package Stage2_070425_060625.Homework6.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data //Генерирует getters, setters, toString, equals, hashCode
@NoArgsConstructor // Генерирует пустой конструктор без параметров
@AllArgsConstructor // Генерирует конструктор со всеми полями в порядке их объявления
@FieldDefaults(level = AccessLevel.PRIVATE) // по умолчанию все объявленные поля присваивает private модификатор
@Builder
public class UserResponseDto {
    Integer id;
    String name;
    String email;
    int age;
    LocalDateTime createdData;
}
