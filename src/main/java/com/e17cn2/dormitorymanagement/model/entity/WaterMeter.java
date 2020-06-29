package com.e17cn2.dormitorymanagement.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblDongHoNuoc")
public class WaterMeter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "chiSoHienTai")
    private float currentReading;
    
    @Column(name = "ngayLaySo")
    private Date measuringDate;
    
    @Column(name = "tblPhongid")
    private int PhongId;

    public WaterMeter() {
    }

    public WaterMeter(int id, float currentReading, Date measuringDate, int PhongId) {
        this.id = id;
        this.currentReading = currentReading;
        this.measuringDate = measuringDate;
        this.PhongId = PhongId;
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

    public int getPhongId() {
        return PhongId;
    }

    public void setPhongId(int PhongId) {
        this.PhongId = PhongId;
    }

}
