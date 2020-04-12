package com.jay.sell.converter;

import com.jay.sell.dto.OrderDTO;
import com.jay.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: OrderMaster 转换成 OrderDTO
 * @author: Jay
 * @create: 2020-03-19 20:18
 **/

public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        List<OrderDTO> orderDTOS = orderMasters.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return orderDTOS;
    }

}
