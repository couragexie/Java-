package com.jay.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @program: sell
 * @description: 购物车信息数据
 * @author: Jay
 * @create: 2020-03-19 15:42
 **/

@AllArgsConstructor
@Data
public class CartDTO {
    /*商品 id*/
    private String productId;

    private int productQuantity;

}
