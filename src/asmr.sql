-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2021 at 07:25 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asmr`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `ItemID` int(11) NOT NULL,
  `ItemName` varchar(50) NOT NULL,
  `ItemPrice` int(11) NOT NULL,
  `ItemQty` int(11) NOT NULL,
  `SupplierID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`ItemID`, `ItemName`, `ItemPrice`, `ItemQty`, `SupplierID`) VALUES
(11, 'iphone', 1, 992, 8),
(12, 'note 10', 1221, 982, 7),
(13, 'IPhoneX', 213314, 12224, 8);

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

CREATE TABLE `personnel` (
  `PersonnelID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Position` set('admin','not admin') NOT NULL DEFAULT 'not admin',
  `PhoneNo` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`PersonnelID`, `FirstName`, `LastName`, `Position`, `PhoneNo`, `Email`, `Salary`, `Username`, `Password`) VALUES
(7, 'Stanlly', 'Henrietta', 'admin', '12341241', 'stan@gmail.com', 131342141, 'Stan', '827ccbeea8a706c4c34a16891f84e7b'),
(9, 'Mika', 'Mahaputra', 'admin', '1231141', NULL, 117000, 'Mika', '3fe99cf6a78f5a396ce8f48dade9b23'),
(10, 'Gadtardi', 'Wongkaren', 'admin', NULL, NULL, 2341143, 'IndoG117', '964d72e72d53d501f2949969849b96c'),
(11, 'Generic', 'Staff', 'admin', '08123414141', 'generic@gmail.com', 2134141, 'Staff', '1253208465b1efa876f982d8a9e73eef'),
(14, 'test213', NULL, 'not admin', NULL, NULL, 1231414, 'test123', '4cf0f33516b8276d758a9a7274737417'),
(16, 'Test', 'Staff', 'not admin', '09841948101', 'testmail@gmail.com', 123414, 'test', '98f6bcd4621d373cade4e832627b4f6');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `PurchaseID` int(11) NOT NULL,
  `TransactionID` int(11) NOT NULL,
  `ItemID` int(11) NOT NULL,
  `ItemPriceAtSale` int(11) NOT NULL,
  `PurchaseQty` int(11) NOT NULL,
  `Subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`PurchaseID`, `TransactionID`, `ItemID`, `ItemPriceAtSale`, `PurchaseQty`, `Subtotal`) VALUES
(33, 2, 6, 12121, 1, 12121),
(34, 2, 3, 9999999, 3, 29999997),
(35, 2, 7, 21313, 4, 85252),
(44, 9, 11, 1, 1, 1),
(45, 10, 12, 1221, 1, 1221),
(48, 15, 12, 1221, 1, 1221),
(51, 19, 11, 1, 3, 3),
(52, 19, 12, 1221, 5, 6105),
(53, 20, 12, 1221, 5, 6105),
(57, 26, 12, 1221, 10, 12210),
(58, 26, 12, 1221, 7, 8547),
(59, 27, 13, 213314, 7, 1493198);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(11) NOT NULL,
  `SupplierName` varchar(50) NOT NULL,
  `PhoneNo` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `PhoneNo`, `Email`) VALUES
(7, 'Samsung', '1231413', 'sam@sung.com'),
(8, 'Apple', '1233141', 'Oranges@apple.co.id'),
(9, 'Oppo', '21314144', 'oppssso@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `TransactionID` int(11) NOT NULL,
  `PersonnelID` int(11) NOT NULL,
  `PersonnelName` varchar(50) NOT NULL,
  `Total` int(11) NOT NULL,
  `Date_Time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`TransactionID`, `PersonnelID`, `PersonnelName`, `Total`, `Date_Time`) VALUES
(1, 1, 'Stan', 0, '2021-01-06 18:01:12'),
(2, 3, 's1', 30097370, '2021-01-06 18:04:47'),
(9, 8, 'Gadtardi', 1, '2021-01-07 00:04:47'),
(10, 7, 'Stanlly', 1221, '2021-01-07 00:05:51'),
(12, 7, 'Stanlly', 18335, '2021-01-07 00:39:29'),
(13, 7, 'Stanlly', 129431, '2021-01-07 00:47:27'),
(14, 7, 'Stanlly', 129431, '2021-01-07 00:47:33'),
(15, 7, 'Stanlly', 1221, '2021-01-07 00:50:51'),
(16, 7, 'Stanlly', 7329, '2021-01-07 00:51:05'),
(17, 7, 'Stanlly', 18332, '2021-01-07 01:00:28'),
(18, 7, 'Stanlly', 18332, '2021-01-07 01:00:44'),
(19, 7, 'Stanlly', 6108, '2021-01-07 01:01:42'),
(20, 7, 'Stanlly', 6105, '2021-01-07 01:01:54'),
(21, 7, 'Stanlly', 10993, '2021-01-07 01:02:08'),
(22, 7, 'Stanlly', 17, '2021-01-07 01:07:33'),
(23, 7, 'Stanlly', 1222, '2021-01-07 01:08:48'),
(24, 7, 'Stanlly', 1225, '2021-01-07 01:09:19'),
(25, 7, 'Stanlly', 4889, '2021-01-07 01:10:57'),
(26, 7, 'Stanlly', 20757, '2021-01-07 01:13:14'),
(27, 16, 'Test', 1493198, '2021-01-07 01:15:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`ItemID`),
  ADD KEY `ItemID` (`ItemID`),
  ADD KEY `SupplierID` (`SupplierID`);

--
-- Indexes for table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`PersonnelID`),
  ADD KEY `PersonnelID` (`PersonnelID`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`PurchaseID`),
  ADD KEY `PurchaseID` (`PurchaseID`),
  ADD KEY `TransactionID` (`TransactionID`),
  ADD KEY `ItemID` (`ItemID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`),
  ADD KEY `SupplierID` (`SupplierID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `TransactionID` (`TransactionID`),
  ADD KEY `PersonnelID` (`PersonnelID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `ItemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `PersonnelID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `PurchaseID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupplierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `TransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`TransactionID`) REFERENCES `transaction` (`TransactionID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
