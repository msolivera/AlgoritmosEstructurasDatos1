/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd0;

/**
 *
 * @author Meki
 */
public class Perro implements IMamifero  { 
    private String nombre;
    
    public Perro(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void ladrar(){
        System.out.println("wof");
    }
    public boolean respondeA (String unNombre){
        return this.nombre.equals(unNombre);
    }
        public void caminar()
    {
        System.out.println("Perro Caminando");
    }
    public void correr()
    {
        System.out.println("Perro Corriendo");
    }
    public void  saltar()
    {
        System.out.println("Perro Saltando");
    }
    
}
