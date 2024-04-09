package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Item;

public interface ItemService {
    Item getItemByName(String name);
    double getPriceByName(String name);
}
