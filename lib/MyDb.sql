CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `areairregular`
--

DROP TABLE IF EXISTS `areairregular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `areairregular` (
  `are_id` int(11) NOT NULL AUTO_INCREMENT,
  `are_area_aprox` double NOT NULL,
  `are_descricao` text NOT NULL,
  `are_ter_id` int(11) NOT NULL,
  PRIMARY KEY (`are_id`),
  KEY `fk_AreaIrregular_Terreno1_idx` (`are_ter_id`),
  CONSTRAINT `fk_AreaIrregular_Terreno1` FOREIGN KEY (`are_ter_id`) REFERENCES `terreno` (`ter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areairregular`
--

LOCK TABLES `areairregular` WRITE;
/*!40000 ALTER TABLE `areairregular` DISABLE KEYS */;
/*!40000 ALTER TABLE `areairregular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terreno`
--

DROP TABLE IF EXISTS `terreno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `terreno` (
  `ter_id` int(11) NOT NULL AUTO_INCREMENT,
  `ter_latitude` varchar(45) DEFAULT NULL,
  `ter_longitude` varchar(45) DEFAULT NULL,
  `ter_estado` varchar(45) DEFAULT NULL,
  `ter_cidade` varchar(45) DEFAULT NULL,
  `ter_bairro` varchar(45) DEFAULT NULL,
  `ter_rua` varchar(45) DEFAULT NULL,
  `ter_numero` int(11) DEFAULT NULL,
  `ter_area` double DEFAULT NULL,
  PRIMARY KEY (`ter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terreno`
--

LOCK TABLES `terreno` WRITE;
/*!40000 ALTER TABLE `terreno` DISABLE KEYS */;
INSERT INTO `terreno` VALUES (1,'64°65´´46´S','65°46´´54´L','Minas Gerais',NULL,'Roseira','Francisco',21,40),(2,'16°54´´13´N','65°45´´45´O','São Paulo',NULL,'Coronéis','Jorge',85,NULL),(3,'56°46´´85´L','54°46´´55´S','Minas','Extrema','abc','123',20,55),(4,'98°64´´53´S','54°16´´51´L','dfgf','jhvjhg','jvkjhkn','jhggjvh',21,NULL);
/*!40000 ALTER TABLE `terreno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `usu_id` int(11) NOT NULL AUTO_INCREMENT,
  `usu_nome` varchar(45) NOT NULL,
  `usu_login` varchar(45) NOT NULL,
  `usu_senha` varchar(45) NOT NULL,
  `usu_tipo` int(11) NOT NULL,
  PRIMARY KEY (`usu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'Matheus','mater','4567',0),(5,'jonathan','jonta','12345',1),(6,'Marcos','marc','12345',0),(7,'Lucas','luca','1234',0),(8,'Maheus','mate','1234',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vistoria`
--

DROP TABLE IF EXISTS `vistoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vistoria` (
  `vis_id` int(11) NOT NULL AUTO_INCREMENT,
  `vis_data_entrega` date DEFAULT NULL,
  `vis_usu_id` int(11) NOT NULL,
  `vis_ter_id` int(11) NOT NULL,
  `vis_estado` varchar(45) NOT NULL,
  `vis_observacoes` text,
  PRIMARY KEY (`vis_id`),
  KEY `fk_Vistoria_Usuario_idx` (`vis_usu_id`),
  KEY `fk_Vistoria_Terreno1_idx` (`vis_ter_id`),
  CONSTRAINT `fk_Vistoria_Terreno1` FOREIGN KEY (`vis_ter_id`) REFERENCES `terreno` (`ter_id`),
  CONSTRAINT `fk_Vistoria_Usuario` FOREIGN KEY (`vis_usu_id`) REFERENCES `usuario` (`usu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vistoria`
--

LOCK TABLES `vistoria` WRITE;
/*!40000 ALTER TABLE `vistoria` DISABLE KEYS */;
INSERT INTO `vistoria` VALUES (1,'2019-05-20',4,1,'Executando',NULL);
/*!40000 ALTER TABLE `vistoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-11 10:46:36
