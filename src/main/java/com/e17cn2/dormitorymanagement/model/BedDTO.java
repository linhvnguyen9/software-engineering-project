package com.e17cn2.dormitorymanagement.model;

public class BedDTO {
    private int id;
    private double price;
    private String description;
    private String type;

    public BedDTO() {
    }

    public BedDTO(int id, double price, String description, String type) {
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
