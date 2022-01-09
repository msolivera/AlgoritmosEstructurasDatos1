/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;

import javax.swing.ImageIcon;

/**
 * Define las operaciones de las Clases que implementan ICestorDeContenidos.
 * @author DANIEL
 */
public interface IGestorDeContenidos {

    /**
     * Operación que definirá como cargar datos desde una base de datos.
     */
    public void cargarDatos(String archivoPeliculas,String archivoActores, 
            String archivoDirectores,String archivoProductores, 
            String archivoPeliculasActores, String PeliculasDirectores, 
            String PeliculasProductores, String Imagenes);

    /**
     * Método que retorna una Lista enlazada de objetos Pelicula, contenida en 
     * los objetos que implementen la Interface IGestorDeContenidos.
     * @return Lista de objetos Pelicula
     */
    public ILista<Pelicula> obtenerPeliculas();

    /**
     * Método que retorna una Lista enlazada de objetos Actor, contenida en los 
     * objetos que implementen la Interface IGestorDeContenidos.
     * @return Lista de objetos Actor.
     */
    public ILista<Actor> obtenerActores();

    /**
     * Método que retorna una Lista enlazada de objetos Director, contenida en 
     * los objetos que implementen la Interface IGestorDeContenidos.
     * @return Lista de objetos Director.
     */
    public ILista<Director> obtenerDirectores();

    /**
     * Método que retorna una Lista enlazada de objetos Productor, contenida en 
     * los objetos que implementen la Interface IGestorDeContenidos.
     * @return Lista de objetos Productor.
     */
    public ILista<Productor> obtenerProductores();

    /**
     * Método que retorna una Lista enlazada de objetos PeliculasActores, 
     * contenida en los objetos que implementen la Interface 
     * IGestorDeContenidos.
     * @return Lista de objetos PeliculasActores.
     */
    public ILista<AsociadorIDPeliculaIDActor> obtenerPeliculasActores();

    /**
     * Método que retorna una Lista enlazada de objetos PeliculasDirectores, 
     * contenida en los objetos que implementen la Interface 
     * IGestorDeContenidos.
     * @return Lista de objetos PeliculasDirectores.
     */
    public ILista<AsociadorIDPeliculaIDDirector> obtenerPeliculasDirectores();

    /**
     * Método que retorna una Lista enlazada de objetos PeliculasProductores, 
     * contenida en los objetos que implementen la Interface 
     * IGestorDeContenidos.
     * @return Lista de objetos PeliculasProductores.
     */
    public ILista<AsociadorIDPeliculaIDProductor> obtenerPeliculasProductores();

    /**
     * Método que retorna una Lista enlazada de objetos Imagen, contenida en los
     * objetos que implementen la Interface IGestorDeContenidos.
     * @return Lista de objetos Imagen.
     */
    public ILista<Imagen> obtenerImagenes();
    
    
    /**
     * Método que retorna un String que contiene información de un objeto 
     * Película, contenido en una lista de objetos Pelicula, de los objetos que 
     * implementen la Interface IGestorDeContenidos.
     * @param nombrePelicula String que contiene la variable nombre de un objeto 
     *                       Pelicula.
     * @return String que contiene información de un objeto Pelicula.
     */
    public String infoPelicula(String nombrePelicula);
    
    /**
     * Método que retorna un String que contiene la ruta de un archivo de 
     * imagen, contenido en una lista que relaciona ID de objetos Pelicula con 
     * ID de objetos Imagen, de los objetos que implementen la Interface 
     * IGestorDeContenidos.
     * @param nombrePelicula String que contiene la variable nombre de un objeto 
     *                       Pelicula.
     * @return String que contiene la ruta de un archivo de imagen.
     */
    public String imagenPelicula(String nombrePelicula);

    /**
     * Método que crea un archivo con un objeto Imagen y retorna un String 
     * conteniendo el valor de la variable nombre de un objeto Actor, contenido
     * en una lista de objetos Actor, de los objetos que implementan la 
     * Interface IGestorDeContenidos.
     * @param idActor String que contiene el valor de la variable ID de un 
     *                objeto Actor.
     * @return  String conteniendo el valor de la variable nombre de un objeto
     *          Actor.
     */
    public String nombreActor (String idActor);

    /**
     * Método que retorna un String conteniendo el valor de la variable nombre 
     * de un objeto Director, contenido en una lista de objetos Director, de los
     * objetos que implementan la Interface IGestorDeContenidos.
     * @param idDirector String que contiene el valor de la variable ID de un 
     *                  objeto Director.
     * @return  String conteniendo el valor de la variable nombre de un objeto
     *          Director.
     */
    public String nombreDirector (String idDirector);

   /**
     * Método que retorna un String conteniendo el valor de la variable nombre 
     * de un objeto Productor, contenido en una lista de objetos Productor, de 
     * los objetos que implementan la Interface IGestorDeContenidos.
     * @param idProductor String que contiene el valor de la variable ID de un 
     *                    objeto Productor.
     * @return  String conteniendo el valor de la variable nombre de un objeto
     *          Productor.
     */
    public String nombreProductor (String idProductor);
    
    /**
     * Método que retorna un int, correspondiente al valor más bajo de las 
     * variables anio de los objetos Pelicula ingresados en la lista de objetos 
     * Pelicula, de los objetos que implementan la Interface 
     * IGestorDeContenidos.
     * @return int con el valor más bajo de las variables anio de los objetos
     *          Pelicula ingresados.
     */
    public int obtenerAnioPeliculaMasAntigua();
    
    /**
     * Método que retorna una lista enlazada de objetos String, donde la carga 
     * de cada nodo es una cadena de caracteres con los diferentes géneros de 
     * los objetos. 
     * Película ingresados en la lista de objetos Pelicula, de los objetos que
     * implementan la Interface IGestorDeContenidos.
     * @return Lista enlazada de objetos String.
     */
    public Lista<String> generosEnListaPeliculas();
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula relacionada con la variable nombre de un 
     * objeto Director.
     * Ambos objetos, así como el objeto que los relaciona, se encuentran
     * cargados en listas enlazadas de los objetos que implementan la Interface 
     * IGestorDeContenidos.
     * @param nombreDirector String conteniendo el valor de la variable nombre 
     *                       de un objeto Director.
     *          
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasDeDirector(String nombreDirector);
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula relacionada con la variable nombre de un 
     * objeto Actor.
     * Ambos objetos, así como el objeto que los relaciona, se encuentran
     * cargados en listas enlazadas de los objetos que implementan la Interface 
     * IGestorDeContenidos.
     * @param nombreActor String conteniendo el valor de la variable nombre 
     *                    de un objeto Actor.
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasDeActor(String nombreActor);
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula, cuya variable anio es mayor o igual a un int
     * anioInferior, y menor o igual a un int anioSuperior.
     * El objeto Pelicula se encuentra cargado en una lista enlazada de los 
     * objetos que implementan la Interface IGestorDeContenidos.
     * @param anioInferior int con un valor determinado por el usuario.
     * @param anioSuperior int con un valor determinado por el ususario, mayor o 
     *                     igual que el int anioInferior.
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasPorAnio (int anioInferior, 
                                                int anioSuperior);
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula, cuya variable puntaje es mayor o igual a un 
     * double puntajeInferior y menor o igual a un double puntajeSuperior.
     * El objeto Pelicula se encuentra cargado en una lista enlazada de los 
     * objetos que implementan la Interface IGestorDeContenidos.
     * @param puntajeInferior double con un valor determinado por el usuario.
     * @param puntajeSuperior double con un valor determinado por el ususario, 
     *                        mayor o igual que el double puntajeInferior.
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasPorPuntaje (double puntajeInferior, 
                                                    double puntajeSuperior);    
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula relacionada cuya variable genero contiene a
     * la cadena de caracteres recibida por parámetro.
     * El objeto Pelicula se encuentra cargado en una lista enlazada de los 
     * objetos que implementan la Interface IGestorDeContenidos.
     * @param genero String conteniendo una cadena de caracteres que puede estar 
     *               incluida dentro de la variable genero de un objeto 
     *               Pelicula.
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasPorGenero (String genero);
    
    /**
     * Método que retorna una lista enlazada, donde la carga de cada nodo 
     * contiene un objeto Pelicula relacionada con las variables: nombre de un 
     * objeto Actor, nombre de un objeto Director y cuya variable anio es mayor
     * o igual a un int anioInferior y menor o igual a un int anioSuperior, cuya
     * variable puntaje es mayor o igual a un double puntajeInferior y menor o
     * igual a un double puntajeSuperior y cuya variable genero contiene a la
     * cadena de caracteres genero recibida por parámetro.
     * Todos los objetos, así como el objetos que los relacionan, se encuentran
     * cargados en listas enlazadas de los objetos que implementan la Interface
     * IGestorDeContenidos.
     * @param nombreDirector String conteniendo el valor de la variable nombre 
     *                       de un objeto Director.
     * @param nombreActor String que contiene el valor de la variable ID de un 
     *                    objeto Actor.
     * @param anioInferior int con un valor determinado por el usuario.
     * @param anioSuperior int con un valor determinado por el ususario, mayor o 
     *                     igual que el int anioInferior.
     * @param puntajeInferior double con un valor determinado por el usuario.
     * @param puntajeSuperior double con un valor determinado por el ususario, 
     *                        mayor o igual que el double puntajeInferior.
     * @param genero String conteniendo una cadena de caracteres que puede estar 
     *               incluida dentro de la variable genero de un objeto 
     *               Pelicula.
     * @return Lista enlazada de objetos Pelicula.
     */
    public Lista<Pelicula> peliculasPorTodosLosFiltros (String nombreDirector, 
            String nombreActor,int anioInferior, int anioSuperior, 
                double puntajeInferior, double puntajeSuperior, String genero);
    
    
}
