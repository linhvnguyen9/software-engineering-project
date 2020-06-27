package model;

import java.io.Serializable;

public class Service implements Serializable{
	private int id;
	private String name;
	private String unity;
	private float price;
	private String des;
	
	public Service() {
		super();
	}
	
	public Service(String name, String unity, float price, String des) {
		super();
		this.name = name;
		this.unity = unity;
		this.price = price;
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

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
}
