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

 Date: 29/07/2024 16:18:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product_category_property_config
-- ----------------------------
DROP TABLE IF EXISTS `t_product_category_property_config`;
CREATE TABLE `t_product_category_property_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `property_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_product_category_property_config
-- ----------------------------
BEGIN;
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (6, 'Tiles', 'Alternate colors', '2024-06-27 15:39:15', '2024-07-10 20:16:50', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (7, 'Tiles', 'Faces/Patterns', '2024-06-27 15:39:52', '2024-07-10 20:16:51', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (8, 'Tiles', 'Sizes', '2024-06-27 15:44:38', '2024-07-10 20:16:53', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (9, 'Tiles', 'Thickness', '2024-06-27 15:44:59', '2024-07-10 20:16:54', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (10, 'Tiles', 'Surface finishes', '2024-07-10 20:12:50', '2024-07-10 20:16:55', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (11, 'Tiles', 'Anti-slip resistance', '2024-07-10 20:12:56', '2024-07-10 20:16:57', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (12, 'Natural Stones', 'Stone Type', '2024-07-10 20:20:00', '2024-07-10 20:20:03', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (13, 'Natural Stones', 'Slab Sizes', '2024-07-10 20:20:06', '2024-07-10 20:20:08', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (14, 'Natural Stones', 'Tile Sizes', '2024-07-10 20:20:11', '2024-07-10 20:20:13', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (15, 'Natural Stones', 'Thickness', '2024-07-10 20:20:15', '2024-07-10 20:20:17', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (16, 'Natural Stones', 'Surface Finishes', '2024-07-10 20:20:19', '2024-07-10 20:20:23', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (17, 'Natural Stones', 'Anti-Slip resistance', '2024-07-10 20:20:25', '2024-07-10 20:20:28', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (18, 'Artificial Stones', 'Stone Type', '2024-07-10 20:21:47', '2024-07-10 20:21:50', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (19, 'Artificial Stones', 'Slab Sizes', '2024-07-10 20:21:51', '2024-07-10 20:21:53', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (20, 'Artificial Stones', 'Tile Sizes', '2024-07-10 20:21:54', '2024-07-10 20:21:59', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (21, 'Artificial Stones', 'Thickness', '2024-07-10 20:22:01', '2024-07-10 20:22:04', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (22, 'Artificial Stones', 'Surface Finishes', '2024-07-10 20:22:05', '2024-07-10 20:22:07', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (23, 'Artificial Stones', 'Anti-Slip resistance', '2024-07-10 20:22:08', '2024-07-10 20:22:16', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (24, 'Cladding', 'Material', '2024-07-10 20:22:51', '2024-07-10 20:22:52', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (25, 'Cladding', 'Sizes', '2024-07-10 20:22:53', '2024-07-10 20:22:54', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (26, 'Cladding', 'Thickness', '2024-07-10 20:22:56', '2024-07-10 20:22:57', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (27, 'Cladding', 'Thickness', '2024-07-10 20:22:58', '2024-07-10 20:26:01', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (28, 'Cabinetry', 'Surface Material', '2024-07-10 20:26:39', '2024-07-10 20:26:42', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (29, 'Cabinetry', 'Panel Material', '2024-07-10 20:26:42', '2024-07-10 20:26:45', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (30, 'Cabinetry', 'Colors', '2024-07-10 20:26:46', '2024-07-10 20:26:48', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (31, 'Cabinetry', 'Hardware', '2024-07-10 20:26:49', '2024-07-10 20:26:56', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (32, 'Doors', 'Finishes', '2024-07-10 20:27:58', '2024-07-10 20:28:00', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (33, 'Doors', 'Sizes', '2024-07-10 20:28:02', '2024-07-10 20:28:04', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (34, 'Doors', 'Type', '2024-07-10 20:28:05', '2024-07-10 20:28:12', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (35, 'Doors', 'Style', '2024-07-10 20:28:13', '2024-07-10 20:28:16', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (36, 'Doors', 'Casing', '2024-07-10 20:28:17', '2024-07-10 20:28:19', '1');
INSERT INTO `t_product_category_property_config` (`id`, `category`, `property_name`, `create_date`, `update_date`, `status`) VALUES (37, 'Doors', 'Fire Rating', '2024-07-10 20:28:21', '2024-07-10 20:29:20', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
