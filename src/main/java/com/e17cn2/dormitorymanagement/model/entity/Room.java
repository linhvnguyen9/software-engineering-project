package com.e17cn2.dormitorymanagement.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String roomType;
    private String roomName;
    private String description;
    private List<Bed> beds;
    private List<ElectricityMeter> electricityMeter;
    private List<WaterMeter> waterMeter;

    //region Constructor
    public Room() {

    }

    public Room(int id, String roomType, String roomName, String description, 
            List<Bed> beds, List<ElectricityMeter> electricityMeter, 
            List<WaterMeter> waterMeter) {
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

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public List<ElectricityMeter> getElectricityMeter() {
        return electricityMeter;
    }

    public void setElectricityMeter(List<ElectricityMeter> electricityMeter) {
        this.electricityMeter = electricityMeter;
    }

    public List<WaterMeter> getWaterMeter() {
        return waterMeter;
    }

    public void setWaterMeter(List<WaterMeter> waterMeter) {
        this.waterMeter = waterMeter;
    }

}
