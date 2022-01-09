/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5.TA4;

import java.util.LinkedList;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class TABBO extends TArbolBB
{
        int[][] w;
        int[][] p;
        int[][] r;
        
        public TABBO(int cantElem)
        {
                crearMatrices(cantElem);
        }
        private void crearMatrices(int cantElem)
        {
                w = new int[cantElem + 1] [cantElem + 1 ];
                p = new int[cantElem + 1] [cantElem + 1 ];
                r = new int[cantElem + 1] [cantElem + 1 ];
        }
        public void encontrarOptimo (int cantElem, int[] frecExito, int[] frecNoExito){
        int i,j,k,kRaiz, h;
        int min, pesoSubArboles;
        kRaiz = 0;
        
        for (i = 0; i<= cantElem; i++){
            this.w[i][i] = frecNoExito[i];
            this.p[i][i] = frecNoExito[i];
        }
        
        for (i = 0; i< cantElem; i++){
            for (j=i+1; j<= cantElem; j++){
                this.w[i][j] = this.w[i][j-1] + frecExito[j] + frecNoExito[j];
            }
        }
        for(i = 0; i < cantElem; i++){
            j=i+1;
            this.p[i][j] = this.w[i][j] + this.p[i][i] + this.p[j][j];
            this.r[i][j] = j;            
        }
        
        for(h=2; h< cantElem+1; h++){
            for(i=0;i<cantElem-h+1;i++){
                j=i+h;
                min=Integer.MAX_VALUE;
                for(k=i+1;k<=j;k++){
                    if((p[i][k-1]+p[k][j]) < min){
                      min = (p[i][k-1]+p[k][j]);
                      kRaiz = k;
                    }
                }
                p[i][j] = min+w[i][j];
                r[i][j] = kRaiz;
            }
        }
        }
        
        public void armarArbol (String[] clave, int[] frecuenciaDeClaves, int i, int j)
        {
                TElementoAB nodoAInsertar;
                int raiz;
                if(i < j )
                {
                        raiz = this.r[i][j];
                        nodoAInsertar = new TElementoAB(clave[raiz], frecuenciaDeClaves[raiz]);
                        this.insertar(nodoAInsertar);
                        this.armarArbol(clave, frecuenciaDeClaves, i, raiz-1);
                        this.armarArbol(clave, frecuenciaDeClaves, raiz, j);
                }
                
        }
        
}

