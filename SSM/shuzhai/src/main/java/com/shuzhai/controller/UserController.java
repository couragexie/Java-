package com.shuzhai.controller;

import com.shuzhai.domain.Response;
import com.shuzhai.domain.User;
import com.shuzhai.service.Imp.UserServiceImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserServiceImp userService;

    /**
     * Log4j日志处理(@author: jay)
     */
    private static final Logger log = Logger.getLogger(UserController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody User user) {
        System.out.println(user);
        boolean ok = userService.addUser(user);
        if (!ok)
            return new Response().failure();
        return new Response().success();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody User user/*, HttpServletResponse response**/) {
        System.out.println("登录用户:" + user);
        Map<String, Object> data = new HashMap<>();

        Integer id;
        id = userService.checkUserByTelAndPassword(user);
        if (id == -1) {
            return new Response().failure();
        } else {
            data.put("userID", id);
            return new Response().success(data);
        }
    }

    /**
     * @Author: jay
     * @Description: 修改密码
     * @Date 2019/10/12 11:41
     **/

    @RequestMapping(value = "/modified", method = RequestMethod.PUT)
    public Response modified(@RequestBody User user,
                             @RequestParam("newPassword") String newPassword) {
        System.out.println(user + "   " + newPassword);
        if (!userService.modifiedPassowrd(user, newPassword))
            return new Response().failure();
        return new Response().success();
    }


}
