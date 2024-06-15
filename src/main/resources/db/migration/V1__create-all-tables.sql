CREATE TABLE curso
(
    id        SERIAL PRIMARY KEY,
    nombre    VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

INSERT INTO curso (nombre, categoria)
VALUES ('Introducción a Python', 'PROGRAMACION');
INSERT INTO curso (nombre, categoria)
VALUES ('Comunicación Efectiva', 'SOFTSKILL');
INSERT INTO curso (nombre, categoria)
VALUES ('Manejo de Software de Adobe', 'SOFTWARE');
INSERT INTO curso (nombre, categoria)
VALUES ('Resolución de Problemas en Programación', 'PROGRAMACION');
INSERT INTO curso (nombre, categoria)
VALUES ('Liderazgo y Gestión de Equipos', 'SOFTSKILL');


CREATE TABLE usuario
(
    id                 SERIAL PRIMARY KEY,
    nombre             VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL,
    contrasena         VARCHAR(255) NOT NULL
);
INSERT INTO usuario(nombre, correo_electronico, contrasena)
VALUES ('admin', 'amind@mail.com', '$2a$12$6Vrj1ND8jHQ5ryxSDQD.D.XMcIzoH60a8HKTIvQNfXuwm5wQqjfwq');

CREATE TABLE perfil
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

INSERT INTO perfil (nombre)
VALUES ('DOCENTE');
INSERT INTO perfil (nombre)
VALUES ('ALUMNO');


CREATE TABLE topico
(
    id             SERIAL PRIMARY KEY,
    titulo         VARCHAR(255) NOT NULL,
    mensaje        TEXT         NOT NULL,
    fecha_creacion TIMESTAMP    NOT NULL,
    status         VARCHAR(50)  NOT NULL,
    autor          INTEGER      NOT NULL,
    curso          INTEGER      NOT NULL,
    FOREIGN KEY (autor) REFERENCES usuario (id),
    FOREIGN KEY (curso) REFERENCES curso (id)
);

CREATE TABLE respuesta
(
    id             SERIAL PRIMARY KEY,
    mensaje        TEXT      NOT NULL,
    topico         INTEGER   NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    autor          INTEGER   NOT NULL,
    solucion       BOOLEAN   NOT NULL,
    FOREIGN KEY (topico) REFERENCES topico (id),
    FOREIGN KEY (autor) REFERENCES usuario (id)
);

CREATE TABLE usuario_perfil
(
    usuario_id INTEGER NOT NULL,
    perfil_id  INTEGER NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id),
    FOREIGN KEY (perfil_id) REFERENCES perfil (id)
);
