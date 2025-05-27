package Stage2_070425_060625.Homework6.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data //Генерирует getters, setters, toString, equals, hashCode
@NoArgsConstructor // Генерирует пустой конструктор без параметров
@AllArgsConstructor // Генерирует конструктор со всеми полями в порядке их объявления
@FieldDefaults(level = AccessLevel.PRIVATE) // по умолчанию все объявленные поля присваивает private модификатор
public class UserResponseDto extends RepresentationModel<UserResponseDto> {
    Integer id;
    String name;
    String email;
    int age;
    LocalDateTime createdData;
}
