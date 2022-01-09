/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meki
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        String A = "Si piensas          que tu profesor es exigente,... espera a conocer a tu jefe ! ";
   
        ContadorPalabras contador= new ContadorPalabras();
        System.out.println(contador.contarPalabras(A));
        
        
}/* BUCLE INFINITO
    ciclar (10);
public static void ciclar(int n) {
        int i = n;
        while (i > 0) {
                System.out.println (i);
                if (i%2 == 0) {
                    i = i/2;
                } else {
                i = i+1;
                    }
            }
    }*/
    
}
