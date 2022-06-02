package Producto.app;

import java.io.Serializable;

public class Bebida extends Producto implements Serializable {
    private int ml;

    public Bebida(String nombreProduto, float precio, int cantLlevada, int stock, int ml) {
        super(nombreProduto, precio, cantLlevada, stock);
        this.ml = ml;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nml: " + ml;
    }
}
