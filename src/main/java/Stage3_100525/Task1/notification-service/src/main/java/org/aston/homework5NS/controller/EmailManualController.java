package org.aston.homework5NS.controller;

import lombok.RequiredArgsConstructor;
import org.aston.homework5NS.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailManualController {

    private final EmailService emailService;

    @PostMapping
    public String sendEmail(@RequestParam String to, @RequestParam String operation) {
        String subject = "Уведомление от сайта";
        String body = "CREATE".equalsIgnoreCase(operation)
                ? "Здравствуйте! Ваш аккаунт на сайте был успешно создан."
                : "Здравствуйте! Ваш аккаунт был удалён.";
        emailService.sendEmail(null, to, subject, body);
        return "Email sent";
    }

    @PostMapping("/send")
    public void sendEmailLog(@RequestParam String to, @RequestParam String operation) {
        emailService.sendEmail(null, to, "Ручное уведомление", "Событие: " + operation);
    }
}