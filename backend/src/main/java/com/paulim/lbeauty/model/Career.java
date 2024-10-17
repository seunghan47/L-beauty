package com.paulim.lbeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "career")
@Getter
@Setter
public class Career {
    @Id
    private long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String message;

    public Career() {
    }

    public Career(String name, String email, String phone, String address, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.message = message;
    }
}
