package ut5ta4;

/**
 *
 * @author Bruno
 */
public class UT5TA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] lineas1, lineas2;
        if (false) {
            lineas1 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA4/UT5_TA2-Claves-y-FE.txt");
            lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA4/UT5_TA2-FNE.txt");
        } else {
            lineas1 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA4/palabras.txt");
            lineas2 = ManejadorArchivosGenerico.leerArchivo("src/UT5TA4/nopalabras.txt");
        }

        int cantElem = lineas1.length;
        String[] claves = new String[cantElem + 1];
        int[] fe = new int[cantElem + 1];
        int[] fne = new int[cantElem + 1];

        for (int i = 1; i <= cantElem; i++) {
            String[] datos = lineas1[i - 1].split(" ");
            claves[i] = datos[0];
            fe[i] = Integer.valueOf(datos[1]);
        }

        for (int i = 0; i <= cantElem; i++) {
            fne[i] = Integer.valueOf(lineas2[i]);
        }

        //Claves: clave
        //Frecuencias exito (a): fe
        //Frecuencias sin exito (b): fne
        //Test imprimir matrices
        TArbolBinarioOptimo abo = new TArbolBinarioOptimo(cantElem);
        TArbolBB arbolBB = new TArbolBB();
        abo.encontrarOptimo(cantElem, fe, fne);
        abo.armarArbolBinario(0, cantElem, claves, arbolBB);

        System.out.println(arbolBB.inOrden());

        /*
        System.out.println("Matriz W");
        Util.imprimirMatriz(arbol.W);
        System.out.println("");
        System.out.println("Matriz P");
        Util.imprimirMatriz(arbol.P);
        System.out.println("");
        System.out.println("Matriz R");
        Util.imprimirMatriz(arbol.R);
         */
    }

}
