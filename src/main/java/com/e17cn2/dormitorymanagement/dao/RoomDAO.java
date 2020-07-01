package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomDAO extends DAO{
    public Room getRoomByBedId(int key){
        Room room=new Room();
		String sql = "SELECT * from tblPhong WHERE tblPhong.id IN (SELECT tblPhongid FROM tblGiuong WHERE tblGiuong.id=?);";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
                            room.setId(rs.getInt("id"));
                            room.setDescription(rs.getString("moTa"));
                            room.setRoomName(rs.getString("tenPhong"));
                            room.setRoomType(rs.getString("KieuPhong"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return room;
	}
}
