package com.jay.sell.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: sell
 * @description: 接收买家订单
 * @author: Jay
 * @create: 2020-03-19 16:13
 **/
@Data
@Component
public class OrderForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "电话不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "微信 id 不能为空")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
