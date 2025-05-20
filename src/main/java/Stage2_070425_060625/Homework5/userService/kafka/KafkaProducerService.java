package Stage2_070425_060625.Homework5.userService.kafka;

import Stage2_070425_060625.Homework5.DTOKafka.EmailEvent;
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
