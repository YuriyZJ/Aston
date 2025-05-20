package Stage2_070425_060625.Homework5.userService.service;


import Stage2_070425_060625.Homework5.DTOKafka.EmailEvent;
import Stage2_070425_060625.Homework5.userService.dto.UserRequestDto;
import Stage2_070425_060625.Homework5.userService.dto.UserResponseDto;
import Stage2_070425_060625.Homework5.userService.entity.User;
import Stage2_070425_060625.Homework5.userService.kafka.KafkaProducerService;
import Stage2_070425_060625.Homework5.userService.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducerService kafkaProducerService;

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User(null, userRequestDto.getName(), userRequestDto.getEmail(), userRequestDto.getAge(), LocalDateTime.now());
        User savedUser = userRepository.save(user);

        kafkaProducerService.sendEmailEvent(new EmailEvent(savedUser.getEmail(), "CREATE"));
        return toDto(userRepository.save(user));
    }

    public List<UserResponseDto> listAllUsers() {
        return userRepository.findAll().stream() //Возвращает список всех User из базы и Превращает список в поток (Stream API)
                .map(this::toDto) //Преобразует каждый User в UserResponseDto
                .collect(Collectors.toList()); //Собирает обратно в List<UserResponseDto>
    }

    public UserResponseDto updateUser(Integer id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
                user.setName(userRequestDto.getName());
                user.setAge(userRequestDto.getAge());
                user.setEmail(userRequestDto.getEmail());
                return toDto(userRepository.save(user));
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        kafkaProducerService.sendEmailEvent(new EmailEvent(user.getEmail(), "DELETE"));
        userRepository.deleteById(id);
    }

    // Метод преобразует сущность User в UserResponseDto, чтобы отправить клиенту только нужные поля.
    private UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getCreatedDate());
    }
}
