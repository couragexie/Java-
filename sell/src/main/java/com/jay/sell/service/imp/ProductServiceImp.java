package com.jay.sell.service.imp;

import com.jay.sell.dao.ProductInfoDao;
import com.jay.sell.dto.CartDTO;
import com.jay.sell.entity.ProductInfo;
import com.jay.sell.enums.ProductStatusEnum;
import com.jay.sell.enums.ResultEnum;
import com.jay.sell.exception.SellException;
import com.jay.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 12:00
 **/
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public void insertOne(ProductInfo productInfo) {
        productInfoDao.insert(productInfo);
    }

    @Override
    public int update(ProductInfo productInfo) {
        return productInfoDao.update(productInfo);
    }

    @Override
    public int delete(String productId) {
        return productInfoDao.delete(productId);
    }

    @Override
    public ProductInfo getOneByProductId(String productId) {
        return productInfoDao.getOneById(productId);
    }

    @Override
    public List<ProductInfo> getAllUp() {
        return productInfoDao.getAllByStatus(ProductStatusEnum.UP.getCode());
    }

    /*减库存*/
    @Transactional
    @Override
    public void descreaseStock(List<CartDTO> cartDTOs) {
        for (CartDTO cartDTO : cartDTOs) {
            // 查看商品是否存在
            ProductInfo productInfo = getOneByProductId(cartDTO.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // 判断库存是否正确
            if (result < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            // 更新库存
            productInfoDao.updateStock(cartDTO.getProductId(), result);
        }
    }

    /*增库存*/
    @Transactional
    @Override
    public void increaseStock(List<CartDTO> cartDTOs) {
        for (CartDTO cartDTO : cartDTOs) {
            // 查询商品是否存在
            ProductInfo productInfo = getOneByProductId(cartDTO.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            int result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            // 更新库存
            productInfoDao.updateStock(productInfo.getProductId(), result);
        }
    }


}
