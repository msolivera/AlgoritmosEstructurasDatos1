package UT4TA4;


/**
 *
 * @author Bruno
 */
public class UT4TA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        TElementoAB elem = new TElementoAB(1);
        arbol.insertar(elem);
        
        System.out.println(arbol.nivel(1));
        

        
        
    }

}
