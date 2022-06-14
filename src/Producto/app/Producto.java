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

    public Producto(String nombreProduto, float precio, int stock)
    {
        this.id = contador;
        this.nombreProduto = nombreProduto;
        this.precio = precio;
        this.cantLlevada = 0;
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

    @Override
    public int hashCode() {
        int result = nombreProduto.hashCode();
        result = 31 * result + precio.hashCode();
        return result;
    }

    //SETTERS----------------------------------


    public void setNombreProduto(String nombreProduto) {
        this.nombreProduto = nombreProduto;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
        if (this.stock == 0){
            setDisponible(false);
        }
    }

    public void setDisponible(Boolean disponible) {
        isDisponible = disponible;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCantLlevada(Integer cantLlevada) {
        this.cantLlevada = cantLlevada;
    }

    //GETTERS--------------------------------

    public Integer getStock() {
        return stock;
    }

    public Integer getCantLlevada() {
        return cantLlevada;
    }

    public Float getPrecio() {
        return precio * cantLlevada;
    }
}
