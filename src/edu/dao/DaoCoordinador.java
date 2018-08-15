
package edu.dao;

import java.sql.*;
import edu.conexion.Conexion;
import edu.modelo.CoordinadorSSE;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase:DaoCoordinador
 * Fecha:12/08/18
 * Versión: 1.6
 * CopyRight:SSE-ITCA
 * @author Roxana Menjivar
 */
public class DaoCoordinador extends Conexion{
    
    public List mostrarCoordinador()
    {
        List lista = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="select * from coordinadorSSE;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                CoordinadorSSE cor = new CoordinadorSSE();
                cor.setIdCoordinador(res.getInt("idCoordinador"));
                cor.setNombre(res.getString("nombre"));
                cor.setCorreo(res.getString("correo"));
                cor.setIdEscuela(res.getInt("idEscuela"));
                lista.add(cor);
            }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error al mostrar " +e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    }
    
    public void insertarCoordinador(CoordinadorSSE cor)
    {
        try 
        {
            this.conectar();
            String sql="insert into coordinadorSSE (nombre,correo,idEscuela) values(?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            //pre.setInt(1, cor.getIdCoordinador());
            pre.setString(1,cor.getNombre());
            pre.setString(2,cor.getCorreo());
            pre.setInt(3,cor.getIdEscuela());
            pre.executeUpdate();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error al insertar " +e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void modificarCoordinador(CoordinadorSSE cor)
    {
        try 
        {
            this.conectar();
            String sql = "update coordinadorSSE set nombre = ? , correo = ?, idEscuela =?  where idCoordinador = ? ;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, cor.getNombre());
            pre.setString(2, cor.getCorreo());
            pre.setInt(3, cor.getIdEscuela());
            pre.setInt(4, cor.getIdCoordinador());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,"Error al modificar datos "+e.getMessage());
        }
        finally 
        {
            this.desconectar();
        }
    }

    public void eliminarCoordinador(int idCoor)
    {
        try 
        {
            this.conectar();
            String sql = "delete from coordinadorSSE where idCoordinador = ?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idCoor);
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,
                    "Imposible Eliminar no seleccinado " + e.getMessage(),
                    "Eliminacion Fallida " ,
                    JOptionPane.ERROR_MESSAGE);
        } 
        finally 
        {
            this.desconectar();
        }
    }

    public CoordinadorSSE getCoordinadorSSE(int idCoordinador)
    {

        CoordinadorSSE cor = new  CoordinadorSSE();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from coordinadorSSE where idCoordinador = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idCoordinador);
            res = pre.executeQuery();
            while (res.next()) 
            {
                cor.setIdCoordinador(res.getInt("idCoordinador"));
                cor.setNombre(res.getString("nombre"));
                cor.setCorreo(res.getString("correo"));
                cor.setIdEscuela(res.getInt("idEscuela"));
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        } 
        finally 
        {
            this.desconectar();
        }
        return cor;
    }
}
