package org.aston.laba1.profileservice.controller;

import lombok.RequiredArgsConstructor;
import org.aston.homework5DK.homework5.dto.UserRequestDto;
import org.aston.homework5DK.homework5.dto.UserResponseDto;
import org.aston.laba1.profileservice.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return profileService.getUsers();
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return profileService.registerUser(userRequestDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        profileService.removeUser(id);
    }
}
