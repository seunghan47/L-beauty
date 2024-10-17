package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductsServiceImpl productsService;

    @PostMapping("/addAll")
    public ResponseEntity<String> putAll(){
        productsService.saveTsql();
        return ResponseEntity.ok("Product added successfully");
    }
}
