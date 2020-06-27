package model;

import java.io.Serializable;

public class Hotel implements Serializable{
	private int id;
	private String name;
	private String address;
	private int star;
	private String des;
	
	public Hotel() {
		super();
	}
	
	public Hotel(String name, String address, int star, String des) {
		super();
		this.name = name;
		this.address = address;
		this.star = star;
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
	
	
}
