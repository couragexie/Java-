package com.jay.sell.dao;

import com.jay.sell.entity.ProductCategory;
import com.jay.sell.util.SimpleSelectInExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryDao {
    /*插入数据*/
    @Insert("INSERT INTO product_category(category_id, category_name, category_type) VALUES(#{categoryId}, #{categoryName}, #{categoryType})")
    @Options(useGeneratedKeys = true)
    public void insertOne(ProductCategory productCategory);

    /*删除类目录*/
    @Delete("DELETE FROM product_category WHERE category_id=#{categoryId}")
    public int delete(int categoryId);

    /*查询一个数据*/
    @Select("SELECT * FROM product_category WHERE category_id=#{categoryId}")
    public ProductCategory getOne(int categoryId);

    /*获取所有类目录*/
    @Select("SELECT * FROM product_category")
    public List<ProductCategory> getAll();

    /*通过 CategoryType 查询所有类目录
     * 通过自定义处理器拼接查询语句，使其具有 dynamic SQL 功能
     * */
    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    @Select("SELECT * FROM product_category WHERE category_type IN (#{categoryTypes})")
    public List<ProductCategory> getCategoryByCategoryType(@Param("categoryTypes") List<Integer> categoryTypes);

}
