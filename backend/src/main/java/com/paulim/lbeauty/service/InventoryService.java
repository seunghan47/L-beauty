package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }
    public List<Inventory> findByNameContainingIgnoreCase(String name) {
        return inventoryRepository.findByNameContainingIgnoreCase(name);
    }

    public Page<Inventory> findPaginatedByCategory(String category, int page, int size, Double priceBelow , String Brand) {
        return inventoryRepository.findByCategory(category, PageRequest.of(page, size));
    }

    public Page<Inventory> findFilteredAndPaginatedByCategory(String category, int page, int size, Double priceBelow , String brand) {
        PageRequest pageable = PageRequest.of(page, size);

        if (priceBelow != null && brand != null) {
            return inventoryRepository.findByCategoryAndPriceLessThanAndBrand(category, priceBelow, brand, pageable);
        } else if (priceBelow != null) {
            return inventoryRepository.findByCategoryAndPriceLessThan(category, priceBelow, pageable);
        } else if (brand != null) {
            return inventoryRepository.findByCategoryAndBrand(category, brand, pageable);
        } else {
            return inventoryRepository.findByCategory(category, pageable);
        }

    }
}