DROP schema IF EXISTS ejercicio3 cascade;
CREATE schema ejercicio3;

DROP TABLE IF EXISTS ejercicio3.alumno;
CREATE TABLE ejercicio3.alumno (
  nro_alumno integer NOT NULL ,
  dni integer NOT NULL ,
  nombre varchar(45) NOT NULL ,
  apellido varchar(45) NOT NULL ,
  sexo varchar(20) NOT NULL ,
  PRIMARY KEY  (nro_alumno)
);

DROP TABLE IF EXISTS ejercicio3.taller;
CREATE TABLE ejercicio3.taller (
  codigo_taller integer NOT NULL ,
  nombre varchar(45) NOT NULL ,
  duracion integer NOT NULL ,
  PRIMARY KEY (codigo_taller)
);

DROP TABLE IF EXISTS ejercicio3.realiza;
CREATE TABLE ejercicio3.realiza (
  nro_alumno integer NOT NULL ,
  codigo_taller integer NOT NULL ,
  PRIMARY KEY (nro_alumno,codigo_taller),
  constraint fk_realiza_nro_alumno
        foreign key (nro_alumno)
    REFERENCES ejercicio3.alumno (nro_alumno),
  constraint fk_realiza_codigo_taller
    foreign key (codigo_taller) 
    REFERENCES ejercicio3.taller 
);

INSERT INTO ejercicio3.alumno VALUES
 (1, 40133723, 'Juan', 'Lopez', 'masculino'),
 (2, 41012149, 'Ana', 'Garcia', 'femenino'),
 (3, 39915686, 'Matias', 'Gonzalez', 'masculino'),
 (4, 40349213, 'Jorge', 'Romero', 'masculino'),
 (5, 40531020, 'Agustina', 'Diaz', 'femenino'),
 (6, 41294339, 'Clara', 'Suarez', 'femenino'),
 (7, 42247714, 'Alan', 'Acosta', 'masculino'),
 (8, 39893011, 'Antonela', 'Perez', 'femenino');

INSERT INTO ejercicio3.taller VALUES
 (1, 'Cocina', 28),
 (2, 'Reparacion de PC', 56),
 (3, 'Bordado', 28),
 (4, 'Historia Argentina', 14),
 (5, 'Disenio Grafico', 21);

INSERT INTO ejercicio3.realiza VALUES
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
