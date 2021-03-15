/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : metro

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/03/2021 13:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achieve_owner
-- ----------------------------
DROP TABLE IF EXISTS `achieve_owner`;
CREATE TABLE `achieve_owner`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NULL DEFAULT NULL,
  `category` int(20) NULL DEFAULT NULL,
  `progress` int(20) NULL DEFAULT NULL,
  `is_reach` int(1) NULL DEFAULT NULL,
  `achievement_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `achievement_id`(`achievement_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `achieve_owner_ibfk_1` FOREIGN KEY (`achievement_id`) REFERENCES `achievement` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `achieve_owner_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of achieve_owner
-- ----------------------------
INSERT INTO `achieve_owner` VALUES (3, 1, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (4, 1, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (5, 1, 2, 1000, 1, 3);
INSERT INTO `achieve_owner` VALUES (6, 1, 2, 1185, 0, 4);
INSERT INTO `achieve_owner` VALUES (7, 1, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (8, 1, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (9, 4, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (10, 4, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (11, 4, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (12, 4, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (13, 4, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (14, 4, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (15, 7, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (16, 7, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (17, 7, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (18, 7, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (19, 7, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (20, 7, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (21, 8, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (22, 8, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (23, 8, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (24, 8, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (25, 8, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (26, 8, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (27, 9, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (28, 9, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (29, 9, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (30, 9, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (31, 9, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (32, 9, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (33, 10, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (34, 10, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (35, 10, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (36, 10, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (37, 10, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (38, 10, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (39, 11, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (40, 11, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (41, 11, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (42, 11, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (43, 11, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (44, 11, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (45, 12, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (46, 12, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (47, 12, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (48, 12, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (49, 12, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (50, 12, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (51, 13, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (52, 13, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (53, 13, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (54, 13, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (55, 13, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (56, 13, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (57, 14, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (58, 14, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (59, 14, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (60, 14, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (61, 14, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (62, 14, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (63, 15, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (64, 15, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (65, 15, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (66, 15, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (67, 15, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (68, 15, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (69, 16, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (70, 16, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (71, 16, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (72, 16, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (73, 16, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (74, 16, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (75, 17, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (76, 17, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (77, 17, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (78, 17, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (79, 17, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (80, 17, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (81, 18, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (82, 18, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (83, 18, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (84, 18, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (85, 18, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (86, 18, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (87, 19, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (88, 19, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (89, 19, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (90, 19, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (91, 19, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (92, 19, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (93, 20, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (94, 20, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (95, 20, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (96, 20, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (97, 20, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (98, 20, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (99, 21, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (100, 21, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (101, 21, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (102, 21, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (103, 21, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (104, 21, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (105, 22, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (106, 22, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (107, 22, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (108, 22, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (109, 22, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (110, 22, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (111, 23, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (112, 23, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (113, 23, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (114, 23, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (115, 23, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (116, 23, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (117, 24, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (118, 24, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (119, 24, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (120, 24, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (121, 24, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (122, 24, 4, 0, 0, 6);
INSERT INTO `achieve_owner` VALUES (123, 25, 1, 0, 0, 1);
INSERT INTO `achieve_owner` VALUES (124, 25, 1, 0, 0, 2);
INSERT INTO `achieve_owner` VALUES (125, 25, 2, 0, 0, 3);
INSERT INTO `achieve_owner` VALUES (126, 25, 2, 0, 0, 4);
INSERT INTO `achieve_owner` VALUES (127, 25, 3, 0, 0, 5);
INSERT INTO `achieve_owner` VALUES (128, 25, 4, 0, 0, 6);

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `achieve_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `condition` int(20) NULL DEFAULT NULL,
  `category` int(20) NULL DEFAULT NULL,
  `reward` int(20) NULL DEFAULT NULL,
  `kind` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES (1, '总金币超过500枚', '/xx/xx', 500, 1, 200, 1);
INSERT INTO `achievement` VALUES (2, '总金币超过1000枚', '/xx/xx', 1000, 1, 200, 1);
INSERT INTO `achievement` VALUES (3, '单句跑过1000米', '/xx/xx', 1000, 2, 200, 1);
INSERT INTO `achievement` VALUES (4, '单句跑过5000米', '/xx/xx', 5000, 2, 10, 0);
INSERT INTO `achievement` VALUES (5, '完成3次拼图', '/xx/xx', 3, 3, 200, 1);
INSERT INTO `achievement` VALUES (6, '获得吸铁石10次', '/xx/xx', 10, 4, 200, 1);

-- ----------------------------
-- Table structure for addfriend
-- ----------------------------
DROP TABLE IF EXISTS `addfriend`;
CREATE TABLE `addfriend`  (
  `friend1` int(10) NULL DEFAULT NULL,
  `friend2` int(10) NULL DEFAULT NULL,
  `friend1_allow` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `friend2_allow` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of addfriend
-- ----------------------------
INSERT INTO `addfriend` VALUES (1, 4, 'Y', '');
INSERT INTO `addfriend` VALUES (1, 7, 'Y', 'Y');
INSERT INTO `addfriend` VALUES (8, 7, 'Y', NULL);
INSERT INTO `addfriend` VALUES (4, 8, 'Y', 'Y');
INSERT INTO `addfriend` VALUES (1, 4, 'Y', NULL);
INSERT INTO `addfriend` VALUES (1, 16, 'Y', NULL);
INSERT INTO `addfriend` VALUES (1, 4, 'Y', NULL);
INSERT INTO `addfriend` VALUES (1, 16, 'Y', NULL);
INSERT INTO `addfriend` VALUES (1, 10, 'Y', NULL);
INSERT INTO `addfriend` VALUES (1, 4, 'Y', NULL);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456', 'admin');
INSERT INTO `admin` VALUES ('reader', '123456', 'reader');
INSERT INTO `admin` VALUES ('root', 'root', 'root');

-- ----------------------------
-- Table structure for carbon_ranking
-- ----------------------------
DROP TABLE IF EXISTS `carbon_ranking`;
CREATE TABLE `carbon_ranking`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `daily_score` int(25) NULL DEFAULT NULL,
  `week_score` int(25) NULL DEFAULT NULL,
  `total_score` int(25) NULL DEFAULT NULL,
  `daily_ranking` int(20) NULL DEFAULT NULL,
  `week_ranking` int(20) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `carbon_ranking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carbon_ranking
-- ----------------------------
INSERT INTO `carbon_ranking` VALUES (1, 0, 0, 600, 1, 1, 1);
INSERT INTO `carbon_ranking` VALUES (2, 0, 0, 3, -1, -1, 4);
INSERT INTO `carbon_ranking` VALUES (5, 0, 0, 0, -1, -1, 7);
INSERT INTO `carbon_ranking` VALUES (6, 0, 0, 0, -1, -1, 8);
INSERT INTO `carbon_ranking` VALUES (7, 0, 0, 0, -1, -1, 9);
INSERT INTO `carbon_ranking` VALUES (8, 0, 0, 0, -1, -1, 10);
INSERT INTO `carbon_ranking` VALUES (9, 0, 0, 0, -1, -1, 11);
INSERT INTO `carbon_ranking` VALUES (10, 0, 0, 0, -1, -1, 12);
INSERT INTO `carbon_ranking` VALUES (11, 0, 0, 0, -1, -1, 13);
INSERT INTO `carbon_ranking` VALUES (12, 0, 0, 0, -1, -1, 14);
INSERT INTO `carbon_ranking` VALUES (13, 0, 0, 0, -1, -1, 15);
INSERT INTO `carbon_ranking` VALUES (14, 0, 0, 0, -1, -1, 16);
INSERT INTO `carbon_ranking` VALUES (15, 0, 0, 0, -1, -1, 17);
INSERT INTO `carbon_ranking` VALUES (16, 0, 0, 0, -1, -1, 18);
INSERT INTO `carbon_ranking` VALUES (17, 0, 0, 0, -1, -1, 19);
INSERT INTO `carbon_ranking` VALUES (18, 0, 0, 0, -1, -1, 20);
INSERT INTO `carbon_ranking` VALUES (19, 0, 0, 0, -1, -1, 21);
INSERT INTO `carbon_ranking` VALUES (20, 0, 0, 0, -1, -1, 22);
INSERT INTO `carbon_ranking` VALUES (21, 0, 0, 0, -1, -1, 23);
INSERT INTO `carbon_ranking` VALUES (22, 0, 0, 0, -1, -1, 24);
INSERT INTO `carbon_ranking` VALUES (23, 0, 0, 0, -1, -1, 25);

-- ----------------------------
-- Table structure for coin
-- ----------------------------
DROP TABLE IF EXISTS `coin`;
CREATE TABLE `coin`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `coin_number` int(25) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  `week_number` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `coin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coin
-- ----------------------------
INSERT INTO `coin` VALUES (1, 4007, 1, 0);
INSERT INTO `coin` VALUES (2, 565, 4, 0);
INSERT INTO `coin` VALUES (5, 60, 7, 0);
INSERT INTO `coin` VALUES (6, 0, 8, 0);
INSERT INTO `coin` VALUES (7, 0, 9, 0);
INSERT INTO `coin` VALUES (8, 0, 10, 0);
INSERT INTO `coin` VALUES (9, 0, 11, 0);
INSERT INTO `coin` VALUES (10, 0, 12, 0);
INSERT INTO `coin` VALUES (11, 0, 13, 0);
INSERT INTO `coin` VALUES (12, 0, 14, 0);
INSERT INTO `coin` VALUES (13, 0, 15, 0);
INSERT INTO `coin` VALUES (14, 0, 16, 0);
INSERT INTO `coin` VALUES (15, 0, 17, 0);
INSERT INTO `coin` VALUES (16, 0, 18, 0);
INSERT INTO `coin` VALUES (17, 0, 19, 0);
INSERT INTO `coin` VALUES (18, 0, 20, 0);
INSERT INTO `coin` VALUES (19, 0, 21, 0);
INSERT INTO `coin` VALUES (20, 0, 22, 0);
INSERT INTO `coin` VALUES (21, 0, 23, 0);
INSERT INTO `coin` VALUES (22, 0, 24, 0);
INSERT INTO `coin` VALUES (23, 0, 25, 0);

-- ----------------------------
-- Table structure for dressup
-- ----------------------------
DROP TABLE IF EXISTS `dressup`;
CREATE TABLE `dressup`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `dress_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int(20) NULL DEFAULT NULL,
  `dressup_id` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dressup_id`(`dressup_id`) USING BTREE,
  CONSTRAINT `dressup_ibfk_1` FOREIGN KEY (`dressup_id`) REFERENCES `dressup_sort` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dressup
-- ----------------------------
INSERT INTO `dressup` VALUES (1, '/image/hat1.png', 50, 1);

-- ----------------------------
-- Table structure for dressup_owner
-- ----------------------------
DROP TABLE IF EXISTS `dressup_owner`;
CREATE TABLE `dressup_owner`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NULL DEFAULT NULL,
  `dressup_id` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `dressup_id`(`dressup_id`) USING BTREE,
  CONSTRAINT `dressup_owner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dressup_owner_ibfk_2` FOREIGN KEY (`dressup_id`) REFERENCES `dressup` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dressup_owner
-- ----------------------------
INSERT INTO `dressup_owner` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for dressup_sort
-- ----------------------------
DROP TABLE IF EXISTS `dressup_sort`;
CREATE TABLE `dressup_sort`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dressup_sort
-- ----------------------------
INSERT INTO `dressup_sort` VALUES (1, '帽子');
INSERT INTO `dressup_sort` VALUES (2, '衣服');
INSERT INTO `dressup_sort` VALUES (3, '裤子');
INSERT INTO `dressup_sort` VALUES (4, '鞋子');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `f_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, '这个东西太好玩了', '2020-02-11 08:03:44', 4, '李四');
INSERT INTO `feedback` VALUES (2, '游戏正好', '2020-02-11 13:04:52', 1, '张三');
INSERT INTO `feedback` VALUES (3, '游戏正好', '2020-02-19 21:11:26', 4, '张三');
INSERT INTO `feedback` VALUES (4, '游戏正好', '2020-02-19 21:12:02', 1, '张三');
INSERT INTO `feedback` VALUES (5, '什么鬼', '2020-02-19 21:12:20', 1, '张三');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `friend1` int(10) NULL DEFAULT NULL,
  `friend2` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (4, 8);
INSERT INTO `friend` VALUES (4, 7);
INSERT INTO `friend` VALUES (1, 15);
INSERT INTO `friend` VALUES (1, 13);
INSERT INTO `friend` VALUES (1, 11);
INSERT INTO `friend` VALUES (1, 12);
INSERT INTO `friend` VALUES (1, 14);

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `entertainment` int(20) NULL DEFAULT NULL,
  `bodybuilding` int(20) NULL DEFAULT NULL,
  `speedContest` int(20) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `game_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, 1584697193, 1582191593, 1582623593, 1);
INSERT INTO `game` VALUES (2, NULL, NULL, NULL, 4);
INSERT INTO `game` VALUES (3, NULL, NULL, NULL, 7);
INSERT INTO `game` VALUES (4, NULL, NULL, NULL, 8);
INSERT INTO `game` VALUES (5, NULL, NULL, NULL, 9);
INSERT INTO `game` VALUES (6, NULL, NULL, NULL, 10);
INSERT INTO `game` VALUES (7, NULL, NULL, NULL, 11);
INSERT INTO `game` VALUES (8, NULL, NULL, NULL, 12);
INSERT INTO `game` VALUES (9, NULL, NULL, NULL, 13);
INSERT INTO `game` VALUES (10, NULL, NULL, NULL, 14);
INSERT INTO `game` VALUES (11, NULL, NULL, NULL, 15);
INSERT INTO `game` VALUES (12, NULL, NULL, NULL, 16);
INSERT INTO `game` VALUES (13, NULL, NULL, NULL, 17);
INSERT INTO `game` VALUES (14, NULL, NULL, NULL, 18);
INSERT INTO `game` VALUES (15, NULL, NULL, NULL, 19);
INSERT INTO `game` VALUES (16, NULL, NULL, NULL, 20);
INSERT INTO `game` VALUES (17, NULL, NULL, NULL, 21);
INSERT INTO `game` VALUES (18, NULL, NULL, NULL, 22);
INSERT INTO `game` VALUES (19, NULL, NULL, NULL, 23);
INSERT INTO `game` VALUES (20, NULL, NULL, NULL, 24);
INSERT INTO `game` VALUES (21, NULL, NULL, NULL, 25);

-- ----------------------------
-- Table structure for history_dgame
-- ----------------------------
DROP TABLE IF EXISTS `history_dgame`;
CREATE TABLE `history_dgame`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `c_time` time(0) NULL DEFAULT NULL,
  `result` int(1) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `history_dgame_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history_dgame
-- ----------------------------

-- ----------------------------
-- Table structure for history_integral
-- ----------------------------
DROP TABLE IF EXISTS `history_integral`;
CREATE TABLE `history_integral`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `num` int(20) NULL DEFAULT NULL,
  `h_date` datetime(0) NULL DEFAULT NULL,
  `reason` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `history_integral_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history_integral
-- ----------------------------

-- ----------------------------
-- Table structure for history_puzzle
-- ----------------------------
DROP TABLE IF EXISTS `history_puzzle`;
CREATE TABLE `history_puzzle`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `complete_time` time(0) NULL DEFAULT NULL,
  `complete_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  `puzzle_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `puzzle_id`(`puzzle_id`) USING BTREE,
  CONSTRAINT `history_puzzle_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_puzzle_ibfk_2` FOREIGN KEY (`puzzle_id`) REFERENCES `pic_puzzle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history_puzzle
-- ----------------------------

-- ----------------------------
-- Table structure for history_sgame
-- ----------------------------
DROP TABLE IF EXISTS `history_sgame`;
CREATE TABLE `history_sgame`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `num` int(20) NULL DEFAULT NULL,
  `distance` int(20) NULL DEFAULT NULL,
  `user_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `history_sgame_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history_sgame
-- ----------------------------

-- ----------------------------
-- Table structure for integral_owner
-- ----------------------------
DROP TABLE IF EXISTS `integral_owner`;
CREATE TABLE `integral_owner`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NULL DEFAULT NULL,
  `mall_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `mall_id`(`mall_id`) USING BTREE,
  CONSTRAINT `integral_owner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `integral_owner_ibfk_2` FOREIGN KEY (`mall_id`) REFERENCES `mall` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of integral_owner
-- ----------------------------

-- ----------------------------
-- Table structure for mall
-- ----------------------------
DROP TABLE IF EXISTS `mall`;
CREATE TABLE `mall`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int(20) NULL DEFAULT NULL,
  `capacity` int(20) NULL DEFAULT NULL,
  `remaining_capacity` int(20) NULL DEFAULT NULL,
  `kind` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall
-- ----------------------------
INSERT INTO `mall` VALUES (1, '地铁乘车5元现金券', '现金券介绍', '/image/hat1.png', 150, 99, 85, '现金券');
INSERT INTO `mall` VALUES (2, '《地铁是如何建成的》', '书本介绍', '/image/hat1.png', 600, 50, 50, '礼品');
INSERT INTO `mall` VALUES (3, '地铁乘车10元现金券', '现金券介绍', '/image/hat1.png', 300, 150, 150, '现金券');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `notice_date` datetime(0) NULL DEFAULT NULL,
  `duration` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `puzzle_music` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `game_music` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `puzzle_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `game_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addition` int(20) NULL DEFAULT NULL,
  `total_strength` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES (1, '链接(这里先不用)', '链接(这里先不用)', '链接(这里先不用)', '链接(这里先不用)', 2, 100);

-- ----------------------------
-- Table structure for pic_puzzle
-- ----------------------------
DROP TABLE IF EXISTS `pic_puzzle`;
CREATE TABLE `pic_puzzle`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chip_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` int(20) NULL DEFAULT NULL,
  `p_time` time(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pic_puzzle
-- ----------------------------

-- ----------------------------
-- Table structure for prop
-- ----------------------------
DROP TABLE IF EXISTS `prop`;
CREATE TABLE `prop`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `prop_describe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `effect_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prop
-- ----------------------------

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `one` int(10) NULL DEFAULT NULL,
  `two` int(10) NULL DEFAULT NULL,
  `three` int(10) NULL DEFAULT NULL,
  `four` int(10) NULL DEFAULT NULL,
  `five` int(10) NULL DEFAULT NULL,
  `six` int(10) NULL DEFAULT NULL,
  `seven` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES (1, 60, 100, 150, 180, 240, 260, 300);

-- ----------------------------
-- Table structure for statistic
-- ----------------------------
DROP TABLE IF EXISTS `statistic`;
CREATE TABLE `statistic`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `totalnum` int(50) NULL DEFAULT NULL,
  `citynum` int(50) NULL DEFAULT NULL,
  `statime` date NULL DEFAULT NULL,
  `city` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statistic
-- ----------------------------
INSERT INTO `statistic` VALUES (1, 3, 3, '2020-04-03', '广东省广州市');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `u_id` int(20) NOT NULL,
  `gender` int(2) NULL DEFAULT 0,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `statement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `default_station` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `current_strength` int(20) NULL DEFAULT NULL,
  `head_portrait` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 1, 'Tristen', '广东省广州市', '节能减排，绿色出行从我做起！\n    耶(＾－＾)V', '天一站', 80, '/headPicUploadImg/head1.jpg');
INSERT INTO `user` VALUES (4, 2, 0, 'Deom', '江苏省无锡市', NULL, NULL, 100, '/headPicUploadImg/head2.jpg');
INSERT INTO `user` VALUES (7, 3, 0, 'DD', '江苏省无锡市', NULL, NULL, 100, '/headPicUploadImg/head3.jpg');
INSERT INTO `user` VALUES (8, 33, 0, 'Leo', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head4.jpg');
INSERT INTO `user` VALUES (9, 4, NULL, '么', '广东省广州市', NULL, NULL, 100, '/headPicUploadImg/head5.jpg');
INSERT INTO `user` VALUES (10, 5, NULL, 'Callvin', '浙江省宁波市', NULL, NULL, 100, '/headPicUploadImg/head6.jpg');
INSERT INTO `user` VALUES (11, 6, NULL, 'Tarset', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head7.jpg');
INSERT INTO `user` VALUES (12, 7, NULL, 'Leetrct', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head8.jpg');
INSERT INTO `user` VALUES (13, 8, NULL, '喜洋洋', '浙江省宁波市', NULL, NULL, 100, '/headPicUploadImg/head9.jpg');
INSERT INTO `user` VALUES (14, 9, NULL, '懒洋洋', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head10.jpg');
INSERT INTO `user` VALUES (15, 10, NULL, '软绵绵', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head11.jpg');
INSERT INTO `user` VALUES (16, 11, NULL, '红太狼', '浙江省宁波市', NULL, NULL, 100, '/headPicUploadImg/head12.jpg');
INSERT INTO `user` VALUES (17, 12, NULL, '鲸鱼', '浙江省宁波市', NULL, NULL, 100, '/headPicUploadImg/head13.jpg');
INSERT INTO `user` VALUES (18, 13, NULL, '毛毛', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head14.jpg');
INSERT INTO `user` VALUES (19, 14, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (20, 15, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (21, 16, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (22, 17, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (23, 18, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (24, 19, NULL, '匿名用户', '浙江省绍兴市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');
INSERT INTO `user` VALUES (25, 20, 0, '匿名用户', '广东省广州市', NULL, NULL, 100, '/headPicUploadImg/head.jpg');

SET FOREIGN_KEY_CHECKS = 1;
