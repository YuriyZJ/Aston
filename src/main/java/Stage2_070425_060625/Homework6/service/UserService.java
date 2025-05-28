package Stage2_070425_060625.Homework6.service;


import Stage2_070425_060625.Homework6.controller.UserController;
import Stage2_070425_060625.Homework6.dto.UserRequestDto;
import Stage2_070425_060625.Homework6.dto.UserResponseDto;
import Stage2_070425_060625.Homework6.entity.User;
import Stage2_070425_060625.Homework6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User(null,
                userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.getAge(),
                LocalDateTime.now());
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
        userRepository.deleteById(id);
    }

    // Метод преобразует сущность User в UserResponseDto, чтобы отправить клиенту только нужные поля.
    //Преобразует сущность User в DTO-объект для отправки клиенту.
    //Добавляет навигационные ссылки по принципу HATEOAS — клиент может видеть, какие действия разрешены.
    private UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                user.getCreatedDate()
        );

        userResponseDto.add(linkTo(methodOn(UserController.class).listAllUsers()).withRel("all_users")); //linkTo(...) — строит ссылку на метод контроллера, methodOn(...).listAllUsers() — имитирует вызов метода listAllUsers(), чтобы HATEOAS смог узнать путь.  withRel("all_users") — добавляет ссылку под названием "all_users" (relationship name). И метод добавляет гиперссылку: "_links": { "all_users": { "href": "http://localhost:8080/api/users" } }
        userResponseDto.add(linkTo(methodOn(UserController.class).addUser(null)).withRel("add_user")); //null здесь передаётся просто как заглушка — methodOn не вызывает реальный метод, а анализирует сигнатуру.
        userResponseDto.add(linkTo(methodOn(UserController.class).updateUser(user.getId(), null)).withRel("update_user"));
        userResponseDto.add(linkTo(methodOn(UserController.class).deleteUser(user.getId())).withRel("delete_user"));

        return userResponseDto; //Возвращается DTO с встроенными ссылками _links.
    }
}
