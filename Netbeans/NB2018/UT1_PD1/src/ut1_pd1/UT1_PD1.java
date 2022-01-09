/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1_pd1;

/**
¿Cuál es la salida? Sé preciso acerca de dónde hay espacios y dónde hay nuevas líneas.
Indicar cuál es la respuesta más correcta: (\n denota nueva línea)
 */
public class UT1_PD1 {

public static void zoop () {
    baffle ();
    System.out.print ("Vos zacata ");
    baffle ();
    }
public static void main (String[] args) {
    System.out.print ("No, yo ");
    zoop ();
    System.out.print ("Yo ");
    baffle ();
    }
   public static void baffle () {
    System.out.print ("pac");
    ping ();
    }
public static void ping () {
    System.out.println (".");
    }
    }
   
