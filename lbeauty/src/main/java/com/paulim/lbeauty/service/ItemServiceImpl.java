package com.paulim.lbeauty.service;
import com.paulim.lbeauty.model.Item;
import com.paulim.lbeauty.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    public ItemRepository itemRepository;
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
    @Override
    public Item getItemByName(String name) {
        return itemRepository.findByName(name);
    }
    @Override
    public double getPriceByName(String name) {
        return 1.0;
    }
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
