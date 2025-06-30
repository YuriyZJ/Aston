package org.aston.homework5DK.homework5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime createdData;
}
