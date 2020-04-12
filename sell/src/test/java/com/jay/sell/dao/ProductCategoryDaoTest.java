package com.jay.sell.dao;

import com.jay.sell.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    void insertOne() {
        ProductCategory productCategory;
        productCategory = ProductCategory.builder().CategoryName("女生专属").categoryType(3).build();
        //System.out.println(productCategoryDao.getClass());
        //System.out.println(productCategory);


        productCategoryDao.insertOne(productCategory);

    }

    @Test
    void getOne() {
        ProductCategory productCategory = productCategoryDao.getOne(1);
        System.out.println(productCategory);
    }

    @Test
    void delete() {
        productCategoryDao.delete(2);
    }

    @Test
    void getAll() {
        List<ProductCategory> pcs = productCategoryDao.getAll();
        for (ProductCategory pc : pcs)
            System.out.println(pc);


    }

    @Test
    void getCategoryByType() {
        List<Integer> categoryTypes = new ArrayList<>();
        categoryTypes.add(2);
        categoryTypes.add(3);
        List<ProductCategory> categories = productCategoryDao.getCategoryByCategoryType(categoryTypes);

        for (ProductCategory productCategory : categories)
            System.out.println(productCategory);
    }
}