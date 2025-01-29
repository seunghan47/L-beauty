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
                new Inventory("333333", "item3", "3.99")
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
    void findFilteredAndPaginatedByCategory() {


        Page<Inventory> page = inventoryService.findFilteredAndPaginatedByCategory("category", 1, 1, 2.0, "apple");


    }


}