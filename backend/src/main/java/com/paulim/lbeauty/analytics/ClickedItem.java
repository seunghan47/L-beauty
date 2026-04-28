package com.paulim.lbeauty.analytics;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clicked_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClickedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String upc;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDate date;

}
