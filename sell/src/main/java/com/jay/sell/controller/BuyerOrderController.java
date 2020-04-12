package com.jay.sell.controller;

import com.jay.sell.VO.ResultVO;
import com.jay.sell.converter.OrderForm2OrderDTOConverter;
import com.jay.sell.dto.OrderDTO;
import com.jay.sell.dto.PageDTO;
import com.jay.sell.dto.PageRequestDTO;
import com.jay.sell.entity.OrderMaster;
import com.jay.sell.enums.ResultEnum;
import com.jay.sell.exception.SellException;
import com.jay.sell.form.OrderForm;
import com.jay.sell.service.OrderService;
import com.jay.sell.service.imp.OrderServiceImp;
import com.jay.sell.util.ResultVOUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sell
 * @description: 买家订单
 * @author: Jay
 * @create: 2020-03-19 16:10
 **/
@RequestMapping("/buyer/order")
@RestController
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImp orderService;

    /*创建订单*/
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        log.info("创建订单");
        System.out.println("创建订单");
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车不能为空，item={}", orderForm.getItems());
            throw new SellException(ResultEnum.CART_IS_EMPTY);
        }

        orderDTO = orderService.createOrder(orderDTO);
        Map<String, String> data = new HashMap<>();
        data.put("orderId", orderDTO.getOrderId());

        log.info("【订单创建】 orderDTO={}", orderDTO);
        return ResultVOUtils.success(data);
    }

    /*订单列表*/
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "1") Integer pageNo,
                                         @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO(pageNo, pageSize);
        if (StringUtils.isEmpty(openid)) {
            log.error("【订单列表】openid 为空 openid={}", openid);
            throw new SellException(ResultEnum.OPENID_IS_EMPTY);
        }

        PageDTO pageDTO = orderService.findPageOfOrdersByOpenid(openid, pageRequestDTO);

        List<OrderDTO> data = pageDTO.getContent();

        return ResultVOUtils.success(data);
    }


    /*订单详情列表*/
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") @NotNull(message = "openId 不能为空") String openid,
                                     @RequestParam("orderId") @NotNull(message = "orderId 不能为空") String orderId) {
        OrderDTO data = orderService.findOneOrder(openid, orderId);
        return ResultVOUtils.success(data);
    }

    /*取消订单*/
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") @NotNull(message = "openId 不能为空") String openid,
                           @RequestParam("orderId") @NotNull(message = "orderId 不能为空") String orderId) {
        orderService.cancelOrder(openid, orderId);
        return ResultVOUtils.success();
    }

}
