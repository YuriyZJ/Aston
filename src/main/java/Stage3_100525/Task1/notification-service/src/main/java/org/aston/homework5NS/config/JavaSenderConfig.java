package org.aston.homework5NS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaSenderConfig {
    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");

        sender.setPassword("password");
        sender.setUsername("username");
        sender.setJavaMailProperties(props);
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);

        return sender;
    }
}
