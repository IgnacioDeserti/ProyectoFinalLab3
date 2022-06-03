package Producto.app;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    private String nombreProduto;
    private static int contador;
    private Integer id;
    private Float precio;
    private Integer stock;
    private Integer cantLlevada;
    private Boolean isDisponible;

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

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
