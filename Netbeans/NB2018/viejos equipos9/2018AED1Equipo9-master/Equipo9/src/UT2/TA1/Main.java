/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2.TA1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws IOException 
        {
                // TODO code application logic here
                ContadorPalabras cont = new ContadorPalabras();
                //int a = cont.contarPalabras("hola a todos");
                //System.out.println(a);
                //int b = cont.contarPalabras("hola       a       todos");
                //System.out.println(b);
                
                
                String ruta = "src/ut2/TA1/UT2_TA1_ARCHIVO_EJEMPLO.txt";//Ruta del archivo a examinar
                ArrayList<String> lineas = cont.obtenerLineas(ruta); //ArrayList que contiene todas las lineas del archivo
                System.out.println("Cantidad de lineas leidas: " + lineas.size()); // Imprime la cantidad de lineas en el archivo
                
                
                int palabrasTotales = cont.cantPalabras(lineas); // Cantidad de palabras en todo el archivo
                System.out.println("Cantidad de palabras en archivo: " + palabrasTotales);
                
        }
        
}
