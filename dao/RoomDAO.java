package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Room;

public class RoomDAO extends DAO{
	
	public RoomDAO() {
		super();
	}


	/**
	 * search all rooms in the tblRoom whose name contains the @key
	 * @param key
	 * @return list of room whose name contains the @key
	 */
	public ArrayList<Room> searchRoom(String key){
		ArrayList<Room> result = new ArrayList<Room>();
		String sql = "SELECT * FROM tblRoom WHERE name LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Room rm = new Room();
				rm.setId(rs.getInt("id"));
				rm.setName(rs.getString("name"));
				rm.setType(rs.getString("type"));
				rm.setPrice(rs.getFloat("price"));
				rm.setDes(rs.getString("des"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	

	/**
	 * update the @room
	 * @param rm
	 */
	public boolean updateRoom(Room rm){
		String sql = "UPDATE tblroom SET name=?, type=?, price=?, des=? WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rm.getName());
			ps.setString(2, rm.getType());
			ps.setFloat(3, rm.getPrice());
			ps.setString(4, rm.getDes());
			ps.setInt(5, rm.getId());

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	/**
	 * Search available rooms in the period from @checkin to @checkout
	 * @param checkin
	 * @param checkout
	 * @return
	 */
	public ArrayList<Room> searchFreeRoom(Date checkin, Date checkout){
		ArrayList<Room> result = new ArrayList<Room>();
		String sql = "SELECT * FROM tblRoom WHERE id NOT IN (SELECT idroom FROM tblBookedRoom WHERE checkout > ? AND checkin < ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdf.format(checkin));
			ps.setString(2, sdf.format(checkout));
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Room rm = new Room();
				rm.setId(rs.getInt("id"));
				rm.setName(rs.getString("name"));
				rm.setType(rs.getString("type"));
				rm.setPrice(rs.getFloat("price"));
				rm.setDes(rs.getString("des"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
}
