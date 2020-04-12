package com.jay.sell.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 14:11
 **/
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class OrderDetail {
    /*订单详情id*/
    private String detailId;
    /*订单 id*/
    private String orderId;
    /*商品 id*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*商品价格*/
    private BigDecimal productPrice;
    /*商品的数量*/
    private Integer productQuantity;
    /*商品的图标*/
    private String productIcon;

}
