package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDAO extends DAO{
    
     public ArrayList<Room> getRoom(){
		ArrayList<Room> result = new ArrayList<Room>();
		String sql = "select tblphong.tenPhong, tblphong.kieuPhong\n" +
"from tblsinhvien, tblhopdong, tblhoadon, tblgiuong,tblphong,tblgiuongdat \n" +
"where tblsinhvien.id = tblhopdong.tblsinhvienid \n" +
"and tblhopdong.id = tblhoadon.tblhopdongid and tblhoadon.soTienConNo>0\n" +
"and tblhopdong.id = tblgiuongdat.tblHopDongid and tblgiuong.id = tblgiuongdat.tblGiuongid\n" +
"and tblgiuong.tblPhongid=tblphong.id;";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Room rm = new Room();
				rm.setRoomName(rs.getString("tenPhong"));
                                rm.setRoomType(rs.getString("kieuPhong"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
}
