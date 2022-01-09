/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD3;

/**
 *EJERCICIO 3
 * @author Meki
 */
public class SomethingIsWrong {
/*1) Indica qué es lo que está mal en el siguiente programa: 
    emitiento un error debido a que falta crear una clase rectangulo. \
    Tampoco estaba inicializador el rectangulo myRect
    tampoco existe el metodo area
    */
    
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}
/*2) Repara el error, ejecuta el programa y verifica que la salida es correcta. 
la salida arrojada es correcta
*/
