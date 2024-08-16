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

 Date: 29/07/2024 16:17:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_hero_section
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_section`;
CREATE TABLE `t_hero_section` (
  `id` int NOT NULL AUTO_INCREMENT,
  `background` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `content` text,
  `module` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_hero_section
-- ----------------------------
BEGIN;
INSERT INTO `t_hero_section` (`id`, `background`, `header`, `content`, `module`, `create_date`, `update_date`, `status`) VALUES (1, 'http://localhost:8080/veda-source/storage/fetch/hxz0d_home-banner.png', 'Value engineering made hassle free', 'Veda Sourcing is your one-stop solution for producing materials from all across the world', 'home', '2024-07-19 16:18:35', '2024-07-19 16:19:08', '1');
INSERT INTO `t_hero_section` (`id`, `background`, `header`, `content`, `module`, `create_date`, `update_date`, `status`) VALUES (2, 'http://localhost:8080/veda-source/storage/fetch/hxz0d_home-banner.png', 'Value engineering made hassle free project', 'Veda Sourcing is your one-stop solution for producing materials from all across the world project', 'project', '2024-07-04 13:38:54', '2024-07-19 16:54:51', '1');
INSERT INTO `t_hero_section` (`id`, `background`, `header`, `content`, `module`, `create_date`, `update_date`, `status`) VALUES (3, 'http://localhost:8080/veda-source/storage/fetch/hxz0d_home-banner.png', 'Value engineering made hassle free product', 'Veda Sourcing is your one-stop solution for producing materials from all across the world product', 'product', '2024-07-18 22:00:01', NULL, '1');
INSERT INTO `t_hero_section` (`id`, `background`, `header`, `content`, `module`, `create_date`, `update_date`, `status`) VALUES (4, 'http://localhost:8080/veda-source/storage/fetch/hxz0d_home-banner.png', 'Value engineering made hassle free about us', 'Veda Sourcing is your one-stop solution for producing materials from all across the world about us', 'about us', '2024-07-18 22:09:27', '2024-07-18 22:51:51', '1');
INSERT INTO `t_hero_section` (`id`, `background`, `header`, `content`, `module`, `create_date`, `update_date`, `status`) VALUES (5, 'http://localhost:8080/veda-source/storage/fetch/hxz0d_home-banner.png', 'Value engineering made hassle free contact us', 'Veda Sourcing is your one-stop solution for producing materials from all across the world contact us', 'contact us', '2024-07-19 16:18:28', '2024-07-19 16:54:51', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
