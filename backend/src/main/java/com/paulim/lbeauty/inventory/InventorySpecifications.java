package com.paulim.lbeauty.inventory;

import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;

public class InventorySpecifications {

    public static Specification<Inventory> hasCategory(String category) {
        return (root, query, cb) ->
                (category == null || category.isEmpty()) ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<Inventory> hasBrand(String brand) {
        return (root, query, cb) ->
                (brand == null || brand.isEmpty()) ? null : cb.equal(root.get("brand"), brand);
    }

    public static Specification<Inventory> priceLessThan(BigDecimal price) {
        return (root, query, cb) ->
                price == null ? null : cb.lessThanOrEqualTo(root.get("price"), price);
    }
}