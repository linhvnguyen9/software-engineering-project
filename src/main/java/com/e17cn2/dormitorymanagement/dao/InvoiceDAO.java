package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.InvoiceDTO;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAO extends DAO{
    public InvoiceDAO() {
		super();
	}
    public ArrayList<Invoice> searchInvoice(String key){
		ArrayList<Invoice> result = new ArrayList<Invoice>();
		String sql = "SELECT * FROM cnpm.tblHoadon WHERE daThanhToan=0 AND id LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
                                
				Invoice rm = new Invoice();
				rm.setId(rs.getInt("id"));
				
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
    
    
    
    public Invoice getInvoiceById(int key){
        Invoice invoice=new Invoice();
		String sql = "SELECT * FROM cnpm.tblhoadon WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
                           invoice.setId(rs.getInt("id"));
                           invoice.setCreatedAt(rs.getDate("ngayLap"));
                           invoice.setAmountUnPaid(rs.getInt("soTienConNo"));
                           invoice.setTotalAmount(rs.getDouble("tongTien"));
                           invoice.setBookedBedId(rs.getInt("tblGiuongDatid"));
                           invoice.setContractId(rs.getInt("tblHopDongid"));
                           invoice.setEmployeeId(rs.getInt("tblNhanVienid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return invoice;
    }
    public void UpdateInvoice(Invoice invoice){
		String sql = "UPDATE tblHoaDon SET tongtien=?,daThanhToan=?,soTienConNo=?,tienDaNhan=? WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setDouble(1,invoice.getTotalAmount());
                        if (invoice.isCheckPayed()==true) 
                            ps.setInt(2,1);
                        else ps.setInt(2,0);
                        
                        ps.setDouble(3,invoice.getAmountUnPaid());
                        ps.setDouble(4,invoice.getAmountPaid());
                        ps.setInt(5,invoice.getId());
			ResultSet rs = ps.executeQuery();

			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
    
}
