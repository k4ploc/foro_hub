CREATE TABLE topicos
(
    id                SERIAL PRIMARY KEY,
    autor_id          INTEGER NOT NULL,
    título            VARCHAR(255),
    mensaje           TEXT,
    fecha_de_creacion TIMESTAMP,
    status            VARCHAR(255),
    curso             VARCHAR(255),
    activo            BOOLEAN,
    FOREIGN KEY (autor_id) REFERENCES autores (id)
);