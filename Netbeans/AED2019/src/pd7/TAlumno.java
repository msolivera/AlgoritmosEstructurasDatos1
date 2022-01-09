/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd7;

/**
 *
 * @author Meki
 */
public class TAlumno {
    private String nombre;
    private String apellido;
    private int ci;
    
    public TAlumno(String n, String a, int c){
       this.apellido = a;
       this.ci = c;
       this.nombre = n;
    }
    
    public int getCedula(){
        return this.ci;
    }
    
    public void imprimirInfo(){
        System.out.println(this.nombre+' '+this.apellido);
    }
}
