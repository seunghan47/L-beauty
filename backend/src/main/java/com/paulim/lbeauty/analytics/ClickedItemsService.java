package com.paulim.lbeauty.analytics;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClickedItemsService {

    private final ClickedItemsRepository clickedItemsRepository;

    public ClickedItemsService(ClickedItemsRepository clickedItemsRepository) {
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
