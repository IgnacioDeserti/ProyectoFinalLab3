package Producto.app;

import java.io.Serializable;

public class Tecnologia extends Producto implements Serializable {
    private boolean isElectrico; //Si es a corriente o bateria


    public Tecnologia(String nombreProduto, float precio, int cantLlevada, int stock, boolean isElectrico) {
        super(nombreProduto, precio, cantLlevada, stock);
        this.isElectrico = isElectrico;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nIs Electrico: " + isElectrico;
    }
}
