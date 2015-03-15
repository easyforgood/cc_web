-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 219.219.220.200
-- Generation Time: 2015-03-15 09:03:06
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cc`
--

-- --------------------------------------------------------

--
-- 表的结构 `Academy`
--

CREATE TABLE IF NOT EXISTS `Academy` (
  `Academy_Id` int(11) NOT NULL,
  `Academy_Name` char(40) DEFAULT NULL,
  PRIMARY KEY (`Academy_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ñ§ÔºÐÅÏ¢';

--
-- 转存表中的数据 `Academy`
--

INSERT INTO `Academy` (`Academy_Id`, `Academy_Name`) VALUES
(1, '计算机科学与技术学院'),
(2, '生命科学学院'),
(3, '商学院'),
(4, '理学院'),
(5, '电子信息学院');

-- --------------------------------------------------------

--
-- 表的结构 `Administrator`
--

CREATE TABLE IF NOT EXISTS `Administrator` (
  `Admin_Name` char(20) DEFAULT NULL,
  `Admin_Password` char(15) DEFAULT NULL,
  `IsSuper` tinyint(4) DEFAULT NULL,
  `Admin_Email` char(30) NOT NULL,
  `Login_Times` int(11) DEFAULT NULL,
  `Log_First_Date_Time` datetime DEFAULT NULL,
  `Login_Total_Time` float DEFAULT NULL,
  PRIMARY KEY (`Admin_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='¹ÜÀíÔ±µÇÂ½Ê±ºòµÄÑéÖ¤ÐÅÏ¢';

--
-- 转存表中的数据 `Administrator`
--

INSERT INTO `Administrator` (`Admin_Name`, `Admin_Password`, `IsSuper`, `Admin_Email`, `Login_Times`, `Log_First_Date_Time`, `Login_Total_Time`) VALUES
('CH', '111', 1, '1206634956@qq.com', NULL, NULL, NULL),
('YXX', '222', 1, 'yxx@qq.com', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `Administrator_Authority`
--

CREATE TABLE IF NOT EXISTS `Administrator_Authority` (
  `Authority_Id` int(11) NOT NULL,
  `Admin_Email` char(30) NOT NULL,
  PRIMARY KEY (`Authority_Id`,`Admin_Email`),
  KEY `FK_Administrator_Authority` (`Admin_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Administrator_Authority`
--

INSERT INTO `Administrator_Authority` (`Authority_Id`, `Admin_Email`) VALUES
(1, '1206634956@qq.com'),
(2, '1206634956@qq.com'),
(3, '1206634956@qq.com'),
(4, '1206634956@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `Authority`
--

CREATE TABLE IF NOT EXISTS `Authority` (
  `Authority_Id` int(11) NOT NULL,
  `Authority_Name` char(20) DEFAULT NULL,
  PRIMARY KEY (`Authority_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='È¨ÏÞ±í';

--
-- 转存表中的数据 `Authority`
--

INSERT INTO `Authority` (`Authority_Id`, `Authority_Name`) VALUES
(1, '增加'),
(2, '删除'),
(3, '修改'),
(4, '查询');

-- --------------------------------------------------------

--
-- 表的结构 `Class`
--

CREATE TABLE IF NOT EXISTS `Class` (
  `Class_Id` int(11) NOT NULL,
  `Class_place` text,
  PRIMARY KEY (`Class_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Class`
--

INSERT INTO `Class` (`Class_Id`, `Class_place`) VALUES
(1, '1'),
(2, '1'),
(3, '4'),
(4, '2'),
(5, '6');

-- --------------------------------------------------------

--
-- 表的结构 `Course`
--

CREATE TABLE IF NOT EXISTS `Course` (
  `Course_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Course_Name` char(20) DEFAULT NULL,
  `Course_Term` char(15) DEFAULT NULL,
  `Course_Info` text,
  `Course_Year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Course_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='¿Î³Ì±íÏêÏ¸ÐÅÏ¢' AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `Course`
--

INSERT INTO `Course` (`Course_Id`, `Course_Name`, `Course_Term`, `Course_Info`, `Course_Year`) VALUES
(1, '高等数学', '2014.1', NULL, ''),
(2, 'C++', '2014.2', NULL, ''),
(3, '操作系统', '2014.2', NULL, '');

-- --------------------------------------------------------

--
-- 表的结构 `Course_Class`
--

CREATE TABLE IF NOT EXISTS `Course_Class` (
  `Course_Id` int(11) NOT NULL,
  `Class_Id` int(11) NOT NULL,
  PRIMARY KEY (`Course_Id`,`Class_Id`),
  KEY `FK_Course_Class` (`Class_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Course_Class`
--

INSERT INTO `Course_Class` (`Course_Id`, `Class_Id`) VALUES
(1, 1),
(3, 1),
(2, 2),
(2, 4),
(3, 5);

-- --------------------------------------------------------

--
-- 表的结构 `Course_Teacher`
--

CREATE TABLE IF NOT EXISTS `Course_Teacher` (
  `Course_Id` int(11) NOT NULL,
  `Teacher_Id` int(11) NOT NULL,
  PRIMARY KEY (`Course_Id`,`Teacher_Id`),
  KEY `FK_Course_Teacher1` (`Teacher_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Course_Teacher`
--

INSERT INTO `Course_Teacher` (`Course_Id`, `Teacher_Id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- 表的结构 `Course_Time`
--

CREATE TABLE IF NOT EXISTS `Course_Time` (
  `Course_Id` int(10) unsigned NOT NULL,
  `Time_id` int(10) unsigned NOT NULL,
  `Class_Id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `File`
--

CREATE TABLE IF NOT EXISTS `File` (
  `File_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Course_Id` int(11) DEFAULT NULL,
  `File_Name` char(100) DEFAULT NULL,
  `File_Size` int(11) DEFAULT NULL,
  `File_Path` text,
  `File_DateTime` datetime DEFAULT NULL,
  `File_Type` char(4) DEFAULT NULL,
  `FileComment` text,
  `File_tag` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`File_Id`),
  KEY `FK_Course_File` (`Course_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='×ÊÁÏ' AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `File`
--

INSERT INTO `File` (`File_Id`, `Course_Id`, `File_Name`, `File_Size`, `File_Path`, `File_DateTime`, `File_Type`, `FileComment`, `File_tag`) VALUES
(1, 2, '嵌入式', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(2, 1, 'linux', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(3, 2, 'java', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(4, 3, 'C', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(5, 3, 'C++', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(6, 3, 'C#', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(7, 3, '.Net', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(8, 2, 'Python', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(9, 2, 'Dos', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(10, 1, 'Ubuntu', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(11, 1, '123', 11, '11', '0000-00-00 00:00:00', 'pdf', '11', 0),
(12, 1, 'javaee', 11, '11', '0000-00-00 00:00:00', 'pdf', '1', 0);

-- --------------------------------------------------------

--
-- 表的结构 `LOG`
--

CREATE TABLE IF NOT EXISTS `LOG` (
  `Log_Id` int(11) NOT NULL,
  `Admin_Email` char(30) DEFAULT NULL,
  `User_Email` char(30) DEFAULT NULL,
  `Log_Information` text,
  `Log_Type` tinyint(4) DEFAULT NULL,
  `Log_DateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Log_Id`),
  KEY `FK_Administrator_Log` (`Admin_Email`),
  KEY `FK_User_Log` (`User_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='¶ÏµãÐø´«µÄ¼ÇÂ¼,ÏµÍ³ºÍÓÃ»§µÄÐÐÎª¼ÇÂ¼\n¼ÇÂ¼ÓÃ»§µÄ»îÔ¾ÆµÂÊ£¨±¾ÔÂµÇÂ½´ÎÊý,×îÐÂµÇÂ½Ê±¼ä£©\n\n                        -&';

-- --------------------------------------------------------

--
-- 表的结构 `Order`
--

CREATE TABLE IF NOT EXISTS `Order` (
  `Order_Id` int(11) NOT NULL,
  `Order_Type` tinyint(4) DEFAULT NULL,
  `Order_Time` datetime DEFAULT NULL,
  `Order_Note` text,
  `Order_Money` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`Order_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Order`
--

INSERT INTO `Order` (`Order_Id`, `Order_Type`, `Order_Time`, `Order_Note`, `Order_Money`) VALUES
(1, 1, '2014-08-09 00:00:00', NULL, '10');

-- --------------------------------------------------------

--
-- 表的结构 `School`
--

CREATE TABLE IF NOT EXISTS `School` (
  `School_Id` int(11) NOT NULL,
  `School_Name` char(20) DEFAULT NULL,
  `School_X` decimal(2,0) DEFAULT NULL,
  `School_Y` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`School_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ñ§Ð£ÐÅÏ¢\n¾­Î³¶È×ø±ê';

--
-- 转存表中的数据 `School`
--

INSERT INTO `School` (`School_Id`, `School_Name`, `School_X`, `School_Y`) VALUES
(1, '中国科学技术大学', NULL, NULL),
(2, '清华大学', NULL, NULL),
(3, '北京大学', NULL, NULL),
(4, '人民大学', NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `School_Academy`
--

CREATE TABLE IF NOT EXISTS `School_Academy` (
  `School_Id` int(11) NOT NULL,
  `Academy_Id` int(11) NOT NULL,
  PRIMARY KEY (`School_Id`,`Academy_Id`),
  KEY `fk_School_Academy_2_idx` (`Academy_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `School_Academy`
--

INSERT INTO `School_Academy` (`School_Id`, `Academy_Id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(1, 4),
(2, 4),
(3, 4),
(4, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5);

-- --------------------------------------------------------

--
-- 表的结构 `Special`
--

CREATE TABLE IF NOT EXISTS `Special` (
  `Special_Id` int(11) NOT NULL,
  `Special_Name` char(40) DEFAULT NULL,
  `Academy_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Special_Id`),
  KEY `fk_Special_1_idx` (`Academy_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='×¨ÒµÐÅÏ¢';

--
-- 转存表中的数据 `Special`
--

INSERT INTO `Special` (`Special_Id`, `Special_Name`, `Academy_Id`) VALUES
(1, '软件工程', 1),
(2, '网络工程', 1),
(3, '计算机科学与技术', 1),
(4, '生物工程', 2),
(5, '会计工程', 3),
(6, '数学分析', 4),
(7, '电气工程', 5);

-- --------------------------------------------------------

--
-- 表的结构 `Special_Course`
--

CREATE TABLE IF NOT EXISTS `Special_Course` (
  `Special_Id` int(11) NOT NULL,
  `Course_Id` int(11) NOT NULL,
  PRIMARY KEY (`Special_Id`,`Course_Id`),
  KEY `FK_Special_Course` (`Course_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Special_Course`
--

INSERT INTO `Special_Course` (`Special_Id`, `Course_Id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- 表的结构 `Teacher`
--

CREATE TABLE IF NOT EXISTS `Teacher` (
  `Teacher_Id` int(11) NOT NULL,
  `Teacher_Name` char(20) DEFAULT NULL,
  `Teacher_Email` char(30) DEFAULT NULL,
  `Teacher_Phone` char(15) DEFAULT NULL,
  PRIMARY KEY (`Teacher_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Teacher`
--

INSERT INTO `Teacher` (`Teacher_Id`, `Teacher_Name`, `Teacher_Email`, `Teacher_Phone`) VALUES
(1, '张华', 'zhanghua@qq.com', '15853627872'),
(2, '李笑', 'lixiao@qq.com', '15687352200');

-- --------------------------------------------------------

--
-- 表的结构 `UserInformation`
--

CREATE TABLE IF NOT EXISTS `UserInformation` (
  `User_Name` char(20) DEFAULT NULL,
  `User_Password` char(15) DEFAULT NULL,
  `User_Id` int(11) NOT NULL,
  `isActive` tinyint(1) unsigned NOT NULL,
  `User_School` varchar(45) DEFAULT NULL,
  `User_Academy` varchar(45) DEFAULT NULL,
  `User_Special` varchar(45) DEFAULT NULL,
  `User_Credit` int(11) DEFAULT NULL,
  `User_Money` double DEFAULT NULL,
  `User_Pic` varchar(45) DEFAULT NULL,
  `User_Phone` varchar(20) DEFAULT NULL,
  `VIP_Start` datetime DEFAULT NULL,
  `VIP_End` datetime DEFAULT NULL,
  `User_Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `UserInformation`
--

INSERT INTO `UserInformation` (`User_Name`, `User_Password`, `User_Id`, `isActive`, `User_School`, `User_Academy`, `User_Special`, `User_Credit`, `User_Money`, `User_Pic`, `User_Phone`, `VIP_Start`, `VIP_End`, `User_Email`) VALUES
('1', '11', 10002, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '111'),
('aaa', '111111', 10003, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'asdf@163.com'),
('cccccc', '123456', 10005, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'qeddd@qq.com'),
(NULL, NULL, 10006, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10007, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10008, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10009, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10010, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10011, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10012, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10013, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10014, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10015, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10016, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10017, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10018, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10019, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10020, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10021, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10022, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10023, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10024, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10025, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10026, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10027, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10028, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, 10029, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `UserNickName`
--

CREATE TABLE IF NOT EXISTS `UserNickName` (
  `Nick_Id` int(11) NOT NULL,
  `NickName` char(20) DEFAULT NULL,
  PRIMARY KEY (`Nick_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `UserNickName`
--

INSERT INTO `UserNickName` (`Nick_Id`, `NickName`) VALUES
(1, '书童'),
(2, '公子'),
(3, '秀才'),
(4, '书圣');

-- --------------------------------------------------------

--
-- 表的结构 `UserRank`
--

CREATE TABLE IF NOT EXISTS `UserRank` (
  `Rank_Id` int(11) NOT NULL,
  `Rank_Name` char(20) DEFAULT NULL,
  PRIMARY KEY (`Rank_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `UserRank`
--

INSERT INTO `UserRank` (`Rank_Id`, `Rank_Name`) VALUES
(1, '1级'),
(2, '2级'),
(3, '3级');

-- --------------------------------------------------------

--
-- 表的结构 `UserVipTimeInfo`
--

CREATE TABLE IF NOT EXISTS `UserVipTimeInfo` (
  `TimeId` int(11) NOT NULL,
  `TimeStart` datetime DEFAULT NULL,
  `TimeEnd` datetime DEFAULT NULL,
  `VIpLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`TimeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `UserVipTimeInfo`
--

INSERT INTO `UserVipTimeInfo` (`TimeId`, `TimeStart`, `TimeEnd`, `VIpLevel`) VALUES
(1, '2013-09-04 00:00:00', '2014-09-04 00:00:00', 1);

-- --------------------------------------------------------

--
-- 表的结构 `User_Authority`
--

CREATE TABLE IF NOT EXISTS `User_Authority` (
  `Authority_Id` int(11) NOT NULL,
  `User_Email` char(30) NOT NULL,
  PRIMARY KEY (`Authority_Id`,`User_Email`),
  KEY `FK_User_Authority1` (`User_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `User_Authority`
--

INSERT INTO `User_Authority` (`Authority_Id`, `User_Email`) VALUES
(3, '1206634956@qq.com'),
(1, 'yxx@qq.com'),
(2, 'yxx@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `User_Course`
--

CREATE TABLE IF NOT EXISTS `User_Course` (
  `User_Id` char(30) NOT NULL,
  `Course_Id` int(11) NOT NULL,
  KEY `FK_User_Course` (`Course_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `User_Course`
--

INSERT INTO `User_Course` (`User_Id`, `Course_Id`) VALUES
('1206634956@qq.com', 1),
('yxx@qq.com', 2);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `User_Course_information_view`
--
CREATE TABLE IF NOT EXISTS `User_Course_information_view` (
`User_Id` int(11)
,`Course_Name` char(20)
,`Time_Id` int(10) unsigned
,`Teacher_Name` char(20)
,`Class_place` text
,`Course_Info` text
);
-- --------------------------------------------------------

--
-- 表的结构 `User_Course_Table`
--

CREATE TABLE IF NOT EXISTS `User_Course_Table` (
  `Table_Id` int(11) NOT NULL,
  `User_Email` char(30) DEFAULT NULL,
  `Table_Path` text,
  PRIMARY KEY (`Table_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `User_Course_Table`
--

INSERT INTO `User_Course_Table` (`Table_Id`, `User_Email`, `Table_Path`) VALUES
(1, '1206634956@qq.com', NULL),
(2, 'yxx@qq.com', NULL);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `User_view`
--
CREATE TABLE IF NOT EXISTS `User_view` (
`User_id` int(11)
,`User_Name` char(20)
,`User_Password` char(15)
,`User_Email` varchar(45)
,`isActive` tinyint(1) unsigned
);
-- --------------------------------------------------------

--
-- 表的结构 `VipInfo`
--

CREATE TABLE IF NOT EXISTS `VipInfo` (
  `Vip_Id` int(11) NOT NULL,
  `Vip_Money` decimal(10,0) DEFAULT NULL,
  `VIp_Time` float DEFAULT NULL,
  `Vip_Level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Vip_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `VipInfo`
--

INSERT INTO `VipInfo` (`Vip_Id`, `Vip_Money`, `VIp_Time`, `Vip_Level`) VALUES
(1, '10', 1, 1),
(2, '15', 1.5, 2),
(3, '2', 2, 3);

-- --------------------------------------------------------

--
-- 表的结构 `vip_authority`
--

CREATE TABLE IF NOT EXISTS `vip_authority` (
  `Authority_Id` int(11) NOT NULL,
  `Vip_Id` int(11) NOT NULL,
  PRIMARY KEY (`Authority_Id`,`Vip_Id`),
  KEY `FK_vip_authority1` (`Vip_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `vip_authority`
--

INSERT INTO `vip_authority` (`Authority_Id`, `Vip_Id`) VALUES
(1, 1),
(2, 1),
(2, 2),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- 视图结构 `User_Course_information_view`
--
DROP TABLE IF EXISTS `User_Course_information_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`cc`@`%` SQL SECURITY DEFINER VIEW `User_Course_information_view` AS select `UserInformation`.`User_Id` AS `User_Id`,`Course`.`Course_Name` AS `Course_Name`,`Course_Time`.`Time_id` AS `Time_Id`,`Teacher`.`Teacher_Name` AS `Teacher_Name`,`Class`.`Class_place` AS `Class_place`,`Course`.`Course_Info` AS `Course_Info` from (((((((`UserInformation` join `Course`) join `Course_Time`) join `Teacher`) join `Class`) join `User_Course`) join `Course_Class`) join `Course_Teacher`) where ((`UserInformation`.`User_Id` = `User_Course`.`User_Id`) and (`User_Course`.`Course_Id` = `Course`.`Course_Id`) and (`User_Course`.`Course_Id` = `Course_Time`.`Course_Id`) and (`User_Course`.`Course_Id` = `Course_Class`.`Course_Id`) and (`User_Course`.`Course_Id` = `Course_Teacher`.`Course_Id`) and (`Teacher`.`Teacher_Id` = `Course_Teacher`.`Teacher_Id`) and (`Class`.`Class_Id` = `Course_Class`.`Class_Id`));

-- --------------------------------------------------------

--
-- 视图结构 `User_view`
--
DROP TABLE IF EXISTS `User_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`cc`@`%` SQL SECURITY DEFINER VIEW `User_view` AS select `UserInformation`.`User_Id` AS `User_id`,`UserInformation`.`User_Name` AS `User_Name`,`UserInformation`.`User_Password` AS `User_Password`,`UserInformation`.`User_Email` AS `User_Email`,`UserInformation`.`isActive` AS `isActive` from `UserInformation`;

