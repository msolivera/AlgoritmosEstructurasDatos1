package UT3PD10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Josse
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio1();
    }

    public static void ejercicio1() {
        
        TesteadorPreparados tester = new TesteadorPreparados();
        tester.cargarSueros("src\\UT3PD10\\Sueros.txt");
        tester.cargarFarmacos("src\\UT3PD10\\farmacos.txt");
        tester.cargarListaBlanca("src\\UT3PD10\\listablanca.txt");
        tester.cargarListaNegra("src\\UT3PD10\\listanegra.txt");

        Lista<Integer> idFarmacos = new Lista<>();
        
        Nodo<Integer> nodo1 = new Nodo (1,null);
        Nodo<Integer> nodo2 = new Nodo (12,null);
        Nodo<Integer> nodo3 = new Nodo (31,null);
        
        idFarmacos.insertar(nodo1);
        idFarmacos.insertar(nodo2);
        idFarmacos.insertar(nodo3);

        tester.preparadoViable(299, idFarmacos);
        tester.preparadoViable(29999, idFarmacos); 
        tester.preparadoViable(15, idFarmacos);   
    }
}
