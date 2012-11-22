/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-09-28 09:35:00
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
) ENGINE=InnoDB AUTO_INCREMENT=1252 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1191', '5', '');
INSERT INTO `answer` VALUES ('1192', '5', '');
INSERT INTO `answer` VALUES ('1193', '5', '');
INSERT INTO `answer` VALUES ('1194', '5', '');
INSERT INTO `answer` VALUES ('1195', '6', '');
INSERT INTO `answer` VALUES ('1196', '7', '');
INSERT INTO `answer` VALUES ('1197', '8', '');
INSERT INTO `answer` VALUES ('1241', '1', 'Twice');
INSERT INTO `answer` VALUES ('1242', '2', 'Three times');
INSERT INTO `answer` VALUES ('1243', '3', '');
INSERT INTO `answer` VALUES ('1244', '4', '');
INSERT INTO `answer` VALUES ('1245', '1', 'North');
INSERT INTO `answer` VALUES ('1246', '2', 'South');
INSERT INTO `answer` VALUES ('1247', '3', 'East');
INSERT INTO `answer` VALUES ('1248', '4', 'West');
INSERT INTO `answer` VALUES ('1249', '1', '1');
INSERT INTO `answer` VALUES ('1250', '2', '2');
INSERT INTO `answer` VALUES ('1251', '3', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=620 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('617', '0', '1', '2329');
INSERT INTO `branchitem` VALUES ('618', '0', '0', '2331');
INSERT INTO `branchitem` VALUES ('619', '0', '2', '2332');

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
) ENGINE=InnoDB AUTO_INCREMENT=664 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule
-- ----------------------------

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

-- ----------------------------
-- Table structure for `branchitem_branchitemrule`
-- ----------------------------
DROP TABLE IF EXISTS `branchitem_branchitemrule`;
CREATE TABLE `branchitem_branchitemrule` (
  `itemid` int(11) NOT NULL,
  `ruleid` int(11) NOT NULL,
  PRIMARY KEY (`itemid`,`ruleid`),
  KEY `branchitem_branchitemrule_ibfk_2` (`ruleid`),
  CONSTRAINT `branchitem_branchitemrule_ibfk_2` FOREIGN KEY (`ruleid`) REFERENCES `branchitemrule` (`ruleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `branchitem_branchitemrule_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `branchitem` (`branchitemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem_branchitemrule
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of columnchoice
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('2', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

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
) ENGINE=InnoDB AUTO_INCREMENT=535 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES ('505', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('506', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('507', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('508', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('509', '0', 'New Page1', '', '');
INSERT INTO `page` VALUES ('510', '1', '', '', '');
INSERT INTO `page` VALUES ('511', '2', 'New Page', '111111淡淡的11', '1111111111111111111');
INSERT INTO `page` VALUES ('512', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('513', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('519', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('520', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('521', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('522', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('530', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('531', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('533', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('534', '2', 'New Page', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=1694 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('1424', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1427', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1566', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1567', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1568', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1569', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1570', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1571', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1572', 'Branch 4', '0');
INSERT INTO `pagebranch` VALUES ('1573', 'Branch 5', '0');
INSERT INTO `pagebranch` VALUES ('1574', 'Branch 6', '0');
INSERT INTO `pagebranch` VALUES ('1575', 'Branch 7', '0');
INSERT INTO `pagebranch` VALUES ('1576', 'Branch 8', '0');
INSERT INTO `pagebranch` VALUES ('1577', 'Branch 9', '0');
INSERT INTO `pagebranch` VALUES ('1578', 'Branch 10', '0');
INSERT INTO `pagebranch` VALUES ('1579', 'Branch 11', '0');
INSERT INTO `pagebranch` VALUES ('1580', 'Branch 12', '0');
INSERT INTO `pagebranch` VALUES ('1581', 'Branch 13', '0');
INSERT INTO `pagebranch` VALUES ('1582', 'Branch 14', '0');
INSERT INTO `pagebranch` VALUES ('1583', 'Branch 15', '0');
INSERT INTO `pagebranch` VALUES ('1584', 'Branch 16', '0');
INSERT INTO `pagebranch` VALUES ('1585', 'Branch 17', '0');
INSERT INTO `pagebranch` VALUES ('1586', 'Branch 18', '0');
INSERT INTO `pagebranch` VALUES ('1587', 'Branch 19', '0');
INSERT INTO `pagebranch` VALUES ('1588', 'Branch 20', '0');
INSERT INTO `pagebranch` VALUES ('1589', 'Branch 21', '0');
INSERT INTO `pagebranch` VALUES ('1590', 'Branch 22', '0');
INSERT INTO `pagebranch` VALUES ('1591', 'Branch 23', '0');
INSERT INTO `pagebranch` VALUES ('1592', 'Branch 24', '0');
INSERT INTO `pagebranch` VALUES ('1593', 'Branch 25', '0');
INSERT INTO `pagebranch` VALUES ('1594', 'Branch 26', '0');
INSERT INTO `pagebranch` VALUES ('1595', 'Branch 27', '0');
INSERT INTO `pagebranch` VALUES ('1596', 'Branch 28', '0');
INSERT INTO `pagebranch` VALUES ('1597', 'Branch 29', '0');
INSERT INTO `pagebranch` VALUES ('1598', 'Branch 30', '0');
INSERT INTO `pagebranch` VALUES ('1599', 'Branch 31', '0');
INSERT INTO `pagebranch` VALUES ('1600', 'Branch 32', '0');
INSERT INTO `pagebranch` VALUES ('1601', 'Branch 33', '0');
INSERT INTO `pagebranch` VALUES ('1602', 'Branch 34', '0');
INSERT INTO `pagebranch` VALUES ('1603', 'Branch 35', '0');
INSERT INTO `pagebranch` VALUES ('1604', 'Branch 36', '0');
INSERT INTO `pagebranch` VALUES ('1605', 'Branch 37', '0');
INSERT INTO `pagebranch` VALUES ('1606', 'Branch 38', '0');
INSERT INTO `pagebranch` VALUES ('1607', 'Branch 39', '0');
INSERT INTO `pagebranch` VALUES ('1608', 'Branch 40', '0');
INSERT INTO `pagebranch` VALUES ('1609', 'Branch 41', '0');
INSERT INTO `pagebranch` VALUES ('1610', 'Branch 42', '0');
INSERT INTO `pagebranch` VALUES ('1611', 'Branch 43', '0');
INSERT INTO `pagebranch` VALUES ('1612', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1613', 'Branch 44', '0');
INSERT INTO `pagebranch` VALUES ('1614', 'Branch 45', '0');
INSERT INTO `pagebranch` VALUES ('1615', 'Branch 46', '0');
INSERT INTO `pagebranch` VALUES ('1616', 'Branch 47', '0');
INSERT INTO `pagebranch` VALUES ('1617', 'Branch 48', '0');
INSERT INTO `pagebranch` VALUES ('1618', 'Branch 49', '0');
INSERT INTO `pagebranch` VALUES ('1619', 'Branch 50', '0');
INSERT INTO `pagebranch` VALUES ('1620', 'Branch 51', '0');
INSERT INTO `pagebranch` VALUES ('1621', 'Branch 52', '0');
INSERT INTO `pagebranch` VALUES ('1622', 'Branch 53', '0');
INSERT INTO `pagebranch` VALUES ('1623', 'Branch 54', '0');
INSERT INTO `pagebranch` VALUES ('1624', 'Branch 55', '0');
INSERT INTO `pagebranch` VALUES ('1625', 'Branch 56', '0');
INSERT INTO `pagebranch` VALUES ('1626', 'Branch 57', '0');
INSERT INTO `pagebranch` VALUES ('1627', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1628', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1629', 'Branch 4', '0');
INSERT INTO `pagebranch` VALUES ('1631', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1632', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1633', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1634', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1635', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1639', 'Branch 5', '0');
INSERT INTO `pagebranch` VALUES ('1640', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1641', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1642', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1643', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1650', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1651', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1652', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1653', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1654', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1655', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1656', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1657', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1658', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1659', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1660', 'Branch 4', '0');
INSERT INTO `pagebranch` VALUES ('1661', 'Branch 2', '0');
INSERT INTO `pagebranch` VALUES ('1662', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1663', 'Branch 4', '0');
INSERT INTO `pagebranch` VALUES ('1685', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1686', 'Branch 1', '0');
INSERT INTO `pagebranch` VALUES ('1687', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1688', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1689', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1690', 'Branch 3', '0');
INSERT INTO `pagebranch` VALUES ('1692', 'Default Branch', '1');
INSERT INTO `pagebranch` VALUES ('1693', 'Default Branch', '1');

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
INSERT INTO `pagebranch_branchitem` VALUES ('1692', '617');
INSERT INTO `pagebranch_branchitem` VALUES ('1692', '618');
INSERT INTO `pagebranch_branchitem` VALUES ('1692', '619');

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
INSERT INTO `page_branch` VALUES ('505', '1566');
INSERT INTO `page_branch` VALUES ('506', '1567');
INSERT INTO `page_branch` VALUES ('506', '1570');
INSERT INTO `page_branch` VALUES ('506', '1571');
INSERT INTO `page_branch` VALUES ('506', '1572');
INSERT INTO `page_branch` VALUES ('506', '1573');
INSERT INTO `page_branch` VALUES ('506', '1574');
INSERT INTO `page_branch` VALUES ('506', '1575');
INSERT INTO `page_branch` VALUES ('506', '1576');
INSERT INTO `page_branch` VALUES ('506', '1577');
INSERT INTO `page_branch` VALUES ('506', '1578');
INSERT INTO `page_branch` VALUES ('506', '1579');
INSERT INTO `page_branch` VALUES ('506', '1580');
INSERT INTO `page_branch` VALUES ('506', '1581');
INSERT INTO `page_branch` VALUES ('506', '1582');
INSERT INTO `page_branch` VALUES ('506', '1583');
INSERT INTO `page_branch` VALUES ('506', '1584');
INSERT INTO `page_branch` VALUES ('506', '1585');
INSERT INTO `page_branch` VALUES ('506', '1586');
INSERT INTO `page_branch` VALUES ('506', '1587');
INSERT INTO `page_branch` VALUES ('506', '1588');
INSERT INTO `page_branch` VALUES ('506', '1589');
INSERT INTO `page_branch` VALUES ('506', '1590');
INSERT INTO `page_branch` VALUES ('506', '1591');
INSERT INTO `page_branch` VALUES ('506', '1592');
INSERT INTO `page_branch` VALUES ('506', '1593');
INSERT INTO `page_branch` VALUES ('506', '1594');
INSERT INTO `page_branch` VALUES ('506', '1595');
INSERT INTO `page_branch` VALUES ('506', '1596');
INSERT INTO `page_branch` VALUES ('506', '1597');
INSERT INTO `page_branch` VALUES ('506', '1598');
INSERT INTO `page_branch` VALUES ('506', '1599');
INSERT INTO `page_branch` VALUES ('506', '1600');
INSERT INTO `page_branch` VALUES ('506', '1601');
INSERT INTO `page_branch` VALUES ('506', '1602');
INSERT INTO `page_branch` VALUES ('506', '1603');
INSERT INTO `page_branch` VALUES ('506', '1604');
INSERT INTO `page_branch` VALUES ('506', '1605');
INSERT INTO `page_branch` VALUES ('506', '1606');
INSERT INTO `page_branch` VALUES ('506', '1607');
INSERT INTO `page_branch` VALUES ('506', '1608');
INSERT INTO `page_branch` VALUES ('506', '1609');
INSERT INTO `page_branch` VALUES ('506', '1610');
INSERT INTO `page_branch` VALUES ('506', '1611');
INSERT INTO `page_branch` VALUES ('506', '1613');
INSERT INTO `page_branch` VALUES ('506', '1614');
INSERT INTO `page_branch` VALUES ('506', '1615');
INSERT INTO `page_branch` VALUES ('506', '1616');
INSERT INTO `page_branch` VALUES ('506', '1617');
INSERT INTO `page_branch` VALUES ('506', '1618');
INSERT INTO `page_branch` VALUES ('506', '1619');
INSERT INTO `page_branch` VALUES ('506', '1620');
INSERT INTO `page_branch` VALUES ('506', '1621');
INSERT INTO `page_branch` VALUES ('506', '1622');
INSERT INTO `page_branch` VALUES ('506', '1623');
INSERT INTO `page_branch` VALUES ('506', '1624');
INSERT INTO `page_branch` VALUES ('506', '1625');
INSERT INTO `page_branch` VALUES ('506', '1626');
INSERT INTO `page_branch` VALUES ('507', '1568');
INSERT INTO `page_branch` VALUES ('507', '1612');
INSERT INTO `page_branch` VALUES ('508', '1569');
INSERT INTO `page_branch` VALUES ('509', '1627');
INSERT INTO `page_branch` VALUES ('510', '1628');
INSERT INTO `page_branch` VALUES ('510', '1633');
INSERT INTO `page_branch` VALUES ('510', '1634');
INSERT INTO `page_branch` VALUES ('510', '1635');
INSERT INTO `page_branch` VALUES ('511', '1629');
INSERT INTO `page_branch` VALUES ('511', '1639');
INSERT INTO `page_branch` VALUES ('511', '1640');
INSERT INTO `page_branch` VALUES ('511', '1641');
INSERT INTO `page_branch` VALUES ('511', '1643');
INSERT INTO `page_branch` VALUES ('512', '1631');
INSERT INTO `page_branch` VALUES ('513', '1632');
INSERT INTO `page_branch` VALUES ('513', '1642');
INSERT INTO `page_branch` VALUES ('519', '1650');
INSERT INTO `page_branch` VALUES ('519', '1654');
INSERT INTO `page_branch` VALUES ('519', '1655');
INSERT INTO `page_branch` VALUES ('520', '1651');
INSERT INTO `page_branch` VALUES ('520', '1652');
INSERT INTO `page_branch` VALUES ('520', '1653');
INSERT INTO `page_branch` VALUES ('521', '1656');
INSERT INTO `page_branch` VALUES ('521', '1658');
INSERT INTO `page_branch` VALUES ('521', '1659');
INSERT INTO `page_branch` VALUES ('521', '1660');
INSERT INTO `page_branch` VALUES ('522', '1657');
INSERT INTO `page_branch` VALUES ('522', '1661');
INSERT INTO `page_branch` VALUES ('522', '1662');
INSERT INTO `page_branch` VALUES ('522', '1663');
INSERT INTO `page_branch` VALUES ('530', '1685');
INSERT INTO `page_branch` VALUES ('530', '1687');
INSERT INTO `page_branch` VALUES ('530', '1688');
INSERT INTO `page_branch` VALUES ('531', '1686');
INSERT INTO `page_branch` VALUES ('531', '1689');
INSERT INTO `page_branch` VALUES ('531', '1690');
INSERT INTO `page_branch` VALUES ('533', '1692');
INSERT INTO `page_branch` VALUES ('534', '1693');

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
) ENGINE=InnoDB AUTO_INCREMENT=2363 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('2360', '0', '1', '1', 'How many times have you called our agency about this issue in the past month?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('2361', '1', '1', '0', 'Where do you live?', '3', '0', null, null, null, null, '0');
INSERT INTO `question` VALUES ('2362', '0', '1', '1', 'test', '3', '0', null, null, null, null, '0');

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
INSERT INTO `question_answer` VALUES ('2360', '1241');
INSERT INTO `question_answer` VALUES ('2360', '1242');
INSERT INTO `question_answer` VALUES ('2360', '1243');
INSERT INTO `question_answer` VALUES ('2360', '1244');
INSERT INTO `question_answer` VALUES ('2361', '1245');
INSERT INTO `question_answer` VALUES ('2361', '1246');
INSERT INTO `question_answer` VALUES ('2361', '1247');
INSERT INTO `question_answer` VALUES ('2361', '1248');
INSERT INTO `question_answer` VALUES ('2362', '1249');
INSERT INTO `question_answer` VALUES ('2362', '1250');
INSERT INTO `question_answer` VALUES ('2362', '1251');

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
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=497 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subquestion
-- ----------------------------
INSERT INTO `subquestion` VALUES ('490', '5', 'Colourful pictures');

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
) ENGINE=InnoDB AUTO_INCREMENT=330 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('275', '0', '0', '0', '2012-09-26', null, 'EN', '', '', '', '', 'test survey', '', '0');
INSERT INTO `survey` VALUES ('317', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test survey 1', '', '0');
INSERT INTO `survey` VALUES ('319', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test', '', '0');
INSERT INTO `survey` VALUES ('320', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'sssss', '', '0');
INSERT INTO `survey` VALUES ('324', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test 2222', '', '0');
INSERT INTO `survey` VALUES ('329', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'aaaa', '', '0');

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
INSERT INTO `survey_page` VALUES ('275', '505');
INSERT INTO `survey_page` VALUES ('275', '506');
INSERT INTO `survey_page` VALUES ('275', '507');
INSERT INTO `survey_page` VALUES ('275', '508');
INSERT INTO `survey_page` VALUES ('317', '509');
INSERT INTO `survey_page` VALUES ('317', '510');
INSERT INTO `survey_page` VALUES ('317', '511');
INSERT INTO `survey_page` VALUES ('317', '512');
INSERT INTO `survey_page` VALUES ('317', '513');
INSERT INTO `survey_page` VALUES ('319', '519');
INSERT INTO `survey_page` VALUES ('319', '520');
INSERT INTO `survey_page` VALUES ('320', '521');
INSERT INTO `survey_page` VALUES ('320', '522');
INSERT INTO `survey_page` VALUES ('324', '530');
INSERT INTO `survey_page` VALUES ('324', '531');
INSERT INTO `survey_page` VALUES ('329', '533');
INSERT INTO `survey_page` VALUES ('329', '534');

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
