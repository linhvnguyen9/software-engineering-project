package com.e17cn2.dormitorymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection con;

    public DAO(){
        if(con == null){
            String dbUrl = "";
            String dbClass = "com.mysql.jdbc.Driver";

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
