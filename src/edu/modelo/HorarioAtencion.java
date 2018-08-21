
package edu.modelo;

/**
 * Nombre de la clase: HorarioAtencion
 * Version: 1.2
 * Fecha: 05/08/18
 * CopyRight: SSE-ITCA
 * @author Roxana Menjivar
 */
public class HorarioAtencion {
    private int idHorarioA;
    private int idCoordinador;
    private String dia;
    private String horaDesde;
    private String horaHasta;
    private String lugar;

    public HorarioAtencion() {
    }

    public HorarioAtencion(int idHorarioA, int idCoordinador, String dia, String horaDesde, String horaHasta, String lugar) {
        this.idHorarioA = idHorarioA;
        this.idCoordinador = idCoordinador;
        this.dia = dia;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.lugar = lugar;
    }

    public int getIdHorarioA() {
        return idHorarioA;
    }

    public void setIdHorarioA(int idHorarioA) {
        this.idHorarioA = idHorarioA;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }  
}
