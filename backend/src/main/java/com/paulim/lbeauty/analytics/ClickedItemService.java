package com.paulim.lbeauty.analytics;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<ClickedItemResponse> getAll() {
        return clickedItemsRepository.findAll()
                .stream()
                .map(item -> new ClickedItemResponse(
                        item.getId(),
                        item.getName(),
                        item.getUpc(),
                        item.getCreatedAt(),
                        item.getDate()
                ))
                .toList();
    }

}
