package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Item;
import com.paulim.lbeauty.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    public ItemRepository itemRepository;


    @Override
    public Item getItemByName(String name) {
        return null;
    }

    @Override
    public double getPriceByName(String name) {
        return 1.0;
    }
}
