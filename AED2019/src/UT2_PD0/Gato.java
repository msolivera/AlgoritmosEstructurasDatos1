/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD0;

/**
 *
 * @author Meki
 */
public class Gato implements Mamifero {

    private String nombre;

    public Gato(String nombre) {
        
        nombre = this.nombre;
    }
    


    @Override
    public String getNombre() {
        return this.nombre;

    }

    @Override
    public boolean responderA (String unNombre){
        
        return false; //NUNCA RESPONDEN
    }
    

    @Override
    public void correr(){
        
        System.out.println("mi gatito esta corriendo");
    }
    
    @Override
    public void saltar(){
        System.out.println("mi gato esta saltanto");
    }
    
    @Override
    public void caminar (){
        
        System.out.println("mi gato camina lento");
        
        
    }
    
    public void maullar() {

        System.out.println("miau miau");
    }


}
