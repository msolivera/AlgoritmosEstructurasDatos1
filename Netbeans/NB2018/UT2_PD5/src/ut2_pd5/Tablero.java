package ut2_pd5;

/*
Escribe un programa llamado Tablero que imprima un tablero de nxn siguiendo el siguiente patrón de ejemplo.
 */

/**
 *
 * @author Meki
 */
public class Tablero {
    
    int largo;
    int filas;
    
    public Tablero (int largo , int filas){
        this.filas=filas;
        this.largo=largo;
    }
    
    
    
    public void dibujar(){
        int contador = 0;
        String repeated;
        while(contador < filas) {
            System.out.println(repeated = new String(new char[largo]).replace("\0", "#"));
            contador++;
            
        }
        
    }
}
