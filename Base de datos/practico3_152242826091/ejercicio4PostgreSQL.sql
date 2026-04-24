
drop schema if exists ejercicio4 cascade;
CREATE schema ejercicio4;

DROP TABLE IF EXISTS ejercicio4.deporte;
CREATE TABLE ejercicio4.deporte (
  cod_deporte integer NOT NULL ,
  denominacion varchar(45) NOT NULL default '',
  PRIMARY KEY  (cod_deporte)
);

DROP TABLE IF EXISTS ejercicio4.competidor;
CREATE TABLE ejercicio4.competidor (
  nro_competidor integer NOT NULL ,
  pais varchar(25) NOT NULL default '',
  anio integer NOT NULL ,
  nombre varchar(45) NOT NULL default '',
  cod_deporte integer NOT NULL ,
  PRIMARY KEY  (nro_competidor)
);

DROP TABLE IF EXISTS ejercicio4.medalla;
CREATE TABLE ejercicio4.medalla (
  pais varchar(20) NOT NULL default '',
  tipo_medalla varchar(20) NOT NULL default '',
  anio integer NOT NULL ,
  cantidad integer NOT NULL ,
  PRIMARY KEY  (pais,tipo_medalla,anio)
) ;

DROP TABLE IF EXISTS ejercicio4.competicion;
CREATE TABLE ejercicio4.competicion (
  pais varchar(25) NOT NULL default '',
  cod_deporte integer NOT NULL ,
  anio integer NOT NULL ,
  PRIMARY KEY  (pais,cod_deporte,anio)
) ;

INSERT INTO ejercicio4.deporte VALUES
 (1,'SALTO EN LARGO'),
 (2,'SALTO EN ALTO'),
 (3,'CARRERA 100 MTS'),
 (4,'CARRERA 200 MTS'),
 (5,'CARRERA 100 MTS CON OBSTACULOS'),
 (6,'NATACION');

INSERT INTO ejercicio4.competidor VALUES
 (1,'ARGENTINA',2000,'PEDRO',1),
 (2,'ARGENTINA',2000,'JUAN',1),
 (3,'ARGENTINA',2000,'JOSE',1),
 (4,'ARGENTINA',2000,'JUAN',2),
 (5,'BRASIL',2001,'MARTIN',5),
 (6,'BRASIL',2001,'PEDRO',5),
 (7,'BRASIL',2001,'ALBERTO',5),
 (8,'URUGUAY',2002,'MARTIN',5),
 (9,'URUGUAY',2002,'PEDRO',4),
 (10,'URUGUAY',2002,'PEDRO',3),
 (11,'ARGENTINA',2000,'PEDRO',2),
 (12,'ARGENTINA',2003,'JOSE',6),
 (13,'URUGUAY',2003,'MARTIN',6),
 (14,'BRASIL',2003,'PEDRO',6);

INSERT INTO ejercicio4.competicion VALUES
 ('ARGENTINA',1,2000),
 ('ARGENTINA',2,2000),
 ('ARGENTINA',6,2003),
 ('BRASIL',5,2001),
 ('BRASIL',6,2003),
 ('URUGUAY',3,2002),
 ('URUGUAY',4,2002),
 ('URUGUAY',5,2002),
 ('URUGUAY',6,2003);

INSERT INTO ejercicio4.medalla VALUES
 ('ARGENTINA','PLATA',2000,1),
 ('ARGENTINA','BRONCE',2000,1),
 ('URUGUAY','BRONCE',2002,1),
 ('BRASIL','ORO',2000,1),
 ('BRASIL','PLATA',2003,1);

