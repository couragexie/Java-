package com.jay.sell.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jay.sell.converter.OrderMaster2OrderDTOConverter;
import com.jay.sell.converter.PageInfo2PageDTOConverter;
import com.jay.sell.dao.OrderDetailDao;
import com.jay.sell.dao.OrderMasterDao;
import com.jay.sell.dao.ProductInfoDao;
import com.jay.sell.dto.CartDTO;
import com.jay.sell.dto.OrderDTO;
import com.jay.sell.dto.PageDTO;
import com.jay.sell.dto.PageRequestDTO;
import com.jay.sell.entity.OrderDetail;
import com.jay.sell.entity.OrderMaster;
import com.jay.sell.entity.ProductInfo;
import com.jay.sell.enums.OrderStatusEnum;
import com.jay.sell.enums.PayStatusEnum;
import com.jay.sell.enums.ResultEnum;
import com.jay.sell.exception.SellException;
import com.jay.sell.service.OrderService;
import com.jay.sell.service.ProductService;
import com.jay.sell.util.GenerateUniqueIdUtils;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: 订单服务实现类
 * @author: Jay
 * @create: 2020-03-19 14:57
 **/
@Service
@Slf4j
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductService productService;

    /*创建订单*/
    @Transactional
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        String orderId = GenerateUniqueIdUtils.generateUniqueIdOfOrder();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        System.out.println("创建订单 orderDTO" + orderDTO);

        /*创建保存商品详情*/
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            /*查询商品详情*/
            ProductInfo productInfo = productService.getOneByProductId(orderDetail.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            /*计算总价*/
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            /*订单详情入库*/
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(GenerateUniqueIdUtils.generateUniqueIdOfOrder());
            log.info("创建订单详情 ：" + orderDetail);
            orderDetailDao.saveOrderDetail(orderDetail);
        }

        /*保存订单*/
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterDao.saveOrderMaster(orderMaster);

        /*减库存*/
        List<CartDTO> cartDTOS = orderDTO.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.descreaseStock(cartDTOS);

        return orderDTO;
    }

    @Override
    public OrderDTO findOneOrder(String openid, String orderId) {
        // 检验订单id与订单拥有者openid是否匹配
        OrderMaster orderMaster = checkOrderOwner(openid, orderId);
        // OrderMaster 转换为 OrderDTO
        OrderDTO orderDTO = OrderMaster2OrderDTOConverter.convert(orderMaster);
        // 获取订单详情
        List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailsByOrderId(orderId);
        orderDTO.setOrderDetails(orderDetails);

        return orderDTO;
    }

    @Override
    public PageDTO findPageOfOrdersByOpenid(String openid, PageRequestDTO pageRequestDTO) {
        // PageInfo 包含页面的信息
        PageInfo<OrderMaster> pageInfo = getPageInfo(openid, pageRequestDTO);
        PageDTO pageDTO = PageInfo2PageDTOConverter.conver(pageInfo);
        List<OrderMaster> orderMasters = pageDTO.getContent();

        List<OrderDTO> orderDTOS = OrderMaster2OrderDTOConverter.convert(orderMasters);

        pageDTO.setContent(orderDTOS);
        return pageDTO;
    }

    /*获取分页信息，PageInfo：pageHelper 中定义的类, 可以获取分页信息*/
    private PageInfo<OrderMaster> getPageInfo(String openid, PageRequestDTO pageRequestDTO) {
        /*注意，一个 startPage 所在的函数只能由一个 dao来存取数据*/
        PageHelper.startPage(pageRequestDTO.getPageNo(), pageRequestDTO.getPageSize());
        List<OrderMaster> orderMasters = orderMasterDao.getPageOfOrderByOpenid(openid);
        return new PageInfo<OrderMaster>(orderMasters);
    }

    @Override
    @Transactional
    public OrderDTO cancelOrder(OrderDTO orderDTO) {
        // 判断订单状态
        OrderMaster orderMaster = orderMasterDao.getOne(orderDTO.getOrderId());
        if (orderMaster == null) {
            log.info("【订单取消】 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【订单取消】 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        // 修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        int ok = orderMasterDao.updateOrderStatus(orderDTO.getOrderId(), orderDTO.getOrderStatus());
        if (ok != 1) {
            log.info("【订单取消】更新失败, orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.UPDATE_STATUS_FAIL);
        }

        // 修改库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.info("【订单失败】订单中无订单详情, OrderDTO={}", orderDTO);
            throw new SellException(ResultEnum.Details_NOT_EXIST);
        }
        List<CartDTO> cartDTOS = orderDTO.getOrderDetails()
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOS);
        //如果已支付，退款
        //TODO
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = findOneOrder(openid, orderId);
        return cancelOrder(orderDTO);
    }

    /*检查订单拥有者*/
    private OrderMaster checkOrderOwner(String openid, String orderId) {
        OrderMaster orderMaster = orderMasterDao.getOne(orderId);
        if (orderMaster == null) {
            log.info("【订单检验】查询不到订单 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断订单的openid 是否一致
        if (!openid.equalsIgnoreCase(orderMaster.getBuyerOpenid())) {
            log.info("【订单检验】订单的openid不一致, openid={}, orderMaster={}", openid, orderMaster);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderMaster;
    }

    @Override
    @Transactional
    public OrderDTO finishOrder(OrderDTO orderDTO) {
        // 判断支付状态
        OrderMaster orderMaster = orderMasterDao.getOne(orderDTO.getOrderId());
        if (orderMaster == null) {
            log.info("【订单完结】订单不存在 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【订单完结】订单状态出错 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        // 修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        int ok = orderMasterDao.updateOrderStatus(orderDTO.getOrderId(), orderDTO.getOrderStatus());
        if (ok != 1) {
            log.info("【订单完结】更新失败, orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.UPDATE_STATUS_FAIL);
        }

        // 消息推送
        // TODO

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        // 判断订单,支付状态
        OrderMaster orderMaster = orderMasterDao.getOne(orderDTO.getOrderId());
        if (orderMaster == null) {
            log.info("【订单结账】订单不存在 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("【订单结账】订单状态出错 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        if (!orderMaster.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.info("【订单结账】支付状态出错！ orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.PAY_STATUS_ERROR);
        }

        // 修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        int ok = orderMasterDao.updatePayStatus(orderDTO.getOrderId(), orderDTO.getPayStatus());
        if (ok != 1) {
            log.info("【订单完结】更新失败, orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.UPDATE_STATUS_FAIL);
        }


        return orderDTO;
    }
}
