/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1_PD1;

/**
 *
 * @author Meki
 */
public class Contador {
    
    final int MAX_CONT = 50; 
    int incremento = 1; 
    int contador = 1; 
    
    
public void mostrarContador(){

    
    while(contador <= MAX_CONT){
        
        System.out.println("El valor del contador es: " + contador);
        contador += incremento;
    
    }

}

public void mostrarContador1(){

    
    do {
        System.out.println("El valor del contador es: " + contador);
        contador += incremento;
    }
    
    while(contador <= MAX_CONT);
    
    

}

public void mostrarContador2(){

    
    for (contador = 0; contador <= MAX_CONT; contador += incremento ){
        
        System.out.println("El valor del contador es: " + contador);
    
    }

}

public static void main (String [] args){
    
    Contador contador = new Contador();
    
    contador.mostrarContador();
    
    
    contador.mostrarContador1();
    
    contador.mostrarContador2();

    
}
    
         
    
}
