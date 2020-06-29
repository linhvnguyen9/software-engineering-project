package com.e17cn2.dormitorymanagement.model.entity;

import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblgiuongdat")
public class BookedBed {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ngayNhanGiuong")
    private Date checkinDate;
    
    @Column(name = "ngayTraGiuong")
    private Date checkoutDate;
    
    @Column(name = "tblGiuongid")
    private int bedId;
    
    @Column(name = "tblHopDongid")
    private int contractId;

    public BookedBed() {
    }

    public BookedBed(int id, Date checkinDate, Date checkoutDate, int bedId, 
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
