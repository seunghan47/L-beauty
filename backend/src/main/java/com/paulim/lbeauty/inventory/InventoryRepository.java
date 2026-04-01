package com.paulim.lbeauty.inventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal; // Import BigDecimal
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByName(String name);

    List<Inventory> findByNameContainingIgnoreCase(String name);

    List<Inventory> findByCategory(String category);

    Page<Inventory> findByCategory(String category, Pageable pageable);

    Page<Inventory> findByCategoryAndPriceLessThan(String category, BigDecimal priceBelow, Pageable pageable);

    Page<Inventory> findByCategoryAndBrand(String category, String brand, Pageable pageable);

    Page<Inventory> findByCategoryAndPriceLessThanAndBrand(String category, BigDecimal priceBelow, String brand, Pageable pageable);
}