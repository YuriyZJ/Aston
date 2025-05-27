package Stage2_070425_060625.Homework6;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//второй вариант реализации Swagger
@OpenAPIDefinition(
        servers = @Server(url = "http://localhost:8080"),
        info = @Info(
                title = "xz2")
)

@SpringBootApplication // Это значит: “Я — главный класс приложения, запусти всё автоматически”. Главная аннотация, которая включает сразу 3 другие: @Configuration, @EnableAutoConfiguration, @ComponentScan.
public class Application { // Этот класс запускает всё приложение. Он содержит аннотацию @SpringBootApplication, а значит: 1. включает автоконфигурацию; 2. включает сканирование компонентов (@ComponentScan); 3. является точкой входа в Spring Boot-приложение.
    public static void main(String[] args) { // точка входа
        SpringApplication.run(Application.class, args); // Запускает Spring Boot, поднимает встроенный веб-сервер (обычно Tomcat), сканирует классы и инициализирует приложение.
    }
}
