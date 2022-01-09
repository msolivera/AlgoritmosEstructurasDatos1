/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4PD4;

/**
 *
 * @author Meki
 */
public class UT4PD4 {
     public static void main(String[] args) {
                  
         int n = 5;
         int resultado = factorialRecursivo(n);
         System.out.println("Factorial de " + n + " es: " + resultado);
         int m = 4;
         int resultadoM = factorialRecursivo(m);
         System.out.println("Factorial de " + m + " es: " + resultadoM);
         int k = 0;
         int resultadoK = factorialRecursivo(k);
         System.out.println("Factorial de " + k + " es: " + resultadoK);
         
         int[] A = new int[5];
         A[0] = 4;
         A[1] = 3;
         A[2] = 6;
         A[3] = 2;
         A[4] = 5;
         
         int resultadoSuma = sumaLineal(A , 5);
         System.out.println("suma lineal hasta 5 " +resultadoSuma );
         
         int resultadoSuma2 = sumaLineal(A , 3);
         System.out.println("suma lineal hasta 3 " +resultadoSuma2 );
         
         System.out.println("Array invertido:");
         int[] b = invertirArray(A, 0,4);
         for (int i = 0; i < b.length; i++) {
             System.out.println(b[i]);
             
         }
        int x = 0;
        while (x != 9) {
            System.out.println("Fibonacci binario de " + x + " = " + fibonacciBinario(x));
            x++;
        }
        
         System.out.println("potencia 5^4 = "+potencia(5,4));   
    }
     
     //EJERCICIO 1
    public static int factorialRecursivo(int numero) {

        if (numero == 0) {
            return 1;
        } else {
            return numero*factorialRecursivo(numero -1);
        }
    }
     //EJERCICIO 2
   public static int sumaLineal(int[] A, int n) {
        if (n == 1) {
            return A[0];
        } else {
            return sumaLineal(A, n - 1) + A[n - 1];
        }

    }
   //EJERCICIO 3
   
    public static int potencia(int x, int n) {
        if (n == 0) {
            return 1;
        } else {

            return x * potencia(x, n - 1);
        }
    }
   //EJERCICIO 4
   
    public static int[] invertirArray(int[] A, int i, int j) {
        if (i < j) {
            A[j] = i;
            A[i] = j;
            invertirArray(A, i + 1, j - 1);

        }
        return A;
    }
    
    //PLUS
        public static int fibonacciBinario(int k) {

        if (k == 1 || k == 0) {
            return 1;
        } else {
            return fibonacciBinario(k - 1) + fibonacciBinario(k - 2);
        }
            
    }
}
