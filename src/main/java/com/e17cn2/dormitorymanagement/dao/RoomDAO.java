package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.RoomDto;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO extends DAO{
    
    public Room getRoomInfoByBookedBedId(int bookedBedId){
        Room room = new Room();
        RoomDto dto = new RoomDto();
        
        String sql = "SELECT * FROM tblPhong WHERE id IN"
                + "(SELECT tblPhongid FROM tblgiuong,tblgiuongdat WHERE tblgiuong.id = tblgiuongdat.tblGiuongid AND tblgiuongdat.id = ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bookedBedId));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                dto.setId(rs.getInt("id"));
                dto.setRoomType(rs.getString("kieuPhong"));
                dto.setRoomName(rs.getString("tenPhong"));
                dto.setDescription(rs.getString("moTa"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        
        return room;
    }
    
    public RoomDto getRoomById(int id){
        RoomDto room = new RoomDto();
        String sql = "SELECT * FROM tblPhong WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                room.setId(rs.getInt("id"));
                room.setRoomName(rs.getString("tenPhong"));
                room.setRoomType(rs.getString("kieuPhong"));
                room.setDescription(rs.getString("moTa"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        
        return room;
    }
    
    private Room convertFromDto(RoomDto dto, int bookedBedId){
        Room room = new Room();
        BookedBedDAO bookedBed = new BookedBedDAO();
        ElectricityMeterDAO electricityMeter = new ElectricityMeterDAO();
        WaterMeterDAO waterMeter = new WaterMeterDAO();
        BedDAO bed = new BedDAO();
        
        if (dto != null) {
            room.setId(dto.getId());
            room.setRoomName(dto.getRoomName());
            room.setRoomType(dto.getRoomType());
            room.setDescription(dto.getDescription());
            room.setBeds(bed.findAllBedByRoomId(dto.getId()));
            room.setElectricityMeter(electricityMeter.getElectricityMeter(bookedBedId));
            room.setWaterMeter(waterMeter.getWaterMeter(bookedBedId));
            
            return room;
        }else return null;
    }
}
