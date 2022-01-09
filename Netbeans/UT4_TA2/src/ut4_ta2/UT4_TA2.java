/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4_ta2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class UT4_TA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TArbolBB miArbol = new TArbolBB();

        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File("src\\ut4_ta2\\clavesPrueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            int contador =0;
            while ((lineas = br.readLine()) != null) {

                Comparable id = Integer.valueOf(lineas);

                TElementoAB<Integer> elemento = new TElementoAB(id, lineas);

                contador += miArbol.insertarContador(elemento);
                //System.out.println(contador);
                //System.out.println(miArbol.insertarContador(elemento));

            }

            br.close();
            System.out.println("Archivo cargado con exito");
            fr.close();
            
             System.out.println(contador);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }
        System.out.println("Recorrido en preOrden");
        System.out.println(miArbol.preOrden());
        
       
    }
   
    
    
}
