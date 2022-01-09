package ProyectoInidvidualSarasola.codigo;

/**
 * Define las operaciones de las Clases que implementan ILista
 * @author Profesor Ocampo
 * @author DANIEL
 * @param <E> Tipo genérico.
 */
public interface ILista<E> {

    /**
     * Método encargado de agregar un nodo al final de la lista.
     * @param nodo - Nodo a agregar
     */
    public void insertar(INodo<E> nodo);

    /**
     * Método encargado de buscar un nodo cuya clave es la indicada.
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo buscar(Comparable clave);

    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Método encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     * @return 
     */
    public String imprimir();

    /**
     * Método que retorna un String con las claves separadas por el separador 
     * pasado por parámetro.
     * @param separador Separa las claves
     * @return
     */
    public String imprimir(String separador);

    /**
     * Método que retorna la cantidad de elementos de la lista. En caso de que 
     * la lista este vacía, retorna 0.
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Método que indica si la lista contiene o no elementos.
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Método que retorna el primer nodo de la lista.
     * @return Primer nodo de la lista.
     */
    public INodo<E> getPrimero();
    
    /**
     * Método que inserta un Nodo de ordenado de forma ascendente.
     * @param unNodo Nodo a insertar.
     * @return boolean Si se ha insertado o no el Nodo.
     */
    public boolean insertarOrdenado(INodo<E> unNodo);
    
    /**
     * Método que inserta un Nodo ordenado de forma descendente.
     * @param unNodo Nodo a insertar.
     * @return boolean Si se ha insertado o no el Nodo.
     */
    public boolean insertarOrdenadoInverso(INodo<E> unNodo);
    
    /**
     * Método que ordena una lista de forma ascendente.
     */
    public void ordenar();
    
    /**
     * Método que ordena una lista de forma descendente.
     */
    public void ordenarInverso();
    
    /**
     * Método que elimina el primer Nodo de una lista.
     * @return
     */
    public INodo<E> quitarPrimero();
    
    
}
