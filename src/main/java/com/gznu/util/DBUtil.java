package com.gznu.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Administrator
 * @date 2019-06-21 23:34
 */
public class DBUtil {

    public static Connection conn = null;
    public static Statement stm;
    public static ResultSet res;

    public static void main(String[] args) {
        DBUtil db = new DBUtil();
        System.out.println(db.getConn());
    }

    public static Connection getConn(){
        ResourceBundle rb = ResourceBundle.getBundle("database");
        String driver = rb.getString("driverClassName");
        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            //conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
            //conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(){
        try {
            if (res != null){
                res.close();
            }
            if (stm == null) {
                stm.close();
            }
            if (conn == null) {
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
