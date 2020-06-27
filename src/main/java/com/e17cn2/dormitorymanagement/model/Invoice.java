package com.e17cn2.dormitorymanagement.model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private int id;
    private Date createdAt;
    private Date payingDate;
    private double totalAmount;
    private double amountPaid;
    private Contract contract;
    private Employee employee;
    private ArrayList<UsedService> usedService;
    private ElectricityMeter oldElectricityMeasurement;
    private ElectricityMeter newElectricityMeasurement;
    private WaterMeter oldWaterMeasurement;
    private WaterMeter newWaterMeasurement;

    //region Constructors
    public Invoice() {
    }

    public Invoice(int id, Date createdAt, Date payingDate, double totalAmount, double amountPaid, Contract contract, Employee employee, ArrayList<UsedService> usedService, ElectricityMeter oldElectricityMeasurement, ElectricityMeter newElectricityMeasurement, WaterMeter oldWaterMeasurement, WaterMeter newWaterMeasurement) {
        this.id = id;
        this.createdAt = createdAt;
        this.payingDate = payingDate;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.contract = contract;
        this.employee = employee;
        this.usedService = usedService;
        this.oldElectricityMeasurement = oldElectricityMeasurement;
        this.newElectricityMeasurement = newElectricityMeasurement;
        this.oldWaterMeasurement = oldWaterMeasurement;
        this.newWaterMeasurement = newWaterMeasurement;
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

    public ArrayList<UsedService> getUsedService() {
        return usedService;
    }

    public void setUsedService(ArrayList<UsedService> usedService) {
        this.usedService = usedService;
    }

    public ElectricityMeter getOldElectricityMeasurement() {
        return oldElectricityMeasurement;
    }

    public void setOldElectricityMeasurement(ElectricityMeter oldElectricityMeasurement) {
        this.oldElectricityMeasurement = oldElectricityMeasurement;
    }

    public ElectricityMeter getNewElectricityMeasurement() {
        return newElectricityMeasurement;
    }

    public void setNewElectricityMeasurement(ElectricityMeter newElectricityMeasurement) {
        this.newElectricityMeasurement = newElectricityMeasurement;
    }

    public WaterMeter getOldWaterMeasurement() {
        return oldWaterMeasurement;
    }

    public void setOldWaterMeasurement(WaterMeter oldWaterMeasurement) {
        this.oldWaterMeasurement = oldWaterMeasurement;
    }

    public WaterMeter getNewWaterMeasurement() {
        return newWaterMeasurement;
    }

    public void setNewWaterMeasurement(WaterMeter newWaterMeasurement) {
        this.newWaterMeasurement = newWaterMeasurement;
    }
    //endregion
}
