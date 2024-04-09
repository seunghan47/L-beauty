package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Item;
import com.paulim.lbeauty.service.ItemService;
import com.paulim.lbeauty.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    public ItemService itemService;

//    @PostMapping("/add")
//    public ResponseEntity<Item> addItem(@RequestBody Item item){
//        itemServiceImpl.
//    }
    @GetMapping("/getItemName")
    public String getItemName(String name) {
        return itemService.getItemByName(name).getName();
    }

    @GetMapping("/getItemPrice")
    public double getItemPrice(String name){
        return itemService.getPriceByName(name);
    }
}
