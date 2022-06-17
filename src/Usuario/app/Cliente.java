package Usuario.app;

import Producto.app.Producto;

import javax.management.MBeanRegistrationException;
import java.io.*;
import java.util.ArrayList;

public class Cliente extends Usuario implements I_MetodosPersona, Serializable {

    private ArrayList<Comida> comidas;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Tecnologia> tecnologias;
    private static int capacidad = 50;

    public Cliente(String nombreYapellido, int dni, String password) {
        super(nombreYapellido, dni, password);
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.tecnologias = new ArrayList<>();

    }
    public Cliente(){

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
        return super.toString() +
                "Cliente{" +
                "comidas=" + comidas +
                ", bebidas=" + bebidas +
                ", tecnologias=" + tecnologias +
                '}';
    }

    public String mostrar() {
        return super.mostrar();
    }

    public void agregarAlCarro(Producto producto){
        if (producto instanceof Comida){
            comidas.add((Comida) producto);
        }else if (producto instanceof Bebida){
            bebidas.add((Bebida) producto);
        }
        else {
            tecnologias.add((Tecnologia) producto);
        }
    }

    public void buscarEnElChanguito(Producto producto) throws ProductoExistenteExcepcion {
        Producto producto1 = null;

        if (producto instanceof Comida){
            for (Producto aux: comidas) {
                if (aux.equals(producto)){
                    throw new ProductoExistenteExcepcion("");
                }
            }
        }
        else if (producto instanceof Bebida){
            for (Producto aux: bebidas) {
                if (aux.equals(producto)){
                    throw new ProductoExistenteExcepcion("");
                }
            }
        }
        else {
            for (Producto aux: tecnologias) {
                if (aux.equals(producto)){
                    throw new ProductoExistenteExcepcion("");
                }
            }
        }
    }

}
