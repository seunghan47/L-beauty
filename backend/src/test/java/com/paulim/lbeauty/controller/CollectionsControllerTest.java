package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.inventory.CollectionsController;
import com.paulim.lbeauty.inventory.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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