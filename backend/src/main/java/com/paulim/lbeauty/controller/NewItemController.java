package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.NewItem;
import com.paulim.lbeauty.service.EmailServiceImpl;
import com.paulim.lbeauty.service.NewItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newItem")
@CrossOrigin("*")
public class NewItemController {
    @Autowired
    NewItemService newItemService;
    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("/health")
    public String health(){
	    return "newItem controller working";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NewItem>> getAll() {
        List<NewItem> allItems = newItemService.getAll();
        return ResponseEntity.ok(allItems);
    }

    @PostMapping("/save")
    public ResponseEntity<NewItem> saveItem(@RequestBody NewItem newItem) {

//        String email = newItem.getEmail();
//        if (email == null || email.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }

        NewItem item = newItemService.saveNewItem(newItem);
        sendConfirmationEmail(newItem.getEmail(), newItem.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    private void sendConfirmationEmail(String toEmail, String message) {

        String subject = "Thank you for your suggestion of " + message;
        String body = "We will see if we can get it and let you know as soon as possible! \n do not reply to this";

        emailService.sendEmail(toEmail, subject, body);
    }
}
