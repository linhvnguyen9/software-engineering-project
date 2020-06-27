package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.BookedRoom;
import model.Booking;
import model.Client;

public class BookingDAO extends DAO{

	public BookingDAO() {
		super();
	}
	
	/**
	 * Insert a new booking into the database, including its booked rooms. All are added in a single transaction.
	 * @param b
	 * @return
	 */
	public boolean addBooking(Booking b) {
		String sqlAddBooking = "INSERT INTO tblBooking(idcreator, idclient, bookingdate, saleoff, note) VALUES(?,?,?,?,?)";
		String sqlAddBookedRoom = "INSERT INTO tblBookedRoom(idbooking, idroom, checkin, checkout, price, saleoff, ischeckin) "
				+ "VALUES(?,?,?,?,?,?,?)";
		String sqlCheckbookedRoom = "SELECT * FROM tblBookedRoom WHERE idroom = ? AND checkout > ? AND checkin < ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean result = true;
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sqlAddBooking, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, b.getCreator().getId());
			ps.setInt(2, b.getClient().getId());
			ps.setString(3, sdf.format(b.getBookedDate()));
			ps.setFloat(4, b.getSaleoff());
			ps.setString(5, b.getNote());
			
			ps.executeUpdate();			
			//get id of the new inserted booking
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				b.setId(generatedKeys.getInt(1));
				
				//insert booked rooms
				for(BookedRoom br: b.getBookedRoom()) {
					//check if the room is available at the period
					ps = con.prepareStatement(sqlCheckbookedRoom);
					ps.setInt(1, br.getRoom().getId());
					ps.setString(2, sdf.format(br.getCheckin()));
					ps.setString(3, sdf.format(br.getCheckout()));
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {//unavailable
						result = false;
						try {
							con.rollback();
							con.setAutoCommit(true);
						}catch(Exception ex) {
							result = false;
							ex.printStackTrace();
						}
						return result;
					}
					
					//insert booked room
					ps = con.prepareStatement(sqlAddBookedRoom, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, b.getId());
					ps.setInt(2, br.getRoom().getId());
					ps.setString(3, sdf.format(br.getCheckin()));
					ps.setString(4, sdf.format(br.getCheckout()));
					ps.setFloat(5, br.getPrice());
					ps.setFloat(6, br.getSaleoff());
					ps.setBoolean(7, br.isChecked());
					
					ps.executeUpdate();			
					//get id of the new inserted booking
					generatedKeys = ps.getGeneratedKeys();
					if (generatedKeys.next()) {
						br.setId(generatedKeys.getInt(1));
					}
				}
			}
			
			//con.commit();//set this line into comment in JUnit test mode
		}catch(Exception e) {
			result = false;			
			try {				
				con.rollback();
			}catch(Exception ex) {
				result = false;
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {				
				//con.setAutoCommit(true);//set this line into comment in JUnit test mode
			}catch(Exception ex) {
				result = false;
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * get list of booking involved the room whose @idroom is given between @startDate and @endDate
	 * @param idroom
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ArrayList<Booking> getBookingOfRoom(int idroom, Date startDate, Date endDate){
		ArrayList<Booking> result = new ArrayList<Booking>();
		String sql = "SELECT a.id as idbookedroom, GREATEST(a.checkin,?) as checkin, LEAST(a.checkout,?) as checkout, a.price, a.saleoff as roomsaleoff,"
				+ "b.id as idbooking, b.saleoff as bookingsaleoff,"
				+ " c.id as idclient, c.name, c.address, c.idcard, c.tel"
				+ " FROM tblBookedRoom a, tblBooking b, tblClient c WHERE a.idroom = ? AND a.ischeckin = 1 "
				+ "AND a.checkout > ? AND a.checkin < ? AND b.id = a.idbooking AND c.id = b.idclient";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdf.format(startDate));
			ps.setString(2, sdf.format(endDate));
			ps.setInt(3, idroom);
			ps.setString(4, sdf.format(startDate));
			ps.setString(5, sdf.format(endDate));
			ResultSet rs = ps.executeQuery();

			//a == null ? b : (b == null ? a : (a.before(b) ? a : b));
			while(rs.next()){
				Booking b = new Booking();
				b.setId(rs.getInt("idbooking"));
				b.setSaleoff(rs.getFloat("bookingsaleoff"));
				//client
				Client c = new Client();
				c.setId(rs.getInt("idclient"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setIdCard(rs.getString("idcard"));
				b.setClient(c);
				//booked room
				BookedRoom br = new BookedRoom();
				br.setId(rs.getInt("idbookedroom"));				
				br.setSaleoff(rs.getFloat("roomsaleoff"));
				br.setPrice(rs.getFloat("price"));
				br.setCheckin(rs.getDate("checkin"));
				br.setCheckout(rs.getDate("checkout"));		
				b.getBookedRoom().add(br);
				result.add(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
}
