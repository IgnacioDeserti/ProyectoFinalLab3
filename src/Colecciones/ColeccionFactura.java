package Colecciones;

import Factura.Factura;
import Producto.app.Producto;
import Usuario.app.Cliente;

import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.util.ArrayList;

public class ColeccionFactura implements I_Coleccion<Factura>, Serializable {

    private ArrayList<Factura> facturas;

    public ColeccionFactura() {
        facturas = new ArrayList<>();
    }

    @Override
    public int contar() {
        return facturas.size();
    }

    @Override
    public boolean eliminar(int aux) {
        return false;
    }

    @Override
    public Factura buscar(int aux) {
        return null;
    }

    @Override
    public String mostrar() {
        return null;
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {

    }

    @Override
    public ArrayList<Factura> leerArchivo(String nombreArchivo) {
        return null;
    }

    @Override
    public boolean agregar(Factura aux) {
        return false;
    }

    @Override
    public String toString() {
        return "" + facturas;
    }
}
