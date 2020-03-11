package com.shuzhai.controller;

import com.shuzhai.domain.Response;
import com.shuzhai.domain.UserInfo;
import com.shuzhai.service.Imp.UserServiceImp;
import com.shuzhai.util.HandlePathUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @program: shuzhai
 * @description: 该类已被抛弃
 * @author: Jay
 * @create: 2019-10-13 13:33
 **/

@RestController
@RequestMapping("/userinfos")
@CrossOrigin(origins = "*")
public class UserInfosController {
    @Autowired
    UserServiceImp userService;

    ///** Log4j日志处理 */
   // private static final Logger log = Logger.getLogger(UserInfosController.class);

    /**
     *
     * @Author: jay
     * @Description: 根据 id 获取用户信息
     * @Date 2019/10/12 12:04
     **/
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET,produces = "application/json")
    public Response getUserInfo(@RequestParam("userId") Integer  userId){
        System.out.println("用户访问数据：" + userId);
        UserInfo userInfo =  userService.getUserInfo(userId);
        if(userInfo == null){
            return new Response().failure();
        }
        return new Response().success(userInfo);
    }



    /**
     *
     * @Author: jay
     * @Description:  修改用户信息;
     * @Date 2019/10/12 12:04
     **/

    @RequestMapping(value = "/userinfo/modified")
    public void  modifiedUserInfo(@RequestBody UserInfo userInfo){
        //log.debug("修改用户：" + userInfo);
        System.out.println("修改用户：" + userInfo);

        /*
        boolean ok = userService.modifiedUserInfo(userInfo);
        System.out.println("添加完成啦啦!");
        if(!ok)
            return new Response().failure();
        return new Response().success();

         */
    }




}
