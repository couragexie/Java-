package com.jay.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品信息模版
 * @author: Jay
 * @create: 2020-03-17 16:18
 **/
@Data
@Component
public class ProductInfoVO {

    @JsonProperty("id")
    private String productInfoId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;
}
