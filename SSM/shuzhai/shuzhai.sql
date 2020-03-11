/*
Navicat MySQL Data Transfer

Source Server         : Jay
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : shuzhai

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-03-11 15:00:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(32) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) NOT NULL,
  `category` varchar(32) DEFAULT NULL COMMENT '分类',
  `price` decimal(5,2) DEFAULT NULL,
  `author` varchar(10) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL COMMENT '商品介绍',
  `pubRegion` varchar(255) DEFAULT NULL COMMENT '发布地点',
  `in_date` timestamp NOT NULL COMMENT '商品录入时间',
  `in_selling` tinyint(4) NOT NULL COMMENT '是否正在出售',
  `adit_status` tinyint(4) NOT NULL COMMENT '审核状态',
  `user_id` int(32) NOT NULL COMMENT '发布人id',
  `like_num` int(32) DEFAULT NULL,
  `collect` int(32) DEFAULT NULL COMMENT '收藏人数',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书籍信息表';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-05 19:25:26', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('2', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-05 19:32:04', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('3', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-05 19:48:34', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('4', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-05 19:52:47', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('5', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 01:55:50', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('6', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 01:57:31', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('7', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:00:26', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('8', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:03:23', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('9', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:06:32', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('10', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:08:07', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('11', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:09:49', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('12', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:12:10', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('13', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:13:29', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('14', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:17:25', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('15', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:18:54', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('16', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:22:30', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('17', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 02:26:07', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('18', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 10:52:46', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('19', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 11:05:57', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('20', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 11:08:54', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('21', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-06 11:12:26', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('22', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-07 10:40:27', '1', '1', '0', '0', '0');
INSERT INTO `book` VALUES ('23', '深入理解计算机系统（原书第3版）', 'dda', '111.20', null, null, null, '2019-10-07 10:49:59', '1', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for book_pic
-- ----------------------------
DROP TABLE IF EXISTS `book_pic`;
CREATE TABLE `book_pic` (
  `book_pic_id` int(32) NOT NULL AUTO_INCREMENT,
  `book_id` int(32) NOT NULL COMMENT '商品所属id',
  `pic_path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `is_main_pic` tinyint(4) DEFAULT NULL COMMENT '是否为主图',
  `pic_status` tinyint(4) DEFAULT NULL COMMENT '图片是否有效',
  PRIMARY KEY (`book_pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书籍图片信息表';

-- ----------------------------
-- Records of book_pic
-- ----------------------------
INSERT INTO `book_pic` VALUES ('1', '1', 'D:\\DevelopmentTools\\img\\book\\9b92b3e9a35e408d86d77e59d35f8fc6.png', '1', '1');
INSERT INTO `book_pic` VALUES ('2', '1', 'D:\\DevelopmentTools\\img\\book\\34c3de53ad0d438f8f69843d375b1933.jpg', '0', '1');
INSERT INTO `book_pic` VALUES ('3', '1', 'D:\\DevelopmentTools\\img\\book\\12d4647a0999409f8c5fcadcfac9ee99.png', '0', '1');
INSERT INTO `book_pic` VALUES ('4', '2', 'D:\\DevelopmentTools\\img\\book\\1f88a5ec92174cac96ee3f1ae1df8fc2.jpg', '1', '1');
INSERT INTO `book_pic` VALUES ('5', '2', 'D:\\DevelopmentTools\\img\\book\\9b7ccbb59d3340dea8f2795d69117c29.png', '0', '1');
INSERT INTO `book_pic` VALUES ('6', '2', 'D:\\DevelopmentTools\\img\\book\\572969a6bb1e4b42ab30d7e00c699a56.jpg', '0', '1');
INSERT INTO `book_pic` VALUES ('7', '3', 'D:\\DevelopmentTools\\img\\book\\dc4273e8181e475a9e9cf88709aaafe8.jpg', '1', '1');
INSERT INTO `book_pic` VALUES ('8', '3', 'D:\\DevelopmentTools\\img\\book\\6ceca1733c8b44ec974984c7883cc421.png', '0', '1');
INSERT INTO `book_pic` VALUES ('9', '3', 'D:\\DevelopmentTools\\img\\book\\691f12f24fce4d309565c8549e5eef3f.jpg', '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(32) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `register_time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13829061922', '123456', null, '2019-10-04 14:21:03');
INSERT INTO `user` VALUES ('2', '13829061921', '123456', '123455', '2019-10-04 15:24:25');
INSERT INTO `user` VALUES ('3', '123455678', '123456', null, '2019-10-11 17:58:37');
INSERT INTO `user` VALUES ('4', '123455678999', '123456', null, '2019-10-11 18:00:28');
INSERT INTO `user` VALUES ('5', '123455678666', '123456', null, '2019-10-11 18:02:58');
INSERT INTO `user` VALUES ('11', '12345567888888', '123456', null, '2019-10-12 11:51:27');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_info_id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL COMMENT '用户 id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `age` int(3) DEFAULT NULL,
  `sex` char(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `intro` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `profile_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  `collection_num` int(10) DEFAULT NULL COMMENT '收藏数量',
  `fans_num` int(10) DEFAULT NULL COMMENT '粉丝数量',
  `follow_num` int(10) DEFAULT NULL COMMENT '关注数量',
  `goods_num` int(10) DEFAULT NULL COMMENT '发布数量',
  PRIMARY KEY (`user_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', 'test', '18', 'test', null, 'test', 'D:\\DevelopmentTools\\img\\user\\04abfe5850074f9c97571b91a4a23855.png', '0.00', 'test', '0', '0', '0', '0');
INSERT INTO `user_info` VALUES ('2', '2', '13829061921', '0', null, null, null, null, '0.00', null, '0', '0', '0', '0');
INSERT INTO `user_info` VALUES ('3', '3', '123455678', '0', null, null, null, null, '0.00', null, '0', '0', '0', '0');
INSERT INTO `user_info` VALUES ('4', '4', '123455678999', '0', null, null, null, null, '0.00', null, '0', '0', '0', '0');
INSERT INTO `user_info` VALUES ('5', '5', '123455678666', '0', null, null, null, null, '0.00', null, '0', '0', '0', '0');
INSERT INTO `user_info` VALUES ('6', '11', '12345567888888', '0', null, null, null, null, '0.00', null, '0', '0', '0', '0');
