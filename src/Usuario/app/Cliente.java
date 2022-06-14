package Usuario.app;

import Producto.app.Producto;

import javax.management.MBeanRegistrationException;
import java.io.*;
import java.util.ArrayList;

public class Cliente extends Usuario implements I_MetodosPersona, Serializable {

    private ArrayList<Producto> changuito;
    private static int capacidad = 50;

    public Cliente(String nombreYapellido, int dni, String password) {
        super(nombreYapellido, dni, password);
        this.changuito = new ArrayList<>();
    }

    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }


    public void agregarAlChanguito(Producto producto){
        changuito.add(producto);
    }

    public void buscarEnElChanguito(Producto producto) throws ProductoExistenteExcepcion {
        Producto producto1 = null;

        for (Producto aux: changuito) {
            if (aux.equals(producto)){
                throw new ProductoExistenteExcepcion("");
            }
        }
    }

}
