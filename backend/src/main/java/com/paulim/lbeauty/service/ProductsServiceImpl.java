package com.paulim.lbeauty.service;

import com.opencsv.CSVReader;
import com.paulim.lbeauty.model.Products;
import com.paulim.lbeauty.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    public void saveTsql() {
        List<Products> products = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(resourceLoader.getResource("classpath:inventory.csv").getInputStream()))){
            String [] nextRecord;
            int start = 0;
            while ((nextRecord = reader.readNext()) != null) {
                if (nextRecord[0].equals("UPC")) continue;
                Products product = new Products();
                product.setId(start++);
                product.setUpc(nextRecord[0]);
                product.setName(nextRecord[1]);
                product.setPrice(nextRecord[2]);
                products.add(product);
            }
            productRepository.saveAll(products);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
