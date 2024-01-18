USE modding;

INSERT INTO propietario (nombre, direccion, telefono)
VALUES 
    ('Juan Pérez', 'Calle 123, Ciudad XYZ', '+34 123 456 789'),
    ('María Rodríguez', 'Avenida ABC, Ciudad XYZ', '+34 987 654 321'),
    ('Ana Gómez', 'Carrera 456, Ciudad XYZ', '+34 111 222 333'),
    ('Carlos Martínez', 'Calle 789, Ciudad XYZ', '+34 444 555 666');

INSERT INTO coche (modelo, marca, velocidad_maxima, id_propietario)
VALUES
    ('Sedán', 'Toyota', 200, 1),
    ('Deportivo', 'Ferrari', 350, 2),
    ('SUV', 'Jeep', 180, 1),
    ('Compacto', 'Honda', 180, 3),
    ('Camioneta', 'Ford', 220, 4);

INSERT INTO modificacion (nombre_modificacion)
VALUES
    ('Tubo de escape'),
    ('Alerón'),
    ('Suspensión deportiva'),
    ('Llantas de aleación'),
    ('Frenos mejorados'),
    ('Kit de carrocería');

INSERT INTO coche_modificacion (id_coche, id_modificacion)
VALUES
    (1, 1),
    (1, 3),
    (2, 2),
    (3, 1),
    (3, 3),
    (4, 4),
    (4, 5),
    (5, 5),
    (5, 6);
