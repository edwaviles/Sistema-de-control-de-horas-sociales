
package edu.dao;

import edu.conexion.Conexion;
import edu.modelo.Carrera;
import edu.modelo.ComboC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase:DaoCarrera
 * Fecha:12/08/18
 * Versión: 1.7
 * CopyRight:SSE-ITCA
 * @author Roxana Menjivar
 */
public class DaoCarrera extends Conexion{
    
    public List<ComboC>mostrarCarrera(int idEscuela)
    {
        List<ComboC> lista = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from carrera where escuela_idEscuela=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idEscuela);
            res=pre.executeQuery();
            while(res.next())
            {
                ComboC cmb = new ComboC();
                cmb.setIdCombo(Integer.parseInt(res.getString("idCarrera")));
                cmb.setDescripcion(res.getString("nombre"));
                cmb.setIdEscuela(res.getInt("escuela_idEscuela"));
                lista.add(cmb);
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar la lista de carreras " +e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    }
    
    public Carrera getidCarrera(int car)
    {
        Carrera c = new Carrera();
        ResultSet res;
        
        try 
        {
            this.conectar();
            String sql = "Select * from carrera where idCarrera = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, car);
            res = pre.executeQuery();
            
            while(res.next())
            {
                c.setIdCarrera(res.getInt("idCarrera"));
                c.setNombre(res.getString("nombre"));
                c.setIdEscuela(res.getInt("escuela_idEscuela"));
            }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar datos " +e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return c;
    }
    
    
}
