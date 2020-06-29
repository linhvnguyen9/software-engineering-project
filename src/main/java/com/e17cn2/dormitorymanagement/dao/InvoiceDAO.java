package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.InvoiceDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InvoiceDAO {
//    public ArrayList<InvoiceDTO> searchInvoice(String key){
//		ArrayList<InvoiceDTO> result = new ArrayList<InvoiceDTO>();
//		String sql = "SELECT * FROM tblhoadon WHERE id LIKE ?";
//		try{
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, "%" + key + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while(rs.next()){
//				InvoiceDTO rm = new InvoiceDTO();
//				rm.setId(rs.getInt("id"));
//				rm.setStudent(rs.getString("name"));
//				rm.setType(rs.getString("type"));
//				rm.setPrice(rs.getFloat("price"));
//				rm.setDes(rs.getString("des"));
//				result.add(rm);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}	
//		return result;
//	}
}
