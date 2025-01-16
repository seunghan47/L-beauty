package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.ClickedItems;
import com.paulim.lbeauty.service.ClickedItemsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClickedItemsControllerTest {

    @Mock
    ClickedItemsService clickedItemsService;
    @InjectMocks
    ClickedItemsController clickedItemsController;

    @Test
    void saveItem() {
        LocalDate date = LocalDate.now();
        ClickedItems item = new ClickedItems("item1",  "12345", date);
        ClickedItems savedItem = new ClickedItems("item1", "12345", date);



        when(clickedItemsService.save(item)).thenReturn(savedItem);
        ResponseEntity<ClickedItems> response = clickedItemsController.saveItem(item);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(savedItem, response.getBody());


    }
}
