CREATE SCHEMA IF NOT EXISTS libros;

CREATE TABLE IF NOT EXISTS Libros.libros.Libros (
    ID SERIAL PRIMARY KEY,
    Titulo VARCHAR(255),
    Autor VARCHAR(255),
    AnoPublicacion INT,
    Disponible BOOLEAN
);