/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ernesto
 */
public class CalculadorMatricesOptimoTest {

    TArbolBB<Integer> elArbol;
    CalculadorMatricesOptimo abo;
    int cantElementos;
    String[] claves;
    String nodosInOrden = "";
    int[] frecExito;
    int[] frecNoExito;

    public CalculadorMatricesOptimoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        elArbol = new TArbolBB();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras2.txt");
        cantElementos = lineas.length;

        abo = new CalculadorMatricesOptimo(cantElementos);
        claves = new String[cantElementos + 1];
        frecExito = new int[cantElementos + 1];
        frecNoExito = new int[cantElementos + 1];

        for (int i = 0; i < cantElementos; i++) {
            String[] datos = lineas[i].split(" ");
            claves[i + 1] = datos[0].trim();
            frecExito[i + 1] = Integer.parseInt(datos[1]);
        }
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras2.txt");
        for (int i = 0; i <= cantElementos; i++) {
            frecNoExito[i] = Integer.parseInt(lineas2[i]);
        }

        abo.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        abo.armarArbolBinario(0, cantElementos, claves, elArbol);

        nodosInOrden = "";
        Lista arbolinorden = elArbol.inOrden();
        INodo aux = arbolinorden.getPrimero();
        while (aux != null) {
            nodosInOrden = nodosInOrden + (String) aux.getDato();
            aux = aux.getSiguiente();
            if (aux != null) {
                nodosInOrden = nodosInOrden + " - ";
            }
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEncontrarOptimo() {
        System.out.println("*** Encontrar Óptimo ***");
        System.out.println("Costo óptimo del árbol: " + abo.P[0][cantElementos]);
        assertEquals(abo.P[0][cantElementos], 76);

    }

    @Test
    public void testArmarArbolBinario() {
        System.out.println("*** Armar Árbol Binario ***");
        System.out.println(nodosInOrden);
        assertEquals(nodosInOrden, "gato - perro - raton - zorro");

    }

}
