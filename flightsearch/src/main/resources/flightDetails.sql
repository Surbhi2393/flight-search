CREATE DATABASE  IF NOT EXISTS `flight_details`;
USE `flight_details`;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;

CREATE TABLE `flight` (
  `flight_number` int(11) NOT NULL AUTO_INCREMENT,
  `airline_name` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `departure_time` DATETIME DEFAULT NULL,
  `arrival_time` DATETIME DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `no_of_stops` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`flight_number`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `flight`
--

INSERT INTO `flight` VALUES 
	(1,'Air India','Bangalore','Chennai','2020-8-04T10:30:00','2020-8-04T11:30:00',60, 0,3000),
	(2,'Air India','Bangalore','Mumbai','2020-8-04T10:30:00','2020-8-04T11:30:00',60, 0,3000),
	(3,'Air Asia','Mumbai','Chennai','2020-8-04T12:30:00','2020-8-04T15:30:00',180, 0,5000),
	(4,'Indigo','Bangalore','Kolkata','2020-8-04T09:30:00','2020-8-04T11:30:00',120, 0,9000),
	(5,'Indigo','Chennai','Bangalore','2020-8-10T09:30:00','2020-8-10T10:30:00',60, 0,3500);