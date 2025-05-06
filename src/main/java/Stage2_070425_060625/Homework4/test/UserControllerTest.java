package Stage2_070425_060625.Homework4.test;

import Stage2_070425_060625.Homework4.controller.UserController;
import Stage2_070425_060625.Homework4.dto.UserRequestDto;
import Stage2_070425_060625.Homework4.dto.UserResponseDto;
import Stage2_070425_060625.Homework4.server.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.List;

import static javax.swing.UIManager.get;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.web.servlet.function.ServerResponse.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldGetAllUsers() throws Exception {
        List<UserResponseDto> users = List.of(new UserResponseDto(1, "Alice", "a@mail.com", 30, LocalDateTime.now()));
        when(userService.listAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserRequestDto request = new UserRequestDto("Bob", "b@mail.com", 25);
        UserResponseDto response = new UserResponseDto(1, "Bob", "b@mail.com", 25, LocalDateTime.now());
        when(userService.addUser(any())).thenReturn(response);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Bob"));
    }
}
