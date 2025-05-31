package Stage2_070425_060625.Homework6.test.java.Stage2_070425_060625;



import Stage2_070425_060625.Homework6.Application;
import Stage2_070425_060625.Homework6.dto.UserRequestDto;
import Stage2_070425_060625.Homework6.dto.UserResponseDto;
import Stage2_070425_060625.Homework6.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Application.class) //Запускает полное Spring Boot приложение (всю инфраструктуру), как при реальном запуске. Нужен, чтобы все бины (UserController, UserService, MockMvc, и т.п.) были доступны в тесте. Если не указать класс (при множества классов с @Configuration), то спринг не сможет собрать нужный контекст и тест не запустится или запустится не с теми бинами.
@AutoConfigureMockMvc //Автоматически настраивает MockMvc — класс, позволяющий эмулировать HTTP-запросы к контроллерам. Чтобы можно было писать mockMvc.perform(...) и тестировать REST API без запуска сервера.
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc; // Инжектит MockMvc — основной инструмент для HTTP-запросов в контроллеры во время тестов. Именно для контроллектов нужен!!!

    private final ObjectMapper objectMapper = new ObjectMapper(); // Преобразует объекты Java ⇄ JSON (writeValueAsString, readValue и т.д.).

    @MockBean
    private UserService userService; //Создаёт мок-объект UserService и подставляет его вместо настоящего в ApplicationContext.

    @Test // Тест метода GET /api/users. Проверяет, что контроллер корректно возвращает список пользователей.
    void shouldGetAllUsers() throws Exception {
        List<UserResponseDto> users = List.of( //Создаём тестовые данные — искусственный список пользователей, который UserService должен вернуть.
                new UserResponseDto(1, "Alice", "alice@example.com", 30, LocalDateTime.now()),
                new UserResponseDto(2, "Bob", "bob@example.com", 40, LocalDateTime.now())
        );

        Mockito.when(userService.listAllUsers()).thenReturn(users); // Мокаем поведение сервиса. Говорим: “Если контроллер вызовет userService.listAllUsers(), верни наш список users.” Это делается, чтобы протестировать только контроллер, без настоящей логики userService.

        mockMvc.perform(get("/api/users")) // Отправляем GET-запрос на /api/users. Это эквивалентно вызову в Postman: GET http://localhost:8080/api/users.
                //Проверяем, что ответ сервера:
                .andExpect(status().isOk()) //HTTP статус 200 OK
                .andExpect(jsonPath("$.size()", is(2))) //JSON-массив содержит 2 элемента
                .andExpect(jsonPath("$[0].name", is("Alice"))) //У первого объекта в списке поле name = "Alice"
                .andExpect(jsonPath("$[1].email", is("bob@example.com"))); //У второго объекта в списке поле email = "bob@example.com"
    }

    @Test  //Тест метода POST-запрос /api/users. Проверяет, что контроллер корректно создает нового пользователя.
    void shouldCreateUser() throws Exception {
        UserRequestDto request = new UserRequestDto("Charlie", "charlie@example.com", 35); //Создаём объект-запрос: данные, которые отправим в теле запроса. Это то, что обычно приходит от клиента в JSON
        UserResponseDto response = new UserResponseDto(3, "Charlie", "charlie@example.com", 30, LocalDateTime.now()); //Создаём объект-ответ — то, что должен вернуть контроллер после успешного создания: 30 — возможно, ошибка (в запросе age = 35);

        Mockito.when(userService.addUser(any(UserRequestDto.class))).thenReturn(response); // addUser(...) — это метод, который вызывается внутри контроллера. any(UserRequestDto.class) — это специальный матчeр от Mockito, который говорит: «Мне неважно, какой конкретно объект UserRequestDto ты туда передашь — возвращай response в любом случае».

        mockMvc.perform(post("/api/users") //симулируем HTTP POST
                        .contentType(MediaType.APPLICATION_JSON) //указываем формат тела запроса, Это предопределённая константа из пакета org.springframework.http.MediaType, То есть формат тела HTTP-запроса или ответа — это JSON.
                        .content(objectMapper.writeValueAsString(request))) //сериализуем DTO в JSON и отправляем
                .andExpect(status().isCreated()) //Ожидаем статус 201 Created
                .andExpect(jsonPath("$.id", is(3))) //Убедиться, что возвращённый JSON содержит id = 3
                .andExpect(jsonPath("$.name", is("Charlie"))); //Убедиться, что name = Charlie
    }


    @Test
    void shouldUpdateUser() throws Exception {
        UserRequestDto request = new UserRequestDto("UpdatedName", "updated@example.com",30);
        UserResponseDto response = new UserResponseDto(1, "UpdatedName", "updated@example.com", 30, LocalDateTime.now());

        Mockito.when(userService.updateUser(eq(1), any(UserRequestDto.class))).thenReturn(response);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("UpdatedName")))
                .andExpect(jsonPath("$.email", is("updated@example.com")));
    }

    @Test //Тест удаления пользователя (DELETE /api/users/{id})
    void shouldDeleteUser() throws Exception { //Тестирует удаление пользователя по ID. Метод DELETE.
        mockMvc.perform(delete("/api/users/1")) //Эмулируем HTTP DELETE запрос на удаление пользователя с id = 1.
                .andExpect(status().isNoContent()); //Проверка: контроллер возвращает HTTP 204 No Content, то есть: 1.Удаление прошло успешно 2.В теле ответа ничего нет
    }
}
