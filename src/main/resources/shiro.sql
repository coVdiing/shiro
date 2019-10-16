/*
Navicat MySQL Data Transfer

Source Server         : vi
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-10-16 20:03:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'addProduct', '增加产品', '/addProduct');
INSERT INTO `permission` VALUES ('2', 'deleteProduct', '删除产品', '/deleteProduct');
INSERT INTO `permission` VALUES ('3', 'editProduct', '编辑产品', '/editeProduct');
INSERT INTO `permission` VALUES ('4', 'updateProduct', '修改产品', '/updateProduct');
INSERT INTO `permission` VALUES ('5', 'listProduct', '查看产品', '/listProduct');
INSERT INTO `permission` VALUES ('6', 'addOrder', '增加订单', '/addOrder');
INSERT INTO `permission` VALUES ('7', 'deleteOrder', '删除订单', '/deleteOrder');
INSERT INTO `permission` VALUES ('8', 'editOrder', '编辑订单', '/editeOrder');
INSERT INTO `permission` VALUES ('9', 'updateOrder', '修改订单', '/updateOrder');
INSERT INTO `permission` VALUES ('10', 'listOrder', '查看订单', '/listOrder');
INSERT INTO `permission` VALUES ('13', 'listUser', '用户管理', '/config/listUser');
INSERT INTO `permission` VALUES ('14', 'editUser', '用户编辑', '/config/editUser');
INSERT INTO `permission` VALUES ('15', 'listRole', '角色管理', '/config/listRole');
INSERT INTO `permission` VALUES ('17', 'editRole', '角色编辑', '/config/editRole');
INSERT INTO `permission` VALUES ('18', 'listPermission', '权限管理', '/config/listPermission');
INSERT INTO `permission` VALUES ('19', 'editPermission', '权限编辑', '/config/editPermission');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'productManager', '产品管理员');
INSERT INTO `role` VALUES ('3', 'orderManager', '订单管理员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('11', '2', '1');
INSERT INTO `role_permission` VALUES ('12', '2', '2');
INSERT INTO `role_permission` VALUES ('13', '2', '3');
INSERT INTO `role_permission` VALUES ('14', '2', '4');
INSERT INTO `role_permission` VALUES ('15', '2', '5');
INSERT INTO `role_permission` VALUES ('50', '3', '10');
INSERT INTO `role_permission` VALUES ('51', '3', '9');
INSERT INTO `role_permission` VALUES ('52', '3', '8');
INSERT INTO `role_permission` VALUES ('53', '3', '7');
INSERT INTO `role_permission` VALUES ('54', '3', '6');
INSERT INTO `role_permission` VALUES ('55', '3', '1');
INSERT INTO `role_permission` VALUES ('104', '1', '18');
INSERT INTO `role_permission` VALUES ('105', '1', '17');
INSERT INTO `role_permission` VALUES ('106', '1', '15');
INSERT INTO `role_permission` VALUES ('107', '1', '14');
INSERT INTO `role_permission` VALUES ('108', '1', '13');
INSERT INTO `role_permission` VALUES ('109', '1', '10');
INSERT INTO `role_permission` VALUES ('110', '1', '9');
INSERT INTO `role_permission` VALUES ('111', '1', '8');
INSERT INTO `role_permission` VALUES ('112', '1', '7');
INSERT INTO `role_permission` VALUES ('113', '1', '6');
INSERT INTO `role_permission` VALUES ('114', '1', '5');
INSERT INTO `role_permission` VALUES ('115', '1', '4');
INSERT INTO `role_permission` VALUES ('116', '1', '3');
INSERT INTO `role_permission` VALUES ('117', '1', '2');
INSERT INTO `role_permission` VALUES ('118', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhang3', 'a7d59dfc5332749cb801f86a24f5f590', 'e5ykFiNwShfCXvBRPr3wXg==');
INSERT INTO `user` VALUES ('2', 'li4', '91debea259ef3c7b133d5d07ce76064f', 'N53206elJ1bPwNSBLK8Xmw==');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('45', '1', '1');
INSERT INTO `user_role` VALUES ('58', '2', '2');
