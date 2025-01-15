package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CollectionsControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private CollectionsController collectionsController;

    @Test
    void collectionItems() {

    }
}