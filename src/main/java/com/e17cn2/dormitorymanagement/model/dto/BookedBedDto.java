package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;

public class BookedBedDto {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private int bedId;
    private int contractId;

    public BookedBedDto() {
    }

    public BookedBedDto(int id, Date checkinDate, Date checkoutDate, int bedId, 
            int contractId) {
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.bedId = bedId;
        this.contractId = contractId;
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

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }
}
