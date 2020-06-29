package com.e17cn2.dormitorymanagement.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblhoadon")
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ngayLap")
    private Date createdAt;
    
    @Column(name = "ngayThanhToan")
    private Date payingDate;
    
    @Column(name = "tongTien")
    private double totalAmount;
    
    @Column(name = "tienDaNhan")
    private double amountPaid;
    
    @Column(name = "daThanhToan")
    private boolean checkPayed;
    
    @Column(name = "soTienConNo")
    private double amountUnPaid;
  
    private Contract contract;
    
    private Employee employee;
    
    private BookedBed BookedBed;

    //region Constructors
    public Invoice() {
    }

    public Invoice(int id, Date createdAt, Date payingDate, double totalAmount, 
            double amountPaid, boolean checkPayed, double amountUnPaid, 
            Contract contract, Employee employee, BookedBed BookedBed) {
        this.id = id;
        this.createdAt = createdAt;
        this.payingDate = payingDate;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.checkPayed = checkPayed;
        this.amountUnPaid = amountUnPaid;
        this.contract = contract;
        this.employee = employee;
        this.BookedBed = BookedBed;
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

    public BookedBed getBookedBed() {
        return BookedBed;
    }

    public void setBookedBed(BookedBed BookedBed) {
        this.BookedBed = BookedBed;
    }
    
    //endregion
}
