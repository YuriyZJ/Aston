package org.aston.homework5NS.service;

import lombok.RequiredArgsConstructor;
import org.aston.homework5NS.entity.EmailLog;
import org.aston.homework5NS.repository.EmailLogRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailLogRepository emailLogRepository;

    public void sendEmail(String to, String subject, String text, String operation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

        EmailLog log = new EmailLog(null, to, operation, LocalDateTime.now());
        emailLogRepository.save(log);
    }
}
