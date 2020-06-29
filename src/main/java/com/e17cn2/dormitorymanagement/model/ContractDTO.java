package com.e17cn2.dormitorymanagement.model;

import java.util.ArrayList;

public class ContractDTO {
    private int id;
    private double price;
    private double createDate;
    private double deposit;
    private double waterReading;
    private double electricityReading;
    private StudentDTO student;
    private EmployeeDTO employee;
    private ArrayList<BookedBedDTO> bookedBeds;

    //region Constructors
    public ContractDTO() {
    }

    public ContractDTO(int id, double price, double createDate, double deposit, double waterReading, double electricityReading, StudentDTO student, EmployeeDTO employee, ArrayList<BookedBedDTO> bookedBeds) {
        this.id = id;
        this.price = price;
        this.createDate = createDate;
        this.deposit = deposit;
        this.waterReading = waterReading;
        this.electricityReading = electricityReading;
        this.student = student;
        this.employee = employee;
        this.bookedBeds = bookedBeds;
    }
    //endregion

    //region Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ArrayList<BookedBedDTO> getBookedBeds() {
        return bookedBeds;
    }

    public void setBookedBeds(ArrayList<BookedBedDTO> bookedBeds) {
        this.bookedBeds = bookedBeds;
    }
    //endregion
}
