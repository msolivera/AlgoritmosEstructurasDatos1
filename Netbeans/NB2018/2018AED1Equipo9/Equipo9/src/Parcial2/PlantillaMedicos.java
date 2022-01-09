package Parcial2;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos 
{

    @Override
    public DirectorioEspecialidad obtenerDirectorio(String laEspecialidad) 
    {
           DirectorioEspecialidad medicos = new DirectorioEspecialidad();  
           LinkedList<Medico> lista = this.inOrden();
           for(Medico med : lista)
           {
                   if(med.getEspecialidad() == laEspecialidad)
                   {
                           TElementoAB elem = new TElementoAB(med.getNombre(), med);
                           medicos.insertar(elem);
                   }
           }
           return medicos;
    }

  
  
}
