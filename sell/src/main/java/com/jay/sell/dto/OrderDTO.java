package com.jay.sell.dto;

import ch.qos.logback.core.boolex.EvaluationException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jay.sell.entity.OrderDetail;
import com.jay.sell.enums.OrderStatusEnum;
import com.jay.sell.enums.PayStatusEnum;
import com.jay.sell.util.serializer.Date2LongSerializer;
import com.sun.org.apache.xerces.internal.xinclude.XInclude11TextReader;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: Data Translate Object， 将数据拼装在一起
 * @author: Jay
 * @create: 2020-03-18 22:55
 **/

/*@JsonInclude(JsonInclude.Include.NON_NULL)
  该注解作用：转 json 格式时，排出值为 null 的值，不传给前端
  如果需要全局的话，则在配置文件中设定
* */

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*订单 id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家手机*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家的微信开放id*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*支付状态*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*订单详情*/
    private List<OrderDetail> orderDetails;

    /*创建时间
     * JsonSerialize 在转json格式时，将 Date 类型转为 Long 类型
     * using=xxx.class 指定 Serializer，该 Serializer 继承JsonSerializer
     * */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


}
