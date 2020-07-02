package com.e17cn2.dormitorymanagement.model.dto;

public class UsedServiceDto {
    private int id;
    private double quantity;
    private int serviceId;
    private int invoiceId;
            
    public UsedServiceDto() {
    }

    public UsedServiceDto(int id, double quantity, int serviceId, int invoiceId) {
        this.id = id;
        this.quantity = quantity;
        this.serviceId = serviceId;
        this.invoiceId = invoiceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

}
