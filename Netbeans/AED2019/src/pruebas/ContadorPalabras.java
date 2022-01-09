/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meki
 */
public class ContadorPalabras {

    /**
     *
     * @param frase = cadena de caracteres
     * @param x = largo de las palabras a contrar
     * @return = array con la cantidad de palabras en total, y las palabras con
     * un largo mayor a x
     */
    public int[] contarPalabras(String frase, int x) {

        int[] contador = new int[2];
        boolean estado = false;
        int contarLargo = 0;
        int encuentraLetra = 0;
        int contadorPalabras = 0;

        for (int i = 0; i < frase.length(); i++) {

            if ((Character.isLetter(frase.charAt(i)))) { //se verifica que el caracter sea una letra

                estado = true;
                encuentraLetra++;

            } else if ((frase.charAt(i) == ' ') && (estado == true)) { //se identifica una palabra

                if (encuentraLetra > x) { //verifica si se encuentra una palabra con mayor al largo obtenido por parametro

                    contarLargo++;

                }
                encuentraLetra = 0; //reinicia contador

                contadorPalabras++;
                estado = false;
                contador[0] = contadorPalabras; //se carga array de resultado
                contador[1] = contarLargo;

            } else if ((Character.isDigit(frase.charAt(i))) || estado == true) {

                encuentraLetra++;

            }

        }

        return contador;

    }
    
    public String [] obtenerLineas (String archivo){
        FileReader fr = null;
        String [] resultado = new String[0];
        try {
            
            File archivo2 = new File (archivo);
            fr = new FileReader (archivo2);
            BufferedReader br = new BufferedReader (fr);
            int contarLinea = 0;
            
            try {
                fr.read();
            } catch (IOException ex) {
                Logger.getLogger(ContadorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String linea = null;
            try {
                linea = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ContadorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (linea != null)
            {
                System.out.println(linea);
                try {
                    linea = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(ContadorPalabras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorPalabras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ContadorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return resultado;
    }
    
    public int contarPalabras (String frase){
            int contador = 1;
            String variable = "";
            
            for(int i=0; i<frase.length();i++)
            {
                variable += frase.charAt(i);    
                if(frase.charAt(i) == ' '){
                    for(int a=0; a<variable.length();a++){
                        if(Character.isLetter(variable.charAt(a))){
                            variable = "";
                            contador += 1;
                        }        
                    }
                }
            }
        return contador;
    }
    
    //    public int[] contadorVocCon(String frase){
//        int[] contador=  new int[2];
//        int voc = 0;
//        int con = 0;
//        String vocales = "aeiou";
//        for(int i=0;i<frase.length();i++){
//            if(vocales.indexOf(frase.charAt(i))){
//                
//            }
//        }
//        contador[0] = voc;
//        contador[1] = con;
//        
//        
//        return contador;
//    }
    
    
     public int cantPalabras (String[] lineas){
        int z= 0;
        for (String linea : lineas) {
            z += contarPalabras(linea);
        }
        return z;
          
      }
        
      
  
    
}
