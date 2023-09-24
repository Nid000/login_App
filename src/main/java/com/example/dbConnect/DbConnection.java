package com.example.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * class for DB connection using JDBC.
 */
public class DbConnection {
    /**
     * required for DB connection
     */
    static Connection con;

    public static Connection getcon() {

        /**
         * establishing mysql DB connection using jdbc driver with username and password.
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dxc_loginApp", "root", "podapatti99");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("con" + con);
        return con;
    }
}

