package com.jay.sell.dao;

import com.jay.sell.dto.PageDTO;
import com.jay.sell.entity.OrderMaster;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: Jay
 * @create: 2020-03-17 14:10
 **/
@Repository
public interface OrderMasterDao {

    /* 创建订单 */
    @Insert("INSERT INTO order_master(order_id, buyer_name, buyer_phone, " +
            "buyer_address, buyer_openid, order_amount, order_status, pay_status)" +
            " VALUES(#{orderId}, #{buyerName}, #{buyerPhone}, " +
            "#{buyerAddress},#{buyerOpenid},#{orderAmount}, #{orderStatus}, #{payStatus})")
    public void saveOrderMaster(OrderMaster orderMaster);

    /*查询订单*/
    @Select("SELECT * FROM order_master WHERE order_id=#{orderId}")
    public OrderMaster getOne(String orderId);

    /*通过openid查询所有订单*/
    @Select("SELECT * FROM order_master WHERE buyerOpenid=#{buyerOpenid}")
    public List<OrderMaster> getAllByBuyerOpenid(String buyerOpenid);

    /*获取所有订单*/
    @Select("SELECT * FROM order_master")
    public List<OrderMaster> getAll();

    /*获取指定页面的订单， 通过 PageHelp 插件解析*/
    @Select("SELECT * FROM order_master WHERE buyer_openid=#{openid}")
    public List<OrderMaster> getPageOfOrderByOpenid(@Param("openid") String openid);

    /*删除订单*/


    /*更新订单状态*/
    @Update("UPDATE order_master SET order_status=#{status} WHERE order_id=#{orderId}")
    public int updateOrderStatus(@Param("orderId") String orderId, @Param("status") int status);

    /*更新订单支付状态*/
    @Update("UPDATE order_master SET pay_status=#{status} WHERE order_id=#{orderId}")
    public int updatePayStatus(@Param("orderId") String orderId, @Param("status") int status);


    /*修改订单*/


}
