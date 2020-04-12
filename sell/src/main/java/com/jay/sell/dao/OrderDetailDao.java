package com.jay.sell.dao;

import com.jay.sell.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {

    /*创建订单详情*/
    @Insert("INSERT INTO order_detail(detail_id, order_id, product_id, product_name," +
            "product_price, product_quantity, product_icon) " +
            "VALUES(#{detailId}, #{orderId}, #{productId}, #{productName}, #{productPrice}," +
            " #{productQuantity}, #{productIcon})")
    public void saveOrderDetail(OrderDetail orderDetail);

    /*查询一个订单*/
    @Select("SELECT * FROM order_detail WHERE detail_id = #{detailId}")
    public OrderDetail getOne(String detail_id);

    /*通过订单id 查询所有订单详情*/
    @Select("SELECT * FROM order_detail WHERE order_id = #{orderId}")
    public List<OrderDetail> getOrderDetailsByOrderId(String orderId);

}
