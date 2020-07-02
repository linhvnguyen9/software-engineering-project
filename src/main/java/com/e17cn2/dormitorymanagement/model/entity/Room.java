package com.e17cn2.dormitorymanagement.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String roomType;
    private String roomName;
    private String description;
    private ArrayList<Bed> beds;
    private List<ElectricityMeter> electricityMeter;
    private List<ElectricityMeter> waterMeter;

    //region Constructor
    public Room() {

    }

    public Room(int id) {
        this.id = id;
    }

    public Room(int id, String roomType, String roomName, String description,
                ArrayList<Bed> beds, List<ElectricityMeter> electricityMeter,
                List<ElectricityMeter> waterMeter) {
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

    public List<ElectricityMeter> getElectricityMeter() {
        return electricityMeter;
    }

    public void setElectricityMeter(List<ElectricityMeter> electricityMeter) {
        this.electricityMeter = electricityMeter;
    }

    public List<ElectricityMeter> getWaterMeter() {
        return waterMeter;
    }

    public void setWaterMeter(List<ElectricityMeter> waterMeter) {
        this.waterMeter = waterMeter;
    }
    
}
