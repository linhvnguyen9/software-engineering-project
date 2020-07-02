package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.ElectricityMeter;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import com.e17cn2.dormitorymanagement.model.entity.WaterMeter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookedBedDAO extends DAO{
    public Bed getBedById(int key){
	Bed bed=new Bed();
	String sql = "SELECT * FROM tblGiuongDat WHERE id=?";
            try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, key);
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
                    bed.setId(rs.getInt("id"));
                    bed.setPrice(rs.getInt("gia"));
                    bed.setDescription(rs.getString("moTa"));
                    bed.setType(rs.getString("loai"));
                }
            }catch(Exception e){
		e.printStackTrace();
            }	
	return bed;
    }
    
    public ArrayList<ElectricityMeter> getElectricityMeterByRoom(int key){
        ArrayList<ElectricityMeter> list=new ArrayList<ElectricityMeter>();
        String sql = "select * from cnpm.tbldonghodien where tblPhongid=? order by (ngayLaySo) DESC limit 2;";
	try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ElectricityMeter electricityMeter=new ElectricityMeter();
                electricityMeter.setCurrentReading(rs.getFloat("chiSoHienTai"));
                electricityMeter.setMeasuringDate(rs.getDate("ngayLaySo"));
                list.add(electricityMeter);
            }
	}catch(Exception e){
            e.printStackTrace();
	}	
	return list;
    }
    public ArrayList<WaterMeter> getWaterMeterByIdRoom(int key){
        ArrayList<WaterMeter> list=new ArrayList<>();
        String sql = "select * from cnpm.tbldonghonuoc where tblPhongid=? order by (ngayLaySo) DESC limit 2;";
	try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaterMeter waterMeter=new WaterMeter();
                waterMeter.setCurrentReading(rs.getFloat("chiSoHienTai"));
                waterMeter.setMeasuringDate(rs.getDate("ngayLaySo"));
                list.add(waterMeter);
            }
	}catch(Exception e){
            e.printStackTrace();
	}	
	return list;
    }
    public int countBookedBedInRoom(Room room) throws SQLException{
        int count = 0;
        String sql = "select count(id) from tblGiuongDat where id in (select id from tblgiuong where tblPhongid = ?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(room.getId()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            count = rs.getInt(1);
        }
         
	}catch(Exception e){
            e.printStackTrace();
	}	
        return count;
    }

}
