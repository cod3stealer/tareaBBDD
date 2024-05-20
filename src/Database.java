import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Agustin Romero Diaz
 * Clase que gestiona la conexión a la base de datos y las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los libros.
 */
public class Database {
    /**
     * Conexión a la base de datos.
     */
    private Connection db;

    /**
     * Constructor que inicializa la conexión a la base de datos y ejecuta el script SQL de creación de la tabla de libros.
     */
    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/libros?currentSchema=Libros", "postgres", "123");

            // Read the libros.sql file
            String librosSql = "";
            try {
                librosSql = new String(Files.readAllBytes(Paths.get("src/Libros.sql")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Execute the SQL script
            try (Statement stmt = db.createStatement()) {
                stmt.executeUpdate(librosSql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade un nuevo libro a la base de datos.
     *
     * @param libro Libro a añadir.
     */
    public void addLibro(Libro libro) {
        String sql = "INSERT INTO Libros (Titulo, Autor, AnoPublicacion, Disponible) VALUES ('"
                + libro.getTitulo() + "', '" + libro.getAutor() + "', " + libro.getFechaPublicacion() + ", " + libro.isDisponible() + ")";

        try (Statement stmt = db.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un libro existente en la base de datos.
     *
     * @param libro Libro a actualizar.
     */
    public void updateLibro(Libro libro) {
        String sql = "UPDATE Libros SET Titulo='" + libro.getTitulo() + "', Autor='" + libro.getAutor()
                + "', AnoPublicacion=" + libro.getFechaPublicacion() + ", Disponible=" + libro.isDisponible()
                + " WHERE ID=" + libro.getID();

        try (Statement stmt = db.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un libro de la base de datos.
     *
     * @param id Identificador único del libro a eliminar.
     */
    public void deleteLibro(int id) {
        String sql = "DELETE FROM Libros WHERE ID=" + id;

        try (Statement stmt = db.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca libros en la base de datos que coincidan con el criterio de búsqueda.
     *
     * @param criteria Criterio de búsqueda (título o autor del libro).
     * @return Lista de libros que coinciden con el criterio de búsqueda.
     */
    public List<Libro> searchLibros(String criteria) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE Titulo ILIKE '%" + criteria + "%' OR Autor ILIKE '%" + criteria + "%'";

        try (Statement stmt = db.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt("ID"), rs.getString("Titulo"), rs.getString("Autor"), rs.getInt("AnoPublicacion"), rs.getBoolean("Disponible"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }
}