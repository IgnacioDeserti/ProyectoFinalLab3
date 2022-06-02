package Producto.app;

public class Comida extends Producto{
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
                "\nGramos: " + gramos +
                "\nTipo producto" + tipoProducto;
    }
}
