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
public class DirectorioEspecialidad extends TArbolBB<Medico> implements IDirectorioEspecialidad {

    @Override
    public LinkedList<Medico> listadoIngresos(int añoDeIngreso) 
    {
            LinkedList<Medico> auxiliar = new LinkedList();
            LinkedList<Medico> medicos = this.inOrden();
            for(Medico med : medicos)
            {
                    if(med.getIngreso() == añoDeIngreso)
                    {
                            auxiliar.add(med);
                    }
            }
            return auxiliar;
    }

   
}
