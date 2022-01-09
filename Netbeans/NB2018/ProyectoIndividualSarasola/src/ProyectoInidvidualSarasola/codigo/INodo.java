package ProyectoInidvidualSarasola.codigo;

/**
 *
 * @author Profesor Ocampo
 * @param <E> Tipo genérico.
 */
public interface INodo<E> {

    /**
     * Método que retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    public E getDato();

    /**
     * Método que asigna un dato al nodo.
     *
     * @param dato a asignar.
     */
    public void setDato(E dato);

    /**
     * Método que asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setSiguiente(INodo<E> nodo);

    /**
     * Método que retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public INodo<E> getSiguiente();

    /**
     * Método que imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Método que imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     * Método que determina si un Nodo pasado por parámetro es igual al Nodo que 
     * implementa la Interface INodo.
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(INodo<E> unNodo);

    /**
     * Método que retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo<E> unNodo);

    /**
     * Método que compara un objeto Comparable recibido por parámetro con otro 
     * componente del objeto que implementa INodo.
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
