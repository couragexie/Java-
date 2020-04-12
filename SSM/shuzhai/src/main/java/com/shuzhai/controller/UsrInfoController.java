package com.shuzhai.controller;

import com.shuzhai.domain.Response;
import com.shuzhai.domain.UserInfo;
import com.shuzhai.service.Imp.UserServiceImp;
import com.shuzhai.service.UserService;
import com.shuzhai.util.HandlePathUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Map;

/**
 * @program: shuzhai
 * @description: 处理用户信息请求
 * @author: Jay
 * @create: 2019-10-15 08:49
 **/
@RequestMapping("/userinfo")
@RestController
@CrossOrigin(origins = "*")
public class UsrInfoController {
    @Autowired
    UserServiceImp userService;


    private static final Logger log = Logger.getLogger(UsrInfoController.class);

    /**
     * @Author: jay
     * @Description: 根据 id 获取用户信息
     * @Date 2019/10/12 12:04
     **/

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Response getUserInfo(@RequestParam("userId") Integer userId) {
        System.out.println("用户访问数据：" + userId);
        UserInfo userInfo = userService.getUserInfo(userId);
        if (userInfo == null) {
            return new Response().failure();
        }
        return new Response().success(userInfo);
    }

    /**
     * @Author: jay
     * @Description: 修改用户信息;
     * @Date 2019/10/12 12:04
     **/
    @RequestMapping("/modified")
    public Response modifiedUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println("收到信息了");
        System.out.println("修改信息" + userInfo);
        boolean ok = userService.modifiedUserInfo(userInfo);
        System.out.println("添加完成啦啦!");
        if (!ok)
            return new Response().failure();
        return new Response().success();
    }

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public Response modifiedPic(Integer userId,
                                @RequestParam(value = "userPicture", required = false) CommonsMultipartFile pictureFile) {
        UserInfo userInfo = userService.getUserInfo(userId);
        //log.info("修改照片：上传图片的文件名" + pictureFile.getOriginalFilename()+"...");
        //log.info("数据库中的文件名" + userService.getPicName(userInfo.getProfileImg())+"...");
        //log.info("文件名相等：" + pictureFile.getOriginalFilename().equals(userService.getPicName(userInfo.getProfileImg())));


        if (pictureFile.getOriginalFilename().equals(userService.getPicName(userInfo.getProfileImg()))) {
            return new Response().failure("未做任何修改");
        }

        String storePahth = userService.uploadPicture(userInfo.getUserId(), pictureFile);
        String url = userService.transformPath(storePahth);
        log.info("url" + url);
        return new Response().success(url);
    }


}
