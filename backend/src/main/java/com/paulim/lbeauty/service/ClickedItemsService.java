package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.ClickedItems;
import com.paulim.lbeauty.repository.ClickedItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ClickedItemsService {

    @Autowired
    ClickedItemsRepository clickedItemsRepository;

    public ClickedItems save(ClickedItems clickedItems) {

        return clickedItemsRepository.save(clickedItems);
    }

}
