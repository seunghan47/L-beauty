package com.paulim.lbeauty.analytics;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clicked_items")
public class ClickedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Item name is required")
    private String name;

    @NotBlank(message = "UPC is required")
    @Size(min = 12, max = 13, message = "UPC must be 12 or 13 digits")
    private String upc;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @NotNull(message = "Date is required")
    private LocalDate date;

    public ClickedItem() {
    }

    public ClickedItem(String name, String upc, LocalDate date) {
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
