package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InvoiceDAO {
    //Lay 2 chi so dien gan nhat
    //select * from cnpm.tbldonghodien where tblPhongid IN 
    //(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = ?)) 
    //order by (ngayLaySo) DESC limit 2;
    
    //Lay 2 chi so nuoc gan nhat
    //select * from cnpm.tbldonghonuoc where tblPhongid IN 
    //(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = ?)) 
    //order by (ngayLaySo) DESC limit 2;
    
    //tim giuong dat chua len hoa don thang nay
    //select * from tblgiuong 
    //where id IN 
    //(select tblGiuongid from tblGiuongDat where id NOT IN (select tblGiuongDatid from tblhoadon where DATE_FORMAT(tblhoadon.ngayLap, '%y-%m') >= DATE_FORMAT(current_timestamp, '%y-%m')));
    
    
    //lay thong tin phong cua giuongdat
    //select * from tblPhong where id IN(select tblPhongid from tblgiuong,tblgiuongdat where tblgiuong.id = tblgiuongdat.tblGiuongid);
    
    //Lay thong tin cua giuong
    //select * from tblgiuong 
    //where id IN (select tblGiuongid from tblGiuongDat);
    
    //Lay thong tin sinh vien
    //select * from tblsinhvien 
    //where id IN (select tblHopDong.tblSinhVienid FROM tblHopDong,tblGiuongDat where tblHopDong.id = tblGiuongDat.tblHopDongid and tblGiuongDat.id = ?);
    
    //Lay tong so tien con no cua cac hoa don truoc
    //select sum(soTienConNo) from tblhoadon where tblGiuongDatid = ?;
    
    //Insert into tblhoadon values(?,?,?,?,?,?,?);
}
