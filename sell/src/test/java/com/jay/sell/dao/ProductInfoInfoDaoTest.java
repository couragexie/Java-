package com.jay.sell.dao;

import com.jay.sell.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductInfoInfoDaoTest {

    @Autowired
    ProductInfoDao productDao;

    @Test
    public void testInsert() {

        ProductInfo product = new ProductInfo("1234567", "番茄炒蛋", new BigDecimal(15.00), 5, "番茄炒鸡蛋", "/images", 0, 2);
        //productDao.insert(product);

        ProductInfo product1 = productDao.getOneById("1234567");

        System.out.println(product1);

        System.out.println(productDao.getStock(product1.getProductId()));

        List<ProductInfo> all = productDao.getAllByCategory(2);
        for (ProductInfo productInfo : all)
            System.out.println(productInfo);

        productDao.delete("123456");


    }

}