package com.paulim.lbeauty.inventory;

import java.math.BigDecimal;

public record InventoryResponseDTO(
        Long id,
        String upc,
        String name,
        BigDecimal price,
        String category,
        String brand,
        double rating
) {}
