/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA5;

/**
 *
 * @author nicolasgonzalezmartinez
 */
public class Factorial 
{
        public static int factorial(int n)
        {
                if (n == 0) 
                {
                        return 1;
                }
                else if (n < 0) 
                {
                        return -1;
                } 
                else 
                {
                        return n * factorial(n - 1);
                }
        }

        public static int factorialIterativo(int n) 
        {
                int fact = n;
                while (n > 1) 
                {
                        n = n - 1;
                        fact = fact * n;

                }
                return fact;
        }
}
