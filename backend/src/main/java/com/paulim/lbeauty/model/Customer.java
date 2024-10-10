package com.paulim.lbeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public Customer() {

    }

    public Customer(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
