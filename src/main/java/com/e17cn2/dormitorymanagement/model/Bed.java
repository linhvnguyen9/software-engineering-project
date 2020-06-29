package com.e17cn2.dormitorymanagement.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblgiuong")
public class Bed {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "gia")
    private double price;
    
    @Column(name = "ma")
    private String name;
    
    @Column(name = "moTa")
    private String description;
    
    @Column(name = "loai")
    private String type;
    
    @Column(name = "tblPhongid")
    private int phongId;

    public Bed() {
    }

    public Bed(int id, double price, String name, String description, String type, int phongId) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
        this.phongId = phongId;
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

    public int getPhongId() {
        return phongId;
    }
    
    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
