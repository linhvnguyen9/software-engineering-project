package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
