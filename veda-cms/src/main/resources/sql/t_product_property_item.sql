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

 Date: 29/07/2024 16:18:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product_property_item
-- ----------------------------
DROP TABLE IF EXISTS `t_product_property_item`;
CREATE TABLE `t_product_property_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_property_id` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_product_property_item
-- ----------------------------
BEGIN;
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (9, 1, '2024-07-02 12:15:44', '2024-07-04 14:18:33', '0', 'label 1-1', 'value 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (10, 1, '2024-07-02 12:15:44', '2024-07-04 14:18:33', '0', 'label 1-2', 'value 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (11, 2, '2024-07-02 12:15:45', '2024-07-04 14:19:25', '0', 'label 2-1', 'value 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (12, 2, '2024-07-02 12:15:45', '2024-07-04 14:19:25', '0', 'label 2-2', 'value 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (13, 3, '2024-07-02 12:15:45', '2024-07-04 14:20:05', '0', 'label addtional 1-1', 'value addtional 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (14, 3, '2024-07-02 12:15:45', '2024-07-04 14:20:05', '0', 'label addtional 1-2', 'value addtional 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (15, 4, '2024-07-02 12:15:46', '2024-07-02 15:28:54', '1', 'label addtional 2-1', 'value addtional 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (16, 4, '2024-07-02 12:15:46', '2024-07-02 15:29:07', '1', 'label addtional 2-2', 'value addtional 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (17, 1, '2024-07-04 14:18:36', NULL, '1', 'label 1-1', 'value 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (18, 1, '2024-07-04 14:18:38', NULL, '1', 'label 1-2', 'value 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (19, 2, '2024-07-04 14:19:26', NULL, '1', 'label 2-1', 'value 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (20, 2, '2024-07-04 14:20:02', NULL, '1', 'label 2-2', 'value 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (21, 3, '2024-07-04 14:20:12', '2024-07-19 01:26:56', '0', 'label addtional 1-1', 'value addtional 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (22, 3, '2024-07-04 14:20:12', '2024-07-19 01:26:56', '0', 'label addtional 1-2', 'value addtional 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (23, 5, '2024-07-04 14:20:12', '2024-07-19 01:26:56', '0', 'label addtional 2-1', 'value addtional 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (24, 5, '2024-07-04 14:20:12', '2024-07-19 01:26:56', '0', 'label addtional 2-2', 'value addtional 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (25, 6, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label 1-1', 'value 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (26, 6, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label 1-2', 'value 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (27, 7, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label 2-1', 'value 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (28, 7, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label 2-2', 'value 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (29, 3, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label addtional 1-1', 'value addtional 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (30, 3, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label addtional 1-2', 'value addtional 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (31, 5, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label addtional 2-1', 'value addtional 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (32, 5, '2024-07-19 01:26:57', '2024-07-26 16:39:03', '0', 'label addtional 2-2', 'value addtional 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (33, 6, '2024-07-26 16:39:04', NULL, '1', 'label 1-1', 'value 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (34, 6, '2024-07-26 16:39:04', NULL, '1', 'label 1-2', 'value 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (35, 7, '2024-07-26 16:39:04', NULL, '1', 'label 2-1', 'value 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (36, 7, '2024-07-26 16:39:04', NULL, '1', 'label 2-2', 'value 2-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (37, 3, '2024-07-26 16:39:04', NULL, '1', 'label addtional 1-1', 'value addtional 1-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (38, 3, '2024-07-26 16:39:04', NULL, '1', 'label addtional 1-2', 'value addtional 1-2');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (39, 5, '2024-07-26 16:39:04', NULL, '1', 'label addtional 2-1', 'value addtional 2-1');
INSERT INTO `t_product_property_item` (`id`, `product_property_id`, `create_date`, `update_date`, `status`, `label`, `value`) VALUES (40, 5, '2024-07-26 16:39:04', NULL, '1', 'label addtional 2-2', 'value addtional 2-2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
