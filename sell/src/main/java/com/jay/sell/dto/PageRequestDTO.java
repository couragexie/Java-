package com.jay.sell.dto;

import lombok.*;

/**
 * @program: sell
 * @description: 页面请求dto
 * @author: Jay
 * @create: 2020-03-19 18:14
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PageRequestDTO {
    /*当前页数*/
    private int pageNo;

    /*页面大小*/
    private int pageSize;
}
