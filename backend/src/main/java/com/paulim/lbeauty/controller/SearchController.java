package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("Search")
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
    public List<Inventory> searchItems(@RequestParam String term) {
        return inventoryService.findByNameContainingIgnoreCase(term);
    }
}
