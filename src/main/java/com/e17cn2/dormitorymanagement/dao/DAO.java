package com.e17cn2.dormitorymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection con;

    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/demo_cnpm?user=root";
            String dbClass = "com.mysql.jdbc.Driver";

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "phamlong4101999");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
