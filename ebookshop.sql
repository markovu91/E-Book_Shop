CREATE DATABASE  IF NOT EXISTS `ebookshop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ebookshop`;
-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ebookshop
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1009 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1008,'Python for dummies','MoneyM',32.56,40),(1004,'A Cup of Java','Kumar',44.44,19),(1005,'A Teaspoon of Java','Kevin Jones',55.67,55),(1007,'kaput','dafoe',11.32,53);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!50001 DROP VIEW IF EXISTS `customers`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `customers` AS SELECT 
 1 AS `id`,
 1 AS `cust_name`,
 1 AS `cust_phone`,
 1 AS `cust_email`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `order_records`
--

DROP TABLE IF EXISTS `order_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_records` (
  `id` int(11) NOT NULL,
  `qty_ordered` int(11) NOT NULL,
  `cust_name` varchar(30) NOT NULL,
  `cust_email` varchar(30) NOT NULL,
  `cust_phone` char(8) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=1005 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_records`
--

LOCK TABLES `order_records` WRITE;
/*!40000 ALTER TABLE `order_records` DISABLE KEYS */;
INSERT INTO `order_records` VALUES (1002,2,'peter','peter@tyhf.com','56567673'),(1004,5,'johnS','dsds@fdfd.fgf','56567674'),(1008,1,'markoV','dsds@fdfd.fgf','34564376');
/*!40000 ALTER TABLE `order_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ebookshop'
--

--
-- Final view structure for view `customers`
--

/*!50001 DROP VIEW IF EXISTS `customers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customers` AS select `order_records`.`id` AS `id`,`order_records`.`cust_name` AS `cust_name`,`order_records`.`cust_phone` AS `cust_phone`,`order_records`.`cust_email` AS `cust_email` from `order_records` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-29  0:18:48
