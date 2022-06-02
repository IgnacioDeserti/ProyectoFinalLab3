package Producto.app;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    private String nombreProduto;
    private static int contador;
    private int id;
    private float precio;
    private int stock;
    private  int cantLlevada;
    private boolean isDisponible;

    public Producto(String nombreProduto, float precio, int cantLlevada, int stock)
    {
        this.id = contador;
        this.nombreProduto = nombreProduto;
        this.precio = precio;
        this.cantLlevada = cantLlevada;
        this.stock = stock;
        this.isDisponible = true;
        contador++;
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

    //SETTERS----------------------------------


    public void setNombreProduto(String nombreProduto) {
        this.nombreProduto = nombreProduto;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCantLlevada(int cantLlevada) {
        this.cantLlevada = cantLlevada;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }
}
