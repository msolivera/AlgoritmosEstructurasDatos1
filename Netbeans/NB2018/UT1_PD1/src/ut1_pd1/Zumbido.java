/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1_pd1;

/**
a) ¿Cuál es la primera sentencia que se ejecuta?
b) Escribir número 2 al lado de la segunda sentencia, un 3 al lado de la que se ejecuta en
tercer lugar, y así siguiendo hasta el final del programa. Si una sentencia se ejecuta más
de una vez, puede que termine con más de un número al lado.
 */
public class Zumbido {
 public static void desconcertar (String dirigible) {
System.out.println (dirigible);
sipo ("ping", -5);
}
public static void sipo (String membrillo, int flag) {
if (flag < 0) {
System.out.println (membrillo + " sup");
} else {
System.out.println ("ik");
desconcertar (membrillo);
System.out.println ("muaa-ja-ja-ja");
}
}
public static void main (String[] args) {
sipo ("traqueteo", 13);
}
    
}
