package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
                                rm.setQuantity(rs.getInt("soLuong"));
                                rm.setId(rs.getInt("id"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
    }
      }

