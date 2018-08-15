
package edu.dao;

import edu.conexion.Conexion;
import edu.modelo.HorarioAtencion;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase:DaoHorarioA
 * Fecha:12/08/18
 * Versión: 1.8
 * CopyRight:SSE-ITCA
 * @author Roxana Menjivar
 */
public class DaoHorarioA extends Conexion{
    
    public List<HorarioAtencion>mostrarHorario()
    {
        List<HorarioAtencion>lista= new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from horarioAtencion";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()) 
            {
                HorarioAtencion hora = new HorarioAtencion();
                
                hora.setIdHorarioA(res.getInt("idHorarioA"));
                hora.setIdCoordinador(res.getInt("idCoordinador"));
                hora.setDia(res.getString("dia"));
                hora.setHoraDesde(res.getString("horaDesde"));
                hora.setHoraHasta(res.getString("horaHasta"));
                hora.setLugar(res.getString("lugar"));
                lista.add(hora);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al mostrar datos "+e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        } 
        finally 
        {
            this.desconectar();
        }
        return lista;
    }
    
    public void insertarHorario(HorarioAtencion hora)
    {
        try 
        {
            this.conectar();
            String sql="insert into horarioAtencion values(?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,hora.getIdHorarioA());
            pre.setInt(2,hora.getIdCoordinador());
            pre.setString(3,hora.getDia());
            pre.setString(4,hora.getHoraDesde());
            pre.setString(5,hora.getHoraHasta());
            pre.setString(6,hora.getLugar());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro agregado",
                        "Confirmacion",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al insertar datos \n"+e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void modificarHorario(HorarioAtencion hora)
    {
        try 
        {
            this.conectar();
            String sql="update horarioAtencion set dia=? where idHorarioA=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1,hora.getIdCoordinador());
            pre.setString(2,hora.getDia());
            pre.setString(3,hora.getHoraDesde());
            pre.setString(4,hora.getHoraHasta());
            pre.setString(5,hora.getLugar());
            pre.setInt(6,hora.getIdHorarioA());
            pre.executeUpdate();  
            JOptionPane.showMessageDialog(null,"Registro modificado",
                        "Confirmacion",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el registro \n"+e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarHorario(HorarioAtencion hora)
    {
        try 
        {
            this.conectar();
            String sql="delete from horarioAtencion where idHorarioA=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,hora.getIdHorarioA());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al eliminar el registro \n"+e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            this.desconectar();
        }
    }
}
