package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory getItem(String name) {
        return inventoryRepository.findByName(name);
    }

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }
    public List<Inventory> findByNameContainingIgnoreCase(String name) {
        return inventoryRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Inventory> findByCategory(String category) {
        return inventoryRepository.findByCategory(category);
    }

    public Page<Inventory> findPaginatedByCategory(String category, int page, int size, Double priceBelow , String Brand) {
        return inventoryRepository.findByCategory(category, PageRequest.of(page, size));
    }
}