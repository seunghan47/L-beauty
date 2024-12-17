package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    /**
     * retrieve all inventory items
     * @return everything from the store in a list
     */
    @GetMapping("/all")
    public List<Inventory> getAll() {
        return inventoryService.getAllItems();
    }

    /**
     * testing to ensure api is reachable
     * @return simple string
     */
    @GetMapping("/testing")
    public String testing() {
        return "GET successful!!";
    }

    /**
     * search for inventory item case-insensitive
     * @param term the search to look for inventory item
     * @return list of matching inventory
     */
    @GetMapping("/query")
    public ResponseEntity<List<Inventory>> searchItems(@RequestParam String term) {
        List<Inventory> inventory = inventoryService.findByNameContainingIgnoreCase(term);

        if (inventory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(inventory);
        }

        return ResponseEntity.ok(inventory);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" unexpected error has occurred " + ex.getMessage());
    }
}
