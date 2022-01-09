/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_pd3;

/**
 *
 * @author Meki
 */
public class Carta {
    
    public String palo;
    public int numero;
    
    public Carta( String palo, int numero){
        this.palo = palo;
        this.numero = numero;
    }
    
    public void mostrarCarta() {
        System.out.println("Carta del palo "+palo+" y numero "+numero);
    }
}
