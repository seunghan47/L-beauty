package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.NewItem;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<NewItem>> getAll() {
        List<NewItem> allItems = newItemService.getAll();
        return ResponseEntity.ok(allItems);
    }

    @PostMapping("/save")
    public ResponseEntity<NewItem> saveItem(@RequestBody NewItem newItem) {
        NewItem item = newItemService.saveNewItem(newItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
