package ut4ta5;

import UT5TA4.*;

public class Util {

    public static void imprimirMatriz(int[][] matriz) {
        System.out.print("");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
