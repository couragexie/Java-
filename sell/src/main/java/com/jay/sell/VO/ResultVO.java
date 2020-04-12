package com.jay.sell.VO;
/*VO 包 ViewObject*/

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description: http 最外层返回值
 * @author: Jay
 * @create: 2020-03-17 14:35
 **/
@Data
@Component
public class ResultVO<T> {
    /*返回码*/
    @JsonProperty("code")
    private int code;

    /*信息*/
    @JsonProperty("msg")
    private String message;

    @JsonProperty("data")
    private T data;
}
