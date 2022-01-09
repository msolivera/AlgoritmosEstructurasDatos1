/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1_pd1;

/**
 *
 * @author Meki
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Multsuma m = new Multsuma();
        
        m.multiSuma(1.0, 2.0,3.0);
        System.out.println(m.multiSuma(1.0, 2.0,3.0));
        
        Alumno alumno = new Alumno("Micaela");
        
        System.out.println(alumno.getNombreAdmiracion());
        System.out.println(alumno.recorrer("Micaela"));
        System.out.println(alumno.getValor());
        System.out.println(alumno.getPrimerCaracter("hOLA"));
        System.out.println(alumno.paraAString(1234));
        
        Contador c = new Contador();
        System.out.println(c.mostrarContador());
    }
    
}
