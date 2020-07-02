package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.InvoiceDto;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
