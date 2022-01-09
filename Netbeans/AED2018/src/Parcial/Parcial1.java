package Parcial;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conjunto plantillaHospital = new Conjunto();
        
        Nodo<Medico> nodo1 = new Nodo<>(8, new Medico(8, "Maria", "Cardiologia"));
        Nodo<Medico> nodo2 = new Nodo<>(5, new Medico(5, "Valentina", "Cirugia"));
        Nodo<Medico> nodo3 = new Nodo<>(3, new Medico(3, "Jose", "Pediatria"));
        Nodo<Medico> nodo4 = new Nodo<>(6, new Medico(6, "Ana", "Cirugia"));
        Nodo<Medico> nodo5 = new Nodo<>(4, new Medico(4, "Florencia", "Pediatria"));
        Nodo<Medico> nodo6 = new Nodo<>(2, new Medico(2, "Juan", "Cardiologia"));
        Nodo<Medico> nodo7 = new Nodo<>(1, new Medico(1, "Pedro", "Cirugia"));
        Nodo<Medico> nodo8 = new Nodo<>(7, new Medico(7, "Martin", "Pediatria"));

        
        plantillaHospital.insertar(nodo1);
        plantillaHospital.insertar(nodo2);
        plantillaHospital.insertar(nodo3);
        plantillaHospital.insertar(nodo4);
        plantillaHospital.insertar(nodo5);
        plantillaHospital.insertar(nodo6);
        plantillaHospital.insertar(nodo7);
        plantillaHospital.insertar(nodo8); 
        System.out.println(plantillaHospital.imprimir());    
      
       
         
        /**
         * Crear los médicos y cargarlos en la planilla del hospital a partir
         * del archivo "medicos.txt” Cada línea tiene cédula, nombre y
         * especialidad del médico
         */
        Conjunto medicosGeriatras = new Conjunto();
        String[] lineasMedicos = ManejadorArchivosGenerico.leerArchivo("src//Parcial//medicos.txt");
        Medico medico;
        for (String l : lineasMedicos) {
            String[] datos = l.split(",");
            medico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2]);
            Nodo<Medico> nuevoNodo = new Nodo<>(medico.getCedula(), medico);
            plantillaHospital.insertar(nuevoNodo);
            if (medico.getEspecialidad().equals("Geriatria")) {  // si es geriatra lo sumamos a la lista de geriatras
                  Nodo<Medico> nuevoNodoEsp = new Nodo<>(medico.getCedula(), medico);
            
                medicosGeriatras.insertar(nuevoNodoEsp);
            }
        }
        System.out.println("Medicos en el hospital: " + plantillaHospital.cantElementos());
        System.out.println("Medicos Geriatras: " + medicosGeriatras.cantElementos());

        
        Conjunto medicosNoGeriatras = medicosGeriatras.complemento(plantillaHospital);
        System.out.println("Total de Medicos No Geriatras: " + medicosNoGeriatras.cantElementos());
        
     }

}
