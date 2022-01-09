/*
a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?
    CLASE ALUMNO NO TENIA NOMBRE. ERA INSTANCIADO COMO NULL.
b) Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
    contador inicia con valor 1,  y la cadena se iba de rango.
c) Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste?
    EL INT IDX ESTABA FUERA DE RANGO
d) Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste?
    USO DE VECTOR INECESARIO palabra.charAt(0) YA DEVUELVE EL PRIMER CARACTER
e) Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste?
    return (String) (x1) no se que es pero no esta bien, x1.toString hace lo correcto
 */
package ut1_pd1;

/**
 *
 * @author Meki
 */
public class Alumno {
    private String nombre;
    public Alumno ( String nombre) {
    this.nombre = nombre;
    }
    
public String getNombreAdmiracion() {
    return nombre.concat("!");
    }


public int recorrer (String cadena) {
    int res = 0;
    for (int i = 0; i <= cadena.length()-1; i++) {
    if (cadena.charAt(i) != ' ') {
    res++;
    }
    }
    return res;
    }


public int getValor() {
int vector[] = { 6, 16, 26,36,46,56,66,76 };
int idx = 7;
return vector[idx];
}


public char getPrimerCaracter(String palabra) {
//String string[] = new String[5];
return (palabra.charAt(0));
}

public String paraAString(int a) {
Object x1 = new Integer(a);

return x1.toString();
}
    
}
