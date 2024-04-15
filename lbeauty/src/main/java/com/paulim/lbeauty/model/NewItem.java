package com.paulim.lbeauty.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class NewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    private MultipartFile file;
    private String company;
    private String date;

    public NewItem() {

    }

    public NewItem(String name, String company, String date) {
        this.name = name;
//        this.file = file;
        this.company = company;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NewItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
