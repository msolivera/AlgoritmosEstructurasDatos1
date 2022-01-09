/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerParcial;


/**
 *
 * @author Usuario
 */
public class CalculadorMatricesOptimo{

    int[][] W;
    int[][] P;
    int[][] R;

    public CalculadorMatricesOptimo(int cantElemento) {
        crearMatrices(cantElemento);

    }

    private void crearMatrices(int cantElemento) {
        W = new int[cantElemento + 1][cantElemento + 1];
        P = new int[cantElemento + 1][cantElemento + 1];
        R = new int[cantElemento + 1][cantElemento + 1];
    }
    
    public void armarArbolBinario (int i, int j , String[] Claves, TArbolBB elArbolBB){
        int unaRaiz;
        if (i<j){
            unaRaiz = this.R[i][j];
            TElementoAB unNodo = new TElementoAB(Claves[unaRaiz],Claves[unaRaiz]);
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i,unaRaiz-1,Claves,elArbolBB);
            armarArbolBinario(unaRaiz,j,Claves,elArbolBB);
            
        }
    }
    
    

    public void encontrarOptimo(int cantElemento, int[] frecExito, int[] frecNoExito) {
        int i, j, k, kraiz, h;
        int min, pesoSubArboles;
        kraiz = 0;

        /*Paso 1 - h=0, wii=bi y pii=wii */
        for (i = 0; i <= cantElemento; i++) {
            W[i][i] = frecNoExito[i];
            P[i][i] = W[i][i];
        }

        //Paso 2 W   
        for (i = 0; i < cantElemento; i++) {
            for (j = i + 1; j <= cantElemento; j++) {
                W[i][j] = W[i][j - 1] + frecExito[j] + frecNoExito[j];
            }
        }
        
        //Paso 3 P
        for (i = 0; i < cantElemento; i++) {
            for (j = i + 1; j <= cantElemento; j++) {
                P[i][j] = W[i][j] + P[i][i] + P[j][j];
                R[i][j]=j;
            }

        }
        
        //Paso 4 P
        kraiz = 0;
        for (h = 2; h < cantElemento + 1; h++) {
            for (i = 0; i < cantElemento - h + 1; i++) {
                j = i + h;
                min = Integer.MAX_VALUE;
                
                for (k=i+1;k<=j;k++){
                    pesoSubArboles =  P[i][k-1] + P[k][j];
                    if(pesoSubArboles<min){
                        min=pesoSubArboles;
                        kraiz = k;
                   }
                }
                
                P[i][j]=min + W[i][j];
                R[i][j] = kraiz;

            }
        }
    }

}
