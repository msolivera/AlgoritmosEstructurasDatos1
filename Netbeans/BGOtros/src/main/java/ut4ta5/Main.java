/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta5;

/**
 *
 * @author Marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] lineas1, lineas2;
        /*
        if (false) {
            lineas1 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA5/UT5_TA2-Claves-y-FE.txt");
            lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA5/UT5_TA2-FNE.txt");
        } else {
            lineas1 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA5/palabras.txt");
            lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA5/nopalabras.txt");
        }*/
        
        lineas1 = new String[]{"Cartel 8", "Telefono 5 ", "Unicornio 1"};
        lineas2 = new String[]{"3", "1", "4", "1"};
        
        int cantElem = lineas1.length;
        String[] claves = new String[cantElem + 1];
        int[] fe = new int[cantElem + 1];
        int[] fne = new int[cantElem + 1];

        for (int i = 1; i <= cantElem; i++) {
            String[] datos = lineas1[i - 1].split(" ");
            claves[i] = datos[0];
            fe[i] = Integer.valueOf(datos[1]);
        }

        for (int i = 0; i <= cantElem; i++) {
            fne[i] = Integer.valueOf(lineas2[i]);
        }
        
       
        //Claves: clave
        //Frecuencias exito (a): fe
        //Frecuencias sin exito (b): fne
        //Test imprimir matrices
        
        TArbolBinarioOptimo abo = new TArbolBinarioOptimo(cantElem);
        TArbolBB arbolBB = new TArbolBB();
        abo.encontrarOptimo(cantElem, fe, fne);
        abo.armarArbolBinario(0, cantElem, claves, arbolBB);
        
        System.out.println("Costo Arbol optimo: "+ arbolBB.calcularCosto(fe, fne));

        
        System.out.println(arbolBB.inOrden());
        System.out.println("Raiz arbol: " + arbolBB.getRaiz().getDatos());
        
        
        System.out.println("Matriz W");
        Util.imprimirMatriz(abo.W);
        System.out.println("");
        System.out.println("Matriz P");
        Util.imprimirMatriz(abo.P);
        System.out.println("");
        System.out.println("Matriz R");
        Util.imprimirMatriz(abo.R);
        
    }
    
}
