/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-10-25 09:16:26
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
) ENGINE=InnoDB AUTO_INCREMENT=8359 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `answer` VALUES ('7653', '1', 'aaaa1');
INSERT INTO `answer` VALUES ('7654', '2', 'aaa2');
INSERT INTO `answer` VALUES ('7655', '3', 'aaaa3');
INSERT INTO `answer` VALUES ('7656', '4', 'aaaa4');
INSERT INTO `answer` VALUES ('7657', '1', 'aaa');
INSERT INTO `answer` VALUES ('7658', '2', '....');
INSERT INTO `answer` VALUES ('7659', '3', 'faa');
INSERT INTO `answer` VALUES ('7660', '4', '11');
INSERT INTO `answer` VALUES ('7661', '5', '11');
INSERT INTO `answer` VALUES ('7662', '6', '11');
INSERT INTO `answer` VALUES ('7663', '7', '11');
INSERT INTO `answer` VALUES ('7664', '8', '11');
INSERT INTO `answer` VALUES ('7665', '9', '11');

-- ----------------------------
-- Table structure for `branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem`;
CREATE TABLE `branchitem` (
  `branchitemid` int(11) NOT NULL AUTO_INCREMENT,
  `hidden` tinyint(1) DEFAULT NULL,
  `itemorder` int(3) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `responseColumnchoiceIds` tinyblob,
  PRIMARY KEY (`branchitemid`),
  UNIQUE KEY `branchitem_id` (`branchitemid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14544 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('666', '1', '1', '1', null);
INSERT INTO `branchitem` VALUES ('696', '1', '1', '96', null);
INSERT INTO `branchitem` VALUES ('697', '1', '2', '118', null);
INSERT INTO `branchitem` VALUES ('837', '0', '1', '95', null);
INSERT INTO `branchitem` VALUES ('838', '0', '1', '95', null);
INSERT INTO `branchitem` VALUES ('839', '0', '1', '95', null);
INSERT INTO `branchitem` VALUES ('840', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('841', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('842', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1012', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1013', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1014', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1015', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1016', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('1017', '0', '1', '95', null);
INSERT INTO `branchitem` VALUES ('1018', '0', '1', '95', null);
INSERT INTO `branchitem` VALUES ('1655', '0', '4', '1', null);
INSERT INTO `branchitem` VALUES ('1656', '0', '4', '95', null);
INSERT INTO `branchitem` VALUES ('1657', '0', '3', '149', null);
INSERT INTO `branchitem` VALUES ('1658', '0', '3', '149', null);
INSERT INTO `branchitem` VALUES ('1659', '0', '3', '149', null);
INSERT INTO `branchitem` VALUES ('1660', '0', '3', '149', null);
INSERT INTO `branchitem` VALUES ('1661', '0', '3', '149', null);
INSERT INTO `branchitem` VALUES ('1662', '0', '1', '148', null);
INSERT INTO `branchitem` VALUES ('1695', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('6581', '0', '1', '171', null);
INSERT INTO `branchitem` VALUES ('7552', '0', '1', '7971', null);
INSERT INTO `branchitem` VALUES ('7694', '1', '0', '8110', null);
INSERT INTO `branchitem` VALUES ('8352', '0', '1', '119', null);
INSERT INTO `branchitem` VALUES ('8353', '0', '2', '119', null);
INSERT INTO `branchitem` VALUES ('8553', '0', '1', '118', null);
INSERT INTO `branchitem` VALUES ('8554', '0', '1', '118', null);
INSERT INTO `branchitem` VALUES ('8593', '0', '0', '1', null);
INSERT INTO `branchitem` VALUES ('8594', '0', '1', '118', null);
INSERT INTO `branchitem` VALUES ('8595', '1', '1', '1', null);
INSERT INTO `branchitem` VALUES ('8596', '1', '2', '95', null);
INSERT INTO `branchitem` VALUES ('8597', '1', '3', '96', null);
INSERT INTO `branchitem` VALUES ('8598', '1', '1', '119', null);
INSERT INTO `branchitem` VALUES ('8599', '1', '1', '148', null);
INSERT INTO `branchitem` VALUES ('8600', '1', '2', '149', null);
INSERT INTO `branchitem` VALUES ('8603', '0', '2', '833', null);
INSERT INTO `branchitem` VALUES ('8665', '0', '4', '364', null);
INSERT INTO `branchitem` VALUES ('8666', '0', '5', '832', null);
INSERT INTO `branchitem` VALUES ('8667', '0', '6', '833', null);
INSERT INTO `branchitem` VALUES ('8668', '0', '7', '941', null);
INSERT INTO `branchitem` VALUES ('8669', '0', '8', '942', null);
INSERT INTO `branchitem` VALUES ('8670', '0', '9', '943', null);
INSERT INTO `branchitem` VALUES ('8671', '0', '10', '944', null);
INSERT INTO `branchitem` VALUES ('8672', '0', '11', '963', null);
INSERT INTO `branchitem` VALUES ('8673', '0', '12', '964', null);
INSERT INTO `branchitem` VALUES ('8674', '0', '13', '965', null);
INSERT INTO `branchitem` VALUES ('8675', '0', '14', '987', null);
INSERT INTO `branchitem` VALUES ('8676', '0', '15', '1297', null);
INSERT INTO `branchitem` VALUES ('8677', '0', '16', '1298', null);
INSERT INTO `branchitem` VALUES ('8684', '0', '1', '364', null);
INSERT INTO `branchitem` VALUES ('8685', '0', '2', '832', null);
INSERT INTO `branchitem` VALUES ('8686', '0', '3', '833', null);
INSERT INTO `branchitem` VALUES ('8687', '0', '4', '941', null);
INSERT INTO `branchitem` VALUES ('8688', '0', '5', '942', null);
INSERT INTO `branchitem` VALUES ('8689', '0', '6', '943', null);
INSERT INTO `branchitem` VALUES ('8690', '0', '7', '944', null);
INSERT INTO `branchitem` VALUES ('8691', '0', '8', '963', null);
INSERT INTO `branchitem` VALUES ('8692', '0', '9', '964', null);
INSERT INTO `branchitem` VALUES ('8693', '0', '10', '965', null);
INSERT INTO `branchitem` VALUES ('8694', '0', '10', '987', null);
INSERT INTO `branchitem` VALUES ('8695', '0', '11', '1297', null);
INSERT INTO `branchitem` VALUES ('8696', '0', '12', '1298', null);
INSERT INTO `branchitem` VALUES ('8851', '1', '0', '119', null);
INSERT INTO `branchitem` VALUES ('8852', '0', '1', '3779', null);
INSERT INTO `branchitem` VALUES ('8853', '0', '3', '118', null);
INSERT INTO `branchitem` VALUES ('8854', '0', '1', '119', null);
INSERT INTO `branchitem` VALUES ('8855', '0', '2', '3779', null);
INSERT INTO `branchitem` VALUES ('8856', '0', '3', '118', null);
INSERT INTO `branchitem` VALUES ('8910', '0', '4', '119', null);
INSERT INTO `branchitem` VALUES ('10373', '0', '1', '364', null);
INSERT INTO `branchitem` VALUES ('10374', '0', '2', '364', null);
INSERT INTO `branchitem` VALUES ('10375', '0', '3', '364', null);
INSERT INTO `branchitem` VALUES ('10376', '0', '4', '364', null);
INSERT INTO `branchitem` VALUES ('10377', '1', '5', '1', null);
INSERT INTO `branchitem` VALUES ('10496', '0', '1', '833', null);
INSERT INTO `branchitem` VALUES ('12358', '0', '4', '832', null);
INSERT INTO `branchitem` VALUES ('12786', '0', '0', '95', null);
INSERT INTO `branchitem` VALUES ('12787', '0', '1', '1', null);
INSERT INTO `branchitem` VALUES ('13270', '0', '3', '13574', null);
INSERT INTO `branchitem` VALUES ('13271', '0', '4', '13575', null);
INSERT INTO `branchitem` VALUES ('13272', '0', '5', '13576', null);

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
  CONSTRAINT `branchitemrule_ibfk_1` FOREIGN KEY (`conditionid`) REFERENCES `condition` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6276 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule
-- ----------------------------
INSERT INTO `branchitemrule` VALUES ('4178', 'If the user answers this question. Show 2 hidden questions.', '6056', '1');
INSERT INTO `branchitemrule` VALUES ('4250', 'If the user answers this question. Show 3 hidden questions.', '6170', '1');
INSERT INTO `branchitemrule` VALUES ('4251', 'If the user skipsthis question. Show one hidden question.', '6171', '1');
INSERT INTO `branchitemrule` VALUES ('4252', 'If the user answersthis question. Temporarily set one pagebranch as default.', '6172', '2');
INSERT INTO `branchitemrule` VALUES ('4540', 'If sub questions and column choices meet certain expectation(s), this question. Jump to page (Page2) immediately.', '6642', '3');
INSERT INTO `branchitemrule` VALUES ('5170', 'If sub questions and column choices meet certain expectation(s), this question. Jump to page (Page3) immediately.', '7678', '3');
INSERT INTO `branchitemrule` VALUES ('5171', 'If sub questions and column choices meet certain expectation(s), this question. Show 0 hidden questions.', '7679', '1');
INSERT INTO `branchitemrule` VALUES ('5267', 'If sub questions and column choices meet certain expectation(s), this question. Jump to page (Page2) immediately.', '7831', '3');
INSERT INTO `branchitemrule` VALUES ('5644', 'If sub questions and column choices meet certain expectation(s), this question. Temporarily set pagebranch (1788) of page (587) as default.', '8446', '2');
INSERT INTO `branchitemrule` VALUES ('5646', 'If sub questions and column choices meet certain expectation(s), this question. Temporarily set 2 pagebranchs as default.', '8448', '2');
INSERT INTO `branchitemrule` VALUES ('5647', 'If sub questions and column choices meet certain expectation(s), this question. Temporarily set 2 pagebranchs as default.', '8449', '2');
INSERT INTO `branchitemrule` VALUES ('5648', 'If answers meet certain expectation(s), this question. Temporarily set pagebranch (1788) of page (587) as default.', '8450', '2');
INSERT INTO `branchitemrule` VALUES ('5738', 'If answers meet certain expectation(s), this question. Show one hidden question.', '8596', '1');
INSERT INTO `branchitemrule` VALUES ('5762', 'If the user answersthis question. Jump to page (Page One B) immediately.', '8634', '3');
INSERT INTO `branchitemrule` VALUES ('5869', 'If the user answersthis question. Jump to page (Last Page) after page.', '8811', '4');

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
INSERT INTO `branchitemrule_result` VALUES ('4178', '3930');
INSERT INTO `branchitemrule_result` VALUES ('4178', '3931');
INSERT INTO `branchitemrule_result` VALUES ('4250', '4010');
INSERT INTO `branchitemrule_result` VALUES ('4250', '4011');
INSERT INTO `branchitemrule_result` VALUES ('4250', '4012');
INSERT INTO `branchitemrule_result` VALUES ('4251', '4013');
INSERT INTO `branchitemrule_result` VALUES ('4540', '4322');
INSERT INTO `branchitemrule_result` VALUES ('5170', '4999');
INSERT INTO `branchitemrule_result` VALUES ('5267', '5098');
INSERT INTO `branchitemrule_result` VALUES ('4252', '5491');
INSERT INTO `branchitemrule_result` VALUES ('5644', '5493');
INSERT INTO `branchitemrule_result` VALUES ('5644', '5494');
INSERT INTO `branchitemrule_result` VALUES ('5646', '5496');
INSERT INTO `branchitemrule_result` VALUES ('5646', '5497');
INSERT INTO `branchitemrule_result` VALUES ('5647', '5498');
INSERT INTO `branchitemrule_result` VALUES ('5647', '5499');
INSERT INTO `branchitemrule_result` VALUES ('5648', '5500');
INSERT INTO `branchitemrule_result` VALUES ('5648', '5501');
INSERT INTO `branchitemrule_result` VALUES ('5738', '5595');
INSERT INTO `branchitemrule_result` VALUES ('5762', '5620');
INSERT INTO `branchitemrule_result` VALUES ('5869', '5736');

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
INSERT INTO `branchitem_branchitemrule` VALUES ('8665', '4178');
INSERT INTO `branchitem_branchitemrule` VALUES ('8668', '4250');
INSERT INTO `branchitem_branchitemrule` VALUES ('10373', '4251');
INSERT INTO `branchitem_branchitemrule` VALUES ('10374', '4252');
INSERT INTO `branchitem_branchitemrule` VALUES ('7694', '4540');
INSERT INTO `branchitem_branchitemrule` VALUES ('7552', '5170');
INSERT INTO `branchitem_branchitemrule` VALUES ('7552', '5171');
INSERT INTO `branchitem_branchitemrule` VALUES ('7694', '5267');
INSERT INTO `branchitem_branchitemrule` VALUES ('13272', '5644');
INSERT INTO `branchitem_branchitemrule` VALUES ('13272', '5646');
INSERT INTO `branchitem_branchitemrule` VALUES ('13272', '5647');
INSERT INTO `branchitem_branchitemrule` VALUES ('13271', '5648');
INSERT INTO `branchitem_branchitemrule` VALUES ('13270', '5738');
INSERT INTO `branchitem_branchitemrule` VALUES ('10375', '5762');
INSERT INTO `branchitem_branchitemrule` VALUES ('8684', '5869');

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
) ENGINE=InnoDB AUTO_INCREMENT=2774 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  `conditiontype` int(11) NOT NULL DEFAULT '1',
  `comparator` int(11) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9484 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('2', '1', '0', null);
INSERT INTO `condition` VALUES ('8', '1', '0', null);
INSERT INTO `condition` VALUES ('13', '1', '0', null);
INSERT INTO `condition` VALUES ('6056', '0', '2', null);
INSERT INTO `condition` VALUES ('6170', '0', '2', null);
INSERT INTO `condition` VALUES ('6171', '1', '2', null);
INSERT INTO `condition` VALUES ('6172', '0', '1', null);
INSERT INTO `condition` VALUES ('6642', '1', '5', '4');
INSERT INTO `condition` VALUES ('7678', '1', '5', '5');
INSERT INTO `condition` VALUES ('7679', '1', '5', null);
INSERT INTO `condition` VALUES ('7831', '1', '5', '5');
INSERT INTO `condition` VALUES ('8446', '1', '5', '5');
INSERT INTO `condition` VALUES ('8448', '1', '5', '5');
INSERT INTO `condition` VALUES ('8449', '1', '5', '5');
INSERT INTO `condition` VALUES ('8450', '1', '4', null);
INSERT INTO `condition` VALUES ('8596', '1', '4', '4');
INSERT INTO `condition` VALUES ('8634', '0', '1', null);
INSERT INTO `condition` VALUES ('8811', '0', '1', null);

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
  CONSTRAINT `condition_scenario_ibfk_1` FOREIGN KEY (`conditionid`) REFERENCES `condition` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of condition_scenario
-- ----------------------------
INSERT INTO `condition_scenario` VALUES ('6642', '463');
INSERT INTO `condition_scenario` VALUES ('6642', '464');
INSERT INTO `condition_scenario` VALUES ('7678', '580');
INSERT INTO `condition_scenario` VALUES ('7678', '581');
INSERT INTO `condition_scenario` VALUES ('7679', '582');
INSERT INTO `condition_scenario` VALUES ('7831', '617');
INSERT INTO `condition_scenario` VALUES ('7831', '618');
INSERT INTO `condition_scenario` VALUES ('8446', '687');
INSERT INTO `condition_scenario` VALUES ('8446', '688');
INSERT INTO `condition_scenario` VALUES ('8446', '689');
INSERT INTO `condition_scenario` VALUES ('8446', '690');
INSERT INTO `condition_scenario` VALUES ('8446', '691');
INSERT INTO `condition_scenario` VALUES ('8446', '692');
INSERT INTO `condition_scenario` VALUES ('8448', '693');
INSERT INTO `condition_scenario` VALUES ('8448', '694');
INSERT INTO `condition_scenario` VALUES ('8448', '695');
INSERT INTO `condition_scenario` VALUES ('8448', '696');
INSERT INTO `condition_scenario` VALUES ('8448', '697');
INSERT INTO `condition_scenario` VALUES ('8448', '698');
INSERT INTO `condition_scenario` VALUES ('8449', '699');
INSERT INTO `condition_scenario` VALUES ('8449', '700');
INSERT INTO `condition_scenario` VALUES ('8449', '701');
INSERT INTO `condition_scenario` VALUES ('8449', '702');
INSERT INTO `condition_scenario` VALUES ('8450', '703');
INSERT INTO `condition_scenario` VALUES ('8596', '720');
INSERT INTO `condition_scenario` VALUES ('8596', '721');

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
) ENGINE=InnoDB AUTO_INCREMENT=10302 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('586', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('587', '2', 'Page2', '', '');
INSERT INTO `page` VALUES ('709', '3', 'Page3', '', '');
INSERT INTO `page` VALUES ('1276', '1', 'Page 1', 'This is Page Header of Page 1', 'This is Page Footer of Page 1');
INSERT INTO `page` VALUES ('1325', '2', 'Page 2', 'This is Page Header of Page 2.', 'This is Page Footer of Page 2.');
INSERT INTO `page` VALUES ('3370', '0', 'New Page', null, null);
INSERT INTO `page` VALUES ('3371', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('3372', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('3416', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('3417', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('3418', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('5715', '0', 'New Page', null, null);
INSERT INTO `page` VALUES ('5716', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('5717', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('5720', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('5721', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('5722', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('5951', '1', 'page1', 'Header', 'Footer');
INSERT INTO `page` VALUES ('5952', '0', 'Page One A', '', '');
INSERT INTO `page` VALUES ('5953', '3', 'Page Two', '', '');
INSERT INTO `page` VALUES ('5954', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('5955', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('5956', '2', 'Page One B', 'Page Header of Page One B', 'Page Footer of Page One B');
INSERT INTO `page` VALUES ('6155', '0', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('6156', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('6157', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('6195', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('6196', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('6197', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('7244', '1', 'Cover Page', 'Cover Page Header', 'Cover Page Footer');
INSERT INTO `page` VALUES ('9013', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('9536', '5', 'Last Page', 'Header', 'Footer');
INSERT INTO `page` VALUES ('9539', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('9540', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('9697', '4', 'Page Three', 'Page Three Header', 'Page Three Footer');

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
) ENGINE=InnoDB AUTO_INCREMENT=16023 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('1424', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1427', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1786', 'Branch 1', '1', '1');
INSERT INTO `pagebranch` VALUES ('1787', 'Branch 1', '0', '1');
INSERT INTO `pagebranch` VALUES ('1788', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('1889', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2041', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('2042', 'Branch 6', '0', '0');
INSERT INTO `pagebranch` VALUES ('2043', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2079', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('2080', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2874', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('2991', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('6254', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('6255', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('6257', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('6317', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('6318', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('6319', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('6320', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('6321', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('9803', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('9804', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9805', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9808', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9809', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('9810', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('10169', 'Branch 1', '0', '1');
INSERT INTO `pagebranch` VALUES ('10170', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('10171', 'Branch 2', '0', '0');
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
INSERT INTO `pagebranch` VALUES ('11085', 'Branch 1', '0', '1');
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
INSERT INTO `pagebranch` VALUES ('15018', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('15117', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('15229', 'Default Branch', '1', '0');

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
INSERT INTO `pagebranch_branchitem` VALUES ('1788', '666');
INSERT INTO `pagebranch_branchitem` VALUES ('1787', '696');
INSERT INTO `pagebranch_branchitem` VALUES ('1787', '697');
INSERT INTO `pagebranch_branchitem` VALUES ('2079', '6581');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '7552');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '7694');
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
INSERT INTO `pagebranch_branchitem` VALUES ('2991', '8603');
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
INSERT INTO `pagebranch_branchitem` VALUES ('11957', '10377');
INSERT INTO `pagebranch_branchitem` VALUES ('10172', '10496');
INSERT INTO `pagebranch_branchitem` VALUES ('10173', '12358');
INSERT INTO `pagebranch_branchitem` VALUES ('14303', '12786');
INSERT INTO `pagebranch_branchitem` VALUES ('14303', '12787');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '13270');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '13271');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '13272');

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
INSERT INTO `page_branch` VALUES ('586', '1786');
INSERT INTO `page_branch` VALUES ('587', '1787');
INSERT INTO `page_branch` VALUES ('587', '1788');
INSERT INTO `page_branch` VALUES ('709', '2079');
INSERT INTO `page_branch` VALUES ('709', '2080');
INSERT INTO `page_branch` VALUES ('1276', '2874');
INSERT INTO `page_branch` VALUES ('1276', '11085');
INSERT INTO `page_branch` VALUES ('1325', '2991');
INSERT INTO `page_branch` VALUES ('3370', '6320');
INSERT INTO `page_branch` VALUES ('3371', '6254');
INSERT INTO `page_branch` VALUES ('3371', '6257');
INSERT INTO `page_branch` VALUES ('3371', '6321');
INSERT INTO `page_branch` VALUES ('3372', '6255');
INSERT INTO `page_branch` VALUES ('3416', '6317');
INSERT INTO `page_branch` VALUES ('3417', '6318');
INSERT INTO `page_branch` VALUES ('3418', '6319');
INSERT INTO `page_branch` VALUES ('5715', '9803');
INSERT INTO `page_branch` VALUES ('5716', '9804');
INSERT INTO `page_branch` VALUES ('5717', '9805');
INSERT INTO `page_branch` VALUES ('5720', '9808');
INSERT INTO `page_branch` VALUES ('5721', '9809');
INSERT INTO `page_branch` VALUES ('5722', '9810');
INSERT INTO `page_branch` VALUES ('5951', '10169');
INSERT INTO `page_branch` VALUES ('5952', '10170');
INSERT INTO `page_branch` VALUES ('5952', '10171');
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
INSERT INTO `page_branch` VALUES ('9539', '15018');
INSERT INTO `page_branch` VALUES ('9540', '15117');
INSERT INTO `page_branch` VALUES ('9697', '15229');

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
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=14811 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '0', '0', '0', '2363663', '1', '0', '1', null, null, null, null, '1', 'Test Test');
INSERT INTO `question` VALUES ('95', '0', '0', '0', 'Click to edit question title.Click to edit question title.', '4', '0', null, null, null, '3', null, '1', 'Test Test');
INSERT INTO `question` VALUES ('96', '0', '0', '0', 'Click to edit question title.Click to edit question title.Click to edit question title.', '2', '0', null, null, '8', null, null, '0', null);
INSERT INTO `question` VALUES ('118', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('119', '0', '0', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('148', '0', '1', '0', 'What do you think about the following opinion of this company has:', '4', '0', null, null, null, '1', null, '0', null);
INSERT INTO `question` VALUES ('149', '0', '1', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, '5', '2', null, '0', null);
INSERT INTO `question` VALUES ('166', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('171', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('364', '0', '1', '0', 'question 1', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('832', '0', '0', '0', 'Question 2', '2', '0', null, null, '5', null, null, '0', null);
INSERT INTO `question` VALUES ('833', '1', '0', '0', 'Question 3', '3', '0', null, null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('941', '0', '0', '0', 'question 4', '1', '0', '2', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('942', '0', '0', '0', 'Question 5', '1', '0', '3', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('943', '0', '0', '0', 'Question 6', '2', '0', null, null, '7', null, null, '0', null);
INSERT INTO `question` VALUES ('944', '0', '0', '0', 'Question 7', '1', '0', '1', '99/99/9999', null, null, null, '0', null);
INSERT INTO `question` VALUES ('963', '1', '0', '0', 'Question 8', '4', '0', null, null, null, '1', null, '0', null);
INSERT INTO `question` VALUES ('964', '0', '0', '0', 'Question 9', '4', '0', null, null, '3', '2', null, '0', null);
INSERT INTO `question` VALUES ('965', '0', '0', '0', 'Question 10', '4', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('987', '1', '0', '0', 'Question 11', '4', '0', null, null, '7', '3', null, '0', null);
INSERT INTO `question` VALUES ('1297', '0', '0', '1', 'Question 12', '4', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('1298', '1', '0', '1', 'Question 13', '4', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('3232', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '1', 'Test');
INSERT INTO `question` VALUES ('3264', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '1', 'Test');
INSERT INTO `question` VALUES ('3521', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '1', 'Test');
INSERT INTO `question` VALUES ('3568', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '1', 'Test');
INSERT INTO `question` VALUES ('3774', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('3779', '0', '1', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, null, '1', 'Test');
INSERT INTO `question` VALUES ('3780', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null, '1', 'Test');
INSERT INTO `question` VALUES ('4166', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('5181', '0', '1', '0', 'What do you think about the following opinion of this company has:', '4', '0', null, null, '2', '1', null, '1', 'Test');
INSERT INTO `question` VALUES ('5183', '0', '0', '0', 'aaaa', '3', '0', null, null, null, null, null, '1', 'Test');
INSERT INTO `question` VALUES ('7727', '0', '0', '0', '蔡皓宇 rating', '2', '0', null, null, '9', null, null, '1', 'Test');
INSERT INTO `question` VALUES ('7828', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('7971', '0', '0', '0', '1111111131', '4', '0', null, null, '2', '2', null, '1', 'Test');
INSERT INTO `question` VALUES ('8110', '0', '0', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, '5', '3', null, '1', 'Test');
INSERT INTO `question` VALUES ('8824', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null);
INSERT INTO `question` VALUES ('8825', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null);
INSERT INTO `question` VALUES ('8826', '0', '1', '0', 'What are the long term goals of your company?', '1', '0', '1', '99/99/9999', null, null, null, '0', null);
INSERT INTO `question` VALUES ('8827', '0', '1', '0', 'From 1 to 5, please rate your website cross-browser compatible', '2', '0', null, null, '6', null, null, '1', 'Test');
INSERT INTO `question` VALUES ('11498', '1', '1', '1', 'Choice question jump', '3', '0', null, null, null, null, null, '1', 'Test Test');
INSERT INTO `question` VALUES ('11499', '0', '1', '0', 'Choice no jump', '3', '0', null, null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('11500', '0', '0', '0', 'asd', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('11501', '0', '0', '0', 'Matrix rating question', '4', '0', null, null, '8', '2', null, '0', null);
INSERT INTO `question` VALUES ('11594', '0', '0', '0', 'dsdfs', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('11733', '0', '0', '0', 'asd', '1', '0', '1', null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('13574', '0', '0', '1', 'Allow Multiple Answers YES', '3', '0', null, null, null, null, null, '0', null);
INSERT INTO `question` VALUES ('13575', '0', '0', '0', 'Allow Multiple Answers No', '3', '0', null, null, null, '3', null, '0', null);
INSERT INTO `question` VALUES ('13576', '0', '0', '0', 'afff', '4', '0', null, null, '5', '3', null, '0', null);

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
INSERT INTO `question_answer` VALUES ('13574', '7653');
INSERT INTO `question_answer` VALUES ('13574', '7654');
INSERT INTO `question_answer` VALUES ('13574', '7655');
INSERT INTO `question_answer` VALUES ('13574', '7656');
INSERT INTO `question_answer` VALUES ('13575', '7657');
INSERT INTO `question_answer` VALUES ('13575', '7658');
INSERT INTO `question_answer` VALUES ('13575', '7659');
INSERT INTO `question_answer` VALUES ('13575', '7660');
INSERT INTO `question_answer` VALUES ('13575', '7661');
INSERT INTO `question_answer` VALUES ('13575', '7662');
INSERT INTO `question_answer` VALUES ('13575', '7663');
INSERT INTO `question_answer` VALUES ('13575', '7664');
INSERT INTO `question_answer` VALUES ('13575', '7665');

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
INSERT INTO `question_subquestion` VALUES ('7971', '1249');
INSERT INTO `question_subquestion` VALUES ('7971', '1250');
INSERT INTO `question_subquestion` VALUES ('7971', '1251');
INSERT INTO `question_subquestion` VALUES ('7971', '1252');
INSERT INTO `question_subquestion` VALUES ('7971', '1253');
INSERT INTO `question_subquestion` VALUES ('7971', '1254');
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
) ENGINE=InnoDB AUTO_INCREMENT=6174 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `result` VALUES ('3930', '8596', null, null, null, null);
INSERT INTO `result` VALUES ('3931', '8597', null, null, null, null);
INSERT INTO `result` VALUES ('4010', '8595', null, null, null, null);
INSERT INTO `result` VALUES ('4011', '8596', null, null, null, null);
INSERT INTO `result` VALUES ('4012', '8597', null, null, null, null);
INSERT INTO `result` VALUES ('4013', '10377', null, null, null, null);
INSERT INTO `result` VALUES ('4322', null, null, null, '587', null);
INSERT INTO `result` VALUES ('4999', null, null, null, '709', null);
INSERT INTO `result` VALUES ('5098', null, null, null, '587', null);
INSERT INTO `result` VALUES ('5491', null, '5952', '10172', null, null);
INSERT INTO `result` VALUES ('5493', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5494', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5496', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5497', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5498', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5499', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5500', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5501', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('5595', '7694', null, null, null, null);
INSERT INTO `result` VALUES ('5620', null, null, null, '5956', null);
INSERT INTO `result` VALUES ('5736', null, null, null, null, '9536');

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
) ENGINE=InnoDB AUTO_INCREMENT=806 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scenario
-- ----------------------------
INSERT INTO `scenario` VALUES ('11', '11', '11', '11', null, null, null, null);
INSERT INTO `scenario` VALUES ('463', '1282', null, null, null, '4', null, 'if 1 or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('464', '1283', null, null, null, '4', null, 'if 1 or  equal 1 Columnchoices ');
INSERT INTO `scenario` VALUES ('580', '1250', '2', null, null, '3', null, 'if 1 Equal 2');
INSERT INTO `scenario` VALUES ('581', '1251', '2', null, null, '3', null, 'if 1 Equal 2');
INSERT INTO `scenario` VALUES ('582', '1249', '2', null, null, '1', null, 'if 11 Greater than 2');
INSERT INTO `scenario` VALUES ('617', '1282', null, null, null, '4', null, 'if 1 or  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('618', '1283', null, null, null, '4', null, 'if 1 or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('687', '2415', null, null, null, '4', null, 'if ffff or  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('688', '2416', null, null, null, null, null, 'if ffff equal 1 Columnchoices ');
INSERT INTO `scenario` VALUES ('689', '2417', null, null, null, '4', null, 'if ffff or  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('690', '2419', null, null, null, '4', null, 'if fff or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('691', '2420', null, null, null, null, null, 'if ff equal 1 Columnchoices ');
INSERT INTO `scenario` VALUES ('692', '2421', null, null, null, '5', null, 'if fff and  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('693', '2415', null, null, null, '5', null, 'if ffff and  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('694', '2416', null, null, null, '5', null, 'if ffff and  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('695', '2417', null, null, null, '5', null, 'if ffff and  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('696', '2418', null, null, null, '4', null, 'if ffff or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('697', '2419', null, null, null, '4', null, 'if fff or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('698', '2420', null, null, null, '4', null, 'if ff or  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('699', '2418', null, null, null, '4', null, 'if ffff or  equal 3 Columnchoices ');
INSERT INTO `scenario` VALUES ('700', '2419', null, null, null, '5', null, 'if fff and  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('701', '2420', null, null, null, null, null, 'if ff equal 1 Columnchoices ');
INSERT INTO `scenario` VALUES ('702', '2417', null, null, null, '4', null, 'if ffff or  equal 2 Columnchoices ');
INSERT INTO `scenario` VALUES ('703', null, null, '7659', null, null, null, null);
INSERT INTO `scenario` VALUES ('720', null, null, '7654', null, null, null, null);
INSERT INTO `scenario` VALUES ('721', null, null, '7655', null, null, null, null);

-- ----------------------------
-- Table structure for `scenariocc`
-- ----------------------------
DROP TABLE IF EXISTS `scenariocc`;
CREATE TABLE `scenariocc` (
  `scenarioccid` int(11) NOT NULL AUTO_INCREMENT,
  `columnchoiceid` int(11) NOT NULL,
  PRIMARY KEY (`scenarioccid`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scenariocc
-- ----------------------------
INSERT INTO `scenariocc` VALUES ('122', '1414');
INSERT INTO `scenariocc` VALUES ('123', '1414');
INSERT INTO `scenariocc` VALUES ('124', '1415');
INSERT INTO `scenariocc` VALUES ('125', '1414');
INSERT INTO `scenariocc` VALUES ('126', '1415');
INSERT INTO `scenariocc` VALUES ('127', '1414');
INSERT INTO `scenariocc` VALUES ('128', '1415');
INSERT INTO `scenariocc` VALUES ('129', '2507');
INSERT INTO `scenariocc` VALUES ('130', '2509');
INSERT INTO `scenariocc` VALUES ('131', '2511');
INSERT INTO `scenariocc` VALUES ('132', '2511');
INSERT INTO `scenariocc` VALUES ('133', '2508');
INSERT INTO `scenariocc` VALUES ('134', '2509');
INSERT INTO `scenariocc` VALUES ('135', '2511');
INSERT INTO `scenariocc` VALUES ('136', '2509');
INSERT INTO `scenariocc` VALUES ('137', '2510');
INSERT INTO `scenariocc` VALUES ('138', '2509');
INSERT INTO `scenariocc` VALUES ('139', '2509');
INSERT INTO `scenariocc` VALUES ('140', '2510');
INSERT INTO `scenariocc` VALUES ('141', '2508');
INSERT INTO `scenariocc` VALUES ('142', '2509');
INSERT INTO `scenariocc` VALUES ('143', '2510');
INSERT INTO `scenariocc` VALUES ('144', '2508');
INSERT INTO `scenariocc` VALUES ('145', '2510');
INSERT INTO `scenariocc` VALUES ('146', '2508');
INSERT INTO `scenariocc` VALUES ('147', '2509');
INSERT INTO `scenariocc` VALUES ('148', '2510');
INSERT INTO `scenariocc` VALUES ('149', '2509');
INSERT INTO `scenariocc` VALUES ('150', '2510');
INSERT INTO `scenariocc` VALUES ('151', '2509');
INSERT INTO `scenariocc` VALUES ('152', '2509');
INSERT INTO `scenariocc` VALUES ('153', '2510');
INSERT INTO `scenariocc` VALUES ('154', '2511');
INSERT INTO `scenariocc` VALUES ('155', '2507');
INSERT INTO `scenariocc` VALUES ('157', '2510');
INSERT INTO `scenariocc` VALUES ('158', '2508');
INSERT INTO `scenariocc` VALUES ('159', '2508');
INSERT INTO `scenariocc` VALUES ('160', '2508');
INSERT INTO `scenariocc` VALUES ('161', '2509');
INSERT INTO `scenariocc` VALUES ('162', '2511');
INSERT INTO `scenariocc` VALUES ('163', '2509');
INSERT INTO `scenariocc` VALUES ('164', '1416');

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
INSERT INTO `scenario_scenariocc` VALUES ('463', '122');
INSERT INTO `scenario_scenariocc` VALUES ('464', '123');
INSERT INTO `scenario_scenariocc` VALUES ('463', '124');
INSERT INTO `scenario_scenariocc` VALUES ('617', '125');
INSERT INTO `scenario_scenariocc` VALUES ('617', '126');
INSERT INTO `scenario_scenariocc` VALUES ('618', '127');
INSERT INTO `scenario_scenariocc` VALUES ('618', '128');
INSERT INTO `scenario_scenariocc` VALUES ('687', '129');
INSERT INTO `scenario_scenariocc` VALUES ('687', '130');
INSERT INTO `scenario_scenariocc` VALUES ('687', '131');
INSERT INTO `scenario_scenariocc` VALUES ('688', '132');
INSERT INTO `scenario_scenariocc` VALUES ('689', '133');
INSERT INTO `scenario_scenariocc` VALUES ('689', '134');
INSERT INTO `scenario_scenariocc` VALUES ('689', '135');
INSERT INTO `scenario_scenariocc` VALUES ('690', '136');
INSERT INTO `scenario_scenariocc` VALUES ('690', '137');
INSERT INTO `scenario_scenariocc` VALUES ('691', '138');
INSERT INTO `scenario_scenariocc` VALUES ('692', '139');
INSERT INTO `scenario_scenariocc` VALUES ('692', '140');
INSERT INTO `scenario_scenariocc` VALUES ('693', '141');
INSERT INTO `scenario_scenariocc` VALUES ('693', '142');
INSERT INTO `scenario_scenariocc` VALUES ('693', '143');
INSERT INTO `scenario_scenariocc` VALUES ('694', '144');
INSERT INTO `scenario_scenariocc` VALUES ('694', '145');
INSERT INTO `scenario_scenariocc` VALUES ('695', '146');
INSERT INTO `scenario_scenariocc` VALUES ('695', '147');
INSERT INTO `scenario_scenariocc` VALUES ('696', '148');
INSERT INTO `scenario_scenariocc` VALUES ('697', '149');
INSERT INTO `scenario_scenariocc` VALUES ('697', '150');
INSERT INTO `scenario_scenariocc` VALUES ('696', '151');
INSERT INTO `scenario_scenariocc` VALUES ('698', '152');
INSERT INTO `scenario_scenariocc` VALUES ('698', '153');
INSERT INTO `scenario_scenariocc` VALUES ('698', '154');
INSERT INTO `scenario_scenariocc` VALUES ('699', '155');
INSERT INTO `scenario_scenariocc` VALUES ('699', '157');
INSERT INTO `scenario_scenariocc` VALUES ('700', '158');
INSERT INTO `scenario_scenariocc` VALUES ('701', '159');
INSERT INTO `scenario_scenariocc` VALUES ('702', '160');
INSERT INTO `scenario_scenariocc` VALUES ('702', '161');
INSERT INTO `scenario_scenariocc` VALUES ('699', '162');
INSERT INTO `scenario_scenariocc` VALUES ('700', '163');
INSERT INTO `scenario_scenariocc` VALUES ('617', '164');

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
) ENGINE=InnoDB AUTO_INCREMENT=2683 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `subquestion` VALUES ('1249', '1', '11');
INSERT INTO `subquestion` VALUES ('1250', '2', '1');
INSERT INTO `subquestion` VALUES ('1251', '3', '1');
INSERT INTO `subquestion` VALUES ('1252', '4', '1');
INSERT INTO `subquestion` VALUES ('1253', '5', '1');
INSERT INTO `subquestion` VALUES ('1254', '6', '1');
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
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7268 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('358', '0', '0', '0', '2012-10-07', null, 'EN', '', '', '', '', '小蔡使用，不要删', '', '0');
INSERT INTO `survey` VALUES ('411', '0', '0', '0', '2012-10-09', null, 'EN', '', '', 'Test Survey 3', '', 'Test Survey 3', '', '0');
INSERT INTO `survey` VALUES ('457', '0', '0', '0', '2012-10-09', null, 'EN', '', '', '小赵做Preview使用', '', '小赵做Preview使用', '小赵做Preview使用', '0');
INSERT INTO `survey` VALUES ('458', '0', '0', '0', '2012-10-09', null, 'EN', '', '', '', '', '禁止上楼', '', '0');
INSERT INTO `survey` VALUES ('3496', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'asdasdasdasd', '', '0');
INSERT INTO `survey` VALUES ('3497', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxc', '', '0');
INSERT INTO `survey` VALUES ('3498', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxczxc', '', '0');
INSERT INTO `survey` VALUES ('3511', '0', '0', '0', '2012-10-16', null, 'EN', '', '', '', '', 'zxczxc12112', '', '0');
INSERT INTO `survey` VALUES ('3983', '1', '0', '0', '2012-10-17', '2012-09-19 00:00:00', 'EN', '', '123@168.COM', 'ASasASas', 'ASDSADSA', 'asdasd', 'ASDSAD\r\n', '0');
INSERT INTO `survey` VALUES ('4077', '0', '0', '0', '2012-10-17', null, 'EN', '', '', '', '', '333333333', '', '0');
INSERT INTO `survey` VALUES ('4100', '1', '1', '1', '2012-10-17', '2012-10-05 00:00:00', 'EN', 'xc', 'xc@163.com', 'using', 'tks', 'survey1', 'welcome', '0');
INSERT INTO `survey` VALUES ('4132', '0', '0', '0', '2012-10-17', null, 'EN', '', '', '', '', '12333333333312123', '', '0');
INSERT INTO `survey` VALUES ('4916', '0', '0', '0', '2012-10-18', null, 'EN', '', '', '', '', 'qweqwe', '', '0');
INSERT INTO `survey` VALUES ('4917', '0', '0', '0', '2012-10-18', null, 'EN', '', '', '', '', 'qweqweqw', '', '0');
INSERT INTO `survey` VALUES ('5365', '0', '0', '0', '2012-10-19', null, 'EN', '', '', '', '', 'qwe', '', '0');
INSERT INTO `survey` VALUES ('5541', '0', '0', '0', '2012-10-19', null, 'EN', '', '', '', '', 'asdsd', '', '0');
INSERT INTO `survey` VALUES ('5592', '0', '0', '0', '2012-10-23', null, 'EN', '', '', '', '', 'asd', '', '0');
INSERT INTO `survey` VALUES ('5593', '1', '1', '0', '2012-10-23', '2012-10-17 00:00:00', 'EN', 'sdsad', 'asd', 'ASa', 'ASas', 'ASas', 'assd', '0');
INSERT INTO `survey` VALUES ('5594', '1', '1', '1', '2012-10-23', '2012-10-12 00:00:00', 'EN', 'ASA', 'ASA', 'AS', 'AS', 'AS', 'AS', '0');

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
INSERT INTO `survey_page` VALUES ('358', '586');
INSERT INTO `survey_page` VALUES ('358', '587');
INSERT INTO `survey_page` VALUES ('358', '709');
INSERT INTO `survey_page` VALUES ('411', '1276');
INSERT INTO `survey_page` VALUES ('411', '1325');
INSERT INTO `survey_page` VALUES ('458', '3370');
INSERT INTO `survey_page` VALUES ('458', '3371');
INSERT INTO `survey_page` VALUES ('458', '3372');
INSERT INTO `survey_page` VALUES ('458', '3416');
INSERT INTO `survey_page` VALUES ('458', '3417');
INSERT INTO `survey_page` VALUES ('458', '3418');
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
INSERT INTO `survey_page` VALUES ('358', '9539');
INSERT INTO `survey_page` VALUES ('358', '9540');
INSERT INTO `survey_page` VALUES ('457', '9697');

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
