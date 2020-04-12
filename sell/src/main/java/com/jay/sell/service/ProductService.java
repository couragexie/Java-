package com.jay.sell.service;


import com.jay.sell.dto.CartDTO;
import com.jay.sell.entity.ProductCategory;
import com.jay.sell.entity.ProductInfo;


import java.util.List;

public interface ProductService {

    /*增加一条数据*/
    public void insertOne(ProductInfo productInfo);

    /*更新数据*/
    public int update(ProductInfo productInfo);

    /*删除*/
    public int delete(String productId);

    /*通过 id 查询一条数组*/
    public ProductInfo getOneByProductId(String productId);

    /*查询所有上架的商品*/
    public List<ProductInfo> getAllUp();


    /*分页查询*/


    /*减库存*/
    public void descreaseStock(List<CartDTO> cartDTOs);

    /*增库存*/
    public void increaseStock(List<CartDTO> cartDTOs);


}
