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

    private final NewItemRepository newItemRepository;

    @Autowired
    public NewItemServiceImpl(NewItemRepository newItemRepository){
        this.newItemRepository = newItemRepository;
    }

    @Override
    public NewItem saveNewItem(NewItem item) {
        return newItemRepository.save(item);
    }

    @Override
    public List<NewItem> getAll() {
        return newItemRepository.findAll();
    }


}
