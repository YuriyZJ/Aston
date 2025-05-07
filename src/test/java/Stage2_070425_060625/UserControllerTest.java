package Stage2_070425_060625;


import Stage2_070425_060625.Homework4.Application;
import Stage2_070425_060625.Homework4.dto.UserRequestDto;
import Stage2_070425_060625.Homework4.dto.UserResponseDto;
import Stage2_070425_060625.Homework4.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private UserService userService;

    @Test
    void shouldGetAllUsers() throws Exception {
        List<UserResponseDto> users = Arrays.asList(
                new UserResponseDto(1, "Alice", "alice@example.com", 30, LocalDateTime.now()),
                new UserResponseDto(2, "Bob", "bob@example.com", 40, LocalDateTime.now())
        );

        Mockito.when(userService.listAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Alice")))
                .andExpect(jsonPath("$[1].email", is("bob@example.com")));
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserRequestDto request = new UserRequestDto("Charlie", "charlie@example.com", 35);
        UserResponseDto response = new UserResponseDto(3, "Charlie", "charlie@example.com", 30, LocalDateTime.now());

        Mockito.when(userService.addUser(any(UserRequestDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Charlie")));
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

    @Test
    void shouldDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}
