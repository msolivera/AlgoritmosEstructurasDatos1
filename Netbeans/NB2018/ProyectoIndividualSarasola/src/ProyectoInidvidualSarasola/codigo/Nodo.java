package ProyectoInidvidualSarasola.codigo;

/**
 * Clase que implementa la Interface INodo.
 * @author Profesor Ocampo
 * @param <T> Tipo genérico.
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /**
     * Constructor de la clase Nodo.
     * @param dato Carga del nodo de un Tipo Genérico.
     * @param etiqueta Comparable con el valor que se le asignará al atributo
     *                 etiqueta.
     */
    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    /**
     * Clona el Nodo actual.
     * @return
     */
    public INodo<T> clonar() {
        return new Nodo<T>(this.dato, this.etiqueta);
    }

    @Override
    public boolean equals(INodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
