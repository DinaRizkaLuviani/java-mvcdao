-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2024 at 09:51 AM
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
-- Database: `db_toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` varchar(5) NOT NULL,
  `namaCustomer` varchar(30) DEFAULT NULL,
  `noTelp` varchar(13) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCustomer`, `namaCustomer`, `noTelp`, `alamat`) VALUES
('11111', 'Hana Amirah Natasya', '081236549652', 'Jl. Tamansari 1'),
('11112', 'Safira Aulia', '081569458623', 'Gg. Kanthil'),
('11113', 'Melani ', '084569451235', 'Jl. Kalimasada');

-- --------------------------------------------------------

--
-- Table structure for table `tblpesanan`
--

CREATE TABLE `tblpesanan` (
  `idPesanan` int(5) NOT NULL,
  `tanggal` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `barangPesan` text NOT NULL,
  `totalHarga` varchar(20) NOT NULL,
  `idCustomer` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblpesanan`
--

INSERT INTO `tblpesanan` (`idPesanan`, `tanggal`, `barangPesan`, `totalHarga`, `idCustomer`) VALUES
(1, '2024-05-24 12:00:22', 'Sabun Cair 1 pack, Telur 1Kg, Beras 1 Lt', 'Rp. 55.000', 11111),
(2, '2024-05-25 06:37:48', 'Sabun Mandi 2 Pcs', 'Rp. 20.000', 11112),
(3, '2024-05-27 16:51:34', 'Shampoo Dove 12 Pcs', 'Rp. 6000', 11113);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `id_barang` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` varchar(20) DEFAULT NULL,
  `stok` int(20) DEFAULT NULL,
  `jenis` varchar(50) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`id_barang`, `nama`, `harga`, `stok`, `jenis`, `supplier`) VALUES
('1esf5', 'sdfghjk', 'dfghj', 67, 'dfghj', 'dfghjk'),
('BRJ1', 'SilverQueen', 'Rp. 10.000', 6, 'Makanan', NULL),
('DG534', 'fghjk', 'sdfghj567', 34, 'dtyuik', NULL),
('FG234', 'Sikat Gigi Pepsodent', 'Rp. 4000', 5, 'Alat Rumah Tangga', NULL),
('FGS3', 'Shampoo Dove', 'Rp. 1000', 50, 'Sanitary', NULL),
('GFR45', 'Sabun Shinzui', 'Rp. 5000', 20, 'Sanitary', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indexes for table `tblpesanan`
--
ALTER TABLE `tblpesanan`
  ADD PRIMARY KEY (`idPesanan`);

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`id_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
