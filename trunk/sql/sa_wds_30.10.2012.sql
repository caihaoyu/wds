/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-10-30 18:53:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answerid` int(11) NOT NULL AUTO_INCREMENT,
  `answerorder` int(11) DEFAULT NULL,
  `answertitle` varchar(600) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`answerid`),
  UNIQUE KEY `answerid` (`answerid`)
) ENGINE=InnoDB AUTO_INCREMENT=11754 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('621', '1', '1');
INSERT INTO `answer` VALUES ('622', '2', '2');
INSERT INTO `answer` VALUES ('623', '3', '3');
INSERT INTO `answer` VALUES ('2638', '1', 'Once');
INSERT INTO `answer` VALUES ('2639', '2', 'Twice');
INSERT INTO `answer` VALUES ('2640', '3', 'Three times');
INSERT INTO `answer` VALUES ('3345', '1', '1');
INSERT INTO `answer` VALUES ('3346', '2', '1');
INSERT INTO `answer` VALUES ('3347', '3', '1');
INSERT INTO `answer` VALUES ('3348', '4', '1');
INSERT INTO `answer` VALUES ('3349', '5', '1');
INSERT INTO `answer` VALUES ('3350', '6', '1');
INSERT INTO `answer` VALUES ('3351', '7', '11');
INSERT INTO `answer` VALUES ('3352', '8', '1');
INSERT INTO `answer` VALUES ('3353', '9', '1');
INSERT INTO `answer` VALUES ('6499', '1', 'a1');
INSERT INTO `answer` VALUES ('6500', '2', '2');
INSERT INTO `answer` VALUES ('6501', '3', '3');
INSERT INTO `answer` VALUES ('6502', '4', '4');
INSERT INTO `answer` VALUES ('6503', '5', '5');
INSERT INTO `answer` VALUES ('6504', '1', 'aaa');
INSERT INTO `answer` VALUES ('6505', '2', 'bbbb');
INSERT INTO `answer` VALUES ('6506', '3', 'cccccc');
INSERT INTO `answer` VALUES ('7657', '1', 'aaa');
INSERT INTO `answer` VALUES ('7658', '2', '....');
INSERT INTO `answer` VALUES ('7659', '3', 'faa');
INSERT INTO `answer` VALUES ('7660', '4', '11');
INSERT INTO `answer` VALUES ('7661', '5', '11');
INSERT INTO `answer` VALUES ('7662', '6', '11');
INSERT INTO `answer` VALUES ('7663', '7', '11');
INSERT INTO `answer` VALUES ('7664', '8', '11');
INSERT INTO `answer` VALUES ('7665', '9', '11');
INSERT INTO `answer` VALUES ('8893', '1', 'Male');
INSERT INTO `answer` VALUES ('8894', '2', 'Female');
INSERT INTO `answer` VALUES ('8895', '1', 'Under 18');
INSERT INTO `answer` VALUES ('8896', '2', '18-24');
INSERT INTO `answer` VALUES ('8897', '3', '25-34');
INSERT INTO `answer` VALUES ('8898', '4', ' 35-44');
INSERT INTO `answer` VALUES ('8899', '5', '45-54');
INSERT INTO `answer` VALUES ('8900', '6', '55-64');
INSERT INTO `answer` VALUES ('8901', '7', '65 or Above');
INSERT INTO `answer` VALUES ('8902', '1', 'Tweet');
INSERT INTO `answer` VALUES ('8903', '2', 'Post on Facebook');
INSERT INTO `answer` VALUES ('8904', '3', ' Passed on by a friend/colleague');
INSERT INTO `answer` VALUES ('8905', '1', 'I am currently working in web design and development');
INSERT INTO `answer` VALUES ('8906', '2', ' I am seeking work in web design and development (but not currently employed in this field)');
INSERT INTO `answer` VALUES ('8907', '3', 'I am a student of web design and development');
INSERT INTO `answer` VALUES ('8908', '4', 'I plan to study web design and development but am not currently doing so');
INSERT INTO `answer` VALUES ('8909', '5', ' Web design and development is a hobby of mine (but not my area of employment/study)');
INSERT INTO `answer` VALUES ('8910', '6', 'None of the above');
INSERT INTO `answer` VALUES ('8911', '1', 'Professional');
INSERT INTO `answer` VALUES ('8912', '2', ' Intermediate');
INSERT INTO `answer` VALUES ('8913', '3', 'Novice/Beginner');
INSERT INTO `answer` VALUES ('8914', '1', 'Full-time');
INSERT INTO `answer` VALUES ('8915', '2', ' Part-time');
INSERT INTO `answer` VALUES ('8916', '3', 'Freelance');
INSERT INTO `answer` VALUES ('8917', '4', 'Short term contract');
INSERT INTO `answer` VALUES ('8918', '5', 'Still in school');
INSERT INTO `answer` VALUES ('8919', '6', ' Unemployed');
INSERT INTO `answer` VALUES ('8920', '1', 'Grade/Primary School');
INSERT INTO `answer` VALUES ('8921', '2', 'High/Secondary School');
INSERT INTO `answer` VALUES ('8922', '3', 'Associate\'s Degree');
INSERT INTO `answer` VALUES ('8923', '4', 'Bachelor\'s Degree');
INSERT INTO `answer` VALUES ('8924', '5', 'Master\'s Degree');
INSERT INTO `answer` VALUES ('8925', '6', 'Doctorate');
INSERT INTO `answer` VALUES ('8926', '1', 'Graphic Design');
INSERT INTO `answer` VALUES ('8927', '2', 'Page Layout & Interface Design');
INSERT INTO `answer` VALUES ('8928', '3', ' Markup e.g. HTML, XHTML, XML, CSS Coding');
INSERT INTO `answer` VALUES ('8929', '4', 'Usability and Accessibility Testing/Knowledge');
INSERT INTO `answer` VALUES ('8930', '5', 'Image Editing & Production');
INSERT INTO `answer` VALUES ('8931', '6', 'Front-end Development, PHP, Ruby on Rails, ASP');
INSERT INTO `answer` VALUES ('8932', '7', 'Writing/Editing');
INSERT INTO `answer` VALUES ('8933', '8', 'Project Management');
INSERT INTO `answer` VALUES ('8934', '9', 'None of the above');
INSERT INTO `answer` VALUES ('8935', '1', 'Yes');
INSERT INTO `answer` VALUES ('8936', '2', 'No');
INSERT INTO `answer` VALUES ('8937', '1', 'Yes');
INSERT INTO `answer` VALUES ('8938', '2', 'No');
INSERT INTO `answer` VALUES ('8939', '1', 'Photoshop');
INSERT INTO `answer` VALUES ('8940', '2', ' Illustrator');
INSERT INTO `answer` VALUES ('8941', '3', 'Flash');
INSERT INTO `answer` VALUES ('8942', '4', ' Fireworks');
INSERT INTO `answer` VALUES ('8943', '5', ' Dreamweaver');
INSERT INTO `answer` VALUES ('8944', '6', 'Firebug');
INSERT INTO `answer` VALUES ('8945', '7', 'Google Web Fonts');
INSERT INTO `answer` VALUES ('8946', '1', ' Wordpress');
INSERT INTO `answer` VALUES ('8947', '2', ' Drupal');
INSERT INTO `answer` VALUES ('8948', '3', ' ExpressionEngine');
INSERT INTO `answer` VALUES ('8949', '4', ' Joomla');
INSERT INTO `answer` VALUES ('8950', '5', 'Squarespace');
INSERT INTO `answer` VALUES ('8951', '6', 'Tumblr');
INSERT INTO `answer` VALUES ('8952', '1', 'Mac Computer');
INSERT INTO `answer` VALUES ('8953', '2', ' PC Computer');
INSERT INTO `answer` VALUES ('8954', '3', ' iPad');
INSERT INTO `answer` VALUES ('8955', '4', ' Other tablet (Not iPad)');
INSERT INTO `answer` VALUES ('8956', '5', 'iPhone');
INSERT INTO `answer` VALUES ('8957', '6', 'Other Smartphone (Not iPhone)');
INSERT INTO `answer` VALUES ('8958', '7', ' iPod ');
INSERT INTO `answer` VALUES ('8959', '8', 'Internet Enabled TV');
INSERT INTO `answer` VALUES ('8960', '9', 'None of the above');
INSERT INTO `answer` VALUES ('8961', '1', 'Only when I\'m notified via RSS');
INSERT INTO `answer` VALUES ('8962', '2', ' Only when I\'m notified on Twitter');
INSERT INTO `answer` VALUES ('8963', '3', ' Only when I\'m notified on Facebook');
INSERT INTO `answer` VALUES ('8964', '4', ' Only when I\'m notified via Email subscription');
INSERT INTO `answer` VALUES ('8965', '5', 'More than once per day');
INSERT INTO `answer` VALUES ('8966', '6', ' 5-7 times per week');
INSERT INTO `answer` VALUES ('8967', '7', '2-4 times per week');
INSERT INTO `answer` VALUES ('8968', '8', ' Once per week');
INSERT INTO `answer` VALUES ('8969', '9', 'Less than once per week');
INSERT INTO `answer` VALUES ('8970', '1', 'RSS Feed');
INSERT INTO `answer` VALUES ('8971', '2', 'Email Subscription');
INSERT INTO `answer` VALUES ('8972', '3', 'Twitter');
INSERT INTO `answer` VALUES ('8973', '4', ' Facebook');
INSERT INTO `answer` VALUES ('10484', '1', 'Once');
INSERT INTO `answer` VALUES ('10485', '2', 'Twice');
INSERT INTO `answer` VALUES ('10486', '3', 'Three times');
INSERT INTO `answer` VALUES ('10487', '1', 'Once');
INSERT INTO `answer` VALUES ('10488', '2', 'Twice');
INSERT INTO `answer` VALUES ('10489', '3', 'Three times');
INSERT INTO `answer` VALUES ('10490', '1', 'Once');
INSERT INTO `answer` VALUES ('10491', '2', 'Twice');
INSERT INTO `answer` VALUES ('10492', '3', 'Three times');

-- ----------------------------
-- Table structure for `assumption`
-- ----------------------------
DROP TABLE IF EXISTS `assumption`;
CREATE TABLE `assumption` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  `conditiontype` int(11) NOT NULL DEFAULT '1',
  `comparator` int(11) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14383 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of assumption
-- ----------------------------
INSERT INTO `assumption` VALUES ('2', '1', '0', null);
INSERT INTO `assumption` VALUES ('8', '1', '0', null);
INSERT INTO `assumption` VALUES ('13', '1', '0', null);
INSERT INTO `assumption` VALUES ('10390', '0', '1', null);
INSERT INTO `assumption` VALUES ('10391', '1', '2', null);
INSERT INTO `assumption` VALUES ('10392', '0', '1', null);
INSERT INTO `assumption` VALUES ('10393', '1', '2', null);
INSERT INTO `assumption` VALUES ('10394', '1', '4', '4');
INSERT INTO `assumption` VALUES ('10395', '1', '2', null);
INSERT INTO `assumption` VALUES ('11260', '0', '1', null);
INSERT INTO `assumption` VALUES ('11332', '0', '1', null);
INSERT INTO `assumption` VALUES ('14180', '1', '4', null);
INSERT INTO `assumption` VALUES ('14217', '1', '5', '4');
INSERT INTO `assumption` VALUES ('14250', '1', '4', '4');

-- ----------------------------
-- Table structure for `branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem`;
CREATE TABLE `branchitem` (
  `branchitemid` int(11) NOT NULL AUTO_INCREMENT,
  `hidden` tinyint(1) DEFAULT NULL,
  `itemorder` int(3) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `mandatory` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`branchitemid`),
  UNIQUE KEY `branchitem_id` (`branchitemid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20598 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('837', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('838', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('839', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('840', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('841', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('842', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1012', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1013', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1014', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1015', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1016', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('1017', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('1018', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('1655', '0', '4', '1', '0');
INSERT INTO `branchitem` VALUES ('1656', '0', '4', '95', '0');
INSERT INTO `branchitem` VALUES ('1657', '0', '3', '149', '0');
INSERT INTO `branchitem` VALUES ('1658', '0', '3', '149', '0');
INSERT INTO `branchitem` VALUES ('1659', '0', '3', '149', '0');
INSERT INTO `branchitem` VALUES ('1660', '0', '3', '149', '0');
INSERT INTO `branchitem` VALUES ('1661', '0', '3', '149', '0');
INSERT INTO `branchitem` VALUES ('1662', '0', '1', '148', '0');
INSERT INTO `branchitem` VALUES ('1695', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('8352', '0', '1', '119', '0');
INSERT INTO `branchitem` VALUES ('8353', '0', '2', '119', '0');
INSERT INTO `branchitem` VALUES ('8553', '0', '1', '118', '0');
INSERT INTO `branchitem` VALUES ('8554', '0', '1', '118', '0');
INSERT INTO `branchitem` VALUES ('8593', '0', '0', '1', '0');
INSERT INTO `branchitem` VALUES ('8594', '0', '1', '118', '0');
INSERT INTO `branchitem` VALUES ('8595', '1', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('8596', '1', '2', '95', '0');
INSERT INTO `branchitem` VALUES ('8597', '1', '3', '96', '0');
INSERT INTO `branchitem` VALUES ('8598', '1', '1', '119', '0');
INSERT INTO `branchitem` VALUES ('8599', '1', '1', '148', '0');
INSERT INTO `branchitem` VALUES ('8600', '1', '2', '149', '0');
INSERT INTO `branchitem` VALUES ('8665', '0', '4', '364', '0');
INSERT INTO `branchitem` VALUES ('8666', '0', '5', '832', '0');
INSERT INTO `branchitem` VALUES ('8667', '0', '6', '833', '0');
INSERT INTO `branchitem` VALUES ('8668', '0', '7', '941', '0');
INSERT INTO `branchitem` VALUES ('8669', '0', '8', '942', '0');
INSERT INTO `branchitem` VALUES ('8670', '0', '9', '943', '0');
INSERT INTO `branchitem` VALUES ('8671', '0', '10', '944', '0');
INSERT INTO `branchitem` VALUES ('8672', '0', '11', '963', '0');
INSERT INTO `branchitem` VALUES ('8673', '0', '12', '964', '0');
INSERT INTO `branchitem` VALUES ('8674', '0', '13', '965', '0');
INSERT INTO `branchitem` VALUES ('8675', '0', '14', '987', '0');
INSERT INTO `branchitem` VALUES ('8676', '0', '15', '1297', '0');
INSERT INTO `branchitem` VALUES ('8677', '0', '16', '1298', '0');
INSERT INTO `branchitem` VALUES ('8684', '0', '1', '364', '0');
INSERT INTO `branchitem` VALUES ('8685', '0', '2', '832', '0');
INSERT INTO `branchitem` VALUES ('8686', '0', '3', '833', '0');
INSERT INTO `branchitem` VALUES ('8687', '0', '4', '941', '0');
INSERT INTO `branchitem` VALUES ('8688', '0', '5', '942', '0');
INSERT INTO `branchitem` VALUES ('8689', '0', '6', '943', '0');
INSERT INTO `branchitem` VALUES ('8690', '0', '7', '944', '0');
INSERT INTO `branchitem` VALUES ('8691', '0', '8', '963', '0');
INSERT INTO `branchitem` VALUES ('8692', '0', '9', '964', '0');
INSERT INTO `branchitem` VALUES ('8693', '0', '10', '965', '0');
INSERT INTO `branchitem` VALUES ('8694', '0', '10', '987', '0');
INSERT INTO `branchitem` VALUES ('8695', '0', '11', '1297', '0');
INSERT INTO `branchitem` VALUES ('8696', '0', '12', '1298', '0');
INSERT INTO `branchitem` VALUES ('8851', '1', '0', '119', '0');
INSERT INTO `branchitem` VALUES ('8852', '0', '1', '3779', '0');
INSERT INTO `branchitem` VALUES ('8853', '0', '3', '118', '0');
INSERT INTO `branchitem` VALUES ('8854', '0', '1', '119', '0');
INSERT INTO `branchitem` VALUES ('8855', '0', '2', '3779', '0');
INSERT INTO `branchitem` VALUES ('8856', '0', '3', '118', '0');
INSERT INTO `branchitem` VALUES ('8910', '0', '4', '119', '0');
INSERT INTO `branchitem` VALUES ('10373', '0', '1', '364', '0');
INSERT INTO `branchitem` VALUES ('10374', '0', '2', '364', '0');
INSERT INTO `branchitem` VALUES ('10375', '0', '3', '364', '0');
INSERT INTO `branchitem` VALUES ('10376', '0', '4', '364', '0');
INSERT INTO `branchitem` VALUES ('10496', '0', '1', '833', '0');
INSERT INTO `branchitem` VALUES ('12358', '0', '4', '832', '0');
INSERT INTO `branchitem` VALUES ('12786', '0', '0', '95', '0');
INSERT INTO `branchitem` VALUES ('12787', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('14591', '0', '1', '832', '0');
INSERT INTO `branchitem` VALUES ('14592', '0', '2', '832', '0');
INSERT INTO `branchitem` VALUES ('14593', '1', '3', '1', '0');
INSERT INTO `branchitem` VALUES ('15538', '0', '1', '15773', '1');
INSERT INTO `branchitem` VALUES ('15539', '0', '2', '15774', '0');
INSERT INTO `branchitem` VALUES ('15540', '0', '3', '15775', '0');
INSERT INTO `branchitem` VALUES ('15541', '0', '4', '15776', '0');
INSERT INTO `branchitem` VALUES ('15542', '0', '4', '15777', '0');
INSERT INTO `branchitem` VALUES ('15544', '1', '5', '15779', '0');
INSERT INTO `branchitem` VALUES ('15545', '1', '7', '15780', '0');
INSERT INTO `branchitem` VALUES ('15640', '0', '5', '832', '0');
INSERT INTO `branchitem` VALUES ('15641', '0', '6', '833', '0');
INSERT INTO `branchitem` VALUES ('15642', '0', '7', '941', '0');
INSERT INTO `branchitem` VALUES ('15808', '0', '1', '364', '0');
INSERT INTO `branchitem` VALUES ('15905', '1', '8', '15782', '0');
INSERT INTO `branchitem` VALUES ('15906', '1', '6', '15783', '0');
INSERT INTO `branchitem` VALUES ('18344', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('18345', '0', '1', '119', '0');
INSERT INTO `branchitem` VALUES ('18346', '0', '1', '148', '0');
INSERT INTO `branchitem` VALUES ('18347', '0', '2', '148', '0');
INSERT INTO `branchitem` VALUES ('18650', '0', '1', '17910', '0');
INSERT INTO `branchitem` VALUES ('18651', '0', '2', '3779', '0');
INSERT INTO `branchitem` VALUES ('18652', '0', '3', '118', '0');
INSERT INTO `branchitem` VALUES ('18653', '0', '1', '17910', '0');
INSERT INTO `branchitem` VALUES ('18654', '0', '2', '3779', '0');
INSERT INTO `branchitem` VALUES ('18655', '0', '3', '118', '0');
INSERT INTO `branchitem` VALUES ('18656', '0', '1', '1', '0');
INSERT INTO `branchitem` VALUES ('18657', '0', '2', '1', '0');
INSERT INTO `branchitem` VALUES ('18664', '0', '1', '987', '0');
INSERT INTO `branchitem` VALUES ('18665', '0', '1', '8824', '0');
INSERT INTO `branchitem` VALUES ('18666', '0', '2', '8827', '0');
INSERT INTO `branchitem` VALUES ('18668', '0', '3', '18563', '0');
INSERT INTO `branchitem` VALUES ('18669', '0', '4', '18565', '0');
INSERT INTO `branchitem` VALUES ('18823', '0', '5', '95', '0');
INSERT INTO `branchitem` VALUES ('19084', '0', '1', '17910', '0');
INSERT INTO `branchitem` VALUES ('19085', '0', '2', '3779', '0');
INSERT INTO `branchitem` VALUES ('19418', '0', '1', '5183', '0');
INSERT INTO `branchitem` VALUES ('19489', '0', '2', '95', '0');
INSERT INTO `branchitem` VALUES ('20453', '0', '1', '95', '0');
INSERT INTO `branchitem` VALUES ('20454', '1', '3', '96', '0');

-- ----------------------------
-- Table structure for `branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitemrule`;
CREATE TABLE `branchitemrule` (
  `ruleid` int(11) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(200) COLLATE utf8_bin NOT NULL,
  `conditionid` int(11) DEFAULT NULL,
  `ruletype` int(11) NOT NULL,
  PRIMARY KEY (`ruleid`),
  UNIQUE KEY `ruleid_UNIQUE` (`ruleid`) USING BTREE,
  KEY `branchitemrule_ibfk_1` (`conditionid`),
  CONSTRAINT `branchitemrule_ibfk_1` FOREIGN KEY (`conditionid`) REFERENCES `assumption` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9309 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule
-- ----------------------------
INSERT INTO `branchitemrule` VALUES ('6832', 'If the user answers this question. Temporarily set one pagebranch as default.', '10390', '2');
INSERT INTO `branchitemrule` VALUES ('6833', 'If the user skips this question. Temporarily set pagebranch (10172) of page (5952) as default.', '10391', '2');
INSERT INTO `branchitemrule` VALUES ('6834', 'If the user answers this question. Jump to page (Page One A) immediately.', '10392', '3');
INSERT INTO `branchitemrule` VALUES ('6835', 'If the user skips this question. Jump to page (Temporary Page) immediately.', '10393', '3');
INSERT INTO `branchitemrule` VALUES ('6836', 'If answers meet certain expectation(s), this question. Jump to page (Page One A) after page.', '10394', '4');
INSERT INTO `branchitemrule` VALUES ('6837', 'If the user skips this question. Jump to page (Temporary Page) after page.', '10395', '4');
INSERT INTO `branchitemrule` VALUES ('9190', 'If answers meet certain expectation(s), this question. Show one hidden question.', '14180', '1');
INSERT INTO `branchitemrule` VALUES ('9213', 'If sub questions and column choices meet certain expectation(s), this question. Show one hidden question.', '14217', '1');
INSERT INTO `branchitemrule` VALUES ('9232', 'If answers meet certain expectation(s), this question. Show one hidden question.', '14250', '1');

-- ----------------------------
-- Table structure for `branchitemrule_result`
-- ----------------------------
DROP TABLE IF EXISTS `branchitemrule_result`;
CREATE TABLE `branchitemrule_result` (
  `ruleid` int(11) NOT NULL,
  `resultid` int(11) NOT NULL,
  PRIMARY KEY (`ruleid`,`resultid`),
  KEY `branchitemrule_result_ibfk_2` (`resultid`),
  CONSTRAINT `branchitemrule_result_ibfk_1` FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `branchitemrule_result_ibfk_2` FOREIGN KEY (`resultid`) REFERENCES `result` (`resultid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule_result
-- ----------------------------
INSERT INTO `branchitemrule_result` VALUES ('6832', '6765');
INSERT INTO `branchitemrule_result` VALUES ('6833', '6766');
INSERT INTO `branchitemrule_result` VALUES ('6834', '6767');
INSERT INTO `branchitemrule_result` VALUES ('6835', '6768');
INSERT INTO `branchitemrule_result` VALUES ('6836', '6769');
INSERT INTO `branchitemrule_result` VALUES ('6837', '6770');
INSERT INTO `branchitemrule_result` VALUES ('9190', '9016');
INSERT INTO `branchitemrule_result` VALUES ('9213', '9040');
INSERT INTO `branchitemrule_result` VALUES ('9232', '9064');

-- ----------------------------
-- Table structure for `branchitem_branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem_branchitemrule`;
CREATE TABLE `branchitem_branchitemrule` (
  `itemid` int(11) NOT NULL,
  `ruleid` int(11) NOT NULL,
  PRIMARY KEY (`itemid`,`ruleid`),
  KEY `branchitem_branchitemrule_ibfk_2` (`ruleid`),
  CONSTRAINT `branchitem_branchitemrule_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `branchitem_branchitemrule_ibfk_2` FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem_branchitemrule
-- ----------------------------
INSERT INTO `branchitem_branchitemrule` VALUES ('10374', '6832');
INSERT INTO `branchitem_branchitemrule` VALUES ('10375', '6833');
INSERT INTO `branchitem_branchitemrule` VALUES ('10376', '6834');
INSERT INTO `branchitem_branchitemrule` VALUES ('15640', '6835');
INSERT INTO `branchitem_branchitemrule` VALUES ('15641', '6836');
INSERT INTO `branchitem_branchitemrule` VALUES ('15642', '6837');
INSERT INTO `branchitem_branchitemrule` VALUES ('15540', '9190');
INSERT INTO `branchitem_branchitemrule` VALUES ('19489', '9213');
INSERT INTO `branchitem_branchitemrule` VALUES ('19418', '9232');

-- ----------------------------
-- Table structure for `columnchoice`
-- ----------------------------
DROP TABLE IF EXISTS `columnchoice`;
CREATE TABLE `columnchoice` (
  `columnchoiceid` int(11) NOT NULL AUTO_INCREMENT,
  `columnchoiceorder` int(11) DEFAULT NULL,
  `columnchoicetitle` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`columnchoiceid`),
  UNIQUE KEY `columnchoiceid` (`columnchoiceid`)
) ENGINE=InnoDB AUTO_INCREMENT=4211 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
-- ----------------------------
INSERT INTO `columnchoice` VALUES ('6', '1', 'Column Choices 1');
INSERT INTO `columnchoice` VALUES ('7', '2', 'Column Choices 2');
INSERT INTO `columnchoice` VALUES ('8', '3', 'Column Choices 3');
INSERT INTO `columnchoice` VALUES ('19', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('20', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('21', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('22', '4', '4th');
INSERT INTO `columnchoice` VALUES ('23', '5', '5th');
INSERT INTO `columnchoice` VALUES ('24', '1', 'Strongly Agree');
INSERT INTO `columnchoice` VALUES ('25', '2', 'Agree');
INSERT INTO `columnchoice` VALUES ('26', '3', 'Disagree');
INSERT INTO `columnchoice` VALUES ('27', '4', 'Strongly Disagree');
INSERT INTO `columnchoice` VALUES ('28', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('29', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('30', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('31', '4', '4th');
INSERT INTO `columnchoice` VALUES ('32', '5', '5th');
INSERT INTO `columnchoice` VALUES ('33', '1', 'Strongly Agree');
INSERT INTO `columnchoice` VALUES ('34', '2', 'Agree');
INSERT INTO `columnchoice` VALUES ('35', '3', 'Disagree');
INSERT INTO `columnchoice` VALUES ('36', '4', 'Strongly Disagree');
INSERT INTO `columnchoice` VALUES ('115', '1', 'lll');
INSERT INTO `columnchoice` VALUES ('116', '2', 'ooo');
INSERT INTO `columnchoice` VALUES ('126', '1', 'ww');
INSERT INTO `columnchoice` VALUES ('127', '2', 'www');
INSERT INTO `columnchoice` VALUES ('200', '1', '1');
INSERT INTO `columnchoice` VALUES ('201', '2', '2');
INSERT INTO `columnchoice` VALUES ('202', '3', '3');
INSERT INTO `columnchoice` VALUES ('203', '1', 'nnn');
INSERT INTO `columnchoice` VALUES ('204', '2', 'bbb');
INSERT INTO `columnchoice` VALUES ('709', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('710', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('711', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('712', '4', '4th');
INSERT INTO `columnchoice` VALUES ('713', '5', '5th');
INSERT INTO `columnchoice` VALUES ('817', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('818', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('819', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('820', '4', '4th');
INSERT INTO `columnchoice` VALUES ('821', '5', '5th');
INSERT INTO `columnchoice` VALUES ('1039', '1', 'Strongly Agree');
INSERT INTO `columnchoice` VALUES ('1040', '2', 'Agree');
INSERT INTO `columnchoice` VALUES ('1041', '3', 'Disagree');
INSERT INTO `columnchoice` VALUES ('1042', '4', 'Strongly Disagree');
INSERT INTO `columnchoice` VALUES ('1413', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('1414', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('1415', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('1416', '4', '4th');
INSERT INTO `columnchoice` VALUES ('2506', '1', 'aaaa');
INSERT INTO `columnchoice` VALUES ('2507', '2', 'fafaf');
INSERT INTO `columnchoice` VALUES ('2508', '3', 'faffafa');
INSERT INTO `columnchoice` VALUES ('2509', '4', 'fffffff');
INSERT INTO `columnchoice` VALUES ('2510', '5', 'fffffff');
INSERT INTO `columnchoice` VALUES ('2511', '6', 'ffffffffffe');
INSERT INTO `columnchoice` VALUES ('2512', '7', 'ffffffffe');
INSERT INTO `columnchoice` VALUES ('3665', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('3666', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('3667', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('3668', '4', '4th');
INSERT INTO `columnchoice` VALUES ('3669', '5', '5th');
INSERT INTO `columnchoice` VALUES ('3670', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('3671', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('3672', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('3673', '4', '4th');
INSERT INTO `columnchoice` VALUES ('3674', '5', '5th');
INSERT INTO `columnchoice` VALUES ('3675', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('3676', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('3677', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('3678', '4', '4th');
INSERT INTO `columnchoice` VALUES ('3679', '5', '5th');
INSERT INTO `columnchoice` VALUES ('3680', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('3681', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('3682', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('3683', '4', '4th');
INSERT INTO `columnchoice` VALUES ('3684', '5', '5th');
INSERT INTO `columnchoice` VALUES ('3685', '1', 'Most');
INSERT INTO `columnchoice` VALUES ('3686', '2', '2nd');
INSERT INTO `columnchoice` VALUES ('3687', '3', '3rd');
INSERT INTO `columnchoice` VALUES ('3688', '4', '4th');
INSERT INTO `columnchoice` VALUES ('3689', '5', '5th');

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` bit(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid` (`conditionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of condition
-- ----------------------------

-- ----------------------------
-- Table structure for `condition_scenario`
-- ----------------------------
DROP TABLE IF EXISTS `condition_scenario`;
CREATE TABLE `condition_scenario` (
  `conditionid` int(11) NOT NULL DEFAULT '0',
  `scenarioid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`conditionid`,`scenarioid`),
  KEY `FK418AC63496EF570B` (`scenarioid`),
  CONSTRAINT `condition_scenario_ibfk_2` FOREIGN KEY (`scenarioid`) REFERENCES `scenario` (`scenarioid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `condition_scenario_ibfk_1` FOREIGN KEY (`conditionid`) REFERENCES `assumption` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of condition_scenario
-- ----------------------------
INSERT INTO `condition_scenario` VALUES ('10394', '906');
INSERT INTO `condition_scenario` VALUES ('10394', '907');
INSERT INTO `condition_scenario` VALUES ('14180', '1258');
INSERT INTO `condition_scenario` VALUES ('14217', '1263');
INSERT INTO `condition_scenario` VALUES ('14217', '1264');
INSERT INTO `condition_scenario` VALUES ('14250', '1265');
INSERT INTO `condition_scenario` VALUES ('14250', '1266');
INSERT INTO `condition_scenario` VALUES ('14250', '1267');

-- ----------------------------
-- Table structure for `entry`
-- ----------------------------
DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `entryid` int(11) NOT NULL AUTO_INCREMENT,
  `questionid` int(11) NOT NULL,
  `answerid` int(11) DEFAULT NULL,
  `subquestionid` int(11) DEFAULT NULL,
  `columnchoiceid` int(11) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of entry
-- ----------------------------

-- ----------------------------
-- Table structure for `page`
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `pageid` int(11) NOT NULL AUTO_INCREMENT,
  `pageorder` int(11) DEFAULT NULL,
  `pagetitle` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `pageheader` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `pagefooter` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`pageid`),
  UNIQUE KEY `pageid` (`pageid`)
) ENGINE=InnoDB AUTO_INCREMENT=14771 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('1276', '0', '淡淡道', 'This is Page Header of Page 1', 'This is Page Footer of Page 1asd');
INSERT INTO `page` VALUES ('1325', '1', 'Page 2', 'This is Page Header of Page 2.', 'This is Page Footer of Page 2.');
INSERT INTO `page` VALUES ('5715', '0', 'New Page', null, null);
INSERT INTO `page` VALUES ('5716', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('5717', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('5720', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('5721', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('5722', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('5951', '1', 'page1', 'Header', 'Footer');
INSERT INTO `page` VALUES ('5952', '0', 'Page One A', '', '');
INSERT INTO `page` VALUES ('5953', '4', 'Page Two', '', '');
INSERT INTO `page` VALUES ('5954', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('5955', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('5956', '3', 'Page One B', 'Page Header of Page One B', 'Page Footer of Page One B');
INSERT INTO `page` VALUES ('6155', '0', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('6156', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('6157', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('6195', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('6196', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('6197', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('7244', '1', 'Cover Page', 'Cover Page Header', 'Cover Page Footer');
INSERT INTO `page` VALUES ('9013', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('9536', '6', 'Last Page', 'Header', 'Footer');
INSERT INTO `page` VALUES ('9697', '5', 'Page Three', 'Page Three Header', 'Page Three Footer');
INSERT INTO `page` VALUES ('10302', '2', 'Rating Page', 'Header of Rating Page', 'Footer of Rating Page');
INSERT INTO `page` VALUES ('11029', '1', 'Client Preparation', 'When responding please refrain from delving too deeply into topics that will be covered in other sections, as they will likely be covered later on.  If a topic is not covered, you will have a chance at the end of the document to add additional comments.', 'The completion of this and other <strong>relevant </strong>surveys is part of our Discovery Process, a key step towards professional web development planning. It is also the foundation of our partnership with you, and the thought-spring from which we will draw the necessary information needed to bring your web dreams to life. ');
INSERT INTO `page` VALUES ('11098', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('11099', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('11100', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('11991', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('11993', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('12068', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('12832', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('13080', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('13081', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('13082', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('13089', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('13090', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('13091', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('13092', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('13093', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('13094', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('13095', '7', 'New Page', null, null);
INSERT INTO `page` VALUES ('13113', '7', 'New Page', null, null);
INSERT INTO `page` VALUES ('13114', '8', 'New Page', null, null);
INSERT INTO `page` VALUES ('13115', '9', 'New Page', null, null);
INSERT INTO `page` VALUES ('13333', '10', 'New Page', null, null);
INSERT INTO `page` VALUES ('13334', '11', 'New Page', null, null);
INSERT INTO `page` VALUES ('13335', '12', 'New Page', null, null);
INSERT INTO `page` VALUES ('13338', '1', 'page title aAS', 'page header  page header page header page header page header page header page header page header page header page header   ', 'page footerpage header page header page header ');
INSERT INTO `page` VALUES ('13339', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('13340', '3', 'aaaaaaaaaa', 'sasd ', '');
INSERT INTO `page` VALUES ('13344', '2', 'Second Page', '', '');
INSERT INTO `page` VALUES ('13649', '1', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('13650', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('13651', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('13774', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('13910', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('13911', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('13912', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('14267', '13', 'New Page', null, null);
INSERT INTO `page` VALUES ('14404', '4', 'New Page', null, null);

-- ----------------------------
-- Table structure for `pagebranch`
-- ----------------------------
DROP TABLE IF EXISTS `pagebranch`;
CREATE TABLE `pagebranch` (
  `branchid` int(11) NOT NULL AUTO_INCREMENT,
  `branchname` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `main` tinyint(1) NOT NULL,
  `have_item` tinyint(1) NOT NULL,
  PRIMARY KEY (`branchid`),
  UNIQUE KEY `branchid` (`branchid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21781 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('1424', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1427', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1889', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2041', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('2042', 'Branch 6', '0', '0');
INSERT INTO `pagebranch` VALUES ('2043', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2874', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('2991', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('9803', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('9804', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9805', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9808', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9809', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9810', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10169', 'Branch 1', '0', '1');
INSERT INTO `pagebranch` VALUES ('10170', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('10172', 'Branch 3', '0', '1');
INSERT INTO `pagebranch` VALUES ('10173', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('10174', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('10175', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('10177', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10178', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('10179', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10180', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('10447', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('10448', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10449', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10450', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('10451', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('10503', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10504', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10505', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10506', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('10507', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('11957', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('13601', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('13602', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('13603', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('13604', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('13605', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('13606', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('13607', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('14303', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('15006', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('15229', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('16023', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('16991', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('17084', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('17085', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('17086', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('17246', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('18211', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('18213', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('18298', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19131', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('19270', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19590', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19591', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19592', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19593', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('19594', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('19605', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('19606', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('19607', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('19608', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19609', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19610', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19611', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19639', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19640', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19641', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19916', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19917', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19918', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19921', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('19922', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('19923', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('19924', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('19925', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('19926', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('19932', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('20322', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('20323', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('20324', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('20325', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('20326', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('20627', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('20628', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('20629', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('20630', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('20631', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('20632', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('20844', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('21029', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('21030', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('21123', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('21124', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('21309', 'Default Branch', '1', '0');

-- ----------------------------
-- Table structure for `pagebranch_branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `pagebranch_branchitem`;
CREATE TABLE `pagebranch_branchitem` (
  `branchid` int(11) NOT NULL,
  `branchitemid` int(11) NOT NULL,
  PRIMARY KEY (`branchid`,`branchitemid`),
  KEY `branchitemid` (`branchitemid`),
  CONSTRAINT `pagebranch_branchitem_ibfk_1` FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pagebranch_branchitem_ibfk_2` FOREIGN KEY (`branchitemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch_branchitem
-- ----------------------------
INSERT INTO `pagebranch_branchitem` VALUES ('9803', '8352');
INSERT INTO `pagebranch_branchitem` VALUES ('9803', '8353');
INSERT INTO `pagebranch_branchitem` VALUES ('10169', '8593');
INSERT INTO `pagebranch_branchitem` VALUES ('10169', '8594');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8595');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8596');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8597');
INSERT INTO `pagebranch_branchitem` VALUES ('10173', '8598');
INSERT INTO `pagebranch_branchitem` VALUES ('10173', '8599');
INSERT INTO `pagebranch_branchitem` VALUES ('10173', '8600');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8665');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8666');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8667');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8668');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8669');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8670');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8671');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8672');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8673');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8674');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8675');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8676');
INSERT INTO `pagebranch_branchitem` VALUES ('10170', '8677');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8684');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8685');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8686');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8687');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8688');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8689');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8690');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8691');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8692');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8693');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8694');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8695');
INSERT INTO `pagebranch_branchitem` VALUES ('10180', '8696');
INSERT INTO `pagebranch_branchitem` VALUES ('10447', '8851');
INSERT INTO `pagebranch_branchitem` VALUES ('10447', '8852');
INSERT INTO `pagebranch_branchitem` VALUES ('10447', '8853');
INSERT INTO `pagebranch_branchitem` VALUES ('10451', '8854');
INSERT INTO `pagebranch_branchitem` VALUES ('10451', '8855');
INSERT INTO `pagebranch_branchitem` VALUES ('10451', '8856');
INSERT INTO `pagebranch_branchitem` VALUES ('10447', '8910');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '10373');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '10374');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '10375');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '10376');
INSERT INTO `pagebranch_branchitem` VALUES ('10172', '10496');
INSERT INTO `pagebranch_branchitem` VALUES ('10173', '12358');
INSERT INTO `pagebranch_branchitem` VALUES ('14303', '12786');
INSERT INTO `pagebranch_branchitem` VALUES ('14303', '12787');
INSERT INTO `pagebranch_branchitem` VALUES ('16023', '14591');
INSERT INTO `pagebranch_branchitem` VALUES ('16023', '14592');
INSERT INTO `pagebranch_branchitem` VALUES ('16023', '14593');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15538');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15539');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15540');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15541');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15542');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15544');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15545');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '15640');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '15641');
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '15642');
INSERT INTO `pagebranch_branchitem` VALUES ('2874', '15808');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15905');
INSERT INTO `pagebranch_branchitem` VALUES ('16991', '15906');
INSERT INTO `pagebranch_branchitem` VALUES ('19606', '18344');
INSERT INTO `pagebranch_branchitem` VALUES ('19607', '18345');
INSERT INTO `pagebranch_branchitem` VALUES ('19605', '18346');
INSERT INTO `pagebranch_branchitem` VALUES ('19606', '18347');
INSERT INTO `pagebranch_branchitem` VALUES ('19921', '18650');
INSERT INTO `pagebranch_branchitem` VALUES ('19921', '18651');
INSERT INTO `pagebranch_branchitem` VALUES ('19921', '18652');
INSERT INTO `pagebranch_branchitem` VALUES ('19922', '18653');
INSERT INTO `pagebranch_branchitem` VALUES ('19922', '18654');
INSERT INTO `pagebranch_branchitem` VALUES ('19922', '18655');
INSERT INTO `pagebranch_branchitem` VALUES ('19131', '18656');
INSERT INTO `pagebranch_branchitem` VALUES ('19131', '18657');
INSERT INTO `pagebranch_branchitem` VALUES ('17084', '18664');
INSERT INTO `pagebranch_branchitem` VALUES ('19932', '18665');
INSERT INTO `pagebranch_branchitem` VALUES ('19932', '18666');
INSERT INTO `pagebranch_branchitem` VALUES ('19932', '18668');
INSERT INTO `pagebranch_branchitem` VALUES ('19932', '18669');
INSERT INTO `pagebranch_branchitem` VALUES ('19932', '18823');
INSERT INTO `pagebranch_branchitem` VALUES ('20325', '19084');
INSERT INTO `pagebranch_branchitem` VALUES ('20325', '19085');
INSERT INTO `pagebranch_branchitem` VALUES ('20627', '19418');
INSERT INTO `pagebranch_branchitem` VALUES ('20627', '19489');
INSERT INTO `pagebranch_branchitem` VALUES ('20629', '20453');
INSERT INTO `pagebranch_branchitem` VALUES ('20627', '20454');

-- ----------------------------
-- Table structure for `page_branch`
-- ----------------------------
DROP TABLE IF EXISTS `page_branch`;
CREATE TABLE `page_branch` (
  `pageid` int(11) NOT NULL,
  `branchid` int(11) NOT NULL,
  UNIQUE KEY `branchid` (`branchid`),
  KEY `FKA66091528C5AF21E` (`branchid`),
  KEY `FKA6609152B1815949` (`pageid`),
  CONSTRAINT `FKA66091528C5AF21E` FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKA6609152B1815949` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page_branch
-- ----------------------------
INSERT INTO `page_branch` VALUES ('1276', '2874');
INSERT INTO `page_branch` VALUES ('1276', '19131');
INSERT INTO `page_branch` VALUES ('1276', '19926');
INSERT INTO `page_branch` VALUES ('1276', '21124');
INSERT INTO `page_branch` VALUES ('1325', '2991');
INSERT INTO `page_branch` VALUES ('1325', '17246');
INSERT INTO `page_branch` VALUES ('5715', '9803');
INSERT INTO `page_branch` VALUES ('5716', '9804');
INSERT INTO `page_branch` VALUES ('5717', '9805');
INSERT INTO `page_branch` VALUES ('5720', '9808');
INSERT INTO `page_branch` VALUES ('5721', '9809');
INSERT INTO `page_branch` VALUES ('5722', '9810');
INSERT INTO `page_branch` VALUES ('5951', '10169');
INSERT INTO `page_branch` VALUES ('5952', '10170');
INSERT INTO `page_branch` VALUES ('5952', '10172');
INSERT INTO `page_branch` VALUES ('5953', '10173');
INSERT INTO `page_branch` VALUES ('5953', '10174');
INSERT INTO `page_branch` VALUES ('5953', '10175');
INSERT INTO `page_branch` VALUES ('5954', '10177');
INSERT INTO `page_branch` VALUES ('5954', '10178');
INSERT INTO `page_branch` VALUES ('5955', '10179');
INSERT INTO `page_branch` VALUES ('5956', '10180');
INSERT INTO `page_branch` VALUES ('6155', '10447');
INSERT INTO `page_branch` VALUES ('6155', '10450');
INSERT INTO `page_branch` VALUES ('6155', '10506');
INSERT INTO `page_branch` VALUES ('6156', '10448');
INSERT INTO `page_branch` VALUES ('6156', '10451');
INSERT INTO `page_branch` VALUES ('6156', '10507');
INSERT INTO `page_branch` VALUES ('6157', '10449');
INSERT INTO `page_branch` VALUES ('6195', '10503');
INSERT INTO `page_branch` VALUES ('6196', '10504');
INSERT INTO `page_branch` VALUES ('6197', '10505');
INSERT INTO `page_branch` VALUES ('7244', '11957');
INSERT INTO `page_branch` VALUES ('9013', '14303');
INSERT INTO `page_branch` VALUES ('9536', '15006');
INSERT INTO `page_branch` VALUES ('9697', '15229');
INSERT INTO `page_branch` VALUES ('10302', '16023');
INSERT INTO `page_branch` VALUES ('11029', '16991');
INSERT INTO `page_branch` VALUES ('11098', '17084');
INSERT INTO `page_branch` VALUES ('11099', '17085');
INSERT INTO `page_branch` VALUES ('11100', '17086');
INSERT INTO `page_branch` VALUES ('11991', '18211');
INSERT INTO `page_branch` VALUES ('11993', '18213');
INSERT INTO `page_branch` VALUES ('12068', '18298');
INSERT INTO `page_branch` VALUES ('12832', '19270');
INSERT INTO `page_branch` VALUES ('13080', '19590');
INSERT INTO `page_branch` VALUES ('13080', '19593');
INSERT INTO `page_branch` VALUES ('13080', '19594');
INSERT INTO `page_branch` VALUES ('13081', '19591');
INSERT INTO `page_branch` VALUES ('13082', '19592');
INSERT INTO `page_branch` VALUES ('13089', '19605');
INSERT INTO `page_branch` VALUES ('13090', '19606');
INSERT INTO `page_branch` VALUES ('13091', '19607');
INSERT INTO `page_branch` VALUES ('13092', '19608');
INSERT INTO `page_branch` VALUES ('13093', '19609');
INSERT INTO `page_branch` VALUES ('13094', '19610');
INSERT INTO `page_branch` VALUES ('13095', '19611');
INSERT INTO `page_branch` VALUES ('13113', '19639');
INSERT INTO `page_branch` VALUES ('13114', '19640');
INSERT INTO `page_branch` VALUES ('13115', '19641');
INSERT INTO `page_branch` VALUES ('13333', '19916');
INSERT INTO `page_branch` VALUES ('13334', '19917');
INSERT INTO `page_branch` VALUES ('13335', '19918');
INSERT INTO `page_branch` VALUES ('13338', '19921');
INSERT INTO `page_branch` VALUES ('13338', '19924');
INSERT INTO `page_branch` VALUES ('13339', '19922');
INSERT INTO `page_branch` VALUES ('13339', '19925');
INSERT INTO `page_branch` VALUES ('13340', '19923');
INSERT INTO `page_branch` VALUES ('13340', '20844');
INSERT INTO `page_branch` VALUES ('13344', '19932');
INSERT INTO `page_branch` VALUES ('13649', '20322');
INSERT INTO `page_branch` VALUES ('13649', '20325');
INSERT INTO `page_branch` VALUES ('13650', '20323');
INSERT INTO `page_branch` VALUES ('13650', '20326');
INSERT INTO `page_branch` VALUES ('13651', '20324');
INSERT INTO `page_branch` VALUES ('13774', '21029');
INSERT INTO `page_branch` VALUES ('13774', '21030');
INSERT INTO `page_branch` VALUES ('13910', '20627');
INSERT INTO `page_branch` VALUES ('13910', '20629');
INSERT INTO `page_branch` VALUES ('13911', '20628');
INSERT INTO `page_branch` VALUES ('13911', '20631');
INSERT INTO `page_branch` VALUES ('13912', '20630');
INSERT INTO `page_branch` VALUES ('13912', '20632');
INSERT INTO `page_branch` VALUES ('14267', '21123');
INSERT INTO `page_branch` VALUES ('14404', '21309');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `allowcustomized` tinyint(1) DEFAULT NULL,
  `allowdescription` tinyint(1) DEFAULT NULL,
  `allowmultipile` tinyint(1) DEFAULT NULL,
  `questiontitle` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `questiontype` int(10) NOT NULL,
  `wysiwyg` tinyint(1) DEFAULT NULL,
  `answertype` int(10) DEFAULT NULL,
  `answermask` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `rating` double(20,0) DEFAULT NULL,
  `columntype` int(10) DEFAULT NULL,
  `inuse` bit(1) DEFAULT NULL,
  `occupy` tinyint(1) DEFAULT '0',
  `lockuser` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `description` text COLLATE utf8_bin,
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=20734 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '0', '0', '0', '2363663', '1', '0', '1', null, null, null, null, '1', 'Test Test', null);
INSERT INTO `question` VALUES ('95', '1', '0', '0', 'Matrix choice question with customized answers bar', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('96', '0', '0', '0', 'asdasdddddddddddddddddddddddddddddddddddddddddddd', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('118', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('119', '0', '0', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('148', '0', '1', '0', 'What do you think about the following opinion of this company has:', '4', '0', null, null, null, '1', null, '0', null, null);
INSERT INTO `question` VALUES ('149', '0', '1', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, '5', '2', null, '1', 'Test Test', null);
INSERT INTO `question` VALUES ('171', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('364', '0', '0', '0', 'question 1', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('832', '0', '0', '0', 'Question 7', '1', '0', '1', '99/99/9999', null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('833', '1', '0', '0', 'Question 3', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('941', '0', '0', '0', 'question 4', '1', '0', '2', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('942', '0', '0', '0', 'Question 5', '1', '0', '3', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('943', '0', '0', '0', 'Question 6', '2', '0', null, null, '7', null, null, '0', null, null);
INSERT INTO `question` VALUES ('963', '1', '0', '0', 'Question 8', '4', '0', null, null, null, '1', null, '0', null, null);
INSERT INTO `question` VALUES ('964', '0', '0', '0', 'Question 9', '4', '0', null, null, '3', '2', null, '0', null, null);
INSERT INTO `question` VALUES ('965', '0', '0', '0', 'Question 10', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('987', '1', '0', '0', 'Question 11', '4', '0', null, null, '7', '3', null, '0', null, null);
INSERT INTO `question` VALUES ('1297', '0', '0', '1', 'Question 12', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('1298', '1', '0', '1', 'Question 13', '4', '0', null, null, null, '3', null, '1', 'Test Test', null);
INSERT INTO `question` VALUES ('3232', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '1', '', null);
INSERT INTO `question` VALUES ('3264', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('3521', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('3568', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('3779', '0', '1', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('3780', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('4166', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('5181', '0', '1', '0', 'What do you think about the following opinion of this company has:', '4', '0', null, null, '2', '1', null, '0', null, null);
INSERT INTO `question` VALUES ('5183', '0', '0', '0', 'aaaa', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('7727', '0', '0', '0', '蔡皓宇 rating', '2', '0', null, null, '9', null, null, '0', null, null);
INSERT INTO `question` VALUES ('7828', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('8110', '0', '0', '0', 'What order of importance do you rank the following website features. What order of importance do you rank the following website features. What order of importance do you rank the following website features', '4', '0', null, null, '5', '3', null, '0', null, null);
INSERT INTO `question` VALUES ('8824', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('8825', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('8826', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('8827', '0', '1', '0', 'From 1 to 5, please rate your website cross-browser compatible', '2', '0', null, null, '6', null, null, '0', null, null);
INSERT INTO `question` VALUES ('11498', '1', '1', '1', 'Choice question jump', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('11499', '0', '1', '0', 'Choice no jump', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('11501', '0', '0', '0', 'Matrix rating question', '4', '0', null, null, '8', '2', null, '0', null, null);
INSERT INTO `question` VALUES ('13575', '0', '0', '0', 'Allow Multiple Answers No', '3', '0', null, null, null, '3', null, '0', null, null);
INSERT INTO `question` VALUES ('13576', '0', '0', '0', 'afff', '4', '0', null, null, '5', '3', null, '0', null, null);
INSERT INTO `question` VALUES ('15773', '0', '0', '0', 'Gender: ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15774', '0', '0', '0', 'Age: ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15775', '1', '0', '0', 'How did you first become aware of this survey? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15776', '0', '0', '0', 'Which of the following best describes your current status involved with web design: ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15777', '0', '0', '0', 'How would you describe your level of expertise in web design and development? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15778', '1', '0', '0', 'What is your employment status? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15779', '1', '0', '0', 'Highest level of education you have completed: ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15780', '0', '0', '1', 'Your web design skills (check all that apply): ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15781', '0', '0', '0', 'Do you have a personal blog? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15782', '0', '0', '0', 'Do you have a personal website? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15783', '0', '0', '1', 'Which of these tools do you use for web design? (Check all that apply): ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15784', '1', '0', '0', 'Which, if any, CMS do you currently use? (Check all that apply) ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15785', '0', '0', '0', 'Which, if any, of these technology items do you own? (Check all that apply): ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15786', '0', '0', '0', 'How often do you visit blogs to read a new post? ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('15787', '1', '0', '0', 'How do you follow blogs? (Check all that apply): ', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('17910', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18555', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18556', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18557', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18558', '0', '0', '0', 'From 1 to 9, please rate your already exists content?', '2', '0', null, null, '10', null, null, '0', null, null);
INSERT INTO `question` VALUES ('18559', '0', '0', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('18560', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18563', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, '5', '3', null, '0', null, 0x54686973206973206D61747269783C62722F3E);
INSERT INTO `question` VALUES ('18564', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, '5', '3', null, '0', null, 0x54686973206973206D61747269783C62722F3E);
INSERT INTO `question` VALUES ('18565', '0', '1', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, '5', '2', null, '0', null, 0x54686973206973206D617472697854686973206973206D61747269783C62722F3E);
INSERT INTO `question` VALUES ('18566', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18567', '0', '0', '0', 'From 1 to 9, please rate your already exists content?', '2', '0', null, null, '10', null, null, '0', null, null);
INSERT INTO `question` VALUES ('18568', '0', '0', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('18569', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, '5', '3', null, '0', null, 0x54686973206973206D61747269783C62722F3E);
INSERT INTO `question` VALUES ('18570', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18571', '0', '0', '0', 'From 1 to 9, please rate your already exists content?', '2', '0', null, null, '10', null, null, '0', null, null);
INSERT INTO `question` VALUES ('18572', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '1', 'Test Test', 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18573', '0', '0', '0', 'From 1 to 9, please rate your already exists content?', '2', '0', null, null, '10', null, null, '0', null, null);
INSERT INTO `question` VALUES ('18574', '0', '0', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, null, '0', null, null);
INSERT INTO `question` VALUES ('18575', '0', '1', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, '5', '2', null, '0', null, 0x54686973206973206D617472697854686973206973206D61747269783C62722F3E);
INSERT INTO `question` VALUES ('18580', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('18581', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('19267', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null, 0x546869732069732066726565746578743C62722F3E);
INSERT INTO `question` VALUES ('19268', '0', '0', '0', 'From 1 to 5, please rate your website cross-browser compatible', '2', '0', null, null, '6', null, null, '0', null, null);
INSERT INTO `question` VALUES ('19474', '0', '0', '0', 'aaa', '2', '0', null, null, '5', null, null, '0', null, null);
INSERT INTO `question` VALUES ('20117', '0', '1', '0', 'kill someBody', '1', '0', '1', null, null, '1', null, '0', null, 0x692068617665206120647265616D20692077616E74206B696C6C20796F7520213C62722F3E);
INSERT INTO `question` VALUES ('20118', '0', '1', '0', 'preper question has saved?', '1', '0', '1', null, null, '1', null, '0', null, 0x74686174206B696C6C20736F6D65426F6479206F6620746865207175657374696F6E206861732073617665203F3C62722F3E);

-- ----------------------------
-- Table structure for `question_answer`
-- ----------------------------
DROP TABLE IF EXISTS `question_answer`;
CREATE TABLE `question_answer` (
  `questionid` int(11) NOT NULL,
  `answerid` int(11) NOT NULL,
  PRIMARY KEY (`questionid`,`answerid`),
  KEY `FK561DF237ECAA0FE7` (`answerid`),
  KEY `FK561DF2372C582A37` (`questionid`),
  CONSTRAINT `FK561DF2372C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK561DF237ECAA0FE7` FOREIGN KEY (`answerid`) REFERENCES `answer` (`answerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question_answer
-- ----------------------------
INSERT INTO `question_answer` VALUES ('833', '621');
INSERT INTO `question_answer` VALUES ('833', '622');
INSERT INTO `question_answer` VALUES ('833', '623');
INSERT INTO `question_answer` VALUES ('3779', '2638');
INSERT INTO `question_answer` VALUES ('3779', '2639');
INSERT INTO `question_answer` VALUES ('3779', '2640');
INSERT INTO `question_answer` VALUES ('5183', '3345');
INSERT INTO `question_answer` VALUES ('5183', '3346');
INSERT INTO `question_answer` VALUES ('5183', '3347');
INSERT INTO `question_answer` VALUES ('5183', '3348');
INSERT INTO `question_answer` VALUES ('5183', '3349');
INSERT INTO `question_answer` VALUES ('5183', '3350');
INSERT INTO `question_answer` VALUES ('5183', '3351');
INSERT INTO `question_answer` VALUES ('5183', '3352');
INSERT INTO `question_answer` VALUES ('5183', '3353');
INSERT INTO `question_answer` VALUES ('11498', '6499');
INSERT INTO `question_answer` VALUES ('11498', '6500');
INSERT INTO `question_answer` VALUES ('11498', '6501');
INSERT INTO `question_answer` VALUES ('11498', '6502');
INSERT INTO `question_answer` VALUES ('11498', '6503');
INSERT INTO `question_answer` VALUES ('11499', '6504');
INSERT INTO `question_answer` VALUES ('11499', '6505');
INSERT INTO `question_answer` VALUES ('11499', '6506');
INSERT INTO `question_answer` VALUES ('13575', '7657');
INSERT INTO `question_answer` VALUES ('13575', '7658');
INSERT INTO `question_answer` VALUES ('13575', '7659');
INSERT INTO `question_answer` VALUES ('13575', '7660');
INSERT INTO `question_answer` VALUES ('13575', '7661');
INSERT INTO `question_answer` VALUES ('13575', '7662');
INSERT INTO `question_answer` VALUES ('13575', '7663');
INSERT INTO `question_answer` VALUES ('13575', '7664');
INSERT INTO `question_answer` VALUES ('13575', '7665');
INSERT INTO `question_answer` VALUES ('15773', '8893');
INSERT INTO `question_answer` VALUES ('15773', '8894');
INSERT INTO `question_answer` VALUES ('15774', '8895');
INSERT INTO `question_answer` VALUES ('15774', '8896');
INSERT INTO `question_answer` VALUES ('15774', '8897');
INSERT INTO `question_answer` VALUES ('15774', '8898');
INSERT INTO `question_answer` VALUES ('15774', '8899');
INSERT INTO `question_answer` VALUES ('15774', '8900');
INSERT INTO `question_answer` VALUES ('15774', '8901');
INSERT INTO `question_answer` VALUES ('15775', '8902');
INSERT INTO `question_answer` VALUES ('15775', '8903');
INSERT INTO `question_answer` VALUES ('15775', '8904');
INSERT INTO `question_answer` VALUES ('15776', '8905');
INSERT INTO `question_answer` VALUES ('15776', '8906');
INSERT INTO `question_answer` VALUES ('15776', '8907');
INSERT INTO `question_answer` VALUES ('15776', '8908');
INSERT INTO `question_answer` VALUES ('15776', '8909');
INSERT INTO `question_answer` VALUES ('15776', '8910');
INSERT INTO `question_answer` VALUES ('15777', '8911');
INSERT INTO `question_answer` VALUES ('15777', '8912');
INSERT INTO `question_answer` VALUES ('15777', '8913');
INSERT INTO `question_answer` VALUES ('15778', '8914');
INSERT INTO `question_answer` VALUES ('15778', '8915');
INSERT INTO `question_answer` VALUES ('15778', '8916');
INSERT INTO `question_answer` VALUES ('15778', '8917');
INSERT INTO `question_answer` VALUES ('15778', '8918');
INSERT INTO `question_answer` VALUES ('15778', '8919');
INSERT INTO `question_answer` VALUES ('15779', '8920');
INSERT INTO `question_answer` VALUES ('15779', '8921');
INSERT INTO `question_answer` VALUES ('15779', '8922');
INSERT INTO `question_answer` VALUES ('15779', '8923');
INSERT INTO `question_answer` VALUES ('15779', '8924');
INSERT INTO `question_answer` VALUES ('15779', '8925');
INSERT INTO `question_answer` VALUES ('15780', '8926');
INSERT INTO `question_answer` VALUES ('15780', '8927');
INSERT INTO `question_answer` VALUES ('15780', '8928');
INSERT INTO `question_answer` VALUES ('15780', '8929');
INSERT INTO `question_answer` VALUES ('15780', '8930');
INSERT INTO `question_answer` VALUES ('15780', '8931');
INSERT INTO `question_answer` VALUES ('15780', '8932');
INSERT INTO `question_answer` VALUES ('15780', '8933');
INSERT INTO `question_answer` VALUES ('15780', '8934');
INSERT INTO `question_answer` VALUES ('15781', '8935');
INSERT INTO `question_answer` VALUES ('15781', '8936');
INSERT INTO `question_answer` VALUES ('15782', '8937');
INSERT INTO `question_answer` VALUES ('15782', '8938');
INSERT INTO `question_answer` VALUES ('15783', '8939');
INSERT INTO `question_answer` VALUES ('15783', '8940');
INSERT INTO `question_answer` VALUES ('15783', '8941');
INSERT INTO `question_answer` VALUES ('15783', '8942');
INSERT INTO `question_answer` VALUES ('15783', '8943');
INSERT INTO `question_answer` VALUES ('15783', '8944');
INSERT INTO `question_answer` VALUES ('15783', '8945');
INSERT INTO `question_answer` VALUES ('15784', '8946');
INSERT INTO `question_answer` VALUES ('15784', '8947');
INSERT INTO `question_answer` VALUES ('15784', '8948');
INSERT INTO `question_answer` VALUES ('15784', '8949');
INSERT INTO `question_answer` VALUES ('15784', '8950');
INSERT INTO `question_answer` VALUES ('15784', '8951');
INSERT INTO `question_answer` VALUES ('15785', '8952');
INSERT INTO `question_answer` VALUES ('15785', '8953');
INSERT INTO `question_answer` VALUES ('15785', '8954');
INSERT INTO `question_answer` VALUES ('15785', '8955');
INSERT INTO `question_answer` VALUES ('15785', '8956');
INSERT INTO `question_answer` VALUES ('15785', '8957');
INSERT INTO `question_answer` VALUES ('15785', '8958');
INSERT INTO `question_answer` VALUES ('15785', '8959');
INSERT INTO `question_answer` VALUES ('15785', '8960');
INSERT INTO `question_answer` VALUES ('15786', '8961');
INSERT INTO `question_answer` VALUES ('15786', '8962');
INSERT INTO `question_answer` VALUES ('15786', '8963');
INSERT INTO `question_answer` VALUES ('15786', '8964');
INSERT INTO `question_answer` VALUES ('15786', '8965');
INSERT INTO `question_answer` VALUES ('15786', '8966');
INSERT INTO `question_answer` VALUES ('15786', '8967');
INSERT INTO `question_answer` VALUES ('15786', '8968');
INSERT INTO `question_answer` VALUES ('15786', '8969');
INSERT INTO `question_answer` VALUES ('15787', '8970');
INSERT INTO `question_answer` VALUES ('15787', '8971');
INSERT INTO `question_answer` VALUES ('15787', '8972');
INSERT INTO `question_answer` VALUES ('15787', '8973');
INSERT INTO `question_answer` VALUES ('18559', '10484');
INSERT INTO `question_answer` VALUES ('18559', '10485');
INSERT INTO `question_answer` VALUES ('18559', '10486');
INSERT INTO `question_answer` VALUES ('18568', '10487');
INSERT INTO `question_answer` VALUES ('18568', '10488');
INSERT INTO `question_answer` VALUES ('18568', '10489');
INSERT INTO `question_answer` VALUES ('18574', '10490');
INSERT INTO `question_answer` VALUES ('18574', '10491');
INSERT INTO `question_answer` VALUES ('18574', '10492');

-- ----------------------------
-- Table structure for `question_columnchoice`
-- ----------------------------
DROP TABLE IF EXISTS `question_columnchoice`;
CREATE TABLE `question_columnchoice` (
  `questionid` int(11) NOT NULL,
  `columnchoiceid` int(11) NOT NULL,
  PRIMARY KEY (`questionid`,`columnchoiceid`),
  KEY `FK75E20C3031F29B19` (`columnchoiceid`),
  KEY `FK75E20C302C582A37` (`questionid`),
  CONSTRAINT `FK75E20C302C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`),
  CONSTRAINT `FK75E20C3031F29B19` FOREIGN KEY (`columnchoiceid`) REFERENCES `columnchoice` (`columnchoiceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question_columnchoice
-- ----------------------------
INSERT INTO `question_columnchoice` VALUES ('95', '6');
INSERT INTO `question_columnchoice` VALUES ('95', '7');
INSERT INTO `question_columnchoice` VALUES ('95', '8');
INSERT INTO `question_columnchoice` VALUES ('118', '19');
INSERT INTO `question_columnchoice` VALUES ('118', '20');
INSERT INTO `question_columnchoice` VALUES ('118', '21');
INSERT INTO `question_columnchoice` VALUES ('118', '22');
INSERT INTO `question_columnchoice` VALUES ('118', '23');
INSERT INTO `question_columnchoice` VALUES ('119', '24');
INSERT INTO `question_columnchoice` VALUES ('119', '25');
INSERT INTO `question_columnchoice` VALUES ('119', '26');
INSERT INTO `question_columnchoice` VALUES ('119', '27');
INSERT INTO `question_columnchoice` VALUES ('148', '28');
INSERT INTO `question_columnchoice` VALUES ('148', '29');
INSERT INTO `question_columnchoice` VALUES ('148', '30');
INSERT INTO `question_columnchoice` VALUES ('148', '31');
INSERT INTO `question_columnchoice` VALUES ('148', '32');
INSERT INTO `question_columnchoice` VALUES ('149', '33');
INSERT INTO `question_columnchoice` VALUES ('149', '34');
INSERT INTO `question_columnchoice` VALUES ('149', '35');
INSERT INTO `question_columnchoice` VALUES ('149', '36');
INSERT INTO `question_columnchoice` VALUES ('965', '115');
INSERT INTO `question_columnchoice` VALUES ('965', '116');
INSERT INTO `question_columnchoice` VALUES ('987', '126');
INSERT INTO `question_columnchoice` VALUES ('987', '127');
INSERT INTO `question_columnchoice` VALUES ('1297', '200');
INSERT INTO `question_columnchoice` VALUES ('1297', '201');
INSERT INTO `question_columnchoice` VALUES ('1297', '202');
INSERT INTO `question_columnchoice` VALUES ('1298', '203');
INSERT INTO `question_columnchoice` VALUES ('1298', '204');
INSERT INTO `question_columnchoice` VALUES ('3264', '709');
INSERT INTO `question_columnchoice` VALUES ('3264', '710');
INSERT INTO `question_columnchoice` VALUES ('3264', '711');
INSERT INTO `question_columnchoice` VALUES ('3264', '712');
INSERT INTO `question_columnchoice` VALUES ('3264', '713');
INSERT INTO `question_columnchoice` VALUES ('3780', '817');
INSERT INTO `question_columnchoice` VALUES ('3780', '818');
INSERT INTO `question_columnchoice` VALUES ('3780', '819');
INSERT INTO `question_columnchoice` VALUES ('3780', '820');
INSERT INTO `question_columnchoice` VALUES ('3780', '821');
INSERT INTO `question_columnchoice` VALUES ('5181', '1039');
INSERT INTO `question_columnchoice` VALUES ('5181', '1040');
INSERT INTO `question_columnchoice` VALUES ('5181', '1041');
INSERT INTO `question_columnchoice` VALUES ('5181', '1042');
INSERT INTO `question_columnchoice` VALUES ('8110', '1413');
INSERT INTO `question_columnchoice` VALUES ('8110', '1414');
INSERT INTO `question_columnchoice` VALUES ('8110', '1415');
INSERT INTO `question_columnchoice` VALUES ('8110', '1416');
INSERT INTO `question_columnchoice` VALUES ('13576', '2506');
INSERT INTO `question_columnchoice` VALUES ('13576', '2507');
INSERT INTO `question_columnchoice` VALUES ('13576', '2508');
INSERT INTO `question_columnchoice` VALUES ('13576', '2509');
INSERT INTO `question_columnchoice` VALUES ('13576', '2510');
INSERT INTO `question_columnchoice` VALUES ('13576', '2511');
INSERT INTO `question_columnchoice` VALUES ('13576', '2512');
INSERT INTO `question_columnchoice` VALUES ('18563', '3665');
INSERT INTO `question_columnchoice` VALUES ('18563', '3666');
INSERT INTO `question_columnchoice` VALUES ('18563', '3667');
INSERT INTO `question_columnchoice` VALUES ('18563', '3668');
INSERT INTO `question_columnchoice` VALUES ('18563', '3669');
INSERT INTO `question_columnchoice` VALUES ('18564', '3670');
INSERT INTO `question_columnchoice` VALUES ('18564', '3671');
INSERT INTO `question_columnchoice` VALUES ('18564', '3672');
INSERT INTO `question_columnchoice` VALUES ('18564', '3673');
INSERT INTO `question_columnchoice` VALUES ('18564', '3674');
INSERT INTO `question_columnchoice` VALUES ('18565', '3675');
INSERT INTO `question_columnchoice` VALUES ('18565', '3676');
INSERT INTO `question_columnchoice` VALUES ('18565', '3677');
INSERT INTO `question_columnchoice` VALUES ('18565', '3678');
INSERT INTO `question_columnchoice` VALUES ('18565', '3679');
INSERT INTO `question_columnchoice` VALUES ('18569', '3680');
INSERT INTO `question_columnchoice` VALUES ('18569', '3681');
INSERT INTO `question_columnchoice` VALUES ('18569', '3682');
INSERT INTO `question_columnchoice` VALUES ('18569', '3683');
INSERT INTO `question_columnchoice` VALUES ('18569', '3684');
INSERT INTO `question_columnchoice` VALUES ('18575', '3685');
INSERT INTO `question_columnchoice` VALUES ('18575', '3686');
INSERT INTO `question_columnchoice` VALUES ('18575', '3687');
INSERT INTO `question_columnchoice` VALUES ('18575', '3688');
INSERT INTO `question_columnchoice` VALUES ('18575', '3689');

-- ----------------------------
-- Table structure for `question_subquestion`
-- ----------------------------
DROP TABLE IF EXISTS `question_subquestion`;
CREATE TABLE `question_subquestion` (
  `questionid` int(11) NOT NULL,
  `subquestionid` int(11) NOT NULL,
  PRIMARY KEY (`questionid`,`subquestionid`),
  KEY `FK63A7AB4D3BC35717` (`subquestionid`),
  KEY `FK63A7AB4D2C582A37` (`questionid`),
  CONSTRAINT `FK63A7AB4D2C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`),
  CONSTRAINT `FK63A7AB4D3BC35717` FOREIGN KEY (`subquestionid`) REFERENCES `subquestion` (`subquestionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question_subquestion
-- ----------------------------
INSERT INTO `question_subquestion` VALUES ('95', '10');
INSERT INTO `question_subquestion` VALUES ('95', '11');
INSERT INTO `question_subquestion` VALUES ('95', '12');
INSERT INTO `question_subquestion` VALUES ('95', '13');
INSERT INTO `question_subquestion` VALUES ('118', '25');
INSERT INTO `question_subquestion` VALUES ('118', '26');
INSERT INTO `question_subquestion` VALUES ('118', '27');
INSERT INTO `question_subquestion` VALUES ('118', '28');
INSERT INTO `question_subquestion` VALUES ('118', '29');
INSERT INTO `question_subquestion` VALUES ('119', '30');
INSERT INTO `question_subquestion` VALUES ('119', '31');
INSERT INTO `question_subquestion` VALUES ('119', '32');
INSERT INTO `question_subquestion` VALUES ('148', '33');
INSERT INTO `question_subquestion` VALUES ('148', '34');
INSERT INTO `question_subquestion` VALUES ('148', '35');
INSERT INTO `question_subquestion` VALUES ('148', '36');
INSERT INTO `question_subquestion` VALUES ('149', '38');
INSERT INTO `question_subquestion` VALUES ('149', '39');
INSERT INTO `question_subquestion` VALUES ('149', '40');
INSERT INTO `question_subquestion` VALUES ('149', '41');
INSERT INTO `question_subquestion` VALUES ('963', '149');
INSERT INTO `question_subquestion` VALUES ('963', '150');
INSERT INTO `question_subquestion` VALUES ('964', '151');
INSERT INTO `question_subquestion` VALUES ('964', '152');
INSERT INTO `question_subquestion` VALUES ('965', '171');
INSERT INTO `question_subquestion` VALUES ('965', '172');
INSERT INTO `question_subquestion` VALUES ('987', '173');
INSERT INTO `question_subquestion` VALUES ('987', '174');
INSERT INTO `question_subquestion` VALUES ('987', '175');
INSERT INTO `question_subquestion` VALUES ('1297', '194');
INSERT INTO `question_subquestion` VALUES ('1297', '195');
INSERT INTO `question_subquestion` VALUES ('1297', '196');
INSERT INTO `question_subquestion` VALUES ('1298', '197');
INSERT INTO `question_subquestion` VALUES ('1298', '198');
INSERT INTO `question_subquestion` VALUES ('3264', '622');
INSERT INTO `question_subquestion` VALUES ('3264', '623');
INSERT INTO `question_subquestion` VALUES ('3264', '624');
INSERT INTO `question_subquestion` VALUES ('3264', '625');
INSERT INTO `question_subquestion` VALUES ('3264', '626');
INSERT INTO `question_subquestion` VALUES ('3780', '729');
INSERT INTO `question_subquestion` VALUES ('3780', '730');
INSERT INTO `question_subquestion` VALUES ('3780', '731');
INSERT INTO `question_subquestion` VALUES ('3780', '732');
INSERT INTO `question_subquestion` VALUES ('3780', '733');
INSERT INTO `question_subquestion` VALUES ('5181', '948');
INSERT INTO `question_subquestion` VALUES ('5181', '949');
INSERT INTO `question_subquestion` VALUES ('5181', '950');
INSERT INTO `question_subquestion` VALUES ('5181', '951');
INSERT INTO `question_subquestion` VALUES ('8110', '1282');
INSERT INTO `question_subquestion` VALUES ('8110', '1283');
INSERT INTO `question_subquestion` VALUES ('11501', '1981');
INSERT INTO `question_subquestion` VALUES ('11501', '1982');
INSERT INTO `question_subquestion` VALUES ('13576', '2415');
INSERT INTO `question_subquestion` VALUES ('13576', '2416');
INSERT INTO `question_subquestion` VALUES ('13576', '2417');
INSERT INTO `question_subquestion` VALUES ('13576', '2418');
INSERT INTO `question_subquestion` VALUES ('13576', '2419');
INSERT INTO `question_subquestion` VALUES ('13576', '2420');
INSERT INTO `question_subquestion` VALUES ('13576', '2421');
INSERT INTO `question_subquestion` VALUES ('18563', '3578');
INSERT INTO `question_subquestion` VALUES ('18563', '3579');
INSERT INTO `question_subquestion` VALUES ('18563', '3580');
INSERT INTO `question_subquestion` VALUES ('18563', '3581');
INSERT INTO `question_subquestion` VALUES ('18563', '3582');
INSERT INTO `question_subquestion` VALUES ('18564', '3583');
INSERT INTO `question_subquestion` VALUES ('18564', '3584');
INSERT INTO `question_subquestion` VALUES ('18564', '3585');
INSERT INTO `question_subquestion` VALUES ('18564', '3586');
INSERT INTO `question_subquestion` VALUES ('18564', '3587');
INSERT INTO `question_subquestion` VALUES ('18565', '3588');
INSERT INTO `question_subquestion` VALUES ('18565', '3589');
INSERT INTO `question_subquestion` VALUES ('18565', '3590');
INSERT INTO `question_subquestion` VALUES ('18565', '3591');
INSERT INTO `question_subquestion` VALUES ('18569', '3593');
INSERT INTO `question_subquestion` VALUES ('18569', '3594');
INSERT INTO `question_subquestion` VALUES ('18569', '3595');
INSERT INTO `question_subquestion` VALUES ('18569', '3596');
INSERT INTO `question_subquestion` VALUES ('18569', '3597');
INSERT INTO `question_subquestion` VALUES ('18575', '3598');
INSERT INTO `question_subquestion` VALUES ('18575', '3599');
INSERT INTO `question_subquestion` VALUES ('18575', '3600');
INSERT INTO `question_subquestion` VALUES ('18575', '3601');

-- ----------------------------
-- Table structure for `reponse_entry`
-- ----------------------------
DROP TABLE IF EXISTS `reponse_entry`;
CREATE TABLE `reponse_entry` (
  `entryid` int(11) NOT NULL,
  `responseid` int(11) NOT NULL,
  KEY `entryid` (`entryid`) USING BTREE,
  KEY `responseid` (`responseid`) USING BTREE,
  CONSTRAINT `reponse_entry_ibfk_1` FOREIGN KEY (`entryid`) REFERENCES `entry` (`entryid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reponse_entry_ibfk_2` FOREIGN KEY (`responseid`) REFERENCES `response` (`responseid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reponse_entry
-- ----------------------------

-- ----------------------------
-- Table structure for `response`
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `responseid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`responseid`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of response
-- ----------------------------

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `resultid` int(11) NOT NULL AUTO_INCREMENT,
  `displays` int(11) DEFAULT NULL,
  `pageid` int(11) DEFAULT NULL,
  `pagebranchid` int(11) DEFAULT NULL,
  `pageid_aq` int(11) DEFAULT NULL,
  `pageid_ap` int(11) DEFAULT NULL,
  PRIMARY KEY (`resultid`),
  UNIQUE KEY `resultid` (`resultid`) USING BTREE,
  KEY `resultid_index` (`resultid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9157 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('274', '966', null, null, null, null);
INSERT INTO `result` VALUES ('278', '965', null, null, null, null);
INSERT INTO `result` VALUES ('342', '965', null, null, null, null);
INSERT INTO `result` VALUES ('404', '965', null, null, null, null);
INSERT INTO `result` VALUES ('421', '965', null, null, null, null);
INSERT INTO `result` VALUES ('2278', null, null, null, '598', null);
INSERT INTO `result` VALUES ('3923', null, null, null, null, '709');
INSERT INTO `result` VALUES ('6484', '10377', null, null, null, null);
INSERT INTO `result` VALUES ('6765', null, '10302', '17133', null, null);
INSERT INTO `result` VALUES ('6766', null, '5952', '10172', null, null);
INSERT INTO `result` VALUES ('6767', null, null, null, '5952', null);
INSERT INTO `result` VALUES ('6768', null, null, null, '11135', null);
INSERT INTO `result` VALUES ('6769', null, null, null, null, '5952');
INSERT INTO `result` VALUES ('6770', null, null, null, null, '11135');
INSERT INTO `result` VALUES ('6840', null, '1325', '17246', null, null);
INSERT INTO `result` VALUES ('6916', '8595', null, null, null, null);
INSERT INTO `result` VALUES ('6917', '8596', null, null, null, null);
INSERT INTO `result` VALUES ('6918', '8597', null, null, null, null);
INSERT INTO `result` VALUES ('6979', null, '11299', '17335', null, null);
INSERT INTO `result` VALUES ('6980', null, '11299', '17335', null, null);
INSERT INTO `result` VALUES ('6981', null, '11299', '17335', null, null);
INSERT INTO `result` VALUES ('9016', '15544', null, null, null, null);
INSERT INTO `result` VALUES ('9040', '20454', null, null, null, null);
INSERT INTO `result` VALUES ('9064', '20454', null, null, null, null);

-- ----------------------------
-- Table structure for `scenario`
-- ----------------------------
DROP TABLE IF EXISTS `scenario`;
CREATE TABLE `scenario` (
  `scenarioid` int(11) NOT NULL AUTO_INCREMENT,
  `subquestionid` int(11) DEFAULT NULL,
  `rating` int(20) DEFAULT NULL,
  `answerid` int(11) DEFAULT NULL,
  `textanswer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comparator` int(11) DEFAULT NULL,
  `columnchoiceid` int(11) DEFAULT NULL,
  `scenariotitle` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`scenarioid`)
) ENGINE=InnoDB AUTO_INCREMENT=1272 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scenario
-- ----------------------------
INSERT INTO `scenario` VALUES ('11', '11', '11', '11', null, null, null, null);
INSERT INTO `scenario` VALUES ('906', null, null, '621', null, null, null, null);
INSERT INTO `scenario` VALUES ('907', null, null, '622', null, null, null, null);
INSERT INTO `scenario` VALUES ('1258', null, null, '8902', null, null, null, null);
INSERT INTO `scenario` VALUES ('1263', '10', null, null, null, null, null, 'if Sub Questions 1 equal 1 Columnchoices (Column Choices 2,)');
INSERT INTO `scenario` VALUES ('1264', '11', null, null, null, '4', null, 'if Sub Questions 2 comparator type is or,  equal 2 Columnchoices (Column Choices 2,Column Choices 3,)');
INSERT INTO `scenario` VALUES ('1265', null, null, '3346', null, null, null, null);
INSERT INTO `scenario` VALUES ('1266', null, null, '3347', null, null, null, null);
INSERT INTO `scenario` VALUES ('1267', null, null, '3349', null, null, null, null);

-- ----------------------------
-- Table structure for `scenariocc`
-- ----------------------------
DROP TABLE IF EXISTS `scenariocc`;
CREATE TABLE `scenariocc` (
  `scenarioccid` int(11) NOT NULL AUTO_INCREMENT,
  `columnchoiceid` int(11) NOT NULL,
  PRIMARY KEY (`scenarioccid`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scenariocc
-- ----------------------------
INSERT INTO `scenariocc` VALUES ('197', '7');
INSERT INTO `scenariocc` VALUES ('198', '7');
INSERT INTO `scenariocc` VALUES ('199', '8');

-- ----------------------------
-- Table structure for `scenario_scenariocc`
-- ----------------------------
DROP TABLE IF EXISTS `scenario_scenariocc`;
CREATE TABLE `scenario_scenariocc` (
  `scenarioid` int(11) NOT NULL DEFAULT '0',
  `scenarioccid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`scenarioid`,`scenarioccid`),
  KEY `scenarioccid` (`scenarioccid`),
  CONSTRAINT `scenario_scenariocc_ibfk_1` FOREIGN KEY (`scenarioid`) REFERENCES `scenario` (`scenarioid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scenario_scenariocc_ibfk_2` FOREIGN KEY (`scenarioccid`) REFERENCES `scenariocc` (`scenarioccid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scenario_scenariocc
-- ----------------------------
INSERT INTO `scenario_scenariocc` VALUES ('1263', '197');
INSERT INTO `scenario_scenariocc` VALUES ('1264', '198');
INSERT INTO `scenario_scenariocc` VALUES ('1264', '199');

-- ----------------------------
-- Table structure for `subquestion`
-- ----------------------------
DROP TABLE IF EXISTS `subquestion`;
CREATE TABLE `subquestion` (
  `subquestionid` int(11) NOT NULL AUTO_INCREMENT,
  `subquestionorder` int(11) DEFAULT NULL,
  `subquestiontitle` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`subquestionid`),
  UNIQUE KEY `subquestionid` (`subquestionid`)
) ENGINE=InnoDB AUTO_INCREMENT=4115 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('10', '1', 'Sub Questions 1');
INSERT INTO `subquestion` VALUES ('11', '2', 'Sub Questions 2');
INSERT INTO `subquestion` VALUES ('12', '3', 'Sub Questions 3');
INSERT INTO `subquestion` VALUES ('13', '4', 'Sub Questions 4');
INSERT INTO `subquestion` VALUES ('20', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('25', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('26', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('27', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('28', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('29', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('30', '1', 'My manager provides constructive criticism');
INSERT INTO `subquestion` VALUES ('31', '2', 'Our medical plan provides adequate coverage');
INSERT INTO `subquestion` VALUES ('32', '3', 'I would prefer to work longer hours on fewer days');
INSERT INTO `subquestion` VALUES ('33', '1', 'A good vacation policy');
INSERT INTO `subquestion` VALUES ('34', '2', 'Good management feedback');
INSERT INTO `subquestion` VALUES ('35', '3', 'Good medical insurance');
INSERT INTO `subquestion` VALUES ('36', '4', 'High wages');
INSERT INTO `subquestion` VALUES ('38', '1', 'My manager provides constructive criticism');
INSERT INTO `subquestion` VALUES ('39', '2', 'Our medical plan provides adequate coverage');
INSERT INTO `subquestion` VALUES ('40', '3', 'I would prefer to work longer hours on fewer days');
INSERT INTO `subquestion` VALUES ('41', '4', 'I would like to have more holidays');
INSERT INTO `subquestion` VALUES ('149', '1', '123');
INSERT INTO `subquestion` VALUES ('150', '2', '1234');
INSERT INTO `subquestion` VALUES ('151', '1', 'aaa');
INSERT INTO `subquestion` VALUES ('152', '2', 'bbb');
INSERT INTO `subquestion` VALUES ('171', '1', 'zzz');
INSERT INTO `subquestion` VALUES ('172', '2', 'www');
INSERT INTO `subquestion` VALUES ('173', '1', 'q');
INSERT INTO `subquestion` VALUES ('174', '2', 'qq');
INSERT INTO `subquestion` VALUES ('175', '3', 'qqq');
INSERT INTO `subquestion` VALUES ('194', '1', 'aa');
INSERT INTO `subquestion` VALUES ('195', '2', 'bb');
INSERT INTO `subquestion` VALUES ('196', '3', 'cc');
INSERT INTO `subquestion` VALUES ('197', '1', 'rr');
INSERT INTO `subquestion` VALUES ('198', '2', 'tt');
INSERT INTO `subquestion` VALUES ('622', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('623', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('624', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('625', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('626', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('729', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('730', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('731', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('732', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('733', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('948', '1', 'A good vacation policy');
INSERT INTO `subquestion` VALUES ('949', '2', 'Good management feedback');
INSERT INTO `subquestion` VALUES ('950', '3', 'Good medical insurance');
INSERT INTO `subquestion` VALUES ('951', '4', 'High wages');
INSERT INTO `subquestion` VALUES ('1282', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('1283', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('1981', '1', 'aaaa');
INSERT INTO `subquestion` VALUES ('1982', '2', 'bbbbb');
INSERT INTO `subquestion` VALUES ('2415', '1', 'ffff');
INSERT INTO `subquestion` VALUES ('2416', '2', 'ffff');
INSERT INTO `subquestion` VALUES ('2417', '3', 'ffff');
INSERT INTO `subquestion` VALUES ('2418', '4', 'ffff');
INSERT INTO `subquestion` VALUES ('2419', '5', 'fff');
INSERT INTO `subquestion` VALUES ('2420', '6', 'ff');
INSERT INTO `subquestion` VALUES ('2421', '7', 'fff');
INSERT INTO `subquestion` VALUES ('3578', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('3579', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('3580', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('3581', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('3582', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('3583', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('3584', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('3585', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('3586', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('3587', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('3588', '1', 'My manager provides constructive criticism');
INSERT INTO `subquestion` VALUES ('3589', '2', 'Our medical plan provides adequate coverage');
INSERT INTO `subquestion` VALUES ('3590', '3', 'I would prefer to work longer hours on fewer days');
INSERT INTO `subquestion` VALUES ('3591', '4', 'I would like to have more holidays');
INSERT INTO `subquestion` VALUES ('3593', '1', 'Top ranking by search engines');
INSERT INTO `subquestion` VALUES ('3594', '2', 'Easy Navigation');
INSERT INTO `subquestion` VALUES ('3595', '3', 'Clear information');
INSERT INTO `subquestion` VALUES ('3596', '4', 'Clever animation');
INSERT INTO `subquestion` VALUES ('3597', '5', 'Colourful pictures');
INSERT INTO `subquestion` VALUES ('3598', '1', 'My manager provides constructive criticism');
INSERT INTO `subquestion` VALUES ('3599', '2', 'Our medical plan provides adequate coverage');
INSERT INTO `subquestion` VALUES ('3600', '3', 'I would prefer to work longer hours on fewer days');
INSERT INTO `subquestion` VALUES ('3601', '4', 'I would like to have more holidays');

-- ----------------------------
-- Table structure for `survey`
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `allowsave` tinyint(1) NOT NULL,
  `attributedescriptions` tinyint(1) NOT NULL,
  `datecreated` date DEFAULT NULL,
  `expires` datetime DEFAULT NULL,
  `language` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `supervisor` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `supervisoremail` varchar(320) COLLATE utf8_bin DEFAULT NULL,
  `surveydescription` varchar(650) COLLATE utf8_bin DEFAULT NULL,
  `surveyendtext` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `surveytitle` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `surveywelcometext` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `usecookie` tinyint(1) NOT NULL,
  `occupy` tinyint(1) DEFAULT '0',
  `lockuser` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=10501 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('411', '0', '0', '0', '2012-10-09', null, 'EN', 'asddddddddasd', '', 'Test Survey 3asddddddddddddddddasdasd\r\nTest Survey 3 3 by xiong Test Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiong', 'assssssssssssdddTest Survey 3 3 by xiong Test Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xio', 'Test Survey Test Survey Test Survey Test Survey Test Survey Test Survey', 'asdddddddddddddasdTest Survey 3 3 by xiong Test Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiongTest Survey 3 3 by xiong', '0', '1', 'Test Test');
INSERT INTO `survey` VALUES ('457', '0', '0', '0', '2012-10-09', null, 'EN', '', '', '小赵做Preview使用1', '小赵做Preview使用3', '小赵做Preview使用333', '小赵做Preview使用2', '0', '0', null);
INSERT INTO `survey` VALUES ('3496', '0', '0', '0', '2012-10-16', null, 'EN', '', '', 'why？tell me', '', 'asdasdasdasd', '', '0', '1', 'Test Test');
INSERT INTO `survey` VALUES ('3497', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxc', '', '0', '0', null);
INSERT INTO `survey` VALUES ('3498', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxczxc', '', '0', '0', null);
INSERT INTO `survey` VALUES ('3511', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxc12112', '', '0', '0', null);
INSERT INTO `survey` VALUES ('3983', '1', '0', '0', '2012-10-17', '2012-09-19 00:00:00', 'EN', '', '123@168.COM', 'ASasASas', 'ASDSADSA', 'asdasd', 'ASDSAD\r\n', '0', '0', null);
INSERT INTO `survey` VALUES ('4077', '0', '0', '0', '2012-10-17', null, 'EN', '', '', '', '', '333333333', '', '0', '0', null);
INSERT INTO `survey` VALUES ('4100', '1', '1', '1', '2012-10-17', '2012-10-05 00:00:00', 'EN', 'xc', 'xc@163.com', 'using', 'tks', 'survey1', 'welcome', '0', '0', null);
INSERT INTO `survey` VALUES ('4132', '0', '0', '0', '2012-10-17', null, 'EN', '', '', '', '', '12333333333312123', '', '0', '0', null);
INSERT INTO `survey` VALUES ('4916', '0', '0', '0', '2012-10-18', null, 'EN', '', '', '', '', 'qweqwe', '', '0', '1', 'Test Test');
INSERT INTO `survey` VALUES ('4917', '0', '0', '0', '2012-10-18', null, 'EN', '', '', '', '', 'qweqweqw', '', '0', '0', null);
INSERT INTO `survey` VALUES ('5365', '0', '0', '0', '2012-10-19', null, 'EN', '', '', '', '', 'qwe', '', '0', '0', null);
INSERT INTO `survey` VALUES ('5541', '0', '0', '0', '2012-10-19', null, 'EN', '', '', '', '', 'asdsd', '', '0', '0', null);
INSERT INTO `survey` VALUES ('5592', '0', '0', '0', '2012-10-23', null, 'EN', '', '', '', '', 'asd', '', '0', '0', null);
INSERT INTO `survey` VALUES ('5593', '1', '1', '0', '2012-10-23', '2012-10-17 00:00:00', 'EN', 'sdsad', 'asd', 'ASa', 'ASas', 'ASas', 'assd', '0', '0', null);
INSERT INTO `survey` VALUES ('5594', '1', '1', '1', '2012-10-23', '2012-10-12 00:00:00', 'EN', 'ASA', 'ASA', 'AS', 'AS', 'AS', 'AS', '0', '0', null);
INSERT INTO `survey` VALUES ('7813', '0', '0', '0', '2012-10-25', null, 'EN', '', '', '', '', 'test', '', '0', '1', 'Test Test');
INSERT INTO `survey` VALUES ('7815', '0', '0', '0', '2012-10-25', null, null, '', '', '', '', 'dddd', '', '0', '0', null);
INSERT INTO `survey` VALUES ('7817', '0', '0', '0', '2012-10-25', null, 'EN', '', '', '', '', 'testing 123', '', '0', '0', null);
INSERT INTO `survey` VALUES ('7818', '0', '0', '0', '2012-10-25', '2012-12-14 00:00:00', 'EN', '', '', 'Client input is the foundation on which successful websites are built. Additional time spent on up-front planning will save you time and money in the long run by assuring that long-term objectives are not in conflict with short-term solutions.', 'As your assigned Project Manager I will be happy to help you answer each of the questions in a thorough, but brief and clear manner.  Should you see a need, Pulse Solutions stands ready and willing to sign any relevant Non-Disclosure Agreements in order to make you feel comfortable in sharing appropriate information with us. ', 'Client Survey – NEW Site Design Project', 'This survey will help your company to articulate and identify the overall goals of your site design, including specific questions regarding message, audience, content, technology platform, look and feel, and required vs. desired functionality. ', '0', '1', 'Test Test');
INSERT INTO `survey` VALUES ('7820', '0', '0', '0', '2012-10-25', null, null, '', '', '', '', 'zzzzzzzzz', '', '0', '0', null);
INSERT INTO `survey` VALUES ('8844', '0', '0', '0', '2012-10-26', null, 'EN', '', '', '', '', 'dfdsfdsf', '', '0', '0', null);
INSERT INTO `survey` VALUES ('9134', '0', '0', '0', '2012-10-26', null, 'EN', '', '', '', '', 'asdasdasdasdggggggggg', '', '0', '0', null);
INSERT INTO `survey` VALUES ('9236', '0', '0', '0', '2012-10-27', null, 'EN', '', '', 'fdsafasf', '', 'dfdsfa', '', '0', '0', null);
INSERT INTO `survey` VALUES ('9247', '0', '0', '0', '2012-10-27', null, 'EN', '', '', '', '', 'dfsf', '', '0', '0', null);
INSERT INTO `survey` VALUES ('9367', '0', '0', '0', '2012-10-29', null, 'EN', '', '', '', '', '测试中', '', '0', '0', null);
INSERT INTO `survey` VALUES ('9647', '1', '0', '1', '2012-10-30', '2012-10-25 00:00:00', 'EN', 'Martha Retallick', 'M.Retallick@webforyou.com.au', 'How to Extract the Facts with a Web Design Client Questionnaire', 'Whew! That’s quite a list of questions. And, truth be told, I don’t use every one of them every time. It’s important to respect your prospects’ time, even when you’re looking for long-term relationships.', 'Extract the Facts', 'I recommend using this questionnaire before you write a Web design proposal. You should reserve your proposal-writing time for the best-qualified prospects, rather than everyone who asks for one.', '0', '1', '');
INSERT INTO `survey` VALUES ('9862', '0', '0', '0', '2012-10-30', null, 'EN', '', '', '', '', 'aaaa', '', '0', '1', '');

-- ----------------------------
-- Table structure for `survey_page`
-- ----------------------------
DROP TABLE IF EXISTS `survey_page`;
CREATE TABLE `survey_page` (
  `sid` int(11) NOT NULL,
  `pageid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`pageid`),
  KEY `pageid` (`pageid`),
  CONSTRAINT `survey_page_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `survey` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `survey_page_ibfk_2` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey_page
-- ----------------------------
INSERT INTO `survey_page` VALUES ('411', '1276');
INSERT INTO `survey_page` VALUES ('411', '1325');
INSERT INTO `survey_page` VALUES ('3983', '5715');
INSERT INTO `survey_page` VALUES ('3983', '5716');
INSERT INTO `survey_page` VALUES ('3983', '5717');
INSERT INTO `survey_page` VALUES ('3983', '5720');
INSERT INTO `survey_page` VALUES ('3983', '5721');
INSERT INTO `survey_page` VALUES ('3983', '5722');
INSERT INTO `survey_page` VALUES ('4100', '5951');
INSERT INTO `survey_page` VALUES ('457', '5952');
INSERT INTO `survey_page` VALUES ('457', '5953');
INSERT INTO `survey_page` VALUES ('4100', '5954');
INSERT INTO `survey_page` VALUES ('4100', '5955');
INSERT INTO `survey_page` VALUES ('457', '5956');
INSERT INTO `survey_page` VALUES ('4132', '6155');
INSERT INTO `survey_page` VALUES ('4132', '6156');
INSERT INTO `survey_page` VALUES ('4132', '6157');
INSERT INTO `survey_page` VALUES ('4132', '6195');
INSERT INTO `survey_page` VALUES ('4132', '6196');
INSERT INTO `survey_page` VALUES ('4132', '6197');
INSERT INTO `survey_page` VALUES ('457', '7244');
INSERT INTO `survey_page` VALUES ('3496', '9013');
INSERT INTO `survey_page` VALUES ('457', '9536');
INSERT INTO `survey_page` VALUES ('457', '9697');
INSERT INTO `survey_page` VALUES ('457', '10302');
INSERT INTO `survey_page` VALUES ('7818', '11029');
INSERT INTO `survey_page` VALUES ('7820', '11098');
INSERT INTO `survey_page` VALUES ('7820', '11099');
INSERT INTO `survey_page` VALUES ('7820', '11100');
INSERT INTO `survey_page` VALUES ('411', '11991');
INSERT INTO `survey_page` VALUES ('411', '11993');
INSERT INTO `survey_page` VALUES ('411', '12068');
INSERT INTO `survey_page` VALUES ('411', '12832');
INSERT INTO `survey_page` VALUES ('9236', '13080');
INSERT INTO `survey_page` VALUES ('9236', '13081');
INSERT INTO `survey_page` VALUES ('9236', '13082');
INSERT INTO `survey_page` VALUES ('9247', '13089');
INSERT INTO `survey_page` VALUES ('9247', '13090');
INSERT INTO `survey_page` VALUES ('9247', '13091');
INSERT INTO `survey_page` VALUES ('9247', '13092');
INSERT INTO `survey_page` VALUES ('9247', '13093');
INSERT INTO `survey_page` VALUES ('9247', '13094');
INSERT INTO `survey_page` VALUES ('9247', '13095');
INSERT INTO `survey_page` VALUES ('411', '13113');
INSERT INTO `survey_page` VALUES ('411', '13114');
INSERT INTO `survey_page` VALUES ('411', '13115');
INSERT INTO `survey_page` VALUES ('411', '13333');
INSERT INTO `survey_page` VALUES ('411', '13334');
INSERT INTO `survey_page` VALUES ('411', '13335');
INSERT INTO `survey_page` VALUES ('9367', '13338');
INSERT INTO `survey_page` VALUES ('9367', '13339');
INSERT INTO `survey_page` VALUES ('9367', '13340');
INSERT INTO `survey_page` VALUES ('7818', '13344');
INSERT INTO `survey_page` VALUES ('9647', '13649');
INSERT INTO `survey_page` VALUES ('9647', '13650');
INSERT INTO `survey_page` VALUES ('9647', '13651');
INSERT INTO `survey_page` VALUES ('7818', '13774');
INSERT INTO `survey_page` VALUES ('9862', '13910');
INSERT INTO `survey_page` VALUES ('9862', '13911');
INSERT INTO `survey_page` VALUES ('9862', '13912');
INSERT INTO `survey_page` VALUES ('411', '14267');
INSERT INTO `survey_page` VALUES ('7818', '14404');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(22) DEFAULT NULL,
  `password` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'sam', '123456');
INSERT INTO `users` VALUES ('2', 'viona', '123456');
