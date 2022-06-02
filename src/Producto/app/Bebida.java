package Producto.app;

import java.io.Serializable;

public class Bebida extends Producto implements Serializable {
    private int ml;

    public Bebida(String nombreProduto, int id, float precio, int tipoProducto, int cantLlevada, int stock, int ml) {
        super(nombreProduto, id, precio, tipoProducto, cantLlevada, stock);
        this.ml = ml;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nml: " + ml;
    }
}
