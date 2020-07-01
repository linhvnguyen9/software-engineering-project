package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContractDAO extends DAO{
    
    public Student getStudentById(int id) throws SQLException{
        Student student=new Student();
	String sql = "SELECT * FROM tblSinhVien WHERE id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
 
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("ten"));
            student.setHomeTown(rs.getString("queQuan"));
            student.setDob(rs.getDate("ngaythangnamsinh"));
            student.setPhone(rs.getString("sdt"));
            student.setSchool(rs.getString("truong"));
            student.setYear(rs.getString("khoa"));
        }
        

        return student;
    }
}
