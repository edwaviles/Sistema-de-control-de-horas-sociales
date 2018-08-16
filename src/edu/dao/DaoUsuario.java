
package edu.dao;
import edu.conexion.Conexion;
import edu.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


 /* Nombre de la clase:DaoUsurio
 * Fecha:11/08/2018
 * CopyRight:ITCA
 * Version:1.0
 * @author Nancy Lopez
 */

public class DaoUsuario extends Conexion{
    
    
        public List<Usuario> mostrar()
    {
        List<Usuario>listaUsuario= new ArrayList();
        ResultSet res;
        try 
        {
          
          this.conectar();
            String sql="select*from usuario";
            PreparedStatement pre= getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Usuario us =new Usuario();
                us.setIdUsuario(Integer.parseInt(res.getString("idUsuario")));
                us.setUsuario(res.getString("usuario"));
                us.setFechaRegistro(res.getString("fecha_Registro"));
                us.setEstado(Integer.parseInt(res.getString("estado")));
                us.setIdRol(Integer.parseInt(res.getString("idRol")));
                listaUsuario.add(us);                                      
            }
            
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error al mostrar"+ e.getMessage());
        }
        finally
        {
            desconectar();
        }
      return listaUsuario;
    }
        
        public void Eliminar(Usuario us)
        {
            try 
            {
                this.conectar();
                String sql="delete from usuario where idUsuario=?";
                PreparedStatement pre= getCon().prepareStatement(sql);
                pre.setInt(1,us.getIdUsuario());
                pre.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Datos elimnados");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar"+e.toString());
            }
        
        }
        
               
        public void Modificar(Usuario us)
        {
            try 
            {
                this.conectar();
                String sql="update usuario set usuario=? where idUsuario=?;";
                PreparedStatement pre= getCon().prepareStatement(sql);
                pre.setString(1,us.getUsuario());
                pre.setInt(2,us.getIdUsuario());  
                 pre.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Datos Modificados");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error al Modiificar"+e.toString());
            }
        
        }
        
        
       public void insertar(Usuario us)
       {
           try 
           {
            this.conectar();
            String sql="INSERT INTO usuario (idUsuario, idRol, usuario, contrasenia,"
                    + " fecha_Registro,fecha_Modifica, estado)\n" +
                      " VALUES (?, ?, ?, ?, ?,?, ?);"; 
                    PreparedStatement pre=getCon().prepareStatement(sql);
                    pre.setInt(1, 0);
                    pre.setInt(2,us.getIdRol());
                    pre.setString(3,us.getUsuario());
                    pre.setString(4,us.getContrasenia());
                    pre.setString(5,us.getFechaRegistro());
                    pre.setString(6,us.getFechaModificacion());
                    pre.setInt(7,us.getEstado());
                    pre.executeUpdate();
           }
           catch (Exception e) 
           {
               JOptionPane.showMessageDialog(null,"Error al insertar"+e.toString());
           }
           
           finally
           {
               desconectar();
           }
       
       }   
      
       public int Verificasiexiste(String usuario)
       {
           try 
           {
             ResultSet res=null;
            this.conectar();
            String sql="select count(idUsuario) from usuario where usuario=?"; 
                    PreparedStatement pre=getCon().prepareStatement(sql);
                    pre.setString(1, usuario);
                    
                   res=pre.executeQuery();
                   if(res.next())
                   {
                      return res.getInt(1);
                   }
                   return 1;
                   
           }
           catch (Exception e) 
           {
               return 1;
           }
           
           finally
           {
               desconectar();
           }
       
       } 
}
