package Stage2_070425_060625.Homework6.controller;


import Stage2_070425_060625.Homework6.dto.UserRequestDto;
import Stage2_070425_060625.Homework6.dto.UserResponseDto;
import Stage2_070425_060625.Homework6.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor //Автоматически генерирует конструктор для всех final полей
public class UserController {
    private final UserService userService;

    @Operation( //Описывает конкретный HTTP-метод (операцию)
            summary = "Get list all users",
            description = "Call method from userService"
    )
    @GetMapping
    public List<UserResponseDto> listAllUsers(){
        return userService.listAllUsers();
    }

    @Operation(
            summary = "Add new user from list",
            description = "Call method from userService"
    )
    @PostMapping //обрабатывает POST-запрос по пути /users (если класс аннотирован @RequestMapping("/users") или аналогично).
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequestDto)); //Управляем статусом ответа (status(HttpStatus.CREATED))
    }


    @Operation(
            summary = "Update user from list",
            description = "Call method from userService"
    )
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    @Operation(
            summary = "Delete user from list",
            description = "Call method from userService"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); //возвращает 204 No Content, что правильно по REST-стандартам при удалении.
    }
}
