# Tarea repaso BBDD

## Actividad: Sistema de Gestión de Biblioteca con PostgreSQL y Java

### Objetivo: Desarrollar una aplicación en Java que interactúe con una base de datos PostgreSQL para gestionar una biblioteca. Los alumnos deberán crear funcionalidades para añadir, actualizar, eliminar y consultar libros en la base de datos.

### Descripción de la Actividad:
Esta actividad tiene como objetivo que los estudiantes apliquen sus conocimientos en programación Java y manejo de bases de datos usando PostgreSQL para crear un sistema de gestión de biblioteca sencillo. Los alumnos deberán implementar una interfaz de usuario que permita realizar operaciones básicas de gestión de libros.

### Requisitos:

# Base de Datos:
Utilizar PostgreSQL para crear una base de datos llamada Biblioteca.
entro de la base de datos, crear una tabla Libros que incluya los siguientes campos:
D (clave primaria, autoincrementable) Título- Autor- Año de Publicación (AnoPublicacion)- Disponible (booleano)

### Funcionalidades de la Aplicación:
- Agregar Libros: Formulario para introducir los datos de un nuevo libro y guardarlo en la base de datos.
- Actualizar Libros: Opción para modificar los detalles de un libro existente.
- Eliminar Libros: Opción para eliminar un libro de la base de datos.
- Consultar Libros: Vista para buscar libros por diferentes criterios (por ejemplo, título, autor, año de publicación) y mostrar los libros que cumplen con el criterio.

### Interfaz Gráfica:
- Desarrollar una interfaz gráfica usando Java Swing.
- La interfaz debe ser intuitiva y fácil de usar, con botones claros y formularios para la entrada de datos.

### Ejemplo de Código para Crear la Tabla en PostgreSQL:
```sql
CREATE TABLE Libros (
  ID SERIAL PRIMARY KEY,
  Titulo VARCHAR(255),
  Autor VARCHAR(255),
  AnoPublicacion INT,
  Disponible BOOLEAN
);
```