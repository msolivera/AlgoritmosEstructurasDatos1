/*
    COLA ENCADENADA (EFICIENTE)
    
    Estructura FIFO (first in, first out)
    
    Requiere:
    - Usa lista encadenada.
    - Referencia al primero y último
    
    Cómo funciona:
    Push al final, y pop del principio
    siempre retornando el primer elemento que
    agregaste
*/
package ut3_lecturas;

/**
 *
 * @author Meki
 */
public class ColaEnlazada {
    
    public Nodo primero, ultimo;
    public ColaEnlazada () {
        primero = null;
        ultimo = null;
    }
    public boolean estaVacia() {
        return primero == null;
    }
    public void agregar(Object obj) {
        Nodo nodo = new Nodo(obj, null);
        if (ultimo != null) {
            ultimo.prox = nodo; 
        }
        ultimo = nodo;
        if (primero == null) {
            primero = ultimo;
        }
    }
    public Object quitar() {
        Nodo resultado = primero;
        if (primero != null) {
            primero = primero.prox;
        }
        if (primero == null) {
            ultimo = null;
        }
        return resultado;
    }
    
}
