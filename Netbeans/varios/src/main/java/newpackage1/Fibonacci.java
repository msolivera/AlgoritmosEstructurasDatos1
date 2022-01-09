package UT4TA5;


public class Fibonacci {
    
    public static long fibonacciBinario(long k){
        long resultado;
        if(k == 0 || k == 1){
            resultado = k;
        }  
        else{
            resultado = fibonacciBinario(k - 1) + fibonacciBinario(k - 2);
        }
        return resultado;
    }
    public static int [] fibonacciLineal(int k)
    {
        int [] result = new int [2];
        if (k == 1)
        {
            result[0]=k;
            result[1]=0;
            return result;
        } else {
            result = fibonacciLineal(k-1);
            int x =result[0];
            result[0]=result[0]+ result[1];
            result[1]= x;
                    
            return result;
        }
        
    }
    
    
}
