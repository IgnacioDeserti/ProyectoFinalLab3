package Persona.app;

import Producto.app.Producto;

import java.util.ArrayList;

public class Cliente extends Persona implements I_MetodosPersona{

    private int idCliente;
    private ArrayList<Producto> changuito;
    private static int capacidad = 50;

    public Cliente(String nombreYapellido, int dni) {
        super(nombreYapellido, dni);
        this.idCliente = idCliente + 1;
        this.changuito = new ArrayList<>();
    }


    @Override
    public boolean registro(Persona persona) {
        return false;
    }

    @Override
    public String listar() {
        return null;
    }
}
