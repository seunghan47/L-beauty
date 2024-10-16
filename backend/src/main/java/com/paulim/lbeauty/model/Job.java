package com.paulim.lbeauty.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobId;
    private String email;
    private String name;
    private String phoneNumber;

//    @ElementCollection
    private String location;
    private String message;

    public Job() {
    }

    public Job(String email, String name, String phoneNumber, String location, String message) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.message = message;
    }
}
