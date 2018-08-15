/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utilidades;

import java.awt.event.KeyEvent;

/**
 * Nombre de la clase: Validaciones
 * Version:
 * Fecha: 11/08/18
 * CopyRight: Proyecto Control SSE
 * @author Roxana Menjivar
 */
public class Validaciones {
    
    /**
     * validar solo numeros
     *
     * @param evt
     */
    public void numbersOnly(KeyEvent evt) 
    {
        if (!Character.isDigit(evt.getKeyChar())) 
        {
            evt.consume();
        }
    }
    
    /**
     * validar solo palabras
     *
     * @param evt
     */
    public void wordsOnly(KeyEvent evt) 
    {
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_SPACE)
        {
            evt.consume();
        }
    }

    public boolean IsNullOrEmpty(String val) 
    {
        if (val.equals("")) 
        {
            return true;
        }
        if (val.length() == 0) 
        {
            return true;
        }
        if (val == null) 
        {
            return true;
        }
        return false;
    }   
}
