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
-- Table structure for table `tariff`
--

DROP TABLE IF EXISTS `tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buildyearfrom` date DEFAULT NULL,
  `buildyearto` date DEFAULT NULL,
  `squarefrom` double DEFAULT NULL,
  `squareto` double DEFAULT NULL,
  `propertytype` varchar(16) DEFAULT NULL,
  `value` double NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `versionstart` datetime DEFAULT NULL,
  `versionend` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `type` (`type`,`buildyearfrom`,`buildyearto`),
  KEY `type_2` (`type`,`squarefrom`,`squareto`),
  KEY `type_3` (`type`,`propertytype`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff`
--

LOCK TABLES `tariff` WRITE;
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
INSERT INTO `tariff` VALUES (29,NULL,NULL,12,14,NULL,200,'bysquare','2019-08-15 18:46:43',NULL),(30,NULL,NULL,NULL,NULL,'House',200,'bytype','2019-08-15 18:46:48',NULL),(31,NULL,NULL,1,50,NULL,1.7,'bysquare','2019-07-01 22:23:00',NULL),(32,'2018-01-01','2020-01-01',NULL,NULL,NULL,1.2,'byyear','2019-07-01 22:23:00',NULL),(33,NULL,NULL,NULL,NULL,'квартира',1.1,'bytype','2019-07-01 22:23:00',NULL),(34,NULL,NULL,NULL,NULL,'дом',1.9,'bytype','2019-07-01 22:23:00',NULL),(35,NULL,NULL,NULL,NULL,'нежилое',1.1,'bytype','2019-07-01 22:23:00',NULL),(36,NULL,NULL,51,10,NULL,2,'bysquare','2019-07-01 22:23:00',NULL),(37,NULL,NULL,51,100,NULL,2,'bysquare','2019-07-01 22:23:00',NULL),(38,NULL,NULL,51,100,NULL,2.1,'bysquare','2019-01-01 22:23:00',NULL),(39,NULL,NULL,51,100,NULL,2,'bysquare','2019-08-01 22:23:00',NULL),(40,NULL,NULL,NULL,NULL,'Дворец',500,'bytype','2019-08-20 20:51:57',NULL);
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-11  1:13:30
