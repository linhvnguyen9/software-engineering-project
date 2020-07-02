package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.dto.BedDto;
import com.e17cn2.dormitorymanagement.model.entity.Bed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    
    public Bed findBedByBookedBedId(int id){
        Bed bed = new Bed();
        String sql = "SELECT * FROM tblgiuong" +
                     "WHERE id IN (select tblGiuongid from tblGiuongDat WHERE tblgiuongdat.id = ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                bed.setId(rs.getInt("id"));
                bed.setName(rs.getString("ma"));
                bed.setPrice(rs.getDouble("gia"));
                bed.setType(rs.getString("loai"));
                bed.setDescription(rs.getString("moTa"));
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        return bed;
    }
    
    public List<Bed> findAllBedByRoomId(int roomId){
        List<Bed> beds = new ArrayList<>();
        Bed bed;
        
        String sql = "SELECT * FROM tblgiuong WHERE tblPhongid = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(roomId));

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bed = new Bed();
                
                bed.setId(rs.getInt("id"));
                bed.setName(rs.getString("ma"));
                bed.setPrice(rs.getDouble("gia"));
                bed.setType(rs.getString("loai"));
                bed.setDescription(rs.getString("moTa"));
                
                beds.add(bed);
            }
            }catch(SQLException e) {
                e.printStackTrace();
         }
        return beds;
    }
    
    public List<Bed> getAllBedNotMonthlyBill(){
        List<BedDto> bedDtos = new ArrayList<>();
        BedDto bedDto;
        
        String sql = "SELECT * FROM `tblgiuong` WHERE tblgiuong.id IN (SELECT `tblGiuongid` FROM `tblGiuongDat` WHERE tblGiuongDat.id NOT IN" +
                     "(SELECT `tblGiuongDatid` FROM `tblhoadon` WHERE DATE_FORMAT(tblhoadon.ngayLap, '%y-%m') >= DATE_FORMAT(current_timestamp, '%y-%m')));";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bedDto = new BedDto();
                
                bedDto.setId(rs.getInt("id"));
                bedDto.setName(rs.getString("ma"));
                bedDto.setPrice(rs.getDouble("gia"));
                bedDto.setType(rs.getString("loai"));
                bedDto.setDescription(rs.getString("moTa"));
                bedDto.setRoomId(rs.getInt("tblPhongid"));
                
                if (bedDto != null) {
                    bedDtos.add(bedDto);
                }
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        return convertFromDtos(bedDtos);
    }
    
    private Bed convertFromDto(BedDto dto){
        Bed bed = new Bed();
        
        if (dto != null) {
            bed.setId(dto.getId());
            bed.setName(dto.getName());
            bed.setPrice(dto.getPrice());
            bed.setType(dto.getType());
            bed.setDescription(dto.getDescription());
            
            return bed;
        }else return null;
    }
    
    private List<Bed> convertFromDtos(List<BedDto> dtos){
        if (dtos != null){
            return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
        } else return null;
    }
}
