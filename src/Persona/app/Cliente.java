package Persona.app;

import Producto.app.Producto;

import java.util.ArrayList;

public class Cliente extends Persona{

    private int idCliente;
    private ArrayList<Producto> changuito;
    private int capacidad;
    private int formaPago;  //0 para efectivo  |  1 para debito/transferencia  | 2 credito

    public Cliente(String nombreYapellido, int dni, int idCliente, int capacidad, int formaPago) {
        super(nombreYapellido, dni);
        this.idCliente = idCliente;
        this.changuito = new ArrayList<>();
        this.capacidad = capacidad;
        this.formaPago = formaPago;
    }
}
