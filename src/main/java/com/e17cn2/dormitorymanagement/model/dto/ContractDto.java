package com.e17cn2.dormitorymanagement.model.dto;

public class ContractDto {
    
    private int id;
    private double createDate;
    private double deposit;
    private double waterReading;
    private double electricityReading;
    private int studentId;
    private int employeeId;

    //region Constructors
    public ContractDto() {
    }

    public ContractDto(int id, double createDate, double deposit, double waterReading,
            double electricityReading, int studentId, int employeeId) {
        this.id = id;
        this.createDate = createDate;
        this.deposit = deposit;
        this.waterReading = waterReading;
        this.electricityReading = electricityReading;
        this.studentId = studentId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCreateDate() {
        return createDate;
    }

    public void setCreateDate(double createDate) {
        this.createDate = createDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWaterReading() {
        return waterReading;
    }

    public void setWaterReading(double waterReading) {
        this.waterReading = waterReading;
    }

    public double getElectricityReading() {
        return electricityReading;
    }

    public void setElectricityReading(double electricityReading) {
        this.electricityReading = electricityReading;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
}
