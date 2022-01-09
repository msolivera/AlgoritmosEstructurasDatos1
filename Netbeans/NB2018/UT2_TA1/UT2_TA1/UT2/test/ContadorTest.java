/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ut2.TA1.ContadorPalabras;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class ContadorTest {
        ContadorPalabras contador = new ContadorPalabras();     //Instanciamos un contador
        String ruta = "src/ut2/TA1/UT2_TA1_ARCHIVO_EJEMPLO.txt";        //Ruta de archivo a trabajar
        /*
        @BeforeClass    //Metodo que se ejecuta antes de iniciar la prueba (UNA VEZ)
        public void beforeC()
        {
                
        }
        
        @AfterClass     //Metodo que se ejecuta después de finalizar la prueba completa (UNA VEZ)
        public static void afterC()
        {
           
        }
        
       @Before  //Este metodo se ejecutara cada vez que se corra un test al iniciar
       public void before()
       {
               
       }
       
       @After
       public void after()      //Este metodo se ejecutara cada vez que se corra un test al finalizar
       {
               
       }
        
        */

        @Test
        public void leerArchivoTest() throws IOException
        {
                
                //ArrayList<String> lineas = contador.obtenerLineas(ruta);
                //int resultado = lineas.size();
                //int esperado = 49;
                //assertEquals(esperado,resultado);
                
        }
        
        public void contarPalabrasTest()
        {
                int resultado = contador.contarPalabras("hola a todos yo tengo siete palabras");
                int esperado = 7;
                assertEquals(esperado,resultado);
        }
        
        public ContadorTest() {
        }
        
        // TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
}
