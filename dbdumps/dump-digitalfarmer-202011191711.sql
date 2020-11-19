-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: digitalfarmer
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB-1:10.4.14+maria~bionic-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animals`
--

DROP TABLE IF EXISTS `animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animals` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `id_species` int(11) NOT NULL,
  `born` date NOT NULL,
  `sex` varchar(100) NOT NULL,
  `id_placing` int(11) NOT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `animal_fk_1` (`id_species`),
  KEY `animal_fk_2` (`id_placing`),
  CONSTRAINT `animal_fk_1` FOREIGN KEY (`id_species`) REFERENCES `species` (`id_species`),
  CONSTRAINT `animal_fk_2` FOREIGN KEY (`id_placing`) REFERENCES `placings` (`id_placing`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (1,'Bonita','75639',1,'2020-01-03','F',1),(2,NULL,'45213',2,'2020-01-03','F',2),(3,'Preciosa',NULL,1,'2010-01-03','F',3),(4,'Lucero','42234',3,'2010-01-03','M',1),(5,'Jeremías','78521',1,'2010-01-03','M',2),(6,'Rocky',NULL,4,'2010-01-03','M',3),(7,'Jacko',NULL,4,'2010-01-03','M',1),(8,NULL,'1234',5,'2020-01-03','M',2),(9,NULL,'786546',2,'2020-01-03','F',3),(10,'Copito','45621',6,'2020-01-03','M',1),(12,'Blanca','78945',1,'2020-01-03','F',1),(19,'Animal1','Cod1',2,'2020-01-03','F',1);
/*!40000 ALTER TABLE `animals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop_events`
--

DROP TABLE IF EXISTS `crop_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crop_events` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `money_spent` decimal(10,0) DEFAULT NULL,
  `money_earned` decimal(10,0) DEFAULT NULL,
  `id_season` int(11) NOT NULL,
  PRIMARY KEY (`id_event`),
  KEY `crop_events_fk` (`id_season`),
  CONSTRAINT `crop_events_fk` FOREIGN KEY (`id_season`) REFERENCES `seasons` (`id_season`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop_events`
--

LOCK TABLES `crop_events` WRITE;
/*!40000 ALTER TABLE `crop_events` DISABLE KEYS */;
INSERT INTO `crop_events` VALUES (1,'Siembra','2020-01-04',1000,0,1);
/*!40000 ALTER TABLE `crop_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farm_tasks`
--

DROP TABLE IF EXISTS `farm_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farm_tasks` (
  `id_task` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `date` date DEFAULT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT 0,
  `id_farm` int(11) NOT NULL,
  PRIMARY KEY (`id_task`),
  KEY `farm_tasks_fk` (`id_farm`),
  CONSTRAINT `farm_tasks_fk` FOREIGN KEY (`id_farm`) REFERENCES `farms` (`id_farm`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm_tasks`
--

LOCK TABLES `farm_tasks` WRITE;
/*!40000 ALTER TABLE `farm_tasks` DISABLE KEYS */;
INSERT INTO `farm_tasks` VALUES (2,'Saneamiento veterinario','2020-01-04',0,1),(5,'Sacar abono','2020-01-04',1,1),(6,'Almacenar forrajes','2020-01-04',1,1);
/*!40000 ALTER TABLE `farm_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farms`
--

DROP TABLE IF EXISTS `farms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farms` (
  `id_farm` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(20) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_farm`),
  KEY `farms_fk` (`id_user`),
  CONSTRAINT `farms_fk` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farms`
--

LOCK TABLES `farms` WRITE;
/*!40000 ALTER TABLE `farms` DISABLE KEYS */;
INSERT INTO `farms` VALUES (1,'Valladolid',1),(2,'Valladolid',2),(3,'Poza de la Vega',3);
/*!40000 ALTER TABLE `farms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fields`
--

DROP TABLE IF EXISTS `fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fields` (
  `id_field` int(11) NOT NULL AUTO_INCREMENT,
  `id_farm` int(11) NOT NULL,
  `location` varchar(20) DEFAULT NULL,
  `area` float DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_field`),
  KEY `fields_fk` (`id_farm`),
  CONSTRAINT `fields_fk` FOREIGN KEY (`id_farm`) REFERENCES `farms` (`id_farm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fields`
--

LOCK TABLES `fields` WRITE;
/*!40000 ALTER TABLE `fields` DISABLE KEYS */;
INSERT INTO `fields` VALUES (1,1,'Parcela 33',1.56,'Regadío'),(2,1,'Parcela 20',0.5,'Secano'),(3,1,'Parcela 13',3.2,'Regadío');
/*!40000 ALTER TABLE `fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machinery`
--

DROP TABLE IF EXISTS `machinery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machinery` (
  `id_machine` int(11) NOT NULL AUTO_INCREMENT,
  `id_farm` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `adquisition` date DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_machine`),
  KEY `machinery_fk` (`id_farm`),
  CONSTRAINT `machinery_fk` FOREIGN KEY (`id_farm`) REFERENCES `farms` (`id_farm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machinery`
--

LOCK TABLES `machinery` WRITE;
/*!40000 ALTER TABLE `machinery` DISABLE KEYS */;
INSERT INTO `machinery` VALUES (1,1,'Tractor 1','2020-01-04',3500),(2,1,'Sembradora','2020-01-04',2000),(3,1,'Abonadora','2020-01-04',5000);
/*!40000 ALTER TABLE `machinery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenances`
--

DROP TABLE IF EXISTS `maintenances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintenances` (
  `id_maintenance` int(11) NOT NULL AUTO_INCREMENT,
  `id_machine` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_maintenance`),
  KEY `maintenances_fk` (`id_machine`),
  CONSTRAINT `maintenances_fk` FOREIGN KEY (`id_machine`) REFERENCES `machinery` (`id_machine`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenances`
--

LOCK TABLES `maintenances` WRITE;
/*!40000 ALTER TABLE `maintenances` DISABLE KEYS */;
INSERT INTO `maintenances` VALUES (2,1,'Cambio aceite 6000 horas','2020-01-04'),(3,2,'Engrasar','2020-01-03');
/*!40000 ALTER TABLE `maintenances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placings`
--

DROP TABLE IF EXISTS `placings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `placings` (
  `id_placing` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `id_farm` int(11) NOT NULL,
  PRIMARY KEY (`id_placing`),
  KEY `placings_fk` (`id_farm`),
  CONSTRAINT `placings_fk` FOREIGN KEY (`id_farm`) REFERENCES `farms` (`id_farm`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placings`
--

LOCK TABLES `placings` WRITE;
/*!40000 ALTER TABLE `placings` DISABLE KEYS */;
INSERT INTO `placings` VALUES (1,'Pasto',1),(2,'Establo 1',1),(3,'Establo 2',1),(11,'Establo 3',1),(14,'Caseta',1);
/*!40000 ALTER TABLE `placings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id_season` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `crop` varchar(20) NOT NULL,
  `id_field` int(11) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_season`),
  KEY `seasons_fk` (`id_field`),
  CONSTRAINT `seasons_fk` FOREIGN KEY (`id_field`) REFERENCES `fields` (`id_field`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
INSERT INTO `seasons` VALUES (1,2018,'Hierba',1,'Forraje');
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_readings`
--

DROP TABLE IF EXISTS `sensor_readings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor_readings` (
  `id_reading` int(11) NOT NULL AUTO_INCREMENT,
  `id_sensor` int(11) NOT NULL,
  `reading` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_reading`),
  KEY `sensor_readings_FK` (`id_sensor`),
  CONSTRAINT `sensor_readings_FK` FOREIGN KEY (`id_sensor`) REFERENCES `sensors` (`id_sensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_readings`
--

LOCK TABLES `sensor_readings` WRITE;
/*!40000 ALTER TABLE `sensor_readings` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_readings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensors`
--

DROP TABLE IF EXISTS `sensors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensors` (
  `id_sensor` int(11) NOT NULL AUTO_INCREMENT,
  `id_farm` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_sensor`),
  KEY `Sensors_FK` (`id_farm`),
  CONSTRAINT `Sensors_FK` FOREIGN KEY (`id_farm`) REFERENCES `farms` (`id_farm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensors`
--

LOCK TABLES `sensors` WRITE;
/*!40000 ALTER TABLE `sensors` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `species` (
  `id_species` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_species`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES (1,'cow'),(2,'pig'),(3,'horse'),(4,'dog'),(5,'hen'),(6,'sheep');
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatments`
--

DROP TABLE IF EXISTS `treatments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatments` (
  `id_treatment` int(11) NOT NULL AUTO_INCREMENT,
  `id_animal` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `date_init` date NOT NULL,
  `date_end` date DEFAULT NULL,
  PRIMARY KEY (`id_treatment`),
  KEY `treatments_fk` (`id_animal`),
  CONSTRAINT `treatments_fk` FOREIGN KEY (`id_animal`) REFERENCES `animals` (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatments`
--

LOCK TABLES `treatments` WRITE;
/*!40000 ALTER TABLE `treatments` DISABLE KEYS */;
INSERT INTO `treatments` VALUES (1,1,'Está jodida','2019-11-13','2020-01-04'),(3,1,'Administrar 5ml de antibiótico al día.','2020-01-03','2020-01-11'),(4,1,'Dar medisinas','2020-01-03',NULL),(5,4,'Administrar medicina','2020-01-08','2020-01-17'),(6,4,'Malito','2020-01-08','2020-01-15');
/*!40000 ALTER TABLE `treatments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `users_un` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'galileo@galileo.es','1234','Galileo'),(2,'sergio@galileo.es','1234','Sergio Gutiérrez'),(3,'patripoza@gmail.com','1234','Patricia');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'digitalfarmer'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-19 17:11:12
