package com.e17cn2.dormitorymanagement.model;

import java.util.ArrayList;

public class Contract {
    private int id;
    private double price;
    private double createDate;
    private double deposit;
    private double waterReading;
    private double electricityReading;
    private Student student;
    private Employee employee;
    private ArrayList<BookedBed> bookedBeds;

    //region Constructors
    public Contract() {
    }

    public Contract(int id, double price, double createDate, double deposit, double waterReading, double electricityReading, Student student, Employee employee, ArrayList<BookedBed> bookedBeds) {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<BookedBed> getBookedBeds() {
        return bookedBeds;
    }

    public void setBookedBeds(ArrayList<BookedBed> bookedBeds) {
        this.bookedBeds = bookedBeds;
    }
    //endregion
}
