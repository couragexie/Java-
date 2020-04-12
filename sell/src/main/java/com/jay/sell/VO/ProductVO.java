package com.jay.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jay.sell.entity.ProductInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: sell
 * @description: 返回商品的模版
 * @author: Jay
 * @create: 2020-03-17 16:14
 **/
@Data
@Component
public class ProductVO {

    // @JsonProperty 表示转换为 json 时，对应的键，
    @JsonProperty("name")
    private String CategoryName;

    @JsonProperty("type")
    private int CategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVO;
}
