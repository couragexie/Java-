package com.bookstore.dao.imp;


import com.bookstore.dao.BaseDao;
import com.bookstore.dao.UserDao;
import com.bookstore.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

///@Repository()
public class UserDaoImp extends BaseDao<User> implements UserDao {
    @Override
    public User getUser(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        return this.get(sql, username);
    }

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO user(username, password, telephone) VALUES(?, ?, ?)";
        return this.update(sql, user.getUsername(), user.getPassword(), user.getTelephone());
    }

    @Override
    public int deleteUser(Integer id) {
        // System.out.println(this.);
        String sql = "DELETE FROM user WHERE id=?";
        return this.update(sql, id);
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        return this.getList(sql);
    }

    @Override
    public User getUserByUsernameAndPassword(User user) {
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        return this.get(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public User getAdmin(User user) {
        String sql = "SELECT * FROM administration WHERE username=? and password=?";
        return this.get(sql, user.getUsername(), user.getPassword());
    }
}
