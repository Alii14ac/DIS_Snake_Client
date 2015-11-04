-- phpMyAdmin SQL Dump
-- version 4.3.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 15, 2015 at 09:48 PM
-- Server version: 5.6.22
-- PHP Version: 5.5.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

use SnakeDB;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `DBCon`
--

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE IF NOT EXISTS `games` (
  `id` bigint(20) NOT NULL,
  `host` bigint(20) DEFAULT NULL,
  `opponent` bigint(20) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `winner` bigint(20) DEFAULT NULL,
  `host_controls` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `opponent_controls` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `map_size` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`id`, `host`, `opponent`, `name`, `status`, `created`, `winner`, `host_controls`, `opponent_controls`, `map_size`) VALUES
(1, NULL, NULL, 'first_game', 'deleted', '2015-10-15 15:07:52', 0, 'sadasas', NULL, 0),
(2, 1, 2, 'jannik', 'pending', '2015-10-15 12:51:28', 1, 'sasdww', 'ssaawd', 0),
(3, NULL, NULL, 'first_game', 'deleted', '2015-10-15 15:26:24', 0, 'sadasas', NULL, 0),
(4, 22, 33, 'first_game', 'deleted', '2015-10-15 19:07:45', NULL, 'sadasas', NULL, NULL),
(5, 22, 33, 'first_game', 'deleted', '2015-10-15 19:08:48', NULL, 'sadasas', NULL, NULL),
(6, 22, 33, 'first_game', 'deleted', '2015-10-15 19:14:04', NULL, 'sadasas', NULL, NULL),
(7, 22, 33, 'first_game', 'deleted', '2015-10-15 19:17:09', NULL, 'sadasas', NULL, NULL),
(8, 22, 33, 'first_game', 'deleted', '2015-10-15 19:17:13', NULL, 'sadasas', NULL, NULL),
(9, 22, 33, 'first_game', 'deleted', '2015-10-15 19:36:24', NULL, 'sadasas', NULL, NULL),
(10, 22, 33, 'first_game', 'deleted', '2015-10-15 19:36:50', NULL, 'sadasas', NULL, NULL),
(11, 22, 33, 'Janniks loserGame', 'pending', '2015-10-15 20:42:47', NULL, 'asdw', NULL, NULL),
(12, 22, 33, 'Janniks loserGame', 'pending', '2015-10-15 20:43:19', NULL, 'asdw', NULL, NULL),
(13, 22, 33, 'Janniks loserGame', 'pending', '2015-10-15 20:44:04', NULL, 'asdw', NULL, NULL),
(14, 22, 33, 'Janniks loserGame', 'Finished', '2015-10-15 20:44:22', 1, 'asdw', 'asa', NULL),
(15, 22, 33, 'Janniks loserGame', 'Finished', '2015-10-15 20:44:45', 1, 'asdw', 'asa', NULL),
(16, 22, 33, 'Janniks loserGame', 'Finished', '2015-10-15 20:44:45', NULL, 'asdw', NULL, NULL),
(17, 22, 33, 'Henrik Thorns Snake game', 'Finished', '2015-10-15 20:46:46', 1, 'asasa', 'sss', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE IF NOT EXISTS `scores` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `opponent_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`id`, `user_id`, `game_id`, `score`, `opponent_id`) VALUES
(1, 2, 3, 33, 0),
(2, 2, 3, 33, 0),
(3, 0, 3, 33, 0),
(4, 1, 15, 66, 2),
(5, 2, 15, 45, 1),
(6, 1, 17, 66, 2),
(7, 2, 17, 45, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

use SnakeDB;

drop TABLE users;

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `created`, `status`, `type`) VALUES
(1, 'Tobias', 'Oestergaard', 'nioe14af@student.cbs.dk', 'Neric123', '123', '2015-10-15 14:13:22', 'active', NULL),
(2, 'Charlotte', 'Heinrichtsen', 'charhein@jubii.dk', 'HeinHero', '321', '2015-10-15 08:39:37', 'active', NULL),
(3, 'Tobias', 'Oestergaard', 'nioe14af@student.cbs.dk', 'Neric123', '123', '2015-10-14 22:00:00', 'active', NULL),
(4, 'Tobias', 'Oestergaard', 'nioe14af@student.cbs.dk', 'Neric123', '123', '2015-10-15 19:36:50', 'deleted', NULL),
(5, 'Tobias', 'Oestergaard', 'nioe14af@student.cbs.dk', 'Neric123', '123', '2015-10-15 19:36:24', 'deleted', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `games`
--
ALTER TABLE `games`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
