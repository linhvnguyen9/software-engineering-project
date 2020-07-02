package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsedServiceDAO extends DAO{
    
    public boolean saveUsedService(UsedService usedService, Invoice inv) throws SQLException{
        String sql = "INSERT INTO dichvusudung VALUES (?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, increaseUsedServiceId());
        ps.setDouble(2, usedService.getQty());
        ps.setInt(3, usedService.getService().getId());
        ps.setInt(4, inv.getId());
        
        return ps.execute();
    }
    
    private int increaseUsedServiceId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM dichvusudung;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        id = id + 1;
        
        return id;
    }

    public ArrayList<UsedService> getSoLuong(){
    ArrayList<UsedService> result = new ArrayList<>();
		String sql = "select dichvusudung.soluong, dichvusudung.id from dichvu,tblhoadon,dichvusudung,tblhopdong, tblsinhvien \n" +
"where dichvusudung.tblHoaDonid=tblhoadon.id and dichvu.id=dichvusudung.DichVuid\n" +
"and tblhoadon.tblHopDongid=tblHopDong.id and tblhopdong.tblSinhVienid=tblsinhvien.id\n" +
"and dichvusudung.kiemTra=1;";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
                                UsedService rm = new UsedService();
                                rm.setQty(rs.getInt("soLuong"));
                                rm.setId(rs.getInt("id"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
    }

    public List<UsedService> getUsedServicesById(int key){
        List<UsedService> list=new ArrayList<UsedService>();
        String sql = "SELECT dichvusudung.soLuong,dichvusudung.kiemTra FROM dichvusudung,dichvu WHERE "
                + "(dichvusudung.dichVuId=dichvu.id) AND dichvusudung.tblhoadonId=?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                UsedService usedService=new UsedService();
                usedService.setQty(rs.getInt("soLuong"));
                usedService.setCheckUnpaid(rs.getBoolean("kiemTra"));
                list.add(usedService);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean UpdateUsedService(UsedService usedService){
        String sql = "UPDATE dichVuSuDung SET kiemTra=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, usedService.isCheckUnpaid());
            ps.setDouble(2,usedService.getId());

            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}

