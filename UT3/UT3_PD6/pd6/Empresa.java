/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd6;

/**
 *
 * @author Meki
 */
public class Empresa {

    private String nombre;
    private Lista sucursales;

    public Empresa(String nombre) {
        this.nombre = nombre;
        sucursales = new Lista();
    }

    public void cargarInfo(String nombreArchivo) {
        //"src\\pd6\\sucursales.txt"
        String[] listaSucursal = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (int i = 0; i < listaSucursal.length; i++) {
         
            try {
                String[] lineaAProcesar = listaSucursal[i].split("\n");
                Nodo nodo = new Nodo(lineaAProcesar[0].trim(), null);
                if (sucursales.buscar(nodo.getEtiqueta()) == null) {
                    sucursales.insertar(nodo);
                    //nodo.imprimirEtiqueta();
                }

            } catch (Exception e) {
                System.err.println("Sucursal no cargada");
            }
        }

    }

    public void agregarUnaSucursal(Comparable nombreSucu) {
            sucursales.insertar(new Nodo (nombreSucu,null));

    }

    public void quitarSucursal(Comparable nombreSucu) {
        sucursales.eliminar(nombreSucu);
    }

    public void buscarSucursal(String nombreSucu) {
       
        Nodo aux = sucursales.getPrimero();
        while(aux.getSiguiente()!= null){
            if(aux.getEtiqueta().compareTo(nombreSucu)==0){
                System.out.println("Existe la sucursal "+nombreSucu+" ");
                break;
            }
          
            aux = aux.getSiguiente();
            
        }
        
    }

    public void imprimirSucursales() {
        
        Nodo aux = sucursales.getPrimero();
        while(aux.getSiguiente()!= null){
            aux.imprimirEtiqueta();
            aux = aux.getSiguiente();
        }
        
        
    }

    public int cantidadSucursales() {
        return sucursales.cantElementos();
    }

    public boolean sinSucursales() {
        if(sucursales.esVacia()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String imprimirSeparador(String separador){
        return sucursales.imprimir(separador);
    }
}
