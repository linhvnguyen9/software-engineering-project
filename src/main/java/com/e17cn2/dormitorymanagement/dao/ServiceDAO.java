package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceDAO extends DAO {
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

    public ArrayList<Service> getServices(){
        ArrayList<Service> result = new ArrayList<>();
        String sql = "select dichvu.ten, dichvu.donGia from dichvu, tblhoadon,\n" +
                "		dichvusudung, tblhopdong, tblsinhvien\n" +
                "where dichvu.id=dichvusudung.DichVuid and dichvusudung.tblHoaDonid=tblhoadon.id\n" +
                "and tblhoadon.tblHopDongid=tblHopDong.id and tblhopdong.tblSinhVienid=tblsinhvien.id "
                + "and dichvusudung.kiemTra=1;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Service rm = new Service();
                rm.setName(rs.getString("ten"));
                rm.setPrice(rs.getDouble("donGia"));
                result.add(rm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Service> getServiceByStudent(int idStudent, int idInvoice ){
        ArrayList<Service> result = new ArrayList<>();
        String sql = "select dichvu.ten,dichvu.donGia from dichvu,tblhoadon,dichvusudung,tblhopdong, tblsinhvien \n" +
                "where dichvusudung.tblHoaDonid=tblhoadon.id and dichvu.id=dichvusudung.DichVuid\n" +
                "and tblhoadon.tblHopDongid=tblHopDong.id and tblhopdong.tblSinhVienid=tblsinhvien.id\n" +
                "and dichvusudung.kiemTra=1 and tblSinhvien.id =? and tblhoadon.id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);


            ps.setInt(1,idStudent);
            ps.setInt(2,idInvoice);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Service rm = new Service();
                rm.setName(rs.getString("ten"));
                rm.setPrice(rs.getDouble("donGia"));
                result.add(rm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
