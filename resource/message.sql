-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018 年 4 朁E30 日 11:56
-- サーバのバージョン： 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `1722212`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `message`
--

CREATE TABLE `message` (
  `INCIDENT_NUMBER` varchar(100) NOT NULL COMMENT 'インシデント番号',
  `STATUS` varchar(100) NOT NULL COMMENT 'ステータス',
  `CHERGER` varchar(100) NOT NULL COMMENT '担当者',
  `INCIDENT_DATE` varchar(100) NOT NULL COMMENT '発生日/報告受領日',
  `DAY` varchar(100) NOT NULL COMMENT '曜日',
  `DETAIL` varchar(2000) NOT NULL COMMENT '詳細内容',
  `TEC_ALERT` varchar(100) NOT NULL COMMENT 'TEC通知',
  `INCIDENT_TIME` varchar(100) NOT NULL COMMENT '発生時刻',
  `NODE_NAME` varchar(100) NOT NULL COMMENT '発生ノード/系列',
  `PRODUCT_NAME` varchar(100) NOT NULL COMMENT 'プロダクト/モジュール名',
  `CONTENT` varchar(2000) NOT NULL COMMENT '初動対応',
  `CONFIRM_RESULT` varchar(100) NOT NULL COMMENT '稼働確認結果',
  `TRANSACTION_CONFIRM` varchar(100) NOT NULL COMMENT '取引確認',
  `USER_HARMRESS` varchar(100) NOT NULL COMMENT 'ユーザ影響有無',
  `HW_ERROR` varchar(100) NOT NULL COMMENT 'HWエラー有無',
  `CAUSE` varchar(2000) NOT NULL COMMENT '原因/トレース状況',
  `RECOVER_TIME` varchar(100) NOT NULL COMMENT '復旧確認時刻',
  `COVER_CONTENT` varchar(2000) NOT NULL COMMENT '暫定対応',
  `REPORT_FOR_RUN` varchar(2000) NOT NULL COMMENT '運用向け報告',
  `COVER_PLAN` varchar(2000) NOT NULL COMMENT '本格対応',
  `COVER_PLAN_DATE` varchar(100) NOT NULL COMMENT '対応予定日'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `message`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD UNIQUE KEY `INCIDENT_NUMBER` (`INCIDENT_NUMBER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

/*
接続文字列　jdbc:mysql://localhost:3307/yuki?characterEncoding=UTF-8&serverTimezone=JST
*/
