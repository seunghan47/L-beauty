package com.paulim.lbeauty.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal; // 1. Added Import
import java.util.List;

@RestController
@RequestMapping("/api/collections")
@CrossOrigin("*")
public class CollectionsController {

    private final InventoryService inventoryService;

    @Autowired
    public CollectionsController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/health")
    public String health(){
        return "Collections Controller Working";
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Inventory>> collectionItems(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "24") int size,
            @RequestParam(required = false) BigDecimal priceBelow, // 2. Changed Double to BigDecimal
            @RequestParam(required = false) String brand
    ) {
        // Now this method call matches the new Service signature
        Page<Inventory> collection = inventoryService.findFilteredAndPaginatedByCategory(category, page, size, priceBelow, brand);
        List<Inventory> items = collection.getContent();

        return ResponseEntity.ok(items);
    }
}