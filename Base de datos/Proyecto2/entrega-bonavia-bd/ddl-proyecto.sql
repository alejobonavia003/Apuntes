CREATE TABLE Usuario(
 id serial UNIQUE NOT NULL,
 tel varchar(50),
 direccion varchar(50),
PRIMARY KEY (id));

CREATE TABLE Reclamo(
 nro serial UNIQUE NOT NULL,
 fecha_resol varchar(50),
 id serial UNIQUE NOT NULL,
FOREIGN KEY (id) REFERENCES Usuario (id) ON DELETE CASCADE,
PRIMARY KEY (nro));

CREATE TABLE Empresa(
 id serial UNIQUE NOT NULL,
 nro_cuit varchar(50),
 cap_kw integer,
 CONSTRAINT capacidad CHECK (cap_kw >= 0 AND cap_kw <= 50000),
FOREIGN KEY (id) REFERENCES Usuario (id),
PRIMARY KEY (id));

CREATE TABLE Persona(
 id serial NOT NULL,
 dni integer UNIQUE,
 apellido varchar(50),
 nombre varchar(50),
 CONSTRAINT dniper CHECK (dni > 0 AND dni < 1000000000), 
FOREIGN KEY (id) REFERENCES Usuario (id),
PRIMARY KEY (id));

CREATE TABLE Empleado(
 id serial UNIQUE NOT NULL,
 sueldo varchar(50),
FOREIGN KEY (id) REFERENCES Usuario (id),
PRIMARY KEY (id));

CREATE TABLE deriva(
 nro serial NOT NULL,
 id serial NOT NULL,
FOREIGN KEY (nro) REFERENCES Reclamo (nro),
FOREIGN KEY (id) REFERENCES Usuario (id),
PRIMARY KEY (nro,id));

CREATE TABLE Motivo(
 codigo serial UNIQUE NOT NULL,
 descripcion varchar(50),
PRIMARY KEY (codigo));

CREATE TABLE Materiales(
 codigo serial UNIQUE NOT NULL,
 descripcion varchar(50),
PRIMARY KEY (codigo));

CREATE TABLE Llamado(
 numero serial UNIQUE NOT NULL,
 nro serial UNIQUE NOT NULL,
FOREIGN KEY (nro) REFERENCES Reclamo (nro) ON DELETE CASCADE,
PRIMARY KEY (numero,nro));

CREATE TABLE Usa(
 codigo serial NOT NULL,
 nro serial NOT NULL,
 cantidad integer NOT NULL,
FOREIGN KEY (codigo) REFERENCES Materiales (codigo),
FOREIGN KEY (nro) REFERENCES Reclamo (nro) ON DELETE CASCADE,
PRIMARY KEY (codigo,nro));

CREATE TABLE auditoria(
 id_auditoria serial PRIMARY KEY,
 nro_reclamo_eliminado integer NOT NULL,
 fecha_eliminacion timestamp DEFAULT CURRENT_TIMESTAMP,
 usuario_id integer,
 fecha_resol_reclamo varchar(50),
 usuario_que_elimino varchar(50)
);

CREATE function funcion_auditoria() returns trigger as $$
begin insert into auditoria(nro_reclamo_eliminado, usuario_id, fecha_resol_reclamo,usuario_que_elimino) 
values(old.nro, old.id , old.fecha_resol,current_user);
return old;
end; 
$$ LANGUAGE plpgsql;

create trigger trigger_auditoria after delete on reclamo for each row
execute procedure funcion_auditoria();

--create schema lauti;


