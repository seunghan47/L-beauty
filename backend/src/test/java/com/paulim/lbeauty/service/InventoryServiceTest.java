package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.InventoryRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    private static List<Inventory> mockInventoryList;

    @BeforeEach
    void setUp() {
        mockInventoryList = List.of(
                new Inventory("111111", "item1", "1.99"),
                new Inventory("222222", "item2", "2.99"),
                new Inventory("333333", "item3", "3.99"),
                new Inventory("444444", "tier3", "4.99")
        );
    }

    @Test
    void testGettingAllItems() {
        when(inventoryRepository.findAll()).thenReturn(mockInventoryList);

        List<Inventory> result = inventoryService.getAllItems();

        assertEquals(mockInventoryList.size(), result.size(), "Expected inventory list size to match");
        assertEquals(mockInventoryList, result, "Expected inventory list to match mock data");

        verify(inventoryRepository, times(1)).findAll();
    }
    @Test
    void findByNameIgnoreCase_shouldReturnMatchingInventory() {
        String query = "item";
        when(inventoryRepository.findByNameContainingIgnoreCase(query)).thenReturn(
                mockInventoryList.stream()
                        .filter(item -> item.getName().toLowerCase().contains(query))
                        .toList()
        );

        List<Inventory> result = inventoryService.findByNameContainingIgnoreCase(query);

        assertNotNull(result, "Returned list should not be null");
        assertFalse(result.isEmpty(), "Expected at least one result");
        assertEquals(3, result.size(), "Expected only 2 matching items");

        verify(inventoryRepository, times(1)).findByNameContainingIgnoreCase(query);
    }

    @Test
    void findFilteredAndPaginatedByCategory_ShouldReturnFilteredResults() {
        String category = "electronics";
        String brand = "apple";
        Double priceBelow = 1000.0;
        int page = 0;
        int size = 2;

        Pageable pageable = PageRequest.of(page, size);
        List<Inventory> filteredItems = List.of(
                new Inventory("555555", "Super nice hair", "999.99", category, brand, 5.0),
                new Inventory("666666", "Super cool wig", "899.99", category, brand, 5.0)
        );
        Page<Inventory> mockPage = new PageImpl<>(filteredItems, pageable, filteredItems.size());

        when(inventoryRepository.findByCategoryAndPriceLessThanAndBrand(category, priceBelow, brand, pageable))
                .thenReturn(mockPage);

        Page<Inventory> result = inventoryService.findFilteredAndPaginatedByCategory(category, page, size, priceBelow, brand);

        assertNotNull(result, "Returned page should not be null");
        assertEquals(2, result.getTotalElements(), "Expected 2 matching items");
        assertEquals(filteredItems, result.getContent(), "Expected filtered inventory list");

        verify(inventoryRepository, times(1))
                .findByCategoryAndPriceLessThanAndBrand(category, priceBelow, brand, pageable);
    }

    @Test
    void findFilteredAndPaginatedByCategory_OnlyPrice_ShouldReturnFilteredResults() {
        String category = "electronics";
        Double priceBelow = 1000.0;
        int page = 0;
        int size = 2;

        Pageable pageable = PageRequest.of(page, size);
        List<Inventory> filteredItems = List.of(
                new Inventory("777777", "Budget Hair", "899.99", category, "Generic", 4.5)
        );
        Page<Inventory> mockPage = new PageImpl<>(filteredItems, pageable, filteredItems.size());

        when(inventoryRepository.findByCategoryAndPriceLessThan(category, priceBelow, pageable))
                .thenReturn(mockPage);

        Page<Inventory> result = inventoryService.findFilteredAndPaginatedByCategory(category, page, size, priceBelow, null);

        assertNotNull(result, "Returned page should not be null");
        assertEquals(1, result.getTotalElements(), "Expected only 1 matching item");
        assertEquals(filteredItems, result.getContent(), "Expected filtered inventory list");

        verify(inventoryRepository, times(1))
                .findByCategoryAndPriceLessThan(category, priceBelow, pageable);
    }

    @Test
    void findFilteredAndPaginatedByCategory_OnlyBrand_ShouldReturnFilteredResults() {
        String category = "electronics";
        String brand = "loreal";
        int page = 0;
        int size = 2;

        Pageable pageable = PageRequest.of(page, size);
        List<Inventory> filteredItems = List.of(
                new Inventory("888888", "Luxury Conditioner", "19.99", category, brand, 4.8)
        );
        Page<Inventory> mockPage = new PageImpl<>(filteredItems, pageable, filteredItems.size());

        when(inventoryRepository.findByCategoryAndBrand(category, brand, pageable))
                .thenReturn(mockPage);

        Page<Inventory> result = inventoryService.findFilteredAndPaginatedByCategory(category, page, size, null, brand);

        assertNotNull(result, "Returned page should not be null");
        assertEquals(1, result.getTotalElements(), "Expected only 1 matching item");
        assertEquals(filteredItems, result.getContent(), "Expected filtered inventory list");

        verify(inventoryRepository, times(1))
                .findByCategoryAndBrand(category, brand, pageable);
    }

    @Test
    void findFilteredAndPaginatedByCategory_NoFilters_ShouldReturnAllInCategory() {
        String category = "electronics";
        int page = 0;
        int size = 2;

        Pageable pageable = PageRequest.of(page, size);
        Page<Inventory> mockPage = new PageImpl<>(mockInventoryList, pageable, mockInventoryList.size());

        when(inventoryRepository.findByCategory(category, pageable))
                .thenReturn(mockPage);

        Page<Inventory> result = inventoryService.findFilteredAndPaginatedByCategory(category, page, size, null, null);

        assertNotNull(result, "Returned page should not be null");
        assertEquals(mockInventoryList.size(), result.getTotalElements(), "Expected all items in category");
        assertEquals(mockInventoryList, result.getContent(), "Expected entire category inventory");

        verify(inventoryRepository, times(1))
                .findByCategory(category, pageable);
    }

    @Test
    void findPaginatedByCategory_ShouldReturnPagedResults() {
        // Given
        String category = "electronics";
        int page = 0;
        int size = 2;
        Pageable pageable = PageRequest.of(page, size);

        List<Inventory> inventoryList = List.of(
                new Inventory("999999", "qqq braiding", "599.99", category, "hair", 4.6),
                new Inventory("101010", "x3 track hair", "999.99", category, "hair", 4.7)
        );
        Page<Inventory> mockPage = new PageImpl<>(inventoryList, pageable, inventoryList.size());

        when(inventoryRepository.findByCategory(category, pageable)).thenReturn(mockPage);

        Page<Inventory> result = inventoryService.findPaginatedByCategory(category, page, size, null, null);

        assertNotNull(result, "Returned page should not be null");
        assertEquals(2, result.getTotalElements(), "Expected 2 items in paginated results");
        assertEquals(inventoryList, result.getContent(), "Expected list of inventory items");

        verify(inventoryRepository, times(1)).findByCategory(category, pageable);
    }





}