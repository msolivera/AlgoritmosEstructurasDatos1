/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta4;

/**
 *
 * @author usuario
 */
public class TArbolBinarioOptimo{

    int[][] W;
    int[][] P;
    int[][] R;

    public TArbolBinarioOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    private void crearMatrices(int cantElem) {
        W = new int[cantElem + 1][cantElem + 1];
        P = new int[cantElem + 1][cantElem + 1];
        R = new int[cantElem + 1][cantElem + 1];
    }

    public void encontrarOptimo(int cantElem, int[] frecExito, int[] frecNoExito) {
        int i, j, k, kraiz, h;
        int min, pesoSubArboles;
        kraiz = 0;

        //PASO 1, h = 0, Wii = Bii y Pii = Wii
        for (k = 0; k <= cantElem; k++) {
            W[k][k] = frecNoExito[k];
            P[k][k] = frecNoExito[k];
        }

        //PASO 2, Wij = Wij-1 + Aj + Bj
        for (i = 0; i < cantElem; i++) {
            for (j = i + 1; j <= cantElem; j++) {
                W[i][j] = W[i][j - 1] + frecExito[j] + frecNoExito[j];
            }
        }

        //PASO 3, h = 1 Pij = Wij + Pii + Pjj
        for (i = 0; i < cantElem; i++) {
            j = i + 1;
            P[i][j] = W[i][j] + P[i][i] + P[j][j];
            R[i][j] = j;
        }

        //PASO 4, h = 2 hasta h = n
        for(h = 2; h <= cantElem; h++){
            for(i = 0; i <= cantElem - h; i++){
                j = i + h;
                
                min = Integer.MAX_VALUE;
                //encontrar k y min:
                for(k = i+1; k <= j; k++){
                    if(min > (P[i][k-1] + P[k][j])){
                        min = P[i][k-1] + P[k][j];
                        kraiz = k;
                    }
                }
                
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
                
            }
        }
    }
    
    void armarArbolBinario(int i, int j, String[] claves, TArbolBB elArbolBB){
        TElementoAB unNodo;
        int unaRaiz;
        if(i<j){
            unaRaiz = R[i][j];
            unNodo = new TElementoAB(unaRaiz, claves[unaRaiz]);
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i, unaRaiz-1, claves, elArbolBB);
            armarArbolBinario(unaRaiz, j, claves, elArbolBB);
        }
    }
}
