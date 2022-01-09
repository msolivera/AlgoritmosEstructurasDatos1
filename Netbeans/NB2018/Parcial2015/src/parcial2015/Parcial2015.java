/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2015;

/**
 *
 * @author Meki
 */
public class Parcial2015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaOrdenada primera = new ListaOrdenada ();
        ListaOrdenada segunda = new ListaOrdenada ();
        Nodo nodo1 = new Nodo(2,2);
        Nodo nodo2 = new Nodo(4,4);
        Nodo nodo3 = new Nodo(3,3);
        Nodo nodo4 = new Nodo(6,6);
        Nodo nodo5 = new Nodo(5,5);
        Nodo nodo6 = new Nodo(8,8);
        Nodo nodo7 = new Nodo(7,7);
        Nodo nodo8 = new Nodo(9,9);
        Nodo nodo9 = new Nodo(10,10);
        Nodo nodo10 = new Nodo(0,0);
       
        primera.insertarOrdenado(nodo1);
        primera.insertarOrdenado(nodo3);
        primera.insertarOrdenado(nodo5);
        primera.insertarOrdenado(nodo7);
        primera.insertarOrdenado(nodo9);
        System.out.println("primer lista");
        primera.imprimir();
        
        
        
        segunda.insertarOrdenado(nodo2);
        segunda.insertarOrdenado(nodo4);
        segunda.insertarOrdenado(nodo6);
        segunda.insertarOrdenado(nodo8);
        segunda.insertarOrdenado(nodo10);
        System.out.println("segunda lista");
        segunda.imprimir();
        
        primera.mezclarOrdenado(segunda);
        System.out.println("resultado");
        
        primera.imprimir();
        /*
        System.out.println("lista con duplicados");              
        Nodo nodo11 = new Nodo(1,9);
        Nodo nodo12 = new Nodo(2,10);
        Nodo nodo13 = new Nodo(2,0);
        Nodo nodo14 = new Nodo (3,5);
        
        ListaOrdenada duplica = new ListaOrdenada();
        duplica.insertar(nodo11);
        duplica.insertar(nodo12);
        duplica.insertar(nodo13);
        duplica.insertar(nodo14);
        duplica.imprimir();
        duplica.eliminarDuplicado();
        duplica.imprimir();*/
        
        ListaOrdenada lista = new ListaOrdenada();
        Nodo hola = new Nodo(0, 0);
        Nodo hola6 = new Nodo(5, 2);; 
        Nodo hola2 = new Nodo(3, 2);
        Nodo hola10 = new Nodo(6, 2);
        lista.insertarOrdenado(hola);
        lista.insertarOrdenado(hola2);
        lista.insertarOrdenado(hola6);
        lista.insertarOrdenado(hola10);
        
        //lista.imprimir();
        System.out.println("__");
        Nodo hola5 = new Nodo(2, 0);
        Nodo hola3 = new Nodo(8, 2);; 
        Nodo hola4 = new Nodo(4, 2);
        //Nodo hola7 = new Nodo(9, 2);
        ListaOrdenada lista2 = new ListaOrdenada();
        lista2.insertarOrdenado(hola5);
        lista2.insertarOrdenado(hola3);
        lista2.insertarOrdenado(hola4);
        lista2.invertir();
        lista2.imprimir();
        
        //lista2.insertarO(hola7);
       // lista2.imprimir();
        System.out.println("___");
        //lista2.mezclarCon_VarianteDos(lista);
        //lista2.imprimir();
        
        System.out.println("_");
        System.out.println("_");
        lista2.invertir();
        lista2.imprimir();
                

    }
    
}
