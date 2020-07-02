package com.e17cn2.dormitorymanagement.dao;

import com.e17cn2.dormitorymanagement.utils.DatabaseConnection;
import com.google.gson.Gson;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection con;

    public DAO() {
        if (con == null) {
            try {
                Gson gson = new Gson();
                File dbConnection = new File(ClassLoader.getSystemResource("connection.json").getFile());
                Reader reader = new BufferedReader(new FileReader(dbConnection));
                DatabaseConnection connection = gson.fromJson(reader, DatabaseConnection.class);
//                String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
                String dbClass = "com.mysql.cj.jdbc.Driver";
                Class.forName(dbClass);
                con = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPassword());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
