package Stage2_070425_060625.Homework5.userService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Это значит: “Я — главный класс приложения, запусти всё автоматически”. Главная аннотация, которая включает сразу 3 другие: @Configuration, @EnableAutoConfiguration, @ComponentScan.
public class Application { // Этот класс запускает всё приложение. Он содержит аннотацию @SpringBootApplication, а значит: 1. включает автоконфигурацию; 2. включает сканирование компонентов (@ComponentScan); 3. является точкой входа в Spring Boot-приложение.
    public static void main(String[] args) { // точка входа
        SpringApplication.run(Application.class, args); // Запускает Spring Boot, поднимает встроенный веб-сервер (обычно Tomcat), сканирует классы и инициализирует приложение.
    }
}
