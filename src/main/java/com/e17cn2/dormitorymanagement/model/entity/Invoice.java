package com.e17cn2.dormitorymanagement.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private int id;
    private Date createdAt;
    private Date payingDate;
    private double totalAmount;
    private double amountPaid;
    private double amountUnPaid;
    private boolean checkPayed;
    private Contract contract;
    private Employee employee;
    private ArrayList<UsedService> usedService;

    //region Constructors
    public Invoice() {
    }

    public Invoice(int id, Date createdAt, Date payingDate, double totalAmount, 
            double amountPaid, double amountUnPaid, boolean checkPayed, Contract
            contract, Employee employee, ArrayList<UsedService> usedService) {
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
    //endregion

    //region Getters and setters
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getAmountUnPaid() {
        return amountUnPaid;
    }

    public boolean isCheckPayed() {
        return checkPayed;
    }

    public Contract getContract() {
        return contract;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ArrayList<UsedService> getUsedService() {
        return usedService;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setPayingDate(Date payingDate) {
        this.payingDate = payingDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setAmountUnPaid(double amountUnPaid) {
        this.amountUnPaid = amountUnPaid;
    }

    public void setCheckPayed(boolean checkPayed) {
        this.checkPayed = checkPayed;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUsedService(ArrayList<UsedService> usedService) {
        this.usedService = usedService;
    }


}
