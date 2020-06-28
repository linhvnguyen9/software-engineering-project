package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.model.Bed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BedDAO extends DAO {
    public List<Bed> findAvailableBed(Double maxPrice, Date checkinDate) throws SQLException {
        ArrayList<Bed> result = new ArrayList<>();

        String query = "SELECT * FROM tblBed WHERE price";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setDate(1, checkinDate);
        preparedStatement.setDouble(2, maxPrice);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Bed bed = new Bed();
            bed.setId(rs.getInt(1));
            bed.setPrice(rs.getDouble(2));
            bed.set(rs.(2));
            result.add()
        }

    }
}
