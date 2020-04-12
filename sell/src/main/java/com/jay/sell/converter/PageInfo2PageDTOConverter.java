package com.jay.sell.converter;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jay.sell.dto.OrderDTO;
import com.jay.sell.dto.PageDTO;

/**
 * @program: sell
 * @description: 页面数据转换
 * @author: Jay
 * @create: 2020-03-19 20:41
 **/

public class PageInfo2PageDTOConverter {

    public static PageDTO<?> conver(PageInfo<?> pageInfo) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setContent(pageInfo.getList());
        pageDTO.setPageNo(pageInfo.getPageNum());
        pageDTO.setPageSize(pageInfo.getPageSize());
        pageDTO.setTotalCount(pageInfo.getTotal());
        pageDTO.setTotalPage(pageInfo.getPages());
        return pageDTO;
    }

}
