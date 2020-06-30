package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.BedDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BedDAO {

    public BedDAO() {
        super();
    }

    public ArrayList<BedDto> searchBed(String key){
	ArrayList<BedDto> result = new ArrayList<BedDto>();
//	String sql = "SELECT * FROM tblgiuong WHERE ma LIKE ?";
//	try{
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + key + "%");
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()){
//		Bed bed = new Bed(rs.getInt("id"),
//                                  rs.getDouble("gia"),
//                                  rs.getString("ma"),
//                                  rs.getString("moTa"),
//                                  rs.getString("loai"),
//                                  rs.get);
//		result.add(bed);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        return result;
    }

}
