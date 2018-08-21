
package edu.modelo;

/**
 * Nombre de la clase: Carrera
 * Version: 1.4
 * Fecha: 12/08/18
 * CopyRight: SSE-ITCA
 * @author Roxana Menjivar
 */
public class Carrera {
    private int idCarrera;
    private int idEscuela;
    private String nombre;

    public Carrera() {
    }

    public Carrera(int idCarrera, int idEscuela, String nombre) {
        this.idCarrera = idCarrera;
        this.idEscuela = idEscuela;
        this.nombre = nombre;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
