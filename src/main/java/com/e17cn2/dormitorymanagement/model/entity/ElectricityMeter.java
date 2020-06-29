package com.e17cn2.dormitorymanagement.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbldonghodien")
public class ElectricityMeter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "chiSoHienTai")
    private float currentReading;
    
    @Column(name = "ngayLaySo")
    private Date measuringDate;
    
    @Column(name = "tblPhongid")
    private int roomId;

    public ElectricityMeter() {
    }

    public ElectricityMeter(int id, float currentReading, Date measuringDate,
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
