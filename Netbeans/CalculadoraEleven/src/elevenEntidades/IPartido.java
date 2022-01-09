/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevenEntidades;

/**
 *
 * @author Meki
 */
public interface IPartido {
  
    
    public void mostrarInfo();

    public String getId();

    public String getFecha();

    public String getTemporada();

    public String getLiga();

    public int getLocal();
    
    public int getVisitante() ;
    
}
