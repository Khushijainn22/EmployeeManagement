package com.khushi.emp;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {

    static Connection con;
    public static Connection createdb() {

        try{
            //load driver
            Class.forName("com.mysql.jdbc.Driver");

            //get connection
            String url="jdbc:mysql://localhost:3306/employeedb?useSSL=false";
            String username="root";
            String password="kjkhushi22";
            con=DriverManager.getConnection(url,username,password);

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
