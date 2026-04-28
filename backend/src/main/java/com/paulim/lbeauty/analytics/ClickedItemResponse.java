package com.paulim.lbeauty.analytics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClickedItemResponse {
    private long id;
    private String name;
    private String upc;
    private LocalDateTime createdAt;
    private LocalDate date;
}