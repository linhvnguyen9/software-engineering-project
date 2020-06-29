package com.e17cn2.dormitorymanagement.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblphong")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "kieuPhong")
    private String roomType;
    
    @Column(name = "tenPhong")
    private String roomName;
    
    @Column(name = "moTa")
    private String description;

    //region Constructor
    public Room() {

    }

    public Room(int id, String roomType, String roomName, String description) {
        this.id = id;
        this.roomType = roomType;
        this.roomName = roomName;
        this.description = description;
    }

    //endregion

    //region Getters and setters
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
    //endregion
}
