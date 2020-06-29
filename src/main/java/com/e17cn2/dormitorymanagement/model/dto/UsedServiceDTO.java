package com.e17cn2.dormitorymanagement.model.dto;

public class UsedServiceDTO {
    private int id;
    private double qty;
    private ServiceDTO service;

    public UsedServiceDTO() {
    }

    public UsedServiceDTO(int id, double qty, ServiceDTO service) {
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

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }
}
