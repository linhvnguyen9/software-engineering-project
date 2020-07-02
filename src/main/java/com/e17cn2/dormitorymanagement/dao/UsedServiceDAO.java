package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsedServiceDAO extends DAO{
    
    public boolean saveUsedService(UsedService usedService, Invoice inv) throws SQLException{
        String sql = "INSERT INTO dichvusudung VALUES (?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, increaseUsedServiceId());
        ps.setDouble(2, usedService.getQty());
        ps.setInt(3, usedService.getService().getId());
        ps.setInt(4, inv.getId());
        
        return ps.execute();
    }
    
    private int increaseUsedServiceId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM dichvusudung;";
        
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
}
