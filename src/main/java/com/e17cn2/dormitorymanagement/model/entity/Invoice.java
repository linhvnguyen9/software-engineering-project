package com.e17cn2.dormitorymanagement.model.entity;

import java.util.Date;
import java.util.List;

public class Invoice {
    private int id;
    private Date createdAt;
    private Date payingDate;
    private double totalAmount;
    private int amountPaid;
    private int amountUnPaid;
    private boolean checkPayed;
    private Contract contract;
    private Employee employee;
    private List<UsedService> usedService;

    //region Constructors
    public Invoice() {
    }

    
    //endregion

    public Invoice(int id, Date createdAt, Date payingDate, double totalAmount, 
            int amountPaid, int amountUnPaid, boolean checkPayed, Contract contract, 
            Employee employee, List<UsedService> usedService) {
        this.id = id;
        this.createdAt = createdAt;
        this.payingDate = payingDate;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.amountUnPaid = amountUnPaid;
        this.checkPayed = checkPayed;
        this.contract = contract;
        this.employee = employee;
        this.usedService = usedService;
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

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getAmountUnPaid() {
        return amountUnPaid;
    }

    public void setAmountUnPaid(int amountUnPaid) {
        this.amountUnPaid = amountUnPaid;
    }

    public boolean isCheckPayed() {
        return checkPayed;
    }

    public void setCheckPayed(boolean checkPayed) {
        this.checkPayed = checkPayed;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<UsedService> getUsedService() {
        return usedService;
    }

    public void setUsedService(List<UsedService> usedService) {
        this.usedService = usedService;
    }

}
