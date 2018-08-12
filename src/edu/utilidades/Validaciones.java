
package edu.utilidades;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *Nombre de la clase:Validaciones
 * Version:
 * Fecha:
 * CopyRight:
 * @author Ernesto Aviles
 */
public class Validaciones {
    
    //solo  numeros
    public void soloNumeros(java.awt.event.KeyEvent evt)
    {
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c)) 
        {
            evt.consume();
        }
    }
    
    //solo  letras
    public void soloLetrasSinEspacios(java.awt.event.KeyEvent evt)
    {
        Character c = evt.getKeyChar();
        if (!Character.isLetter(c)) 
        {
            evt.consume();
        }
    }
    //solo  letras
    public void soloLetrasConEspacios(java.awt.event.KeyEvent evt)
    {
        Character c = evt.getKeyChar();
        if (!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) 
        {
            evt.consume();
        }
    }
    
    //solo numeros y un punto
    public void soloNumeroYunPunto(java.awt.event.KeyEvent evt, JTextField Jtext)
    {
        Character c= evt.getKeyChar();
        if (!Character.isDigit(c) && c!='.')
        {
            evt.consume();
        }
        if (c=='.' && Jtext.getText().contains(".")) 
        {
            evt.consume();
        }
    }
     
    
    //es nulo o vacio
    public Boolean EsNuloOVacio(JTextField jt)
    {   
        Boolean c=false;
        if (jt.equals("")) 
            c=true;
        if (jt.getText().length()==0) 
            c=true;
        if (jt==null) 
            c=true;
        return c;        
    }
}//fin de validaciones
