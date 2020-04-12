package com.jay.sell.service.imp;

import com.jay.sell.dao.ProductCategoryDao;
import com.jay.sell.entity.ProductCategory;
import com.jay.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 11:11
 **/
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public void insertOne(ProductCategory productCategory) {
        productCategoryDao.insertOne(productCategory);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }

    @Override
    public void delete(int categoryId) {
        productCategoryDao.delete(categoryId);
    }

    @Override
    public List<ProductCategory> getCategoryByCategoryType(List<Integer> categoryTypes) {
        return productCategoryDao.getCategoryByCategoryType(categoryTypes);
    }
}
