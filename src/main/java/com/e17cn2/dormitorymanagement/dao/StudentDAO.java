package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO extends DAO {
    public List<Student> findStudentByName(String nameQuery) throws SQLException {
        ArrayList<Student> result = new ArrayList<Student>();

        String query = "SELECT * FROM tblSinhVien WHERE ten LIKE %?%";
        PreparedStatement psmt = con.prepareStatement(query);
        psmt.setString(1, nameQuery);

        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            Student student = mapToStudent(rs);
            result.add(student);
        }
        return result;
    }

    public List<Student> findStudentByIdCard(String idCard) throws SQLException {
        ArrayList<Student> result = new ArrayList<Student>();

        String query = "SELECT * FROM tblSinhVien WHERE ten=?";
        PreparedStatement psmt = con.prepareStatement(query);
        psmt.setString(1, idCard);

        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            Student student = mapToStudent(rs);
            result.add(student);
        }
        return result;
    }

    private Student mapToStudent(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String address = rs.getString(3);
        Date dob = rs.getDate(4);
        String idCard = rs.getString(5);
        String phone = rs.getString(6);
        String school = rs.getString(7);
        String course = rs.getString(8);
        String year = rs.getString(9);

        return new Student(id, address, name, dob, idCard, phone, school, course, year);
    }
}
