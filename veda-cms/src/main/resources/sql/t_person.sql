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

 Date: 29/07/2024 16:18:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `image` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_person
-- ----------------------------
BEGIN;
INSERT INTO `t_person` (`id`, `name`, `description`, `image`, `create_date`, `update_date`, `status`) VALUES (1, 'Vatsal', 'Vatsal comes from a family with six decades of experience running a construction and real estate development powerhouse in India. He spearheads their firm\'s US division with a goal to match the Indian division\'s scale in just five short years. Through his involvement in this sector, he has intricate knowledge of the design, quality and value of materials used in construction', 'http://localhost:8080/veda-source/storage/fetch/97gbz_vatsal.png', '2024-07-12 16:18:08', '2024-07-17 15:36:48', '1');
INSERT INTO `t_person` (`id`, `name`, `description`, `image`, `create_date`, `update_date`, `status`) VALUES (2, 'Anil', 'Anil has a multi-faceted background in industries such as garment manufacturing and restaurants. Having run businesses across multiple countries, he has the expertise in finding the right manufacturers, ensuring quality control and managing logistical issuas', 'http://localhost:8080/veda-source/storage/fetch/unkp6_anil.png', '2024-07-12 16:19:19', '2024-07-17 15:36:55', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
