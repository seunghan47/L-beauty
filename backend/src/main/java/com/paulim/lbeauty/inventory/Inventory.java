package com.paulim.lbeauty.inventory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Auto-generated database ID")
    private Long id; // Changed to Long (wrapper) to allow nulls before save

    @Column(nullable = false, unique = true, length = 20)
    @Schema(example = "880123456789", description = "The 12 or 13 digit barcode/UPC")
    @Size(min = 12, max = 12, message = "UPC must be exactly 12 digits")
    private String upc;

    @Column(nullable = false)
    @Schema(example = "Silk Therapy Shampoo")
    @NotBlank(message = "Product name is required")
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    @Schema(example = "15.99", description = "Price of the item")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    @Schema(example = "Shampoo")
    private String category;

    @Schema(example = "BioSilk")
    private String brand;

    @Schema(example = "4.5")
    private double rating;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;

    // 1. Required No-Args Constructor
    public Inventory() {}

    // 2. Updated 3-arg constructor
    public Inventory(String upc, String name, BigDecimal price) {
        this.upc = upc;
        this.name = name;
        this.price = price;
    }

    // 3. Updated 6-arg constructor
    public Inventory(String upc, String name, BigDecimal price, String category, String brand, double rating) {
        this.upc = upc;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUpc() { return upc; }
    public void setUpc(String upc) { this.upc = upc; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}