package com.jay.sell.controller;

import com.jay.sell.VO.ProductInfoVO;
import com.jay.sell.VO.ProductVO;
import com.jay.sell.VO.ResultVO;
import com.jay.sell.entity.ProductCategory;
import com.jay.sell.entity.ProductInfo;
import com.jay.sell.service.imp.CategoryServiceImp;
import com.jay.sell.service.imp.ProductServiceImp;
import com.jay.sell.util.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 14:36
 **/

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductServiceImp productInfoService;

    @Autowired
    private CategoryServiceImp categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        ResultVO resultVO = new ResultVO();
        // 获取全部商品信息
        List<ProductInfo> productInfos = productInfoService.getAllUp();
        // 利用 lamba 获取商品信息的 categoryType 值。
        List<Integer> categoryTypes = productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        // 获取商品的类目录
        List<ProductCategory> productCategories = categoryService.getCategoryByCategoryType(categoryTypes);
        // 拼接数据
        List<ProductVO> productVO = joinData(productInfos, productCategories);

        return ResultVOUtils.success(productVO);
    }

    /*拼接数据*/
    private List<ProductVO> joinData(List<ProductInfo> productInfos, List<ProductCategory> productCategories) {
        // 商品类型的VO
        List<ProductVO> productVOs = new ArrayList<>();

        // 按照类目录组装商品信息
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();

            // 将商品所属类型相同的拼接在 ProductVO 里面
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVO(productInfoVOS);
            productVOs.add(productVO);
        }
        return productVOs;
    }


}
