-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2019 at 04:19 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AFC_System`
--

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `id` varchar(16) NOT NULL,
  `released_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `balance` float NOT NULL,
  `owner_id` varchar(16) NOT NULL DEFAULT '1234567890abcdef',
  `last_pass` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `released_time`, `balance`, `owner_id`, `last_pass`) VALUES
('9ac2197d9258257b', '2019-11-29 15:15:50', 55.3, 't93o5qqw90az7d2f', 0),
('testcard00000000', '2019-11-29 13:41:10', 10, 'testcard00000000', 0);

-- --------------------------------------------------------

--
-- Table structure for table `list_ticket`
--

CREATE TABLE `list_ticket` (
  `id` varchar(16) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `list_ticket`
--

INSERT INTO `list_ticket` (`id`, `type`) VALUES
('testticket24h000', 'ticket24h'),
('e8dc4081b13434b4', 'ticketoneway'),
('testticketoneway', 'ticketoneway'),
('bab1246b02772bb0', 'ticket24h');

-- --------------------------------------------------------

--
-- Table structure for table `passing_history`
--

CREATE TABLE `passing_history` (
  `pass_id` int(11) NOT NULL,
  `id` varchar(16) NOT NULL,
  `getin_point` varchar(1) NOT NULL,
  `getout_point` varchar(1) DEFAULT NULL,
  `pass_status` int(4) NOT NULL,
  `fare` float DEFAULT NULL,
  `getin_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `getout_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passing_history`
--

INSERT INTO `passing_history` (`pass_id`, `id`, `getin_point`, `getout_point`, `pass_status`, `fare`, `getin_time`, `getout_time`) VALUES
(0, 'testpasshistory0', 'a', 'b', 0, 0, '2019-11-23 17:00:00.000', '2019-11-23 18:00:00.000'),
(10, '9ac2197d9258257b', 'f', 'i', 0, 3.1, '2019-11-24 11:38:32.209', '2019-11-24 11:39:58.031'),
(11, '9ac2197d9258257b', 'b', 'i', 0, 5.9, '2019-11-24 11:47:32.678', '2019-11-24 11:48:16.993'),
(12, '9ac2197d9258257b', 'a', 'i', 0, 6.7, '2019-11-24 11:54:04.778', '2019-11-24 11:54:57.228'),
(13, 'bab1246b02772bb0', 'a', 'i', 0, 0, '2019-11-24 12:33:57.933', '2019-11-24 12:34:36.080'),
(14, 'e8dc4081b13434b4', 'd', 'g', 0, 3.1, '2019-11-24 13:13:30.442', '2019-11-24 13:14:07.366'),
(15, '9ac2197d9258257b', 'b', 'e', 0, 3.1, '2019-11-24 13:18:52.416', '2019-11-24 13:19:03.272'),
(16, '9ac2197d9258257b', 'a', 'i', 0, 6.7, '2019-11-24 14:38:42.667', '2019-11-24 14:38:57.850'),
(17, 'bab1246b02772bb0', 'c', 'h', 0, 0, '2019-11-24 14:40:01.133', '2019-11-24 14:40:12.123'),
(18, 'e8dc4081b13434b4', 'e', 'g', 0, 2.3, '2019-11-24 14:41:15.280', '2019-11-24 14:41:25.746'),
(19, '07c84c6c4ba59f88', 'a', 'i', 0, 0, '2019-11-24 14:54:39.661', '2019-11-24 14:54:56.645'),
(20, '9ac2197d9258257b', 'b', 'h', 0, 5.1, '2019-11-25 02:12:25.936', '2019-11-25 02:13:46.431'),
(21, '9ac2197d9258257b', 'a', 'G', 0, 5.5, '2019-11-25 03:50:19.791', '2019-11-25 03:51:46.532'),
(22, '9ac2197d9258257b', 'd', NULL, 1, 0, '2019-11-25 04:31:33.176', NULL),
(23, '9ac2197d9258257b', 'd', NULL, 1, 0, '2019-11-25 04:33:16.984', NULL),
(24, '9ac2197d9258257b', 'e', 'i', 0, 3.5, '2019-11-25 04:36:24.122', '2019-11-25 04:36:45.403'),
(25, '9ac2197d9258257b', 'a', NULL, 1, 0, '2019-11-25 04:37:51.615', NULL),
(26, '9ac2197d9258257b', 'a', 'h', 0, 6.3, '2019-11-25 05:39:21.617', '2019-11-25 05:43:04.833'),
(27, '9ac2197d9258257b', 'a', NULL, 1, 0, '2019-11-29 09:08:45.249', NULL),
(28, '9ac2197d9258257b', 'a', 'f', 0, 4.7, '2019-11-29 15:15:26.539', '2019-11-29 15:15:50.852');

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE `station` (
  `station_id` varchar(1) NOT NULL,
  `st_name` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`station_id`, `st_name`) VALUES
('a', 'Saint-Lazare'),
('b', 'Madeleine'),
('c', 'Pyramides'),
('d', 'Chatelet'),
('e', 'Gare de Lyon'),
('f', 'Bercy'),
('g', 'Cour Saint-Emilion'),
('h', 'Bibliotheque Francois Mitterrand'),
('i', 'Olympiades');

-- --------------------------------------------------------

--
-- Table structure for table `station_distance`
--

CREATE TABLE `station_distance` (
  `station_id1` varchar(1) NOT NULL,
  `station_id2` varchar(1) NOT NULL,
  `distance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `station_distance`
--

INSERT INTO `station_distance` (`station_id1`, `station_id2`, `distance`) VALUES
('a', 'a', 0),
('a', 'b', 5),
('a', 'c', 8.5),
('a', 'd', 11.3),
('a', 'e', 15.8),
('a', 'f', 18.9),
('a', 'g', 22),
('a', 'h', 25.3),
('a', 'i', 28.8);

-- --------------------------------------------------------

--
-- Table structure for table `ticket24h`
--

CREATE TABLE `ticket24h` (
  `id` varchar(16) NOT NULL,
  `released_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `first_use` datetime DEFAULT NULL,
  `valid_time` timestamp NULL DEFAULT NULL,
  `price` float NOT NULL DEFAULT '8.5',
  `last_pass` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket24h`
--

INSERT INTO `ticket24h` (`id`, `released_time`, `first_use`, `valid_time`, `price`, `last_pass`) VALUES
('bab1246b02772bb0', '2019-11-24 14:40:12', '2019-11-24 20:00:00', '2019-11-25 13:00:00', 8.5, 0),
('testticket24h000', '2019-11-29 14:52:13', '2019-11-10 00:00:00', '2019-11-10 17:00:00', 8.5, 0);

--
-- Triggers `ticket24h`
--
DELIMITER $$
CREATE TRIGGER `delete_24h_trigger` BEFORE DELETE ON `ticket24h` FOR EACH ROW DELETE FROM list_ticket
WHERE id = old.id
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_into_listticket` AFTER INSERT ON `ticket24h` FOR EACH ROW INSERT INTO list_ticket
VALUES (NEW.id,"ticket24h")
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_lt24h_trigger` AFTER UPDATE ON `ticket24h` FOR EACH ROW UPDATE list_ticket
SET id = new.id
WHERE id = old.id
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ticket_oneway`
--

CREATE TABLE `ticket_oneway` (
  `id` varchar(16) NOT NULL,
  `released_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `price` float NOT NULL,
  `start_station` varchar(1) NOT NULL,
  `exit_station` varchar(1) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_oneway`
--

INSERT INTO `ticket_oneway` (`id`, `released_time`, `price`, `start_station`, `exit_station`, `status`) VALUES
('e8dc4081b13434b4', '2019-11-24 14:41:25', 5.6, 'd', 'i', 0),
('testticketoneway', '2019-11-29 15:00:18', 10, 'a', 'h', 0);

--
-- Triggers `ticket_oneway`
--
DELIMITER $$
CREATE TRIGGER `delete_1w_trigger` AFTER DELETE ON `ticket_oneway` FOR EACH ROW DELETE FROM list_ticket
WHERE id = old.id
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_into_listticket2` AFTER INSERT ON `ticket_oneway` FOR EACH ROW INSERT INTO list_ticket
VALUES (NEW.id,"ticketoneway")
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_1w_trigger` BEFORE UPDATE ON `ticket_oneway` FOR EACH ROW UPDATE list_ticket
SET id = new.id
WHERE id = old.id
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passing_history`
--
ALTER TABLE `passing_history`
  ADD PRIMARY KEY (`pass_id`),
  ADD KEY `foreign-con1` (`id`),
  ADD KEY `foreign_station1` (`getin_point`),
  ADD KEY `foreign_station2` (`getout_point`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`);

--
-- Indexes for table `station_distance`
--
ALTER TABLE `station_distance`
  ADD PRIMARY KEY (`station_id1`,`station_id2`),
  ADD KEY `foreign_dis2` (`station_id2`);

--
-- Indexes for table `ticket24h`
--
ALTER TABLE `ticket24h`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket_oneway`
--
ALTER TABLE `ticket_oneway`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreign_st1` (`start_station`),
  ADD KEY `foreign_st2` (`exit_station`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `passing_history`
--
ALTER TABLE `passing_history`
  MODIFY `pass_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `passing_history`
--
ALTER TABLE `passing_history`
  ADD CONSTRAINT `foreign_station1` FOREIGN KEY (`getin_point`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `foreign_station2` FOREIGN KEY (`getout_point`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE;

--
-- Constraints for table `station_distance`
--
ALTER TABLE `station_distance`
  ADD CONSTRAINT `foreign_dis1` FOREIGN KEY (`station_id1`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `foreign_dis2` FOREIGN KEY (`station_id2`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE;

--
-- Constraints for table `ticket_oneway`
--
ALTER TABLE `ticket_oneway`
  ADD CONSTRAINT `foreign_st1` FOREIGN KEY (`start_station`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `foreign_st2` FOREIGN KEY (`exit_station`) REFERENCES `station` (`station_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
