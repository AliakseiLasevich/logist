-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: logist
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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `contact_person` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `phone1` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `phone2` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `website` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=1502 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Conte','active','Belarus','Grodno','Pobedy - 51','Sergey Gonchar','+945397232','+435250563','Gonchar@conte.by','www.conte.by'),(2,'Korona','active','Belarus','Minsk','vbadkmwp - 35','hqsme vbneq','+966974560','+523767871','lhuse@korona.by','www.korona.by'),(3,'Collin\'s','active','Belarus','Minsk','smmhchgj - 07','Tatyana Petrova','+862891092','+421686400','lbwja@pbfl.com','www.collins.com'),(4,'ABC','active','Belarus','Grodno','Folush - 46','Dmitryi Venskovich','+453668989','+026635802','fptzf@yrqv.com','www.edohfgnct.com'),(5,'Komunarka','active','Belarus','Minsk','Pobediteley - 73','Anna Ivanova','+746854665','+513662384','anna@kom.by','www.komunarka.by'),(6,'Santa-Bremor','active','Belarus','Brest','Moskovskaya - 52','Santa Bremor','+554358309','+596209383','sb@sb.by','www.sb.by'),(7,'ehflc6','active','Belarus','ogpxvr','ldjbbain - 53','ozanw lbpja','+198181119','+218316259','bnfbr@eayr.com','www.clzviafwy.com'),(8,'jxisv7','active','Belarus','rwcugv','pfxzknwg - 01','oryqc fgonx','+011085412','+409173732','gpikv@xvqj.com','www.bxnjkvpli.com'),(9,'rbjgi8','active','Belarus','ltkeyo','ppqumkeb - 52','aozat ztkty','+031195037','+781324781','yrzfy@oymk.com','www.ypgiqyauu.com'),(10,'vpupw9','archive','Belarus','birjxg','gzkqdece - 98','nfsgy ibizj','+649821537','+215413754','syvjw@lgfy.com','www.gygbvtsnl.com'),(11,'cgpfj10','archive','Belarus','fsxsbq','vfonsrfa - 96','tglnz flqdo','+785937356','+100776063','stgtb@epcu.com','www.npmictmqo.com'),(12,'pzskj11','archive','Belarus','haintn','kqsydqjc - 37','ombvu uywog','+730611362','+906973210','uunbk@mghr.com','www.vyerlxxfo.com'),(13,'fzfna12','archive','Belarus','xvqoif','gjjmalmt - 06','ysocm csynj','+228172143','+931057217','ybsta@qzwd.com','www.abwlwpwxi.com'),(14,'ydpkp13','active','Belarus','jcwjoa','opixnfmq - 79','ijikp cjxos','+431230642','+098670961','obwbz@tpjs.com','www.udxqxqnhr.com'),(15,'fxdml14','active','Belarus','kjvzaw','foymerae - 48','jmxeb cjhyz','+034745191','+297888514','sgxoo@qjbi.com','www.hkjchktsg.com'),(16,'jvqrp15','active','Belarus','stnfgu','zwzmfogi - 02','mfeng xuupn','+250201396','+554898343','sqzyi@ruzt.com','www.ivljvrszo.com'),(17,'gjppe16','active','Belarus','xrizqr','ogiyetvf - 07','apolu qeyot','+898914648','+908025446','lynom@tquq.com','www.xixtqzgrw.com'),(18,'jzlcp17','active','Belarus','zcyxdu','luvseypn - 53','bubvs pyxfk','+676551290','+364537676','ynzuz@gikd.com','www.retmxysec.com'),(19,'pwxgs18','active','Belarus','dzrlty','jqilsdhw - 47','iyywu vpwqo','+456609266','+675308899','kyuxz@prom.com','www.smofhnzcm.com'),(20,'wbpgp19','active','Belarus','aaelsl','hmsodfzy - 40','nwjvf nxczc','+322031348','+983052163','mwvor@ambr.com','www.yegaciifh.com'),(21,'dalhy20','active','Belarus','klifeg','xegzhbwo - 71','fahzw xkvjk','+227281106','+160984249','ecdpj@xibf.com','www.mvonjwbuz.com'),(22,'jwaxm21','active','Belarus','cfswjj','hmqyhzrp - 76','luhre cgsct','+229890734','+373771309','hafjo@barm.com','www.pgjgrvqkf.com'),(23,'mnnwx22','active','Belarus','jdcing','dygbztyy - 11','pjstd inkkn','+822457630','+262697493','kxfkt@wyhm.com','www.spwhkktyu.com'),(24,'nskoi23','archive','Belarus','crmcei','lzpfkujt - 22','sedfy uhger','+729155790','+583602333','makxu@jaro.com','www.clvwxkbeq.com'),(25,'ckypc24','archive','Belarus','wsvstm','fbpeuuzq - 34','cytvq pjbje','+095458035','+436217188','fxzyb@ofao.com','www.pyyfshhis.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-18 13:13:49
