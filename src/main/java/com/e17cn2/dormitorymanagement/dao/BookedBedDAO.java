package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookedBedDAO extends DAO{
    public BookedBed findBookedBedByBedId(int bedId){
        BookedBed bookedBed = new BookedBed();
        
        String sql = "SELECT * FROM tblgiuongdat WHERE tblGiuongid = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bedId));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                bookedBed.setId(rs.getInt("id"));
                bookedBed.setCheckinDate(rs.getDate("ngayNhanGiuong"));
                bookedBed.setCheckoutDate(rs.getDate("ngayTraGiuong"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        return bookedBed;
    }
}
