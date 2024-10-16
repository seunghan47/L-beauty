package com.paulim.lbeauty.repository;

import com.paulim.lbeauty.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
