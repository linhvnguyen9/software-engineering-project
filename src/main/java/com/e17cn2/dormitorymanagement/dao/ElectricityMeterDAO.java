package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.ElectricityMeterDto;
import com.e17cn2.dormitorymanagement.model.entity.ElectricityMeter;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectricityMeterDAO extends DAO{
    
    public List<ElectricityMeter> getElectricityMeter(int bookedBedId){
        List<ElectricityMeterDto> electricityDtos = new ArrayList<>();
        ElectricityMeterDto dto;
        
        String sql = "SELECT * FROM cnpm.tbldonghodien WHERE tblPhongid IN" +
                     "(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = ?))" +
                     "ORDER BY (ngayLaySo) DESC LIMIT 2;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bookedBedId));

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                dto = new ElectricityMeterDto();
                
                dto.setId(rs.getInt("id"));
                dto.setCurrentReading(rs.getFloat("chiSoHienTai"));
                dto.setMeasuringDate(rs.getDate("ngayLaySo"));
                dto.setRoomId(rs.getInt("tblPhongid"));
                
                electricityDtos.add(dto);
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        return convertFromDTOs(electricityDtos);
    }
    
    private ElectricityMeter convertFromDto(ElectricityMeterDto dto){
        ElectricityMeter electricity = new ElectricityMeter();
        Room room = new Room();
        
        if (dto != null) {
            room.setId(dto.getRoomId());
            
            electricity.setId(dto.getId());
            electricity.setCurrentReading(dto.getCurrentReading());
            electricity.setMeasuringDate(dto.getMeasuringDate());
            electricity.setRoomDto(room);
            
            return electricity;
        }else return null;
    }
    
    private List<ElectricityMeter> convertFromDTOs(List<ElectricityMeterDto> dtos){
        if (dtos != null){
            return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
        } else return null;
    }

}
