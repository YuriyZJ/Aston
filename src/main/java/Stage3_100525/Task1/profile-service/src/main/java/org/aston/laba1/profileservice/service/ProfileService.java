package org.aston.laba1.profileservice.service;

import lombok.RequiredArgsConstructor;

import org.aston.homework5DK.homework5.dto.UserRequestDto;
import org.aston.homework5DK.homework5.dto.UserResponseDto;
import org.aston.laba1.profileservice.client.UserClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserClient userClient;

    public List<UserResponseDto> getUsers() {
        return userClient.getAllUsers();
    }

    public UserResponseDto registerUser(UserRequestDto userRequestDto){
        return userClient.createUser(userRequestDto);
    }

    public void removeUser(Integer id){
        userClient.deleteUser(id);
    }
}
