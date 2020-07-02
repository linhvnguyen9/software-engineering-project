package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;

public class InvoiceDto {
    private int id;
    private Date createdAt;
    private Date payingDate;
    private double totalAmount;
    private double amountPaid;
    private boolean checkPayed;
    private double amountUnPaid;
    private int contractId;
    private int employeeId;
    private int BookedBedId;

    //region Constructors
    public InvoiceDto() {
    }
    
    public InvoiceDto(int id, Date createdAt, Date payingDate, double totalAmount,
            double amountPaid, boolean checkPayed, double amountUnPaid, int contractId, 
            int employeeId, int BookedBedId) {
        this.id = id;
        this.createdAt = createdAt;
        this.payingDate = payingDate;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.checkPayed = checkPayed;
        this.amountUnPaid = amountUnPaid;
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.BookedBedId = BookedBedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getPayingDate() {
        return payingDate;
    }

    public void setPayingDate(Date payingDate) {
        this.payingDate = payingDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isCheckPayed() {
        return checkPayed;
    }

    public void setCheckPayed(boolean checkPayed) {
        this.checkPayed = checkPayed;
    }

    public double getAmountUnPaid() {
        return amountUnPaid;
    }

    public void setAmountUnPaid(double amountUnPaid) {
        this.amountUnPaid = amountUnPaid;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getBookedBedId() {
        return BookedBedId;
    }

    public void setBookedBedId(int BookedBedId) {
        this.BookedBedId = BookedBedId;
    }
    
}
