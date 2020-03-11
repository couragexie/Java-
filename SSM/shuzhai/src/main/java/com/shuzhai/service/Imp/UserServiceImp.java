package com.shuzhai.service.Imp;

import com.shuzhai.dao.UserDao;
import com.shuzhai.domain.User;
import com.shuzhai.domain.UserInfo;
import com.shuzhai.service.UserService;
import com.shuzhai.util.HandleFileUtil;
import com.shuzhai.util.HandlePathUtil;
import javafx.scene.chart.ScatterChart;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    /**
     *
     * @Author: jay
     * @Description: 处理用户注册
     * @Date 2019/10/13 17:05
     **/
    public boolean addUser(User user) {
        user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        try {
            userDao.addUser(user);
            saveUserInfo(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @Author: jay
     * @Description: 用户登录检查
     * @Date 2019/10/13 17:05
     **/
    public int checkUserByTelAndPassword(User user){
        int id = -1;
        try {
            id = userDao.checkUser(user);
        }catch(Exception e) {
            System.out.println(e);
        }

        return id;
    }

    // 获取用户信息
    public UserInfo getUserInfo(int userID){
        UserInfo userInfo = null;
        try {
            userInfo = userDao.getUserInfo(userID);
            userInfo = transformPath(userInfo);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(userInfo);
        return  userInfo;
    }


    /**
     *
     * @Author: jay
     * @Description: 注册时添加用户默认信息。
     * @Date 2019/10/13 17:03
     **/
    public void  saveUserInfo(User user) {
        UserInfo userInfo = new UserInfo(user.getUserID(), user.getTelephone(), new BigDecimal(0),null, 0, 0, 0, 0);
        // 设置默认图片
        userInfo.setProfileImg("/imgs/users/9fb4e049gy1g7wffmsvgnj20rs0tyafn.jpg");
        try {
            userDao.addUserInfo(userInfo);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     *
     * @Author: jay
     * @Description: 修改用户信息
     * @Date 2019/10/13 17:03
     **/
    public boolean modifiedUserInfo(UserInfo userInfo){
        try {
            userDao.updateUserInfo(userInfo);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @Author: jay
     * @Description:  修改密码
     * @Date 2019/10/13 17:02
     **/
    public boolean modifiedPassowrd(User user, String newPassword){
        // 从数据库中取出操作对象
        User tUser = null;
        try {
            tUser = userDao.getUser(user.getUserID());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        // 判断两个对象密码是否相等
        if(!tUser.getPassword().equals(user.getPassword()))
            return false;

        // 更新密码
        try {
            user.setPassword(newPassword);
            userDao.updatePassword(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @Author: jay
     * @Description:  处理用户图片上传
     * @Date 2019/10/13 17:02
     **/
    public String uploadPicture(Integer userId, CommonsMultipartFile pictureFile){
        // 处理文件上传的路径, 0：代表上传到 imgs/user 文件夹下
        String storePath = HandlePathUtil.handlePicPath(pictureFile.getOriginalFilename(), 0);

        // 获取用户旧图片的存储位置，方便后面对其删除
        String oldStorePath = userDao.getUserPicStorePath(userId);

        File destFile = new File(storePath);
        System.out.println("文件上传位置：" + destFile.getAbsolutePath());
        try{
            FileUtils.copyInputStreamToFile(pictureFile.getInputStream(), destFile);
            // 更新数据库图片字段的数据
            userDao.updateUserPic(storePath, userId);
            System.out.println("更新成功！！");
        }catch(IOException e){
            e.printStackTrace();
        }

        // 从服务器中删除旧的图片
        HandleFileUtil.deleteFileByStorePath(oldStorePath);

        return storePath;
    }

    /**
     *
     * @Author: jay
     * @Description: 处理图片的访问路径
     * @Date 2019/10/13 17:17
     **/
    public UserInfo transformPath(UserInfo userInfo){
        String storePath = userInfo.getProfileImg();
        userInfo.setProfileImg(HandlePathUtil.storePathTransformUrl(storePath));
        return userInfo;
    }

    public String transformPath(String storePath){
        return HandlePathUtil.storePathTransformUrl(storePath);
    }

    public String getPicName(String storePath){
        return HandlePathUtil.getPicNameFromPath(storePath);
    }


}
