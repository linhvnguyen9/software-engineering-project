package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
