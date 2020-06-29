package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;

public class WaterMeterDTO {
    private int id;
    private float currentReading;
    private Date measuringDate;

    public WaterMeterDTO() {
    }

    public WaterMeterDTO(int id, float currentReading, Date measuringDate) {
        this.id = id;
        this.currentReading = currentReading;
        this.measuringDate = measuringDate;
     
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

}
