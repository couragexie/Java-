package com.jay.sell.service;

import com.jay.sell.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 11:07
 **/

public interface CategoryService {
    /*增加数据*/
    public void insertOne(ProductCategory productCategory);
    //public ProductCategory getOne(int );

    /*获取所有的类目录*/
    public List<ProductCategory> getAll();

    /*删除指定类目录*/
    public void delete(int categoryId);

    /*根据类编号获取*/
    public List<ProductCategory> getCategoryByCategoryType(List<Integer> categories);
}
