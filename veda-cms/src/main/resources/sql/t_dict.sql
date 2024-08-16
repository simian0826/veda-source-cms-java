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

 Date: 29/07/2024 16:17:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
BEGIN;
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (1, 'Tiles', 'Tiles', 'product category', '2024-06-27 14:58:46', '2024-07-10 20:15:58', '1');
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (2, 'Natural Stones', 'Natural Stones', 'product category', '2024-06-27 14:59:35', '2024-07-10 20:16:10', '1');
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (3, 'Artificial Stones', 'Artificial Stones', 'product category', '2024-06-27 15:00:06', '2024-07-10 20:16:18', '1');
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (4, 'Doors', 'Doors', 'product category', '2024-06-27 15:00:32', '2024-07-10 20:16:33', '1');
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (5, 'Cladding', 'Cladding', 'product category', '2024-06-27 15:00:53', '2024-07-10 20:16:36', '1');
INSERT INTO `t_dict` (`id`, `label`, `value`, `type`, `create_date`, `update_date`, `status`) VALUES (6, 'Cabinetry', 'Cabinetry', 'product category', '2024-06-27 15:01:11', '2024-07-10 20:16:40', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
