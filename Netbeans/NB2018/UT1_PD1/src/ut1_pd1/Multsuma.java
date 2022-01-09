/*
Muchos cálculos pueden ser expresados de manera concisa usando la operación “multsuma”,
que toma tres operandos y computa a*b + c. Algunos procesadores incluso proveen una
implementación de hardware para esta operación para números de punto flotante.
Crear un nuevo programa llamado Multsuma.java. Escribir un método llamado multsuma que
toma tres doubles como parámetros y que imprime el resultado de multisumarlo.
Escribir un método main que testee multsuma invocándolo con unos pocos parámetros
simples, como por ejemplo 1.0, 2.0, 3.0, y después imprima por consola el resultado, que en
ese caso debería ser 5.0.
 */
package ut1_pd1;

/**
 *
 * @author Meki
 */
public class Multsuma 
{ 
    public double multiSuma (double a, double b ,double c)
    {
        double resultado;
        resultado = (a*b)+c;
          return resultado;
    
        
    }
  
}
