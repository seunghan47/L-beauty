package com.paulim.lbeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;
    private String customerName;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;

    public Orders() {
        // Default constructor
    }

    public Orders(String customerName, LocalDateTime orderDate, Double totalAmount, String status) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters

}
