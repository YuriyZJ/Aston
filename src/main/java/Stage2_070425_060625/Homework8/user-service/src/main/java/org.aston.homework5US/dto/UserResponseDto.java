package org.aston.homework5US.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //Генерирует getters, setters, toString, equals, hashCode
@NoArgsConstructor // Генерирует пустой конструктор без параметров
@AllArgsConstructor // Генерирует конструктор со всеми полями в порядке их объявления
public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime createdData;
}
