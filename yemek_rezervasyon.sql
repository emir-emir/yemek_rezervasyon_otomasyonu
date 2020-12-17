-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 05 Haz 2020, 21:16:52
-- Sunucu sürümü: 8.0.18
-- PHP Sürümü: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `yemek_rezervasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `kID` int(11) NOT NULL,
  `kul_ad` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `sifre` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `ad` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `soyad` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`kID`, `kul_ad`, `sifre`, `ad`, `soyad`, `telefon`) VALUES
(121, 'ali', '50', '', '', ''),
(122, 'salih', '123', '', '', ''),
(123, 'ösdmfds', 'dsf132', '', '', ''),
(124, 'emir', '123', 'a', 'a', 'a'),
(125, 'mahmut', '123456', 'mahmut', 'ERDEN', '05398231245'),
(129, 'd', 'd', '', '', ''),
(130, 'a', 'a', '', '', ''),
(131, 'b', 'b', '', '', ''),
(132, 'F', 'F', '', '', ''),
(133, 'G', 'G', '', '', ''),
(134, '', '', '', '', ''),
(135, 'F', 'F', '', '', ''),
(136, 'D', 'D', '', '', ''),
(137, '', '', '', '', ''),
(138, 'd', 'd', '', '', ''),
(139, 'emirşah', 'emi.1212', 'emirşah', 'erdeen', '052464'),
(140, 'emirşah', '123456', 'dklfskdlh', 'sdhfnlsk', 'sdknfşsal');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yemek_secimii`
--

CREATE TABLE `yemek_secimii` (
  `Id` int(100) NOT NULL,
  `Anayemekler` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_turkish_ci NOT NULL,
  `Aperatifler` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_turkish_ci NOT NULL,
  `içecekler` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_turkish_ci NOT NULL,
  `Tatlılar` varchar(100) CHARACTER SET utf16 COLLATE utf16_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `yemek_secimii`
--

INSERT INTO `yemek_secimii` (`Id`, `Anayemekler`, `Aperatifler`, `içecekler`, `Tatlılar`) VALUES
(63, 'Mantarlı Köfte', 'Çiğköfte', 'Şalgam', 'Fırında Sütlaç'),
(68, 'Belen Tava', 'Piyaz', 'kola', 'Fırında Sütlaç');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`kID`);

--
-- Tablo için indeksler `yemek_secimii`
--
ALTER TABLE `yemek_secimii`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `kID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;

--
-- Tablo için AUTO_INCREMENT değeri `yemek_secimii`
--
ALTER TABLE `yemek_secimii`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
