
package edu.dao;
import edu.conexion.Conexion;
import edu.modelo.Escuela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import edu.modelo.Rol;

 /* Nombre de la clase:DaoRol
 * Fecha:11/08/2018
 * CopyRight:ITCA
 * Version:1.0
 * @author Nancy Lopez
 */
public class DaoRol extends Conexion{
    
     public ArrayList<Rol>getRol(){
        ArrayList<Rol> ls=new  ArrayList<>();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="Select * from rol;";
            PreparedStatement pre=getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Rol rol=new Rol();
                rol.setIdRol(res.getInt("idRol"));
                rol.setNombre(res.getString("nombre"));
                ls.add(rol);
            }
            
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo obtener los roles"+e.toString());
        }
        finally
        {
            this.desconectar();
        }
        return ls;
    }
    
    public Rol getidRol(int rol)
     {
        Rol ro= new Rol();

        ResultSet res=null;
        try 
        {
              this.conectar();
              String sql = "select * from rol where idRol = ?;";
              PreparedStatement pre = this.getCon().prepareStatement(sql);
              pre.setInt(1, rol);   
              res = pre.executeQuery();
             while (res.next()) 
               {              
                   ro.setIdRol(res.getInt("idRol"));
                   ro.setNombre(res.getString("nombre"));                
               }
           } catch (SQLException e) 
           {
               JOptionPane.showMessageDialog(null,"Error al mostrar datos "+e.getMessage());
           } 
           finally 
           {
               this.desconectar();
           }
           return ro;
    }

}
