package com.jay.sell.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sell
 * @description: 获取网页登录授权
 * @author: Jay
 * @create: 2020-03-22 12:55
 **/

@Configuration
public class WeChatOpenidConfig {

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(weChatConfigProperties.getMpAppId());
        wxMpConfigStorage.setSecret(weChatConfigProperties.getMpAppSecret());
        return wxMpConfigStorage;
    }

}
