package com.bookstore.dao;

import com.bookstore.domain.User;

import java.util.List;

public interface UserDao {

    User getUser(String username);

    int addUser(User user);

    int deleteUser(Integer id);

    User getAdmin(User user);

    List<User> getAllUser();

    User getUserByUsernameAndPassword(User user);
}
