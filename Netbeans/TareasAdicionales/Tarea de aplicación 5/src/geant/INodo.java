package geant;

public interface INodo {

    public Object getDato();

    public void setDato(Object dato);

    public void setSiguiente(INodo nodo);

    public INodo getSiguiente();

    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     *
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(INodo unNodo);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
