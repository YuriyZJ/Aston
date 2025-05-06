package Stage2_070425_060625.Homework4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime createdData;
}
