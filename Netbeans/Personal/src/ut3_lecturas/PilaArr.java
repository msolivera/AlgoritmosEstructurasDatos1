/*
    PILA CON ARREGLO
    Estructura LIFO (last in, first out)
    Push al final y pop del final (según índice)
*/
package ut3_lecturas;

/**
 *
 * @author Meki
 */
public class PilaArr {
    Object[] arreglo;
    int indice;
    public PilaArr () {
        this.arreglo = new Object[128];
        this.indice = 0;
    }
    public boolean isEmpty () {
        return indice == 0;
    }
    public Object pop () {
        indice--;
        return arreglo[indice];
    }
    public void push (Object item) {
        if (lleno ()) redimensionar ();
        // en este punto podemos probar
        // que indice < arreglo.length
        arreglo[indice] = item;
        indice++;
    }
    private boolean lleno () {
        return indice == arreglo.length;
    }
    private void redimensionar () {
        Object[] nuevoArreglo = new Object[arreglo.length * 2];
        // asumimos que el arreglo anterior estaba lleno
        for (int i=0; i<arreglo.length; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }
    
}
