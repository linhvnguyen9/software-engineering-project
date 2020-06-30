package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.InvoiceDTO;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InvoiceDAO extends DAO{
    public InvoiceDAO() {
		super();
	}
    public ArrayList<Invoice> searchInvoice(String key){
		ArrayList<Invoice> result = new ArrayList<Invoice>();
		String sql = "SELECT * FROM cnpm.tblHoadon WHERE id LIKE ?";
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
}
