/*
    COLA ENCADENADA (NO EFICIENTE)
    
    Estructura FIFO (first in, first out)
    
    Usa lista encadenada.
    Push al final, y pop del principio,
    pero no es tan eficiente como
    la circular.
*/
package ut3_lecturas;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class Cola {
    
    private LinkedList lista;
    public Cola() {
        lista = new LinkedList ();
    }
    public boolean estaVacia() {
        return lista.isEmpty();
    }
    public void agregar(Object obj) {
        lista.addLast (obj);
    }
    public Object quitar() {
        return lista.removeFirst ();
    }
    
}
