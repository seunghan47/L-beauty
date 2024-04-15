package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.NewItem;
import com.paulim.lbeauty.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewItemServiceImpl implements NewItemService{

    @Autowired
    NewItemRepository newItemRepository;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public NewItem saveNewItem(NewItem item) {
        return newItemRepository.save(item);
    }

    @Override
    public List<NewItem> getAll() {
        return newItemRepository.findAll();
    }

    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paulslim47@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail sent successfully...");
    }
}
