package com.jay.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_ERROR(1, "商品库存出错"),

    ORDER_NOT_EXIST(3, "订单不存在"),

    ORDER_STATUS_ERROR(4, "订单状态出错"),

    PAY_STATUS_ERROR(5, "支付状态出错"),

    UPDATE_STATUS_FAIL(6, "更新失败"),

    Details_NOT_EXIST(7, "订单中没有订单详情"),

    PARAM_ERROR(8, "参数不正确"),

    CART_IS_EMPTY(9, "购物车为空"),

    OPENID_IS_EMPTY(10, "微信openid 为空"),

    ORDER_OWNER_ERROR(11, "订单的openid不一致"),

    WeChat_MP_Error(12, "微信网页授权出错！");;

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
