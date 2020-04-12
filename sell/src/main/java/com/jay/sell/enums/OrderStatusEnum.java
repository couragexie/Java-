package com.jay.sell.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description: 订单状态
 * @author: Jay
 * @create: 2020-03-18 21:55
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "完成"),
    CANCEL(2, "取消");

    int code;
    String message;

    OrderStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
