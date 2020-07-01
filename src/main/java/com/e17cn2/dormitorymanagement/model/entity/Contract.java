package com.e17cn2.dormitorymanagement.model.entity;

import java.util.Date;
import java.util.List;

public class Contract {
    private int id;
    private Date createDate;
    private double deposit;
    private WaterMeter waterReading;
    private ElectricityMeter electricityReading;
    private Student student;
    private Employee employee;
    private List<BookedBed> bookedBeds;

    //region Constructors
    public Contract() {
    }

    public Contract(int id, Date createDate, double deposit,
            WaterMeter waterReading, ElectricityMeter electricityReading, Student student,
            Employee employee, List<BookedBed> bookedBeds) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public WaterMeter getWaterReading() {
        return waterReading;
    }

    public void setWaterReading(WaterMeter waterReading) {
        this.waterReading = waterReading;
    }

    public ElectricityMeter getElectricityReading() {
        return electricityReading;
    }

    public void setElectricityReading(ElectricityMeter electricityReading) {
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

    public List<BookedBed> getBookedBeds() {
        return bookedBeds;
    }

    public void setBookedBeds(List<BookedBed> bookedBeds) {
        this.bookedBeds = bookedBeds;
    }
    //endregion
}
