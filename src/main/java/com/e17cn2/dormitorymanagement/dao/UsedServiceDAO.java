package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsedServiceDAO extends DAO{
    
    
    public List<UsedService> getUsedServicesById(int key){
        List<UsedService> list=new ArrayList<UsedService>();
		String sql = "SELECT dichvusudung.soLuong,dichvusudung.kiemTra FROM dichvusudung,dichvu WHERE "
                        + "(dichvusudung.dichVuId=dichvu.id) AND dichvusudung.tblhoadonId=?;";
		try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, key);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                         UsedService usedService=new UsedService();
                         usedService.setQty(rs.getInt("soLuong"));
                         usedService.setCheckUnpaid(rs.getBoolean("kiemTra"));
                         list.add(usedService);
                    }
		}catch(Exception e){
			e.printStackTrace();
		}	
		return list;
	}
    public boolean UpdateUsedService(UsedService usedService){
	String sql = "UPDATE dichVuSuDung SET kiemTra=? WHERE id=?";
            try{
		PreparedStatement ps = con.prepareStatement(sql);
                ps.setBoolean(1, usedService.isCheckUnpaid());
		ps.setDouble(2,usedService.getId());
                
		ps.executeUpdate();
	}catch(Exception e){
            e.printStackTrace();
	}		
	return true;        
    }
}
