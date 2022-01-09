/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoindividual.Codigo;

/**
 * Clase que implementa la Interface ILibreria, conteniendo una serie de listas
 * enlazadadas que contienen objetos Libros, Autor y Tags, así como métodos para
 * accedar a toda la información contenida en las mismas.
 *
 * @author Micaela Olivera
 */
public class Libreria implements ILibreria {

    private final Lista<Libro> libros;
    private final Lista<Autor> autores;
    private final Lista<Tag> tags;
    private TArbolAVL<Lista> arbolTags;

    /**
     * Constructor de la clase Libreria
     */
    public Libreria() {

        this.autores = new Lista<>();
        this.libros = new Lista<>();
        this.tags = new Lista<>();

    }

    /**
     * Metodo que devuelve la lista enlazada simple de objetos Libro.
     *
     * @return lista de objetos Libro.
     */
    @Override
    public ILista<Libro> obtenerLibros() {

        return this.libros;

    }

    /**
     * Metodo que devuelve la lista enlazada simple de objetos Autor.
     *
     * @return lista de objetos Autor.
     */
    @Override
    public ILista<Autor> obtenerAutores() {
        return this.autores;
    }

    /**
     * Metodo que devuelve la lista enlazada simple de objetos Tag.
     *
     * @return lista de objetos tag.
     */
    @Override
    public ILista<Tag> obtenerTags() {

        return this.tags;
    }

    /**
     * Metodo que define la carga de los Objetos Autor, mediante el uso de un
     * archivo cuyos datos seran utilizados para definir los atributos del
     * mismo.
     *
     * @param archivoAutores String con la ruta del archivo que se utilizara
     * para la carga de autores. Sera definido por defecto.
     */
    @Override
    public void cargarAutores(String archivoAutores) {

        String[] listaAutores = ManejadorArchivosGenerico.leerArchivo(archivoAutores);
        for (int i = 0; i < listaAutores.length; i++) {
            try {
                String[] lineaAProcesar = listaAutores[i].split("\\|");
                Autor autor = new Autor(Integer.parseInt(lineaAProcesar[0].trim()),
                        lineaAProcesar[1].trim());
                /*Se crea un nuevo nodo, cuya carga es el Autor antes
                 *instanciado.
                 */
                Nodo<Autor> nuevoNodo;
                nuevoNodo = new Nodo<>(autor, autor.getID());
                /*Se chequea que el autor no haya sido ingresado con
                 *anterioridad.
                 */
                Nodo<Autor> buscarNuevoNodo;
                buscarNuevoNodo = autores.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.*/
                if (buscarNuevoNodo == null) {
                    autores.insertatInicio(nuevoNodo);

                }
            } catch (Exception e) {
                System.err.println("Autor no cargado");
            }
        }
    }

    /**
     * Metodo que define la carga de los Objetos Tag, mediante el uso de un
     * archivo cuyos datos seran utilizados para definir los atributos del
     * mismo.
     *
     * @param archivoTags String con la ruta del archivo que se utilizara para
     * la carga de tags. Sera definido por defecto.
     */
    @Override
    public void cargarTags(String archivoTags) {

        String[] listaTags = ManejadorArchivosGenerico.leerArchivo(archivoTags);
        
        this.arbolTags = new TArbolAVL();
        
        for (int i = 0; i < listaTags.length; i++) {
            try {
                String[] lineaAProcesar = listaTags[i].split("\\|");
                Tag tag = new Tag(Integer.parseInt(lineaAProcesar[0].replaceAll("\"", "")), lineaAProcesar[1].replaceAll("\"", ""));
                
                
                String etiqueta = lineaAProcesar[1].replaceAll("\"", "");
                Lista<Libro> listaLibrosAsociados = new Lista<>();
                TElementoAVL<Lista> elemento = new TElementoAVL(etiqueta,listaLibrosAsociados);
                arbolTags.insertar(elemento);
                
                /*Se crea un nuevo nodo, cuya carga es el Tag antes 
                 *instanciado.                
                 */
                Nodo<Tag> nuevoNodo;
                nuevoNodo = new Nodo<>(tag, tag.getID());
                /*Se chequea que el Tag no haya sido ingresado con 
                 *anterioridad.                
                 */
                Nodo<Tag> buscarNuevoNodo;
                buscarNuevoNodo = tags.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.*/
                if (buscarNuevoNodo == null) {
                    tags.insertatInicio(nuevoNodo);

                }
                
                
            } catch (Exception e) {
                System.err.println("Tag no cargado");
            }
            
           
            
            
        }
    }

    public void cargarLibrosDeTag(Lista<Libro> lista, String etiquetaTag){
        
        
        
    }
    /**
     * Metodo que define la carga de los Objetos Libro, mediante el uso de un
     * archivo cuyos datos seran utilizados para definir los atributos del
     * mismo.
     *
     * @param archivosLibros String con la ruta del archivo que se utilizara
     * para la carga de libros. Sera definido por defecto.
     */
    @Override
    public void cargarLibros(String archivosLibros) {

        String[] listaLibros = ManejadorArchivosGenerico.leerArchivo(archivosLibros);
        for (int i = 0; i < listaLibros.length; i++) {

            try {
                String[] lineaAProcesar = listaLibros[i].split("\\|");
                Libro libro = new Libro(Integer.parseInt(lineaAProcesar[0].trim()), lineaAProcesar[1].trim(),
                        Integer.parseInt(lineaAProcesar[2].trim()), Float.parseFloat(lineaAProcesar[3].trim()),
                        Integer.parseInt(lineaAProcesar[4].trim()), lineaAProcesar[5].trim());
                /*
                Se crea un nuevo nodo, cuya carga sera el Libro antes
                instanciado.
                 */
                Nodo<Libro> nuevoNodo;
                nuevoNodo = new Nodo<>(libro, libro.getID());
                /*
                Se chequea que el Libro no haya sido ingresado con anterioridad. 
                 */
                Nodo<Libro> buscarNuevoNodo;
                buscarNuevoNodo = libros.buscar(nuevoNodo.getEtiqueta());
                /* se inserta el nodo en la lista*/
                if (buscarNuevoNodo == null) {
                    libros.insertatInicio(nuevoNodo);
                }
            } catch (Exception e) {
                //System.err.println("Libro no cargado");
            }

        }
    }

    /**
     * Metodo encargado de imprimir en pantalla la informacion de los Objetos
     * Libro contenido en la lista enlazada del Objeto Libreria, cuyo datos
     * fecha y nombre coincidan con los recibidor por parametro.
     *
     * @param fecha int definido por el usuario.
     * @param nombre String definido por el usuario.
     */
    @Override
    public void buscarFechaNombre(int fecha, String nombre) {
        Nodo<Libro> unLibro = this.libros.getPrimero();

        boolean encontrado = true;
        while (unLibro != null && encontrado == true) {
            if (unLibro.getDato().getNombre().equals(nombre)) {
                if (unLibro.getDato().getAnio() == fecha) {
                    unLibro.getDato().mostrarInfo();
                    encontrado = false;

                }

                unLibro = unLibro.getSiguiente();

            }

            unLibro = unLibro.getSiguiente();

        }
        if (encontrado == true) {
            System.out.println("No se encuentran coincidencias");
        }

    }

    /**
     * *
     * Metodo encargado de imprimir en pantalla la informacion de los Objetos
     * Libro contenido en la lista enlazada del Objeto Libreria, cuyo datos
     * fecha sea mayor o igual al recibido por parametro.
     *
     * @param anio int definido por el usuario
     */
    @Override
    public void mostrarPorFecha(int anio) {

        Nodo<Libro> unLibro = this.libros.getPrimero();

        boolean encontrado = true;
        while (unLibro != null) {
            if (unLibro.getDato().getAnio() >= anio) {
                unLibro.getDato().mostrarInfo();
                unLibro = unLibro.getSiguiente();
                encontrado = false;

            }
            unLibro = unLibro.getSiguiente();
        }
        if (encontrado == true) {
            System.out.println("No hay libros del año " + anio);
        }

    }

    /**
     * Metodo encargado de imprimir en pantalla la informacion de los Objetos
     * Libro contenido en la lista enlazada del Objeto Libreria, cuyo dato isbn
     * coincidan con los recibidor por parametro.
     *
     * @param isbn String definido por el usuario
     */
    @Override
    public void mostrarPorIsbn(String isbn) {

        Nodo<Libro> unLibro = this.libros.getPrimero();

        boolean encontrado = true;
        while (unLibro != null && encontrado == true) {
            if (unLibro.getDato().getIsbn().equals(isbn)) {
                unLibro.getDato().mostrarInfo();
                encontrado = false;

            }

            unLibro = unLibro.getSiguiente();

        }
        if (encontrado == true) {
            System.out.println("No se encuentran coincidencias");
        }
    }

    /**
     * Metodo encargado de imprimir en pantalla la informacion de los Objetos
     * Libro contenido en la lista enlazada del Objeto Libreria, cuyo dato ID se
     * encuentre relacionado con el ID del objeto Autor contenido en la lista de
     * autores de la Libreria.
     *
     * @param nombreAutor String definido por el usuario
     */
    @Override
    public void mostrarPorAutor(String nombreAutor) {

        Comparable IdAutor = null;
        Nodo<Autor> unAutor = autores.getPrimero();

        boolean encontrado = true;
        /* se busca el autor en la lista de autores*/
        while (unAutor != null) {

            if (unAutor.getDato().getNombre().equals(nombreAutor)) {
                IdAutor = unAutor.getDato().getID();
                /* si encuentra el Autor imprime la informacion*/
                unAutor.getDato().mostrarInfo();

                String[] listaLibroAutores = ManejadorArchivosGenerico.leerArchivo("src/ProyectoIndividual/DataBase/bookauthors.csv");
                for (int i = 0; i < listaLibroAutores.length; i++) {
                    String[] lineaAProcesar = listaLibroAutores[i].split("\\|");
                    /* se busca la linea que contenga un dato igual al ID del autor encontrado;
                    de ser asi, se guarda en una variable el dato correspondiente al ID de libro 
                    relacionado.
                     */
                    if (lineaAProcesar[1].equals(IdAutor.toString())) {
                        Comparable variableLibro = lineaAProcesar[0];
                        Nodo<Libro> unLibro = libros.getPrimero();
                        /* se  busca el libro en la lista de libros*/
                        while (unLibro != null) {
                            if (unLibro.getDato().getID().toString().equals(variableLibro)) {
                                /*si lo encuentra imprime la informacion del mismo*/
                                unLibro.getDato().mostrarInfo();
                                encontrado = false;

                            }
                            unLibro = unLibro.getSiguiente();

                        }

                    }

                }
            }
            unAutor = unAutor.getSiguiente();

        }
        if (encontrado == true) {
            System.out.println("No se encuentran libros del autor " + nombreAutor);

        }

    }

    /**
     * Metodo encargado de imprimir en pantalla la informacion de los Objetos
     * Libro contenido en la lista enlazada del Objeto Libreria, cuyo dato ID se
     * encuentre relacionado con el ID del objeto Tag contenido en la lista de
     * tags de la Libreria.
     *
     * @param genero String definido por el usuario
     */
    @Override
    public void mostrarPorGenero(String genero) {

        Comparable IdTag = null;
        Nodo<Tag> unTag = tags.getPrimero();

        boolean encontrado = true;
        /* se busca el genero en la lista de tags*/
        while (unTag != null) {
            if (unTag.getDato().getNombre().equals(genero)) {
                IdTag = unTag.getDato().getID();
                /*si se encuentra el genero se imprime su informacion*/
                unTag.getDato().mostrarInfo();
                String[] listaLibroTags = ManejadorArchivosGenerico.leerArchivo("src/ProyectoIndividual/DataBase/booktags.csv");

                for (int i = 0; i < listaLibroTags.length; i++) {
                    String[] lineaAProcesar = listaLibroTags[i].split("\\|");
                    /* se busca la linea que contenga un dato igual al ID del genero encontrado;
                    de ser asi, se guarda en una variable el dato correspondiente al ID de libro 
                    relacionado.
                     */
                    if (lineaAProcesar[1].equals(IdTag.toString())) {
                        Comparable variableLibro = lineaAProcesar[0];
                        Nodo<Libro> unLibro = libros.getPrimero();
                        /*se busca el libro en la lista de libros*/
                        while (unLibro != null) {
                            if (unLibro.getDato().getID().toString().equals(variableLibro)) {
                                /*si lo encuentra imprime su informacion*/
                                unLibro.getDato().mostrarInfo();
                                encontrado = false;

                            }
                            unLibro = unLibro.getSiguiente();

                        }
                    }

                }

            }
            unTag = unTag.getSiguiente();

        }
        if (encontrado == true) {

            System.out.println("No se encuntran libros del genero " + genero);
        }

    }

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Tag cargados en la lista enlazada tags del objero Libreria.
     */
    @Override
    public void verTags() {
        Nodo<Tag> unTag = tags.getPrimero();
        while (unTag != null) {
            unTag.getDato().mostrarInfo();
            unTag = unTag.getSiguiente();
        }

    }

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Libro cargados en la lista enlazada libros del objero Libreria.
     */

    @Override
    public void verLibros() {
        Nodo<Libro> unLibro = libros.getPrimero();
        while (unLibro != null) {
            unLibro.getDato().mostrarInfo();
            unLibro = unLibro.getSiguiente();
        }
    }

    /**
     * Metodo que imprime por pantalla la informacion Basica de todos los
     * objetos Autor cargados en la lista enlazada autores del objero Libreria.
     */

    @Override
    public void verAutores() {
        Nodo<Autor> unAutor = autores.getPrimero();
        while (unAutor != null) {
            unAutor.getDato().mostrarInfo();
            unAutor = unAutor.getSiguiente();
        }

    }

    /**
     * Metodo encargado de buscar un autor en la lista enlazada de autores de la
     * Libreria e imprimir su informacion basica.
     *
     * @param nombre String definido por el usuario.
     */

    @Override
    public void buscarAutor(String nombre) {

        Nodo<Autor> autor = this.autores.getPrimero();
        boolean encontrado = true;
        while (autor != null && encontrado == true) {

            if (autor.getDato().getNombre().equals(nombre)) {
                autor.getDato().mostrarInfo();
                encontrado = false;
            }
            autor = autor.getSiguiente();

        }
        if (encontrado == true) {
            System.out.println("No se encuentra el autor " + nombre);
        }
    }

    /**
     * Metodo encargado de buscar un libro en la lista enlazada de libros de la
     * Libreria e imprimir su informacion basica.
     *
     * @param nombre String definido por el usuario.
     */
    @Override
    public void buscarLibro(String nombre) {

        Nodo<Libro> libro = this.libros.getPrimero();
        boolean encontrado = true;
        while (libro != null && encontrado == true) {
            if (libro.getDato().getNombre().equals(nombre)) {
                libro.getDato().mostrarInfo();
                encontrado = false;
            }
            libro = libro.getSiguiente();

        }
        if (encontrado == true) {
            System.out.println("No se encuentra el libro " + nombre);
        }

    }

    /**
     * Metodo encargado de buscar un autor en la lista enlazada de autores le la
     * libreria y eliminarlo. Tambien se realiza la busqueda de los libros cuyo
     * numero Id este relacionado con el del Autor eliminado, y se eliminan de
     * la lista enlazada de libros.
     *
     * @param autor String definido por el usuario
     */
    @Override
    public void eliminarLibroAutor(String autor) {

        Comparable IdAutor = null;
        Nodo<Autor> unAutor = autores.getPrimero();

        boolean autorEncontrado = true;

        while (unAutor != null) {
            /*se busca el autor en la lista de autores*/
            if (unAutor.getDato().getNombre().equals(autor)) {
                /*si lo encuentra se elimina de la lista, y se guarda su Id en la variable IdAutor*/
                IdAutor = unAutor.getDato().getID();
                this.autores.eliminar(IdAutor);
                autorEncontrado = false;
                System.out.println(autor + " eliminado");
                String[] listaLibroAutores = ManejadorArchivosGenerico.leerArchivo("src/ProyectoIndividual/DataBase/bookauthors.csv");
                for (int i = 0; i < listaLibroAutores.length; i++) {
                    String[] lineaAProcesar = listaLibroAutores[i].split("\\|");
                    /*se buscan las lineas en las que se encuentre un dato 
                    igual al guardado en la variable IdAutor*/
                    if (lineaAProcesar[1].equals(IdAutor.toString())) {
                        /*si lo encuentro, guardo en una variable (variableLibro) el dato correspondiente
                        a un libro asociado.
                         */
                        Comparable variableLibro = lineaAProcesar[0];
                        Nodo<Libro> unLibro = libros.getPrimero();
                        boolean libroEncontrado = true;
                        /*se busca el libro en la lista de libros*/
                        while (unLibro != null) {
                            if (unLibro.getDato().getID().toString().equals(variableLibro)) {
                                /*si lo encuentra lo elimina de la lista*/
                                this.libros.eliminar(unLibro.getDato().getID());
                                libroEncontrado = false;
                                System.out.println(unLibro.getDato().getNombre() + " eliminado");

                            }
                            unLibro = unLibro.getSiguiente();

                        }
                        if (libroEncontrado == true) {
                            System.out.println("No se encunetran libros del autor");
                        }

                    }

                }
            }
            unAutor = unAutor.getSiguiente();

        }
        if (autorEncontrado == true) {
            System.out.println("No se encuentra el autor");
        }

    }

    /**
     * Metodo que imprime la informacion detallada de un libro cuyo nombre
     * coincide con el recibido por parametro e imprime la informacion de todos
     * los autores que seencuentren relacionados mediante su ID con el
     * mencionado libro
     *
     * @param nombre String correspondiente al nombre de un libro, definido por
     * el usuario.
     */
    public void mostrarAutoresDeLibro(String nombre) {

        Comparable IdLibro = null;
        Nodo<Libro> unLibro = libros.getPrimero();
        /*se busca el lubro en la lista de libros*/
        while (unLibro != null) {
            if (unLibro.getDato().getNombre().equals(nombre)) {
                /*si lo encunetra imprime su infomacion basica y se guarda su ID en una variable (IdLibro)*/
                IdLibro = unLibro.getDato().getID();
                System.out.println("-------INFORMACION DETALLADA-------");
                unLibro.getDato().mostrarInfo();
                String[] listaLibroAutores = ManejadorArchivosGenerico.leerArchivo("src/ProyectoIndividual/DataBase/bookauthors.csv");
                for (int i = 0; i < listaLibroAutores.length; i++) {
                    /*se buscan los autores cuyo Id se encuentren relacionados con el IdLibro**/
                    String[] lineaAProcesar = listaLibroAutores[i].split("\\|");
                    if (lineaAProcesar[0].equals(IdLibro.toString())) {
                        Comparable variableAutor = lineaAProcesar[1];
                        Nodo<Autor> unAutor = autores.getPrimero();
                        boolean autorEncontrado = true;
                        /*si encuentra un dato asociado lo guarda en la variable variableAutor
                        se busca el Autor en la lista de autores.
                         */
                        while (unAutor != null) {
                            if (unAutor.getDato().getID().toString().equals(variableAutor)) {
                                /*si encuentra el autor se imprime su informacion detallada*/
                                unAutor.getDato().mostrarInfo();
                                autorEncontrado = false;
                            }
                            unAutor = unAutor.getSiguiente();
                        }
                        if (autorEncontrado == true) {
                            //System.out.println("No se encunetran autores asociados para el libro " + nombre);
                        }

                    }
                }
            }
            unLibro = unLibro.getSiguiente();
        }
    }

    /**
     * Metodo que imprime la informacion de todos los generos que seencuentren
     * relacionados mediante su ID con el Id del libro cuyo nombre coincide con
     * el recibido por parametro.
     *
     * @param nombre String correspondiente al nombre de un libro, definido por
     * el usuario.
     */
    public void mostrarGenerosDeLibro(String nombre) {

        Comparable IdLibro = null;
        Nodo<Libro> unLibro = libros.getPrimero();
        /*se busca el lubro en la lista de libros*/
        boolean libroEncontrado = true;
        while (unLibro != null) {
            if (unLibro.getDato().getNombre().equals(nombre)) {
                /*si lo encunetra imprime su infomacion basica y se guarda su ID en una variable (IdLibro)*/
                IdLibro = unLibro.getDato().getID();
                libroEncontrado = false;
                String[] listaLibroTags = ManejadorArchivosGenerico.leerArchivo("src/ProyectoIndividual/DataBase/booktags.csv");
                for (int i = 0; i < listaLibroTags.length; i++) {
                    /*se buscan los generos cuyo Id se encuentren relacionados con el IdLibro**/
                    String[] lineaAProcesar = listaLibroTags[i].split("\\|");
                    if (lineaAProcesar[0].equals(IdLibro.toString())) {
                        Comparable variableTag = lineaAProcesar[1];
                        Nodo<Tag> unTag = tags.getPrimero();
                        /*si encuentra un dato asociado lo guarda en la variable variableTag
                        se busca el genero en la lista de tags.
                         */
                        boolean tagEncontrado = true;
                        while (unTag != null) {

                            if (unTag.getDato().getID().toString().equals(variableTag)) {
                                /*si encuentra el genero imprime su informacion*/
                                unTag.getDato().mostrarInfo();
                                tagEncontrado = false;
                            }
                            unTag = unTag.getSiguiente();
                        }
                        if (tagEncontrado == true) {
                            //System.out.println("No se encunetran autores asociados para el libro " + nombre);
                        }

                    }
                }
            }
            unLibro = unLibro.getSiguiente();
        }
        if (libroEncontrado == true) {
            System.out.println("No se encuentra el libro en la base de datos");
        }
    }
}
