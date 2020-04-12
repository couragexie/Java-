package com.jay.sell.exception;

import com.jay.sell.enums.ResultEnum;
import lombok.AllArgsConstructor;

/**
 * @program: sell
 * @description: 异常类
 * @author: Jay
 * @create: 2020-03-19 15:12
 **/
public class SellException extends RuntimeException {
    private int code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(int code, String message) {

        super(message);

        this.code = code;
    }
}
