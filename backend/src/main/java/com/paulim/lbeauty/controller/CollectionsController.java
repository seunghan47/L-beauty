package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collections")
@CrossOrigin("*")
public class CollectionsController {

    private final InventoryService inventoryService;

    @Autowired
    public CollectionsController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Inventory>> collectionItems(@PathVariable String category) {
        List<Inventory> collection = inventoryService.findByCategory(category);

        return ResponseEntity.ok(collection);
    }
}
