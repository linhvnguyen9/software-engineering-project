package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BedDAO {

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
    public Bed getBedByInvoiceId(int key){
        Bed bed=new Bed();
		String sql = "SELECT tblGiuong.id,tblGiuong.gia,tblGiuong.ma,tblGiuong.mota,tblGiuong.loai\n"
                        + "FROM tblHoaDon,tblGiuongDat,tblGiuong WHERE tblHoaDon.tblGiuongDatid=tblGiuongDat.id AND "
                        + "tblGiuongDat.tblGiuongid=tblGiuong.id AND tblhoadon.id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
                           bed.setId(rs.getInt("id"));
                           bed.setPrice(rs.getDouble("gia"));
                           bed.setDescription(rs.getString("mota"));
                           bed.setType(rs.getString("loai"));
                           bed.setName(rs.getString("ma"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return bed;
	}
}
