package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
