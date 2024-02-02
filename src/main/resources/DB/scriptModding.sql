CREATE DATABASE modding;
USE modding;

CREATE TABLE propietario (
    id_propietario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    direccion VARCHAR(100),
    telefono VARCHAR(15) 
);

CREATE TABLE coche (
    id_coche INT PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(50),
    marca VARCHAR(50),
    velocidad_maxima INT,
    id_propietario INT,
    FOREIGN KEY (id_propietario) REFERENCES propietario(id_propietario) ON DELETE SET NULL
);

CREATE TABLE modificacion (
    id_modificacion INT PRIMARY KEY AUTO_INCREMENT,
    nombre_modificacion VARCHAR(50),
    velocidad INT
);

CREATE TABLE coche_modificacion (
    id_coche INT,
    id_modificacion INT,
    PRIMARY KEY (id_coche, id_modificacion),
    FOREIGN KEY (id_coche) REFERENCES coche(id_coche),
    FOREIGN KEY (id_modificacion) REFERENCES modificacion(id_modificacion)
);