package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    protected Inventory getItem(String name) {
        return inventoryRepository.findByName(name);
    }

    public List<Inventory> getAllItems(){
        return inventoryRepository.findAll();
    }

    @Transactional
    public void updateFromCSV(String csvFilePath) throws IOException {
        try {
            Reader reader =
        }
    }

}
