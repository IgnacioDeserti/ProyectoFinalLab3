package Producto.app;

import java.io.Serializable;

public class Bebida extends Producto implements Serializable {
    private Integer ml;

    public Bebida(String nombreProduto, float precio, int stock, int ml) {
        super(nombreProduto, precio, stock);
        this.ml = ml;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nml: " + ml;
    }

    //SETTERS---------------------------------------------------------


    public void setMl(int ml) {
        this.ml = ml;
    }
}
