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
public class Mazo {
    
    Carta[] lista = new Carta[12];
    
    
    
    public Mazo(){
        
    }
    
    public void crearMazo()
    {
        
        Carta p1 = new Carta ("palo",1);
        Carta p2 = new Carta ("palo",2);
        Carta p3 = new Carta ("palo",3);
        Carta p4 = new Carta ("palo",4);
        Carta p5 = new Carta ("palo",5);
        Carta p6 = new Carta ("palo",6);
        
        Carta e1 = new Carta ("espada",1);
        Carta e2 = new Carta ("espada",2);
        Carta e3 = new Carta ("espada",3);
        Carta e4 = new Carta ("espada",4);
        Carta e5 = new Carta ("espada",5);
        Carta e6 = new Carta ("espada",6);
        
        lista[0] = p1;
        lista[1] = p2;
        lista[2] = p3;
        lista[3] = p4;
        lista[4] = p5;
        lista[5] = p6;
        lista[6] = e1;
        lista[7] = e2;
        lista[8] = e3;
        lista[9] = e4;
        lista[10] = e5;
        lista[11] = e6;
        
        
    }
    
    public void mostrarMazo(){
      
            
        for(int i=0; i<lista.length; i++){
		lista[i].mostrarCarta();
	}
        
        
    
    }
    
    
}
