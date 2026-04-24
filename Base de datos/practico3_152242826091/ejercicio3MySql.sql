CREATE DATABASE IF NOT EXISTS  ejercicio3;
USE ejercicio3;

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (

  `nro_alumno` int(11) NOT NULL,

  `dni` int(11) NOT NULL,

  `nombre` VARCHAR(45) NOT NULL,

  `apellido` VARCHAR(45) NOT NULL,

  `sexo` VARCHAR(20) NOT NULL,

  PRIMARY KEY  (`nro_alumno`)

)

ENGINE=INNODB;

DROP TABLE IF EXISTS `taller`;

CREATE TABLE `taller` (

  `codigo_taller` int(11) NOT NULL,

  `nombre`VARCHAR(45) NOT NULL,

  `duracion` int(11) NOT NULL,

  PRIMARY KEY (`codigo_taller`)

)

ENGINE=INNODB;

DROP TABLE IF EXISTS `realiza`;

CREATE TABLE `realiza` (

  `nro_alumno` int(11) NOT NULL,

  `codigo_taller` int(11) NOT NULL,

  PRIMARY KEY (`nro_alumno`,`codigo_taller`),

  CONSTRAINT `FK_REALIZA_NRO_ALUMNO`

    FOREIGN KEY (`nro_alumno`)

      REFERENCES `alumno`(`nro_alumno`),

  CONSTRAINT `FK_REALIZA_CODIGO_TALLER`

    FOREIGN KEY (`codigo_taller`)

      REFERENCES `taller` (`codigo_taller`) 

)

ENGINE=INNODB;

INSERT INTO alumno VALUES
 (1, 40133723, 'Juan', 'Lopez', 'masculino'),
 (2, 41012149, 'Ana', 'Garcia', 'femenino'),
 (3, 39915686, 'Matias', 'Gonzalez', 'masculino'),
 (4, 40349213, 'Jorge', 'Romero', 'masculino'),
 (5, 40531020, 'Agustina', 'Diaz', 'femenino'),
 (6, 41294339, 'Clara', 'Suarez', 'femenino'),
 (7, 42247714, 'Alan', 'Acosta', 'masculino'),
 (8, 39893011, 'Antonela', 'Perez', 'femenino');

INSERT INTO taller VALUES
 (1, 'Cocina', 28),
 (2, 'Reparacion de PC', 56),
 (3, 'Bordado', 28),
 (4, 'Historia Argentina', 14),
 (5, 'Disenio Grafico', 21);

INSERT INTO realiza VALUES
 (1,1),
 (1,2),
 (1,5),
 (2,2),
 (2,3),
 (2,5),
 (3,3),
 (3,4),
 (4,1),
 (5,1),
 (5,2),
 (5,3),
 (5,4),
 (5,5),
 (6,1),
 (6,2),
 (7,3),
 (7,5),
 (8,4),
 (8,5);