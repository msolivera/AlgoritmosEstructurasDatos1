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
public interface IMamifero {
    
    
    public String getNombre();
    public boolean respondeA (String unNombre);
    public void caminar();
    public void correr();
    public void saltar();
}
