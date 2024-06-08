CREATE TABLE curso
(
    id        SERIAL PRIMARY KEY,
    nombre    VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE usuario
(
    id                SERIAL PRIMARY KEY,
    nombre            VARCHAR(255) NOT NULL,
    correoElectronico VARCHAR(255) NOT NULL,
    contrasena        VARCHAR(255) NOT NULL
);

CREATE TABLE perfil
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE topico
(
    id            SERIAL PRIMARY KEY,
    titulo        VARCHAR(255) NOT NULL,
    mensaje       TEXT         NOT NULL,
    fechaCreacion TIMESTAMP    NOT NULL,
    status        VARCHAR(50)  NOT NULL,
    autor         INTEGER      NOT NULL,
    curso         INTEGER      NOT NULL,
    FOREIGN KEY (autor) REFERENCES usuario (id),
    FOREIGN KEY (curso) REFERENCES curso (id)
);

CREATE TABLE respuesta
(
    id            SERIAL PRIMARY KEY,
    mensaje       TEXT      NOT NULL,
    topico        INTEGER   NOT NULL,
    fechaCreacion TIMESTAMP NOT NULL,
    autor         INTEGER   NOT NULL,
    solucion      BOOLEAN   NOT NULL,
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
