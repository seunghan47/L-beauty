package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.ClickedItems;
import com.paulim.lbeauty.repository.ClickedItemsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClickedItemsServiceTest {

    @Mock
    ClickedItemsRepository clickedItemsRepository;

    @InjectMocks
    ClickedItemsService clickedItemsService;

    @Test
    void savedItemSuccess() {
        LocalDate today = LocalDate.now();
        ClickedItems item = new ClickedItems("item1", "123456", today);
        clickedItemsService.save(item);
        verify(clickedItemsRepository).save(item);

    }
}
