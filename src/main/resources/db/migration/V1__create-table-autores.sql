CREATE TABLE autores
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(30),
    email  VARCHAR(50),
    activo BOOLEAN
);