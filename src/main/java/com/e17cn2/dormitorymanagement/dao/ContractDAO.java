package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.entity.*;
import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class ContractDAO extends DAO {
    public static void main(String[] args) throws SQLException {
        ContractDAO contractDAO = new ContractDAO();
        ArrayList<BookedBed> bookedBeds = new ArrayList<>();
        bookedBeds.add(new BookedBed(0, new Date(), null, new Bed(4, 1200.0, "B2", "", "tang tren", "101", 1)));
        contractDAO.saveContract(
                new Contract(0,
                        new Date(),
                        1000,
                        new WaterMeter(0, 170.0f, new Date(), null),
                        new ElectricityMeter(0, 660.0f, new Date(), null),
                        new Student(4, "Ha Noi", "Pham Phi Long", null, "012345676", "012345676", "PTIT", "2017-2022", "CNTT"),
                        new Employee(2, "Mai Thanh Tung", "manager", "quanly", "quanly"),
                        bookedBeds
                )
        );
    }

    public Student getStudentById(int id) throws SQLException{
        Student student=new Student();
        String sql = "SELECT * FROM tblSinhVien WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("ten"));
            student.setHomeTown(rs.getString("queQuan"));
            student.setDob(rs.getDate("ngaythangnamsinh"));
            student.setPhone(rs.getString("sdt"));
            student.setSchool(rs.getString("truong"));
            student.setYear(rs.getString("khoa"));
        }

        return student;
    }

    public boolean saveContract(Contract contract) throws SQLException {
        String checkBookedBedStillAvailableQuery =
                "SELECT tblgiuong.id " +
                        "FROM tblphong, tblgiuong " +
                        "WHERE tblphong.id=tblgiuong.tblPhongid " +
                        "AND tblgiuong.id NOT IN (" +
                        "SELECT tblGiuongid " +
                        "FROM tblgiuongdat " +
                        "WHERE (ngayNhanGiuong <= ? " +
                        "AND ngayTraGiuong >= ?) OR (ngayNhanGiuong <= ? AND ngayTraGiuong is null))";
        PreparedStatement preparedStatement = con.prepareStatement(checkBookedBedStillAvailableQuery);
        preparedStatement.setDate(1, new java.sql.Date(contract.getCreateDate().getTime()));
        preparedStatement.setDate(2, new java.sql.Date(contract.getCreateDate().getTime()));
        preparedStatement.setDate(3, new java.sql.Date(contract.getCreateDate().getTime()));

        System.out.println("Contract's creation date " + contract.getCreateDate());
        //Ignoring case where price changes during time when we create contract
        ResultSet rs = preparedStatement.executeQuery();

        HashSet<Integer> availableBedId = new HashSet<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            availableBedId.add(id);
            System.out.println("Available bed: " + id);
        }

        for (BookedBed bed : contract.getBookedBeds()) {
            System.out.println("Bed id" + bed.getBedDto().getId());
            if (!availableBedId.contains(bed.getBedDto().getId())) {
                System.out.println("One of the beds is booked during contract creation time");
                return false;
            }
        }

        //Assuming that all beds booked in contract belongs to the same room
        WaterMeter waterReading = contract.getWaterReading();
        String waterMeter = "INSERT INTO tbldonghonuoc VALUES (null, ?, ?, ?)";
        PreparedStatement psmt1 = con.prepareStatement(waterMeter, Statement.RETURN_GENERATED_KEYS);
        psmt1.setDouble(1, waterReading.getCurrentReading());
        psmt1.setDate(2, new java.sql.Date(new Date().getTime()));
        psmt1.setInt(3, contract.getBookedBeds().get(0).getBedDto().getRoomId());
        psmt1.executeUpdate();
        ResultSet result1 = psmt1.getGeneratedKeys();
        result1.next();
        int waterId = result1.getInt(1);
        System.out.println(waterId);

        ElectricityMeter electricityReading = contract.getElectricityReading();
        String electricityMeter = "INSERT INTO tbldonghodien VALUES (null, ?, ?, ?)";
        PreparedStatement psmt2 = con.prepareStatement(electricityMeter, Statement.RETURN_GENERATED_KEYS);
        psmt2.setDouble(1, electricityReading.getCurrentReading());
        psmt2.setDate(2, new java.sql.Date(new Date().getTime()));
        psmt2.setInt(3, contract.getBookedBeds().get(0).getBedDto().getRoomId());
        psmt2.executeUpdate();
        ResultSet result2 = psmt2.getGeneratedKeys();
        result2.next();
        int electricityId = result2.getInt(1);
        System.out.println(electricityId);

        String query = "INSERT INTO tblhopdong VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        Date currentDate = new Date();
        double deposit = contract.getDeposit();
        int studentId = contract.getStudent().getId();
        int employeeId = contract.getEmployee().getId();

        psmt.setDate(1, new java.sql.Date(currentDate.getTime()));
        psmt.setDouble(2, deposit);
        psmt.setInt(3, studentId);
        psmt.setInt(4, employeeId);
        psmt.setInt(5, electricityId);
        psmt.setInt(6, waterId);

        psmt.executeUpdate();
        ResultSet rs3 = psmt.getGeneratedKeys();
        rs3.next();
        int contractId = rs3.getInt(1);

        for (BookedBed bed : contract.getBookedBeds()) {
            String insertBookedBed = "INSERT INTO tblgiuongdat VALUES (null, ?, null, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertBookedBed);
            ps.setDate(1, new java.sql.Date(contract.getCreateDate().getTime()));
            ps.setInt(2, bed.getBedDto().getId());
            ps.setInt(3, contractId);
            ps.executeUpdate();
        }

        return true;
    }
}
