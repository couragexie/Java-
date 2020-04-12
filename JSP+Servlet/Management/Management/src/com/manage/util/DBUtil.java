package com.manage.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/studentManagement?useSSL=true&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "123456";
    private static Connection con;

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (con == null)
                con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
        return con;
    }


}
