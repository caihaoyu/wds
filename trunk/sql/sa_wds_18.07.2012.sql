/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-07-18 01:13:23
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
) ENGINE=InnoDB AUTO_INCREMENT=394 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `answer` VALUES ('310', '1', 'Extremely professional');
INSERT INTO `answer` VALUES ('311', '2', 'Very professional');
INSERT INTO `answer` VALUES ('312', '3', 'Moderately professional');
INSERT INTO `answer` VALUES ('313', '4', 'Slightly professional');
INSERT INTO `answer` VALUES ('314', '5', 'Not at all professional');
INSERT INTO `answer` VALUES ('315', '1', 'A great deal');
INSERT INTO `answer` VALUES ('316', '2', 'A lot');
INSERT INTO `answer` VALUES ('317', '3', 'A moderate amount');
INSERT INTO `answer` VALUES ('318', '4', 'A few');
INSERT INTO `answer` VALUES ('319', '5', 'None at all');
INSERT INTO `answer` VALUES ('320', '1', 'A great deal');
INSERT INTO `answer` VALUES ('321', '2', 'A lot');
INSERT INTO `answer` VALUES ('322', '3', 'A moderate amount');
INSERT INTO `answer` VALUES ('323', '4', 'A few');
INSERT INTO `answer` VALUES ('324', '5', 'None at all');
INSERT INTO `answer` VALUES ('325', '1', 'Much too much');
INSERT INTO `answer` VALUES ('326', '2', 'Somewhat too much');
INSERT INTO `answer` VALUES ('327', '3', 'Slightly too much');
INSERT INTO `answer` VALUES ('328', '4', 'About the right amount');
INSERT INTO `answer` VALUES ('329', '5', 'Slightly too little');
INSERT INTO `answer` VALUES ('330', '6', 'Somewhat too little');
INSERT INTO `answer` VALUES ('331', '7', 'Much too little');
INSERT INTO `answer` VALUES ('332', '1', 'Extremely often');
INSERT INTO `answer` VALUES ('333', '2', 'Very often');
INSERT INTO `answer` VALUES ('334', '3', 'Moderately often');
INSERT INTO `answer` VALUES ('335', '4', 'Slightly often');
INSERT INTO `answer` VALUES ('336', '5', 'Not at all often');
INSERT INTO `answer` VALUES ('337', '1', 'Much too much');
INSERT INTO `answer` VALUES ('338', '2', 'Somewhat too much');
INSERT INTO `answer` VALUES ('339', '3', 'Slightly too much');
INSERT INTO `answer` VALUES ('340', '4', 'About the right amount');
INSERT INTO `answer` VALUES ('341', '5', 'Slightly too little');
INSERT INTO `answer` VALUES ('342', '6', 'Somewhat too little');
INSERT INTO `answer` VALUES ('343', '7', 'Much too little');

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
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('76', '0', '1', '19');
INSERT INTO `branchitem` VALUES ('77', '0', '2', '292');
INSERT INTO `branchitem` VALUES ('78', '0', '3', '286');
INSERT INTO `branchitem` VALUES ('79', '0', '4', '287');
INSERT INTO `branchitem` VALUES ('80', '0', '5', '288');
INSERT INTO `branchitem` VALUES ('81', '0', '1', '289');
INSERT INTO `branchitem` VALUES ('82', '0', '2', '290');
INSERT INTO `branchitem` VALUES ('83', '0', '3', '291');
INSERT INTO `branchitem` VALUES ('84', '0', '4', '292');
INSERT INTO `branchitem` VALUES ('85', '0', '5', '294');
INSERT INTO `branchitem` VALUES ('86', '0', '1', '296');
INSERT INTO `branchitem` VALUES ('87', '0', '6', '298');
INSERT INTO `branchitem` VALUES ('88', '0', '2', '299');
INSERT INTO `branchitem` VALUES ('89', '0', '3', '300');
INSERT INTO `branchitem` VALUES ('90', '0', '4', '301');
INSERT INTO `branchitem` VALUES ('91', '0', '5', '305');
INSERT INTO `branchitem` VALUES ('92', '0', '6', '306');
INSERT INTO `branchitem` VALUES ('93', '0', '6', '302');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
-- ----------------------------
INSERT INTO `columnchoice` VALUES ('6', '2', 'Column choice 2');
INSERT INTO `columnchoice` VALUES ('7', '3', 'Column choice 3');
INSERT INTO `columnchoice` VALUES ('8', '1', 'Extremely Important');
INSERT INTO `columnchoice` VALUES ('9', '2', 'Very Important');
INSERT INTO `columnchoice` VALUES ('10', '3', 'Somewhat Important');
INSERT INTO `columnchoice` VALUES ('11', '4', 'Slightly Important');
INSERT INTO `columnchoice` VALUES ('12', '5', 'Not Important at All');

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

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
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('160', '2', 'Basic Of Your Project', '', '');
INSERT INTO `page` VALUES ('161', '1', 'About Your Organization', '', '');
INSERT INTO `page` VALUES ('162', '3', 'Personal Information', '', '');
INSERT INTO `page` VALUES ('228', '1', 'Page One', '', '');
INSERT INTO `page` VALUES ('229', '2', 'Page Two', '', '');
INSERT INTO `page` VALUES ('230', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('233', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('234', '5', 'New Page', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=833 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `pagebranch_branchitem` VALUES ('597', '81');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '82');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '83');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '84');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '85');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '86');
INSERT INTO `pagebranch_branchitem` VALUES ('595', '87');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '88');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '89');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '90');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '91');
INSERT INTO `pagebranch_branchitem` VALUES ('604', '92');
INSERT INTO `pagebranch_branchitem` VALUES ('597', '93');

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
INSERT INTO `page_branch` VALUES ('161', '597');
INSERT INTO `page_branch` VALUES ('161', '598');
INSERT INTO `page_branch` VALUES ('162', '604');
INSERT INTO `page_branch` VALUES ('228', '794');
INSERT INTO `page_branch` VALUES ('229', '795');
INSERT INTO `page_branch` VALUES ('229', '800');
INSERT INTO `page_branch` VALUES ('230', '801');
INSERT INTO `page_branch` VALUES ('233', '806');
INSERT INTO `page_branch` VALUES ('234', '807');

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
  `inuse` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=352 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('19', 'N', 'N', 'N', 'The website will be used for:', '3', 'N', null, null, null, null, '1');
INSERT INTO `question` VALUES ('20', null, 'N', null, 'Name of your organization', '1', 'N', '1', null, null, null, '0');
INSERT INTO `question` VALUES ('284', 'N', 'N', 'N', 'Free text with input mask (Date)', '1', null, '1', '99/99/9999', null, null, '0');
INSERT INTO `question` VALUES ('285', 'N', 'N', 'N', 'How well do the customer service  representatives at our company  answer your questions ?', '3', null, null, null, null, null, '0');
INSERT INTO `question` VALUES ('286', 'N', 'N', 'N', 'Do you like our company , neither like nor dislike it, or dislike it?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('287', 'N', 'N', 'N', 'How much money did YOU personally earn in 2010 ? This includes money from jobs; net income from business, farm, or rent; pensions; dividends; interest; social security payments; and any other money income received by YOU. Please report the total amount of money you earned - do not subtract the amount you paid in taxes or any deductions listed on your tax return.', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('288', 'N', 'N', 'Y', 'From which of the following professional networking websites does your company  typically find its most qualified job candidates?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('289', 'N', 'N', 'N', 'How often does your company  use professional networking websites  when recruiting job candidates?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('290', 'N', 'N', 'N', 'Is the impact of your coworker  on your work environment positive, neither positive nor negative, or negative?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('291', 'N', 'N', 'N', 'How professional is your coworker ?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('292', 'N', 'N', 'N', 'How many rules do you have to follow at work?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('293', 'N', 'N', 'N', 'How much training have you received for your job?', '3', null, null, null, null, null, '0');
INSERT INTO `question` VALUES ('294', 'N', 'N', 'N', 'What does your supervisor  need to do to improve his/her  performance?', '1', null, '2', null, null, null, '1');
INSERT INTO `question` VALUES ('295', 'N', 'N', 'N', 'What does management need to do to improve their overall effectiveness ?', '1', null, '2', null, null, null, '0');
INSERT INTO `question` VALUES ('296', 'N', 'N', 'N', 'What could you do to increase your productivity at work?', '1', null, '2', null, null, null, '1');
INSERT INTO `question` VALUES ('297', 'N', 'N', 'N', 'Are you supervised too much at work, supervised too little, or supervised about the right amount?', '3', null, null, null, null, null, '0');
INSERT INTO `question` VALUES ('298', 'N', 'N', 'N', 'How often do you work with other employees at the company?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('299', 'N', 'N', 'N', 'Does your job require you to do too much work, too little work, or about the right amount of work?', '3', null, null, null, null, null, '1');
INSERT INTO `question` VALUES ('300', 'N', 'N', 'N', 'Please rate from 1 to 5 how much do your opinions about work matter to your coworkers ?', '2', null, null, null, '8', null, '1');
INSERT INTO `question` VALUES ('301', 'N', 'N', 'N', 'Please rate from 1 to 5, how well do your coworkers  work with other employees ?', '2', null, null, null, '5', null, '1');
INSERT INTO `question` VALUES ('302', 'N', 'N', 'N', 'Please rate from 1 to 10, how clear are the goals management sets for the company?', '2', null, null, null, '10', null, '1');
INSERT INTO `question` VALUES ('303', 'N', 'N', 'N', 'Please rate from 1 to 10, How well does management  handle employee problems? (the more stars the better)', '2', null, null, null, '10', null, '0');
INSERT INTO `question` VALUES ('304', 'N', 'N', 'N', 'Please rate from 1 to 5, how easy is it to navigate our website ? (the more stars the better)', '2', null, null, null, '5', null, '0');
INSERT INTO `question` VALUES ('305', 'N', 'N', 'N', 'The following qualities are important in my supervisor:', '4', null, null, null, null, '3', '1');
INSERT INTO `question` VALUES ('306', 'N', 'N', 'N', 'Which benefits are important to you? Please rate the following from 1-5 where 1 is Not at all Important and 5 is Extremely Important:', '4', null, null, null, null, '2', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of questionrule
-- ----------------------------

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
INSERT INTO `question_answer` VALUES ('19', '266');
INSERT INTO `question_answer` VALUES ('19', '267');
INSERT INTO `question_answer` VALUES ('19', '268');
INSERT INTO `question_answer` VALUES ('19', '269');
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
INSERT INTO `question_answer` VALUES ('291', '310');
INSERT INTO `question_answer` VALUES ('291', '311');
INSERT INTO `question_answer` VALUES ('291', '312');
INSERT INTO `question_answer` VALUES ('291', '313');
INSERT INTO `question_answer` VALUES ('291', '314');
INSERT INTO `question_answer` VALUES ('292', '315');
INSERT INTO `question_answer` VALUES ('292', '316');
INSERT INTO `question_answer` VALUES ('292', '317');
INSERT INTO `question_answer` VALUES ('292', '318');
INSERT INTO `question_answer` VALUES ('292', '319');
INSERT INTO `question_answer` VALUES ('293', '320');
INSERT INTO `question_answer` VALUES ('293', '321');
INSERT INTO `question_answer` VALUES ('293', '322');
INSERT INTO `question_answer` VALUES ('293', '323');
INSERT INTO `question_answer` VALUES ('293', '324');
INSERT INTO `question_answer` VALUES ('297', '325');
INSERT INTO `question_answer` VALUES ('297', '326');
INSERT INTO `question_answer` VALUES ('297', '327');
INSERT INTO `question_answer` VALUES ('297', '328');
INSERT INTO `question_answer` VALUES ('297', '329');
INSERT INTO `question_answer` VALUES ('297', '330');
INSERT INTO `question_answer` VALUES ('297', '331');
INSERT INTO `question_answer` VALUES ('298', '332');
INSERT INTO `question_answer` VALUES ('298', '333');
INSERT INTO `question_answer` VALUES ('298', '334');
INSERT INTO `question_answer` VALUES ('298', '335');
INSERT INTO `question_answer` VALUES ('298', '336');
INSERT INTO `question_answer` VALUES ('299', '337');
INSERT INTO `question_answer` VALUES ('299', '338');
INSERT INTO `question_answer` VALUES ('299', '339');
INSERT INTO `question_answer` VALUES ('299', '340');
INSERT INTO `question_answer` VALUES ('299', '341');
INSERT INTO `question_answer` VALUES ('299', '342');
INSERT INTO `question_answer` VALUES ('299', '343');

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
INSERT INTO `question_columnchoice` VALUES ('305', '8');
INSERT INTO `question_columnchoice` VALUES ('305', '9');
INSERT INTO `question_columnchoice` VALUES ('305', '10');
INSERT INTO `question_columnchoice` VALUES ('305', '11');
INSERT INTO `question_columnchoice` VALUES ('305', '12');

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
INSERT INTO `question_subquestion` VALUES ('305', '7');
INSERT INTO `question_subquestion` VALUES ('305', '8');
INSERT INTO `question_subquestion` VALUES ('305', '9');
INSERT INTO `question_subquestion` VALUES ('305', '10');
INSERT INTO `question_subquestion` VALUES ('305', '11');
INSERT INTO `question_subquestion` VALUES ('306', '12');
INSERT INTO `question_subquestion` VALUES ('306', '13');
INSERT INTO `question_subquestion` VALUES ('306', '14');
INSERT INTO `question_subquestion` VALUES ('306', '15');
INSERT INTO `question_subquestion` VALUES ('306', '16');

-- ----------------------------
-- Table structure for `reponse_entry`
-- ----------------------------
DROP TABLE IF EXISTS `reponse_entry`;
CREATE TABLE `reponse_entry` (
  `entryid` int(11) NOT NULL,
  `responseid` int(11) NOT NULL,
  KEY `entryid` (`entryid`) USING BTREE,
  KEY `responseid` (`responseid`) USING BTREE,
  CONSTRAINT `reponse_entry_ibfk_2` FOREIGN KEY (`responseid`) REFERENCES `response` (`responseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reponse_entry_ibfk_1` FOREIGN KEY (`entryid`) REFERENCES `entry` (`entryid`) ON DELETE CASCADE ON UPDATE CASCADE
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('4', '1', 'sub question 1');
INSERT INTO `subquestion` VALUES ('5', '2', 'sub question 2');
INSERT INTO `subquestion` VALUES ('6', '3', 'sub question 3');
INSERT INTO `subquestion` VALUES ('7', '1', 'APPROACHABLE');
INSERT INTO `subquestion` VALUES ('8', '2', 'QUALIFIED');
INSERT INTO `subquestion` VALUES ('9', '3', 'HONEST');
INSERT INTO `subquestion` VALUES ('10', '4', 'BELIEVABLE');
INSERT INTO `subquestion` VALUES ('11', '5', 'SUCCESSFUL');
INSERT INTO `subquestion` VALUES ('12', '1', 'Vision Care');
INSERT INTO `subquestion` VALUES ('13', '2', 'Dental Care');
INSERT INTO `subquestion` VALUES ('14', '3', 'Medical Care');
INSERT INTO `subquestion` VALUES ('15', '4', 'Vacation Time');
INSERT INTO `subquestion` VALUES ('16', '5', '401K/Retirement Plan');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `survey_page` VALUES ('6', '230');
INSERT INTO `survey_page` VALUES ('6', '233');
INSERT INTO `survey_page` VALUES ('6', '234');

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
