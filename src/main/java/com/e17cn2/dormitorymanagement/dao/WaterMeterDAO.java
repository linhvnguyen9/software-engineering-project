package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.WaterMeterDto;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import com.e17cn2.dormitorymanagement.model.entity.WaterMeter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WaterMeterDAO extends DAO{
    
    public boolean saveWaterMeter(WaterMeter waterMeter) throws SQLException{
        String query = "INSERT INTO tbldonghonuoc VALUES (null, ?, ?, ?)";
        PreparedStatement psmt = con.prepareStatement(query);
            
        Date currentDate = new Date();
        double index = waterMeter.getCurrentReading();
        int roomId = waterMeter.getRoom().getId();
            
        psmt.setDouble(1, index);
        psmt.setDate(2, new java.sql.Date(currentDate.getTime()));
        psmt.setInt(3, roomId);
          
        return psmt.execute();
    }
    
    public List<WaterMeter> getWaterMeter(int bookedBedId){
        List<WaterMeterDto> waterMeters = new ArrayList<>();
        WaterMeterDto dto;
        
        String sql = "SELECT * FROM cnpm.tbldonghonuoc WHERE tblPhongid IN" +
                     "(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = ?))" +
                     "ORDER BY (ngayLaySo) DESC LIMIT 2;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bookedBedId));

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                dto = new WaterMeterDto();
                
                dto.setId(rs.getInt("id"));
                dto.setCurrentReading(rs.getFloat("chiSoHienTai"));
                dto.setMeasuringDate(rs.getDate("ngayLaySo"));
                dto.setPhongId(rs.getInt("tblPhongid"));
                
                waterMeters.add(dto);
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        return convertFromDTOs(waterMeters);
    }
    
    private WaterMeter convertFromDto(WaterMeterDto dto){
        WaterMeter waterMeter = new WaterMeter();
        Room room = new Room();
        
        if (dto != null) {
            room.setId(dto.getPhongId());
            
            waterMeter.setId(dto.getId());
            waterMeter.setCurrentReading(dto.getCurrentReading());
            waterMeter.setMeasuringDate(dto.getMeasuringDate());
            waterMeter.setRoom(room);
            
            return waterMeter;
        }else return null;
    }
    
    private List<WaterMeter> convertFromDTOs(List<WaterMeterDto> dtos){
        if (dtos != null){
            return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
        } else return null;
    }
    
}
