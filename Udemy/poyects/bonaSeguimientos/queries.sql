CREATE TABLE seguimiento_cultivo (
    id SERIAL PRIMARY KEY, -- Identificador único para cada registro
    fecha DATE NOT NULL, -- Fecha del registro
    riego BOOLEAN NOT NULL, -- Indica si hubo riego (Sí o No)
    fertilizacion BOOLEAN NOT NULL, -- Indica si hubo fertilización (Sí o No)
    anomalias TEXT, -- Descripción de anomalías en las hojas
    foto BYTEA, -- Almacena la imagen de la planta en formato binario
    notas TEXT, -- Notas y observaciones adicionales
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha y hora de creación del registro
);

CREATE TABLE historial_gastos (
    id serial PRIMARY KEY, -- Identificador único para cada gasto
    concepto VARCHAR(255) NOT NULL,   -- Concepto del gasto
    monto DECIMAL(10, 2) NOT NULL,    -- Monto del gasto
    responsable VARCHAR(100) NOT NULL, -- Responsable del gasto
    fecha DATE NOT NULL                -- Fecha del gasto
);

INSERT INTO seguimiento_cultivo (fecha, riego, fertilizacion, anomalias, foto, notas) VALUES
('2024-12-20', true, false, 'Hojas amarillas', NULL, 'Riego suficiente, revisar fertilización.'),
('2024-12-19', false, true, NULL, NULL, 'Fertilización realizada, sin riego.'),
('2024-12-18', true, true, 'Hojas secas', NULL, 'Buen crecimiento observado.'),
('2024-12-17', true, false, NULL, NULL, 'Solo riego, sin anomalías.'),
('2024-12-16', true, true, NULL, NULL, 'Riego y fertilización completados.'),
('2024-12-15', false, false, 'Manchas marrones', NULL, 'Posible exceso de humedad.'),
('2024-12-14', true, false, NULL, NULL, 'Riego realizado, crecimiento regular.'),
('2024-12-13', false, false, 'Hojas caídas', NULL, 'Condiciones de luz insuficientes.'),
('2024-12-12', true, true, NULL, NULL, 'Sin observaciones anómalas.'),
('2024-12-11', true, false, 'Hojas amarillas', NULL, 'Ajustar cantidad de fertilizante.');



INSERT INTO historial_gastos (concepto, monto, responsable, fecha) VALUES
('Compra de fertilizantes', 1200.50, 'Juan Pérez', '2024-12-15'),
('Pago de luz', 3000.00, 'Ana López', '2024-12-14'),
('Compra de semillas', 800.75, 'Carlos Gómez', '2024-12-13'),
('Mantenimiento del sistema de riego', 4500.00, 'Lucía Martínez', '2024-12-12'),
('Herramientas para poda', 2300.00, 'Juan Pérez', '2024-12-11'),
('Compra de tierra', 1500.00, 'Ana López', '2024-12-10'),
('Renovación de macetas', 2500.00, 'Carlos Gómez', '2024-12-09'),
('Fertilizantes orgánicos', 1100.00, 'Lucía Martínez', '2024-12-08'),
('Pago de agua', 2700.00, 'Juan Pérez', '2024-12-07'),
('Insecticidas', 900.00, 'Ana López', '2024-12-06');

