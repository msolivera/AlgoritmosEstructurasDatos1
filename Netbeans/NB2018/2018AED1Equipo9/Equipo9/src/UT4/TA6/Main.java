package UT4.TA6;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
            /*
        TArbolBB arbol = new TArbolBB();

        // insertar los elementos 12, 25, 14, 1, 33, 88, 45, 2, 7, 66,5, 99
  
    LinkedList<Comparable> li = arbol.inorden();
     for (Comparable c : li){
        System.out.println(c.toString());
     }
       
        System.out.println("\n");
        
     // eliminar los elementos 99, 15, 2, 12, 77, 33 y volver a emitir el inorden....  

        */
            
            TArbolBB instance = new TArbolBB();
            TElementoAB elemento = new TElementoAB(12, 12);
            TElementoAB elemento1 = new TElementoAB(25, 25);
            TElementoAB elemento2 = new TElementoAB(14, 14);
            TElementoAB elemento3 = new TElementoAB(1, 1);
            TElementoAB elemento4 = new TElementoAB(33, 33);
            TElementoAB elemento5 = new TElementoAB(88, 88);
            TElementoAB elemento6 = new TElementoAB(45, 45);
            TElementoAB elemento7 = new TElementoAB(2, 2);
            TElementoAB elemento8 = new TElementoAB(7, 7);
            TElementoAB elemento9 = new TElementoAB(66, 66);
            TElementoAB elemento10 = new TElementoAB(5, 5);
            TElementoAB elemento11 = new TElementoAB(99, 99);
            instance.insertar(elemento);
            instance.insertar(elemento1);
            instance.insertar(elemento2);
            instance.insertar(elemento3);
            instance.insertar(elemento4);
            instance.insertar(elemento5);
            instance.insertar(elemento6);
            instance.insertar(elemento7);
            instance.insertar(elemento8);
            instance.insertar(elemento9);
            instance.insertar(elemento10);
            instance.insertar(elemento11);
            System.out.println(instance.inOrden());
            instance.eliminar(99);
            instance.eliminar(15);
            instance.eliminar(2);
            instance.eliminar(12);
            instance.eliminar(77);
            instance.eliminar(33);
            System.out.println(instance.inorden());
            System.out.println(instance.preOrden());
            System.out.println(instance.postOrden());
    }

}
