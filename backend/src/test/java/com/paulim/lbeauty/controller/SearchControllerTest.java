package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService InventoryService;

    @InjectMocks
    private SearchController SearchController;
    @Autowired
    private InventoryService inventoryService;

    @Test
    void testGetAll_Success() throws Exception{
        List<Inventory> mockInventory = List.of(new Inventory("123", "Item1", "987"), new Inventory("456", "Item2", "654"));
        Mockito.when(inventoryService.getAllItems()).thenReturn(mockInventory);

    }

    @Test
    void testing() {
    }

    @Test
    void searchItems() {
    }
}