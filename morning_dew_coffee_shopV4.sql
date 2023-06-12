-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 03, 2023 at 06:42 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `morning_dew_coffee_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ID_pelanggan` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tipe` enum('admin','user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ID_pelanggan`, `nama`, `username`, `password`, `tipe`) VALUES
(2, 'admin2', 'admin1', 'admin', 'admin'),
(4, 'Taffan', 'tfn', '123', 'user'),
(5, 'Mario', 'Yahoo', 'garnett', 'user'),
(6, 'frenk', 'ocean', 'blond', 'user'),
(8, 'Lincoln', 'abe', 'confederate', 'user'),
(9, 'Muhammad Rizqi', 'taffan', '152021124', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `ID_feedback` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `feedback` varchar(300) NOT NULL,
  `address` varchar(100) NOT NULL,
  `handphone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`ID_feedback`, `name`, `feedback`, `address`, `handphone`) VALUES
(3, 'taffan', 'nice', 'Jln. Garut', '08334123'),
(5, 'ocean', 'nice cafe', 'Jln. Garut', '9892932'),
(8, 'Frank', 'Nice ambience', 'Jln. Siu', '98992332'),
(9, 'Taffan', 'Add more spicyy', 'Jln. ss', '2993333');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `ID_menu` int(5) NOT NULL,
  `nama_menu` varchar(30) NOT NULL,
  `harga` int(50) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`ID_menu`, `nama_menu`, `harga`, `stok`) VALUES
(3, 'Americano', 20000, 34),
(4, 'Cappucino', 26000, 24),
(5, 'Dew Kuasong', 30000, 56),
(6, 'Mocha', 30000, 12),
(7, 'Bread', 12000, 30),
(8, 'Cheesecake', 26000, 21);

-- --------------------------------------------------------

--
-- Table structure for table `order_acc`
--

CREATE TABLE `order_acc` (
  `ID_order` int(11) NOT NULL,
  `ID_pelanggan` int(11) NOT NULL,
  `order_detail` varchar(100) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_acc`
--

INSERT INTO `order_acc` (`ID_order`, `ID_pelanggan`, `order_detail`, `total`) VALUES
(1, 5, 'Americano Qty: 3', 60000),
(8, 4, 'Dew Kuasong - Quantity: 1, Americano - Quantity: 2', 70000),
(9, 6, 'Bread - Quantity: 1, Cafe Latte - Quantity: 1', 12000),
(10, 6, 'Dew Kuasong - Quantity: 1, None - Quantity: 1', 30000),
(11, 4, 'None - Quantity: 1, Cappucino - Quantity: 1', 26000),
(12, 6, 'Dew Kuasong - Quantity: 1, Americano - Quantity: 1', 50000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID_pelanggan`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`ID_feedback`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ID_menu`);

--
-- Indexes for table `order_acc`
--
ALTER TABLE `order_acc`
  ADD PRIMARY KEY (`ID_order`),
  ADD KEY `fk_order_account` (`ID_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ID_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `ID_feedback` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `ID_menu` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `order_acc`
--
ALTER TABLE `order_acc`
  MODIFY `ID_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_acc`
--
ALTER TABLE `order_acc`
  ADD CONSTRAINT `fk_order_account` FOREIGN KEY (`ID_pelanggan`) REFERENCES `account` (`ID_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
