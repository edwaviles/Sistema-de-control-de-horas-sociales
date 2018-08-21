/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.modelo;

/**
 *
 * @author Ernesto Aviles
 */
public class Usuario {
    private int codigo;
    private String nombre;
    private String pass;
    private int rol;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String pass, int rol) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
}
