package Factura;

import Producto.app.Producto;
import Usuario.app.Cliente;

import java.util.ArrayList;

public class Factura {

    private Cliente comprador;
    private float total;

    public Factura(Cliente comprador, float total) {
        this.comprador = comprador;
        this.total = total;
    }

    public Factura(){

    }

    //GETTERS----------------------------------------------------

    public Cliente getComprador() {
        return comprador;
    }

    public float getTotal() {
        return total;
    }

    //SETTERS----------------------------------------------------


    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "comprador=" + comprador +
                ", total=" + total +
                '}';
    }

    public String mostrar() {
        return "Factura: "+
                "\nCliente: " + comprador.listar() +
                "\nDetalle: " + comprador.mostrarBebidas() +
                "\n" + comprador.mostrarComidas() +
                "\n" + comprador.mostrarTecnologias() +
                "\nTotal: " + total;
    }
}
