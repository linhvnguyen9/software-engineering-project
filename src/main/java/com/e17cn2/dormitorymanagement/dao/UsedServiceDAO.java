package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsedServiceDAO extends DAO{
    public ArrayList<Service> getServiceById(int key){
		ArrayList<Service> result = new ArrayList<Service>();
		String sql = "SELECT * FROM dichvusudung,dichvu WHERE (dichvusudung.dichVuId=dichvu.id) AND dichvusudung.tblhoadonId=?;";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, key);
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
    public List<UsedService> getQuantityById(int key){
        List<UsedService> list=new ArrayList<UsedService>();
		String sql = "SELECT dichvusudung.soLuong FROM dichvusudung,dichvu WHERE "
                        + "(dichvusudung.dichVuId=dichvu.id) AND dichvusudung.tblhoadonId=?;";
		try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, key);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                         UsedService usedService=new UsedService();
                         usedService.setQuantity(rs.getInt("soLuong"));
                         list.add(usedService);
                    }
		}catch(Exception e){
			e.printStackTrace();
		}	
		return list;
	}
}
