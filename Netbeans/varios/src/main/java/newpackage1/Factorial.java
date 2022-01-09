
package UT4TA5;

public class Factorial {
    
    public static int factorialIterativo(int n){
        int fact = n;
        while(n>1){
            n = n-1;
            fact = fact * n;
        }
        return fact;
    }
    
    public static int factorialRecursivo(int n){
        if(n==0){
            return 1;
        }
        else{
            return n * factorialRecursivo(n-1);
        }
    }
    
    
}
