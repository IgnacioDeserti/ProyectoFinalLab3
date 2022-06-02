package Persona.app;

import Colecciones.Deposito;
import Producto.app.Producto;

import java.io.*;
import java.util.HashMap;

public class Admin extends Empleado implements I_MetodosPersona, Serializable {

    private int codigoSecreto;

    public Admin(String nombreYapellido, int dni, String password, String departamento, int codigoSecreto) {
        super(nombreYapellido, dni, password, departamento);
        this.codigoSecreto = codigoSecreto;
    }

    @Override
    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nCodigo Secreto: " + codigoSecreto;
    }

    public String elegirArchi(int op){
        String nombreArchi = "";
        if (op == 1){
            nombreArchi = "comida.bin";
        }
        if (op == 2){
            nombreArchi = "bebida.bin";
        }
        if (op == 3){
            nombreArchi = "tecnologia.bin";
        }

        return nombreArchi;
    }

    public Producto seleccionoProducto(int id, String nombreArchivo){

        Deposito deposito = new Deposito();
        deposito.setProductoHashMap(deposito.leerArchivo(nombreArchivo));

        Producto aux = deposito.buscar(id);

        return aux;
    }

    public Producto modificoProducto(Producto producto, String nombre){

        producto.setNombreProduto(nombre);

        return producto;
    }

}
