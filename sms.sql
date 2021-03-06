/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20-log : Database - sms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sms`;

/*Table structure for table `t_new_users` */

DROP TABLE IF EXISTS `t_new_users`;

CREATE TABLE `t_new_users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `newname` varchar(255) DEFAULT NULL,
  `newemail` varchar(255) DEFAULT NULL,
  `newusername` varchar(255) DEFAULT NULL,
  `newuserpwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_new_users` */

insert  into `t_new_users`(`id`,`newname`,`newemail`,`newusername`,`newuserpwd`) values (1,'汪京生','1090781735@qq.com','wjs','wjs'),(2,'22','222','22','22');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `myclass` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`sno`,`name`,`myclass`,`score`) values (1,'霍文达','计算机16级1班',999),(2,'王冰','英语教育16级2班',100),(3,'王艺','计算机16级1班',100),(4,'李涛','计算机16级1班',100),(5,'贵莹莹','计算机16级1班',100),(6,'班玲松','计算机16级1班',100),(7,'尚小云','计算机16级1班',100),(8,'宋慧慧','计算机16级1班',100),(9,'付利臣','计算机16级1班',100),(10,'夏春蕾','计算机16级1班',100),(11,'孟凡华','计算机16级1班',100),(12,'李乔雨','计算机16级1班',100),(13,'秦劲松','计算机16级1班',100),(14,'尚美丽','计算机16级1班',100),(15,'贾媛媛','计算机16级1班',100),(16,'刘嘉伟','计算机16级1班',100),(17,'郑少恒','计算机16级1班',100),(18,'王建宾','计算机16级1班',100),(19,'王愈涛','计算机16级1班',100),(20,'张世康','计算机16级1班',100),(21,'张默涵','计算机16级1班',100),(22,'景若凡','计算机16级1班',100),(23,'刘伟宁','计算机16级1班',100),(24,'马雪琳','计算机16级1班',100),(25,'李文欣','计算机16级1班',100),(26,'张爱','计算机16级1班',100),(27,'韩天高','计算机16级1班',100),(28,'许羚','计算机16级1班',100),(29,'郑佳丽','计算机16级1班',100),(30,'周旭','计算机16级1班',100),(31,'苏子跃','计算机16级1班',100),(32,'赵康','计算机16级1班',100),(33,'张德康','计算机16级1班',100),(34,'王宏宇','计算机16级1班',100),(35,'苏晗','计算机16级1班',100),(36,'戎浩宇','计算机16级1班',100),(37,'索孟莹','计算机16级2班',100),(38,'郭建玲','计算机16级2班',100),(39,'孟超月','计算机16级2班',100),(40,'王云霄','计算机16级2班',100),(41,'潘晓林','计算机16级2班',100),(42,'翟越璇','计算机16级2班',100),(43,'孟新悦','计算机16级2班',100),(44,'吴超楠','计算机16级2班',100),(45,'樊高宇','计算机16级2班',100),(46,'任静菲','计算机16级2班',100),(47,'赵杉杉','计算机16级2班',100),(48,'汪京生','计算机16级2班',100),(49,'刘爽','计算机16级2班',100),(50,'王立苹','计算机16级2班',100),(51,'李子恺','计算机16级2班',100),(52,'孟书君','计算机16级2班',100),(53,'郝家辉','计算机16级2班',100),(54,'张家伟','计算机16级2班',100),(55,'李朝阳','计算机16级2班',100),(56,'胡正阳','计算机16级2班',100),(57,'张金苗','计算机16级2班',100),(58,'葛艺璇','计算机16级2班',100),(59,'高源','计算机16级2班',100),(60,'刘晨雨','计算机16级2班',100),(61,'房胜瑾','计算机16级2班',100),(62,'樊傲','计算机16级2班',100),(63,'刘美满','计算机16级2班',100),(64,'王霞','计算机16级2班',100),(65,'谷盼红','计算机16级2班',100),(66,'许丛岳','计算机16级2班',100),(67,'赵正元','计算机16级2班',100),(68,'杨杨','计算机16级2班',100),(69,'陈罗杰','计算机16级2班',100),(70,'魏玉婷','计算机16级2班',100),(71,'于畅','计算机16级2班',100),(72,'张琪','计算机16级2班',100),(73,'郭靖','广告设计18级1班',99),(74,'韦小宝','网络技术1班',55),(75,'到','带哦',20);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`name`,`sex`,`email`,`tel`) values (1,'admin','admin',NULL,NULL,NULL,NULL),(5,'admin1','admin1','111','女','1090781735@qq.com','11111111111'),(6,'admin2','admin2','111','男','1090781735@qq.com','11111111111');

/*Table structure for table `t_user3` */

DROP TABLE IF EXISTS `t_user3`;

CREATE TABLE `t_user3` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(4) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_user3` */

insert  into `t_user3`(`id`,`username`,`password`,`sex`,`intro`) values (1,'admin','admin',NULL,NULL),(2,'wjs','wjs',NULL,NULL),(3,'11','11',NULL,NULL),(4,NULL,NULL,0,'哈哈'),(5,'admin','admin',0,'111'),(6,'admin','admin',0,'123'),(7,'汪京生','汪京生',0,'哈哈哈'),(8,'admin','admin',0,'哈哈哈');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`username`,`password`) values ('abc','abc'),('123456','123456'),('111','111'),('222','222');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
