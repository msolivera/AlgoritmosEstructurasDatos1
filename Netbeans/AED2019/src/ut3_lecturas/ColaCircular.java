/*
    COLA CIRCULAR
    Estructura FIFO (first in, first out)
    
    Requiere:
    - Un arreglo de objetos
    - Referencia DE ÍNDICES al primero y próximo del arreglo
    
    Ej.
    Inicial (LISTA VACÍA ES PRIMERO == PRÓXIMO)
    ------------------------------------
    |           |          |           |
    | prim/prox |          |           |
    |           |          |           |
    -----------------------------------|
    PUSHeo uno, queda en prim, y próximo
    apunta a un espacio VACÍO del array
    ------------------------------------
    |           |          |           |
    | prim      |  prox    |           |
    |           |          |           |
    -----------------------------------|
    PUSHeo otro
    ------------------------------------
    |           |          |           |
    | prim      |          | prox      |
    |           |          |           |
    -----------------------------------|
    POP uno
    ------------------------------------
    |           |          |           |
    |           | prim     | prox      |
    |           |          |           |
    -----------------------------------|
    POP otro (COLA VACÍA, ya que prim == prox)
    ------------------------------------
    |           |          |           |
    |           |          | prim/prox |
    |           |          |           |
    -----------------------------------|
    
    PUSH OTRO
    ------------------------------------
    |           |          |           |
    | prox      |          | prim      |
    |           |          |           |
    -----------------------------------|
    
    OJO: Acá obviamente, si pusheamos otro
    prim se desborda, pero el libro no consideraba
    este caso. Lo que hay que hacer, es además
    de ir corroborando si lista está llena,
    corroborar si prim llegó al borde.
*/
package ut3_lecturas;

/**
 *
 * @author Meki
 */
public class ColaCircular {
    public Object[] arreglo;
    public int primero, prox;
    public ColaCircular () {
        arreglo = new Object[128];
        primero = 0;
        prox = 0;
    }
    public boolean estaVacia () {
        return primero == prox;
    }
    public boolean estaLleno () {
        return ((prox + 1) % arreglo.length == primero);
    }
    public void agregar (Object elemento) {
        if (estaLleno()) return; // TODO: Acá debe redimensionar el array
        arreglo[prox] = elemento;
        prox++;
        // Doy vuelta al array para seguir llenando
        if (prox == arreglo.length) prox = 0;
    }
    public Object quitar () {
        // TODO: Hay un caso borde que no contempla el libro acá
        // si quité muchos elementos y llegué al final del array, primero se desborda también
        // al igual que prox cuando agregamos elementos
        // Acá tendría que verificar esto y dejar primero = 0
        if (estaVacia()) return null;
        Object resultado = arreglo[primero];
        primero++;
        return resultado;
    }
    
}
