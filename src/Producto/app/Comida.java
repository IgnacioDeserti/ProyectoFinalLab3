package Producto.app;

import java.io.Serializable;

public class Comida extends Producto implements Serializable {
    private float gramos;
    private  int tipoProducto; //1 Frio | 2 Seco

    public Comida(String nombreProduto, float precio, int tipoProducto, int stock, float gramos) {
        super(nombreProduto, precio, stock);
        this.gramos = gramos;
        this.tipoProducto = tipoProducto;
    }

    public Comida(){

    }

    @Override
    public String toString() {
        return super.toString() +
                "Comida{" +
                "gramos=" + gramos +
                ", tipoProducto=" + tipoProducto +
                '}';
    }

    @Override
    public String mostrar() {
        return  super.mostrar()+
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
