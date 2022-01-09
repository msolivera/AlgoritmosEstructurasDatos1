/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5.TA4;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) 
        {
                String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/UT5/TA4/UT5_TA2-Claves-y-FE.txt");
                //String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/UT5/TA4/palabras.txt");
                int cantidadDeElementos = lineas.length;
                int[] frecExito = new int[cantidadDeElementos + 1];
                int[] frecNoExito = new int[cantidadDeElementos + 1];
                String[] claves = new String[cantidadDeElementos + 1];
                
                for(int i = 1 ; i <= cantidadDeElementos; i++) 
                {
                        
                        String[] datos = lineas[i-1].split(" ");
                        frecExito[i] = Integer.parseInt(datos[1]);                        
                        claves[i] = datos[0];
                }
                
                String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5/TA4/UT5_TA2-FNE.txt");
                //String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5/TA4/nopalabras.txt");
                for (int i = 0 ; i <= cantidadDeElementos; i++) 
                {
                        frecNoExito[i] = Integer.parseInt(lineas2[i]);
                }
                
        
        TABBO arbol = new TABBO(cantidadDeElementos);
        arbol.encontrarOptimo(cantidadDeElementos, frecExito, frecNoExito);
                System.out.println("Iimprimiendo W");
                imprimirMatriz(arbol.w);
                System.out.println("Imprimiendo P");
                imprimirMatriz(arbol.p);
                System.out.println("Imprimiendo R");
                imprimirMatriz(arbol.r);
                
                System.out.println("Armando el árbol...");
                arbol.armarArbol(claves, frecNoExito, 0, cantidadDeElementos);
                System.out.println("IMPRIMIENDO PRE-ORDEN :");
                System.out.println(arbol.preOrden());
        
        }
        
        public static void imprimirMatriz(int[][] matriz) 
        {
                System.out.print("  ");

                for (int i = 0; i < matriz.length; i++) {

                        for (int j = 0; j < matriz.length; j++) {
                                System.out.print(matriz[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
        
}
