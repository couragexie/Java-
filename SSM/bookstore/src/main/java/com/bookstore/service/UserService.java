package com.bookstore.service;

import com.bookstore.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.imp.UserDaoImp;
import com.bookstore.domain.User;

@Service()
public class UserService {
    @Autowired
    private UserDao userDao;
    // 处理登陆
    public User checkUp(User user, boolean isAdmin){
    	User checkUser = null;
    	if(isAdmin)
    		checkUser = userDao.getAdmin(user);	
    	else  
    		checkUser = userDao.getUserByUsernameAndPassword(user);
    	
        System.out.println("获取到的数据:" + checkUser);
        return checkUser;
    }
    // 处理注册请求
    public boolean register(User user){
        int ok = userDao.addUser(user);
        System.out.println("ok：" + ok );
        if(ok == 1) {
            System.out.println("注册成功！");
        	return true;
            
        }else {
        	System.out.println("注册失败！");
        	return false;
        }
    }


}
