package com.paulim.lbeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ClickedItems {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String upc;
    private LocalDate date;

    public ClickedItems() {
    }

    public ClickedItems(String name, String upc, LocalDate date) {
        this.name = name;
        this.upc = upc;
        this.date = date;
    }
}
