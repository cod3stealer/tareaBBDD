import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Santiago Agustin Romero Diaz
 * */
public class GUI extends JFrame {
    /**
     * Constructor de la clase GUI. Inicializa la ventana y añade los componentes necesarios.
     */
    public GUI() {
        Database db = new Database();
        Libro libro = new Libro();
        libro.libros.add(new Libro(0, "El lector de Julio Verne", "Almudena Grande", 2000, true));
        inicializarComponentes(db, libro);
        setVisible(true);
    }

    /**
     * Método que inicializa los componentes de la interfaz gráfica de usuario.
     *
     * @param db   Objeto de la clase Database que representa la base de datos de libros.
     * @param libro Objeto de la clase Libro que representa el libro seleccionado.
     */
    public void inicializarComponentes(Database db, Libro libro) {
        AtomicInteger ID = new AtomicInteger(1);

        JButton addLibro = new JButton("add");
        JButton updateLibro = new JButton("update");
        JButton deleteLibro = new JButton("delete");
        JButton searchLibro = new JButton("search");

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(4, 2));

        content.add(addLibro);
        content.add(updateLibro);
        content.add(deleteLibro);
        content.add(searchLibro);

        // Acción al pulsar el botón "add"
        addLibro.addActionListener(e -> {
            String titulo = "";
            String autor = "";
            int fechaPublicacion = 0;

            while (titulo.isEmpty() || autor.isEmpty() || fechaPublicacion == 0) {
                titulo = JOptionPane.showInputDialog("Introduce el título del libro:");
                autor = JOptionPane.showInputDialog("Introduce el autor del libro:");
                String fechaInput = JOptionPane.showInputDialog("Introduce el año de publicación del libro:");
                fechaPublicacion = Integer.parseInt(fechaInput);
            }

            libro.libros.add(new Libro(ID.get(), titulo, autor, fechaPublicacion, true));

            db.addLibro(libro.libros.get(ID.get()));

            ID.getAndIncrement();
        });

        // Acción al pulsar el botón "update"
        updateLibro.addActionListener(e -> {
            String titulo;
            String autor;
            int fechaPublicacion;
            int IDlibro;

            JOptionPane.showMessageDialog(null, "Si no quieres modificar un campo en especifico, simplemente no introduzcas nada");
            JOptionPane.showMessageDialog(null, "Introduce el ID del libro que quieres modificar");
            IDlibro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID:"));
            titulo = JOptionPane.showInputDialog("Introduce el título del libro:");
            autor = JOptionPane.showInputDialog("Introduce el autor del libro:");
            String fechaInput = JOptionPane.showInputDialog("Introduce el año de publicación del libro:");
            fechaPublicacion = Integer.parseInt(fechaInput);


            libro.libros.add(new Libro(IDlibro, titulo, autor, fechaPublicacion, true));
            db.updateLibro(libro.libros.get(ID.get()));
            ID.getAndIncrement();
        });

        // Acción al pulsar el botón "delete"
        deleteLibro.addActionListener(e -> {
            int id = -1;
            while (id == -1) {
                id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del libro que quieres eliminar:"));
            }
            db.deleteLibro(id);
            libro.libros.remove(id);
            ID.getAndIncrement();
        });

        // Acción al pulsar el botón "search"
        searchLibro.addActionListener(e -> {
            String busqueda = "";
            while (busqueda.isEmpty()) {
                busqueda = JOptionPane.showInputDialog("Introduce el nombre del autor o el nombre del libro que quieres buscar: ");
            }
            for (Libro l : db.searchLibros(busqueda)) {
                if (l != null) {
                    JOptionPane.showMessageDialog(null, "Es este tu libro?\n" + l.getTitulo() + "\n" + l.getAutor() + "\n" + l.getFechaPublicacion() + "\n" + l.getID());
                    break;
                }
            }
        });

        add(content);
        setPreferredSize(new Dimension(1080, 720));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}
