package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Products;

import java.util.List;

public interface ProductsService {
    Products saveProduct(Products product);
    Products getProductById(Long id);
    List<Products> getAllProducts();
    void deleteProductById(Long id);

}
