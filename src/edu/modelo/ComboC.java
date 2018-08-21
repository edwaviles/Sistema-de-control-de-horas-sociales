/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.modelo;

/**
 *
 * @author Roxana
 */
public class ComboC {
     private int idCombo;
     private int idEscuela;
     private String descripcion;

    public ComboC() {
    }

    public ComboC(int idCombo, int idEscuela, String descripcion) {
        this.idCombo = idCombo;
        this.idEscuela = idEscuela;
        this.descripcion = descripcion;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion ;
    }
    
    
}
