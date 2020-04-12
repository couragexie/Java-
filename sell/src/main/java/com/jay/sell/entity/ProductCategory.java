package com.jay.sell.entity;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description: 商品的类目录
 * @author: Jay
 * @create: 2020-03-17 10:19
 **/
@ToString
@Builder
@Setter
@Getter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    private Integer categoryId;

    private String CategoryName;

    private Integer categoryType;
}
