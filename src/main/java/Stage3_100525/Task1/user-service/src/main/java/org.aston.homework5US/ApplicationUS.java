package org.aston.homework5US;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApplicationUS {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationUS.class, args);
    }
}