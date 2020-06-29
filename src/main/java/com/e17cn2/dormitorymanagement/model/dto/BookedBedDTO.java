package com.e17cn2.dormitorymanagement.model.dto;

import com.e17cn2.dormitorymanagement.model.dto.BedDTO;
import java.util.Date;

public class BookedBedDTO {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private BedDTO bedDto;

    public BookedBedDTO() {
    }

    public BookedBedDTO(int id, Date checkinDate, Date checkoutDate, 
                         BedDTO bedDto) {
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

    public BedDTO getBedDto() {
        return bedDto;
    }

    public void setBedDto(BedDTO bedDto) {
        this.bedDto = bedDto;
    }

}
