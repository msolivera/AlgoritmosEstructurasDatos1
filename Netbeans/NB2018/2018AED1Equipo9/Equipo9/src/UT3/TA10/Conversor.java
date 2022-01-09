/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA10;

/**
 * Clase encargada de convertir char[] a String y vicebersa
 * @author Equipo9
 */
public class Conversor {
        /**
         * Convierte una lista de chars a cadena de caracteres
         * @param lst Lista de chars a ser convertida a string
         * @return Cadena de caracteres con cada char de la lista
         */
        public String charToString(char[] lst)
        {
                String str = String.valueOf(lst);
                return str;
        }
        /**
         * Convierte una cadena de caracteres a lista de chars
         * @param str Cadena a convertir
         * @return Lista de chars con cada caracter de la cadena
         */
        public char[] strintToChar(String str)
        {
                char[] lst = str.toCharArray();
                return lst;
        }
        
}
