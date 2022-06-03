package Producto.app;

import java.io.Serializable;

public class Comida extends Producto implements Serializable {
    private float gramos;
    private  int tipoProducto; //1 Frio | 2 Seco

    public Comida(String nombreProduto, float precio, int tipoProducto, int cantLlevada, int stock, float gramos) {
        super(nombreProduto, precio, cantLlevada, stock);
        this.gramos = gramos;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\nGramos: " + gramos;
    }

    //SETTERS-----------------------------------------------------

    public void setGramos(float gramos) {
        this.gramos = gramos;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
