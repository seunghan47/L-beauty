package com.paulim.lbeauty.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<InventoryResponseDTO>> search(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) BigDecimal maxPrice) {

        List<InventoryResponseDTO> results = inventoryService.searchInventory(category, brand, maxPrice);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/all")
    public List<InventoryResponseDTO> getAll() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/query")
    public ResponseEntity<List<InventoryResponseDTO>> searchItems(@RequestParam String term) {
        List<InventoryResponseDTO> inventory = inventoryService.findByNameContainingIgnoreCase(term);

        if (inventory.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inventory);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build(); // 204 No Content is standard for successful deletes
    }
}