package com.e17cn2.dormitorymanagement.model.entity;

public class UsedService {
    private int id;
    private double qty;
    private Invoice invoice;
    private boolean checkUnpaid;
    private Service service;

    public UsedService() {
    }

    public UsedService(int id, double qty, Invoice invoice, boolean checkUnpaid, Service service) {
        this.id = id;
        this.qty = qty;
        this.invoice = invoice;
        this.checkUnpaid = checkUnpaid;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public double getQty() {
        return qty;
    }

    public boolean isCheckUnpaid() {
        return checkUnpaid;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Service getService() {
        return service;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public void setCheckUnpaid(boolean checkUnpaid) {
        this.checkUnpaid = checkUnpaid;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
}
