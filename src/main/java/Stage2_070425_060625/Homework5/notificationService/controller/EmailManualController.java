package Stage2_070425_060625.Homework5.notificationService.controller;

import Stage2_070425_060625.Homework5.notificationService.service.EmailService;
import lombok.RequiredArgsConstructor;
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
        emailService.sendEmail(to, subject, body);
        return "Email sent";
    }
}