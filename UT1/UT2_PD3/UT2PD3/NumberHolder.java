/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD3;

/**
 *
 * @author Meki
 */
public class NumberHolder{  
    
        public int anInt;     
        public float aFloat; 
        
    public NumberHolder (int a , float b){
        this.anInt = a;
        this.aFloat = b;
    }
    
    public void imprimir(){
        System.out.println("anInt = "+this.anInt);
        System.out.println("aFloat = "+this.aFloat);
    }
}