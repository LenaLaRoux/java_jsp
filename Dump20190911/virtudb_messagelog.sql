-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: virtudb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messagelog`
--

DROP TABLE IF EXISTS `messagelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messagelog` (
  `logtime` time DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messagelog`
--

LOCK TABLES `messagelog` WRITE;
/*!40000 ALTER TABLE `messagelog` DISABLE KEYS */;
INSERT INTO `messagelog` VALUES ('13:18:25','test'),('13:30:26','bysquare'),('13:33:34','bysquare'),('13:37:34','bysquare'),('13:57:40','0'),('13:59:29','0'),('14:06:15','0'),('14:24:20','0'),('14:24:56','0'),('14:25:23','0'),('14:34:42','0'),('14:35:50','0'),('15:32:17',NULL),('15:38:46',NULL),('15:40:50',NULL),('15:42:26',NULL),('15:45:41',NULL),('15:46:50',NULL),('15:48:03',NULL),('15:53:56',NULL),('15:54:50',NULL),('15:58:41','0'),('16:01:52','0'),('17:17:18','0'),('17:22:33','0'),('17:22:33','2'),('17:37:21','bysquare'),('17:37:37','bytype'),('23:46:47','bysquare'),('23:46:47','bytype'),('01:42:24','bysquare'),('01:44:35','byyear'),('01:47:32','bytype'),('01:47:32','bytype'),('01:47:32','bytype'),('01:50:36','bysquare'),('01:51:27','bysquare'),('01:52:49','bysquare'),('01:52:49','bysquare'),('01:52:43','bytype'),('02:00:26','bytype');
/*!40000 ALTER TABLE `messagelog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-11  1:13:29
