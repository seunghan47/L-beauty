package com.paulim.lbeauty.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplTest {

    @InjectMocks
    private EmailServiceImpl emailService;

    @Mock
    private JavaMailSender mailSender;

    @Test
    void sendEmail_shouldSendEmailSuccessfully() {
        String toEmail = "test@example.com";
        String subject = "Test Subject";
        String body = "Test Body";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paulslim47@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        emailService.sendEmail(toEmail, subject, body);

        verify(mailSender, times(1)).send(message);
    }

    @Test
    void sendEmail_shouldThrowExceptionWhenEmailIsNull() {
        String toEmail = null;
        String subject = "Test Subject";
        String body = "Test Body";

        assertThrows(IllegalArgumentException.class, () -> emailService.sendEmail(toEmail, subject, body));
    }

    @Test
    void sendEmail_shouldThrowExceptionWhenEmailIsEmpty() {
        String toEmail = "";
        String subject = "Test Subject";
        String body = "Test Body";

        assertThrows(IllegalArgumentException.class, () -> emailService.sendEmail(toEmail, subject, body));
    }
}
