package com.e17cn2.dormitorymanagement.model;

public class UsedService {
    private int id;
    private double qty;
    private Service service;

    public UsedService() {
    }

    public UsedService(int id, double qty, Service service) {
        this.id = id;
        this.qty = qty;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
