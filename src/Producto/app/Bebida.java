package Producto.app;

public class Bebida extends Producto{
    private int ml;

    public Bebida(String nombreProduto, int id, float precio, int tipoProducto, int cantLlevada, int stock, int ml) {
        super(nombreProduto, id, precio, tipoProducto, cantLlevada, stock);
        this.ml = ml;
    }
}
