package com.jay.sell.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @program: sell
 * @description: 页面类
 * @author: Jay
 * @create: 2020-03-19 18:02
 **/
@Data
public class PageDTO<T> {
    /*页的大小*/
    private int pageSize;

    /*当前页数*/
    private int pageNo;

    /*总共的数据*/
    private long totalCount;

    /*总页数*/
    private int totalPage;

    private List<T> content;

    /*数据库索引*/
    //private int index;

//    private boolean hasNext;
//
//    private boolean hasPrev;


}
