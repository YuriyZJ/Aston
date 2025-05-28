package Stage2_070425_060625.Homework6;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//второй вариант реализации Swagger
/*@OpenAPIDefinition(
        // указывает, на каком сервере (или базовом URL) работает это API
        servers = @Server(url = "http://localhost:8080"),

        //секция метаинформации об API
        info = @Info(
                title = "Task6_way2")
)*/

@SpringBootApplication // Это значит: “Я — главный класс приложения, запусти всё автоматически”. Главная аннотация, которая включает сразу 3 другие: @Configuration, @EnableAutoConfiguration, @ComponentScan.
public class Application { // Этот класс запускает всё приложение. Он содержит аннотацию @SpringBootApplication, а значит: 1. включает автоконфигурацию; 2. включает сканирование компонентов (@ComponentScan); 3. является точкой входа в Spring Boot-приложение.
    public static void main(String[] args) { // точка входа
        SpringApplication.run(Application.class, args); // Запускает Spring Boot, поднимает встроенный веб-сервер (обычно Tomcat), сканирует классы и инициализирует приложение.
    }
}
