package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO extends DAO{
    public Student getStudentByInvoiceId(int key){
        Student student=new Student();
		String sql = "select tblsinhvien.id,tblsinhvien.ten,tblsinhvien.quequan,"
                        + "tblsinhvien.sdt,tblsinhvien.ngaythangnamsinh,tblsinhvien.truong,tblsinhvien.khoa, "
                        + "tblSinhVien.cmt from tblhoadon,tblhopdong,tblsinhvien where tblhoadon.tblhopdongid=tblHopDong.id "
                        + "and tblsinhvien.id=tblhopdong.tblSinhVienid and tblhoadon.id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
                            student.setId(rs.getInt("id"));
                            student.setDob(rs.getDate("ngaythangnamsinh"));
                            
                            student.setHomeTown(rs.getString("quequan"));
                            student.setName(rs.getString("ten"));
                            student.setPhone(rs.getString("sdt"));
                            student.setYear(rs.getString("khoa"));
                            student.setSchool(rs.getString("truong"));
                            student.setIdCard(rs.getString("cmt"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return student;
	}

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
