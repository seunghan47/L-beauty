package com.paulim.lbeauty.inventory;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class InventoryCsvRecord {
    @CsvBindByName(column = "UPC")
    private String upc;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Price")
    private String price;
}