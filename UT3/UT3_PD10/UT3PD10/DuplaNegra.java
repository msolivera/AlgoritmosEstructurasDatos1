/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD10;

/**
 *
 * @author Meki
 */
public class DuplaNegra {
    
    private final int sueroId;
    private final int farmacoId;

    
    public DuplaNegra(int idS, int idF) {
        this.farmacoId = idF;
        this.sueroId = idS;
    }

    
    public int getIdFarmaco (){
        return this.farmacoId;
    }
    public int getIdSuero (){
        return this.sueroId;
    }
    
        public void imprimir(){
        System.out.println(" id farmaco "+this.farmacoId+" id suero "+this.sueroId);
    }
    
}
