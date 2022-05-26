package Producto.app;

public class Tecnologia extends Producto{
    private boolean isElectrico; //Si es a corriente o bateria


    public Tecnologia(String nombreProduto, int id, float precio, int tipoProducto, int cantLlevada, int stock, boolean isElectrico) {
        super(nombreProduto, id, precio, tipoProducto, cantLlevada, stock);
        this.isElectrico = isElectrico;
    }
}
