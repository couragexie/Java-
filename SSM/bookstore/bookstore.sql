/*
Navicat MySQL Data Transfer

Source Server         : Jay
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-03-11 15:00:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administration
-- ----------------------------
DROP TABLE IF EXISTS `administration`;
CREATE TABLE `administration` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` bigint(11) DEFAULT NULL,
  `isAdmin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of administration
-- ----------------------------
INSERT INTO `administration` VALUES ('1', 'xiejie', '123456', '13829061922', null);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `classifyID` int(11) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('4', '深入理解计算机系统（原书第3版）', '作者:（美）兰德尔?E.布莱恩特（Randal E.Bryant）', '133.4', '机械工业出版社', '1', '程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！', null, 'D:\\DevelopmentTools\\img\\dcdec55ef77e423c9504e4613f00a25b.jpg');
INSERT INTO `book` VALUES ('5', '深入理解计算机系统（原书第3版）', '作者:（美）兰德尔?E.布莱恩特（Randal E.Bryant）', '133.4', '机械工业出版社', '1', '程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！', null, 'D:\\DevelopmentTools\\img\\701be8b53c904b888ae4ca262e602961.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiejie', '123456', '13829061922');
INSERT INTO `user` VALUES ('5', '张i', '123456', '1234556');
INSERT INTO `user` VALUES ('7', '21313', '1312', '12313');
