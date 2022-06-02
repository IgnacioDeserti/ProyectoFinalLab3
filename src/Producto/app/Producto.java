package Producto.app;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    private String nombreProduto;
    private static int id;
    private float precio;
    private int stock;
    private  int cantLlevada;
    private boolean isDisponible;

    public Producto(String nombreProduto, float precio, int cantLlevada, int stock)
    {
        id++;
        this.nombreProduto = nombreProduto;
        this.precio = precio;
        this.cantLlevada = cantLlevada;
        this.stock = stock;
        this.isDisponible = true;
    }

    public void setDisponible(){
        if (stock < 0){
            isDisponible = false;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n\nNombre produto: " + nombreProduto +
                "\nId: " + id +
                "\nPrecio: " + precio +
                "\nStock: " + stock +
                "\nIs Disponible: " + isDisponible;
    }


    //public void verificarCantLlevada(){}


}
