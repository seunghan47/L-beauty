package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Item;

import java.util.List;

public interface ItemService {
    Item saveItem(Item item);
    Item getItemByName(String name);
    double getPriceByName(String name);
    List<Item> getAll();
}
