package com.paulim.lbeauty.analytics;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClickedItemService {

    private final ClickedItemRepository clickedItemsRepository;

    public ClickedItemService(ClickedItemRepository clickedItemsRepository) {
        this.clickedItemsRepository = clickedItemsRepository;
    }

    public ClickedItem save(ClickedItemRequest request) {

        ClickedItem entity = new ClickedItem();
        entity.setName(request.getName());
        entity.setUpc(request.getUpc());
        entity.setDate(LocalDate.now());

        return clickedItemsRepository.save(entity);
    }

}
