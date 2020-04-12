package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.User;
import Util.DBConnection;

/**
 * @author xj138 �����û����ݣ����е�¼��ע��
 */
public class UserDao {
    private User user;

    public int login(User user) {
        Connection con = DBConnection.connectDB();
        PreparedStatement preSt = null;
        ResultSet rs = null;
        String sql = "select id,username, password from user where username=?";

        try {
            preSt = con.prepareStatement(sql);
            preSt.setString(1, user.getUserName());
            rs = preSt.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).equals(user.getPassword())) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
                preSt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }

    public boolean queryUser(String username) {
        //��ѯ�û����Ƿ����, ���ڷ��� true�� �����ڷ��� false

        Connection con = DBConnection.connectDB();
        PreparedStatement preSt = null;
        ResultSet rs = null;
        String sql = "SELECT username FROM user WHERE username=?";

        try {
            preSt = con.prepareStatement(sql);
            preSt.setString(1, username);
            rs = preSt.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {

        } finally {
            try {
                rs.close();
                preSt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public int registration(User user) {
        Connection con = DBConnection.connectDB();
        PreparedStatement preSt = null;
        String sql = "INSERT INTO user (username, password, tel) VALUES(?, ?, ?)";
        int ok = -1;
        if (queryUser(user.getUserName())) {
            return ok;
        }

        try {
            preSt = con.prepareStatement(sql);
            preSt.setString(1, user.getUserName());
            preSt.setString(2, user.getPassword());
            preSt.setString(3, user.getTelephone());
            ok = preSt.executeUpdate();
            if (ok != -1)
                System.out.println("ע��ɹ�");

            return ok;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                preSt.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return ok;
    }


}
