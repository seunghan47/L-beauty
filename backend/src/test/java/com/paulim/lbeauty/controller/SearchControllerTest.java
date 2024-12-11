package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @Mock
    private InventoryService InventoryService;
    @InjectMocks
    private SearchController SearchController;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAll() {
    }

    @Test
    void testing() {
    }

    @Test
    void searchItems() {
    }
}