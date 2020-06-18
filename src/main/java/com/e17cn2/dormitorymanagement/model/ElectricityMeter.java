package com.e17cn2.dormitorymanagement.model;

import java.util.Date;

public class ElectricityMeter {
    private int id;
    private float currentReading;
    private double unitPrice;
    private String unit;
    private Date measuringDate;

    public ElectricityMeter() {
    }

    public ElectricityMeter(int id, float currentReading, double unitPrice, String unit, Date measuringDate) {
        this.id = id;
        this.currentReading = currentReading;
        this.unitPrice = unitPrice;
        this.unit = unit;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getMeasuringDate() {
        return measuringDate;
    }

    public void setMeasuringDate(Date measuringDate) {
        this.measuringDate = measuringDate;
    }
}
