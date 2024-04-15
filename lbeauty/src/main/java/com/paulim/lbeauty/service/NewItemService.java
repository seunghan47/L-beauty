package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.NewItem;
import com.paulim.lbeauty.repository.ItemRepository;
import com.paulim.lbeauty.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewItemService {
    NewItem saveNewItem(NewItem item);
    List<NewItem> getAll();

}
