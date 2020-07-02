package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceDAO extends DAO {
    public double getCleaningPrice() throws SQLException {
        String query = "SELECT * FROM dichvu WHERE ten LIKE 've sinh' LIMIT 1";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        return rs.getDouble(3);
    }

    public double getParkingPrice() throws SQLException {
        String query = "SELECT * FROM dichvu WHERE ten LIKE 'gui xe' LIMIT 1";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        return rs.getDouble(3);
    }
    
    public Service getServiceById(Service service){
        String query = "SELECT * FROM dichvu WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, String.valueOf(service.getId()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("ten"));
                service.setPrice(rs.getDouble("donGia"));
                service.setUnit(rs.getString("donViTinh"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        return service;
    }
    
    public Service getServiceByUsedServiceId(UsedService usedService){
        String query = "SELECT * FROM dichvu WHERE id IN (SELECT DichVuid FROM dichvusudung WHERE id = ?);";
        Service service = new Service();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, String.valueOf(usedService.getService().getId()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("ten"));
                service.setPrice(rs.getDouble("donGia"));
                service.setUnit(rs.getString("donViTinh"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        return service;
    }
}
