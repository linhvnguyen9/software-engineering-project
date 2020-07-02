package com.e17cn2.dormitorymanagement.model.entity;

public class Bed {
    private int id;
    private double price;
    private String name;
    private String description;
    private String type;
    private String roomName;
    private int roomId;

    public Bed() {
    }

    public Bed(int id, double price, String name, String description, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Bed(int id, double price, String name, String description, String type, String roomName) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
        this.roomName = roomName;
    }

    public Bed(int id, double price, String name, String description, String type, String roomName, int roomId) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
        this.roomName = roomName;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
