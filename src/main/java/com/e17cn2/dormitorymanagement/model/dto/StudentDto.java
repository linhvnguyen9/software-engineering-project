package com.e17cn2.dormitorymanagement.model.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblsinhvien")
public class StudentDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "queQuan")
    private String homeTown;
    
    @Column(name = "ten")
    private String name;
    
    @Column(name = "ngayThangNamSinh")
    private Date dob;
    
    @Column(name = "cmt")
    private String idCard;
    
    @Column(name = "sdt")
    private String phone;
    
    @Column(name = "truong")
    private String school;
    
    @Column(name = "nienKhoa")
    private String year;
    
    @Column(name = "khoa")
    private String major;

    //region Constructors
    public StudentDto() {
    }

    
    //endregion

    public StudentDto(int id, String homeTown, String name, Date dob, String idCard, 
            String phone, String school, String year, String major) {
        this.id = id;
        this.homeTown = homeTown;
        this.name = name;
        this.dob = dob;
        this.idCard = idCard;
        this.phone = phone;
        this.school = school;
        this.year = year;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    
}
