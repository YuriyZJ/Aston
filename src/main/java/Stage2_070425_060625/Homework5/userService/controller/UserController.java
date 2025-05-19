package Stage2_070425_060625.Homework5.userService.controller;


import Stage2_070425_060625.Homework5.userService.dto.UserRequestDto;
import Stage2_070425_060625.Homework5.userService.dto.UserResponseDto;
import Stage2_070425_060625.Homework5.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor //Автоматически генерирует конструктор для всех final полей
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> listAllUsers(){
        return userService.listAllUsers();
    }

    @PostMapping //обрабатывает POST-запрос по пути /users (если класс аннотирован @RequestMapping("/users") или аналогично).
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequestDto)); //Управляем статусом ответа (status(HttpStatus.CREATED))
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); //возвращает 204 No Content, что правильно по REST-стандартам при удалении.
    }
}
