package Codigo;
/**
 * Define las operaciones de las Clases que implementan ILibreria.
 *
 * @author Micaela Olivera
 */
public interface ILibreria {

    /**
     * Operacion que definira la carga de los objetos Autor.
     *
     * @param archivoAutores String con la ruta del archivo del cual se tomaran
     * los datos para general los objetos Autor.
     */
    public void cargarAutores(String archivoAutores);

    /**
     * Operacion que definira la carga de los objetos Libro.
     *
     * @param archvoiLibros String con la ruta del archivo del cual se tomaran
     * los datos para general los objetos Libro.
     */
    public void cargarLibros(String archvoiLibros);

    /**
     * Operacion que definira la carga de los objetos Tag.
     *
     * @param archvoiLibros String con la ruta del archivo del cual se tomaran
     * los datos para general los objetos Tag.
     */
    public void cargarTags(String archvoiLibros);

    /**
     * Método que retorna una Lista enlazada de objetos Libro, contenida en los
     * objetos que implementen la Interface ILibreria.
     *
     * @return Lista de objetos Libro
     */
    public ILista<Libro> obtenerLibros();

    /**
     * Método que retorna una Lista enlazada de objetos Autor, contenida en los
     * objetos que implementen la Interface ILibreria.
     *
     * @return Lista de objetos Actor.
     */
    public ILista<Autor> obtenerAutores();

    /**
     * Método que retorna una Lista enlazada de objetos Tag, contenida en los
     * objetos que implementen la Interface ILibreria.
     *
     * @return Lista de objetos Tag.
     */
    public ILista<Tag> obtenerTags();

    /**
     * Método que imprime por pantalla la informacion de los objetos Libro de la
     * lista enlazada de libros,contenida en el objeto que implementa la
     * interface ILibreria, donde cada Libro estara relacionado con la variable
     * fecha siempre y cuando la fecha del libro sea igual o mayor a la recibida
     * por parametro.
     *
     * @param anio int con un valor determinado por el usuario.
     */
    public void mostrarPorFecha(int anio);

    /**
     * Método que imprime por pantalla la informacion de los objetos Libro de la
     * lista enlazada de Libros, contenida en el objeto que implementa la
     * interface ILibreria, donde cada Libro estara relacionado con la variable
     * fecha y nombre recibidos por parametro.
     *
     * @param fecha int con un valor determinado por el usuario.
     * @param nombre String con un valor determinado por el usuario.
     */
    public void buscarFechaNombre(int fecha, String nombre);

    /**
     * Método que imprime por pantalla la informacion de los objetos Libro de la
     * lista enlazada de Libros, contenida en el objeto que implementa la
     * interface ILibreria, donde cada Libro estara relacionado con la variable
     * isbn recibida por parametro.
     *
     * @param isbn String con un valor determinado por el usuario.
     */
    public void mostrarPorIsbn(String isbn);

    /**
     * Metodo que imprime por pantalla la informacion de los objetos Libro de la
     * lista enlazada de Libros, contenida en el objeto que implementa la
     * interface ILibreria, donde cada libro estara relacionado mediante su Id,
     * al Id cuyo nombre de autor coincida con el recibido por paramentro.
     * Tambien se imprimira la informacion del Autor cuyo nombre se recibira por
     * parametro.
     *
     * @param nombreAutor
     */
    public void mostrarPorAutor(String nombreAutor);

    /**
     * Metodo que imprime por pantalla la informacion de los objetos Libro de la
     * lista enlazada de Libros, contenida en el objeto que implementa la
     * interface ILibreria, donde cada libro estara relacionado mediante su Id,
     * al Id cuyo nombre de genero coincida con el recibido por paramentro.
     * Tambien se imprimira la informacion del genero cuyo nombre se recibira
     * por parametro.
     *
     * @param genero
     */
    public void mostrarPorGenero(String genero);

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Tag cargados en la lista enlazada tags del objero Libreria.
     */
    public void verTags();

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Libro cargados en la lista enlazada libros del objero Libreria.
     */
    public void verLibros();

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Autor cargados en la lista enlazada autores del objero Libreria.
     */
    public void verAutores();

    /**
     * Metodo encargado de buscar un autor en la lista enlazada de autores de la
     * Libreria e imprimir su informacion basica.
     *
     * @param nombre String definido por el usuario.
     */
    public void buscarAutor(String nombre);

    /**
     * Metodo encargado de buscar un libro en la lista enlazada de libros de la
     * Libreria e imprimir su informacion basica.
     *
     * @param nombre String definido por el usuario.
     */
    public void buscarLibro(String nombre);

    /**
     * Metodo encargado de buscar un autor en la lista enlazada de autores le la
     * libreria y eliminarlo. Tambien se realiza la busqueda de los libros cuyo
     * numero Id este relacionado con el del Autor eliminado, y se eliminan de
     * la lista enlazada de libros.
     *
     * @param autor String definido por el usuario
     */
    public void eliminarLibroAutor(String autor);

}
