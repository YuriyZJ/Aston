package org.aston.laba1.profileservice.client;

import org.aston.homework5DK.homework5.dto.UserRequestDto;
import org.aston.homework5DK.homework5.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/api/users")
    List<UserResponseDto> getAllUsers();

    @PostMapping("/api/users")
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto);

    @DeleteMapping("/api/user/{id}")
    void deleteUser(@PathVariable("id") Integer id);
}
