/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50509
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2012-04-20 01:03:04
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
) ENGINE=InnoDB AUTO_INCREMENT=364 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('261', '1', 'Retail (products for purchase) ');
INSERT INTO `answer` VALUES ('262', '2', 'Payment for services ');
INSERT INTO `answer` VALUES ('263', '3', 'Donations / fund raising ');
INSERT INTO `answer` VALUES ('264', '4', 'Products demostration');
INSERT INTO `answer` VALUES ('265', '5', 'Other industry');
INSERT INTO `answer` VALUES ('266', '1', 'Existing company');
INSERT INTO `answer` VALUES ('267', '2', 'Start-up company');
INSERT INTO `answer` VALUES ('268', '3', 'Product launch');
INSERT INTO `answer` VALUES ('269', '4', 'Other');
INSERT INTO `answer` VALUES ('327', '1', 'aaa111');
INSERT INTO `answer` VALUES ('328', '2', 'bbb');
INSERT INTO `answer` VALUES ('329', '3', 'cvcc');

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
  UNIQUE KEY `branchitem_id` (`branchitemid`) USING BTREE,
  UNIQUE KEY `questionid` (`questionid`),
  KEY `FK50B0FFB52C582A37` (`questionid`),
  CONSTRAINT `FK50B0FFB52C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('17', '1', '1', null);
INSERT INTO `branchitem` VALUES ('18', '1', '3', null);
INSERT INTO `branchitem` VALUES ('19', '1', '2', null);
INSERT INTO `branchitem` VALUES ('34', '0', '4', null);
INSERT INTO `branchitem` VALUES ('37', '0', '5', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
-- ----------------------------
INSERT INTO `columnchoice` VALUES ('5', '1', 'Column choice 1');
INSERT INTO `columnchoice` VALUES ('6', '2', 'Column choice 2');
INSERT INTO `columnchoice` VALUES ('7', '3', 'Column choice 3');
INSERT INTO `columnchoice` VALUES ('8', '2', 'asdasd');

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('8', '0');
INSERT INTO `condition` VALUES ('9', '1');
INSERT INTO `condition` VALUES ('17', '1');
INSERT INTO `condition` VALUES ('18', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('160', '1', 'Basic Of Your Project', '', '');
INSERT INTO `page` VALUES ('161', '2', 'About Your Organization', '', '');
INSERT INTO `page` VALUES ('162', '3', 'Personal Information', '', '');
INSERT INTO `page` VALUES ('228', '1', 'Page One', '', '');
INSERT INTO `page` VALUES ('229', '2', 'Page Two', '', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=837 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('595', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('597', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('598', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('601', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('602', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('603', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('604', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('794', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('795', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('800', 'Branch 2', '0');

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
INSERT INTO `pagebranch_branchitem` VALUES ('794', '17');
INSERT INTO `pagebranch_branchitem` VALUES ('794', '18');
INSERT INTO `pagebranch_branchitem` VALUES ('794', '19');
INSERT INTO `pagebranch_branchitem` VALUES ('794', '34');
INSERT INTO `pagebranch_branchitem` VALUES ('794', '37');

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
  CONSTRAINT `FKA66091528C5AF21E` FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`),
  CONSTRAINT `FKA6609152B1815949` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page_branch
-- ----------------------------
INSERT INTO `page_branch` VALUES ('160', '595');
INSERT INTO `page_branch` VALUES ('160', '601');
INSERT INTO `page_branch` VALUES ('160', '602');
INSERT INTO `page_branch` VALUES ('161', '597');
INSERT INTO `page_branch` VALUES ('161', '598');
INSERT INTO `page_branch` VALUES ('161', '603');
INSERT INTO `page_branch` VALUES ('162', '604');
INSERT INTO `page_branch` VALUES ('228', '794');
INSERT INTO `page_branch` VALUES ('229', '795');
INSERT INTO `page_branch` VALUES ('229', '800');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `allowcustomized` char(1) COLLATE utf8_bin DEFAULT NULL,
  `allowdescription` char(1) COLLATE utf8_bin DEFAULT NULL,
  `allowmultipile` char(1) COLLATE utf8_bin DEFAULT NULL,
  `questiontitle` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `questiontype` int(10) NOT NULL,
  `wysiwyg` char(1) COLLATE utf8_bin DEFAULT NULL,
  `answertype` int(10) DEFAULT NULL,
  `answermask` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `rating` double(20,0) DEFAULT NULL,
  `columntype` int(10) DEFAULT NULL,
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('18', 'N', 'N', 'N', 'Primary purpose of website:', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('19', 'N', 'N', 'N', 'The website will be used for:', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('20', null, 'N', null, 'Name of your organization', '1', 'N', '1', '', null, null);
INSERT INTO `question` VALUES ('284', 'N', 'N', 'N', 'Free text with input mask (Date)', '1', null, '1', '99/99/9999', null, null);
INSERT INTO `question` VALUES ('288', 'N', 'N', 'N', 'Matrix with sub questions and column choices', '4', null, null, null, null, '3');
INSERT INTO `question` VALUES ('325', 'N', 'N', 'N', 'Test choice', '3', null, null, null, null, null);

-- ----------------------------
-- Table structure for `questionrule`
-- ----------------------------
DROP TABLE IF EXISTS `questionrule`;
CREATE TABLE `questionrule` (
  `ruleid` int(11) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(200) COLLATE utf8_bin NOT NULL,
  `conditionid` int(11) DEFAULT NULL,
  `ruletype` int(11) NOT NULL,
  PRIMARY KEY (`ruleid`),
  UNIQUE KEY `ruleid_UNIQUE` (`ruleid`) USING BTREE,
  UNIQUE KEY `condition_conditionid_UNIQUE` (`conditionid`),
  KEY `fk_questionrule_condition1` (`conditionid`),
  CONSTRAINT `fk_questionrule_condition1` FOREIGN KEY (`conditionid`) REFERENCES `condition` (`conditionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of questionrule
-- ----------------------------
INSERT INTO `questionrule` VALUES ('18', 'If the user answers this question. Show one hidden question.', '8', '1');
INSERT INTO `questionrule` VALUES ('19', 'If the user skips this question. Temporarily set pagebranch (794) of page (228) as default.', '9', '2');
INSERT INTO `questionrule` VALUES ('45', 'If the user skips this question. Jump to page (228) immediately.', '17', '3');
INSERT INTO `questionrule` VALUES ('46', 'If the user answers this question. Jump to page (228) after page.', '18', '4');

-- ----------------------------
-- Table structure for `questionrule_result`
-- ----------------------------
DROP TABLE IF EXISTS `questionrule_result`;
CREATE TABLE `questionrule_result` (
  `ruleid` int(11) NOT NULL,
  `resultid` int(11) NOT NULL,
  PRIMARY KEY (`resultid`),
  KEY `ruleid_index` (`ruleid`) USING BTREE,
  KEY `resultid_index` (`resultid`) USING BTREE,
  CONSTRAINT `questionrule_result_ibfk_1` FOREIGN KEY (`ruleid`) REFERENCES `questionrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `questionrule_result_ibfk_2` FOREIGN KEY (`resultid`) REFERENCES `result` (`resultid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of questionrule_result
-- ----------------------------
INSERT INTO `questionrule_result` VALUES ('18', '8');
INSERT INTO `questionrule_result` VALUES ('19', '9');
INSERT INTO `questionrule_result` VALUES ('45', '17');
INSERT INTO `questionrule_result` VALUES ('46', '18');

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
  CONSTRAINT `FK561DF2372C582A37` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`),
  CONSTRAINT `FK561DF237ECAA0FE7` FOREIGN KEY (`answerid`) REFERENCES `answer` (`answerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question_answer
-- ----------------------------
INSERT INTO `question_answer` VALUES ('18', '261');
INSERT INTO `question_answer` VALUES ('18', '262');
INSERT INTO `question_answer` VALUES ('18', '263');
INSERT INTO `question_answer` VALUES ('18', '264');
INSERT INTO `question_answer` VALUES ('18', '265');
INSERT INTO `question_answer` VALUES ('19', '266');
INSERT INTO `question_answer` VALUES ('19', '267');
INSERT INTO `question_answer` VALUES ('19', '268');
INSERT INTO `question_answer` VALUES ('19', '269');
INSERT INTO `question_answer` VALUES ('325', '327');
INSERT INTO `question_answer` VALUES ('325', '328');
INSERT INTO `question_answer` VALUES ('325', '329');

-- ----------------------------
-- Table structure for `question_branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `question_branchitem`;
CREATE TABLE `question_branchitem` (
  `questionid` int(11) NOT NULL DEFAULT '0',
  `branchitemid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`questionid`,`branchitemid`),
  UNIQUE KEY `branchitemid` (`branchitemid`) USING BTREE,
  UNIQUE KEY `questionid` (`questionid`) USING BTREE,
  CONSTRAINT `question_branchitem_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_branchitem_ibfk_2` FOREIGN KEY (`branchitemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question_branchitem
-- ----------------------------
INSERT INTO `question_branchitem` VALUES ('18', '17');
INSERT INTO `question_branchitem` VALUES ('19', '18');
INSERT INTO `question_branchitem` VALUES ('20', '19');
INSERT INTO `question_branchitem` VALUES ('284', '34');
INSERT INTO `question_branchitem` VALUES ('288', '37');

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
INSERT INTO `question_columnchoice` VALUES ('288', '5');
INSERT INTO `question_columnchoice` VALUES ('288', '8');

-- ----------------------------
-- Table structure for `question_questionrule`
-- ----------------------------
DROP TABLE IF EXISTS `question_questionrule`;
CREATE TABLE `question_questionrule` (
  `questionid` int(11) NOT NULL,
  `ruleid` int(11) NOT NULL,
  PRIMARY KEY (`questionid`,`ruleid`),
  KEY `fk_question_questionrule_question1` (`questionid`),
  KEY `fk_question_questionrule_questionrule1` (`ruleid`),
  CONSTRAINT `fk_question_questionrule_question1` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_questionrule_questionrule1` FOREIGN KEY (`ruleid`) REFERENCES `questionrule` (`ruleid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question_questionrule
-- ----------------------------
INSERT INTO `question_questionrule` VALUES ('18', '19');
INSERT INTO `question_questionrule` VALUES ('19', '18');
INSERT INTO `question_questionrule` VALUES ('19', '45');
INSERT INTO `question_questionrule` VALUES ('19', '46');

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
INSERT INTO `question_subquestion` VALUES ('288', '7');
INSERT INTO `question_subquestion` VALUES ('288', '8');
INSERT INTO `question_subquestion` VALUES ('288', '9');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('8', '17', null, null, null, null);
INSERT INTO `result` VALUES ('9', null, '228', '794', null, null);
INSERT INTO `result` VALUES ('17', null, null, null, '228', null);
INSERT INTO `result` VALUES ('18', null, null, null, null, '228');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('4', '1', 'sub question 1');
INSERT INTO `subquestion` VALUES ('5', '2', 'sub question 2');
INSERT INTO `subquestion` VALUES ('6', '3', 'sub question 3');
INSERT INTO `subquestion` VALUES ('7', '1', 'asdasd');
INSERT INTO `subquestion` VALUES ('8', '2', 'asdasda');
INSERT INTO `subquestion` VALUES ('9', '3', 'asdads');

-- ----------------------------
-- Table structure for `survey`
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) COLLATE utf8_bin DEFAULT NULL,
  `allowsave` char(1) COLLATE utf8_bin DEFAULT NULL,
  `attributedescriptions` char(1) COLLATE utf8_bin DEFAULT NULL,
  `datecreated` date DEFAULT NULL,
  `expires` datetime DEFAULT NULL,
  `language` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `supervisor` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `supervisoremail` varchar(320) COLLATE utf8_bin DEFAULT NULL,
  `surveydescription` varchar(650) COLLATE utf8_bin DEFAULT NULL,
  `surveyendtext` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `surveytitle` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `surveywelcometext` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `usecookie` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('5', 'Y', 'Y', 'Y', '2011-11-24', '2011-11-03 00:00:00', 'EN', 'samuel tian', 'sam@satech.com.au', 'Test Survey 1 (Survey description)', 'Test Survey 1 (Survey end text)', 'Clients review', 'Test Survey 1 (Survey welcome text)', null);
INSERT INTO `survey` VALUES ('6', 'Y', 'Y', 'Y', '2011-11-24', '2011-12-21 11:00:00', 'EN', 'Viona Zuo', 'viona@satech.com.au', 'Test Survey 2(Survey description)', 'Test Survey 2 (Survey end text)', 'Test Survey 2 (Survey title)', 'Test Survey 2(Survey welcome text)', null);
INSERT INTO `survey` VALUES ('7', 'N', 'N', 'Y', '2011-11-24', '2011-11-17 00:00:00', 'CN', 'some1else', 'some1else@satech.com.au', 'Test Survey 3(Survey description)', 'Test Survey 3 (Survey end text)', 'Test Survey 3 (Survey title)', 'Test Survey 3(Survey welcome text)', null);

-- ----------------------------
-- Table structure for `survey_page`
-- ----------------------------
DROP TABLE IF EXISTS `survey_page`;
CREATE TABLE `survey_page` (
  `sid` int(11) NOT NULL,
  `pageid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`pageid`),
  KEY `pageid` (`pageid`),
  CONSTRAINT `survey_page_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `survey` (`sid`),
  CONSTRAINT `survey_page_ibfk_2` FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey_page
-- ----------------------------
INSERT INTO `survey_page` VALUES ('5', '160');
INSERT INTO `survey_page` VALUES ('5', '161');
INSERT INTO `survey_page` VALUES ('5', '162');
INSERT INTO `survey_page` VALUES ('6', '228');
INSERT INTO `survey_page` VALUES ('6', '229');

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
