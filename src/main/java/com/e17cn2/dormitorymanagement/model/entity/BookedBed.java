package com.e17cn2.dormitorymanagement.model.entity;

import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.util.Date;

public class BookedBed {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Bed bedDto;

    public BookedBed() {
    }

    public BookedBed(int id, Date checkinDate, Date checkoutDate, Bed bedDto) {
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.bedDto = bedDto;
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

    public Bed getBedDto() {
        return bedDto;
    }

    public void setBedDto(Bed bedDto) {
        this.bedDto = bedDto;
    }

}
