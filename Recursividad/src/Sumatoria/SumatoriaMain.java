/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sumatoria;

/**
 *
 * @author Meki
 */
public class SumatoriaMain {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num = 9;
        int resultado = sumatoriaRecursiva(num);
        System.out.println("Resultado de sumatoria de "+num+" es: "+resultado);
    }
    
    public static int sumatoriaRecursiva(int numero) {

        int resultado = 0;

        if (numero == 1) {

            return 1;

        } else {
            resultado = numero + sumatoriaRecursiva(numero - 1);

        }

        return resultado;

    }


}
