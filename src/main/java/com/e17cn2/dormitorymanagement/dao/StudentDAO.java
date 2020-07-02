package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO extends DAO{
    
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
     
    
	
    
}
