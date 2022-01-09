/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigo;


import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Clase que implementa la Interface IGestorDeContenidos, conteniendo una serie
 * de listas enlazadadas que contienen objetos Pelicula, Actor, Director,
 * Productor y objetos que asocian información de los nombrados con
 * anterioridad, así como métodos para accedar a toda la información contenida
 * en las mismas.
 * 
 * @author DANIEL
 */
public class GestorDeContenidosUCUMovie implements IGestorDeContenidos {
    
    private ILista <Pelicula> peliculas;
    private ILista<Actor> actores;
    private ILista<Director> directores;
    private ILista<Productor> productores;
    private ILista<AsociadorIDPeliculaIDActor> peliculasActores;
    private ILista<AsociadorIDPeliculaIDDirector> peliculasDirectores;
    private ILista<AsociadorIDPeliculaIDProductor> peliculasProductores;
    private ILista<Imagen> imagenes;
    private int anioPeliculaMasAntigua;

    /**
     *
     */
    public GestorDeContenidosUCUMovie() {
        this.peliculas = new Lista<>();
        this.actores = new Lista<>();
        this.directores = new Lista<>();
        this.productores = new Lista<>();
        this.peliculasActores = new Lista<>();
        this.peliculasDirectores = new Lista<>();
        this.peliculasProductores = new Lista<>();
        this.imagenes= new Lista<>();
        //Obtengo el año actual del sistema.
        Calendar calendario = Calendar.getInstance();        
        int anioActual = calendario.get(Calendar.YEAR);
        this.anioPeliculaMasAntigua = anioActual;
    }
    
    @Override
    public ILista<Pelicula> obtenerPeliculas() {
        return this.peliculas;
    }

    @Override
    public ILista<Actor> obtenerActores() {
        return this.actores;
    }

    @Override
    public ILista<Director> obtenerDirectores() {
        return this.directores;
    }

    @Override
    public ILista<Productor> obtenerProductores() {
        return this.productores;
    }

    @Override
    public ILista<AsociadorIDPeliculaIDActor> obtenerPeliculasActores(){
        return this.peliculasActores;
    }

    @Override
    public ILista<AsociadorIDPeliculaIDDirector> obtenerPeliculasDirectores(){
        return this.peliculasDirectores;
    }

    @Override
    public ILista<AsociadorIDPeliculaIDProductor> obtenerPeliculasProductores(){
        return this.peliculasProductores;
    }
    
    @Override
    public ILista<Imagen> obtenerImagenes(){
        return this.imagenes;
    }
    
    @Override
    public int obtenerAnioPeliculaMasAntigua(){
        return this.anioPeliculaMasAntigua;
    }
    

    @Override
    public void cargarDatos(String archivoPeliculas,String archivoActores, 
            String archivoDirectores,String archivoProductores, 
            String archivoPeliculasActores, String archivoPeliculasDirectores, 
            String archivoPeliculasProductores, String archivoImagenes) {
       
        String [] listaPeliculas = ManejadorArchivosGenerico.leerArchivo
                                                      (archivoPeliculas, false);        
        for(String lineaLeida : listaPeliculas){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                Pelicula pelicula = new Pelicula
                        (Integer.parseInt(lineaAProcesar[0].trim()), 
                            lineaAProcesar[1].trim(),
                                Integer.parseInt(lineaAProcesar[2].trim()),
                                Double.parseDouble(lineaAProcesar[3].trim()),
                                    lineaAProcesar[4].trim(), 
                                        lineaAProcesar[5].trim());
                /*Se crea un nuevo nodo, cuya carga es la Pelicula antes 
                 *instanciada.                
                */
                INodo<Pelicula> nuevoNodo;
                nuevoNodo = new Nodo<>(pelicula, pelicula.getID());
                /*Se chequea que la película no haya sido ingresada con 
                 *anterioridad.                
                */
                INodo<Pelicula> buscarNuevoNodo;
                buscarNuevoNodo = peliculas.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.*/
                if(buscarNuevoNodo == null){
                    peliculas.insertarOrdenadoInverso(nuevoNodo);
                    if(nuevoNodo.getDato().getAnio()<= anioPeliculaMasAntigua){
                        anioPeliculaMasAntigua = nuevoNodo.getDato().getAnio();
                    }
                }   
            }catch(Exception e){
                System.err.println("Pelicula no cargada");
            }                                          
        }
        
        String [] listaActores = ManejadorArchivosGenerico.leerArchivo
                                                        (archivoActores, false);        
        for(String lineaLeida : listaActores){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                Actor actor = new Actor
                                (Integer.parseInt(lineaAProcesar[0].trim()), 
                                                    lineaAProcesar[1].trim());
                /*Se crea un nuevo nodo, cuya carga es el Actor antes 
                 *instanciado.
                */
                INodo<Actor> nuevoNodo;
                nuevoNodo = new Nodo<>(actor, actor.getID());
                /*Se chequea que el actor no haya sido ingresado con 
                 *anterioridad.
                */
                INodo<Actor> buscarNuevoNodo;
                buscarNuevoNodo = actores.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.
                */
                if(buscarNuevoNodo == null){
                    actores.insertar(nuevoNodo);
                }                
            }catch(Exception e){
                System.err.println("Actor no cargado");
            }
                               
        }
       
        String [] listaDirectores = ManejadorArchivosGenerico.leerArchivo
                                                    (archivoDirectores, false);        
        for(String lineaLeida : listaDirectores){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                Director director = new Director
                                    (Integer.parseInt(lineaAProcesar[0].trim()),
                                                      lineaAProcesar[1].trim());
                /*Se crea un nuevo nodo, cuya carga es el Director antes 
                 * instanciado.
                */
                INodo<Director> nuevoNodo;
                nuevoNodo = new Nodo<>(director, director.getID());
                /*Se chequea que el director no haya sido ingresado con 
                 *anterioridad.
                */
                INodo<Director> buscarNuevoNodo;
                buscarNuevoNodo = directores.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.
                */
                if(buscarNuevoNodo == null){
                    directores.insertar(nuevoNodo);
                }                
            }catch(Exception e){
                System.err.println("Director no cargado");
            }
                                             
        }
        
        String [] listaProductores = ManejadorArchivosGenerico.leerArchivo
                                                    (archivoProductores, false);        
        for(String lineaLeida : listaProductores){
            try{                
                String [] lineaAProcesar = lineaLeida.split("\\|");
                Productor productor = new Productor
                                    (Integer.parseInt(lineaAProcesar[0].trim()), 
                                                      lineaAProcesar[1].trim());
                /*Se crea un nuevo nodo, cuya carga es el Productor antes 
                 *instanciado.
                */
                INodo<Productor> nuevoNodo;
                nuevoNodo = new Nodo<>(productor, productor.getID());
                /*Se chequea que el Productor no haya sido ingresado con 
                 * anterioridad.
                */
                INodo<Productor> buscarNuevoNodo;
                buscarNuevoNodo = productores.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.
                */
                if(buscarNuevoNodo == null){
                    productores.insertar(nuevoNodo);
                }                
            }catch(Exception e){
                System.err.println("Productor no cargado");
            }
                                         
        }
       
        String [] listaPeliculasActores = ManejadorArchivosGenerico.leerArchivo
                                                (archivoPeliculasActores,false);        
        for(String lineaLeida : listaPeliculasActores){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                AsociadorIDPeliculaIDActor<Actor> peliculaActor;
                peliculaActor = new AsociadorIDPeliculaIDActor<>
                             (Integer.parseInt(lineaAProcesar[0].trim()), 
                                    Integer.parseInt(lineaAProcesar[1].trim()));
                /*Se crea un nuevo nodo, como para una película pueden haber 
                 *varios Actores, no se chequea si el IDPelícula ya fué 
                 *ingresado.
                */
                INodo<AsociadorIDPeliculaIDActor> nuevoNodo;
                nuevoNodo = new Nodo<>(peliculaActor, 
                                            peliculaActor.getIDPelicula());
                /*Se inserta el nodo en la lista.
                */
                peliculasActores.insertar(nuevoNodo);                
            }catch(Exception e){
                System.err.println("AsociadorIDPeliculaIDActor no cargado");
            }
                                  
        }       
        
        String [] listaPeliculasDirectores;        
        listaPeliculasDirectores = ManejadorArchivosGenerico.leerArchivo
                                             (archivoPeliculasDirectores,false);
        for(String lineaLeida : listaPeliculasDirectores){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                AsociadorIDPeliculaIDDirector<Director> peliculaDirector;
                peliculaDirector = new AsociadorIDPeliculaIDDirector<>
                           (Integer.parseInt(lineaAProcesar[0].trim()), 
                                    Integer.parseInt(lineaAProcesar[1].trim()));
                /*Se crea un nuevo nodo, como para una película pueden haber 
                 *varios Directores, no se chequea si el IDPelícula ya fué 
                 *ingresado.
                */
                INodo<AsociadorIDPeliculaIDDirector> nuevoNodo;
                nuevoNodo = new Nodo<>(peliculaDirector, 
                                            peliculaDirector.getIDPelicula());
                /*Se inserta el nodo en la lista.
                */
                peliculasDirectores.insertar(nuevoNodo);                
            }catch(Exception e){
                System.err.println("AsociadorIDPeliculaIDDirector no cargado");
            }
                                   
        }
        
        String [] listaPeliculasProductores;        
        listaPeliculasProductores = ManejadorArchivosGenerico.leerArchivo
                                            (archivoPeliculasProductores,false);
        for(String lineaLeida : listaPeliculasProductores){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                AsociadorIDPeliculaIDProductor<Productor> peliculaProductor;
                peliculaProductor = new AsociadorIDPeliculaIDProductor<>
                              (Integer.parseInt(lineaAProcesar[0].trim()), 
                                    Integer.parseInt(lineaAProcesar[1].trim()));
                /*Se crea un nuevo nodo, como para una película pueden haber
                 *varios Productores, no se chequea si el IDPelícula ya fué 
                 *ingresado.
                */
                INodo<AsociadorIDPeliculaIDProductor> nuevoNodo;
                nuevoNodo = new Nodo<>(peliculaProductor, 
                                            peliculaProductor.getIDPelicula());
                /*Se inserta el nodo en la lista.
                */
                peliculasProductores.insertar(nuevoNodo);                
            }catch(Exception e){
                System.err.println("AsociadorIDPeliculaIDProductor no cargado");
            }
                                   
        }
        
        String [] listaImagenes;        
        listaImagenes = ManejadorArchivosGenerico.leerArchivo
                                                       (archivoImagenes, false);
        for(String lineaLeida : listaImagenes){
            try{
                String [] lineaAProcesar = lineaLeida.split("\\|");
                Imagen imagen = new Imagen
                                (Integer.parseInt(lineaAProcesar[0].trim()), 
                                                    lineaAProcesar[1].trim());            
                /* //Se crea un nuevo nodo, cuya carga es la Imagen antes 
                 *instanciada.
                */
                INodo<Imagen> nuevoNodo;
                nuevoNodo = new Nodo<>(imagen, imagen.getID());
                /*Se chequea que la imagen no haya sido ingresada con 
                 *anterioridad.
                */
                INodo<Imagen> buscarNuevoNodo;
                buscarNuevoNodo = imagenes.buscar(nuevoNodo.getEtiqueta());
                /*Se inserta el nodo en la lista.
                */
                if(buscarNuevoNodo == null){
                    imagenes.insertar(nuevoNodo);                
                }                
            }catch(Exception e){
                System.err.println("Imagen no cargada");
            }
            
        }
         
         
    }
    @Override
    public String infoPelicula(String nombrePelicula) {
        
        String infoPelicula = "";
        String actoresResultado = "";
        String directoresResultado = "";
        String productoresResultado = "";        
        
        INodo<Pelicula> auxiliarPelicula = peliculas.getPrimero();
        while(auxiliarPelicula != null){
            if(auxiliarPelicula.getDato().getNombre().equals(nombrePelicula)){
                infoPelicula = "Nombre: " + 
                        auxiliarPelicula.getDato().getNombre()+"\nPuntuación: "+
                        auxiliarPelicula.getDato().getPuntaje() +  
                        "\nId Película: "+ auxiliarPelicula.getDato().getID() + 
                        "\nAño: " + auxiliarPelicula.getDato().getAnio()+ 
                        "\nGénero: " + auxiliarPelicula.getDato().getGenero() + 
                        "\nReseña: " + auxiliarPelicula.getDato().getResenia();
                
                INodo<AsociadorIDPeliculaIDActor> auxIDPeliculaIDActor;
                auxIDPeliculaIDActor = peliculasActores.getPrimero();
                while(auxIDPeliculaIDActor != null){                    
                    if(auxiliarPelicula.getEtiqueta().
                            compareTo(auxIDPeliculaIDActor.getEtiqueta()) == 0){
                        
                        String actorAIncluir;
                        actorAIncluir = auxIDPeliculaIDActor.getDato().
                                                             getID().toString();
                        actoresResultado += nombreActor(actorAIncluir) + "\n\t";                        
                    }
                    auxIDPeliculaIDActor = auxIDPeliculaIDActor.getSiguiente();                    
                }
                infoPelicula += "\nElenco> \n\t" + actoresResultado;
                
                INodo<AsociadorIDPeliculaIDDirector> auxIDPeliculaIDDirector;
                auxIDPeliculaIDDirector = peliculasDirectores.getPrimero();
                while(auxIDPeliculaIDDirector != null){                    
                    if(auxiliarPelicula.getEtiqueta().
                         compareTo(auxIDPeliculaIDDirector.getEtiqueta()) == 0){
                        
                        String directorAIncluir;
                        directorAIncluir = auxIDPeliculaIDDirector.getDato().
                                                             getID().toString();
                        directoresResultado += nombreDirector(directorAIncluir) 
                                                                       + "\n\t";                        
                    }
                    auxIDPeliculaIDDirector = auxIDPeliculaIDDirector.
                                                                 getSiguiente();                    
                }
                infoPelicula += "\nDirector> \n\t" + directoresResultado;      
                
                INodo<AsociadorIDPeliculaIDProductor> auxIDPeliculaIDProductor;
                auxIDPeliculaIDProductor = peliculasProductores.getPrimero();
                while(auxIDPeliculaIDProductor != null){                    
                    if(auxiliarPelicula.getEtiqueta().compareTo
                                 (auxIDPeliculaIDProductor.getEtiqueta()) == 0){
                        
                        String productorAIncluir = auxIDPeliculaIDProductor.
                                                   getDato().getID().toString();
                        productoresResultado += nombreProductor
                                                    (productorAIncluir)+ "\n\t";                        
                    }
                    auxIDPeliculaIDProductor = auxIDPeliculaIDProductor.
                                                                 getSiguiente();                    
                }
                infoPelicula += "\nProductores> \n\t" + productoresResultado;               
            }
            auxiliarPelicula = auxiliarPelicula.getSiguiente();
        }
        return infoPelicula;
        
    }
    
    @Override
    public String imagenPelicula(String nombrePelicula){
        String aRetornar  = "";
        INodo<Imagen> resultado = null;
        Comparable aEncontrar = null;
        
        INodo<Pelicula> auxiliarPelicula = peliculas.getPrimero();
        while(auxiliarPelicula != null){
            if(auxiliarPelicula.getDato().getNombre().equals(nombrePelicula)){
                aEncontrar = auxiliarPelicula.getEtiqueta();
                break;
            }
            auxiliarPelicula = auxiliarPelicula.getSiguiente();
        }
        INodo<Imagen> auxiliarImagen = imagenes.getPrimero();
        while(auxiliarImagen != null){
            if(auxiliarImagen.getEtiqueta().compareTo(aEncontrar) == 0){
                resultado = auxiliarImagen;
                break;
            }
            auxiliarImagen = auxiliarImagen.getSiguiente();
        }
        if (resultado != null){
            
            ImageUtils imagenAArchivo = new ImageUtils();
            String aProcesar = resultado.getDato().getContenido();
            byte [] imagenAPresentar;               
            imagenAPresentar = imagenAArchivo.hexStringToBytes(aProcesar);
            try {
                imagenAArchivo.bytesToImage(imagenAPresentar, 
                                 resultado.getDato().getID().toString(), "png");
            } catch (IOException ex) {
                Logger.getLogger(GestorDeContenidosUCUMovie.class.getName()).
                                                    log(Level.SEVERE, null, ex);
            }                            
            /*Para cargar la imagenAArchivo
            */
            aRetornar = "src/ProyectoInidvidualSarasola/ArchivoImagenes/"+ 
                                    ("" + resultado.getDato().getID()) + ".png";                   
        }
        return aRetornar;       
    }

    @Override
    public String nombreActor(String idActor) {
        String nombreActor = "";
        INodo<Actor> auxiliarActor = actores.getPrimero();
        while(auxiliarActor != null){
            if (auxiliarActor.getDato().getID().
                                     compareTo(Integer.parseInt(idActor)) == 0){
                
                nombreActor = auxiliarActor.getDato().getNombre();
            }
            auxiliarActor = auxiliarActor.getSiguiente();
        }
        return nombreActor;
    }

    @Override
    public String nombreDirector(String idDirector) {
        String nombreDirector = "";
        INodo<Director> auxiliarDirector = directores.getPrimero();
        while(auxiliarDirector != null){
            if (auxiliarDirector.getDato().getID().
                                  compareTo(Integer.parseInt(idDirector)) == 0){
                
                nombreDirector = auxiliarDirector.getDato().getNombre();
            }
            auxiliarDirector = auxiliarDirector.getSiguiente();
        }
        return nombreDirector;
    }

    @Override
    public String nombreProductor(String idProductor) {
        String nombreProductor = "";
        INodo<Productor> auxiliarProductor = productores.getPrimero();
        while(auxiliarProductor != null){
            if (auxiliarProductor.getDato().getID().
                                 compareTo(Integer.parseInt(idProductor)) == 0){
                
                nombreProductor = auxiliarProductor.getDato().getNombre();
            }
            auxiliarProductor = auxiliarProductor.getSiguiente();
        }
        return nombreProductor;
    }
    
    @Override
    public Lista<String> generosEnListaPeliculas(){
        Lista<String> resultado = new Lista<>();
        INodo<Pelicula> auxPelicula = peliculas.getPrimero();
            while (auxPelicula != null){
                String [] generosEnPeliculas;
                generosEnPeliculas = auxPelicula.getDato().getGenero().
                                                                   split("\\-");
                for(String lineaAProcesar : generosEnPeliculas){
                    Comparable aComparar = lineaAProcesar;
                    if(resultado.buscar(aComparar) == null){
                        INodo<String> aInsertar;
                        aInsertar = new Nodo<>(lineaAProcesar, lineaAProcesar);
                        resultado.insertar(aInsertar);                       
                    }
                }                
                auxPelicula = auxPelicula.getSiguiente();
            }
        return resultado;        
    }
    
    @Override
    public Lista<Pelicula> peliculasDeDirector(String nombreDirector){
        Lista<Pelicula> resultado = new Lista<>();
        
        Comparable IdDirector = null;
        INodo<Director> auxiliarDirector = directores.getPrimero();
        while (auxiliarDirector != null){
            if (auxiliarDirector.getDato().getNombre().equals(nombreDirector)){
                IdDirector = auxiliarDirector.getDato().getID();
                break;
            }
            auxiliarDirector = auxiliarDirector.getSiguiente();
        }       
        INodo<AsociadorIDPeliculaIDDirector> auxPeliDirector;
        auxPeliDirector = peliculasDirectores.getPrimero();
        while (auxPeliDirector != null){
            if (auxPeliDirector.getDato().getID().compareTo(IdDirector) == 0){
                
                INodo<Pelicula> auxPelicula = peliculas.getPrimero();
                while (auxPelicula != null){
                    if (auxPeliDirector.getDato().getIDPelicula().
                                compareTo(auxPelicula.getDato().getID()) == 0){
                        INodo<Pelicula> aInsertar;
                        aInsertar = new Nodo<>(auxPelicula.getDato(), 
                                                    auxPelicula.getEtiqueta());
                        resultado.insertar(aInsertar);                        
                    }
                    auxPelicula = auxPelicula.getSiguiente();
                }
                
            }                       
            auxPeliDirector= auxPeliDirector.getSiguiente();
        }
        return resultado;        
    }
    
    @Override
    public Lista<Pelicula> peliculasDeActor(String nombreActor){
        Lista<Pelicula> resultado = new Lista<>();
        
        Comparable IdActor = null;
        INodo<Actor> auxiliarActor = actores.getPrimero();
        while (auxiliarActor != null){
            if (auxiliarActor.getDato().getNombre().equals(nombreActor)){
                IdActor = auxiliarActor.getDato().getID();
                break;
            }
            auxiliarActor = auxiliarActor.getSiguiente();
        }       
        INodo<AsociadorIDPeliculaIDActor> auxPeliActor;
        auxPeliActor = peliculasActores.getPrimero();
        while (auxPeliActor != null){
            if (auxPeliActor.getDato().getID().compareTo(IdActor) == 0){
                
                INodo<Pelicula> auxPelicula = peliculas.getPrimero();
                while (auxPelicula != null){
                    if (auxPeliActor.getDato().getIDPelicula().
                                 compareTo(auxPelicula.getDato().getID()) == 0){
                        
                        INodo<Pelicula> aInsertar;
                        aInsertar = new Nodo<>(auxPelicula.getDato(), 
                                                     auxPelicula.getEtiqueta());
                        resultado.insertar(aInsertar);                        
                    }
                    auxPelicula = auxPelicula.getSiguiente();
                }                
            }                       
            auxPeliActor= auxPeliActor.getSiguiente();
        }
        return resultado;        
    }   
    
    @Override
    public Lista<Pelicula> peliculasPorAnio (int anioInferior,int anioSuperior){
        Lista<Pelicula> resultado = new Lista<>();
        INodo<Pelicula> auxPelicula = peliculas.getPrimero();
            while (auxPelicula != null){
                if (anioInferior <= auxPelicula.getDato().getAnio() && 
                                auxPelicula.getDato().getAnio()<= anioSuperior){
                    
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxPelicula.getDato(), 
                                                     auxPelicula.getEtiqueta());
                    resultado.insertar(aInsertar);                        
                }
                auxPelicula = auxPelicula.getSiguiente();
            }
        return resultado;        
    }
    
    @Override
    public Lista<Pelicula> peliculasPorPuntaje (double puntajeInferior, 
                                                        double puntajeSuperior){
        Lista<Pelicula> resultado = new Lista<>();
        INodo<Pelicula> auxPelicula = peliculas.getPrimero();
            while (auxPelicula != null){
                if (puntajeInferior <= auxPelicula.getDato().getPuntaje() && 
                          auxPelicula.getDato().getPuntaje()<= puntajeSuperior){
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxPelicula.getDato(), 
                                                     auxPelicula.getEtiqueta());
                    resultado.insertar(aInsertar);                        
                }
                auxPelicula = auxPelicula.getSiguiente();
            }
        return resultado;        
    }
    
    @Override
    public Lista<Pelicula> peliculasPorGenero (String genero){
        Lista<Pelicula> resultado = new Lista<>();
        INodo<Pelicula> auxPelicula = peliculas.getPrimero();
            while (auxPelicula != null){
                if (auxPelicula.getDato().getGenero().contains(genero)){
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxPelicula.getDato(), 
                                                     auxPelicula.getEtiqueta());
                    resultado.insertar(aInsertar);                        
                }
                auxPelicula = auxPelicula.getSiguiente();
            }
        return resultado;        
    }
    
    @Override
    public Lista<Pelicula> peliculasPorTodosLosFiltros (String nombreDirector, 
            String nombreActor,int anioInferior, int anioSuperior, 
                 double puntajeInferior, double puntajeSuperior, String genero){
        
        Lista<Pelicula> resultado = new Lista<>();
        Lista<Pelicula> resultadoDirector = peliculasDeDirector(nombreDirector);
        Lista<Pelicula> resultadoActor = peliculasDeActor(nombreActor);
        Lista<Pelicula> resultadoPorAnio;
        resultadoPorAnio = peliculasPorAnio(anioInferior, anioSuperior);
        Lista<Pelicula> resultadoPorPuntaje;
        resultadoPorPuntaje = peliculasPorPuntaje(puntajeInferior, 
                                                               puntajeSuperior);
        Lista<Pelicula> resultadoGenero = peliculasPorGenero(genero);
        
        INodo<Pelicula>auxiliarPeliDirector = resultadoDirector.getPrimero();
        while(auxiliarPeliDirector!= null){
            INodo<Pelicula>auxiliarPeliActor = resultadoActor.getPrimero();
            while(auxiliarPeliActor!= null){
                if (auxiliarPeliDirector.getEtiqueta().
                               compareTo(auxiliarPeliActor.getEtiqueta()) == 0){
                    
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxiliarPeliActor.getDato(),
                                               auxiliarPeliActor.getEtiqueta());
                    INodo<Pelicula> buscarAInsertar;                    
                    buscarAInsertar = resultado.buscar(aInsertar.getEtiqueta());
                    if(buscarAInsertar == null){
                        resultado.insertar(aInsertar);
                    }                   
                }
                auxiliarPeliActor = auxiliarPeliActor.getSiguiente();
            }
            auxiliarPeliDirector = auxiliarPeliDirector.getSiguiente();
        }
        Lista<Pelicula> resultado1 = new Lista<>();
        INodo<Pelicula> auxiliarResultado = resultado.getPrimero();
        while(auxiliarResultado!= null){
            INodo<Pelicula>auxiliarPeliPorAnio = resultadoPorAnio.getPrimero();
            while(auxiliarPeliPorAnio!= null){
                if (auxiliarResultado.getEtiqueta().
                             compareTo(auxiliarPeliPorAnio.getEtiqueta()) == 0){
                    
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxiliarResultado.getDato(),
                                               auxiliarResultado.getEtiqueta());
                    INodo<Pelicula> buscarAInsertar;                    
                    buscarAInsertar = resultado1.
                                                buscar(aInsertar.getEtiqueta());
                    if(buscarAInsertar == null){
                        resultado1.insertar(aInsertar);
                    }                   
                }
                auxiliarPeliPorAnio = auxiliarPeliPorAnio.getSiguiente();
            }
            auxiliarResultado = auxiliarResultado.getSiguiente();
        }
        
        Lista<Pelicula> resultado2 = new Lista<>();
        INodo<Pelicula> auxiliarResultado1 = resultado1.getPrimero();
        while(auxiliarResultado1!= null){
            INodo<Pelicula>auxiliarPeliPorPuntaje;
            auxiliarPeliPorPuntaje = resultadoPorPuntaje.getPrimero();
            while(auxiliarPeliPorPuntaje!= null){
                if (auxiliarResultado1.getEtiqueta().
                          compareTo(auxiliarPeliPorPuntaje.getEtiqueta()) == 0){
                    
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxiliarResultado1.getDato(), 
                                              auxiliarResultado1.getEtiqueta());
                    INodo<Pelicula> buscarAInsertar;                    
                    buscarAInsertar = resultado2.
                                                buscar(aInsertar.getEtiqueta());
                    if(buscarAInsertar == null){
                        resultado2.insertar(aInsertar);
                    }                   
                }
                auxiliarPeliPorPuntaje = auxiliarPeliPorPuntaje.getSiguiente();
            }
            auxiliarResultado1 = auxiliarResultado1.getSiguiente();
        }
        
        Lista<Pelicula> resultado3 = new Lista<>();
        INodo<Pelicula> auxiliarResultado2 = resultado2.getPrimero();
        while(auxiliarResultado2!= null){
            INodo<Pelicula>auxiliarPeliPorGenero = resultadoGenero.getPrimero();
            while(auxiliarPeliPorGenero!= null){
                if (auxiliarResultado2.getEtiqueta().
                           compareTo(auxiliarPeliPorGenero.getEtiqueta()) == 0){                    
                    INodo<Pelicula> aInsertar;
                    aInsertar = new Nodo<>(auxiliarResultado2.getDato(), 
                                              auxiliarResultado2.getEtiqueta());
                    INodo<Pelicula> buscarAInsertar;                    
                    buscarAInsertar = resultado3.
                                                buscar(aInsertar.getEtiqueta());
                    if(buscarAInsertar == null){
                        resultado3.insertar(aInsertar);
                    }                   
                }
                auxiliarPeliPorGenero = auxiliarPeliPorGenero.getSiguiente();
            }
            auxiliarResultado2 = auxiliarResultado2.getSiguiente();
        }
        return resultado3;
    }    
}
