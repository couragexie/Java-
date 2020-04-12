package com.shuzhai.domain;

import java.util.List;

/**
 * @program: shuzhai
 * @description: 页面数据
 * @author: Jay
 * @create: 2019-10-07 16:29
 **/

public class Page<T> {

    private List<T> pageData;  // 页面数据

    private int pageNo; // 当前页面码；

    private int pageSize = 5; // 每个页面多少条数据，默认设置，也可以根据传来的数据修改

    private int totalCount;  // 总数据数量；

    /* 以下需要的数据需要计算得到，所以出于安全考虑，去除 setter 方法 */

    private int totalPage; // 总页面数量

    private int index; // 数据库查询开始索引，需要根据当前页码和页面显示数据数量计算

    private boolean hasNext;  // 是否有下一页

    private boolean hasPrev; // 是否有上一页


    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getPageNo() {
        return pageNo;
    }


    // 该方法要在获取 totalPage 总页数后才能调用，不然会报错
    public void setPageNo(int pageNo) {
        int total = getTotalPage();   // 获取总页数
        System.out.println("total" + total);
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > total) {
            pageNo = total;
        }
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        // 获取页数
        int number = getTotalCount() / getPageSize();
        // 整除后，可能还有数据
        if (getTotalCount() % getPageSize() > 0)
            number += 1;

        return number;
    }

    // 当前页数减 1， 数据库索引是从 0 开始的， 0, 5,10,
    public int getIndex() {
        System.out.println("index111:" + (getPageNo() - 1) * getPageSize());
        return (getPageNo() - 1) * getPageSize();
    }


    public boolean isHasNext() {
        return pageNo < getTotalPage();
    }

    public boolean isHasPrev() {
        return pageNo > 1;
    }

}

