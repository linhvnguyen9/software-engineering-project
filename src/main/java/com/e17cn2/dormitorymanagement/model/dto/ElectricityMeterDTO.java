package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;

public class ElectricityMeterDTO {
    private int id;
    private float currentReading;
    private Date measuringDate;
    private RoomDTO roomDto;
    
    public ElectricityMeterDTO() {
    }

    public ElectricityMeterDTO(int id, float currentReading, Date measuringDate, RoomDTO roomDto) {
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

    public RoomDTO getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDTO roomDto) {
        this.roomDto = roomDto;
    }

}
