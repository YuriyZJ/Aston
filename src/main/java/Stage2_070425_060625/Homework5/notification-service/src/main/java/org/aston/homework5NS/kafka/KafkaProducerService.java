package org.aston.homework5NS.kafka;

import homework5.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, EmailEvent> kafkaTemplate;
    private static final String TOPIC = "user-events";

    public void sendEmailEvent(EmailEvent emailEvent) {
        kafkaTemplate.send(TOPIC, emailEvent);
    }
}
