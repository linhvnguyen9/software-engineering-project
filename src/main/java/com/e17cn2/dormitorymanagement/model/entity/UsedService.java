package com.e17cn2.dormitorymanagement.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dichvusudung")
public class UsedService {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "soLuong")
    private double quantity;
    
    @Column(name = "DichVuid")
    private int serviceId;
    
    @Column(name = "tblHoaDonid")
    private int invoiceId;
            
    public UsedService() {
    }

    public UsedService(int id, double quantity, int serviceId, int invoiceId) {
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
