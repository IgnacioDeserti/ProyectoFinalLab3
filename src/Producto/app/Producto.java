package Producto.app;

public abstract class Producto{
    private String nombreProduto;
    private int id;
    private float precio;
    private int stock;
    private  int cantLlevada;
    private  int tipoProducto;   //1 Frio | 2 Seco

    public Producto(String nombreProduto, int id, float precio, int tipoProducto, int cantLlevada, int stock)
    {
        this.id = id;
        this.nombreProduto = nombreProduto;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.cantLlevada = cantLlevada;
        this.stock = stock;
    }
}
