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
public class Perro implements Mamifero {
    
    private String nombre;
    
    public Perro (String nombre){
        
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre(){
        
        return this.nombre;
    }
    
    
    @Override
    public boolean responderA(String unNombre){
        
        return this.nombre.equals(unNombre);
    }
    
    @Override
    public void correr (){
        
        System.out.println("mi perro esta corriendo!!!");
    }
    
    @Override
    public void caminar(){
        System.out.println("perrito caminando");
    }
    
    @Override
    public void saltar(){
        
        System.out.println("mi perro salta muy alto!!!");
    }
    
    public void ladrar(){
        
        System.out.println("Wof wof");
    }
    
    
}
