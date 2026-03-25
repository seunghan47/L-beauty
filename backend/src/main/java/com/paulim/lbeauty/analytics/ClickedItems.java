package com.paulim.lbeauty.analytics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class ClickedItems {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Item name is required")
    private String name;

    @NotBlank(message = "UPC is required")
    @Size(min = 12, max = 13, message = "UPC must be 12 or 13 digits")
    private String upc;

    @NotNull(message = "Date is required")
    private LocalDate date;
    public ClickedItems() {
    }

    public ClickedItems(String name, String upc, LocalDate date) {
        this.name = name;
        this.upc = upc;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
