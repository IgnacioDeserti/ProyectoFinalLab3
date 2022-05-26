package Producto.app;

public class Comida extends Producto{
    private float gramos;

    public Comida(String nombreProduto, int id, float precio, int tipoProducto, int cantLlevada, int stock, float gramos) {
        super(nombreProduto, id, precio, tipoProducto, cantLlevada, stock);
        this.gramos = gramos;
    }
}
