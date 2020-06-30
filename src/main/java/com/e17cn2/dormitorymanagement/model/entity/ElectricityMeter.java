package com.e17cn2.dormitorymanagement.model.entity;

import java.util.Date;

public class ElectricityMeter {
    private int id;
    private float currentReading;
    private Date measuringDate;
    private Room roomDto;
    
    public ElectricityMeter() {
    }

    public ElectricityMeter(int id, float currentReading, Date measuringDate, Room roomDto) {
        this.id = id;
        this.currentReading = currentReading;
        this.measuringDate = measuringDate;
        this.roomDto = roomDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(float currentReading) {
        this.currentReading = currentReading;
    }

    public Date getMeasuringDate() {
        return measuringDate;
    }

    public void setMeasuringDate(Date measuringDate) {
        this.measuringDate = measuringDate;
    }

    public Room getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(Room roomDto) {
        this.roomDto = roomDto;
    }

}
