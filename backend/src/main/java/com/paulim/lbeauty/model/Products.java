package com.paulim.lbeauty.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String price;
    private String upc;


    public Products() {
    }

    public Products(String name, String price, String upc) {
        this.name = name;
        this.price = price;
        this.upc = upc;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + price +
                '}';
    }
}
