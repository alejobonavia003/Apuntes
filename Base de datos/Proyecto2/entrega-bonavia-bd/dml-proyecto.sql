
-- insercion de usuarios (id tel direccion)
ALTER SEQUENCE usuario_id_seq RESTART WITH 1;
INSERT INTO Usuario(tel, direccion) VALUES 
('3385-443705', 'calle 5 522 Rio Cuarto'),
('3583-434810', 'Belgrano 554 Rio Cuarto'),
('358-443605', 'constitucion 240 Rio Cuarto'),
('358-432464', 'lavalle 790 Rio Cuarto'),
('358-536345', 'Av. peron este 540 Rio Cuarto'),
('358-146423', 'Av. Peron oeste 523 Rio Cuarto');


-- insercion de personas son (usuarios del 1 al 4) 
INSERT INTO Persona(id, dni, apellido, nombre) VALUES 
(1, 44899798, 'Bonavia', 'Alejo'),
(2, 45954465, 'Fiore', 'Lautaro'),
(3, 43478653, 'Chave', 'Lukas'),
(4, 43354356, 'Bosch', 'Joaquin'); 



-- insercion de empresas son (usuario 5 y 6)
INSERT INTO Empresa(id, nro_cuit, cap_kw) VALUES 
(5, '30-44899798-8', 15000),
(6, '30-44765455-9', 25000);


-- insercion de motivo de reclamo
ALTER SEQUENCE motivo_codigo_seq RESTART WITH 1;
INSERT INTO Motivo(descripcion) VALUES
('por que me trataron mal'),
('dejan los cables colgados'),
('se me corta la luz todos los dias'),
('odio esta empresa'),
('me dieron mal la factura'),
('se callo un poste en el techo de mi casa'),
('cuando pongo la pava se corta la luz'),
('me quede pegado en los cables');

-- insercion de materiales 
ALTER SEQUENCE materiales_codigo_seq RESTART WITH 1;
INSERT INTO Materiales(descripcion) VALUES 
('20 metros de cable'),
('cinta aisladora'),
('un termo un mate y yerba'),
('iterruptor'),
('tester');

-- insercion de reclamos 
ALTER SEQUENCE reclamo_nro_seq RESTART WITH 1;
INSERT INTO Reclamo(fecha_resol, id) VALUES
('05-06-2024', 1),
('12-03-2025', 2),
('08-02-2024', 3),
('23-07-2023', 4),
('26-05-2022', 5),
(NULL, 6); -- reclamo sin resolver 


-- insercion de empleados derivan reclamos 
INSERT INTO deriva(nro, id) VALUES 
(1, 1), -- empleado 1 deriva el reclamo 1
(2, 2), 
(3, 3),
(4, 4),
(4, 5);

-- insercion de llamados 
ALTER SEQUENCE llamado_numero_seq RESTART WITH 1;
INSERT INTO Llamado(nro) VALUES 
(1), (2), (3), (4), (5);
-- no setoy seguro si esta tabla contiene la cantidad de veces que se llamo por un reclamo 

-- insercion de uso de materiales en reclamo 
INSERT INTO Usa(codigo, nro, cantidad) VALUES 
(1, 2, 1),
(2, 6, 1),
(3, 1, 1), -- para el reclamo de que lo trataron mal se soluciono con el material termo y mate 
(4, 3, 4),
(5, 4, 1);

-- luego agrego dos empleados 
insert into Usuario (tel, direccion) values 
('3385-443701', 'Borivilar 270 Rio Cuarto'),
('3385-443709', 'calle 1 400 Rio Cuarto');

