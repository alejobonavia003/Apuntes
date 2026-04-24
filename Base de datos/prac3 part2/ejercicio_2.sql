set search_path = part2;

alter table vacunas add
	constraint al_borrar 
		foreign key vacunas (cod_vacuna)
			references vacunados (cod_vacuna)
			on delete cascade; 


set search_path = part2;

-- ---------------------------
-- Script de carga de datos
-- ---------------------------

-- Insertar municipios
INSERT INTO municipios (municipio, provincia) VALUES
('Cordoba', 'Cordoba'),
('Rio Cuarto', 'Cordoba'),
('Mendoza', 'Mendoza'),
('Rosario', 'Santa Fe'),
('Santa Fe', 'Santa Fe');

-- Insertar vacunas
INSERT INTO vacunas (cod_vacuna, nombre) VALUES
('VAC001', 'COVID'),
('VAC002', 'FIEBRE'),
('VAC003', 'AMARILLA'),
('VAC004', 'DENGUE'),
('VAC005', 'SARAMPION');

-- Insertar personas
INSERT INTO personas (dni, nombre, edad, municipio) VALUES
('12345678', 'Juan Perez', 35, 'Cordoba'),
('87654321', 'Maria Gomez', 28, 'Rio Cuarto'),
('11223344', 'Luis Martinez', 42, 'Mendoza'),
('44332211', 'Ana Lopez', 50, 'Rosario'),
('55667788', 'Pedro Alvarez', 22, 'Santa Fe');

-- Insertar contagios
INSERT INTO contagios (dni, cepa) VALUES
('12345678', 'ALFA'),
('87654321', 'DELTA'),
('11223344', 'OMICRON');

-- Insertar vacunados
INSERT INTO vacunados (dni, cod_vacuna) VALUES
('12345678', 'VAC001'),
('87654321', 'VAC002'),
('11223344', 'VAC001'),
('44332211', 'VAC004'),
('55667788', 'VAC005');


		
		
