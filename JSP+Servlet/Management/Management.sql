/*
Navicat MySQL Data Transfer

Source Server         : Jay
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : studentmanagement

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-03-11 14:04:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('C2001', '高等数学', '5');
INSERT INTO `course` VALUES ('C2002', '大学英语', '2');
INSERT INTO `course` VALUES ('C2003', '线性代数', '2');
INSERT INTO `course` VALUES ('C2005', '大学计算机基础', '1');
INSERT INTO `course` VALUES ('C2006', 'JavaEE', '3');
INSERT INTO `course` VALUES ('C2007', '网络协议', '3');
INSERT INTO `course` VALUES ('C2008', '计算机网络', '3');
INSERT INTO `course` VALUES ('C2012', 'Linux 操作系统', '3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3117004111', '123', '黄晓明');
INSERT INTO `student` VALUES ('3117004882', '2', '杨幂');
INSERT INTO `student` VALUES ('3117004885', '2', '小冉');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `sid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `major` varchar(10) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `class_` varchar(10) DEFAULT NULL,
  `position` varchar(5) DEFAULT NULL,
  `dormitory` varchar(5) DEFAULT NULL,
  `phoneNum` varchar(15) DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('3117004111', '黄晓明', '信息安全', '22', '男', '170807', '学习委员', '622', '123456', '111@163.com');
INSERT INTO `student_info` VALUES ('3117004882', '杨幂', '信息安全', '22', '女', '170807', '团支书', '511', '987654321', '163@.com');

-- ----------------------------
-- Table structure for s_c
-- ----------------------------
DROP TABLE IF EXISTS `s_c`;
CREATE TABLE `s_c` (
  `s_cid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `grade` int(5) DEFAULT NULL,
  PRIMARY KEY (`s_cid`,`cid`,`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s_c
-- ----------------------------
INSERT INTO `s_c` VALUES ('1', 'C2001', '3117004111', '90');
INSERT INTO `s_c` VALUES ('2', 'C2002', '3117004111', '98');
INSERT INTO `s_c` VALUES ('3', 'C2003', '3117004111', '89');
INSERT INTO `s_c` VALUES ('14', 'C2006', '3117004111', '90');
INSERT INTO `s_c` VALUES ('16', 'C2012', '3117004111', '89');
INSERT INTO `s_c` VALUES ('19', 'C2007', '3117004111', '0');
INSERT INTO `s_c` VALUES ('20', 'C2008', '3117004111', '0');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(10) NOT NULL,
  `name` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3117001', '张明', '123');
