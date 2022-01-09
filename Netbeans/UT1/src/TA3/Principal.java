/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meki
 */
public class Principal {

    public static void main(String[] args) {

        try {
            ContadorPalabras contador = new ContadorPalabras();
            int x = 3;
            System.out.println(contador.contarPalabras("22 222h 22 *+ "));
            System.out.println(contador.contarPalabras("22 222 22 3433 "));
            int res[] = contador.contarPalabras(" hola 222h 46565 5656656565656565656565656h 453 d4353 la cosa ", x);
           System.out.println("Cantidad de palabras " + res[0]);
           System.out.println("Cantidad de palabras con largo mayor a " + x + " : " + res[1]);
                   
      
        //int resultado[] = contador.contadorVocCon("holacomoestas");
        System.out.println(contador.contarPalabras("hola 111 estas"));
       // System.out.println(resultado[0]);
        //System.out.println(resultado[1]);
            
            
            File archivo2 = new File ("src/TA3/ejemplo.txt");
            FileReader fr = null;
            fr = new FileReader (archivo2);
            BufferedReader br = new BufferedReader (fr);
            int contarLinea = 0;
            
            int cosa = fr.read();
            System.out.println(cosa);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

          

    }

}