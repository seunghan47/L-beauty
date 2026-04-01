package com.paulim.lbeauty.inventory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Auto-generated database ID")
    private long id;

    @Schema(example = "880123456789", description = "The 12 or 13 digit barcode/UPC")
    private String UPC;

    @Schema(example = "Silk Therapy Shampoo")
    private String name;

    @Schema(example = "15.99")
    private String price;

    @Schema(example = "Shampoo")
    private String category;

    @Schema(example = "BioSilk")
    private String brand;

    @Schema(example = "4.5")
    private double rating;

    // 1. Required No-Args Constructor for JPA
    public Inventory() {}

    // 2. Found in InventoryControllerTest: 3-arg constructor
    public Inventory(String UPC, String name, String price) {
        this.UPC = UPC;
        this.name = name;
        this.price = price;
    }

    // 3. Found in InventoryServiceTest: 6-arg constructor
    public Inventory(String UPC, String name, String price, String category, String brand, double rating) {
        this.UPC = UPC;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.rating = rating;
    }

    // Explicit Getters and Setters to fix "cannot find symbol: method getName()"
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUPC() { return UPC; }
    public void setUPC(String UPC) { this.UPC = UPC; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}