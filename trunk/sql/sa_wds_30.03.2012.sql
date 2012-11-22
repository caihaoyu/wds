/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50509
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2012-03-30 00:00:13
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
) ENGINE=InnoDB AUTO_INCREMENT=332 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '1', '0 to $1000');
INSERT INTO `answer` VALUES ('2', '2', '$1000 to $3000');
INSERT INTO `answer` VALUES ('3', '3', '$3000 to $8000');
INSERT INTO `answer` VALUES ('4', '4', '$8000 to $20k');
INSERT INTO `answer` VALUES ('5', '1', 'Search Engine');
INSERT INTO `answer` VALUES ('6', '2', 'Yellow Pages');
INSERT INTO `answer` VALUES ('7', '3', 'Newspaper');
INSERT INTO `answer` VALUES ('8', '4', 'Advertisement');
INSERT INTO `answer` VALUES ('9', '5', 'Friends');
INSERT INTO `answer` VALUES ('10', '1', 'Mostly 75%');
INSERT INTO `answer` VALUES ('11', '2', 'So so 25%');
INSERT INTO `answer` VALUES ('12', '3', 'Medium 50%');
INSERT INTO `answer` VALUES ('13', '4', 'Not at all 0%');
INSERT INTO `answer` VALUES ('14', '5', 'Totally 100%');
INSERT INTO `answer` VALUES ('15', '1', 'Nearly every day');
INSERT INTO `answer` VALUES ('16', '2', '1-2 times per week');
INSERT INTO `answer` VALUES ('17', '3', '3-4 times per week');
INSERT INTO `answer` VALUES ('18', '4', '1-2 times per month');
INSERT INTO `answer` VALUES ('19', '5', '1-5 per year');
INSERT INTO `answer` VALUES ('20', '6', 'For more complex');
INSERT INTO `answer` VALUES ('251', '1', 'E-Commerce Web design and/or related services');
INSERT INTO `answer` VALUES ('252', '2', 'Corporate web design and/or related services');
INSERT INTO `answer` VALUES ('253', '3', 'Institutional web design and/or related services');
INSERT INTO `answer` VALUES ('254', '4', 'Internet Marketing & Search Engine Optiomization');
INSERT INTO `answer` VALUES ('255', '5', 'Other');
INSERT INTO `answer` VALUES ('256', '1', 'Radio Advertisement ');
INSERT INTO `answer` VALUES ('257', '2', 'Google, Bing (Search Engine) Search ');
INSERT INTO `answer` VALUES ('258', '3', 'Webmaster Studio Sales Executive');
INSERT INTO `answer` VALUES ('259', '4', 'Online or printed article ');
INSERT INTO `answer` VALUES ('260', '5', 'Other');
INSERT INTO `answer` VALUES ('261', '1', 'Retail (products for purchase) ');
INSERT INTO `answer` VALUES ('262', '2', 'Payment for services ');
INSERT INTO `answer` VALUES ('263', '3', 'Donations / fund raising ');
INSERT INTO `answer` VALUES ('264', '4', 'Products demostration');
INSERT INTO `answer` VALUES ('265', '5', 'Other industry');
INSERT INTO `answer` VALUES ('266', '1', 'Existing company');
INSERT INTO `answer` VALUES ('267', '2', 'Start-up company');
INSERT INTO `answer` VALUES ('268', '3', 'Product launch');
INSERT INTO `answer` VALUES ('269', '4', 'Other');

-- ----------------------------
-- Table structure for `branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem`;
CREATE TABLE `branchitem` (
  `branchitemid` int(11) NOT NULL AUTO_INCREMENT,
  `questionid` int(11) DEFAULT NULL,
  `hidden` tinyint(1) DEFAULT NULL,
  `itemorder` int(3) DEFAULT NULL,
  PRIMARY KEY (`branchitemid`),
  KEY `branchitem_ibfk_1` (`questionid`),
  CONSTRAINT `branchitem_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=810 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('471', '4', '0', '2');
INSERT INTO `branchitem` VALUES ('472', '5', '1', '1');
INSERT INTO `branchitem` VALUES ('473', '6', '1', '3');
INSERT INTO `branchitem` VALUES ('474', '7', '1', '4');
INSERT INTO `branchitem` VALUES ('475', '15', '0', '5');
INSERT INTO `branchitem` VALUES ('476', '16', '0', '6');
INSERT INTO `branchitem` VALUES ('477', '17', '0', '1');
INSERT INTO `branchitem` VALUES ('702', null, '0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
-- ----------------------------
INSERT INTO `columnchoice` VALUES ('1', '1', 'Somewhat Satisfied');
INSERT INTO `columnchoice` VALUES ('2', '2', 'Satisfied');
INSERT INTO `columnchoice` VALUES ('3', '3', 'Very satisfield');
INSERT INTO `columnchoice` VALUES ('4', '4', 'Dissatisfied');

-- ----------------------------
-- Table structure for `combinedtext`
-- ----------------------------
DROP TABLE IF EXISTS `combinedtext`;
CREATE TABLE `combinedtext` (
  `combineid` int(11) NOT NULL AUTO_INCREMENT,
  `answermask` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `answertype` int(11) DEFAULT NULL,
  `colposition` int(11) DEFAULT NULL,
  `combinetitle` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `rowposition` int(11) DEFAULT NULL,
  PRIMARY KEY (`combineid`),
  UNIQUE KEY `combineid` (`combineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of combinedtext
-- ----------------------------

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('15', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('160', '1', 'Basic Of Your Project', '', '');
INSERT INTO `page` VALUES ('161', '2', 'About Your Organization', '', '');
INSERT INTO `page` VALUES ('162', '3', 'Personal Information', '', '');
INSERT INTO `page` VALUES ('198', '4', 'New Page', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=802 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `pagebranch` VALUES ('738', 'Default Branch', '1');

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
INSERT INTO `pagebranch_branchitem` VALUES ('595', '471');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '472');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '473');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '474');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '475');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '476');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '477');

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
INSERT INTO `page_branch` VALUES ('198', '738');

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
) ENGINE=InnoDB AUTO_INCREMENT=239 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('4', 'N', 'N', 'N', 'Do you have a specific budget range already established for this \nproject?', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('5', 'N', 'N', 'N', 'How did you hear about us?', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('6', 'N', 'N', 'Y', 'Are you satisfied with our customer service?', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('7', 'N', 'N', 'Y', 'How often to go into a restaurant for a meal?', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('8', 'N', 'N', 'N', 'How would you rate your experience with Customer Support?', '4', 'N', null, null, null, '3');
INSERT INTO `question` VALUES ('15', null, 'N', null, 'This is a question and the question title is pretty long enough to dominate three to four lines when displayed in paging and re-ordering page', '1', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('16', 'N', 'Y', 'N', 'Our website design or online marketing project is . . .', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('17', 'N', 'N', 'N', 'I learned about YOUR COMPANY from:', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('18', 'N', 'N', 'N', 'Primary purpose of website:', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('19', 'N', 'N', 'N', 'The website will be used for:', '3', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('20', null, 'N', null, 'Name of your organization', '1', 'N', null, null, null, null);
INSERT INTO `question` VALUES ('165', null, null, null, 'Test free new free text', '1', null, '2', null, null, null);
INSERT INTO `question` VALUES ('238', 'N', 'N', 'N', 'Test new rating question', '2', 'N', null, null, '5', null);

-- ----------------------------
-- Table structure for `questionrule`
-- ----------------------------
DROP TABLE IF EXISTS `questionrule`;
CREATE TABLE `questionrule` (
  `ruleid` int(11) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(200) COLLATE utf8_bin NOT NULL,
  `conditionid` int(11) DEFAULT NULL,
  `ruletype` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ruleid`),
  UNIQUE KEY `ruleid_UNIQUE` (`ruleid`) USING BTREE,
  UNIQUE KEY `condition_conditionid_UNIQUE` (`conditionid`),
  KEY `fk_questionrule_condition1` (`conditionid`),
  CONSTRAINT `fk_questionrule_condition1` FOREIGN KEY (`conditionid`) REFERENCES `condition` (`conditionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of questionrule
-- ----------------------------
INSERT INTO `questionrule` VALUES ('57', 'If the user answers this question. Show one hidden question.', '15', 'SHOW HIDDEN QUESTION');

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
INSERT INTO `questionrule_result` VALUES ('57', '15');

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
INSERT INTO `question_answer` VALUES ('4', '1');
INSERT INTO `question_answer` VALUES ('4', '2');
INSERT INTO `question_answer` VALUES ('4', '3');
INSERT INTO `question_answer` VALUES ('4', '4');
INSERT INTO `question_answer` VALUES ('5', '5');
INSERT INTO `question_answer` VALUES ('5', '6');
INSERT INTO `question_answer` VALUES ('5', '7');
INSERT INTO `question_answer` VALUES ('5', '8');
INSERT INTO `question_answer` VALUES ('5', '9');
INSERT INTO `question_answer` VALUES ('6', '10');
INSERT INTO `question_answer` VALUES ('6', '11');
INSERT INTO `question_answer` VALUES ('6', '12');
INSERT INTO `question_answer` VALUES ('6', '13');
INSERT INTO `question_answer` VALUES ('6', '14');
INSERT INTO `question_answer` VALUES ('7', '15');
INSERT INTO `question_answer` VALUES ('7', '16');
INSERT INTO `question_answer` VALUES ('7', '17');
INSERT INTO `question_answer` VALUES ('7', '18');
INSERT INTO `question_answer` VALUES ('7', '19');
INSERT INTO `question_answer` VALUES ('7', '20');
INSERT INTO `question_answer` VALUES ('16', '251');
INSERT INTO `question_answer` VALUES ('16', '252');
INSERT INTO `question_answer` VALUES ('16', '253');
INSERT INTO `question_answer` VALUES ('16', '254');
INSERT INTO `question_answer` VALUES ('16', '255');
INSERT INTO `question_answer` VALUES ('17', '256');
INSERT INTO `question_answer` VALUES ('17', '257');
INSERT INTO `question_answer` VALUES ('17', '258');
INSERT INTO `question_answer` VALUES ('17', '259');
INSERT INTO `question_answer` VALUES ('17', '260');
INSERT INTO `question_answer` VALUES ('18', '261');
INSERT INTO `question_answer` VALUES ('18', '262');
INSERT INTO `question_answer` VALUES ('18', '263');
INSERT INTO `question_answer` VALUES ('18', '264');
INSERT INTO `question_answer` VALUES ('18', '265');
INSERT INTO `question_answer` VALUES ('19', '266');
INSERT INTO `question_answer` VALUES ('19', '267');
INSERT INTO `question_answer` VALUES ('19', '268');
INSERT INTO `question_answer` VALUES ('19', '269');

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
INSERT INTO `question_columnchoice` VALUES ('8', '1');
INSERT INTO `question_columnchoice` VALUES ('8', '2');
INSERT INTO `question_columnchoice` VALUES ('8', '3');
INSERT INTO `question_columnchoice` VALUES ('8', '4');

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
INSERT INTO `question_questionrule` VALUES ('5', '57');

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
INSERT INTO `question_subquestion` VALUES ('8', '1');
INSERT INTO `question_subquestion` VALUES ('8', '2');
INSERT INTO `question_subquestion` VALUES ('8', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('15', '472', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('1', '1', 'Helpfulness of Representative');
INSERT INTO `subquestion` VALUES ('2', '2', 'Promptness of Response');
INSERT INTO `subquestion` VALUES ('3', '3', 'Quality of Service');

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('5', 'Y', 'Y', 'Y', '2011-11-24', '2011-11-03 11:00:00', 'EN', 'samuel tian', 'sam@satech.com.au', 'Test Survey 1 (Survey description)', 'Test Survey 1 (Survey end text)', 'Clients review', 'Test Survey 1 (Survey welcome text)', null);
INSERT INTO `survey` VALUES ('6', 'Y', 'Y', 'Y', '2011-11-24', '2011-12-21 11:00:00', 'EN', 'Viona Zuo', 'viona@satech.com.au', 'Test Survey 2(Survey description)', 'Test Survey 2 (Survey end text)', 'Test Survey 2 (Survey title)', 'Test Survey 2(Survey welcome text)', null);
INSERT INTO `survey` VALUES ('7', 'N', 'N', 'Y', '2011-11-24', '2011-11-17 11:00:00', 'CN', 'some1else', 'some1else@satech.com.au', 'Test Survey 3(Survey description)', 'Test Survey 3 (Survey end text)', 'Test Survey 3 (Survey title)', 'Test Survey 3(Survey welcome text)', null);

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
INSERT INTO `survey_page` VALUES ('5', '198');

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
