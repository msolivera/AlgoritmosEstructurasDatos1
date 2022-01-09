package geant;

public class Lista implements ILista {

    private INodo primero;
    
    public Lista(){
        primero = null;
    }
       
    @Override
    public INodo buscar(Comparable clave) {
       if(this.primero.compareTo(clave)>=0){
           return primero;
       }
       else{ 
           INodo aux = primero;
           int comparador;
           while (aux.getSiguiente()!=null){
               comparador = aux.getSiguiente().compareTo(clave);
               if(comparador>=0)
               {
                   return aux;
               }
               aux = aux.getSiguiente();
           }
           return aux;
       }
    }

    @Override
    public void insertar(INodo nodo) {
        if(esVacia()){
            this.primero = nodo;
        }
        else{
            INodo before = buscar(nodo.getEtiqueta());
            if(!before.equals(nodo)){ //para evitar que se coloque un primero y segundo iguales
                if(before.getSiguiente() == null){
                    before.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                else{
                    if(!before.getSiguiente().equals(nodo)){
                        nodo.setSiguiente(before.getSiguiente());
                        before.setSiguiente(nodo);
                    }
                }                   
            }
        }
    }
    
    @Override
    public boolean eliminar(Comparable clave) {
         INodo before = buscar(clave);
         if(this.primero.compareTo(clave) == 0){
             primero = primero.getSiguiente();
             return true;
         }   
         else{     
             if(before.getSiguiente()!=null && before.getSiguiente().compareTo(clave)==0){
               before.setSiguiente(before.getSiguiente().getSiguiente());
               return true;
            }
            return false;
         }
    }
    
    @Override
    public String imprimir() {
        String cadena  = "";
        INodo aux = primero;
        while (aux!=null){
            cadena += aux.getEtiqueta();
            aux = aux.getSiguiente();
        }
        return cadena;
    }

    @Override
    public String imprimir(String separador) {
        String cadena  = "";
        INodo aux = primero;
        while (aux!=null){
            cadena += aux.getEtiqueta() + separador;
            aux = aux.getSiguiente();
       }
       return cadena;
    }

    @Override
    public int cantElementos() {
        INodo aux = primero;
        int sumador = 0;
        while (aux!=null){
            sumador++;
            aux = aux.getSiguiente();
       }
        return sumador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public INodo getPrimero() {
        return this.primero;
    }
}
