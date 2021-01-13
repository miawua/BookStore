-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES UTF8MB3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

-- DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
-- CREATE TABLE `book` (
--   `isbn` varchar(255) NOT NULL,
--   `bookauthor` varchar(64) DEFAULT NULL,
--   `bookname` varchar(64) DEFAULT NULL,
--   `picturelink` varchar(255) DEFAULT NULL,
--   `price` float NOT NULL,
--   `releasetime` date DEFAULT NULL,
--   `remainnum` int NOT NULL,
--   `shelftime` date DEFAULT NULL,
--   `soldnum` int NOT NULL,
--   `text` text,
--   PRIMARY KEY (`isbn`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

-- LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('0001','Randal E.·Bryant','深入理解计算机系统（原书第3版）','https://img12.360buyimg.com/n1/jfs/t3310/143/1379472768/437459/d9d8bd99/582435faN7c9dd621.jpg',101.9,'2016-12-01',1120,'2021-01-13',151,'和第2版相比，本版内容上*大的变化是，从以IA32和x86-64为基础转变为完全以x86-64为基础。基于x86-64，大量地重写代码，首次介绍对处理浮点数据的程序的机器级支持。处理器体系结构修改为支持64位字和操作的设计。引入更多的功能单元和更复杂的控制逻辑，使基于程序数据流表示的程序性能模型预测更加可靠。扩充关于用GOT和PLT创建与位置无关代码的讨论，描述了更加强大的链接技术（比如库打桩）。增加了对信号处理程序更细致的描述，包括异步信号安全的函数等。采用新函数，更新了与协议无关和线程安全的网络编程。'),('0002','Brian W.Kernighan','C程序设计语言','https://img12.360buyimg.com/n1/jfs/t1/34588/8/839/146167/5cad9a57Ebe6aea40/9ceff26db3a586c1.jpg',50.6,'2019-04-01',1120,'2021-01-13',151,'《C程序设计语言（原书第2版·新版 典藏版）》原著即为C语言的设计者之一DennisM.Ritchie和著名的计算机科学家BrianW.Kernighan合著的一本介绍C语言的经典著作。我们现在见到的大量论述C语言程序设计的教材和专著均以此书为蓝本。原著第1版中介绍的C语言成为后来广泛使用的C语言版本——标准C的基础。人们熟知的“hello，world”程序就是由《C程序设计语言（原书第2版·新版 典藏版）》首次引入的，现在，这一程序已经成为所有程序设计语言入门的第一课。原著第2版根据1987年制定的ANSIC标准做了适当的修订，引入了新的语言形式，并增加了新的示例。通过简洁的描述、典型的示例，作者全面、系统、准确地讲述了C语言的各个特性以及程序设计的基本方法。对于计算机从业人员来说，《C程序设计语言（原书第2版·新版 典藏版）》是一本必读的程序设计语言方面的参考书。'),('0003','Abraham Silberschatz，Henry F.Korth，S.Sudarshan','数据库系统概念（原书第6版）','https://img11.360buyimg.com/n1/16066/70ef6289-39cf-45f6-aced-4606c64eb94f.jpg',76,'2012-04-01',1120,'2021-01-13',151,'数据库系统概念（原书第6版）》是经典的数据库系统教科书《Database System Concepts》的新修订版，全面介绍数据库系统的各种知识，透彻阐释数据库管理的基本概念。本书内容丰富，不仅讨论了关系数据模型和关系语言、数据库设计过程、关系数据库理论、数据库应用设计和开发、数据存储结构、数据存取技术、查询优化方法、事务处理系统和并发控制、故障恢复技术、数据仓库和数据挖掘，而且对性能调整、性能评测标准、数据库应用测试和标准化、空间和地理数据、时间数据、多媒体数据、移动和个人数据库管理以及事务处理监控器、事务工作流、电子商务、高性能事务系统、实时事务系统和持续长时间的事务等高级应用主题进行了广泛讨论。'),('0004','Andrew S. Tanenbaum，Herbert Bos','现代操作系统（原书第4版）','https://img10.360buyimg.com/n1/jfs/t5767/171/8269246406/248250/13d1cd8e/59796a5fN31af7668.jpg',70.2,'2017-07-01',1120,'2021-01-13',151,'本书是操作系统领域的经典教材，主要内容包括进程与线程、内存管理、文件系统、输入/输出、死锁、虚拟化和云、多处理机系统、安全，以及关于UNIX、Linux、Android和Windows的实例研究等。第4版对知识点进行了全面更新，反映了当代操作系统的发展与动向。本书适合作为高等院校计算机专业的操作系统课程教材，也适合相关技术人员参考。'),('0005','James，F.Kurose，Keith，W.Ross','计算机网络：自顶向下方法(原书第7版)','https://img10.360buyimg.com/n1/jfs/t21907/93/2430108706/94785/22c9a5a2/5b559504N3e8c3441.jpg',65.3,'2018-07-01',1120,'2021-01-13',151,'本书是经典的计算机网络教材之一，采用了作者的自顶向下方法来讲授计算机网络的原理及其协议，自16年前第1版出版以来已经被数百所大学和学院选作教材，被译为14种语言。第7版保持了以前版本的特色，继续关注因特网和计算机网络的现代处理方式，注重原理和实践，为计算机网络教学提供了一种新颖和与时俱进的方法。同时，第7版进行了相当多的修订和更新，首次改变了各章的组织结构，将网络层分成两章（第4章关注网络层的“数据平面”，第5章关注网络层的“控制平面”），并将网络管理主题放入了新的第5章中。此外，为了反映自第6版以来计算机网络领域的新变化，对其他章节也进行了更新，删除了FTP和分布式散列表的材料，用流行的因特网显式拥塞通告（ECN）材料代替了ATM网络的材料，更新了有关802.11（所谓WiFi）网络和蜂窝网络（包括4G和LTE）的材料，全面修订并增加了新的课后习题，等等。'),('0006',' George Coulouris，Jean Dollimore，Tim Kindberg，Gordon Blair','分布式系统：概念与设计（原书第5版）','https://img14.360buyimg.com/n1/g10/M00/08/1A/rBEQWFE5cDoIAAAAAA-SH4z6enQAABuiQOXMYsAD5I3042.jpg',99.4,'2013-03-01',1120,'2021-01-13',151,'《分布式系统：概念与设计（原书第5版）》旨在全面介绍互联网及其他常用分布式系统的原理、体系结构、算法和设计，内容涵盖分布式系统的相关概念、安全、数据复制、组通信、分布式文件系统、分布式事务、分布式系统设计等，以及相关的前沿主题，包括Web服务、网格、移动系统和无处不在系统等。');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

-- DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
-- CREATE TABLE `hibernate_sequence` (
--   `next_val` bigint DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

-- LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
-- INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `record`
--

-- DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
-- CREATE TABLE `record` (
--   `id` bigint NOT NULL,
--   `isbn` varchar(255) DEFAULT NULL,
--   `buyername` varchar(32) DEFAULT NULL,
--   `payfor` float NOT NULL,
--   `purchasedate` date DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

-- LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `user`
--

-- DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
-- CREATE TABLE `user` (
--   `username` varchar(32) NOT NULL,
--   `address` varchar(64) DEFAULT NULL,
--   `password` varchar(64) DEFAULT NULL,
--   PRIMARY KEY (`username`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

-- LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('user1','123@u.com','123456'),('user2','qwd@u.com','67575'),('user3','asdasd@u.com','advsa'),('user4','sdvfgdsh@u.com','2365467jnfg'),('user5','wer23rq23@u.com','bsdbfgdfg'),('user6','123415@u.com','avds'),('user7','asdffre@u.com','afbadfb'),('user8','321@u.com','123456789');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
-- UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-13 11:04:22
