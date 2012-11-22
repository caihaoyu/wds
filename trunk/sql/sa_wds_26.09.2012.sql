/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-09-26 11:18:54
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
) ENGINE=InnoDB AUTO_INCREMENT=853 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('266', '1', 'Existing company');
INSERT INTO `answer` VALUES ('267', '2', 'Start-up company');
INSERT INTO `answer` VALUES ('268', '3', 'Product launch');
INSERT INTO `answer` VALUES ('269', '4', 'Other');
INSERT INTO `answer` VALUES ('270', '1', 'Extremely well');
INSERT INTO `answer` VALUES ('271', '2', 'Very well');
INSERT INTO `answer` VALUES ('272', '3', 'Moderately well');
INSERT INTO `answer` VALUES ('273', '4', 'Slightly well');
INSERT INTO `answer` VALUES ('274', '5', 'Not at all well');
INSERT INTO `answer` VALUES ('275', '1', 'Like a great deal');
INSERT INTO `answer` VALUES ('276', '2', 'Like a moderate amount');
INSERT INTO `answer` VALUES ('277', '3', 'Like a little');
INSERT INTO `answer` VALUES ('278', '4', 'Neither like nor dislike');
INSERT INTO `answer` VALUES ('279', '5', 'Dislike a little');
INSERT INTO `answer` VALUES ('280', '6', 'Dislike a moderate amount');
INSERT INTO `answer` VALUES ('281', '7', 'Dislike a great deal');
INSERT INTO `answer` VALUES ('282', '1', '$0 - $9,999');
INSERT INTO `answer` VALUES ('283', '2', '$10,000 - $19,999');
INSERT INTO `answer` VALUES ('284', '3', '$20,000 - $29,999');
INSERT INTO `answer` VALUES ('285', '4', '$30,000 - $39,999');
INSERT INTO `answer` VALUES ('286', '5', '$40,000 - $59,999');
INSERT INTO `answer` VALUES ('287', '6', '$60,000 - $79,999');
INSERT INTO `answer` VALUES ('288', '7', '$80,000 - $99,999');
INSERT INTO `answer` VALUES ('289', '8', '$100,000 or More');
INSERT INTO `answer` VALUES ('290', '1', 'Doostang');
INSERT INTO `answer` VALUES ('291', '2', 'Fast Pitch!');
INSERT INTO `answer` VALUES ('292', '3', 'JobsByRef');
INSERT INTO `answer` VALUES ('293', '4', 'Jobvite');
INSERT INTO `answer` VALUES ('294', '5', 'LinkedIn');
INSERT INTO `answer` VALUES ('295', '6', 'Realmatch');
INSERT INTO `answer` VALUES ('296', '7', 'Smibsnet');
INSERT INTO `answer` VALUES ('297', '8', 'Talkbiznow');
INSERT INTO `answer` VALUES ('298', '1', 'Always');
INSERT INTO `answer` VALUES ('299', '2', 'Most of the time');
INSERT INTO `answer` VALUES ('300', '3', 'About half the time');
INSERT INTO `answer` VALUES ('301', '4', 'Once in a while');
INSERT INTO `answer` VALUES ('302', '5', 'Never');
INSERT INTO `answer` VALUES ('303', '1', 'Extremely positive');
INSERT INTO `answer` VALUES ('304', '2', 'Moderately positive');
INSERT INTO `answer` VALUES ('305', '3', 'Slightly positive');
INSERT INTO `answer` VALUES ('306', '4', 'Neither positive nor negative');
INSERT INTO `answer` VALUES ('307', '5', 'Slightly negative');
INSERT INTO `answer` VALUES ('308', '6', 'Moderately negative');
INSERT INTO `answer` VALUES ('309', '7', 'Extremely negative');
INSERT INTO `answer` VALUES ('745', '1', 'updatachoice11');
INSERT INTO `answer` VALUES ('746', '2', 'updatachoice12');
INSERT INTO `answer` VALUES ('747', '3', 'updatachoice13');
INSERT INTO `answer` VALUES ('748', '1', 'updatachoice11');
INSERT INTO `answer` VALUES ('749', '2', 'updatachoice12');
INSERT INTO `answer` VALUES ('750', '3', 'updatachoice13');
INSERT INTO `answer` VALUES ('751', '4', 'updatachoice14');
INSERT INTO `answer` VALUES ('752', '5', '');
INSERT INTO `answer` VALUES ('753', '5', '');
INSERT INTO `answer` VALUES ('754', '6', '');
INSERT INTO `answer` VALUES ('755', '5', '');
INSERT INTO `answer` VALUES ('756', '5', '');
INSERT INTO `answer` VALUES ('757', '4', 'updatachoice14');
INSERT INTO `answer` VALUES ('758', '6', '');
INSERT INTO `answer` VALUES ('759', '7', '');
INSERT INTO `answer` VALUES ('760', '5', '');
INSERT INTO `answer` VALUES ('761', '4', '123');
INSERT INTO `answer` VALUES ('762', '6', 'test');
INSERT INTO `answer` VALUES ('824', '7', 'test2');
INSERT INTO `answer` VALUES ('825', '8', 'test34');

-- ----------------------------
-- Table structure for `branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem`;
CREATE TABLE `branchitem` (
  `branchitemid` int(11) NOT NULL AUTO_INCREMENT,
  `hidden` tinyint(1) DEFAULT NULL,
  `itemorder` int(3) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`branchitemid`),
  UNIQUE KEY `branchitem_id` (`branchitemid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=426 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('76', '0', '2', '19');
INSERT INTO `branchitem` VALUES ('77', '0', '1', '292');
INSERT INTO `branchitem` VALUES ('78', '0', '3', '286');
INSERT INTO `branchitem` VALUES ('79', '0', '4', '287');
INSERT INTO `branchitem` VALUES ('80', '0', '5', '288');
INSERT INTO `branchitem` VALUES ('87', '0', '6', '298');
INSERT INTO `branchitem` VALUES ('146', '0', '1', '19');
INSERT INTO `branchitem` VALUES ('147', '0', '1', '287');
INSERT INTO `branchitem` VALUES ('158', '0', '1', '1352');
INSERT INTO `branchitem` VALUES ('159', '0', '1', '298');

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
  KEY `conditionid` (`conditionid`),
  CONSTRAINT `branchitemrule_ibfk_1` FOREIGN KEY (`conditionid`) REFERENCES `condition` (`conditionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=541 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule
-- ----------------------------
INSERT INTO `branchitemrule` VALUES ('378', 'If the user skips this question. Jump to page (160) after page.', '1', '4');

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
INSERT INTO `branchitemrule_result` VALUES ('378', '81');

-- ----------------------------
-- Table structure for `branchitem_branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem_branchitemrule`;
CREATE TABLE `branchitem_branchitemrule` (
  `itemid` int(11) NOT NULL,
  `ruleid` int(11) NOT NULL,
  PRIMARY KEY (`itemid`,`ruleid`),
  KEY `branchitem_branchitemrule_ibfk_2` (`ruleid`),
  CONSTRAINT `branchitem_branchitemrule_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `branchitem_branchitemrule_ibfk_2` FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem_branchitemrule
-- ----------------------------
INSERT INTO `branchitem_branchitemrule` VALUES ('77', '378');

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
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
-- ----------------------------
INSERT INTO `columnchoice` VALUES ('6', '2', 'Column choice 2');
INSERT INTO `columnchoice` VALUES ('7', '3', 'Column choice 3');
INSERT INTO `columnchoice` VALUES ('88', '3', '');
INSERT INTO `columnchoice` VALUES ('92', '4', '');

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

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
) ENGINE=InnoDB AUTO_INCREMENT=437 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('160', '2', 'Basic Of Your Project', '', '');
INSERT INTO `page` VALUES ('161', '2', 'About Your Organization', '', '');
INSERT INTO `page` VALUES ('162', '4', 'Personal Information', '', '');
INSERT INTO `page` VALUES ('228', '1', 'Page One', '', '');
INSERT INTO `page` VALUES ('229', '2', 'Page Two', '', '');
INSERT INTO `page` VALUES ('230', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('233', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('234', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('247', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('278', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('379', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('381', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('385', '4', 'New Page', null, null);

-- ----------------------------
-- Table structure for `pagebranch`
-- ----------------------------
DROP TABLE IF EXISTS `pagebranch`;
CREATE TABLE `pagebranch` (
  `branchid` int(11) NOT NULL AUTO_INCREMENT,
  `branchname` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `main` tinyint(1) NOT NULL,
  PRIMARY KEY (`branchid`),
  UNIQUE KEY `branchid` (`branchid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1370 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('595', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('597', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('598', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('604', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('794', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('795', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('800', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('801', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('806', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('807', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('844', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('926', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('927', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('929', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('930', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1161', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1163', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1178', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1198', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1202', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1203', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1205', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1210', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1211', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1212', 'Branch 4', '0');
INSERT INTO `pagebranch` VALUES ('1214', 'Branch 5', '0');
INSERT INTO `pagebranch` VALUES ('1215', 'Branch 6', '0');
INSERT INTO `pagebranch` VALUES ('1216', 'Branch 7', '0');
INSERT INTO `pagebranch` VALUES ('1219', 'Branch 8', '0');
INSERT INTO `pagebranch` VALUES ('1233', 'Branch 9', '0');
INSERT INTO `pagebranch` VALUES ('1234', 'Branch 9', '0');
INSERT INTO `pagebranch` VALUES ('1235', 'Branch 10', '0');
INSERT INTO `pagebranch` VALUES ('1236', 'Branch 11', '0');
INSERT INTO `pagebranch` VALUES ('1237', 'test', '0');
INSERT INTO `pagebranch` VALUES ('1280', 'Branch 12', '0');
INSERT INTO `pagebranch` VALUES ('1305', 'Branch 13', '0');
INSERT INTO `pagebranch` VALUES ('1356', 'Branch 14', '0');

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
INSERT INTO `pagebranch_branchitem` VALUES ('595', '76');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '77');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '78');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '79');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '80');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '87');
INSERT INTO `pagebranch_branchitem` VALUES ('926', '146');
INSERT INTO `pagebranch_branchitem` VALUES ('927', '147');
INSERT INTO `pagebranch_branchitem` VALUES ('929', '158');
INSERT INTO `pagebranch_branchitem` VALUES ('930', '159');

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
  CONSTRAINT `FKA6609152B1815949` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKA66091528C5AF21E` FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page_branch
-- ----------------------------
INSERT INTO `page_branch` VALUES ('160', '1203');
INSERT INTO `page_branch` VALUES ('161', '1161');
INSERT INTO `page_branch` VALUES ('162', '604');
INSERT INTO `page_branch` VALUES ('162', '1163');
INSERT INTO `page_branch` VALUES ('228', '794');
INSERT INTO `page_branch` VALUES ('229', '795');
INSERT INTO `page_branch` VALUES ('229', '800');
INSERT INTO `page_branch` VALUES ('230', '801');
INSERT INTO `page_branch` VALUES ('233', '806');
INSERT INTO `page_branch` VALUES ('234', '807');
INSERT INTO `page_branch` VALUES ('247', '844');
INSERT INTO `page_branch` VALUES ('278', '929');
INSERT INTO `page_branch` VALUES ('278', '930');
INSERT INTO `page_branch` VALUES ('381', '1198');
INSERT INTO `page_branch` VALUES ('385', '1202');
INSERT INTO `page_branch` VALUES ('385', '1210');
INSERT INTO `page_branch` VALUES ('385', '1211');
INSERT INTO `page_branch` VALUES ('385', '1212');
INSERT INTO `page_branch` VALUES ('385', '1214');
INSERT INTO `page_branch` VALUES ('385', '1215');
INSERT INTO `page_branch` VALUES ('385', '1216');
INSERT INTO `page_branch` VALUES ('385', '1219');
INSERT INTO `page_branch` VALUES ('385', '1234');
INSERT INTO `page_branch` VALUES ('385', '1235');
INSERT INTO `page_branch` VALUES ('385', '1236');
INSERT INTO `page_branch` VALUES ('385', '1280');
INSERT INTO `page_branch` VALUES ('385', '1305');
INSERT INTO `page_branch` VALUES ('385', '1356');

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
  `inuse` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=1883 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('19', '0', '0', '0', 'The website will be used for:', '3', '0', null, null, null, null, '1');
INSERT INTO `question` VALUES ('20', '0', '0', '0', 'Name of your organization', '1', '0', '1', null, null, null, '0');
INSERT INTO `question` VALUES ('284', '0', '0', '0', 'Free text with input mask (Date)', '1', '0', '1', '99/99/9999', null, null, '0');
INSERT INTO `question` VALUES ('285', '0', '0', '0', 'How well do the customer service  representatives at our company  answer your questions ?', '3', '1', null, null, null, null, '0');
INSERT INTO `question` VALUES ('286', '0', '0', '0', 'Do you like our company , neither like nor dislike it, or dislike it?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('287', '0', '0', '0', 'How much money did YOU personally earn in 2010 ? This includes money from jobs; net income from business, farm, or rent; pensions; dividends; interest; social security payments; and any other money income received by YOU. Please report the total amount of money you earned - do not subtract the amount you paid in taxes or any deductions listed on your tax return.', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('288', '0', '0', '1', 'From which of the following professional networking websites does your company  typically find its most qualified job candidates?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('289', '1', '0', '0', 'How often does your company  use professional networking websites  when recruiting job candidates?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('290', '0', '0', '0', 'Is the impact of your coworker  on your work environment positive, neither positive nor negative, or negative?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('1656', '0', '1', '0', 'test1', '1', '0', '1', '99/99/9999', null, null, '0');
INSERT INTO `question` VALUES ('1770', '1', '1', '1', 'updatachoice2', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('1771', '1', '1', '1', 'updatachoice1', '3', '0', null, null, null, null, '0');

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
  CONSTRAINT `FK561DF237ECAA0FE7` FOREIGN KEY (`answerid`) REFERENCES `answer` (`answerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK561DF2372C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question_answer
-- ----------------------------
INSERT INTO `question_answer` VALUES ('19', '266');
INSERT INTO `question_answer` VALUES ('19', '267');
INSERT INTO `question_answer` VALUES ('19', '268');
INSERT INTO `question_answer` VALUES ('285', '270');
INSERT INTO `question_answer` VALUES ('285', '271');
INSERT INTO `question_answer` VALUES ('285', '272');
INSERT INTO `question_answer` VALUES ('285', '273');
INSERT INTO `question_answer` VALUES ('285', '274');
INSERT INTO `question_answer` VALUES ('286', '275');
INSERT INTO `question_answer` VALUES ('286', '276');
INSERT INTO `question_answer` VALUES ('286', '277');
INSERT INTO `question_answer` VALUES ('286', '278');
INSERT INTO `question_answer` VALUES ('286', '279');
INSERT INTO `question_answer` VALUES ('286', '280');
INSERT INTO `question_answer` VALUES ('286', '281');
INSERT INTO `question_answer` VALUES ('287', '282');
INSERT INTO `question_answer` VALUES ('287', '283');
INSERT INTO `question_answer` VALUES ('287', '284');
INSERT INTO `question_answer` VALUES ('287', '285');
INSERT INTO `question_answer` VALUES ('287', '286');
INSERT INTO `question_answer` VALUES ('287', '287');
INSERT INTO `question_answer` VALUES ('287', '288');
INSERT INTO `question_answer` VALUES ('287', '289');
INSERT INTO `question_answer` VALUES ('288', '290');
INSERT INTO `question_answer` VALUES ('288', '291');
INSERT INTO `question_answer` VALUES ('288', '292');
INSERT INTO `question_answer` VALUES ('288', '293');
INSERT INTO `question_answer` VALUES ('288', '294');
INSERT INTO `question_answer` VALUES ('288', '295');
INSERT INTO `question_answer` VALUES ('288', '296');
INSERT INTO `question_answer` VALUES ('288', '297');
INSERT INTO `question_answer` VALUES ('289', '298');
INSERT INTO `question_answer` VALUES ('289', '299');
INSERT INTO `question_answer` VALUES ('289', '300');
INSERT INTO `question_answer` VALUES ('289', '301');
INSERT INTO `question_answer` VALUES ('289', '302');
INSERT INTO `question_answer` VALUES ('290', '303');
INSERT INTO `question_answer` VALUES ('290', '304');
INSERT INTO `question_answer` VALUES ('290', '305');
INSERT INTO `question_answer` VALUES ('290', '306');
INSERT INTO `question_answer` VALUES ('290', '307');
INSERT INTO `question_answer` VALUES ('290', '308');
INSERT INTO `question_answer` VALUES ('290', '309');
INSERT INTO `question_answer` VALUES ('1770', '745');
INSERT INTO `question_answer` VALUES ('1770', '746');
INSERT INTO `question_answer` VALUES ('1770', '747');
INSERT INTO `question_answer` VALUES ('1771', '748');
INSERT INTO `question_answer` VALUES ('1771', '749');
INSERT INTO `question_answer` VALUES ('1771', '750');
INSERT INTO `question_answer` VALUES ('1771', '751');
INSERT INTO `question_answer` VALUES ('1771', '756');
INSERT INTO `question_answer` VALUES ('1770', '757');
INSERT INTO `question_answer` VALUES ('1771', '758');
INSERT INTO `question_answer` VALUES ('1770', '760');
INSERT INTO `question_answer` VALUES ('19', '761');
INSERT INTO `question_answer` VALUES ('285', '762');

-- ----------------------------
-- Table structure for `question_branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `question_branchitem`;
CREATE TABLE `question_branchitem` (
  `questionid` int(11) NOT NULL,
  `branchitemid` int(11) NOT NULL,
  PRIMARY KEY (`branchitemid`),
  KEY `FK6C84CDAE975EFA35` (`branchitemid`),
  KEY `FK6C84CDAE2C582A37` (`questionid`),
  CONSTRAINT `FK6C84CDAE2C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`),
  CONSTRAINT `FK6C84CDAE975EFA35` FOREIGN KEY (`branchitemid`) REFERENCES `branchitem` (`branchitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question_branchitem
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('81', null, null, null, null, '160');

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
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('4', '1', 'sub question 1');
INSERT INTO `subquestion` VALUES ('5', '2', 'sub question 2');
INSERT INTO `subquestion` VALUES ('6', '3', 'sub question 3');
INSERT INTO `subquestion` VALUES ('248', '7', '');
INSERT INTO `subquestion` VALUES ('249', '5', '');
INSERT INTO `subquestion` VALUES ('264', '7', '');
INSERT INTO `subquestion` VALUES ('266', '8', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('5', '1', '1', '1', '2011-11-24', '2011-11-03 00:00:00', 'EN', 'samuel tian', 'sam@satech.com.au', 'Test Survey 1 (Survey description)', 'Test Survey 1 (Survey end text)', 'Clients review', 'Test Survey 1 (Survey welcome text)', '1');
INSERT INTO `survey` VALUES ('6', '1', '1', '1', '2011-11-24', '2011-12-21 11:00:00', 'EN', 'Viona Zuo', 'viona@satech.com.au', 'Test Survey 2(Survey description)', 'Test Survey 2 (Survey end text)', 'Test Survey 2 (Survey title)', 'Test Survey 2(Survey welcome text)', '0');
INSERT INTO `survey` VALUES ('7', '0', '0', '1', '2011-11-24', '2011-11-17 00:00:00', 'CN', 'some1else', 'some1else@satech.com.au', 'Test Survey 3(Survey description)', 'Test Survey 3 (Survey end text)', 'Test Survey 3 (Survey title)', 'Test Survey 3(Survey welcome text)', '0');
INSERT INTO `survey` VALUES ('104', '1', '1', '1', '2012-09-20', '2012-09-13 00:00:00', 'EN', 'ca', 'xsa', 'caf', 'ca', 'caitest', 'ca', '0');
INSERT INTO `survey` VALUES ('179', '1', '0', '1', '2012-09-21', '2012-09-21 00:00:00', 'EN', 'supervisor', 'wuxuehu@qq.com', 'survey description', 'endext', 'survey test title', 'webcometext', '0');

-- ----------------------------
-- Table structure for `survey_page`
-- ----------------------------
DROP TABLE IF EXISTS `survey_page`;
CREATE TABLE `survey_page` (
  `sid` int(11) NOT NULL,
  `pageid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`pageid`),
  KEY `pageid` (`pageid`),
  CONSTRAINT `survey_page_ibfk_2` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `survey_page_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `survey` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey_page
-- ----------------------------
INSERT INTO `survey_page` VALUES ('5', '160');
INSERT INTO `survey_page` VALUES ('5', '161');
INSERT INTO `survey_page` VALUES ('5', '162');
INSERT INTO `survey_page` VALUES ('6', '228');
INSERT INTO `survey_page` VALUES ('6', '229');
INSERT INTO `survey_page` VALUES ('6', '230');
INSERT INTO `survey_page` VALUES ('6', '233');
INSERT INTO `survey_page` VALUES ('6', '234');
INSERT INTO `survey_page` VALUES ('7', '247');
INSERT INTO `survey_page` VALUES ('104', '278');
INSERT INTO `survey_page` VALUES ('5', '385');

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
