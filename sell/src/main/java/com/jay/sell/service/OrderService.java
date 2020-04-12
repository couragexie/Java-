package com.jay.sell.service;

import com.jay.sell.dto.OrderDTO;
import com.jay.sell.dto.PageDTO;
import com.jay.sell.dto.PageRequestDTO;

public interface OrderService {

    /*创建订单*/
    public OrderDTO createOrder(OrderDTO orderDTO);

    /*查询单个订单*/
    public OrderDTO findOneOrder(String openid, String orderId);

    /*查询订单列表*/
    public PageDTO<OrderDTO> findPageOfOrdersByOpenid(String openid, PageRequestDTO pageRequestDTO);

    /*取消订单*/
    public OrderDTO cancelOrder(OrderDTO orderDTO);

    public OrderDTO cancelOrder(String openid, String orderId);

    /*完结订单*/
    public OrderDTO finishOrder(OrderDTO orderDTO);

    /*支付完成*/
    public OrderDTO paid(OrderDTO orderDTO);
}
