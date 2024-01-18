CREATE DATABASE modding;
USE modding;

INSERT INTO propietario (nombre, direccion, telefono)
VALUES 
    ('Juan Pérez', 'Calle 123, Ciudad XYZ', 123456789),
    ('María Rodríguez', 'Avenida ABC, Ciudad XYZ', 987654321),
    ('Ana Gómez', 'Carrera 456, Ciudad XYZ', 111222333),
    ('Carlos Martínez', 'Calle 789, Ciudad XYZ', 444555666);

INSERT INTO coche (modelo, marca, velocidad_maxima, id_propietario)
VALUES
    ('Sedán', 'Toyota', 200, 1),
    ('Deportivo', 'Ferrari', 350, 2),
    ('SUV', 'Jeep', 180, 1),
    ('Compacto', 'Honda', 180, 3),
    ('Camioneta', 'Ford', 220, 4);

INSERT INTO modificacion (nombre_modificacion, velocidad)
VALUES
    ('Tubo de escape',15),
    ('Alerón',20),
    ('Suspensión deportiva',15),
    ('Llantas de aleación',5),
    ('Frenos mejorados',0),
    ('Kit de carrocería',3);

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