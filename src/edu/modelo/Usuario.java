
package edu.modelo;
import edu.modelo.Rol;

 /* Nombre de la clase:Conexion
 * Fecha:11/08/2018
 * CopyRight:ITCA
 * Version:1.0
 * @author Nancy Lopez
 */
public class Usuario extends Rol{
    
     private int idUsuario;
    private String Usuario;
    private String contrasenia;
    private String fechaRegistro;
    private String fechaModificacion;
    private int estado;

    public Usuario() 
    {
        
    }

    public Usuario(int idUsuario, int cod_Usuario, String Usuario, String contrasenia, String fechaRegistro, String fechaModificacion, int estado, int idRol, String nombre) {
        super(idRol, nombre);
        this.idUsuario = idUsuario;
       
        this.Usuario = Usuario;
        this.contrasenia = contrasenia;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }     
}
