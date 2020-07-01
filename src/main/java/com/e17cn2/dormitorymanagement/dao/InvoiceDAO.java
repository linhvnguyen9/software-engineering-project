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
        String sql = "INSERT INTO tblhoadon VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        InvoiceDto dto = convertToDto(invoice, bookedBed.getId());
            
        ps.setInt(1, increaseInvoiceId());
        ps.setDate(2, (java.sql.Date) dto.getCreatedAt());
        ps.setDate(3, null);
        ps.setDouble(4, dto.getTotalAmount());
        ps.setBoolean(5, dto.isCheckPayed());
        ps.setInt(6, dto.getAmountUnPaid());
        ps.setInt(7, dto.getAmountPaid());
        ps.setInt(8, dto.getContractId());
        ps.setInt(9, dto.getEmployeeId());
        ps.setInt(10, dto.getBookedBedId());
        
        return ps.execute();
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
        Date currentDate = new Date();
        
        if (invoice != null) {
            dto.setId(invoice.getId());
            dto.setCreatedAt(currentDate);
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
