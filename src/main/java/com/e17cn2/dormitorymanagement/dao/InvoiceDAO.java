package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;

import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InvoiceDAO extends DAO {
    public ArrayList<Invoice> getInvoice() {
        ArrayList<Invoice> result = new ArrayList<Invoice>();
        String sql = "select distinct tblhoadon.soTienConNo, tblhoadon.id\n" +
                "from tblsinhvien, tblhopdong, tblhoadon, tblgiuong,tblphong,tblgiuongdat \n" +
                "where tblsinhvien.id = tblhopdong.tblsinhvienid \n" +
                "and tblhopdong.id = tblhoadon.tblhopdongid and tblhoadon.soTienConNo>0;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Invoice rm = new Invoice();
                rm.setAmountUnPaid(rs.getDouble("soTienConNo"));
                rm.setId(rs.getInt("id"));
                result.add(rm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Invoice> getDatePay(Student student) {
        ArrayList<Invoice> result = new ArrayList<>();
        String sql = "select distinct tblhoadon.id,tblhoadon.ngaythanhtoan from dichvu, tblhoadon,\n" +
                "		dichvusudung, tblhopdong, tblsinhvien\n" +
                "where dichvusudung.tblHoaDonid=tblhoadon.id and dichvu.id=dichvusudung.DichVuid\n" +
                "and tblhoadon.tblHopDongid=tblHopDong.id and tblhopdong.tblSinhVienid=tblsinhvien.id \n" +
                "and dichvusudung.kiemTra=1 and tblsinhvien.id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Invoice rm = new Invoice();
                rm.setId(rs.getInt("id"));
                rm.setPayingDate(rs.getDate("ngayThanhToan"));
                result.add(rm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}