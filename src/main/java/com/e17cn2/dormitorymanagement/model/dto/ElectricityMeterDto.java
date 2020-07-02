package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;

public class ElectricityMeterDto {
    private int id;
    private float currentReading;
    private Date measuringDate;
    private int roomId;

    public ElectricityMeterDto() {
    }

    public ElectricityMeterDto(int id, float currentReading, Date measuringDate,
            int roomId) {
        this.id = id;
        this.currentReading = currentReading;
        this.measuringDate = measuringDate;
        this.roomId = roomId;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}
