/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : veda_source

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/07/2024 16:18:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  `name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `description` text,
  `imgs` varchar(255) DEFAULT NULL,
  `certificate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_product
-- ----------------------------
BEGIN;
INSERT INTO `t_product` (`id`, `create_date`, `update_date`, `status`, `name`, `category`, `description`, `imgs`, `certificate`) VALUES (1, '2024-07-02 12:15:33', '2024-07-26 16:39:04', '1', 'product name', 'Tiles', 'product description', 'http://localhost:8080/veda-source/storage/fetch/vpktz_9.jpg,http://localhost:8080/veda-source/storage/fetch/965ir_10.jpg,http://localhost:8080/veda-source/storage/fetch/fvomn_11.jpg', 'http://localhost:8080/veda-source/storage/fetch/yasqy_iso.png,http://localhost:8080/veda-source/storage/fetch/b6hcp_iso9001.png,http://localhost:8080/veda-source/storage/fetch/l20lq_iso17025.png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
