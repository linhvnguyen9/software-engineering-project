package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends DAO{

    public EmployeeDAO() {
        super();
    }
    
    public boolean checkLogin(Employee employee){
        boolean result = false;

        String sql = "SELECT id, ten, chucVu FROM tblNhanVien WHERE tenTaiKhoan = ? AND matKhau = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("ten"));
		employee.setRole(rs.getString("chucVu"));
	
                result = true;
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
	return result;
    }
}
