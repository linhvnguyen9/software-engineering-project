package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.Bed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BedDAO extends DAO {
    public BedDAO() {
        super();
    }
        /**
     * @param maxPrice    Maximum price of Bed
     * @param checkinDate Starting date
     * @return Map with Bed and Room name of Bed
     */
    public Map<Bed, String> findAvailableBeds(Double maxPrice, Date checkinDate) throws SQLException {
        HashMap<Bed, String> result = new HashMap<>();

        String query = "SELECT tblgiuong.id, tblphong.tenPhong, tblgiuong.ma, tblgiuong.loai, tblgiuong.gia, tblgiuong.moTa " +
                "FROM tblphong, tblgiuong " +
                "WHERE tblphong.id=tblgiuong.tblPhongid " +
                "AND tblgiuong.gia <= ?" +
                "AND tblgiuong.id NOT IN (" +
                "SELECT tblGiuongid " +
                "FROM tblgiuongdat " +
                "WHERE (ngayNhanGiuong < ? " +
                "AND ngayTraGiuong > ?) OR (ngayNhanGiuong < ? AND ngayTraGiuong is null))";
        PreparedStatement psmt = con.prepareStatement(query);

        java.sql.Date sqlCheckinDate = new java.sql.Date(checkinDate.getTime());

        psmt.setDouble(1, maxPrice);
        psmt.setDate(2, sqlCheckinDate);
        psmt.setDate(3, sqlCheckinDate);
        psmt.setDate(4, sqlCheckinDate);

        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String roomName = rs.getString(2);
            String bedName = rs.getString(3);
            String bedType = rs.getString(4);
            double bedPrice = rs.getDouble(5);
            String bedDesc = rs.getString(6);

            Bed bed = new Bed(id, bedPrice, bedName, bedDesc, bedType);
            result.put(bed, roomName);
        }

        return result;
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
    public Bed getBedByInvoiceId(int key){
        Bed bed=new Bed();
	String sql = "SELECT tblGiuong.id,tblGiuong.gia,tblGiuong.ma,tblGiuong.mota,tblGiuong.loai\n"
                    + "FROM tblHoaDon,tblGiuongDat,tblGiuong WHERE tblHoaDon.tblGiuongDatid=tblGiuongDat.id AND "
                    + "tblGiuongDat.tblGiuongid=tblGiuong.id AND tblhoadon.id = ?";
            try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, key);
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
                    bed.setId(rs.getInt("id"));
                    bed.setPrice(rs.getDouble("gia"));
                    bed.setDescription(rs.getString("mota"));
                    bed.setType(rs.getString("loai"));
                    bed.setName(rs.getString("ma"));
		}
            }catch(Exception e){
		e.printStackTrace();
            }	
	return bed;
    }
}
