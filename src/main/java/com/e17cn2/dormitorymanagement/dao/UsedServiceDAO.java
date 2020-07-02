package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsedServiceDAO extends DAO{
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

