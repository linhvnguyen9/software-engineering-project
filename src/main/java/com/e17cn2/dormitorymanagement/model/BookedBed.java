package com.e17cn2.dormitorymanagement.model;

import java.util.Date;

public class BookedBed {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Date totalPrice;
    private Bed bed;

    public BookedBed() {
    }

    public BookedBed(int id, Date checkinDate, Date checkoutDate, Date totalPrice, Bed bed) {
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.totalPrice = totalPrice;
        this.bed = bed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Date totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
