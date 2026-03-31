package com.paulim.lbeauty.inventory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Auto-generated database ID")
    private long id;

    @Schema(example = "880123456789", description = "The 12 or 13 digit barcode/UPC of the product")
    private String UPC;

    @Schema(example = "Silk Therapy Shampoo", description = "The full name of the beauty product")
    private String name;

    @Schema(example = "15.99", description = "Retail price of the item")
    private String price;

    @Schema(example = "Shampoo", description = "Category of the product (e.g. Hair, Skin, Nails)")
    private String category;

    @Schema(example = "In Stock", description = "Current availability status")
    private String status;

    @Schema(example = "https://s3.amazon.com/lbeauty/shampoo.jpg", description = "S3 URL for the product image")
    private String imageUrl;
}