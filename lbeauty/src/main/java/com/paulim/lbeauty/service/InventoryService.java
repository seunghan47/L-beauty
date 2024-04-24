package com.paulim.lbeauty.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    protected Inventory getItem(String name) {
        return inventoryRepository.findByName(name);
    }

    public List<Inventory> getAllItems(String filePath){
        List<Inventory> items = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            int start = 0;
            while ((nextRecord = reader.readNext()) != null) {
                if (nextRecord[0].equals("UPC")) continue;
                Inventory item = new Inventory();
                item.setId(start++);
                item.setUPC(nextRecord[0]);
                item.setName(nextRecord[1]);
                item.setPrice(nextRecord[2]);
                items.add(item);
            }
        } catch (IOException error) {
            error.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
