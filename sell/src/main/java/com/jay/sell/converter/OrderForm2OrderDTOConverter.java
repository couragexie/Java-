package com.jay.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jay.sell.dto.OrderDTO;
import com.jay.sell.entity.OrderDetail;
import com.jay.sell.form.OrderForm;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @description: 订单表单转换器
 * @author: Jay
 * @create: 2020-03-20 16:48
 **/

public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetails = new ArrayList<>();

        try {
            orderDetails = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        orderDTO.setOrderDetails(orderDetails);

        return orderDTO;
    }
}
