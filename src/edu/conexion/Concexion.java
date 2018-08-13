
package edu.conexion;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ernesto Aviles
 */
public class Concexion 
{
    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public void conectar(){
        try 
        {
            Class.forName("");
            con=DriverManager.getConnection("");
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Imposible conectar a base de datos\n   "+e.getMessage());
        }
    }
    
    
    //este es un comentario
    
    public  void desconectar()
    {
        try 
        {
            if (con!=null) 
            {
                if (!con.isClosed()) {
                    con.close();
                }
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Problemas con base de datos\n  " +e.getMessage());
        }
    }
}
