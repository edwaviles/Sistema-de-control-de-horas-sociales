
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
        if (!Character.isDigit(c) && c==KeyEvent.VK_SPACE) 
        {
            evt.consume();
        }
    }
    
    //solo  letras
    public void soloLetras(java.awt.event.KeyEvent evt)
    {
        Character c = evt.getKeyChar();
        if (!Character.isLetter(c)) 
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
        
}//fin de validaciones
