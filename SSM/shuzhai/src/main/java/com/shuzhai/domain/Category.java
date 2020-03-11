package com.shuzhai.domain;

/**
 * @program: shuzhai
 * @description: 图书分类信息
 * @author: Jay
 * @create: 2019-10-20 11:52
 **/

public class Category {
    private Integer categoryId;
    private String category;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
