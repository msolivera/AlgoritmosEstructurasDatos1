/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4PD5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class UT4PD5 {
    public static void main(String[] args) {

        TArbolBB miArbol = new TArbolBB();

        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
          archivo = new File("src\\UT4PD5\\clavesPrueba.txt");
           //archivo = new File("src\\UT4PD5\\test.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                Comparable id = Integer.valueOf(lineas);

                TElementoAB<Integer> nodo = new TElementoAB(id, lineas);
                miArbol.insertar(nodo);

            }

            br.close();
            System.out.println("Archivo cargado con exito");
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        
        System.out.println(miArbol.getMayor().toString());
        System.out.println(miArbol.getMenor().toString());
        System.out.println(miArbol.esDeBusqueda());
        System.out.println(miArbol.getCantidadPorNivel(4));
        System.out.println(miArbol.listadoNodos());
        System.out.println(miArbol.listadoHojas());
        System.out.println(miArbol.getCantidadHojas());
        //LinkedList<String> resultados = new LinkedList<>();
        //resultados = miArbol.listadoHojasInor();
        
         //Escritura de  HOJAS CON SUS NIVELES INORDEN
        
        LinkedList<String> resultados = new LinkedList<>();
        resultados = miArbol.listadoNodosInor();
        String[] lineasInorden = new String[resultados.size()];
        for (int i = 0; i < resultados.size(); i++) {
            lineasInorden[i] = resultados.get(i);
        }
        FileWriter fw;
        try {
            fw = new FileWriter("src\\UT4PD5\\listadoHojasNivel.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String linea : lineasInorden) {
                    bw.write(linea);
                    bw.newLine();

                }

            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }
        
             
         }
    
}
/**
 * 3.Obtener la clave inmediata anterior a una clave dada (pasada por parámetro).
 * listar hojas, el actual lista TODO
 */