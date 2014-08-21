/*
MySQL Data Transfer
Source Host: localhost
Source Database: lists
Target Host: localhost
Target Database: lists
Date: 2014/8/21 22:44:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for report0810
-- ----------------------------
DROP TABLE IF EXISTS `report0810`;
CREATE TABLE `report0810` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0811
-- ----------------------------
DROP TABLE IF EXISTS `report0811`;
CREATE TABLE `report0811` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0812
-- ----------------------------
DROP TABLE IF EXISTS `report0812`;
CREATE TABLE `report0812` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0813
-- ----------------------------
DROP TABLE IF EXISTS `report0813`;
CREATE TABLE `report0813` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0814
-- ----------------------------
DROP TABLE IF EXISTS `report0814`;
CREATE TABLE `report0814` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0815
-- ----------------------------
DROP TABLE IF EXISTS `report0815`;
CREATE TABLE `report0815` (
  `own` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0816
-- ----------------------------
DROP TABLE IF EXISTS `report0816`;
CREATE TABLE `report0816` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0817
-- ----------------------------
DROP TABLE IF EXISTS `report0817`;
CREATE TABLE `report0817` (
  `own` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0818
-- ----------------------------
DROP TABLE IF EXISTS `report0818`;
CREATE TABLE `report0818` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report0819
-- ----------------------------
DROP TABLE IF EXISTS `report0819`;
CREATE TABLE `report0819` (
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `acc` varchar(255) DEFAULT NULL,
  `ty` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `startdt` varchar(255) DEFAULT NULL,
  `enddt` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `own` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reporttable
-- ----------------------------
DROP TABLE IF EXISTS `reporttable`;
CREATE TABLE `reporttable` (
  `nid` int(11) NOT NULL,
  `id` varchar(50) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `leaf` tinyint(4) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL DEFAULT '0',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `report0810` VALUES ('hao0810', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '已呼通', null);
INSERT INTO `report0810` VALUES ('tang0810', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '未呼通', null);
INSERT INTO `report0810` VALUES ('hao08103', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '3', '已办理', null);
INSERT INTO `report0810` VALUES ('tang08104', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '4', '已呼通', null);
INSERT INTO `report0810` VALUES ('hao08105', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '5', '未呼', null);
INSERT INTO `report0810` VALUES ('tang08106', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '6', '未呼通', null);
INSERT INTO `report0810` VALUES ('hao08107', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '7', '已办理', null);
INSERT INTO `report0810` VALUES ('tang08108', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '8', '未呼', null);
INSERT INTO `report0810` VALUES ('hao08109', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '9', '未呼通', null);
INSERT INTO `report0810` VALUES ('tang081010', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '10', '未呼', null);
INSERT INTO `report0810` VALUES ('hao081011', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '11', '已办理', null);
INSERT INTO `report0810` VALUES ('tang081012', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '12', '已办理', null);
INSERT INTO `report0810` VALUES ('hao081013', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '13', '已呼通', null);
INSERT INTO `report0810` VALUES ('tang081014', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '14', '已呼通', null);
INSERT INTO `report0810` VALUES ('hao081015', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '15', '未呼通', null);
INSERT INTO `report0810` VALUES ('tang081016', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '16', '未呼', null);
INSERT INTO `report0810` VALUES ('hao081017', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '17', '未呼通', null);
INSERT INTO `report0810` VALUES ('tang081018', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '18', '未呼', null);
INSERT INTO `report0810` VALUES ('hao081019', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '19', '未呼通', null);
INSERT INTO `report0810` VALUES ('tang081020', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '20', '未呼通', null);
INSERT INTO `report0810` VALUES ('hao081021', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '21', '未呼', null);
INSERT INTO `report0810` VALUES ('tang081022', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '22', '未呼', null);
INSERT INTO `report0810` VALUES ('hao081023', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '23', '未呼', null);
INSERT INTO `report0810` VALUES ('tang081024', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '24', '未呼', null);
INSERT INTO `report0810` VALUES ('hao08101', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '25', '未呼', null);
INSERT INTO `report0810` VALUES ('tang08102', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '26', '未呼', null);
INSERT INTO `report0811` VALUES ('hao0811', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '未呼通', null);
INSERT INTO `report0811` VALUES ('tang0811', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '已办理', null);
INSERT INTO `report0812` VALUES ('hao0812', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '未呼', null);
INSERT INTO `report0812` VALUES ('tang0812', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '未呼', null);
INSERT INTO `report0813` VALUES ('hao', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '已呼通', null);
INSERT INTO `report0813` VALUES ('tang', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '未呼', null);
INSERT INTO `report0814` VALUES ('hao0814', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '已办理', null);
INSERT INTO `report0814` VALUES ('tang0814', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '未呼', null);
INSERT INTO `report0815` VALUES (null, 'hao0810', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '未呼');
INSERT INTO `report0815` VALUES (null, 'tang0810', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '已呼通');
INSERT INTO `report0815` VALUES (null, 'hao08103', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '3', '已办理');
INSERT INTO `report0815` VALUES (null, 'tang08104', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '4', '未呼通');
INSERT INTO `report0815` VALUES (null, 'hao08105', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '5', '未呼');
INSERT INTO `report0815` VALUES (null, 'tang08106', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '6', '未呼');
INSERT INTO `report0815` VALUES (null, 'hao08107', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '7', '未呼通');
INSERT INTO `report0815` VALUES (null, 'tang08108', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '8', '未呼');
INSERT INTO `report0815` VALUES (null, 'hao08109', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '9', '未呼');
INSERT INTO `report0816` VALUES ('tang081010', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '10', '未呼通', null);
INSERT INTO `report0816` VALUES ('hao081011', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '11', '未呼通', null);
INSERT INTO `report0816` VALUES ('tang081012', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '12', '已办理', null);
INSERT INTO `report0816` VALUES ('hao081013', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '13', '已办理', null);
INSERT INTO `report0816` VALUES ('tang081014', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '14', '未呼通', null);
INSERT INTO `report0816` VALUES ('hao081015', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '15', '未呼', null);
INSERT INTO `report0816` VALUES ('tang081016', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '16', '未呼', null);
INSERT INTO `report0816` VALUES ('hao081017', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '17', '未呼', null);
INSERT INTO `report0817` VALUES (null, 'tang081018', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '18', '未呼通');
INSERT INTO `report0817` VALUES (null, 'hao081019', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '19', '已呼通');
INSERT INTO `report0817` VALUES (null, 'tang081020', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '20', '已办理');
INSERT INTO `report0817` VALUES (null, 'hao081021', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '21', '未呼');
INSERT INTO `report0817` VALUES (null, 'tang081022', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '22', '未呼');
INSERT INTO `report0817` VALUES (null, 'hao081023', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '23', '未呼');
INSERT INTO `report0817` VALUES (null, 'tang081024', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '24', '未呼');
INSERT INTO `report0817` VALUES (null, 'hao08101', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '25', '未呼');
INSERT INTO `report0817` VALUES (null, 'tang08102', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '26', '未呼');
INSERT INTO `report0818` VALUES ('hao0811', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '未呼', null);
INSERT INTO `report0818` VALUES ('tang0811', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '已办理', null);
INSERT INTO `report0819` VALUES ('hao', 'hao', '123456', '123', '289', '六合', '2014-01-01', '2014-01-02', '1', '未呼', null);
INSERT INTO `report0819` VALUES ('tang', 'tang', '2323', '23', '289', 'liuhe', '2014-01-02', '2014-01-02', '2', '已办理', null);
INSERT INTO `reporttable` VALUES ('1', 'report0810', '宽带0810', '1', '6', '宽带1');
INSERT INTO `reporttable` VALUES ('2', 'report0811', '宽带0811', '1', '6', '宽带2');
INSERT INTO `reporttable` VALUES ('3', 'report0812', '宽带0812', '1', '6', '宽带3');
INSERT INTO `reporttable` VALUES ('4', 'report0813', '宽带0813', '1', '6', '宽带4');
INSERT INTO `reporttable` VALUES ('5', 'report0814', '宽带0814', '1', '6', '宽带5');
INSERT INTO `reporttable` VALUES ('6', '201408', '201408', '0', '0', 'root');
INSERT INTO `reporttable` VALUES ('7', 'report0815', '宽带0815', '1', '12', '宽带6');
INSERT INTO `reporttable` VALUES ('8', 'report0816', '宽带0816', '1', '12', '宽带7');
INSERT INTO `reporttable` VALUES ('9', 'report0817', '宽带0817', '1', '12', '宽带8');
INSERT INTO `reporttable` VALUES ('10', 'report0818', '宽带0818', '1', '12', '宽带9');
INSERT INTO `reporttable` VALUES ('11', 'report0819', '宽带0819', '1', '12', '宽带0');
INSERT INTO `reporttable` VALUES ('12', '201409', '201409', '0', '0', 'root');
INSERT INTO `user` VALUES ('1', 'hao', '123', 'admin', '销售部', '六合', '0');
INSERT INTO `user` VALUES ('2', 'tang', '123', 'normal', '渠道', '马鞍支局', '1');
INSERT INTO `user` VALUES ('3', 'tangyuan', '123', 'normal', 'l', 'liuhe', '1');
