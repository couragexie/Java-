package com.jay.sell.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-15 00:18
 **/

@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
@NoArgsConstructor
@Builder
public class ProductInfo {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

}
