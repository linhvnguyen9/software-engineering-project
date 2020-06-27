package model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable{
	private int id;
	private Date paymentDate;
	private float amount;
	private String paymentType;
	private String note;
	private User creator;
	private Booking booking;
	
	public Bill() {
		super();
	}
	
	public Bill(int id, Date paymentDate, float amount, String paymentType, String note, User creator,
			Booking booking) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentType = paymentType;
		this.note = note;
		this.creator = creator;
		this.booking = booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
}
