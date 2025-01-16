package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.ClickedItems;
import com.paulim.lbeauty.repository.ClickedItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickedItemsService {

    @Autowired
    ClickedItemsRepository clickedItemsRepository;

    public ClickedItems save(ClickedItems clickedItems) {

        return clickedItemsRepository.save(clickedItems);
    }

}
