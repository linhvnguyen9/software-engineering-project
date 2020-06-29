package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.Bed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BedDAO extends DAO {
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

            Bed bed = new Bed(id, bedPrice, bedDesc, bedType); //TODO: Pull code from git to get Bed with bedName
            result.put(bed, roomName);
        }

        return result;
    }
}
