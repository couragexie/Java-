package com.shuzhai.dao;

import com.shuzhai.domain.User;
import com.shuzhai.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    // 获取数据
    User getUser(int userId);

    // 检查是否存在用户
    int checkUser(User user);

    // 获取用户信息
    UserInfo getUserInfo(Integer userId);

    // 获取用户图片存储路径
    String getUserPicStorePath(Integer userId);

    // 添加数据
    void addUser(User user);

    // 添加用户信息
    void addUserInfo(UserInfo userInfo);

    // 更新密码
    int updatePassword(User user);

    // 更新用户信息
    int updateUserInfo(UserInfo userInfo);

    int updateUserPic(@Param("profileImg") String profileImg, @Param("userId") Integer userId);

    // 删除照片
    //int deletePic(Integer userId);
}
