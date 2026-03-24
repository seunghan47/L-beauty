package com.paulim.lbeauty.analytics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clicked")
public class ClickedItemsController {
    private final ClickedItemsService clickedItemsService;

    ClickedItemsController(ClickedItemsService clickedItemsService) {
        this.clickedItemsService = clickedItemsService;
    }

    @PostMapping("/clicked")
    public ResponseEntity<ClickedItems> saveItem(@RequestBody ClickedItems clickedItems){

        ClickedItems saved = clickedItemsService.save(clickedItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
