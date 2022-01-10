/*
Navicat MySQL Data Transfer

Source Server         : dcq
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : xuanke

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-01-07 08:38:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生日',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cardId` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `level` int(10) NOT NULL DEFAULT '1' COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员信息表';

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '男', '22', '2021-02-27 18:25:37', '18843232356', '上海市', '111', 'aa@163.com', '342425199001116372', '1');
INSERT INTO `admin_info` VALUES ('2', 'admin2', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '男', '23', '2021-02-27 18:25:37', '18843232356', '北京市', '222', 'bb@163.com', '342425199001116376', '1');
INSERT INTO `admin_info` VALUES ('3', 'admin3', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '女', '32', '2021-02-27 18:25:37', '18843232356', '合肥市', '333', 'cc@163.com', '342425199001116323', '1');

-- ----------------------------
-- Table structure for advertiser_info
-- ----------------------------
DROP TABLE IF EXISTS `advertiser_info`;
CREATE TABLE `advertiser_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公告名称',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '公告内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公告时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='公告信息表';

-- ----------------------------
-- Records of advertiser_info
-- ----------------------------
INSERT INTO `advertiser_info` VALUES ('1', '即将选课通知！', '<p>这是系统公告，管理员可以在后台修改</p><p><br></p><p>马上要选课啦！大家做好准备！</p>', '2021-02-27 23:35:14');
INSERT INTO `advertiser_info` VALUES ('2', '我校学子在2021年美国大学生数学建模竞赛中再获佳绩', '<p>我校师生于去年12月开始备赛，比赛由校领导牵头，学工处、教务处及各学部中心提供支持，公共课部广泛宣传和动员，学生积极参与，利用周末、寒假时间进行培训与赛前演练。公共课部主任尹水仿非常重视并亲自部署重要工作，数理中心教师徐忠昌、马倩、李长伟负责培训并带领梅嘉俊、郑克太、郑钦杰、张子睿等9名学生代表学校参加本次比赛。</p><p>2021年美国大学生数学建模竞赛比赛时间为北京时间‍‍‍‍‍‍‍‍‍2月5日上午6:00至2月9日上午9:00。正值春节前夕，选手安心比赛，在4日内完成了题目分析、建立以及求解模型、验证结果的合理性、完英文论文撰写等工作。</p><p>美国大学生数学建模竞赛(MCM/ICM)由COMAP(the Consortium for Mathematics and Its Application)美国数学及其应用联合会主办，竞赛包括MCM/ICM两种类型：Mathematical Contest In Modeling (数学建模竞赛)和 Interdisciplinary Contest In Modeling (跨学科建模竞赛)。共有国内外1576所院校的代表队，共计26112个队伍参赛，包括77594名学生。</p><p>我校已经连续多年参加全国大学生数学建模比赛和美国大学生数学建模比赛，参赛人数以及获奖比例逐年提高，学生解决问题能力得到了锻炼，学校在实践教学、三全育人层面培养了一批具有创新能力的应用型人才。</p>', '2021-04-28 18:00:22');
INSERT INTO `advertiser_info` VALUES ('3', '湖北文理学院理工学院来我校考察交流', '<p>新闻网讯(记者刘书翔)4月22日，湖北文理学院理工学院常务副校长耿帮才率相关工作人员一行6人来我校考察交流。工会主席吴翠红热情接待了来访嘉宾。双方在行政楼A315会议室座谈进行深入交流，学校相关单位负责人参加座谈。</p><p>&nbsp;</p><p class=\"ql-align-center\"><img src=\"http://www.city.wust.edu.cn/upload/20210425/202104251511408880.JPG\"></p><p class=\"ql-align-center\">&nbsp;</p><p>吴翠红对湖北文理学院理工学院一行的到来表示热烈欢迎，向来宾们详细介绍了我校的发展历程以及近年来发展取得的成就。双方就转设过程中如何有效推动学校各项工作高质量发展进行了深入的交流。</p><p>耿帮才代表湖北文理学院理工学院感谢我校的热情接待，对我校学科建设、教学科研水平、基础设施建设等工作给予高度赞扬，希望两校加强交流，共同进步，为促进湖北高校教育的发展作出努力。</p><p>座谈会后，两校相关负责人展开一对一交流，就学校各项工作做深入探讨。来访嘉宾还实地走访参观，深入了解校园环境、教育教学设施及办学情况。</p>', '2021-04-28 18:00:59');
INSERT INTO `advertiser_info` VALUES ('4', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('5', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('6', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('7', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('8', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('9', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');
INSERT INTO `advertiser_info` VALUES ('10', '系统公告', '这是系统公告，管理员可以在后台修改', '2021-02-27 18:25:37');

-- ----------------------------
-- Table structure for auto_fill
-- ----------------------------
DROP TABLE IF EXISTS `auto_fill`;
CREATE TABLE `auto_fill` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(22) DEFAULT '0',
  `is_delete` int(22) DEFAULT '1' COMMENT '逻辑删除   0为删除，1为没删',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人  来自于自动填充，如果没有system',
  `update_by` varchar(255) DEFAULT NULL COMMENT '编辑人  自动填充，如果没有为system',
  `create_time` datetime DEFAULT NULL COMMENT '创建数据的时间',
  `update_time` datetime DEFAULT NULL COMMENT '数据修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_fill
-- ----------------------------
INSERT INTO `auto_fill` VALUES ('1', '张曼玉', '19', null, null, null, null, '2021-11-11 11:20:17');
INSERT INTO `auto_fill` VALUES ('2', '林青霞', '29', '1', null, 'system', null, null);
INSERT INTO `auto_fill` VALUES ('8', '林青霞', '18', null, 'system', 'system', '2021-11-11 11:27:20', '2021-11-11 11:27:20');
INSERT INTO `auto_fill` VALUES ('9', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:33', '2021-11-11 14:06:33');
INSERT INTO `auto_fill` VALUES ('10', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:33', '2021-11-11 14:06:33');
INSERT INTO `auto_fill` VALUES ('11', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:34', '2021-11-11 14:06:34');
INSERT INTO `auto_fill` VALUES ('12', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:35', '2021-11-11 14:06:35');
INSERT INTO `auto_fill` VALUES ('13', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:36', '2021-11-11 14:06:36');
INSERT INTO `auto_fill` VALUES ('14', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:36', '2021-11-11 14:06:36');
INSERT INTO `auto_fill` VALUES ('15', '张三', '18', null, 'system', 'system', '2021-11-11 14:06:37', '2021-11-11 14:06:37');
INSERT INTO `auto_fill` VALUES ('16', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:37', '2021-11-11 14:06:37');
INSERT INTO `auto_fill` VALUES ('17', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:38', '2021-11-11 14:06:38');
INSERT INTO `auto_fill` VALUES ('18', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:43', '2021-11-11 14:06:43');
INSERT INTO `auto_fill` VALUES ('19', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:46', '2021-11-11 14:06:46');
INSERT INTO `auto_fill` VALUES ('20', '张三', '18', null, 'system', 'system', '2021-11-11 14:06:50', '2021-11-11 14:06:50');
INSERT INTO `auto_fill` VALUES ('21', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:51', '2021-11-11 14:06:51');
INSERT INTO `auto_fill` VALUES ('22', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:51', '2021-11-11 14:06:51');
INSERT INTO `auto_fill` VALUES ('23', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:52', '2021-11-11 14:06:52');
INSERT INTO `auto_fill` VALUES ('24', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:06:57', '2021-11-11 14:06:57');
INSERT INTO `auto_fill` VALUES ('25', '李四', '18', null, 'system', 'system', '2021-11-11 14:07:00', '2021-11-11 14:07:00');
INSERT INTO `auto_fill` VALUES ('26', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:07:01', '2021-11-11 14:07:01');
INSERT INTO `auto_fill` VALUES ('27', '张曼玉', '18', null, 'system', 'system', '2021-11-11 14:07:01', '2021-11-11 14:07:01');
INSERT INTO `auto_fill` VALUES ('28', '林青霞', '18', null, 'system', 'system', '2021-11-11 14:07:02', '2021-11-11 14:07:02');
INSERT INTO `auto_fill` VALUES ('29', '林青霞', '18', null, 'system', 'system', '2021-11-15 18:59:22', '2021-11-15 18:59:22');
INSERT INTO `auto_fill` VALUES ('30', '林青霞', '18', null, 'system', 'system', '2021-11-15 19:05:52', '2021-11-15 19:05:52');
INSERT INTO `auto_fill` VALUES ('31', '张曼玉', '19', null, 'system', 'system', '2021-11-15 19:42:43', '2021-11-15 19:42:43');
INSERT INTO `auto_fill` VALUES ('32', '张曼玉', '19', null, 'system', 'system', '2021-11-15 19:47:40', '2021-11-15 19:47:40');
INSERT INTO `auto_fill` VALUES ('33', '张曼玉', '19', null, 'system', 'system', '2021-11-15 19:48:07', '2021-11-15 19:48:07');
INSERT INTO `auto_fill` VALUES ('34', '张曼玉', '199', null, 'system', 'system', '2021-11-16 10:20:59', '2021-11-16 10:20:59');
INSERT INTO `auto_fill` VALUES ('35', '张曼玉', '199', null, 'system', 'system', '2021-11-16 10:40:33', '2021-11-16 10:40:33');
INSERT INTO `auto_fill` VALUES ('36', '张曼玉', '199', null, 'system', 'system', '2021-11-16 10:48:52', '2021-11-16 10:48:52');
INSERT INTO `auto_fill` VALUES ('37', '张曼玉', '199', null, 'system', 'system', '2021-11-16 10:53:22', null);
INSERT INTO `auto_fill` VALUES ('38', '张曼玉', '199', null, 'system', 'system', '2021-11-16 10:55:43', null);
INSERT INTO `auto_fill` VALUES ('39', '张曼玉', '199', null, 'system', 'system', '2021-11-16 11:16:10', null);
INSERT INTO `auto_fill` VALUES ('40', '张曼玉', '199', null, 'system', 'system', '2021-11-17 14:22:48', null);
INSERT INTO `auto_fill` VALUES ('41', '王五', '18', '1', null, null, null, null);

-- ----------------------------
-- Table structure for auto_gill
-- ----------------------------
DROP TABLE IF EXISTS `auto_gill`;
CREATE TABLE `auto_gill` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) DEFAULT NULL,
  `aid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_gill
-- ----------------------------
INSERT INTO `auto_gill` VALUES ('1', '小王', '1');
INSERT INTO `auto_gill` VALUES ('2', '小田', '1');
INSERT INTO `auto_gill` VALUES ('3', '小李', '1');
INSERT INTO `auto_gill` VALUES ('4', '小狗', '2');
INSERT INTO `auto_gill` VALUES ('5', '小猪', '2');

-- ----------------------------
-- Table structure for comment_kecheng_info
-- ----------------------------
DROP TABLE IF EXISTS `comment_kecheng_info`;
CREATE TABLE `comment_kecheng_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论时间',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论人',
  `foreignId` bigint(20) DEFAULT NULL COMMENT '关联的模块id',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='课程评论信息表';

-- ----------------------------
-- Records of comment_kecheng_info
-- ----------------------------
INSERT INTO `comment_kecheng_info` VALUES ('1', '66666', '2021-04-02 20:35:15', '赵同学', '4', '0');

-- ----------------------------
-- Table structure for comment_zhuyishixiang_info
-- ----------------------------
DROP TABLE IF EXISTS `comment_zhuyishixiang_info`;
CREATE TABLE `comment_zhuyishixiang_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论时间',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论人',
  `foreignId` bigint(20) DEFAULT NULL COMMENT '关联的模块id',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='注意事项评论信息表';

-- ----------------------------
-- Records of comment_zhuyishixiang_info
-- ----------------------------
INSERT INTO `comment_zhuyishixiang_info` VALUES ('3', '好的一定准时报名', '2021-04-02 20:28:39', '赵同学', '1', '0');

-- ----------------------------
-- Table structure for kecheng_info
-- ----------------------------
DROP TABLE IF EXISTS `kecheng_info`;
CREATE TABLE `kecheng_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程名称',
  `classTime` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上课时间',
  `teacherId` bigint(20) DEFAULT NULL COMMENT '教师id',
  `publishName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布人',
  `publishId` bigint(20) DEFAULT NULL COMMENT '发布人id',
  `publishStatus` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布审核状态',
  `publishReason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布审核理由',
  `publishVerifyName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布审核人',
  `reserveName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约人',
  `reserveId` bigint(20) DEFAULT NULL COMMENT '预约人id',
  `reserveStatus` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约审核状态',
  `reserveReason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约审核理由',
  `reserveVerifyName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约审核人',
  `fileId` bigint(20) DEFAULT NULL COMMENT '文件id',
  `fileName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名',
  `userName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上传人',
  `level` int(10) DEFAULT NULL COMMENT '上传用户等级',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户id',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='课程信息表';

-- ----------------------------
-- Records of kecheng_info
-- ----------------------------
INSERT INTO `kecheng_info` VALUES ('1', '计算机基础', '周一上午第二大节、周三下午第一大节', '1', '张大三', '1', '审核通过', '通过', 'admin', '张同学', '1', '待审核', '通过', null, '0', '', null, null, null, '0');
INSERT INTO `kecheng_info` VALUES ('2', 'Java基础课', '周二上午第一大节、周五下午第二大节', '2', '赵小四', '2', '审核通过', '通过', '赵千里', '钱同学', '3', '待审核', '通过', null, '0', '', null, null, null, '0');
INSERT INTO `kecheng_info` VALUES ('3', 'Java基础课', '周二上午第一大节、周五下午第二大节', '2', '赵小四', '2', '审核通过', '通过', '赵千里', '张同学', '1', '审核通过', '通过', null, '0', '', null, null, null, '2');
INSERT INTO `kecheng_info` VALUES ('4', 'web前端技术课', '周一下午第二大节、周四下午第一大节', '3', '钱五五', '3', '审核通过', '通过', 'admin', '钱同学', '3', '待审核', '该老师没有时间', null, '0', '', null, null, null, '0');
INSERT INTO `kecheng_info` VALUES ('5', 'Java基础课', '周二上午第一大节、周五下午第二大节', '2', '赵小四', '2', '审核通过', '通过', '赵千里', '赵同学', '2', '审核通过', '通过', null, '0', '', null, null, null, '2');
INSERT INTO `kecheng_info` VALUES ('8', '计算机基础', '周一上午第二大节、周三下午第一大节', '1', '张大三', '1', '审核通过', '通过', 'admin', '钱同学', '3', '审核通过', '通过', null, '0', '', null, null, null, '1');
INSERT INTO `kecheng_info` VALUES ('11', 'Java基础课', '周二上午第一大节、周五下午第二大节', '2', '赵小四', '2', '审核通过', '通过', '赵千里', '钱同学', '3', '待审核', '', null, '0', '', null, null, null, '2');
INSERT INTO `kecheng_info` VALUES ('12', 'web前端技术课', '周一下午第二大节、周四下午第一大节', '3', '钱五五', '3', '审核通过', '通过', 'admin', '钱同学', '3', '待审核', '', null, '0', '', null, null, null, '4');
INSERT INTO `kecheng_info` VALUES ('13', '计算机基础', '周一上午第二大节、周三下午第一大节', '1', '张大三', '1', '审核通过', '通过', 'admin', '张同学', '1', '待审核', '', null, '0', '', null, null, null, '1');
INSERT INTO `kecheng_info` VALUES ('15', '测试111', '周一下午2点钟', '3', 'admin', '1', '审核通过', '符合要求', 'admin', null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `kecheng_info` VALUES ('16', '数据库', '周一下午2点钟', '2', '赵小四', '2', '审核通过', '通过', 'admin', '张同学', '1', '审核通过', '22', null, '0', '', null, null, null, '0');
INSERT INTO `kecheng_info` VALUES ('17', '数据库', '周一下午2点钟', '2', '赵小四', '2', '审核通过', '通过', 'admin', '张同学', '1', '审核通过', '22', null, '0', '', null, null, null, '16');
INSERT INTO `kecheng_info` VALUES ('18', '数据库', '周一下午2点钟', '2', '赵小四', '2', '审核通过', '通过', 'admin', '赵同学', '2', '审核通过', '11', null, '0', '', null, null, null, '16');

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '留言名称',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '留言内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '留言时间',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='选课交流信息表';

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', 'admin', '大家都选到自己喜欢的课程了吗？', '2021-02-27 23:37:05', '0');
INSERT INTO `message_info` VALUES ('2', '赵同学', '选到了！！', '2021-02-27 23:47:23', '1');
INSERT INTO `message_info` VALUES ('3', '张大三', '欢迎童鞋们来报张老师的课哦', '2021-04-02 20:36:32', '1');
INSERT INTO `message_info` VALUES ('4', '张大三', '66655', '2021-04-02 20:36:38', '0');
INSERT INTO `message_info` VALUES ('5', 'admin', '同学们好啊', '2021-05-13 14:26:19', '0');

-- ----------------------------
-- Table structure for nx_system_file_info
-- ----------------------------
DROP TABLE IF EXISTS `nx_system_file_info`;
CREATE TABLE `nx_system_file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `originName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原始文件名',
  `fileName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文件信息表';

-- ----------------------------
-- Records of nx_system_file_info
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生日',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cardId` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `level` int(10) NOT NULL DEFAULT '3' COMMENT '权限等级',
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='学生信息表';

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1', '张同学', 'e10adc3949ba59abbe56e057f20f883e', '小张', '男', '22', '2021-02-27 18:25:37', '18843232356', '上海市', 'aa@163.com', '342425199001116372', '3', '2');
INSERT INTO `student_info` VALUES ('2', '赵同学', 'e10adc3949ba59abbe56e057f20f883e', '小赵', '男', '23', '2021-02-27 18:25:37', '18843232356', '北京市', 'bb@163.com', '342425199001116376', '3', '2');
INSERT INTO `student_info` VALUES ('3', '钱同学', 'e10adc3949ba59abbe56e057f20f883e', '小钱', '女', '32', '2021-02-27 18:25:37', '18843232356', '合肥市', 'cc@163.com', '342425199001116323', '3', '2');
INSERT INTO `student_info` VALUES ('4', '李四', '123456', '小李', '楠', '19', '2017-10-1', '1999999', '湖北', '1515@qq.com', '51616161', '2', '1');
INSERT INTO `student_info` VALUES ('5', '王五', null, null, null, null, null, null, null, null, null, '2', '1');
INSERT INTO `student_info` VALUES ('7', '王五1', null, null, null, null, null, null, null, null, null, '2', '1');
INSERT INTO `student_info` VALUES ('8', '林青霞', null, null, null, null, null, null, null, null, null, '3', null);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生日',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cardId` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `level` int(10) NOT NULL DEFAULT '2' COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='教师信息表';

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES ('1', '张大三', 'e10adc3949ba59abbe56e057f20f883e', '老张', '男', '22', '2021-02-27 18:25:37', '18843232356', '上海市', 'aa@163.com', '342425199001116372', '2');
INSERT INTO `teacher_info` VALUES ('2', '赵小四', 'e10adc3949ba59abbe56e057f20f883e', '老赵', '男', '23', '2021-02-27 18:25:37', '18843232356', '北京市', 'bb@163.com', '342425199001116376', '2');
INSERT INTO `teacher_info` VALUES ('3', '钱五五', 'e10adc3949ba59abbe56e057f20f883e', '老钱', '女', '32', '2021-02-27 18:25:37', '18843232356', '合肥市', 'cc@163.com', '342425199001116323', '2');
INSERT INTO `teacher_info` VALUES ('4', '贾六六', 'e10adc3949ba59abbe56e057f20f883e', '老贾', '女', '24', '2021-02-27 18:25:37', '18843232356', '北京市', 'hahaha@126.com', '342425199001116837', '2');

-- ----------------------------
-- Table structure for zhuyishixiang_info
-- ----------------------------
DROP TABLE IF EXISTS `zhuyishixiang_info`;
CREATE TABLE `zhuyishixiang_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='注意事项信息表';

-- ----------------------------
-- Records of zhuyishixiang_info
-- ----------------------------
INSERT INTO `zhuyishixiang_info` VALUES ('1', '选课注意事项', '<p>一定要把握好时间，别忘了各位同学！</p><p><br></p><p>啊哈哈哈哈，错过这个村，就没那个店了！</p>');
INSERT INTO `zhuyishixiang_info` VALUES ('2', '测试111', '<p>测试测试测试</p>');
INSERT INTO `zhuyishixiang_info` VALUES ('3', '学校召开电信诈骗工作推进会议', '<p> 新闻网讯(实习记者徐书格)为严密防范电信网络诈骗事件发生,切实维护师生财产安全，4月27日，我校在行政楼A333会议室召开反电信诈骗工作推进会。会议由副院长彭邦银主持，保卫处、学工处(团委)负责人，各学部党总支副书记参加了会议。</p>');
