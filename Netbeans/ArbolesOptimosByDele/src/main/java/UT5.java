
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meki
 */
public class UT5 {
    
     /** Separador archivo "palabras" */
    public static final String SEPARADOR = " ";
    
    /** Máximo para los arreglos auxiliares */
    public static final int MAX_ARREGLOS = 200;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //DESCOMENTAR PARA ARCHIVO GRANDEEEE///////////////////////////////////////////////////////////////
        
        BufferedReader br;
        String[] etiquetas, campos;
        int indice, cantElem;
        int[] freqExito, freqNoExito;
        
        // Nuevos arreglos vacíos
        // TODO: Usar ArrayList y que dinámicamente
        // genere los arreglos
        freqExito = new int[MAX_ARREGLOS];
        freqNoExito = new int[MAX_ARREGLOS];
        etiquetas = new String[MAX_ARREGLOS];
        
        // Leo "palabras" (etiqueta + frecuencias de éxito) y cargo arreglos
        //br = new BufferedReader(new FileReader("palabrasPrueba.txt"));
        br = new BufferedReader(new FileReader("src\\palabras.txt"));
        indice = 0;
        cantElem = 0; // almacena cantidad elementos
        freqExito[0] = 0; // cargo primer valor en 0
        etiquetas[0] = ""; // cargo primer valor vacío
        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
            campos = linea.split(SEPARADOR);
            freqExito[indice + 1] = Integer.parseInt(campos[1]);
            etiquetas[indice + 1] = campos[0].trim();
            indice++;
        }
        br.close();
        cantElem = indice; // actualizo cantidad elementos
        
        // Leo "nopalabras" (frecuencias de no éxito) y cargo arreglo
        //br = new BufferedReader(new FileReader("nopalabrasPrueba.txt"));
        br = new BufferedReader(new FileReader("src\\nopalabras.txt"));
        indice = 0;
        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
            freqNoExito[indice] = Integer.parseInt(linea);
            indice++;
        }
        br.close();
        
        // Calculador de N elementos (según cantElem)
        CalculadorMatricesOptimo calc = new CalculadorMatricesOptimo(cantElem);
        
        calc.encontrarOptimo(cantElem, freqExito, freqNoExito);
        
        // Imprimo matrices
        UtilDele.imprimirMatriz(calc.w);
        System.out.println("");
        UtilDele.imprimirMatriz(calc.p);
        System.out.println("");
        UtilDele.imprimirMatriz(calc.r);
        
        // Genero árbol
        TArbolBB arbolBB = new TArbolBB();
        calc.armarArbolBinario(0, cantElem, etiquetas, arbolBB);
        
        // Debuguear esta línea para ver árbol
        System.out.println("----------------------------------------------");
        


//////////////////EJERCICIO DE LA CLASE GATO PERRO COSO COSO
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
    }
    
}
