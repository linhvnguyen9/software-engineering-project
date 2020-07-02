package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.RoomDto;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAO extends DAO{
    
    public Room getRoomInfoByBookedBedId(int bookedBedId){
        RoomDto dto = new RoomDto();
        
        String sql = "SELECT * FROM tblPhong WHERE id IN"
                + "(SELECT tblPhongid FROM tblgiuong,tblgiuongdat WHERE tblgiuong.id = tblgiuongdat.tblGiuongid AND tblgiuongdat.id = ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bookedBedId));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                dto.setId(rs.getInt("id"));
                dto.setRoomType(rs.getString("kieuPhong"));
                dto.setRoomName(rs.getString("tenPhong"));
                dto.setDescription(rs.getString("moTa"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        
        Room room = new Room(dto.getId(), dto.getRoomType(), dto.getRoomName(), 
                dto.getDescription(), null, null, null);
        
        return room;
    }
    
    public Room getRoomById(int id){
        RoomDto dto = new RoomDto();
        String sql = "SELECT * FROM tblPhong WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                dto.setId(rs.getInt("id"));
                dto.setRoomName(rs.getString("tenPhong"));
                dto.setRoomType(rs.getString("kieuPhong"));
                dto.setDescription(rs.getString("moTa"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        
        Room room = new Room(dto.getId(), dto.getRoomType(), dto.getRoomName(), 
                dto.getDescription(), null, null, null);
        return room;
    }
    
    private Room convertFromDto(RoomDto dto, int bookedBedId){
        Room room = new Room();
        BookedBedDAO bookedBed = new BookedBedDAO();
        BedDAO bed = new BedDAO();
        
        if (dto != null) {
            room.setId(dto.getId());
            room.setRoomName(dto.getRoomName());
            room.setRoomType(dto.getRoomType());
            room.setDescription(dto.getDescription());
            room.setBeds(bed.findAllBedByRoomId(dto.getId()));
            
            return room;
        }else return null;
    }

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
