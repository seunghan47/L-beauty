package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Item;
import com.paulim.lbeauty.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping("/working")
    public String working() {
        return "return working as intended";
    }
//    }
    @GetMapping("/getItemName")
    public String getItemName(String name) {
        return itemService.getItemByName(name).getName();
    }

    @GetMapping("/getItemPrice")
    public double getItemPrice(String name){
        return itemService.getPriceByName(name);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAll() {
        List<Item> allItems = itemService.getAll();
        return ResponseEntity.ok(allItems);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Item> saveItem (@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }
}
