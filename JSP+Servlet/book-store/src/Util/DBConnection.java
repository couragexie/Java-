package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/book-store?userSSL=true&serverTimezone=GMT%2B8";
    private static String root = "root";
    private static String password = "password";
    private static Connection con = null;

    public static Connection connectDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
        }

        try {
            con = DriverManager.getConnection(url, root, password);

            if (con == null) {
                System.out.println("����ʧ��");
            }

        } catch (Exception e) {

        }
        return con;
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
        }

    }

}
