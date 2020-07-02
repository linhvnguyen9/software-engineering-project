package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public boolean saveContract(Contract contract) throws SQLException {
        String query = "INSERT INTO tblhopdong VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = con.prepareStatement(query);

        Date currentDate = new Date();
        double deposit = contract.getDeposit();
        int studentId = contract.getStudent().getId();
        int employeeId = contract.getEmployee().getId();
        int electricityMeterId = contract.getElectricityReading().getId();
        int waterMeterId = contract.getWaterReading().getId();

        psmt.setDate(1, new java.sql.Date(currentDate.getTime()));
        psmt.setDouble(2, deposit);
        psmt.setInt(3, studentId);
        psmt.setInt(4, employeeId);
        psmt.setInt(5, electricityMeterId);
        psmt.setInt(6, waterMeterId);

        return psmt.execute();
    }
}
