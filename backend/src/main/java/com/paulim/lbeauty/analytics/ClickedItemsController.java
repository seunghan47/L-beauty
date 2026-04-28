package com.paulim.lbeauty.analytics;

import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<ClickedItem> trackClick(@Valid @RequestBody ClickedItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clickedItemsService.save(request));
    }

}
