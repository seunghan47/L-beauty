package com.paulim.lbeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
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
