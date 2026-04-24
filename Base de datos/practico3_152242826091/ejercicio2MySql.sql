CREATE DATABASE /*!32312 IF NOT EXISTS*/ ejercicio2;
USE ejercicio2;

DROP TABLE IF EXISTS `competencia`;
CREATE TABLE `competencia` (
    `NRO_COMPETENCIA` int(11) NOT NULL,
    `DESCRIPCION` varchar(30) NOT NULL,
    `CATEGORIA` int(11) default NULL,
  PRIMARY KEY  (`NRO_COMPETENCIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `competencia` DISABLE KEYS */;
INSERT INTO `competencia` (`NRO_COMPETENCIA`,`DESCRIPCION`,`CATEGORIA`) VALUES
 (1,'torneo de futbol infantil',' 5'),
 (2,'torneo de futbol juvenil','2'),
 (3,'torneo de futbol veteranos','5 '),
 (4,'torneo de tenis infantil','5'),
 (5,'torneo de tenis juvenil','3'),
 (6,'torneo de tenis veteranos','6 '),
 (7,'torneo de basquet infantil','3'),
 (8,'torneo de basquet juvenil','1'),
 (9,'torneo de basquet veteranos','2');


DROP TABLE IF EXISTS `club`;
 CREATE TABLE `club` (
  `NRO_CLUB` int(12) NOT NULL,
  `NOMBRE_CLUB` varchar(30) NOT NULL,
  `PRESUPUESTO` decimal(9,2) default NULL,
  PRIMARY KEY  (`NRO_CLUB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


 INSERT INTO `club` (`NRO_CLUB`,`NOMBRE_CLUB`,`PRESUPUESTO`) VALUES
 (1,'Atlético Estudiantes','35000.00'),
 (2,'Banda Norte','27500.80'),
 (3,'Atenas','19700.00'),
 (4,'Sportivo Municipal','21640.00'),
 (5,'Atlético Adelia María','22000.00'),
 (6,'Atlético Sampacho','18000.00'),
 (7,'Alianza Moldes','65200.00');


DROP TABLE IF EXISTS `participacion`;
 CREATE TABLE `participacion`(
  `NRO_CLUB` int(12) NOT NULL,
  `NRO_COMPETENCIA` int(11) NOT NULL,
  `PUESTO` varchar(129) default NULL,
   PRIMARY KEY (`NRO_CLUB`,`NRO_COMPETENCIA`),
   CONSTRAINT `FK_PARTICIPACION_1` FOREIGN KEY (`NRO_CLUB`) REFERENCES `club` (`NRO_CLUB`),
   CONSTRAINT `FK_PARTICIPACION_2` FOREIGN KEY (`NRO_COMPETENCIA`) REFERENCES `competencia` (`NRO_COMPETENCIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


 INSERT INTO `participacion` (`NRO_CLUB`,`NRO_COMPETENCIA`,`PUESTO`) VALUES
 (1,'1','primer puesto'),
 (2,'1','segundo puesto'),
 (3,'3','tercer puesto'),
 (4,'8','primer puesto'),
 (5,'4','segundo puesto'),
 (1,'2','primer puesto'),
 (6,'8','segundo puesto'),
 (3,'9','tercer puesto');
