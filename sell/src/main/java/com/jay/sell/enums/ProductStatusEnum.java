package com.jay.sell.enums;

import com.sun.javaws.jnl.IconDesc;
import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    // 实例化 enum
    // 最后一个实例要用 ; 隔开，当
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
