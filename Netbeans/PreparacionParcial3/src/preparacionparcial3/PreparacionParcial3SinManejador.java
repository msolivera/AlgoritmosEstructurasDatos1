/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Meki
 */
public class PreparacionParcial3SinManejador {

    /**
     * Separador archivo "palabras"
     */
    public static final String SEPARADOR = " ";

    /**
     * Máximo para los arreglos auxiliares
     */
    public static final int MAX_ARREGLOS = 200;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {//TODO ESTO ES CARGANDO LA INFO SIN EL MANEJADOR

//////////////////////////////SE CARGAN ARBOLES SE CALCULA OPTIMOS Y SE IMPRIMEN//////////////////////////////
//DESCOMENTAR PARA ARCHIVO GRANDEEEE//////////////////////
//        BufferedReader br;
//        String[] etiquetas, campos;
//        int indice, cantElem;
//        int[] freqExito, freqNoExito;
//        
//        // Nuevos arreglos vacíos
//        // TODO: Usar ArrayList y que dinámicamente
//        // genere los arreglos
//        freqExito = new int[MAX_ARREGLOS];
//        freqNoExito = new int[MAX_ARREGLOS];
//        etiquetas = new String[MAX_ARREGLOS];
//        
//        // Leo "palabras" (etiqueta + frecuencias de éxito) y cargo arreglos
//        //br = new BufferedReader(new FileReader("palabrasPrueba.txt"));
//        br = new BufferedReader(new FileReader("src\\palabras.txt"));
//        indice = 0;
//        cantElem = 0; // almacena cantidad elementos
//        freqExito[0] = 0; // cargo primer valor en 0
//        etiquetas[0] = ""; // cargo primer valor vacío
//        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
//            campos = linea.split(SEPARADOR);
//            freqExito[indice + 1] = Integer.parseInt(campos[1]);
//            etiquetas[indice + 1] = campos[0].trim();
//            indice++;
//        }
//        br.close();
//        cantElem = indice; // actualizo cantidad elementos
//        
//        // Leo "nopalabras" (frecuencias de no éxito) y cargo arreglo
//        //br = new BufferedReader(new FileReader("nopalabrasPrueba.txt"));
//        br = new BufferedReader(new FileReader("src\\nopalabras.txt"));
//        indice = 0;
//        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
//            freqNoExito[indice] = Integer.parseInt(linea);
//            indice++;
//        }
//        br.close();
//        
//        // Calculador de N elementos (según cantElem)
//        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(cantElem);
//        
//        calc.encontrarOptimo(cantElem, freqExito, freqNoExito);
//        
//        // Imprimo matrices
//        UtilDele.imprimirMatriz(calc.w);
//        System.out.println("");
//        UtilDele.imprimirMatriz(calc.p);
//        System.out.println("");
//        UtilDele.imprimirMatriz(calc.r);
//        
//        // Genero árbol
//        TArbolBB arbolBB = new TArbolBB();
//        calc.armarArbolBinario(0, cantElem, etiquetas, arbolBB);
//        
//        // Debuguear esta línea para ver árbol
//        System.out.println("----------------------------------------------");


//EJERCICIO DE LA CLASE GATO PERRO COSO COSO////////////////
//
//CalculadorMatricesOptimo calculador = new CalculadorMatricesOptimo(4);
//        int[] freqExito = new int[]{0,5,3,4,2};
//        int[] freqNoExito = new int[]{1,3,1,3,7};
//        int cantElem = 4;
//        calculador.encontrarOptimo(cantElem, freqExito, freqNoExito);
//        
//        // Imprimo matrices
//       UtilDele.imprimirMatriz(calculador.w);
//       System.out.println("");
//       UtilDele.imprimirMatriz(calculador.p);
//       System.out.println("");
//       UtilDele.imprimirMatriz(calculador.r);


//TA7 SORPRESA////////////////
//ACA SE ARMAN LOS ARBOLES SE CALCULAN LAS MATRICES, SE IMPRIMEN Y SE CALCULA EL NIVEL COSTO. ////////////////
//TAMBIEN SE ESCRIBEN LOS RECORRIDOS EN UN ARCHIVO////////////////
        BufferedReader br;
        String[] etiquetas, campos;
        int indice, cantElementos;
        int[] freqExito, freqNoExito;
        freqExito = new int[MAX_ARREGLOS];
        freqNoExito = new int[MAX_ARREGLOS];
        etiquetas = new String[MAX_ARREGLOS];

        // Leo "palabras" (etiqueta + frecuencias de éxito) y cargo arreglos
        br = new BufferedReader(new FileReader("src\\preparacionparcial3\\palabras.txt"));
        indice = 0;
        cantElementos = 0; // almacena cantidad elementos
        freqExito[0] = 0; // cargo primer valor en 0
        etiquetas[0] = ""; // cargo primer valor vacío
        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
            campos = linea.split(SEPARADOR);
            freqExito[indice + 1] = Integer.parseInt(campos[1]);
            etiquetas[indice + 1] = campos[0].trim();
            indice++;
        }
        br.close();
        cantElementos = indice;
        // cargar los vectores de claves, frecuencias con éxito y frecuencias sin éxito
        // archivos "palabras.txt" y "nopalabras.txt"
        // Leo "nopalabras" (frecuencias de no éxito) y cargo arreglo
        br = new BufferedReader(new FileReader("src\\preparacionparcial3\\nopalabras.txt"));
        indice = 0;
        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
            freqNoExito[indice] = Integer.parseInt(linea);
            indice++;
        }
        br.close();

        // Calculador de N elementos (según cantElem)
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(cantElementos);

        calc.encontrarOptimo(cantElementos, freqExito, freqNoExito);

        CalculadorMatricesOptimo abo = new CalculadorMatricesOptimo(cantElementos);

        abo.encontrarOptimo(cantElementos, freqExito, freqNoExito);

        System.out.println("Raiz: " + abo.R[0][cantElementos]);
        System.out.println("Matriz R: ");
        Util.imprimirMatriz(abo.R);
        System.out.println("Matriz P: ");
        Util.imprimirMatriz(abo.P);
        System.out.println("Matriz W: ");
        Util.imprimirMatriz(abo.W);

        System.out.println("costo del arbol optimo : " + abo.P[0][cantElementos]);
        TArbolBB elArbol = new TArbolBB();

        abo.armarArbolBinario(0, cantElementos, etiquetas, elArbol);
        // emitir un archivo "preorden.txt" con el listado de las claves en preorden
        FileWriter fw;
        try {
            fw = new FileWriter("src\\preparacionparcial3\\preorden.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                Lista pre = elArbol.listaPreOrden();
                Nodo aux = pre.getPrimero();
                while (aux != null) {
                    String lineaEscribir = aux.getEtiqueta().toString();
                    bw.write(lineaEscribir);
                    bw.newLine();

                    aux = aux.getSiguiente();
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }
        // emitir un archivo "inorden.txt" con el listado de las claves en inorden

        FileWriter fw2;
        try {
            fw2 = new FileWriter("src\\preparacionparcial3\\inorden.txt", true);
            try (BufferedWriter bw2 = new BufferedWriter(fw2)) {
                Lista in = elArbol.listaInOrden();
                Nodo aux = in.getPrimero();
                while (aux != null) {
                    String lineaEscribir = aux.getEtiqueta().toString();
                    bw2.write(lineaEscribir);
                    bw2.newLine();

                    aux = aux.getSiguiente();
                }
            }
            fw2.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }
        // emitir un archivo "postorden.txt" con el listado de las claves en postorden

        FileWriter fw3;
        try {
            fw3 = new FileWriter("src\\preparacionparcial3\\postorden.txt", true);
            try (BufferedWriter bw3 = new BufferedWriter(fw3)) {
                Lista post = elArbol.listaPostOrden();
                Nodo aux = post.getPrimero();
                while (aux != null) {
                    String lineaEscribir = aux.getEtiqueta().toString();
                    bw3.write(lineaEscribir);
                    bw3.newLine();

                    aux = aux.getSiguiente();
                }
            }
            fw3.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }

        System.out.println("costo del arbol iterando: " + elArbol.calcularCosto(freqExito, freqNoExito));

        // invocar a nivelClave, con el parámetro indicado en el pizarrón         
        String laClave1 = "return";
        String laClave2 = "strict";

        // indicar si la clave está o no en el árbol y cuál sería el nivel correspondiente, 
        // invocando al método alArbol.nivelClave
        System.out.println("return");
        System.out.println(elArbol.nivelClave(laClave1));
        System.out.println("strict");
        System.out.println(elArbol.nivelClave(laClave2));

    }
    
    
}
