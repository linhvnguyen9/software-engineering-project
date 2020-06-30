package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.Contract;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ContractDAO extends DAO {
    public boolean saveContract(Contract contract) throws SQLException {
        String query = "INSERT INTO tblhopdong VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = con.prepareStatement(query);

        Date currentDate = new Date();
        double deposit = contract.getDeposit();
        int studentId = contract.getStudent().getId();
        int employeeId = contract.getEmployee().getId();
        int electricityMeterId = contract.getElectricityReading().getId();
        int waterMeterId = contract.getWaterReading().getId();

        psmt.setDate(1, new java.sql.Date(currentDate.getTime()));
        psmt.setDouble(2, deposit);
        psmt.setInt(3, studentId);
        psmt.setInt(4, employeeId);
        psmt.setInt(5, electricityMeterId);
        psmt.setInt(6, waterMeterId);

        return psmt.execute();
    }
}
