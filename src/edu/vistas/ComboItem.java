
package edu.vistas;

/**
 * Nombre de la clase:ComboItem
 * Fecha:12/08/18
 * Versión: 2.1
 * CopyRight:SSE-ITCA
 * @author Roxana Menjivar
 */
public class ComboItem {
    
    public ComboItem() {
    }

    private int value;
    private String label;

    public ComboItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    } 
}
