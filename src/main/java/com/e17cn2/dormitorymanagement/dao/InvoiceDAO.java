package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.InvoiceDto;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceDAO extends DAO{
    
    public boolean saveMonthlyInvoice(Invoice invoice, BookedBed bookedBed) throws SQLException{
        String sql = "INSERT INTO tblhoadon VALUES (null,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        Date currentDate = new Date();
        InvoiceDto dto = convertToDto(invoice, bookedBed.getId());
        
        ps.setDate(1, new java.sql.Date(currentDate.getTime()));
        ps.setDate(2, null);
        ps.setDouble(3, dto.getTotalAmount());
        ps.setBoolean(4, dto.isCheckPayed());
        ps.setInt(5, 0);
        ps.setInt(6, 0);
        ps.setInt(7, dto.getContractId());
        ps.setInt(8, dto.getEmployeeId());
        ps.setInt(9, dto.getBookedBedId());
        
        return ps.execute();
    }
    
    public Invoice findAllAmountUnPaidByBookedBedId(BookedBed bookedBed){
        String sql = "SELECT sum(tienDaNhan),sum(soTienConNo) FROM tblhoadon WHERE tblGiuongDatid = ?;";
        Invoice invoice = new Invoice();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(bookedBed.getId()));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                invoice.setAmountPaid(rs.getInt(1));
                invoice.setAmountUnPaid(rs.getInt(2));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        return invoice;
    }
    
    public int increaseInvoiceId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tblhoadon;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        id = id + 1;
        
        return id;
    }
    
    private InvoiceDto convertToDto(Invoice invoice, int bookedBedId){
        InvoiceDto dto = new InvoiceDto();
        
        if (invoice != null) {
            dto.setId(invoice.getId());
            dto.setCreatedAt(dto.getCreatedAt());
            dto.setPayingDate(null);
            dto.setTotalAmount(invoice.getTotalAmount());
            dto.setCheckPayed(false);
            dto.setAmountUnPaid(invoice.getAmountUnPaid());
            dto.setAmountPaid(invoice.getAmountPaid());
            dto.setContractId(invoice.getContract().getId());
            dto.setEmployeeId(invoice.getEmployee().getId());
            dto.setBookedBedId(bookedBedId);
            
            return dto;
        }else return null;
    }

    public ArrayList<Invoice> searchInvoice(String key) {
        ArrayList<Invoice> result = new ArrayList<Invoice>();
        String sql = "SELECT * FROM cnpm.tblHoadon WHERE daThanhToan=0 AND id LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Invoice rm = new Invoice();
                rm.setId(rs.getInt("id"));
                result.add(rm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Invoice getInvoiceById(int key) {
        Invoice invoice = new Invoice();
        String sql = "SELECT * FROM cnpm.tblhoadon WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                invoice.setId(rs.getInt("id"));
                invoice.setCreatedAt(rs.getDate("ngayLap"));
                invoice.setAmountUnPaid(rs.getInt("soTienConNo"));
                invoice.setTotalAmount(rs.getDouble("tongTien"));
//                    invoice.setBookedBedId(rs.getInt("tblGiuongDatid"));
//                    invoice.setContractId(rs.getInt("tblHopDongid"));
//                    invoice.setEmployeeId(rs.getInt("tblNhanVienid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public boolean UpdateInvoice(Invoice invoice) {
        String sql = "UPDATE tblHoaDon SET tongtien=?,daThanhToan=?,soTienConNo=?,tienDaNhan=?,ngayThanhToan=? WHERE id=?";

        try {
            Date currentDate = new Date();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, invoice.getTotalAmount());
            if (invoice.isCheckPayed() == true)
                ps.setBoolean(2, true);
            else ps.setBoolean(2, false);

            ps.setDouble(3, invoice.getAmountUnPaid());
            ps.setDouble(4, invoice.getAmountPaid());
            ps.setDate(5, new java.sql.Date(currentDate.getTime()));
            ps.setInt(6, invoice.getId());


            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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
}
