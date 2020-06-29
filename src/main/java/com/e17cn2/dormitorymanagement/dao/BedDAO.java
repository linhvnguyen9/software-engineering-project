package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.dao.repository.BedRepository;
import com.e17cn2.dormitorymanagement.dao.repository.RoomRepository;
import com.e17cn2.dormitorymanagement.model.dto.BedDTO;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class BedDAO{
    @Autowired
    private BedRepository bedRepository;
    
    private RoomRepository roomRepository;
    
    private BedDAO bedDAO;
    
    public BedDAO() {
        super();
    }
    
    public ArrayList<Bed> searchBed(String key){
	ArrayList<Bed> result = new ArrayList<Bed>();
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
    
    public  getBed(Integer id){
        Bed bed =new Bed();
        return convertToDto(bed);
    }
    
    

}
