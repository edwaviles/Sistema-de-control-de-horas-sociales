package edu.vistas;

/**
 *
 * @author Ernesto Aviles
 */
public class CombosItems {

 public CombosItems() {
    }

    private int value;
    private String label;

    public CombosItems(int value, String label) {
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
