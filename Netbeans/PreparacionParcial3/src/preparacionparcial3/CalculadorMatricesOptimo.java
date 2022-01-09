package preparacionparcial3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meki
 */
public class CalculadorMatricesOptimo {
    /** Matriz peso */
    public int[][] W;
    
    /** Matriz longitud trayectorias */
    public int[][] P;
    
    /** Matriz raíces */
    public int[][] R;

    /**
     * Constructor por defecto de la clase
     * @param cantElem 
     */
    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    /**
     * Crea las matrices iniciales
     * @param cantElem 
     */
    private void crearMatrices(int cantElem) {
        W = new int[cantElem + 1][cantElem + 1];
        P = new int[cantElem + 1][cantElem + 1];
        R = new int[cantElem + 1][cantElem + 1];
    }
    
    /**
     * Genera un árbol binario de búsqueda óptimo
     * @param i
     * @param j
     * @param claves
     * @param elArbolBB 
     */
    public void armarArbolBinario(int i, int j, String[] claves, TArbolBB elArbolBB) {
        int unaRaiz;
        
        if (i < j) {
            unaRaiz = R[i][j];
            elArbolBB.insertar(new TElementoAB(claves[unaRaiz], null));
            armarArbolBinario(i, unaRaiz-1, claves, elArbolBB);
            armarArbolBinario(unaRaiz, j, claves, elArbolBB);
        }
    }
    
    /**
     * Encuentra el árbol óptimo
     * @param cantElem
     * @param freqExito
     * @param freqNoExito 
     */
    public void encontrarOptimo(int cantElem, int[] freqExito, int[] freqNoExito) {
        int i, j, k, kraiz, h;
        int min, pesoSubArboles;
        kraiz = 0;
        
        // PASO 1, h = 0
        // Llenamos diagonales P y W
        for (i = 0; i <= cantElem; i++) {
            P[i][i] = freqNoExito[i];
            W[i][i] = freqNoExito[i];
        }
        
        // PASO 2
        // Ahora llenamos el resto de W
        for (i = 0; i <= cantElem; i++) {
            for (j = i + 1; j <= cantElem; j++) {
                W[i][j] = W[i][j-1] + freqExito[j] + freqNoExito[j];
            }
        }
        
        // PASO 3, h = 1
        // Llenamos P y R, caso h = 1
        for (i = 0; i < cantElem; i++) {
            j = i + 1;
            P[i][j] = W[i][j] + P[i][i] + P[j][j];
            R[i][j] = j;
        }
        
        // PASO 4, h = 2
        // Llenamos P y R para cualquier h >= 2
        kraiz = 0;
        pesoSubArboles = 0;
        for (h = 2; h < cantElem + 1; h++) {
            for (i = 0; i < cantElem - h + 1; i++) {
                j = i + h;
                min = Integer.MAX_VALUE;
                
                // Hallamos min.
                for (k = i + 1; k <= j; k++) {
                    pesoSubArboles = P[i][k-1] + P[k][j];
                    if (pesoSubArboles < min) {
                        min = pesoSubArboles;
                        kraiz = k;
                    }
                }
                
                // Actualizamos P y R
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
            }
        }
    }
}
