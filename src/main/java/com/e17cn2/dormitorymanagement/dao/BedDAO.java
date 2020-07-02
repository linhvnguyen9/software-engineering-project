package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BedDAO {

    public BedDAO() {
        super();
    }
     
      public ArrayList<Bed> getBed(){
		ArrayList<Bed> result = new ArrayList<Bed>();
		String sql = "select distinct tblgiuong.ma, tblgiuong.loai\n" +
"from tblsinhvien, tblhopdong, tblhoadon, tblgiuong,tblphong,tblgiuongdat \n" +
"where tblsinhvien.id = tblhopdong.tblsinhvienid \n" +
"and tblhopdong.id = tblhoadon.tblhopdongid and tblhoadon.soTienConNo>0\n" +
"and tblhopdong.id = tblgiuongdat.tblHopDongid and tblgiuong.id = tblgiuongdat.tblGiuongid;";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Bed rm = new Bed();
                                rm.setName(rs.getString("ma"));
                                rm.setType(rs.getString("loai"));
				result.add(rm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}

}
