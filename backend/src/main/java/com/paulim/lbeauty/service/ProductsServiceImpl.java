package com.paulim.lbeauty.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.model.Products;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    public void saveTsql(String filePath) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))){

            } catch (Exception e){
                e.printStackTrace();
            }

    }
}
