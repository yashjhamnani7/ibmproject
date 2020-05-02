
DROP DATABASE IF EXISTS `ibmproj`;
CREATE DATABASE `ibmproj` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ibmproj`;

#
# Source for table "its_tbl_candidate"
#

DROP TABLE IF EXISTS `its_tbl_candidate`;
CREATE TABLE `its_tbl_candidate` (
  `CandidateId` bigint(20) NOT NULL AUTO_INCREMENT,
  `PrimarySkills` varchar(30) DEFAULT NULL,
  `SecondarySkills` varchar(30) DEFAULT NULL,
  `Experience` int(11) DEFAULT NULL,
  `Qualification` varchar(20) DEFAULT NULL,
  `Designation` varchar(20) DEFAULT NULL,
  `NoticePeriod` int(11) DEFAULT NULL,
  `Location` varchar(20) DEFAULT NULL,
  `ShareDetails` int(11) DEFAULT NULL,
  PRIMARY KEY (`CandidateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "its_tbl_candidate"
#

INSERT INTO `its_tbl_candidate` VALUES (1,'Java','Chjjs',2,'Btech','engineer',4,'dhan',2,1);

#
# Source for table "its_tbl_hrpanel"
#

DROP TABLE IF EXISTS `its_tbl_hrpanel`;
CREATE TABLE `its_tbl_hrpanel` (
  `empHRId` varchar(6) NOT NULL,
  `empHRName` varchar(25) NOT NULL,
  PRIMARY KEY (`empHRId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "its_tbl_hrpanel"
#


#
# Source for table "its_tbl_techpanel"
#

DROP TABLE IF EXISTS `its_tbl_techpanel`;
CREATE TABLE `its_tbl_techpanel` (
  `techId` varchar(6) NOT NULL,
  `techName` varchar(25) NOT NULL,
  `Subjects` varchar(40) NOT NULL,
  PRIMARY KEY (`techId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "its_tbl_techpanel"
#


#
# Source for table "its_tbl_interview_schedule"
#

DROP TABLE IF EXISTS `its_tbl_interview_schedule`;
CREATE TABLE `its_tbl_interview_schedule` (
  `InterviewID` varchar(6) NOT NULL,
  `CandidateId` bigint(20) DEFAULT NULL,
  `Subject` varchar(20) NOT NULL,
  `TechID` varchar(6) DEFAULT NULL,
  `InterviewDate` date NOT NULL,
  `InterviewTime` varchar(8) NOT NULL,
  `TechRating` decimal(1,1) DEFAULT NULL,
  `empHRID` varchar(6) DEFAULT NULL,
  `empHRInterviewDate` date DEFAULT NULL,
  `empHRInterviewTime` varchar(8) DEFAULT NULL,
  `empHRRating` decimal(1,1) DEFAULT NULL,
  `Result` varchar(20) DEFAULT NULL,
  `ShareResult` int(11) DEFAULT NULL,
  PRIMARY KEY (`InterviewID`),
  KEY `CandidateID_idx` (`CandidateId`),
  KEY `TechID_idx` (`TechID`),
  KEY `empHRID_idx` (`empHRID`),
  CONSTRAINT `CandidateID_is` FOREIGN KEY (`CandidateId`) REFERENCES `its_tbl_candidate` (`CandidateId`),
  CONSTRAINT `empHRID` FOREIGN KEY (`empHRID`) REFERENCES `its_tbl_hrpanel` (`empHRId`),
  CONSTRAINT `TechID` FOREIGN KEY (`TechID`) REFERENCES `its_tbl_techpanel` (`techId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=0;
#
# Data for table "its_tbl_interview_schedule"
#


#
# Source for table "its_tbl_user_credentials"
#

DROP TABLE IF EXISTS `its_tbl_user_credentials`;
CREATE TABLE `its_tbl_user_credentials` (
  `UserId` varchar(6) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Usertype` varchar(1) DEFAULT NULL,
  `Loginstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "its_tbl_user_credentials"
#

INSERT INTO `its_tbl_user_credentials` VALUES ('1001','akshay123','A',1,''),('1002','yash123','T',1,''),('1003','arko123','T',1,''),('1004','hemant123','T',1,''),('1005','anish123','H',1,''),('1006','sibu123','H',1,''),('1007','sandeep123','H',1,'');

#
# Source for table "its_tbl_user_profile"
#

DROP TABLE IF EXISTS `its_tbl_user_profile`;
CREATE TABLE `its_tbl_user_profile` (
  `CandidateId` bigint(20) NOT NULL,
  `Firstname` varchar(15) NOT NULL,
  `Lastname` varchar(15) NOT NULL,
  `Dateofbirth` date NOT NULL,
  `Gender` varchar(7) NOT NULL,
  `Street` varchar(30) NOT NULL,
  `Location` varchar(15) NOT NULL,
  `City` varchar(15) NOT NULL,
  `State` varchar(15) NOT NULL,
  `Pincode` varchar(6) NOT NULL,
  `MobileNo` varchar(10) DEFAULT NULL,
  `EmailId` varchar(30) DEFAULT NULL,
 
  KEY `CandidateId_idx` (`CandidateId`),
  CONSTRAINT `CandidateId_idx` FOREIGN KEY (`CandidateId`) REFERENCES `its_tbl_candidate` (`CandidateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "its_tbl_user_profile"
#

 