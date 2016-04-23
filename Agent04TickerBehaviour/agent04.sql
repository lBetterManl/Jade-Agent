/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : agent04

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2016-04-21 14:45:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trainlist
-- ----------------------------
DROP TABLE IF EXISTS `trainlist`;
CREATE TABLE `trainlist` (
  `ID` varchar(255) NOT NULL,
  `Station` varchar(255) DEFAULT NULL,
  `startStation` varchar(255) DEFAULT NULL,
  `endStation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trainlist
-- ----------------------------
INSERT INTO `trainlist` VALUES ('1256', '荆州', '宜昌', '武汉');
INSERT INTO `trainlist` VALUES ('2345', '汉口', '上海', '北京');
INSERT INTO `trainlist` VALUES ('5672', '天门南', '宜昌', '武汉');
INSERT INTO `trainlist` VALUES ('7255', '武昌', '武昌', '上海');
INSERT INTO `trainlist` VALUES ('7456', '武汉', '广州', '宜昌');
INSERT INTO `trainlist` VALUES ('D5852', '武昌', '广州南', '宜昌东');
INSERT INTO `trainlist` VALUES ('D5858', '武汉', '利川北', '宜昌');
INSERT INTO `trainlist` VALUES ('G114', '长沙', '太原', '上海');
INSERT INTO `trainlist` VALUES ('K2345', '岳阳', '武汉', '汨罗东');
INSERT INTO `trainlist` VALUES ('K5276', '天门南', '怀化', '大理');
INSERT INTO `trainlist` VALUES ('K7174', '武汉', '广州南', '凤凰');
INSERT INTO `trainlist` VALUES ('K747', '上海', '上海', '广东');
