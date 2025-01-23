package com.paulim.lbeauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }



    public void sendEmail(String toEmail, String subject, String body) {

        if (toEmail == null || toEmail.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paulslim47@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail sent successfully...");
    }
}
