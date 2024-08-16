/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80039
 Source Host           : localhost:3306
 Source Schema         : veda_source

 Target Server Type    : MySQL
 Target Server Version : 80039
 File Encoding         : 65001

 Date: 16/08/2024 23:33:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for storage_file
-- ----------------------------
DROP TABLE IF EXISTS `storage_file`;
CREATE TABLE `storage_file`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` bigint(0) NULL DEFAULT NULL,
  `storage_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK575ag81fcckiyb7jxbu657s10`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storage_file
-- ----------------------------
INSERT INTO `storage_file` VALUES (1, '2024-08-06 22:35:26.261069', 'admin', '449gb_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (2, '2024-08-07 15:53:48.662412', 'admin', 'pa0hk_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (3, '2024-08-07 20:09:03.589326', 'admin', 'oridw_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (4, '2024-08-07 20:16:01.617082', 'admin', '4fzq6_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (5, '2024-08-07 20:25:26.692622', 'admin', 'd4aar_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (6, '2024-08-07 20:35:47.848708', 'admin', '1r6qc_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (7, '2024-08-06 22:35:26.261069', 'admin', '1169y_home-process-1.png', 'home-process-1.png', 1452777, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (8, '2024-08-06 22:35:26.261069', 'admin', '6eoqw_home-process-3.png', 'home-process-3.png', 847067, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (9, '2024-08-06 22:35:26.261069', 'admin', '6mff4_tiles.jpg', 'tiles.jpg', 218568, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (10, '2024-08-06 22:35:26.261069', 'admin', '965ir_10.jpg', '10.jpg', 239840, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (11, '2024-08-06 22:35:26.261069', 'admin', '97gbz_vatsal.png', 'vatsal.png', 251013, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (12, '2024-08-06 22:35:26.261069', 'admin', '99gg7_shoppingExperience.png', 'shoppingExperience.png', 2925, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (13, '2024-08-06 22:35:26.261069', 'admin', 'b6hcp_iso9001.png', 'iso9001.png', 61978, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (14, '2024-08-06 22:35:26.261069', 'admin', 'f2d3y_Dicon.png', 'Dicon.png', 2715, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (15, '2024-08-06 22:35:26.261069', 'admin', 'fc1wc_toyota-logo.png', 'toyota-logo.png', 238307, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (16, '2024-08-06 22:35:26.261069', 'admin', 'fvomn_11.jpg', '11.jpg', 157123, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (17, '2024-08-06 22:35:26.261069', 'admin', 'fwjtf_on-timeDelivery.png', 'on-timeDelivery.png', 5230, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (18, '2024-08-06 22:35:26.261069', 'admin', 'hxz0d_home-banner.png', 'home-banner.png', 7729318, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (19, '2024-08-06 22:35:26.261069', 'admin', 'l20lq_iso17025.png', 'iso17025.png', 52382, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (20, '2024-08-06 22:35:26.261069', 'admin', 'n7k3c_ourWarranty.png', 'ourWarranty.png', 8836, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (21, '2024-08-06 22:35:26.261069', 'admin', 'ns7l0_furniture.png', 'furniture.png', 234097, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (22, '2024-08-06 22:35:26.261069', 'admin', 'o34my_naturalStone.jpg', 'naturalStone.jpg', 1730694, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (23, '2024-08-06 22:35:26.261069', 'admin', 'qa9ys_door.jpg', 'door.jpg', 137680, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (24, '2024-08-06 22:35:26.261069', 'admin', 'r4eg4_artificialStone.jpg', 'artificialStone.jpg', 1939809, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (25, '2024-08-06 22:35:26.261069', 'admin', 'ssnsu_logo-micl.png', 'logo-micl.png', 432640, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (26, '2024-08-06 22:35:26.261069', 'admin', 'u2iqy_logo-bombay-darbar.png', 'logo-bombay-darbar.png', 75487, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (27, '2024-08-06 22:35:26.261069', 'admin', 'unkp6_anil.png', 'anil.png', 767771, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (28, '2024-08-06 22:35:26.261069', 'admin', 'vpktz_9.jpg', '9.jpg', 342683, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (29, '2024-08-06 22:35:26.261069', 'admin', 'wm5xg_home-process-2.png', 'home-process-2.png', 1541488, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (30, '2024-08-06 22:35:26.261069', 'admin', 'xfxmk_qualityService.png', 'qualityService.png', 3554, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (31, '2024-08-06 22:35:26.261069', 'admin', 'y1u23_canyon.jpg', 'canyon.jpg', 2126621, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (32, '2024-08-06 22:35:26.261069', 'admin', 'y3l5i_porcelain.png', 'porcelain.png', 30554, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (33, '2024-08-06 22:35:26.261069', 'admin', 'yasqy_iso.png', 'iso.png', 35523, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (34, '2024-08-06 22:35:26.261069', 'admin', 'ycsa8_gandam.jpeg', 'gandam.jpeg', 425067, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (35, '2024-08-06 22:35:26.261069', 'admin', 'z7v2a_logo-forth-development.png', 'logo-forth-development.png', 81364, 'SsIPzgpd9rFgxJhe3yUxk', 'image/png');
INSERT INTO `storage_file` VALUES (36, '2024-08-15 17:41:58.530789', 'admin', 'tgfbx_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (37, '2024-08-15 17:42:15.301213', 'admin', 'mzun4_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (38, '2024-08-15 17:43:03.084110', 'admin', 'pjn4s_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (39, '2024-08-16 10:16:25.771938', 'admin', 'yuwtm_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (40, '2024-08-16 10:39:37.066453', 'admin', 'mhswv_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (41, '2024-08-16 10:41:24.534307', 'admin', 'oe26s_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (42, '2024-08-16 16:45:09.262199', 'admin', 'cfa44_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (43, '2024-08-16 16:52:08.191920', 'admin', 'pom2e_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (44, '2024-08-16 16:52:17.131483', 'admin', '69tlu_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (45, '2024-08-16 16:52:22.092561', 'admin', '0bght_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (46, '2024-08-16 16:57:47.335749', 'admin', 'bels3_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (47, '2024-08-16 16:57:53.001908', 'admin', '2m2mx_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (48, '2024-08-16 16:57:55.714922', 'admin', '5bdsh_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (49, '2024-08-16 16:58:19.785133', 'admin', 'u3a2u_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (50, '2024-08-16 16:58:23.741695', 'admin', 'mvez1_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (51, '2024-08-16 16:58:27.628529', 'admin', '8c3k8_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (52, '2024-08-16 18:58:01.966275', 'admin', 'ugkyt_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (53, '2024-08-16 18:58:05.398952', 'admin', 'tglvp_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (54, '2024-08-16 18:58:08.741859', 'admin', 'e5y95_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (55, '2024-08-16 18:58:12.471330', 'admin', '89f2m_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (56, '2024-08-16 18:58:15.880225', 'admin', '5jaut_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (57, '2024-08-16 18:58:19.096063', 'admin', '6e1h9_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (58, '2024-08-16 19:04:22.940972', 'admin', 'ajech_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (59, '2024-08-16 19:04:26.043703', 'admin', 'qct8n_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (60, '2024-08-16 19:04:29.781580', 'admin', '9eizl_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (61, '2024-08-16 19:04:33.242779', 'admin', 'b8njn_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (62, '2024-08-16 19:04:36.660385', 'admin', 'cwfww_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (63, '2024-08-16 19:04:39.511860', 'admin', 'j7krd_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (64, '2024-08-16 19:09:36.719226', 'admin', 'c8zyd_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (65, '2024-08-16 19:09:39.598880', 'admin', 'z7up8_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (66, '2024-08-16 19:09:42.707699', 'admin', '0vb52_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (67, '2024-08-16 19:09:45.670853', 'admin', 'ytkgh_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (68, '2024-08-16 19:09:48.461703', 'admin', '21j2u_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (69, '2024-08-16 19:09:51.794293', 'admin', 'ee5hc_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (70, '2024-08-16 19:22:40.352570', 'admin', 't97th_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (71, '2024-08-16 19:22:46.329334', 'admin', 'm8h9b_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (72, '2024-08-16 19:22:49.809654', 'admin', '1gcx6_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (73, '2024-08-16 19:22:53.923151', 'admin', '3oruf_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (74, '2024-08-16 19:22:56.816428', 'admin', 'yyisg_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (75, '2024-08-16 19:23:00.957641', 'admin', 'v8o2c_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (76, '2024-08-16 19:31:46.074056', 'admin', '525xw_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (77, '2024-08-16 19:31:49.291493', 'admin', 'gm45l_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (78, '2024-08-16 19:31:52.514237', 'admin', '80vq8_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (79, '2024-08-16 19:31:55.814683', 'admin', 'gbwv3_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (80, '2024-08-16 19:31:59.334406', 'admin', 'ogjek_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (81, '2024-08-16 19:32:02.514494', 'admin', '1fd0z_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (82, '2024-08-16 19:39:12.115207', 'admin', 'rp6fs_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (83, '2024-08-16 19:39:15.790367', 'admin', 'hp1gl_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (84, '2024-08-16 19:39:19.758688', 'admin', '3k71o_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (85, '2024-08-16 19:39:23.895261', 'admin', 'im8ur_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (86, '2024-08-16 19:39:26.926463', 'admin', 'q3z7v_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (87, '2024-08-16 19:39:30.266810', 'admin', 'ohy1t_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');
INSERT INTO `storage_file` VALUES (88, '2024-08-16 20:44:49.300717', 'admin', 'c808d_bg.jpg', 'bg.jpg', 2079540, 'SsIPzgpd9rFgxJhe3yUxk', 'image/jpeg');

SET FOREIGN_KEY_CHECKS = 1;
