/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1_PD3;

/**
 *
 * @author Meki
 */
public class ContadorDePalabras {
     
     public int contarPalabras(String frase){
        int contador =1;
        int largo = frase.length();
        
        for(int i =1; i<largo ; i++){
          if ((!(Character.isDigit(frase.charAt(i))))&& (!(Character.isLetter(frase.charAt(i)))))
                  {
                        if ((!(Character.isDigit(frase.charAt(i-1))))&& (!(Character.isLetter(frase.charAt(i-1))))){
                            
                        }
                        else{
                            contador++;
                        }
                  }
        }
        return contador;
        
    }
     
      public static void main(String[] args) {
          
     ContadorDePalabras contador = new ContadorDePalabras();
     
          System.out.println(contador.contarPalabras("micaela es una gran chica"));
      
      
      
      }
      
    
}
