package UT4.TA5;
import java.util.ArrayList;

/**
 *
 * @author Equipo9
 */
public class Fibonacci 
{
        private int contadorLineal = 0;
        private int contadorBinario = 0;
        private int i,j;
        private ArrayList lista;
        
        public Fibonacci()
        {
                this.i = 0; this.j = 1; this.lista = new ArrayList();
                this.lista.add(0); this.lista.add(1);
        }
        
        public ArrayList fibonacciLineal(int k){
                contadorLineal++;
                if(k >=1)
                {
                 int resultado = i + j; 
                 if(resultado <= k)
                        {
                                this.lista.add(resultado);
                                i = j;
                                j = resultado; 
                                return fibonacciLineal(k);
                        }
                               
                }
                else
                {       
                        System.out.println("No es posible calcular Fibonacci a: " + k + " Ingrese un valor entre 1 --> ++");
                        return null;
                        
                }
                System.out.println(contadorLineal);
                return lista; 
                }
        
        public int fibonacciBinario(int k) 
        {
                contadorBinario++;
                if (k == 0 || k == 1) 
                {
                        System.out.println(contadorBinario);
                        return k;
                }
                else 
                {
                        System.out.println(contadorBinario);
                        return fibonacciBinario(k - 1) + fibonacciBinario(k - 2);
                }
        }
}
