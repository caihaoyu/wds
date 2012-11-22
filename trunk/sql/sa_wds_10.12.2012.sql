/*
Navicat MySQL Data Transfer

Source Server         : station2
Source Server Version : 50525
Source Host           : station2:3306
Source Database       : sa_wds

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-10-12 10:15:35
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
) ENGINE=InnoDB AUTO_INCREMENT=1685 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('621', '1', '1');
INSERT INTO `answer` VALUES ('622', '2', '2');
INSERT INTO `answer` VALUES ('623', '3', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=2181 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitem
-- ----------------------------
INSERT INTO `branchitem` VALUES ('617', '0', '1', '2329');
INSERT INTO `branchitem` VALUES ('618', '0', '0', '2331');
INSERT INTO `branchitem` VALUES ('619', '0', '2', '2332');
INSERT INTO `branchitem` VALUES ('665', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('666', '1', '1', '1');
INSERT INTO `branchitem` VALUES ('696', '1', '1', '96');
INSERT INTO `branchitem` VALUES ('697', '1', '2', '118');
INSERT INTO `branchitem` VALUES ('698', '0', '2', '119');
INSERT INTO `branchitem` VALUES ('699', '0', '1', '148');
INSERT INTO `branchitem` VALUES ('825', '0', '1', '364');
INSERT INTO `branchitem` VALUES ('826', '0', '2', '832');
INSERT INTO `branchitem` VALUES ('827', '0', '3', '833');
INSERT INTO `branchitem` VALUES ('830', '0', '4', '941');
INSERT INTO `branchitem` VALUES ('831', '0', '5', '942');
INSERT INTO `branchitem` VALUES ('833', '0', '6', '943');
INSERT INTO `branchitem` VALUES ('834', '0', '7', '944');
INSERT INTO `branchitem` VALUES ('835', '0', '8', '963');
INSERT INTO `branchitem` VALUES ('836', '0', '9', '964');
INSERT INTO `branchitem` VALUES ('837', '0', '1', '95');
INSERT INTO `branchitem` VALUES ('838', '0', '1', '95');
INSERT INTO `branchitem` VALUES ('839', '0', '1', '95');
INSERT INTO `branchitem` VALUES ('840', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('841', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('842', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('849', '0', '10', '965');
INSERT INTO `branchitem` VALUES ('850', '0', '11', '987');
INSERT INTO `branchitem` VALUES ('963', '0', '12', '1297');
INSERT INTO `branchitem` VALUES ('964', '0', '13', '1298');
INSERT INTO `branchitem` VALUES ('965', '1', '2', '95');
INSERT INTO `branchitem` VALUES ('966', '1', '3', '96');
INSERT INTO `branchitem` VALUES ('1012', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1013', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1014', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1015', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1016', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1017', '0', '1', '95');
INSERT INTO `branchitem` VALUES ('1018', '0', '1', '95');
INSERT INTO `branchitem` VALUES ('1640', '0', '1', '364');
INSERT INTO `branchitem` VALUES ('1655', '0', '4', '1');
INSERT INTO `branchitem` VALUES ('1656', '0', '4', '95');
INSERT INTO `branchitem` VALUES ('1657', '0', '3', '149');
INSERT INTO `branchitem` VALUES ('1658', '0', '3', '149');
INSERT INTO `branchitem` VALUES ('1659', '0', '3', '149');
INSERT INTO `branchitem` VALUES ('1660', '0', '3', '149');
INSERT INTO `branchitem` VALUES ('1661', '0', '3', '149');
INSERT INTO `branchitem` VALUES ('1662', '0', '1', '148');
INSERT INTO `branchitem` VALUES ('1695', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1759', '0', '1', '1');
INSERT INTO `branchitem` VALUES ('1760', '0', '2', '95');
INSERT INTO `branchitem` VALUES ('1781', '0', '0', '119');

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
) ENGINE=InnoDB AUTO_INCREMENT=1144 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of branchitemrule
-- ----------------------------
INSERT INTO `branchitemrule` VALUES ('845', 'If the user skips this question. Show 2 hidden questions.', '978', '1');
INSERT INTO `branchitemrule` VALUES ('846', 'If the user skips this question. Temporarily set 2 pagebranchs as default.', '979', '2');
INSERT INTO `branchitemrule` VALUES ('864', 'If the user skips this question. Temporarily set 2 pagebranchs as default.', '994', '2');

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
INSERT INTO `branchitemrule_result` VALUES ('846', '669');
INSERT INTO `branchitemrule_result` VALUES ('846', '670');
INSERT INTO `branchitemrule_result` VALUES ('845', '671');
INSERT INTO `branchitemrule_result` VALUES ('864', '673');
INSERT INTO `branchitemrule_result` VALUES ('864', '674');
INSERT INTO `branchitemrule_result` VALUES ('845', '675');

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
INSERT INTO `branchitem_branchitemrule` VALUES ('665', '845');
INSERT INTO `branchitem_branchitemrule` VALUES ('665', '846');
INSERT INTO `branchitem_branchitemrule` VALUES ('665', '864');

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
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `columnchoice` VALUES ('203', '1', 'nn');
INSERT INTO `columnchoice` VALUES ('204', '2', 'bb');

-- ----------------------------
-- Table structure for `condition`
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition` (
  `conditionid` int(11) NOT NULL AUTO_INCREMENT,
  `skips` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`conditionid`),
  UNIQUE KEY `conditionid_unique` (`conditionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1456 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of condition
-- ----------------------------
INSERT INTO `condition` VALUES ('2', '1');
INSERT INTO `condition` VALUES ('8', '1');
INSERT INTO `condition` VALUES ('13', '1');
INSERT INTO `condition` VALUES ('978', '1');
INSERT INTO `condition` VALUES ('979', '1');
INSERT INTO `condition` VALUES ('994', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=1580 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of page
-- ----------------------------
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
INSERT INTO `page` VALUES ('543', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('544', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('545', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('547', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('568', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('573', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('586', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('587', '2', 'Page2', '', '');
INSERT INTO `page` VALUES ('596', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('597', '0', '第一页', 'Page Header', 'Page Footer');
INSERT INTO `page` VALUES ('598', '3', 'Page Two', '', '');
INSERT INTO `page` VALUES ('599', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('612', '2', 'New Page', null, null);
INSERT INTO `page` VALUES ('614', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('615', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('681', '0', 'Page 1', 'page header1', 'page footer1');
INSERT INTO `page` VALUES ('682', '1', 'Page 2', 'page header2', 'page footer2');
INSERT INTO `page` VALUES ('683', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('684', '4', 'New Page', null, null);
INSERT INTO `page` VALUES ('685', '5', 'New Page', null, null);
INSERT INTO `page` VALUES ('686', '6', 'New Page', null, null);
INSERT INTO `page` VALUES ('687', '7', 'New Page', null, null);
INSERT INTO `page` VALUES ('688', '8', 'New Page', null, null);
INSERT INTO `page` VALUES ('691', '9', 'New Page', null, null);
INSERT INTO `page` VALUES ('692', '10', 'New Page', null, null);
INSERT INTO `page` VALUES ('693', '11', 'New Page', null, null);
INSERT INTO `page` VALUES ('694', '12', 'New Page', null, null);
INSERT INTO `page` VALUES ('695', '13', 'New Page', null, null);
INSERT INTO `page` VALUES ('696', '14', 'New Page', null, null);
INSERT INTO `page` VALUES ('697', '15', 'New Page', null, null);
INSERT INTO `page` VALUES ('698', '16', 'New Page', null, null);
INSERT INTO `page` VALUES ('699', '17', 'New Page', null, null);
INSERT INTO `page` VALUES ('700', '18', 'New Page', null, null);
INSERT INTO `page` VALUES ('701', '19', 'New Page', null, null);
INSERT INTO `page` VALUES ('705', '0', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('709', '3', 'Page3', '', '');
INSERT INTO `page` VALUES ('1276', '1', 'Page 1', 'This is Page Header of Page 1', 'This is Page Footer of Page 1');
INSERT INTO `page` VALUES ('1325', '2', 'Page 2', 'This is Page Header of Page 2.', 'This is Page Footer of Page 2.');
INSERT INTO `page` VALUES ('1332', '1', 'New Page', null, null);
INSERT INTO `page` VALUES ('1333', '3', 'New Page', null, null);
INSERT INTO `page` VALUES ('1576', '0', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('1577', '1', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('1578', '3', 'page title', 'page header', 'page footer');
INSERT INTO `page` VALUES ('1579', '4', 'New Page', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=3427 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pagebranch
-- ----------------------------
INSERT INTO `pagebranch` VALUES ('1424', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1427', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1627', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1628', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('1629', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('1631', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1632', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1633', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1634', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1635', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1639', 'Branch 5', '0', '0');
INSERT INTO `pagebranch` VALUES ('1640', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1641', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1642', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1643', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('1650', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1651', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1652', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1653', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1654', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1655', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1656', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1657', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1658', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1659', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('1660', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('1661', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1662', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1663', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('1685', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('1686', 'Branch 1', '0', '0');
INSERT INTO `pagebranch` VALUES ('1687', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1688', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1689', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1690', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1692', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1693', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1700', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1701', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1702', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1704', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1716', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1717', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1765', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1770', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1786', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('1787', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('1788', 'Branch 2', '0', '1');
INSERT INTO `pagebranch` VALUES ('1810', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1815', 'Branch 1', '0', '1');
INSERT INTO `pagebranch` VALUES ('1818', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1820', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1826', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1827', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('1862', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1864', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1865', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1884', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('1889', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('1890', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('1891', 'Branch 5', '0', '0');
INSERT INTO `pagebranch` VALUES ('1892', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('2025', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('2026', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('2027', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('2028', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2029', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('2030', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2031', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('2032', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2033', 'Branch 5', '0', '0');
INSERT INTO `pagebranch` VALUES ('2034', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2035', 'Branch 6', '0', '0');
INSERT INTO `pagebranch` VALUES ('2036', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2037', 'Branch 7', '0', '0');
INSERT INTO `pagebranch` VALUES ('2038', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2039', 'Branch 8', '0', '0');
INSERT INTO `pagebranch` VALUES ('2041', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('2042', 'Branch 6', '0', '0');
INSERT INTO `pagebranch` VALUES ('2043', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2047', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2048', 'Branch 9', '0', '0');
INSERT INTO `pagebranch` VALUES ('2049', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2050', 'Branch 10', '0', '0');
INSERT INTO `pagebranch` VALUES ('2051', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2052', 'Branch 11', '0', '0');
INSERT INTO `pagebranch` VALUES ('2053', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2054', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2055', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('2056', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2057', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('2058', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2059', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2060', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2061', 'Branch 12', '0', '0');
INSERT INTO `pagebranch` VALUES ('2062', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2063', 'Branch 13', '0', '0');
INSERT INTO `pagebranch` VALUES ('2064', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2065', 'Branch 14', '0', '0');
INSERT INTO `pagebranch` VALUES ('2067', 'Branch 15', '0', '0');
INSERT INTO `pagebranch` VALUES ('2069', 'Branch 16', '0', '0');
INSERT INTO `pagebranch` VALUES ('2079', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('2080', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('2874', 'Default Branch', '1', '1');
INSERT INTO `pagebranch` VALUES ('2892', 'Branch 4', '0', '0');
INSERT INTO `pagebranch` VALUES ('2991', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3007', 'Branch 1', '0', '1');
INSERT INTO `pagebranch` VALUES ('3008', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('3009', 'Branch 3', '0', '0');
INSERT INTO `pagebranch` VALUES ('3010', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3011', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3059', 'Branch 2', '0', '0');
INSERT INTO `pagebranch` VALUES ('3423', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3424', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3425', 'Default Branch', '1', '0');
INSERT INTO `pagebranch` VALUES ('3426', 'Default Branch', '1', '0');

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
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '665');
INSERT INTO `pagebranch_branchitem` VALUES ('1788', '666');
INSERT INTO `pagebranch_branchitem` VALUES ('1787', '696');
INSERT INTO `pagebranch_branchitem` VALUES ('1787', '697');
INSERT INTO `pagebranch_branchitem` VALUES ('1815', '698');
INSERT INTO `pagebranch_branchitem` VALUES ('1815', '699');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '825');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '826');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '827');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '830');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '831');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '833');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '834');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '835');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '836');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '849');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '850');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '963');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '964');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '965');
INSERT INTO `pagebranch_branchitem` VALUES ('1786', '966');
INSERT INTO `pagebranch_branchitem` VALUES ('2025', '966');
INSERT INTO `pagebranch_branchitem` VALUES ('2026', '966');
INSERT INTO `pagebranch_branchitem` VALUES ('2874', '1640');
INSERT INTO `pagebranch_branchitem` VALUES ('3007', '1759');
INSERT INTO `pagebranch_branchitem` VALUES ('3007', '1760');
INSERT INTO `pagebranch_branchitem` VALUES ('1815', '1781');

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
INSERT INTO `page_branch` VALUES ('509', '1627');
INSERT INTO `page_branch` VALUES ('509', '1884');
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
INSERT INTO `page_branch` VALUES ('519', '1892');
INSERT INTO `page_branch` VALUES ('520', '1651');
INSERT INTO `page_branch` VALUES ('520', '1652');
INSERT INTO `page_branch` VALUES ('520', '1653');
INSERT INTO `page_branch` VALUES ('520', '1890');
INSERT INTO `page_branch` VALUES ('520', '1891');
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
INSERT INTO `page_branch` VALUES ('533', '1716');
INSERT INTO `page_branch` VALUES ('533', '1717');
INSERT INTO `page_branch` VALUES ('534', '1693');
INSERT INTO `page_branch` VALUES ('543', '1700');
INSERT INTO `page_branch` VALUES ('544', '1701');
INSERT INTO `page_branch` VALUES ('545', '1702');
INSERT INTO `page_branch` VALUES ('547', '1704');
INSERT INTO `page_branch` VALUES ('568', '1765');
INSERT INTO `page_branch` VALUES ('573', '1770');
INSERT INTO `page_branch` VALUES ('586', '1786');
INSERT INTO `page_branch` VALUES ('587', '1787');
INSERT INTO `page_branch` VALUES ('587', '1788');
INSERT INTO `page_branch` VALUES ('596', '1810');
INSERT INTO `page_branch` VALUES ('597', '1815');
INSERT INTO `page_branch` VALUES ('597', '1826');
INSERT INTO `page_branch` VALUES ('597', '1827');
INSERT INTO `page_branch` VALUES ('597', '2892');
INSERT INTO `page_branch` VALUES ('598', '1818');
INSERT INTO `page_branch` VALUES ('598', '3059');
INSERT INTO `page_branch` VALUES ('599', '1820');
INSERT INTO `page_branch` VALUES ('612', '1862');
INSERT INTO `page_branch` VALUES ('614', '1864');
INSERT INTO `page_branch` VALUES ('615', '1865');
INSERT INTO `page_branch` VALUES ('681', '2025');
INSERT INTO `page_branch` VALUES ('681', '2027');
INSERT INTO `page_branch` VALUES ('681', '2029');
INSERT INTO `page_branch` VALUES ('681', '2031');
INSERT INTO `page_branch` VALUES ('681', '2033');
INSERT INTO `page_branch` VALUES ('681', '2035');
INSERT INTO `page_branch` VALUES ('681', '2037');
INSERT INTO `page_branch` VALUES ('681', '2039');
INSERT INTO `page_branch` VALUES ('681', '2048');
INSERT INTO `page_branch` VALUES ('681', '2050');
INSERT INTO `page_branch` VALUES ('681', '2052');
INSERT INTO `page_branch` VALUES ('681', '2061');
INSERT INTO `page_branch` VALUES ('681', '2063');
INSERT INTO `page_branch` VALUES ('681', '2065');
INSERT INTO `page_branch` VALUES ('681', '2067');
INSERT INTO `page_branch` VALUES ('681', '2069');
INSERT INTO `page_branch` VALUES ('682', '2026');
INSERT INTO `page_branch` VALUES ('682', '2055');
INSERT INTO `page_branch` VALUES ('682', '2057');
INSERT INTO `page_branch` VALUES ('683', '2028');
INSERT INTO `page_branch` VALUES ('684', '2030');
INSERT INTO `page_branch` VALUES ('685', '2032');
INSERT INTO `page_branch` VALUES ('686', '2034');
INSERT INTO `page_branch` VALUES ('687', '2036');
INSERT INTO `page_branch` VALUES ('688', '2038');
INSERT INTO `page_branch` VALUES ('691', '2047');
INSERT INTO `page_branch` VALUES ('692', '2049');
INSERT INTO `page_branch` VALUES ('693', '2051');
INSERT INTO `page_branch` VALUES ('694', '2053');
INSERT INTO `page_branch` VALUES ('695', '2054');
INSERT INTO `page_branch` VALUES ('696', '2056');
INSERT INTO `page_branch` VALUES ('697', '2058');
INSERT INTO `page_branch` VALUES ('698', '2059');
INSERT INTO `page_branch` VALUES ('699', '2060');
INSERT INTO `page_branch` VALUES ('700', '2062');
INSERT INTO `page_branch` VALUES ('701', '2064');
INSERT INTO `page_branch` VALUES ('705', '3007');
INSERT INTO `page_branch` VALUES ('705', '3008');
INSERT INTO `page_branch` VALUES ('705', '3009');
INSERT INTO `page_branch` VALUES ('709', '2079');
INSERT INTO `page_branch` VALUES ('709', '2080');
INSERT INTO `page_branch` VALUES ('1276', '2874');
INSERT INTO `page_branch` VALUES ('1325', '2991');
INSERT INTO `page_branch` VALUES ('1332', '3010');
INSERT INTO `page_branch` VALUES ('1333', '3011');
INSERT INTO `page_branch` VALUES ('1576', '3423');
INSERT INTO `page_branch` VALUES ('1577', '3424');
INSERT INTO `page_branch` VALUES ('1578', '3425');
INSERT INTO `page_branch` VALUES ('1579', '3426');

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
  PRIMARY KEY (`questionid`),
  UNIQUE KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=2217 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='<double-click to overwrite multiple objects>';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '0', '0', '0', '2363663', '1', '0', '1', null, null, null, null);
INSERT INTO `question` VALUES ('95', '0', '0', '0', 'Click to edit question title.Click to edit question title.', '4', '0', null, null, null, '3', null);
INSERT INTO `question` VALUES ('96', '0', '0', '0', 'Click to edit question title.Click to edit question title.Click to edit question title.', '2', '0', null, null, '8', null, null);
INSERT INTO `question` VALUES ('118', '0', '1', '0', 'What order of importance do you rank the following website features', '4', '0', null, null, null, '3', null);
INSERT INTO `question` VALUES ('119', '0', '0', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, null, '3', null);
INSERT INTO `question` VALUES ('148', '0', '1', '0', 'What do you think about the following opinion of this company has:', '4', '0', null, null, null, '1', null);
INSERT INTO `question` VALUES ('149', '0', '1', '0', 'How much do you agree with each of the following statements:', '4', '0', null, null, null, '2', null);
INSERT INTO `question` VALUES ('166', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null);
INSERT INTO `question` VALUES ('167', '0', '1', '0', 'How would you describe your services and/or products?', '1', '0', '1', '99/99/9999', null, null, null);
INSERT INTO `question` VALUES ('171', '0', '0', '0', 'Test delete one question', '1', '0', '1', null, null, null, null);
INSERT INTO `question` VALUES ('364', '0', '1', '0', 'question 1', '1', '0', '1', null, null, null, null);
INSERT INTO `question` VALUES ('832', '0', '0', '0', 'Question 2', '2', '0', null, null, '5', null, null);
INSERT INTO `question` VALUES ('833', '1', '0', '0', 'Question 3', '3', '0', null, null, null, null, null);
INSERT INTO `question` VALUES ('941', '0', '0', '0', 'question 4', '1', '0', '2', null, null, null, null);
INSERT INTO `question` VALUES ('942', '0', '0', '0', 'Question 5', '1', '0', '3', null, null, null, null);
INSERT INTO `question` VALUES ('943', '0', '0', '0', 'Question 6', '2', '0', null, null, '7', null, null);
INSERT INTO `question` VALUES ('944', '0', '0', '0', 'Question 7', '1', '0', '1', null, null, null, null);
INSERT INTO `question` VALUES ('963', '1', '0', '0', 'Question 8', '4', '0', null, null, null, '1', null);
INSERT INTO `question` VALUES ('964', '0', '0', '0', 'Question 9', '4', '0', null, null, '3', '2', null);
INSERT INTO `question` VALUES ('965', '0', '0', '0', 'Question 10', '4', '0', null, null, null, '3', null);
INSERT INTO `question` VALUES ('987', '1', '0', '0', 'Question 11', '4', '0', null, null, '7', '3', null);
INSERT INTO `question` VALUES ('1297', '0', '0', '1', 'Question 12', '4', '0', null, null, null, '3', null);
INSERT INTO `question` VALUES ('1298', '1', '0', '1', 'Question 13', '4', '0', null, null, null, '3', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=985 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('274', '966', null, null, null, null);
INSERT INTO `result` VALUES ('278', '965', null, null, null, null);
INSERT INTO `result` VALUES ('342', '965', null, null, null, null);
INSERT INTO `result` VALUES ('404', '965', null, null, null, null);
INSERT INTO `result` VALUES ('421', '965', null, null, null, null);
INSERT INTO `result` VALUES ('669', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('670', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('671', '966', null, null, null, null);
INSERT INTO `result` VALUES ('673', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('674', null, '587', '1788', null, null);
INSERT INTO `result` VALUES ('675', '965', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=424 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=1465 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES ('275', '0', '0', '0', '2012-09-26', null, 'EN', '', '', '', '', '网站开发问卷', '', '0');
INSERT INTO `survey` VALUES ('317', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test survey 1', '', '0');
INSERT INTO `survey` VALUES ('319', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test1', '', '0');
INSERT INTO `survey` VALUES ('320', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'sssss', '', '0');
INSERT INTO `survey` VALUES ('324', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'test 2222', '', '0');
INSERT INTO `survey` VALUES ('329', '0', '0', '0', '2012-09-27', null, 'EN', '', '', '', '', 'aaaa', '', '0');
INSERT INTO `survey` VALUES ('333', '0', '0', '0', '2012-09-28', null, 'EN', '', '', '', '', 'testing', '', '0');
INSERT INTO `survey` VALUES ('339', '0', '0', '0', '2012-09-28', null, 'EN', '', '', '', '', '36366356369', '', '0');
INSERT INTO `survey` VALUES ('357', '0', '0', '0', '2012-10-07', null, 'EN', '', '', '', '', 'asdasdasd1', '', '0');
INSERT INTO `survey` VALUES ('358', '0', '0', '0', '2012-10-07', null, 'EN', '', '', '', '', '小蔡使用，不要删', '', '0');
INSERT INTO `survey` VALUES ('411', '0', '0', '0', '2012-10-09', null, 'EN', '', '', 'Test Survey 3', '', 'Test Survey 3', '', '0');
INSERT INTO `survey` VALUES ('457', '0', '0', '0', '2012-10-09', null, 'EN', '', '', '', '', 'Test Survey 4', '', '0');
INSERT INTO `survey` VALUES ('458', '0', '0', '0', '2012-10-09', null, 'EN', '', '', '', '', '禁止上楼', '', '0');
INSERT INTO `survey` VALUES ('1464', '1', '0', '1', '2012-10-12', '2012-10-25 00:00:00', 'EN', 'Martha Retallick', 'M.Retallick@webforyou.com.au', 'How to Extract the Facts with a Web Design Client Questionnaire', 'Whew! That’s quite a list of questions. And, truth be told, I don’t use every one of them every time. It’s important to respect your prospects’ time, even when you’re looking for long-term relationships.', 'Extract the Facts', 'I recommend using this questionnaire before you write a Web design proposal. You should reserve your proposal-writing time for the best-qualified prospects, rather than everyone who asks for one.', '0');

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
INSERT INTO `survey_page` VALUES ('333', '543');
INSERT INTO `survey_page` VALUES ('333', '544');
INSERT INTO `survey_page` VALUES ('333', '545');
INSERT INTO `survey_page` VALUES ('333', '547');
INSERT INTO `survey_page` VALUES ('357', '568');
INSERT INTO `survey_page` VALUES ('357', '573');
INSERT INTO `survey_page` VALUES ('358', '586');
INSERT INTO `survey_page` VALUES ('358', '587');
INSERT INTO `survey_page` VALUES ('275', '596');
INSERT INTO `survey_page` VALUES ('275', '597');
INSERT INTO `survey_page` VALUES ('275', '598');
INSERT INTO `survey_page` VALUES ('275', '599');
INSERT INTO `survey_page` VALUES ('339', '612');
INSERT INTO `survey_page` VALUES ('339', '614');
INSERT INTO `survey_page` VALUES ('339', '615');
INSERT INTO `survey_page` VALUES ('457', '681');
INSERT INTO `survey_page` VALUES ('457', '682');
INSERT INTO `survey_page` VALUES ('457', '683');
INSERT INTO `survey_page` VALUES ('457', '684');
INSERT INTO `survey_page` VALUES ('457', '685');
INSERT INTO `survey_page` VALUES ('457', '686');
INSERT INTO `survey_page` VALUES ('457', '687');
INSERT INTO `survey_page` VALUES ('457', '688');
INSERT INTO `survey_page` VALUES ('457', '691');
INSERT INTO `survey_page` VALUES ('457', '692');
INSERT INTO `survey_page` VALUES ('457', '693');
INSERT INTO `survey_page` VALUES ('457', '694');
INSERT INTO `survey_page` VALUES ('457', '695');
INSERT INTO `survey_page` VALUES ('457', '696');
INSERT INTO `survey_page` VALUES ('457', '697');
INSERT INTO `survey_page` VALUES ('457', '698');
INSERT INTO `survey_page` VALUES ('457', '699');
INSERT INTO `survey_page` VALUES ('457', '700');
INSERT INTO `survey_page` VALUES ('457', '701');
INSERT INTO `survey_page` VALUES ('458', '705');
INSERT INTO `survey_page` VALUES ('358', '709');
INSERT INTO `survey_page` VALUES ('411', '1276');
INSERT INTO `survey_page` VALUES ('411', '1325');
INSERT INTO `survey_page` VALUES ('458', '1332');
INSERT INTO `survey_page` VALUES ('458', '1333');
INSERT INTO `survey_page` VALUES ('1464', '1576');
INSERT INTO `survey_page` VALUES ('1464', '1577');
INSERT INTO `survey_page` VALUES ('1464', '1578');
INSERT INTO `survey_page` VALUES ('1464', '1579');

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
