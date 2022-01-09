/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;
import java.io.IOException;
/**
 *
 * @author Meki
 */
public class PrimerParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        
                Lista lista = new Lista();
                ListaOrdenada lista1 = new ListaOrdenada();
                Nodo nodo1 = new Nodo(5,1);
                Nodo nodo2 = new Nodo(20,2);
                Nodo nodo3 = new Nodo(30,7);
                Nodo nodo4 = new Nodo(24,25);
                Nodo nodo5 = new Nodo(22,0);
                Nodo nodo6 = new Nodo(10,14);
               
                lista1.insertar(nodo4);
                lista1.insertar(nodo5);
                lista1.insertar(nodo6);
                lista1.imprimir(); 
                lista.imprimir();
                
                lista.invertir();
                lista.imprimir();
                

                
    }
    
}
