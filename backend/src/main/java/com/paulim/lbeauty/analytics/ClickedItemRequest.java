package com.paulim.lbeauty.analytics;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClickedItemRequest {

    @NotBlank(message = "Item name is required")
    private String name;

    @NotBlank(message = "UPC is required")
    @Size(min = 1, max = 13, message = "UPC must be 12 or 13 digits")
    private String upc;


}