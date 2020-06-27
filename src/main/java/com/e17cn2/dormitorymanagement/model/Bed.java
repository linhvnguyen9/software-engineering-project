package com.e17cn2.dormitorymanagement.model;

import javax.persistence.Table;

@Table(name = "bedTbl")
public class Bed {
    private int id;
    private double price;
    private String description;
    private String type;

    public Bed() {
    }

    public Bed(int id, double price, String description, String type) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
