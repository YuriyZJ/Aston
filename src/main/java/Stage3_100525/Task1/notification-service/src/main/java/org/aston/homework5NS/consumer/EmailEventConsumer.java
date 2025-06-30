package org.aston.homework5NS.consumer;

import lombok.RequiredArgsConstructor;
import org.aston.homework5DK.homework5.EmailEvent;
import org.aston.homework5NS.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailEventConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "user-events", groupId = "notification-group")
    public void listen(EmailEvent event) {
        emailService.sendEmail(null, event.getEmail(), "Уведомление от системы", "Событие: " + event.getOperation());
    }
}
