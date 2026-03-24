package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.inventory.InventoryController;
import com.paulim.lbeauty.inventory.Inventory;
import com.paulim.lbeauty.inventory.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    private List<Inventory> mockList;

    @BeforeEach
    void setUp() {
        mockList = List.of(
                new Inventory("111111", "item1", "1.99"),
                new Inventory("222222", "item2", "2.99"),
                new Inventory("333333", "item3", "3.99")
        );
    }

    @Test
    void gettingAllItems() {
        when(inventoryService.getAllItems()).thenReturn(mockList);
        List<Inventory> result = inventoryController.getAll();

        assertEquals(mockList.size(), result.size(), "Expected inventory list size to match");
        assertEquals(mockList, result, "Expected returned list to match mock data");

        verify(inventoryService).getAllItems();

    }
}