package Colecciones;

import Excepciones.EliminarExcepcion;
import Factura.Factura;
import Producto.app.Producto;
import Usuario.app.Cliente;

import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.util.ArrayList;
import JSON.JsonUtiles;


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
    public boolean eliminar(int dni){
        boolean bool = false;
        for (Factura factura : facturas) {
            if (factura.getComprador().getDni() == dni ){
                facturas.remove(factura);
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public Factura buscar(int dni) {
        for (Factura factura : facturas) {
            if (factura.getComprador().getDni() == dni ){
                return factura;
            }
        }
        return null;
    }

    @Override
    public String mostrar() {
        return facturas.toString();
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
        Factura factura = buscar(aux.getComprador().getDni());
        if (factura == null){
            facturas.add(aux);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + facturas;
    }


}
