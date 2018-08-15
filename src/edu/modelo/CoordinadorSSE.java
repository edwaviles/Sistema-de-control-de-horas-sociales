
package edu.modelo;

/**
 * Nombre de la clase: CoordinadorSSE
 * Version: 1.1
 * Fecha: 05/08/18
 * CopyRight: SSE-ITCA
 * @author Roxana Menjivar
 */
public class CoordinadorSSE {
    private int idCoordinador;
    private String nombre;
    private String correo;
    private int idEscuela;

    public CoordinadorSSE() {
    }

    public CoordinadorSSE(int idCoordinador, String nombre, String correo, int idEscuela) {
        this.idCoordinador = idCoordinador;
        this.nombre = nombre;
        this.correo = correo;
        this.idEscuela = idEscuela;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }      
}
