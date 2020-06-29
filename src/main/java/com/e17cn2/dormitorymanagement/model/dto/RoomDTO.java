package com.e17cn2.dormitorymanagement.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {
    private int id;
    private String roomType;
    private String roomName;
    private String description;
    private ArrayList<BedDTO> beds;
    private List<ElectricityMeterDTO> electricityMeter;
    private List<ElectricityMeterDTO> waterMeter;

    //region Constructor
    public RoomDTO() {

    }

    public RoomDTO(int id, String roomType, String roomName, String description,
            ArrayList<BedDTO> beds, List<ElectricityMeterDTO> electricityMeter,
            List<ElectricityMeterDTO> waterMeter) {
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

    public ArrayList<BedDTO> getBeds() {
        return beds;
    }

    public void setBeds(ArrayList<BedDTO> beds) {
        this.beds = beds;
    }

    public List<ElectricityMeterDTO> getElectricityMeter() {
        return electricityMeter;
    }

    public void setElectricityMeter(List<ElectricityMeterDTO> electricityMeter) {
        this.electricityMeter = electricityMeter;
    }

    public List<ElectricityMeterDTO> getWaterMeter() {
        return waterMeter;
    }

    public void setWaterMeter(List<ElectricityMeterDTO> waterMeter) {
        this.waterMeter = waterMeter;
    }
    
}
