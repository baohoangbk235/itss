-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2019 at 02:22 PM
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
  `last_pass` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `released_time`, `balance`, `owner_id`, `last_pass`) VALUES
('9ac2197d9258257b', '2019-11-24 13:19:03', 87.1, 't93o5qqw90az7d2f', 0),
('cv34567er0abcdef', '2019-11-13 22:58:53', 12, '1234567890abcdef', 0),
('mvght67er0abc336', '2019-11-13 18:41:47', 90, '1234567890abcdef', 0);

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
(1, '9ac2197d9258257b', 'c', 'd', 0, 1.9, '2019-11-24 01:50:28.000', '2019-11-24 01:53:39.000'),
(10, '9ac2197d9258257b', 'f', 'i', 0, 3.1, '2019-11-24 11:38:32.209', '2019-11-24 11:39:58.031'),
(11, '9ac2197d9258257b', 'b', 'i', 0, 5.9, '2019-11-24 11:47:32.678', '2019-11-24 11:48:16.993'),
(12, '9ac2197d9258257b', 'a', 'i', 0, 6.7, '2019-11-24 11:54:04.778', '2019-11-24 11:54:57.228'),
(13, 'bab1246b02772bb0', 'a', 'i', 0, 0, '2019-11-24 12:33:57.933', '2019-11-24 12:34:36.080'),
(14, 'e8dc4081b13434b4', 'd', 'g', 0, 3.1, '2019-11-24 13:13:30.442', '2019-11-24 13:14:07.366'),
(15, '9ac2197d9258257b', 'b', 'e', 0, 3.1, '2019-11-24 13:18:52.416', '2019-11-24 13:19:03.272');

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
  `last_pass` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket24h`
--

INSERT INTO `ticket24h` (`id`, `released_time`, `first_use`, `valid_time`, `price`, `last_pass`) VALUES
('07c84c6c4ba59f88', '2019-11-15 17:40:38', NULL, NULL, 8.5, 0),
('7sad4ew3242sdf49', '2019-11-12 17:06:13', NULL, NULL, 8.5, 0),
('asadaew3242sdf4c', '2019-11-15 17:44:25', NULL, NULL, 8.5, 0),
('bab1246b02772bb0', '2019-11-24 12:34:36', '2019-11-24 07:12:00', '2019-11-25 00:12:00', 8.5, 0);

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
('e8dc4081b13434b4', '2019-11-24 13:14:07', 3.42, 'd', 'i', 0),
('g23de46k2k70xdw7', '2019-11-15 17:30:32', 2.5, 'c', 'g', 1);

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
  MODIFY `pass_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

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
