package com.e17cn2.dormitorymanagement.model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceDTO {
    private int id;
    private Date createdAt;
    private Date payingDate;
    private double totalAmount;
    private double amountPaid;
    private ContractDTO contract;
    private EmployeeDTO employee;
    private ArrayList<UsedServiceDTO> usedService;
    private ElectricityMeterDTO oldElectricityMeasurement;
    private ElectricityMeterDTO newElectricityMeasurement;
    private WaterMeterDTO oldWaterMeasurement;
    private WaterMeterDTO newWaterMeasurement;

    //region Constructors
    public InvoiceDTO() {
    }

    public InvoiceDTO(int id, Date createdAt, Date payingDate, double totalAmount, double amountPaid, ContractDTO contract, EmployeeDTO employee, ArrayList<UsedServiceDTO> usedService, ElectricityMeterDTO oldElectricityMeasurement, ElectricityMeterDTO newElectricityMeasurement, WaterMeterDTO oldWaterMeasurement, WaterMeterDTO newWaterMeasurement) {
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

    public ContractDTO getContract() {
        return contract;
    }

    public void setContract(ContractDTO contract) {
        this.contract = contract;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ArrayList<UsedServiceDTO> getUsedService() {
        return usedService;
    }

    public void setUsedService(ArrayList<UsedServiceDTO> usedService) {
        this.usedService = usedService;
    }

    public ElectricityMeterDTO getOldElectricityMeasurement() {
        return oldElectricityMeasurement;
    }

    public void setOldElectricityMeasurement(ElectricityMeterDTO oldElectricityMeasurement) {
        this.oldElectricityMeasurement = oldElectricityMeasurement;
    }

    public ElectricityMeterDTO getNewElectricityMeasurement() {
        return newElectricityMeasurement;
    }

    public void setNewElectricityMeasurement(ElectricityMeterDTO newElectricityMeasurement) {
        this.newElectricityMeasurement = newElectricityMeasurement;
    }

    public WaterMeterDTO getOldWaterMeasurement() {
        return oldWaterMeasurement;
    }

    public void setOldWaterMeasurement(WaterMeterDTO oldWaterMeasurement) {
        this.oldWaterMeasurement = oldWaterMeasurement;
    }

    public WaterMeterDTO getNewWaterMeasurement() {
        return newWaterMeasurement;
    }

    public void setNewWaterMeasurement(WaterMeterDTO newWaterMeasurement) {
        this.newWaterMeasurement = newWaterMeasurement;
    }
    //endregion
}
