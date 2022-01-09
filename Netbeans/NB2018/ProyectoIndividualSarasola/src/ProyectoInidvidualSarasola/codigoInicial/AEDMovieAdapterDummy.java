/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoInidvidualSarasola.codigoInicial;

/**
 *
 * @author Josse
 */
public class AEDMovieAdapterDummy implements IAEDMovieAdapter{
    private Pelicula[] peliculas;
    private Actor[] actores;
    private PeliculasActores[] peliculasActores;
        
    @Override
    public void cargarDatos() {
        String [] listaActores = ManejadorArchivosGenerico.leerArchivo("src/ProyectoInidvidualSarasola/archivos/Actores.csv", false);
        actores = new Actor[listaActores.length];
        int contador = 0;
        for(String lineaLeida : listaActores){
            String [] lineaAProcesar = lineaLeida.split(",");
            Actor actor = new Actor(Integer.parseInt(lineaAProcesar[0]), lineaAProcesar[1]);
            actores[contador]= actor;
            contador ++;            
        }
        String [] listaPeliculas = ManejadorArchivosGenerico.leerArchivo("src/ProyectoInidvidualSarasola/archivos/Peliculas.csv", false);
        peliculas = new Pelicula[listaPeliculas.length];
        int contador1 = 0;
        for(String lineaLeida : listaPeliculas){
            String [] lineaAProcesar = lineaLeida.split(",");
            Pelicula pelicula = new Pelicula(Integer.parseInt(lineaAProcesar[0]), lineaAProcesar[1],2016);
            peliculas[contador1]= pelicula;
            contador1 ++;            
        }
        String [] listaPeliculasActores = ManejadorArchivosGenerico.leerArchivo("src/ProyectoInidvidualSarasola/archivos/PeliculasActores.csv", false);
        peliculasActores = new PeliculasActores[listaPeliculasActores.length];
        int contador2 = 0;
        for(String lineaLeida : listaPeliculasActores){
            String [] lineaAProcesar = lineaLeida.split(",");
            PeliculasActores peliculasActores = new PeliculasActores(Integer.parseInt(lineaAProcesar[0]), Integer.parseInt(lineaAProcesar[1]));
            this.peliculasActores[contador2]= peliculasActores;
            contador2 ++;            
        }
        
    }

    @Override
    public Pelicula [] obtenerPeliculas() {
        return peliculas;
    }

    @Override
    public Actor[] obtenerActores() {
           return actores;
    }

    @Override
    public PeliculasActores[] obtenerPeliculasActores() {
        return peliculasActores;
    }
    
    @Override
    public String getInfoPelicula(String nombrePelicula){
        String infoPelicula = "";
        String actores = "";
        for(Pelicula pelicula : peliculas){
            if (pelicula.getNombre() == nombrePelicula){                
                infoPelicula = "Nombre: " + pelicula.getNombre()+  "\nId Película: "+ pelicula.getID() + 
                                         "\nAño: " + pelicula.getAnio();
                for(PeliculasActores peliActores : peliculasActores){
                    
                    if(pelicula.getID() == peliActores.getIdPelicula())
                        actores += getNombreActor(""+peliActores.getIdActor()) + "\n\t";
                }
                infoPelicula += "\nActores> \n\t" + actores;
            }
        }
        return infoPelicula;
    }
    
    @Override
    public String getNombreActor(String idActor) {
        String nombreActor = "";
        for (Actor actor : actores){
            if (actor.getID() == Integer.parseInt(idActor)){
                nombreActor = actor.getNombre();
            }
        }
        return nombreActor;
    }
}
