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

 Date: 29/07/2024 16:19:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_project_material
-- ----------------------------
DROP TABLE IF EXISTS `t_project_material`;
CREATE TABLE `t_project_material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_id` int DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `subtitle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tax_type` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_project_material
-- ----------------------------
BEGIN;
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (1, 1, 'material title1', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (2, 1, 'material title2', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (3, 1, 'material title3', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (4, 1, 'material title4', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (5, 1, 'material title5', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (6, 1, 'material title6', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (7, 1, 'material title7', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:00:49', '2024-07-29 14:02:14', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (8, 2, 'material title1', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (9, 2, 'material title2', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (10, 2, 'material title3', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (11, 2, 'material title4', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (12, 2, 'material title5', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (13, 2, 'material title6', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (14, 2, 'material title7', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:01:36', '2024-07-29 14:02:50', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (15, 1, 'material title1', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (16, 1, 'material title2', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (17, 1, 'material title3', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (18, 1, 'material title4', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (19, 1, 'material title5', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (20, 1, 'material title6', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (21, 1, 'material title7', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:14', '2024-07-29 14:02:24', '0');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (22, 1, 'material title1', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (23, 1, 'material title2', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (24, 1, 'material title3', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (25, 1, 'material title4', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (26, 1, 'material title5', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (27, 1, 'material title6', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (28, 1, 'material title7', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:25', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (29, 2, 'material title1', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (30, 2, 'material title2', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (31, 2, 'material title3', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (32, 2, 'material title4', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (33, 2, 'material title5', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (34, 2, 'material title6', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
INSERT INTO `t_project_material` (`id`, `project_id`, `title`, `subtitle`, `image`, `tax_type`, `create_date`, `update_date`, `status`) VALUES (35, 2, 'material title7', 'material subtitle', 'https://uploads-ssl.webflow.com/64d54eb7f99a540e86caeea1/64d54eb7f99a540e86caeeaa_patrick-hendry-eDgUyGu93Yw-unsplash.jpg', 'taxType', '2024-07-29 14:02:50', NULL, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
