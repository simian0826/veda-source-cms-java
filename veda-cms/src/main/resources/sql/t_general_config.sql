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

 Date: 29/07/2024 16:17:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_general_config
-- ----------------------------
DROP TABLE IF EXISTS `t_general_config`;
CREATE TABLE `t_general_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` json DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'Active: 1, Inactive: 0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Records of t_general_config
-- ----------------------------
BEGIN;
INSERT INTO `t_general_config` (`id`, `data`, `type`, `create_date`, `update_date`, `status`) VALUES (2, '{\"leaders\": [1, 2], \"clientLogos\": [\"http://localhost:8080/veda-source/storage/fetch/ssnsu_logo-micl.png\", \"http://localhost:8080/veda-source/storage/fetch/z7v2a_logo-forth-development.png\", \"http://localhost:8080/veda-source/storage/fetch/u2iqy_logo-bombay-darbar.png\", \"http://localhost:8080/veda-source/storage/fetch/z7v2a_logo-forth-development.png\"], \"processItems\": [{\"image\": \"http://localhost:8080/veda-source/storage/fetch/1169y_home-process-1.png\", \"title\": \"PRODUCT SELECTION\", \"detailText\": \"Our team is constantly scouring the globe to find new materials and inspiration. We work directly with manufacturers to secure the best rates for our customers.\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/wm5xg_home-process-2.png\", \"title\": \"QUALITY CONTROL\", \"detailText\": \"Oversight at very level of the manufacturing and packaging process helps us maintain the highest standards of quality. All of our products are vigorously tested and certified by the appropriate authorities.\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/6eoqw_home-process-3.png\", \"title\": \"TRANSPORT & DELIVERY\", \"detailText\": \"From the manufacturer\'s warehouse to your project site, we work with freight providers to ensure that your goods will arrive right on schedule.\"}], \"introductionItems\": [{\"image\": \"http://localhost:8080/veda-source/storage/fetch/y1u23_canyon.jpg\", \"title\": \"This copy introduces the product title 1\", \"infoLeft\": {\"info\": \"90+\", \"supplementary\": \"supplementary 2\"}, \"subTitle\": \"STARTINGG EROM SX/SCOFT\", \"infoRight\": {\"info\": \"80%\", \"supplementary\": \"supplementary 1\"}, \"productId\": 1, \"description\": \"This copy introduces the product abstract This copy intro-duces the product abstract This copy introduces the product abstract This copy introduces the product abstract This copy introduces the product abstract This copy introducesthe product abstract This copy introduces the product abstract\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/ycsa8_gandam.jpeg\", \"title\": \"This copy introduces the product title 2\", \"infoLeft\": {\"info\": \"#222\", \"supplementary\": \"supplementary 2\"}, \"subTitle\": \"STARTINGG EROM SX/SCOFT\", \"infoRight\": {\"info\": \"$ 65\", \"supplementary\": \"supplementary 1\"}, \"productId\": 2, \"description\": \"This copy introduces the product abstract This copy intro-duces the product abstract This copy introduces the product abstract This copy introduces the product abstract This copy introduces the product abstract This copy introducesthe product abstract This copy introduces the product abstract\"}], \"productCategoryItems\": [{\"image\": \"http://localhost:8080/veda-source/storage/fetch/6mff4_tiles.jpg\", \"title\": \"Tiles\", \"category\": \"Tiles\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/o34my_naturalStone.jpg\", \"title\": \"Natural Stones\", \"category\": \"Natural Stones\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/r4eg4_artificialStone.jpg\", \"title\": \"Artificial Stone\", \"category\": \"Artificial Stones\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/qa9ys_door.jpg\", \"title\": \"Doors\", \"category\": \"Doors\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/y3l5i_porcelain.png\", \"title\": \"Cladding\", \"category\": \"Cladding\"}, {\"image\": \"http://localhost:8080/veda-source/storage/fetch/ns7l0_furniture.png\", \"title\": \"Cabinetry\", \"category\": \"Cabinetry\"}]}', 'home', '2024-07-10 17:12:26', '2024-07-17 15:34:38', '1');
INSERT INTO `t_general_config` (`id`, `data`, `type`, `create_date`, `update_date`, `status`) VALUES (3, '{\"teamMembers\": [1, 2, 3, 4], \"needHelpDesc\": \"Our team is standing by to make sure you get the help you need. Whether you need to place an order or adjust delivery details, we\'re ready to help!\", \"qualityItems\": [{\"desc\": \"All our products — whether we make them or not — are backed by our warranty.\", \"image\": \"http://localhost:8080/veda-source/storage/fetch/n7k3c_ourWarranty.png\", \"title\": \"Our Warranty\"}, {\"desc\": \"Can\'t find what you\'re looking for? We\'ll go on a hunt to find exactly what you need.\", \"image\": \"http://localhost:8080/veda-source/storage/fetch/fwjtf_on-timeDelivery.png\", \"title\": \"Shopping Experience\"}, {\"desc\": \"We ensure that your project gets the right materials at the rig\", \"image\": \"http://localhost:8080/veda-source/storage/fetch/xfxmk_qualityService.png\", \"title\": \"On-time Delivery\"}, {\"desc\": \"Whether you need technical support or just a chat, we\'re here for you.\", \"image\": \"http://localhost:8080/veda-source/storage/fetch/99gg7_shoppingExperience.png\", \"title\": \"Quality Service\"}], \"needHelpHeader\": \"Reach Us\"}', 'aboutUs', '2024-07-15 14:42:29', '2024-07-18 22:39:56', '1');
INSERT INTO `t_general_config` (`id`, `data`, `type`, `create_date`, `update_date`, `status`) VALUES (4, '{\"email\": \"xinyu@miclglobal.com\", \"address\": \"MICL Global INC. 7 Mckee Place Cheshire, CT 06410\"}', 'basicInfo', '2024-07-24 12:06:20', '2024-07-24 12:06:39', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
