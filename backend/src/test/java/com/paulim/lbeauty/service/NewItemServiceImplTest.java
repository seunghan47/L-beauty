package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.NewItem;
import com.paulim.lbeauty.repository.NewItemRepository;
import org.eclipse.angus.mail.imap.protocol.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewItemServiceImplTest {

    @Mock
    NewItemRepository newItemRepository;

    @InjectMocks
    NewItemServiceImpl newItemService;

    private List<NewItem> newItems;

    @BeforeEach
    void setUp() {
        NewItem newItem = new NewItem("item 1", "company 1", "today", "hello1@gmail.com");
        NewItem newItem2 = new NewItem("item 2", "company 2", "tomorrow", "hello2@gmail.com");
        newItems = Arrays.asList(newItem, newItem2);
    }

    @Test
    void saveNewItem() {
        NewItem newItem = new NewItem("item 1", "company 1", "today", "hello1@gmail.com");

        when(newItemRepository.save(newItem)).thenReturn(newItem);
        NewItem savedItem = newItemService.saveNewItem(newItem);

        assertNotNull(savedItem);

        verify(newItemRepository).save(newItem);
    }

    @Test
    void getAll() {
        when(newItemRepository.findAll()).thenReturn(newItems);

        List<NewItem> items = newItemService.getAll();

        assertNotNull(items);
        assertEquals(items.size(), newItems.size());

        verify(newItemRepository).findAll();
    }
}