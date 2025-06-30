package org.aston.homework5NS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ApplicationNS {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationNS.class, args);
    }
}
