package org.aston.homework5NS.kafka;

import homework5.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.aston.homework5NS.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;

    @KafkaListener(topics = "user-events", groupId = "email-group")
    public void consume(EmailEvent event) {
        String subject = "Уведомление от сайта";
        String body;

        if ("CREATE".equals(event.getOperation())) {
            body = "Здравствуйте! Ваш аккаунт на сайте был успешно создан.";
        } else if ("DELETE".equals(event.getOperation())) {
            body = "Здравствуйте! Ваш аккаунт был удалён.";
        } else {
            body = "Неизвестная операция";
        }

        emailService.sendEmail(event.getEmail(), subject, body);
    }
}
