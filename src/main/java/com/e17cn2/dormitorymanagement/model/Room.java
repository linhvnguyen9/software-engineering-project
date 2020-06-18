package com.e17cn2.dormitorymanagement.model;

import java.util.ArrayList;

public class Room {
    private int id;
    private String roomType;
    private String roomName;
    private String description;
    private ArrayList<Bed> beds;
    private ElectricityMeter electricityMeter;
    private WaterMeter waterMeter;

    public Room() {

    }

    public Room(int id, String roomType, String roomName, String description, ArrayList<Bed> beds, ElectricityMeter electricityMeter, WaterMeter waterMeter) {
        this.id = id;
        this.roomType = roomType;
        this.roomName = roomName;
        this.description = description;
        this.beds = beds;
        this.electricityMeter = electricityMeter;
        this.waterMeter = waterMeter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Bed> getBeds() {
        return beds;
    }

    public void setBeds(ArrayList<Bed> beds) {
        this.beds = beds;
    }

    public ElectricityMeter getElectricityMeter() {
        return electricityMeter;
    }

    public void setElectricityMeter(ElectricityMeter electricityMeter) {
        this.electricityMeter = electricityMeter;
    }

    public WaterMeter getWaterMeter() {
        return waterMeter;
    }

    public void setWaterMeter(WaterMeter waterMeter) {
        this.waterMeter = waterMeter;
    }
}
