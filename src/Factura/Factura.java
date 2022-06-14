package Factura;

import Producto.app.Producto;
import Usuario.app.Cliente;

import java.util.ArrayList;

public class Factura {

    private ArrayList<Producto> compra;
    private Cliente comprador;
    private float total;

    public Factura(ArrayList<Producto> compra, Cliente comprador, float total) {
        this.compra = compra;
        this.comprador = comprador;
        this.total = total;
    }

    //GETTERS----------------------------------------------------
    public ArrayList<Producto> getCompra() {
        return compra;
    }

    public Cliente getComprador() {
        return comprador;
    }

    //SETTERS----------------------------------------------------

    public void setCompra(ArrayList<Producto> compra) {
        this.compra = compra;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "Factura: "+
                "\n Cliente: " + comprador.listar() +
                "\nDetalle: " + compra.toString() +
                "\nTotal: " + total;
    }
}
