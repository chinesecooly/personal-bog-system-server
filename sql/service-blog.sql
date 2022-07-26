-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: personal_blog_system_blog
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` bigint unsigned NOT NULL COMMENT '文章ID',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT '文章地址',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '文章描述',
  `read_count` int unsigned NOT NULL DEFAULT '0' COMMENT '阅读数',
  `like_count` int unsigned NOT NULL DEFAULT '0' COMMENT '点赞数',
  `comment_count` int unsigned NOT NULL DEFAULT '0' COMMENT '评论数',
  `favorite_count` int unsigned NOT NULL DEFAULT '0' COMMENT '收藏数',
  `is_deleted` int unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_draft` int unsigned NOT NULL DEFAULT '0' COMMENT '是否是草稿',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1520005954488279042,'从JDBC到MyBatis渐进学习','20220429194354536','jdbc',39,1,3,0,0,'2022-05-23 04:43:31','2022-05-23 04:43:31',0),(1520010763735965698,'全面详细、通俗易懂的Git和GitHub','20220429200301164','全面详细、通俗易懂的Git和GitHub',7,0,0,0,0,'2022-05-02 13:08:16','2022-05-02 13:08:16',0),(1520011667100966914,'全面、详细、通俗易懂的C语言语法和标准库','20220429200636543','c语言',13,0,0,0,0,'2022-05-01 14:06:54','2022-05-01 14:06:54',0),(1520013375168356353,'Java与BIO和NIO网络编程及API详解','20220429201323766','Java与BIO和NIO网络编程及API详解',11,0,0,0,0,'2022-05-01 14:06:55','2022-05-01 14:06:55',0),(1520014018239045634,'java并发编程与API详解','20220429201557100','java并发编程与API详解',3,0,0,0,0,'2022-04-29 12:15:57','2022-04-29 12:15:57',0),(1520015398009872385,'从JVM角度查看一个java对象的生命周期','20220429202126060','从JVM角度查看一个java对象的生命周期',4,0,0,0,0,'2022-04-29 12:21:26','2022-04-29 12:21:26',0),(1522771794019225601,'123445','20220507105422047','倒萨的温泉为',25,0,13,0,0,'2022-05-20 06:46:51','2022-05-20 06:46:51',0),(1527894068250558466,'大厦撒多久啊是大家说的','20220521140827399','的撒旦撒旦',3,0,0,0,0,'2022-05-21 06:08:27','2022-05-21 06:08:27',0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_category`
--

DROP TABLE IF EXISTS `article_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_category` (
  `id` bigint unsigned NOT NULL COMMENT '文章分类ID',
  `article_id` bigint unsigned DEFAULT NULL COMMENT '文章ID',
  `category_id` bigint unsigned DEFAULT NULL COMMENT '分类ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_category`
--

LOCK TABLES `article_category` WRITE;
/*!40000 ALTER TABLE `article_category` DISABLE KEYS */;
INSERT INTO `article_category` VALUES (1520011667235184642,1520011667100966914,1519992608330395649,'2022-04-29 12:06:36','2022-04-29 12:06:36'),(1520013375302574081,1520013375168356353,1519990022516793345,'2022-04-29 12:13:23','2022-04-29 12:13:23'),(1520014018431983619,1520014018239045634,1519990022516793345,'2022-04-29 12:15:57','2022-04-29 12:15:57'),(1520015398139895810,1520015398009872385,1520014606758686722,'2022-04-29 12:21:26','2022-04-29 12:21:26'),(1521114121049796610,1520005954488279042,1519993315259326465,'2022-05-02 13:07:22','2022-05-02 13:07:22'),(1521114121091739650,1520005954488279042,1519990022516793345,'2022-05-02 13:07:22','2022-05-02 13:07:22'),(1521114350415310851,1520010763735965698,1519990024232263683,'2022-05-02 13:08:16','2022-05-02 13:08:16'),(1522771794883252226,1522771794019225601,1519990022516793345,'2022-05-07 02:54:22','2022-05-07 02:54:22'),(1527894068384776195,1527894068250558466,1519990022516793345,'2022-05-21 06:08:27','2022-05-21 06:08:27');
/*!40000 ALTER TABLE `article_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_tag`
--

DROP TABLE IF EXISTS `article_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_tag` (
  `id` bigint unsigned NOT NULL COMMENT '文章标签ID',
  `article_id` bigint unsigned DEFAULT NULL COMMENT '文章ID',
  `tag_id` bigint unsigned DEFAULT NULL COMMENT '标签ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `article_id_index` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_tag`
--

LOCK TABLES `article_tag` WRITE;
/*!40000 ALTER TABLE `article_tag` DISABLE KEYS */;
INSERT INTO `article_tag` VALUES (1520011667235184643,1520011667100966914,1519989942946635779,'2022-04-29 12:06:36','2022-04-29 12:06:36'),(1520013375302574082,1520013375168356353,1519989941679955970,'2022-04-29 12:13:23','2022-04-29 12:13:23'),(1520013375302574083,1520013375168356353,1519994891533406210,'2022-04-29 12:13:23','2022-04-29 12:13:23'),(1520013375302574084,1520013375168356353,1519994891600515074,'2022-04-29 12:13:23','2022-04-29 12:13:23'),(1520013375369682946,1520013375168356353,1519994891600515075,'2022-04-29 12:13:23','2022-04-29 12:13:23'),(1520014018431983618,1520014018239045634,1519989941679955970,'2022-04-29 12:15:57','2022-04-29 12:15:57'),(1520014018431983620,1520014018239045634,1519995044583477249,'2022-04-29 12:15:57','2022-04-29 12:15:57'),(1520014018494898178,1520014018239045634,1519995046173118465,'2022-04-29 12:15:57','2022-04-29 12:15:57'),(1520014018494898179,1520014018239045634,1519995046173118466,'2022-04-29 12:15:57','2022-04-29 12:15:57'),(1520015398207004674,1520015398009872385,1519989941679955970,'2022-04-29 12:21:26','2022-04-29 12:21:26'),(1520015398207004675,1520015398009872385,1519995044583477249,'2022-04-29 12:21:26','2022-04-29 12:21:26'),(1521114121049796609,1520005954488279042,1519989941679955970,'2022-05-02 13:07:22','2022-05-02 13:07:22'),(1521114121091739649,1520005954488279042,1519989942883721217,'2022-05-02 13:07:22','2022-05-02 13:07:22'),(1521114121091739651,1520005954488279042,1519989942946635778,'2022-05-02 13:07:22','2022-05-02 13:07:22'),(1521114350415310850,1520010763735965698,1519994889662746626,'2022-05-02 13:08:16','2022-05-02 13:08:16'),(1521114350415310852,1520010763735965698,1519994891533406209,'2022-05-02 13:08:16','2022-05-02 13:08:16'),(1522771794816143361,1522771794019225601,1519989941679955970,'2022-05-07 02:54:22','2022-05-07 02:54:22'),(1522771794883252225,1522771794019225601,1519989942946635777,'2022-05-07 02:54:22','2022-05-07 02:54:22'),(1527894068384776193,1527894068250558466,1519989942883721217,'2022-05-21 06:08:27','2022-05-21 06:08:27'),(1527894068384776194,1527894068250558466,1519989942946635778,'2022-05-21 06:08:27','2022-05-21 06:08:27'),(1527894068447690753,1527894068250558466,1519994889662746626,'2022-05-21 06:08:27','2022-05-21 06:08:27');
/*!40000 ALTER TABLE `article_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint unsigned NOT NULL COMMENT '分类ID',
  `body` varchar(50) NOT NULL DEFAULT '' COMMENT '分类主体',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '分类描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1519990022516793345,'java','','2022-04-29 10:50:03','2022-04-29 10:50:03'),(1519990024169349122,'linux','','2022-04-29 10:50:03','2022-04-29 10:50:03'),(1519990024232263681,'数据结构和算法','','2022-04-29 10:50:03','2022-04-29 10:50:03'),(1519990024232263682,'spring','','2022-04-29 10:50:03','2022-04-29 10:50:03'),(1519990024232263683,'工具','','2022-04-29 10:50:03','2022-04-29 10:50:03'),(1519992606879166466,'数据库','','2022-04-29 10:52:28','2022-04-29 10:52:28'),(1519992608267481090,'中间件','','2022-04-29 10:52:28','2022-04-29 10:52:28'),(1519992608330395649,'c','','2022-04-29 10:52:28','2022-04-29 10:52:28'),(1519992608330395650,'计算机网络','','2022-04-29 10:52:28','2022-04-29 10:52:28'),(1519992608401698818,'操作系统','','2022-04-29 10:52:28','2022-04-29 10:52:28'),(1519993313346723841,'计算机组成原理','','2022-04-29 10:55:13','2022-04-29 10:55:13'),(1519993315129303042,'高数','','2022-04-29 10:55:13','2022-04-29 10:55:13'),(1519993315192217602,'英语','','2022-04-29 10:55:13','2022-04-29 10:55:13'),(1519993315259326465,'框架','','2022-04-29 10:55:13','2022-04-29 10:55:13'),(1519993315259326466,'其它','','2022-04-29 10:55:13','2022-04-29 10:55:13'),(1520014606758686722,'JVM','','2022-04-29 12:18:44','2022-04-29 12:18:44'),(1520014607777902594,'category-1','','2022-04-29 12:18:17','2022-04-29 12:18:17'),(1520014607840817153,'category-2','','2022-04-29 12:18:17','2022-04-29 12:18:17'),(1520014607840817154,'category-3','','2022-04-29 12:18:17','2022-04-29 12:18:17'),(1520014607840817155,'category-4','','2022-04-29 12:18:17','2022-04-29 12:18:17');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` bigint unsigned NOT NULL COMMENT '标签ID',
  `body` varchar(50) NOT NULL DEFAULT '' COMMENT '标签主体',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tag_body_uindex` (`body`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1519989941679955970,'java','2022-04-29 10:58:06','2022-04-29 10:58:06'),(1519989942883721217,'orm','2022-04-29 10:58:06','2022-04-29 10:58:06'),(1519989942946635777,'mysql','2022-04-29 10:58:06','2022-04-29 10:58:06'),(1519989942946635778,'mybatis','2022-04-29 10:58:06','2022-04-29 10:58:06'),(1519989942946635779,'c语言','2022-04-29 10:58:06','2022-04-29 10:58:06'),(1519994889662746626,'git','2022-04-29 12:03:52','2022-04-29 12:03:52'),(1519994891533406209,'github','2022-04-29 12:03:52','2022-04-29 12:03:52'),(1519994891533406210,'aio','2022-04-29 12:13:13','2022-04-29 12:13:13'),(1519994891600515074,'bio','2022-04-29 12:13:14','2022-04-29 12:13:14'),(1519994891600515075,'nio','2022-04-29 12:13:13','2022-04-29 12:13:13'),(1519995044583477249,'JVM','2022-04-29 12:15:50','2022-04-29 12:15:50'),(1519995046173118465,'多线程','2022-04-29 12:15:50','2022-04-29 12:15:50'),(1519995046173118466,'并发编程','2022-04-29 12:15:50','2022-04-29 12:15:50'),(1519995046240227330,'jdk','2022-04-29 12:20:29','2022-04-29 12:20:29'),(1519995046240227331,'tag-4','2022-04-29 11:00:33','2022-04-29 11:00:33');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-29 17:36:08