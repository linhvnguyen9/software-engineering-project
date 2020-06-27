package model;

import java.io.Serializable;

public class UsedService implements Serializable{
	private int id;
	private Service service;
	private float price;
	private float quantity;
	private float total;
	private float saleoff;
	
	public UsedService() {
		super();
	}
	
	
	public UsedService(Service service, float price, float quantity, float total, float saleoff) {
		super();
		this.service = service;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.saleoff = saleoff;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
		//total = quantity*price;
	}


	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
		this.quantity = quantity;
		//total = quantity*price;
	}


	public float getTotal() {
		updateTotal();
		return total;
	}

	public float getSaleoff() {
		return saleoff;
	}


	public void setSaleoff(float saleoff) {
		this.saleoff = saleoff;
	}
	
	private void updateTotal() {
		total = quantity*price - saleoff;
	}
}
