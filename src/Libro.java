import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Agustin Romero Diaz
 * Representa un libro con sus características básicas.
 */
public class Libro {
    /**
     * Identificador único del libro.
     */
    public int ID;

    /**
     * Año de publicación del libro.
     */
    public int fechaPublicacion;

    /**
     * Título del libro.
     */
    public String titulo;

    /**
     * Autor del libro.
     */
    public String autor;

    /**
     * Indica si el libro está disponible para préstamo.
     */
    public boolean disponible;

    /**
     * Lista de libros (no se utiliza en este ejemplo, pero se deja para futuras implementaciones).
     */
    public List<Libro> libros = new ArrayList<>();

    /**
     * Constructor que inicializa un libro con sus características básicas.
     *
     * @param ID          Identificador único del libro.
     * @param titulo      Título del libro.
     * @param autor       Autor del libro.
     * @param fechaPublicacion Año de publicación del libro.
     * @param disponible  Indica si el libro está disponible para préstamo.
     */
    public Libro(int ID, String titulo, String autor, int fechaPublicacion, boolean disponible) {
        this.ID = ID;
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    /**
     * Constructor vacío para inicializar un libro sin características.
     */
    public Libro(){}

    /**
     * Obtiene el identificador único del libro.
     *
     * @return Identificador único del libro.
     */
    public int getID() {
        return ID;
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param ID Identificador único del libro.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Obtiene el año de publicación del libro.
     *
     * @return Año de publicación del libro.
     */
    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Establece el año de publicación del libro.
     *
     * @param fechaPublicacion Año de publicación del libro.
     */
    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return Autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor Autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Indica si el libro está disponible para préstamo.
     *
     * @return true si el libro está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del libro para préstamo.
     *
     * @param disponible true si el libro está disponible, false en caso contrario.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
