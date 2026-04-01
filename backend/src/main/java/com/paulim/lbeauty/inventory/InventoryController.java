package com.paulim.lbeauty.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/all")
    public List<Inventory> getAll() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/query")
    public ResponseEntity<List<Inventory>> searchItems(@RequestParam String term) {
        List<Inventory> inventory = inventoryService.findByNameContainingIgnoreCase(term);

        if (inventory.isEmpty()) {
            return ResponseEntity.noContent().build(); // Standard REST: 204 No Content if empty
        }

        return ResponseEntity.ok(inventory);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}