
package elevenCode;

/**
 * Interface de la Clase ElevenCalculador
 * @author Micaela Olivera
 */
public interface IElevenCalculador {
    
    
    public void cargarJugadores(String nombreArchivo);
    
    public void cargarEquipos(String nombreArchivo);
    
    public void cargarPartidos(String nombreArchivo);
    
    public void cargarPartidosCompleto(String nombreArchivo);
    
    public void cargarEventos(String nombreArchivo);
    
    public void imprimirJugadores();
    
    public void imprimirEquipos();
    
    public void imprimirPartidos();
    
    public void imprimirEventos();
    
    public void onceIdeal();
    
    public void masParticipacionPorTemporada (String temporada);
    
    public void nombreLigasDeJugador (String nombreJugador);
    
    public void mejorArqueroPorTemporada(String temporada);
    
    public void delanteroMenosEfectivo(String temporada);
    
    public void equipoGoleador(String temporada);
    
    public void equipoGoleado(String temporada);
    
    
    
    
}
