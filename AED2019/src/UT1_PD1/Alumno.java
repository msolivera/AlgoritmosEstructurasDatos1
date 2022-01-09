/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1_PD1;

/**
 *
 * @author Meki
 */
public class Alumno {

    private String nombre;

    public Alumno() {
        //nombre = null; antes era asi
        nombre = "micaela"; //esto lo arregle yo
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");

    }

    public static void main(String[] args) {
        //a)
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
        //b)
        int pruebaReco = recorrer(alumno.nombre);
        System.out.println(pruebaReco);
        //c)
        int pruebaValor = getValor();
        System.out.println(pruebaValor);
        //d)
        char caracter = getPrimerCaracter(alumno.nombre);
        System.out.println(caracter);
        //e)
        String letra = paraAString(12);
        System.out.println(letra);
       
    }

    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = {6, 16, 26, 36, 46, 56, 66, 76};
        //int idx = 8;
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
       // String string[] = new String[5];
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        //return (String) (x1);
        
        return x1.toString();
    }

}

/*
a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste? 
ERROR: java.lang.NullPointerException
el atributo nombre no tenia valor asociado era nulo

b) Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
ERROR:  java.lang.StringIndexOutOfBoundsException
en el for decia for (int i = 0; i <= cadena.length(); i++) y eso no puede ser asi
puesto que si i = cadena.length() se va de rango.

c) Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste?
ERROR:  java.lang.ArrayIndexOutOfBoundsException: 8
El error pasa porque al inicio el int indx esta definido en 8 pero el indice 8 no
existe en el array puesto que se numeran del 0 al 7 (8 valores)

d) Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste? 
ERROR:java.lang.NullPointerException
Este error ocurre puesto que String string[] = new String[5]; es innecesario ademas el charAt estaba en 1
y la primera posicion es 0

e) Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste? 
ERROR: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
estaba mal definido como convertir el numero a estring
*/