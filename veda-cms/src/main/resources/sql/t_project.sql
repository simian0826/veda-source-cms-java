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

 Date: 29/07/2024 16:19:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `subtitle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `location` varchar(30) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `project_images` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_project
-- ----------------------------
BEGIN;
INSERT INTO `t_project` (`id`, `title`, `subtitle`, `description`, `location`, `type`, `project_images`, `create_date`, `update_date`, `status`) VALUES (1, 'project title 1', 'project subtitle 1', 'project description 1', 'Miami Beach', 'onGoing', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg,https://miclglobal.com/wp-content/uploads/2022/08/Edition-Residences-Fort-Lauderdale-1.jpg,https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeea7_denisse-leon-J7CjWufjmg4-unsplash.jpg', '2024-07-29 14:00:49', '2024-07-29 14:02:25', '1');
INSERT INTO `t_project` (`id`, `title`, `subtitle`, `description`, `location`, `type`, `project_images`, `create_date`, `update_date`, `status`) VALUES (2, 'project title 2', 'project subtitle 2', 'project description 2', 'Miami Beach', 'completed', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg,https://miclglobal.com/wp-content/uploads/2022/08/Edition-Residences-Fort-Lauderdale-1.jpg,https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeea7_denisse-leon-J7CjWufjmg4-unsplash.jpg', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
