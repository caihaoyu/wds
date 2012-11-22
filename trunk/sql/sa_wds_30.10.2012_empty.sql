/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-10-30 18:29:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
`answerid`  int(11) NOT NULL AUTO_INCREMENT ,
`answerorder`  int(11) NULL DEFAULT NULL ,
`answertitle`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
PRIMARY KEY (`answerid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=11661

;

-- ----------------------------
-- Table structure for `assumption`
-- ----------------------------
DROP TABLE IF EXISTS `assumption`;
CREATE TABLE `assumption` (
`conditionid`  int(11) NOT NULL AUTO_INCREMENT ,
`skips`  tinyint(1) NULL DEFAULT NULL ,
`conditiontype`  int(11) NOT NULL DEFAULT 1 ,
`comparator`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`conditionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=14217

;

-- ----------------------------
-- Table structure for `branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem`;
CREATE TABLE `branchitem` (
`branchitemid`  int(11) NOT NULL AUTO_INCREMENT ,
`hidden`  tinyint(1) NULL DEFAULT NULL ,
`itemorder`  int(3) NULL DEFAULT NULL ,
`questionid`  int(11) NULL DEFAULT NULL ,
`responseColumnchoiceIds`  tinyblob NULL ,
`mandatory`  tinyint(1) NULL DEFAULT NULL ,
PRIMARY KEY (`branchitemid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=20453

;

-- ----------------------------
-- Table structure for `branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitemrule`;
CREATE TABLE `branchitemrule` (
`ruleid`  int(11) NOT NULL AUTO_INCREMENT ,
`rulename`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`conditionid`  int(11) NULL DEFAULT NULL ,
`ruletype`  int(11) NOT NULL ,
PRIMARY KEY (`ruleid`),
FOREIGN KEY (`conditionid`) REFERENCES `assumption` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=9213

;

-- ----------------------------
-- Table structure for `branchitemrule_result`
-- ----------------------------
DROP TABLE IF EXISTS `branchitemrule_result`;
CREATE TABLE `branchitemrule_result` (
`ruleid`  int(11) NOT NULL ,
`resultid`  int(11) NOT NULL ,
PRIMARY KEY (`ruleid`, `resultid`),
FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`resultid`) REFERENCES `result` (`resultid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `branchitem_branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem_branchitemrule`;
CREATE TABLE `branchitem_branchitemrule` (
`itemid`  int(11) NOT NULL ,
`ruleid`  int(11) NOT NULL ,
PRIMARY KEY (`itemid`, `ruleid`),
FOREIGN KEY (`itemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `columnchoice`
-- ----------------------------
DROP TABLE IF EXISTS `columnchoice`;
CREATE TABLE `columnchoice` (
`columnchoiceid`  int(11) NOT NULL AUTO_INCREMENT ,
`columnchoiceorder`  int(11) NULL DEFAULT NULL ,
`columnchoicetitle`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`columnchoiceid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=4166

;

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
`conditionid`  int(11) NOT NULL AUTO_INCREMENT ,
`skips`  bit(1) NULL DEFAULT NULL ,
PRIMARY KEY (`conditionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `condition_scenario`
-- ----------------------------
DROP TABLE IF EXISTS `condition_scenario`;
CREATE TABLE `condition_scenario` (
`conditionid`  int(11) NOT NULL DEFAULT 0 ,
`scenarioid`  int(11) NOT NULL DEFAULT 0 ,
PRIMARY KEY (`conditionid`, `scenarioid`),
FOREIGN KEY (`scenarioid`) REFERENCES `scenario` (`scenarioid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`conditionid`) REFERENCES `assumption` (`conditionid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `entry`
-- ----------------------------
DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
`entryid`  int(11) NOT NULL AUTO_INCREMENT ,
`questionid`  int(11) NOT NULL ,
`answerid`  int(11) NULL DEFAULT NULL ,
`subquestionid`  int(11) NULL DEFAULT NULL ,
`columnchoiceid`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`entryid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=357

;

-- ----------------------------
-- Table structure for `page`
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
`pageid`  int(11) NOT NULL AUTO_INCREMENT ,
`pageorder`  int(11) NULL DEFAULT NULL ,
`pagetitle`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`pageheader`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`pagefooter`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`pageid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=14657

;

-- ----------------------------
-- Table structure for `pagebranch`
-- ----------------------------
DROP TABLE IF EXISTS `pagebranch`;
CREATE TABLE `pagebranch` (
`branchid`  int(11) NOT NULL AUTO_INCREMENT ,
`branchname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`main`  tinyint(1) NOT NULL ,
`have_item`  tinyint(1) NOT NULL ,
PRIMARY KEY (`branchid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=21659

;

-- ----------------------------
-- Table structure for `pagebranch_branchitem`
-- ----------------------------
DROP TABLE IF EXISTS `pagebranch_branchitem`;
CREATE TABLE `pagebranch_branchitem` (
`branchid`  int(11) NOT NULL ,
`branchitemid`  int(11) NOT NULL ,
PRIMARY KEY (`branchid`, `branchitemid`),
FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`branchitemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `page_branch`
-- ----------------------------
DROP TABLE IF EXISTS `page_branch`;
CREATE TABLE `page_branch` (
`pageid`  int(11) NOT NULL ,
`branchid`  int(11) NOT NULL ,
FOREIGN KEY (`branchid`) REFERENCES `pagebranch` (`branchid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
`questionid`  int(11) NOT NULL AUTO_INCREMENT ,
`allowcustomized`  tinyint(1) NULL DEFAULT NULL ,
`allowdescription`  tinyint(1) NULL DEFAULT NULL ,
`allowmultipile`  tinyint(1) NULL DEFAULT NULL ,
`questiontitle`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`questiontype`  int(10) NOT NULL ,
`wysiwyg`  tinyint(1) NULL DEFAULT NULL ,
`answertype`  int(10) NULL DEFAULT NULL ,
`answermask`  varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`rating`  double(20,0) NULL DEFAULT NULL ,
`columntype`  int(10) NULL DEFAULT NULL ,
`inuse`  bit(1) NULL DEFAULT NULL ,
`occupy`  tinyint(1) NULL DEFAULT 0 ,
`lockuser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`description`  text CHARACTER SET utf8 COLLATE utf8_bin NULL ,
PRIMARY KEY (`questionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
COMMENT='<double-click to overwrite multiple objects>'
AUTO_INCREMENT=20604

;

-- ----------------------------
-- Table structure for `question_answer`
-- ----------------------------
DROP TABLE IF EXISTS `question_answer`;
CREATE TABLE `question_answer` (
`questionid`  int(11) NOT NULL ,
`answerid`  int(11) NOT NULL ,
PRIMARY KEY (`questionid`, `answerid`),
FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`answerid`) REFERENCES `answer` (`answerid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
COMMENT='<double-click to overwrite multiple objects>'

;

-- ----------------------------
-- Table structure for `question_columnchoice`
-- ----------------------------
DROP TABLE IF EXISTS `question_columnchoice`;
CREATE TABLE `question_columnchoice` (
`questionid`  int(11) NOT NULL ,
`columnchoiceid`  int(11) NOT NULL ,
PRIMARY KEY (`questionid`, `columnchoiceid`),
FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`columnchoiceid`) REFERENCES `columnchoice` (`columnchoiceid`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `question_subquestion`
-- ----------------------------
DROP TABLE IF EXISTS `question_subquestion`;
CREATE TABLE `question_subquestion` (
`questionid`  int(11) NOT NULL ,
`subquestionid`  int(11) NOT NULL ,
PRIMARY KEY (`questionid`, `subquestionid`),
FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`subquestionid`) REFERENCES `subquestion` (`subquestionid`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `reponse_entry`
-- ----------------------------
DROP TABLE IF EXISTS `reponse_entry`;
CREATE TABLE `reponse_entry` (
`entryid`  int(11) NOT NULL ,
`responseid`  int(11) NOT NULL ,
FOREIGN KEY (`entryid`) REFERENCES `entry` (`entryid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`responseid`) REFERENCES `response` (`responseid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `response`
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
`responseid`  int(11) NOT NULL AUTO_INCREMENT ,
`sid`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`responseid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=268

;

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
`resultid`  int(11) NOT NULL AUTO_INCREMENT ,
`displays`  int(11) NULL DEFAULT NULL ,
`pageid`  int(11) NULL DEFAULT NULL ,
`pagebranchid`  int(11) NULL DEFAULT NULL ,
`pageid_aq`  int(11) NULL DEFAULT NULL ,
`pageid_ap`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`resultid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=9040

;

-- ----------------------------
-- Table structure for `scenario`
-- ----------------------------
DROP TABLE IF EXISTS `scenario`;
CREATE TABLE `scenario` (
`scenarioid`  int(11) NOT NULL AUTO_INCREMENT ,
`subquestionid`  int(11) NULL DEFAULT NULL ,
`rating`  int(20) NULL DEFAULT NULL ,
`answerid`  int(11) NULL DEFAULT NULL ,
`textanswer`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`comparator`  int(11) NULL DEFAULT NULL ,
`columnchoiceid`  int(11) NULL DEFAULT NULL ,
`scenariotitle`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`scenarioid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1263

;

-- ----------------------------
-- Table structure for `scenariocc`
-- ----------------------------
DROP TABLE IF EXISTS `scenariocc`;
CREATE TABLE `scenariocc` (
`scenarioccid`  int(11) NOT NULL AUTO_INCREMENT ,
`columnchoiceid`  int(11) NOT NULL ,
PRIMARY KEY (`scenarioccid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=197

;

-- ----------------------------
-- Table structure for `scenario_scenariocc`
-- ----------------------------
DROP TABLE IF EXISTS `scenario_scenariocc`;
CREATE TABLE `scenario_scenariocc` (
`scenarioid`  int(11) NOT NULL DEFAULT 0 ,
`scenarioccid`  int(11) NOT NULL DEFAULT 0 ,
PRIMARY KEY (`scenarioid`, `scenarioccid`),
FOREIGN KEY (`scenarioid`) REFERENCES `scenario` (`scenarioid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`scenarioccid`) REFERENCES `scenariocc` (`scenarioccid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `subquestion`
-- ----------------------------
DROP TABLE IF EXISTS `subquestion`;
CREATE TABLE `subquestion` (
`subquestionid`  int(11) NOT NULL AUTO_INCREMENT ,
`subquestionorder`  int(11) NULL DEFAULT NULL ,
`subquestiontitle`  varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`subquestionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=4070

;

-- ----------------------------
-- Table structure for `survey`
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey` (
`sid`  int(11) NOT NULL AUTO_INCREMENT ,
`active`  tinyint(1) NOT NULL ,
`allowsave`  tinyint(1) NOT NULL ,
`attributedescriptions`  tinyint(1) NOT NULL ,
`datecreated`  date NULL DEFAULT NULL ,
`expires`  datetime NULL DEFAULT NULL ,
`language`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`supervisor`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`supervisoremail`  varchar(320) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`surveydescription`  varchar(650) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`surveyendtext`  varchar(400) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`surveytitle`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`surveywelcometext`  varchar(400) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`usecookie`  tinyint(1) NOT NULL ,
`occupy`  tinyint(1) NULL DEFAULT 0 ,
`lockuser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
PRIMARY KEY (`sid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=10400

;

-- ----------------------------
-- Table structure for `survey_page`
-- ----------------------------
DROP TABLE IF EXISTS `survey_page`;
CREATE TABLE `survey_page` (
`sid`  int(11) NOT NULL ,
`pageid`  int(11) NOT NULL ,
PRIMARY KEY (`sid`, `pageid`),
FOREIGN KEY (`sid`) REFERENCES `survey` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`pageid`) REFERENCES `page` (`pageid`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
`userid`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`userid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Indexes structure for table `answer`
-- ----------------------------
CREATE UNIQUE INDEX `answerid` ON `answer`(`answerid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `answer`
-- ----------------------------
ALTER TABLE `answer` AUTO_INCREMENT=11661;

-- ----------------------------
-- Indexes structure for table `assumption`
-- ----------------------------
CREATE UNIQUE INDEX `conditionid_unique` ON `assumption`(`conditionid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `assumption`
-- ----------------------------
ALTER TABLE `assumption` AUTO_INCREMENT=14217;

-- ----------------------------
-- Indexes structure for table `branchitem`
-- ----------------------------
CREATE UNIQUE INDEX `branchitem_id` ON `branchitem`(`branchitemid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `branchitem`
-- ----------------------------
ALTER TABLE `branchitem` AUTO_INCREMENT=20453;

-- ----------------------------
-- Indexes structure for table `branchitemrule`
-- ----------------------------
CREATE UNIQUE INDEX `ruleid_UNIQUE` ON `branchitemrule`(`ruleid`) USING BTREE ;
CREATE INDEX `branchitemrule_ibfk_1` ON `branchitemrule`(`conditionid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `branchitemrule`
-- ----------------------------
ALTER TABLE `branchitemrule` AUTO_INCREMENT=9213;

-- ----------------------------
-- Indexes structure for table `branchitemrule_result`
-- ----------------------------
CREATE INDEX `branchitemrule_result_ibfk_2` ON `branchitemrule_result`(`resultid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `branchitem_branchitemrule`
-- ----------------------------
CREATE INDEX `branchitem_branchitemrule_ibfk_2` ON `branchitem_branchitemrule`(`ruleid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `columnchoice`
-- ----------------------------
CREATE UNIQUE INDEX `columnchoiceid` ON `columnchoice`(`columnchoiceid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `columnchoice`
-- ----------------------------
ALTER TABLE `columnchoice` AUTO_INCREMENT=4166;

-- ----------------------------
-- Indexes structure for table `condition`
-- ----------------------------
CREATE UNIQUE INDEX `conditionid` ON `condition`(`conditionid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `condition`
-- ----------------------------
ALTER TABLE `condition` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table `condition_scenario`
-- ----------------------------
CREATE INDEX `FK418AC63496EF570B` ON `condition_scenario`(`scenarioid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `entry`
-- ----------------------------
ALTER TABLE `entry` AUTO_INCREMENT=357;

-- ----------------------------
-- Indexes structure for table `page`
-- ----------------------------
CREATE UNIQUE INDEX `pageid` ON `page`(`pageid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `page`
-- ----------------------------
ALTER TABLE `page` AUTO_INCREMENT=14657;

-- ----------------------------
-- Indexes structure for table `pagebranch`
-- ----------------------------
CREATE UNIQUE INDEX `branchid` ON `pagebranch`(`branchid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `pagebranch`
-- ----------------------------
ALTER TABLE `pagebranch` AUTO_INCREMENT=21659;

-- ----------------------------
-- Indexes structure for table `pagebranch_branchitem`
-- ----------------------------
CREATE INDEX `branchitemid` ON `pagebranch_branchitem`(`branchitemid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `page_branch`
-- ----------------------------
CREATE UNIQUE INDEX `branchid` ON `page_branch`(`branchid`) USING BTREE ;
CREATE INDEX `FKA66091528C5AF21E` ON `page_branch`(`branchid`) USING BTREE ;
CREATE INDEX `FKA6609152B1815949` ON `page_branch`(`pageid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `question`
-- ----------------------------
CREATE UNIQUE INDEX `questionid` ON `question`(`questionid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `question`
-- ----------------------------
ALTER TABLE `question` AUTO_INCREMENT=20604;

-- ----------------------------
-- Indexes structure for table `question_answer`
-- ----------------------------
CREATE INDEX `FK561DF237ECAA0FE7` ON `question_answer`(`answerid`) USING BTREE ;
CREATE INDEX `FK561DF2372C582A37` ON `question_answer`(`questionid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `question_columnchoice`
-- ----------------------------
CREATE INDEX `FK75E20C3031F29B19` ON `question_columnchoice`(`columnchoiceid`) USING BTREE ;
CREATE INDEX `FK75E20C302C582A37` ON `question_columnchoice`(`questionid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `question_subquestion`
-- ----------------------------
CREATE INDEX `FK63A7AB4D3BC35717` ON `question_subquestion`(`subquestionid`) USING BTREE ;
CREATE INDEX `FK63A7AB4D2C582A37` ON `question_subquestion`(`questionid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `reponse_entry`
-- ----------------------------
CREATE INDEX `entryid` ON `reponse_entry`(`entryid`) USING BTREE ;
CREATE INDEX `responseid` ON `reponse_entry`(`responseid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `response`
-- ----------------------------
ALTER TABLE `response` AUTO_INCREMENT=268;

-- ----------------------------
-- Indexes structure for table `result`
-- ----------------------------
CREATE UNIQUE INDEX `resultid` ON `result`(`resultid`) USING BTREE ;
CREATE INDEX `resultid_index` ON `result`(`resultid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `result`
-- ----------------------------
ALTER TABLE `result` AUTO_INCREMENT=9040;

-- ----------------------------
-- Auto increment value for `scenario`
-- ----------------------------
ALTER TABLE `scenario` AUTO_INCREMENT=1263;

-- ----------------------------
-- Auto increment value for `scenariocc`
-- ----------------------------
ALTER TABLE `scenariocc` AUTO_INCREMENT=197;

-- ----------------------------
-- Indexes structure for table `scenario_scenariocc`
-- ----------------------------
CREATE INDEX `scenarioccid` ON `scenario_scenariocc`(`scenarioccid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `subquestion`
-- ----------------------------
CREATE UNIQUE INDEX `subquestionid` ON `subquestion`(`subquestionid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `subquestion`
-- ----------------------------
ALTER TABLE `subquestion` AUTO_INCREMENT=4070;

-- ----------------------------
-- Indexes structure for table `survey`
-- ----------------------------
CREATE UNIQUE INDEX `sid` ON `survey`(`sid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `survey`
-- ----------------------------
ALTER TABLE `survey` AUTO_INCREMENT=10400;

-- ----------------------------
-- Indexes structure for table `survey_page`
-- ----------------------------
CREATE INDEX `pageid` ON `survey_page`(`pageid`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `users`
-- ----------------------------
CREATE UNIQUE INDEX `unique_username` ON `users`(`username`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `users`
-- ----------------------------
ALTER TABLE `users` AUTO_INCREMENT=3;
