package com.e17cn2.dormitorymanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
