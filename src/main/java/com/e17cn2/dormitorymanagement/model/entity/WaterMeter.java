package com.e17cn2.dormitorymanagement.model.entity;

import com.e17cn2.dormitorymanagement.model.dto.RoomDto;
import java.util.Date;

public class WaterMeter {
    private int id;
    private float currentReading;
    private Date measuringDate;
    private Room room;

    public WaterMeter() {
    }

    public WaterMeter(int id, float currentReading, Date measuringDate, Room room) {
        this.id = id;
        this.currentReading = currentReading;
        this.measuringDate = measuringDate;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
