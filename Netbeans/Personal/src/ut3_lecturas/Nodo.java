/*
    LISTA ENCADENADA
    Sólo necesito una referencia al nodo inicial
    INSERTAR:
    Debo conocer un anterior simplemente
    ELIMINAR:
    Debo conocer un anterior simplemente
*/
package ut3_lecturas;

/**
 *
 * @author Meki
 */
public class Nodo {

    Object carga;
    Nodo prox;

    public Nodo() {
        carga = 0;
        prox = null;
    }

    public Nodo(Object carga, Nodo prox) {
        this.carga = carga;
        this.prox = prox;
    }

    @Override
    public String toString() {
        return carga + "";
    }

}
