package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServiceDAO extends DAO{
    public ArrayList<Service> getService(){
		ArrayList<Service> result = new ArrayList<Service>();
		String sql = "SELECT * FROM dichVu;";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Service service=new Service();
				service.setId(rs.getInt("id"));
				service.setName(rs.getString("ten"));
                                service.setPrice(rs.getDouble("donGia"));
                                service.setUnit(rs.getString("donViTinh"));
				result.add(service);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}

}
