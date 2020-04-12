package com.jay.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description: 配置信息
 * @author: Jay
 * @create: 2020-03-22 13:08
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfigProperties {

    private String mpAppId;

    private String mpAppSecret;
}
