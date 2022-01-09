/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial3;

import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class Parcial3AnioPasadoBruno {
     public static void main(String[] args) {
        
        //1.	cargar los vectores de claves con  frecuencias de búsquedas exitosas y frecuencias de búsquedas no exitosas, desde los archivos provistos (“datos.zip” en webasignatura):	
        System.out.println("PARTE 1 INICIO\n");
        
        String[] lineas1 = ManejadorArchivosGenerico.leerArchivo("src\\preparacionparcial3\\consultasEspecialidades.txt");
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src\\preparacionparcial3\\ConsultasOtrasEspecialidades.txt");
        
        int cantElementos = lineas1.length;
        String[] claves = new String[cantElementos + 1];
        int[] fe  = new int[cantElementos + 1];
        int[] fne = new int[cantElementos + 1];
        
        for(int i = 1; i <= cantElementos; i++){
            String[] datos = lineas1[i-1].split(",");
            claves[i] = datos[0];
            fe[i] = Integer.valueOf(datos[1]);
        }
        
        for(int i = 0; i <= cantElementos; i++){
            fne[i] = Integer.valueOf(lineas2[i]);
        }
        
        System.out.println("PARTE 1 FIN\n");
        
        //2.	crear una instancia de la clase calculadorMatricesOptimo, ejecutar el método “encontrarOptimo “ 
        System.out.println("PARTE 2 INICIO\n");
        
        CalculadorMatricesOptimo calculador = new CalculadorMatricesOptimo(cantElementos);
        calculador.encontrarOptimo(cantElementos, fe, fne);
        
        System.out.println("PARTE 2 FIN\n");
        
        //3.	imprimir por consola las matrices P, W, y R resultantes
        System.out.println("PARTE 3 INICIO\n");
        
        System.out.println("Matriz W:");
        Util.imprimirMatriz(calculador.W);
        System.out.println("");
        System.out.println("Matriz P:");
        Util.imprimirMatriz(calculador.P);
        System.out.println("");
        System.out.println("Matriz R:");
        Util.imprimirMatriz(calculador.R);
        
        System.out.println("PARTE 3 FIN\n");
        
        //4.	generar una instancia de la clase TArbolBB
        System.out.println("PARTE 4 INICIO\n");
        
        TArbolBB arbolBB = new TArbolBB();
        
        System.out.println("PARTE 4 FIN\n");
        
        //5.	ejecutar el método armarArbolBinario, que inserte las claves en el árbol binario de búsqueda 
        System.out.println("PARTE 5 INICIO\n");
        
        calculador.armarArbolBinario(0, cantElementos, claves, arbolBB);
        
        System.out.println("PARTE 5 FIN\n");
        
        //6.	En el archivo “salidaArbolEspecialidades.txt” escribir el recorrido en  postorden del árbol resultante 
        System.out.println("PARTE 6 INICIO\n");
        
        LinkedList listaPostOrden = arbolBB.postorden();
        String[] postOrden = new String[listaPostOrden.size()];
        for(int i = 0; i < listaPostOrden.size(); i++){
            postOrden[i] = listaPostOrden.get(i).toString();
        }
        ManejadorArchivosGenerico.escribirArchivo("src\\preparacionparcial3\\salidaArbolEspecialidades.txt", postOrden);
       
        System.out.println("PARTE 6 FIN\n");
        
        //7.	Para ese árbol, ejecutar el método calcularCosto –  imprimir por consola el resultado y comparar con el valor de costo del árbol óptimo 
        System.out.println("PARTE 7 INICIO\n");
        
        long costoArbol = arbolBB.calcularCosto(fe, fne);
        long costoMatriz = calculador.P[0][cantElementos];
        
        System.out.println("Costo del arbol: " + costoArbol + ", costo del paso 2: " + costoMatriz);
        
        System.out.println("PARTE 7 FIN\n");
        
        //8.	Para el mismo árbol, ejecutar el método longTrayIntMedia e imprimir por consola el valor (en coma flotante) resultante correspondiente. 
        System.out.println("PARTE 8 INICIO\n");
        
        float ltim = arbolBB.longTrayIntMedia();
        System.out.println("LTIM: " + ltim);
        
        System.out.println("PARTE 8 FIN\n");
        


    }
}
