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
