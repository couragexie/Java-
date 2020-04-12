package com.jay.sell.dao;

import com.jay.sell.entity.ProductCategory;
import com.jay.sell.entity.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: sell
 * @description: 商品的存取
 * @author: Jay
 * @create: 2020-03-15 00:17
 **/
@Repository
public interface ProductInfoDao {
    /*插入单个商品数据*/
    @Insert("INSERT INTO product_info(" +
            "product_id, product_name, product_price," +
            "product_stock, product_description, product_icon, " +
            "product_status, category_type)  " +
            "VALUES(#{productId}, #{productName}, #{productPrice}, " +
            "#{productStock}, #{productDescription}, #{productIcon}," +
            "#{productStatus}, #{categoryType})")
    public void insert(ProductInfo product);

    /*查询单个商品信息*/
    @Select("SELECT * FROM product_info WHERE product_id = #{productId}  ")
    public ProductInfo getOneById(String productId);

    /*查询所有同一类型商品信息*/
    @Select("SELECT * FROM product_info WHERE category_type = #{categoryType}")
    public List<ProductInfo> getAllByCategory(int categoryType);

    /*查询所有同一状态的商品*/
    @Select("SELECT * FROM product_info WHERE product_status=#{status}")
    public List<ProductInfo> getAllByStatus(int status);

    /*查询库存*/
    @Select("SELECT product_stock FROM product_info WHERE product_id=#{productId}")
    public int getStock(String productId);

    /*更新商品信息*/
    @Update("UPDATE product_info SET " +
            "product_id=#{productId}, product_name=#{productName}," +
            "product_price=#{productPrice}, product_stock=#{productStock}" +
            "product_description=#{productDescription}, product_icon=#{productIcon}," +
            "product_status=#{productStatus}, category_type=#{CategoryType} WHERE product_id=#{productId}")
    public int update(ProductInfo product);

    /*更新库存*/
    @Update("UPDATE product_info SET product_stock=#{stock} WHERE product_id=#{id}")
    public int updateStock(@Param("id") String productId, @Param("stock") int productStock);

    /*删除商品*/
    @Delete("DELETE FROM product_info WHERE product_id=#{productId}")
    public int delete(String productId);

}
