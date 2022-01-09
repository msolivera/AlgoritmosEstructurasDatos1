/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4PD3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class UT4PD3main {
    
    public static void main(String[] args) {
      
      TArbolBB miArbol = new TArbolBB();
    
     File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File("src\\UT4PD3\\clavesPrueba.txt");
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
        
        System.out.println(miArbol.getCantidadHojas());
        System.out.println(miArbol.getCantidadPorNivel(0));
        System.out.println(miArbol.sumarEtiquetas());
        
    }

}
