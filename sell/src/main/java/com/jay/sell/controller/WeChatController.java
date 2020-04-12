package com.jay.sell.controller;

import com.jay.sell.config.WeChatOpenidConfig;
import com.jay.sell.enums.ResultEnum;
import com.jay.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @program: sell
 * @description: 微信登录
 * @author: Jay
 * @create: 2020-03-22 12:10
 **/
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {
/*
    *微信原生获取 openid
    @GetMapping("/auth")
    public String auth(@RequestParam("code")String code) throws MalformedURLException {

        log.info("获取到 code:" + code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9253f047e4a41320&secret=f894f8fbcfd194aecc5a9a37f63f501d&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        ;
        return response;
    }*/

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        // 配置， 使用配置类
        // 调用方法
        String url = "http://sellc.nat300.top/sell/wechat/userInfo";
        // state 参数传的是获取openid后准备返回的Url
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));

        return "redirect:" + redirectUrl;
    }

    //state 被用来传递获取openid后准备返回的Url
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);

        } catch (WxErrorException e) {
            log.info("【微信登录出错】 code={}", code);
            throw new SellException(ResultEnum.WeChat_MP_Error.getCode(), e.getMessage());
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();
        System.out.println("openid:" + openid);
        return "redirect:" + returnUrl + "?openid=" + openid;
    }
}
