package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.BedDto;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookedBedDAO extends DAO{
    
    public List<Bed> getAllBedNotMonthlyBill(){
        List<Bed> beds = new ArrayList<>();
        List<BedDto> bedDtos = new ArrayList<>();
        BedDto bedDto;
        
        String sql = "SELECT * FROM tblgiuong" +
                     "WHERE id IN" +
                     "(SELECT tblGiuongid FROM tblGiuongDat WHERE id NOT IN " +
                     "(SELECT tblGiuongDatid FROM tblhoadon WHERE DATE_FORMAT(tblhoadon.ngayLap, '%y-%m') >= DATE_FORMAT(current_timestamp, '%y-%m')));";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bedDto = new BedDto();
                
                bedDto.setId(rs.getInt("id"));
                bedDto.setName(rs.getString("ma"));
                bedDto.setPrice(rs.getDouble("gia"));
                bedDto.setType(rs.getString("loai"));
                bedDto.setDescription(rs.getString("moTa"));
                bedDto.setRoomId(rs.getInt("tblPhongid"));
                
                if (bedDto != null) {
                    bedDtos.add(bedDto);
                }
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        return beds;
    }
    
}
