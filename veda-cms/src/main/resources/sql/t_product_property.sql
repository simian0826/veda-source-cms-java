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

 Date: 29/07/2024 16:18:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product_property
-- ----------------------------
DROP TABLE IF EXISTS `t_product_property`;
CREATE TABLE `t_product_property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  `type` varchar(20) DEFAULT NULL COMMENT 'original, additional',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_product_property
-- ----------------------------
BEGIN;
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (1, 1, 'tile property 1', '2024-07-04 14:16:53', '2024-07-04 14:18:36', '1', 'original');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (2, 1, 'tile property 2', '2024-07-04 14:18:40', '2024-07-04 14:19:25', '1', 'original');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (3, 1, 'tile addtional property 1', '2024-07-26 16:39:04', '2024-07-26 16:39:03', '1', 'additional');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (4, 1, 'tile addtional property 2', '2024-07-02 12:15:45', '2024-07-02 14:04:18', '0', 'additional');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (5, 1, 'tile addtional property 2', '2024-07-26 16:39:04', '2024-07-26 16:39:03', '1', 'additional');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (6, 1, 'Alternate colors', '2024-07-26 16:39:04', '2024-07-26 16:39:03', '1', 'original');
INSERT INTO `t_product_property` (`id`, `product_id`, `name`, `create_date`, `update_date`, `status`, `type`) VALUES (7, 1, 'Faces/Patterns', '2024-07-26 16:39:04', '2024-07-26 16:39:03', '1', 'original');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
