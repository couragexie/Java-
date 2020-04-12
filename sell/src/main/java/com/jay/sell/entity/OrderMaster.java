package com.jay.sell.entity;

import com.jay.sell.enums.OrderStatusEnum;
import com.jay.sell.enums.PayStatusEnum;
import lombok.*;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 14:11
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Component
public class OrderMaster {
    /*订单 id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家手机*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家的微信开放id*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*支付状态*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

}
