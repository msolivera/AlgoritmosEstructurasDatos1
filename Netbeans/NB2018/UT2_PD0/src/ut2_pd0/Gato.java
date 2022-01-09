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
public class Gato implements IMamifero{
    
    private String nombre;
    public Gato (String nombre) {
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void maullar(){
        System.out.println("miau");
    }
    public boolean respondeA (String unNombre){
        System.out.println("No responde a nada");
        return false;
    }
    public void caminar()
    {
        System.out.println("Gato Caminando");
    }
    public void correr()
    {
        System.out.println("Gato Corriendo");
    }
    public void  saltar()
    {
        System.out.println("Gato Saltando");
    }
}
