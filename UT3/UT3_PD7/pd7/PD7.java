/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd7;

/**
 *
 * @author Meki
 */
public class PD7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //PRUEBAS GENERALES
        /*
        Nodo nodo1 = new Nodo(1,"hola");
        Nodo nodo2 = new Nodo(8,"hola");
        Nodo nodo3 = new Nodo(5,"hola");
        Nodo nodo4 = new Nodo(2,"hola");
        Nodo nodo5 = new Nodo(7,"hola");
        Nodo nodo6 = new Nodo(3,"hola");
        
        Nodo nodo7 = new Nodo(1,"hola");
        Nodo nodo8 = new Nodo(8,"hola");
        Nodo nodo9 = new Nodo(5,"hola");
        Nodo nodo10 = new Nodo(12,"hola");
        Nodo nodo11 = new Nodo(17,"hola");
        Nodo nodo12 = new Nodo(13,"hola");
        
        Conjunto unaLista = new Conjunto();
        Conjunto otraLista = new Conjunto();
        Conjunto vacia = new Conjunto();
      
        unaLista.insertar(nodo1);
        unaLista.insertar(nodo2);
        unaLista.insertar(nodo3);
        unaLista.insertar(nodo4);
        unaLista.insertar(nodo5);
        unaLista.insertar(nodo6);
        
        otraLista.insertar(nodo7);
        otraLista.insertar(nodo8);
        otraLista.insertar(nodo9);
        otraLista.insertar(nodo10);
        otraLista.insertar(nodo11);
        otraLista.insertar(nodo12);
      
        unaLista.imprimir();
        System.out.println("-----------");
        otraLista.imprimir();
        System.out.println("INTERSECCION");
        unaLista.Interseccion(otraLista).imprimir();
        System.out.println("UNION");
        unaLista.union(otraLista).imprimir();
        System.out.println("-------------------------------------------");
        System.out.println("Probando interseccion con lista vacia");
        unaLista.Interseccion(vacia).imprimir();
        System.out.println("Probando union con lista vacia");
        unaLista.union(vacia).imprimir();
        System.out.println("---------------------------------------------");
        System.out.println("Probando interseccion si mi lista es vacia");
        vacia.Interseccion(otraLista).imprimir();
        System.out.println("Probando union si mi lista es vacia");
        vacia.union(unaLista).imprimir();
        System.out.println("-----------------------------------------------");
        */
        TAlumno a1 = new TAlumno("micaela", "olivera", 523);
        Nodo n1 = new Nodo(a1.getCedula(), a1);
        TAlumno a2 = new TAlumno("agus", "picos", 4452);
        Nodo n2 = new Nodo(a2.getCedula(), a2);
        TAlumno a3 = new TAlumno("lucas", "astor", 2344);
        Nodo n3 = new Nodo(a3.getCedula(), a3);
        TAlumno a4 = new TAlumno("bruno", "delegado", 6785);
        Nodo n4 = new Nodo(a4.getCedula(), a4);
        TAlumno a5 = new TAlumno("diego", "vazquez", 6674);
        Nodo n5 = new Nodo(a5.getCedula(), a5);
        TAlumno a6 = new TAlumno("andrea", "abimorad", 3443);
        Nodo n6 = new Nodo(a6.getCedula(), a6);
        
        Conjunto AED = new Conjunto();
        Conjunto PF = new Conjunto();
        
        AED.insertar(n1.clonar());
        AED.insertar(n2.clonar());
        AED.insertar(n3.clonar());
        AED.insertar(n4.clonar());
        

        
        PF.insertar(n2.clonar());
        PF.insertar(n3.clonar());
        PF.insertar(n4.clonar());  
        PF.insertar(n5.clonar());
        PF.insertar(n6.clonar());
        
        System.out.println("codigo de alumno inscripto en ALGORITMOS Y ESTRUCTURAS DE DATOS");
        AED.imprimir();
        System.out.println("codigo de alumno inscripto en PROGRAMACION FUNCIONAL");
        PF.imprimir();
        
       System.out.println("codigo de todos los alumnos");
       AED.union(PF).imprimir();
       System.out.println("codigo de todos los alumnos que cursan ambas materias");
       AED.Interseccion(PF).imprimir();
        
        
        
        
        
        
        
        
    }
    
}
