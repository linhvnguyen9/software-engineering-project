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

    public ArrayList<Student> getStudent(){
        ArrayList<Student> result = new ArrayList<Student>();
        String sql = "select tblsinhvien.id, tblsinhvien.ten, tblsinhvien.cmt, tblsinhvien.sdt, \n" +
                "tblsinhvien.truong, tblsinhvien.khoa, tblsinhvien.nienKhoa,tblphong.tenPhong,\n" +
                "tblphong.kieuPhong, tblgiuong.ma, tblgiuong.loai, tblhoadon.soTienConNo\n" +
                " from tblsinhvien, tblhopdong, tblhoadon, tblgiuong,tblphong,tblgiuongdat \n" +
                " where tblsinhvien.id = tblhopdong.tblsinhvienid \n" +
                "and tblhopdong.id = tblhoadon.tblhopdongid and tblhoadon.soTienConNo>0\n" +
                "and tblhopdong.id = tblgiuongdat.tblHopDongid and tblgiuong.id = tblgiuongdat.tblGiuongid\n" +
                "and tblgiuong.tblPhongid=tblphong.id;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Student rm = new Student();
                rm.setId(rs.getInt("id"));
                rm.setName(rs.getString("ten"));
                rm.setIdCard(rs.getString("cmt"));
                rm.setPhone(rs.getString("sdt"));
                rm.setSchool(rs.getString("truong"));
                rm.setMajor(rs.getString("khoa"));
                rm.setYear(rs.getString("nienKhoa"));
                result.add(rm);
            }
        }catch(Exception e){
            e.printStackTrace();
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
