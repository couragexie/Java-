package com.jay.sell.dao;

import com.jay.sell.dto.OrderDTO;
import com.jay.sell.dto.PageRequestDTO;
import com.jay.sell.entity.OrderDetail;
import com.jay.sell.entity.OrderMaster;
import com.jay.sell.enums.PayStatusEnum;
import com.jay.sell.service.OrderService;
import com.jay.sell.service.imp.OrderServiceImp;
import com.jay.sell.util.GenerateUniqueIdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.awt.event.WindowFocusListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailDaoTest {
    @Autowired
    OrderMasterDao orderMasterDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    OrderServiceImp orderService;

    @Test
    public void test() {
        OrderMaster orderMaster = OrderMaster.builder()
                .orderId(GenerateUniqueIdUtils.generateUniqueIdOfOrder())
                .buyerName("李四").buyerAddress("广东省江门市五邑大学").buyerOpenid("112345")
                .buyerPhone("12345678").orderAmount(new BigDecimal(128.8))
                .payStatus(PayStatusEnum.WAIT.getCode()).build();
        orderMasterDao.saveOrderMaster(orderMaster);

        OrderDetail orderDetail1 = OrderDetail.builder()
                .detailId(GenerateUniqueIdUtils.generateUniqueIdOfOrder())
                .orderId(orderMaster.getOrderId()).productName("奶茶")
                .productId("1234570").productIcon("http://xxxxx.jpg")
                .productQuantity(3).productPrice(new BigDecimal(15))
                .build();

        OrderDetail orderDetail2 = OrderDetail.builder()
                .detailId(GenerateUniqueIdUtils.generateUniqueIdOfOrder())
                .orderId(orderMaster.getOrderId()).productName("番茄炒蛋")
                .productId("1234567").productIcon("http://xxxxx.jpg")
                .productQuantity(3).productPrice(new BigDecimal(15))
                .build();

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);

        List<OrderDetail> list = new ArrayList<>();
        list.add(orderDetail1);
        list.add(orderDetail2);
        orderDTO.setOrderDetails(list);
        System.out.println(orderDTO);

        orderService.createOrder(orderDTO);
    }

    @Test
    public void test2() {
        for (OrderMaster orderMaster : orderMasterDao.getAll())
            System.out.println(orderMaster);
    }

    @Test
    public void test3() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPageNo(1);
        pageRequestDTO.setPageSize(10);

        System.out.println(orderService.findPageOfOrdersByOpenid("112345", pageRequestDTO));


    }

    @Test
    public void test4() {
        OrderMaster orderMaster = orderMasterDao.getOne("123");
        System.out.println(orderMaster);
    }

    @Test
    public void test5() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("15846052586618501635");
        orderService.paid(orderDTO);


    }

}