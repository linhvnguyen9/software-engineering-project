package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class BookedRoom implements Serializable{
	private int id;
	private Room room;
	private Date checkin;
	private Date checkout;
	private float price;
	private float saleoff;
	private float total;
	private boolean isChecked;
	private ArrayList<UsedService> usedService;
	
	public BookedRoom() {
		super();
		usedService = new ArrayList<UsedService>();
	}
	
	public BookedRoom(Room room, Date checkin, Date checkout, float price, float saleoff, boolean isChecked) {
		super();
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
		this.saleoff = saleoff;
		this.isChecked = isChecked;
		usedService = new ArrayList<UsedService>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
		//updateTotal();
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
		//updateTotal();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		//updateTotal();
	}

	public float getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(float saleoff) {
		this.saleoff = saleoff;
		//updateTotal();
	}

	public float getTotal() {
		updateTotal();
		return total;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public ArrayList<UsedService> getUsedService() {
		return usedService;
	}

	public void setUsedService(ArrayList<UsedService> usedService) {
		this.usedService = usedService;
	}
	
	private void updateTotal() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		LocalDateTime date1 = LocalDateTime.parse(format.format(checkin).toString(),dtf);
		LocalDateTime date2 = LocalDateTime.parse(format.format(checkout).toString(),dtf);
		total = Duration.between(date1, date2).toDays()*price - saleoff;
		if(usedService != null) {
			for(UsedService us: usedService) {
				total += us.getTotal();
			}
		}
	}
}
