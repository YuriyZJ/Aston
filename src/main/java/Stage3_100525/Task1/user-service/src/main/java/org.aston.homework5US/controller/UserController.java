package org.aston.homework5US.controller;


import lombok.RequiredArgsConstructor;
import org.aston.homework5DK.homework5.dto.UserRequestDto;
import org.aston.homework5DK.homework5.dto.UserResponseDto;
import org.aston.homework5US.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> listAllUsers(){
        return userService.listAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequestDto));
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
