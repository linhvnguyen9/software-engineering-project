package com.e17cn2.dormitorymanagement.model.dto;

public class RoomDto {
    private int id;
    private String roomType;
    private String roomName;
    private String description;

    //region Constructor
    public RoomDto() {
    }

    public RoomDto(int id, String roomType, String roomName, String description) {
        this.id = id;
        this.roomType = roomType;
        this.roomName = roomName;
        this.description = description;
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

}
