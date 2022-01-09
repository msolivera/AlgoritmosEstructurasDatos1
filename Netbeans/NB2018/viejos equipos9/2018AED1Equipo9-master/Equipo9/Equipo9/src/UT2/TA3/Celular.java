/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_TA3;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Celular 
{
        public String Convertidor (String texto)
            
    {
        String fn = "";
        
        
        for (int i= texto.length()-1 ; i>=0 ;i--)
        {
           fn += texto.charAt(i);
           
        }
        return fn;
        
    }
    
    
    
    public String Decodificador (String linea)
    {
        String var = "";
        
        String aux2 = Convertidor(linea);
        String aux = aux2.toUpperCase();
               
        for ( int i =0 ; i < aux.length(); i++)
        {
          if (aux.charAt(i) == 'A' || aux.charAt(i) == 'B' || aux.charAt(i) == 'C' )
          {
              var += 2;
              
          }
          else if (aux.charAt(i) == 'D' || aux.charAt(i) == 'F' || aux.charAt(i) == 'E' )
          {
              var += 3;
              
          }
          else if (aux.charAt(i) == 'G' || aux.charAt(i) == 'H' || aux.charAt(i) == 'I' )
          {
              var += 4;
              
          }
          else if (aux.charAt(i) == 'J' || aux.charAt(i) == 'K' || aux.charAt(i) == 'L' )
          {
              var += 5;
              
          }
          else if (aux.charAt(i) == 'M' || aux.charAt(i) == 'N' || aux.charAt(i) == 'O' )
          {
              var += 6;
              
          }
          else if (aux.charAt(i) == 'P' || aux.charAt(i) == 'Q' || aux.charAt(i) == 'R'|| aux.charAt(i) == 'S' )
          {
              var += 7;
              
          }
          else if (aux.charAt(i) == 'T' || aux.charAt(i) == 'U' || aux.charAt(i) == 'V' )
          {
              var += 8;
              
          }
          else if (aux.charAt(i) == 'W' || aux.charAt(i) == 'X' || aux.charAt(i) == 'Y'|| aux.charAt(i) == 'Z' )
          {
              var += 9;
              
          }
          else if (aux.charAt(i) == ' ')
          {
              var += 0;
              
          }else if (aux.charAt(i) == '.')
          {
              var += 1;
              
          }
        
          
        }
        return var;  
        
        
    }
        
}
