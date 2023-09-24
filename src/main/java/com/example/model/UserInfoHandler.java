package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dbConnect.DbConnection;

public class UserInfoHandler {
	
    static Connection con;
    static PreparedStatement ps;
    
    
    public UserInfo loginaction(String username, String password) {
        UserInfo u_info = null;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbConnection.getcon();
            ps = con.prepareStatement("SELECT * FROM dxc_loginApp.stakeholder WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u_info = new UserInfo(rs.getString("username"), rs.getString("password"), rs.getString("name"),
                        rs.getString("role"), rs.getInt("role_ind"));
            }
        } catch (Exception e) {
            // Handle exceptions here, e.g., log or throw custom exceptions
            e.printStackTrace(); // This is a simple example; consider using a logger
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Handle SQLException if closing connections fails
                e.printStackTrace(); // This is a simple example; consider using a logger
            }
        }

        return u_info;
    }

    
    
//    public UserInfo loginaction(String username, String password) {
//	
//	UserInfo u_info = null;
//
//	try {
//        con = DbConnection.getcon();
//        ps = con.prepareStatement("SELECT * FROM dxc_loginApp.stakeholder WHERE  username = ? and password = ?");
//        ps.setString(1, username);   
//        ps.setString(2, password); 
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//        u_info = new UserInfo(rs.getString("username"), rs.getString("password"), rs.getString("name"),
//        		rs.getString("role"), rs.getInt("role_ind"));
//       
//        }
//    }catch (Exception e) {
//        System.out.println(e);
//    }
//    	return u_info;
//    }

}
