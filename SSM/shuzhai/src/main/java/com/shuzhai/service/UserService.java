package com.shuzhai.service;

import com.shuzhai.domain.User;
import com.shuzhai.domain.UserInfo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface UserService {

    // 添加用户
    public boolean addUser(User user);

    // 登录检查
    public int checkUserByTelAndPassword(User user);

    // 获取用户信息
    public UserInfo getUserInfo(int userID);

    // 保存用户信息
    public void saveUserInfo(User user);

    // 修改用户信息
    public boolean modifiedUserInfo(UserInfo userInfo);

    // 修改密码
    public boolean modifiedPassowrd(User user, String newPassword);

    // 修改头像
    public String uploadPicture(Integer userId, CommonsMultipartFile pictureFile);

    // 将图片存储路径修改为访问路径
    public UserInfo transformPath(UserInfo userInfo);

    public String transformPath(String storePath);

    public String getPicName(String storePath);

}
