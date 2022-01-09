/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_pd7;

/**
 *
 * @author Meki
 */
public class TAlumno {

    private final int cedula;
    private String nombre;
    private final String apellido;

    public TAlumno(int cedula, String nombre, String apellido) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getCedula() {
        return this.cedula;
    }
}
