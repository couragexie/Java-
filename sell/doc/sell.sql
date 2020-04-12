drop table if exists `product_category`;
create table `product_category`(
    `category_id` int(16) not null auto_increment,
    `category_name` varchar(64) not null,
    `category_type` int not null comment'类目录编号',
    `create_time` timestamp not null default current_timestamp comment'创建时间',
    `update_time` timestamp not null default current_timestamp  on update current_timestamp  comment'修改时间',
    primary key(`category_id`)

)comment'类目录';

drop table if exists `product_info`;

create table `product_info`(
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment'商品名称',
    `product_price` decimal(8,2) not null comment'商品价格',
    `product_stock` int not null comment'商品库存',
    `product_description` varchar(64) comment'商品描述',
    `product_icon` varchar (512) comment'商品的图片',
    `product_status` tinyint(3) default 0 comment'商品转态，0：正常，1：下架',
    `category_type` int not null comment'商品的类编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',

    primary key(`product_id`)
)comment'商品的信息';

drop table if exists `order_master`;

create table `order_master`(
    `order_id` varchar (32) not null,
    `buyer_name` varchar (32) not null comment'卖家的名字',
    `buyer_phone` varchar (32) not null comment'卖家的电话',
    `buyer_address` varchar (128) not null comment'卖家的地址',
    `buyer_openid` varchar (64) not null comment '卖家微信openid',
    `order_amount` decimal (8,2) not null comment'订单总金额',
    `order_status` tinyint(3) not null default 0 comment'订单的状态，默认新下单',
    `pay_status` tinyint(3) not null default 0 comment'支付状态，默认未支付',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',

    primary key(`order_id`),
    key `index_buyer_openid` (`buyer_openid`) comment'索引'

)comment'订单';

drop table if exists `order_detail`;

create table `order_detail`(
    `detail_id` varchar (32) not null,
    `order_id` varchar (32) not null comment'订单id',
    `product_id` varchar (32) not null comment'商品id',
    `product_name` varchar (32) not null comment'商品名称',
    `product_price` decimal (8,2) not null comment'商品的价格',
    `product_quantity` int not null comment'商品的数量',
    `product_icon` varchar (512) comment'商品的图片',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',

    primary key (`detail_id`),
    key `index_order_id` (`order_id`)

)comment'订单详情';

drop table if exists `seller_info`;

create table `seller_info`(
    `seller_id` varchar (32) not null ,
    `usernmae` varchar (32) not null,
    `password` varchar (32) not null,
    `openid` varchar (64) not null comment'微信的openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`seller_id`)
) comment '卖家信息表';

