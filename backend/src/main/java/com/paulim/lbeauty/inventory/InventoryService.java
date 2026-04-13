package com.paulim.lbeauty.inventory;

import com.paulim.lbeauty.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal; // Import BigDecimal
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Page<Inventory> findFilteredAndPaginatedByCategory(String category, int page, int size, BigDecimal priceBelow, String brand) {
        PageRequest pageable = PageRequest.of(page, size);

        if (priceBelow != null && brand != null) {
            return inventoryRepository.findByCategoryAndPriceLessThanAndBrand(category, priceBelow, brand, pageable);
        } else if (priceBelow != null) {
            return inventoryRepository.findByCategoryAndPriceLessThan(category, priceBelow, pageable);
        } else if (brand != null) {
            return inventoryRepository.findByCategoryAndBrand(category, brand, pageable);
        } else {
            return inventoryRepository.findByCategory(category, pageable);
        }
    }

    public void deleteItem(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Product with ID " + id + " not found.");
        }
        inventoryRepository.deleteById(id);
    }

    // Add to your existing InventoryService
    public List<InventoryResponseDTO> searchInventory(String category, String brand, BigDecimal maxPrice) {
        Specification<Inventory> spec = Specification.where(InventorySpecifications.hasCategory(category))
                .and(InventorySpecifications.hasBrand(brand))
                .and(InventorySpecifications.priceLessThan(maxPrice));

        return inventoryRepository.findAll(spec)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<InventoryResponseDTO> getAllItems() {
        return inventoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<InventoryResponseDTO> findByNameContainingIgnoreCase(String name) {
        return inventoryRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private InventoryResponseDTO convertToDTO(Inventory inventory) {
        return new InventoryResponseDTO(
                inventory.getId(),
                inventory.getUpc(),
                inventory.getName(),
                inventory.getPrice(),
                inventory.getCategory(),
                inventory.getBrand(),
                inventory.getRating()
        );
    }
}