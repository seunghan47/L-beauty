package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/all")
    public List<Inventory> getAll() {
        return inventoryService.getAllItems();
    }
    @GetMapping("/testing")
    public String testing() {
        return "GET successful!!";
    }

    @GetMapping("/query")
    public ResponseEntity<List<Inventory>> searchItems(@RequestParam String term) {
        List<Inventory> inventory = inventoryService.findByNameContainingIgnoreCase(term);
        return ResponseEntity.ok(inventory);
    }
}
