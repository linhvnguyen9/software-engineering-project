package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.RoomStat;

public class RoomStatDAO extends DAO{

	public RoomStatDAO() {
		super();
	}
	
	public ArrayList<RoomStat> getRoomStat(Date startDate, Date endDate){
		ArrayList<RoomStat> result = new ArrayList<RoomStat>();
		String sql = "SELECT a.id, a.name, a.type, a.des, "
				+ "(SELECT SUM(DATEDIFF(LEAST(b.checkout, ?), GREATEST(b.checkin, ?))) FROM tblBookedRoom b "
				+ "WHERE b.idroom = a.id AND b.checkout > ? AND b.checkin < ?  AND b.ischeckin = 1 GROUP BY b.idroom) as days,"
				+ " (SELECT SUM(DATEDIFF(LEAST(b.checkout, ?), GREATEST(b.checkin, ?))*b.price) FROM tblBookedRoom b "
				+ "WHERE b.idroom = a.id AND b.checkout > ? AND b.checkin < ?  AND b.ischeckin = 1 GROUP BY b.idroom) as income "
				+ " FROM tblRoom a ORDER BY income DESC, days DESC";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdf.format(endDate));
			ps.setString(2, sdf.format(startDate));
			ps.setString(3, sdf.format(startDate));
			ps.setString(4, sdf.format(endDate));
			ps.setString(5, sdf.format(endDate));
			ps.setString(6, sdf.format(startDate));
			ps.setString(7, sdf.format(startDate));
			ps.setString(8, sdf.format(endDate));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				RoomStat r = new RoomStat();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setType(rs.getString("type"));
				r.setDes(rs.getString("des"));
				r.setTotalDay(rs.getInt("days"));
				r.setTotalIncome(rs.getFloat("income"));
				result.add(r);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
