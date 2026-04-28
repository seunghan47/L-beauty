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
    public ResponseEntity<ClickedItemResponse> trackClick(@Valid @RequestBody ClickedItemRequest request) {

        ClickedItem saved = clickedItemsService.save(request);

        ClickedItemResponse response = new ClickedItemResponse(
                saved.getId(),
                saved.getName(),
                saved.getUpc(),
                saved.getCreatedAt(),
                saved.getDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
