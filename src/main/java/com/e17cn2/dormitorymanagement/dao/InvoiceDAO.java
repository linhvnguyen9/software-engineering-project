package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InvoiceDAO {
    //select * from cnpm.tbldonghodien where tblPhongid IN 
    //(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = 1)) 
    //order by (ngayLaySo) DESC limit 2;
    
    //select * from cnpm.tbldonghonuoc where tblPhongid IN 
    //(SELECT tblPhongid FROM cnpm.tblgiuong WHERE id IN (SELECT tblGiuongid FROM tblgiuongdat WHERE id = 1)) 
    //order by (ngayLaySo) DESC limit 2;
    //
    
    //
}
