package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.dto.EmployeeDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends DAO{

    public EmployeeDAO() {
        super();
    }
    
    public boolean checkLogin(EmployeeDTO employeeDto){
        boolean result = false;
        
        String sql = "SELECT ten, chucVu FROM tblNhanVien WHERE tenTaiKhoan = ? AND matKhau = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employeeDto.getUsername());
            ps.setString(2, employeeDto.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
		employeeDto.setName(rs.getString("ten"));
		employeeDto.setRole(rs.getString("chucVu"));
	
                result = true;
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
	return result;
    }
}
