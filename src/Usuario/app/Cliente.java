package Usuario.app;

import Excepciones.CantidadExcedidaExcepcion;
import Excepciones.ProductoExistenteExcepcion;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;

import javax.management.MBeanRegistrationException;
import java.io.*;
import java.util.ArrayList;

public class Cliente extends Usuario implements Serializable {

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

    //GETTERS-----------------------------------------

    public static int getCapacidad() {
        return capacidad;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public ArrayList<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    //SETTERS-----------------------------------------


    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public void setTecnologias(ArrayList<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public int verificoCantidadLlevada(Producto producto, int cantLlevada) throws CantidadExcedidaExcepcion {
        if (producto.getCantLlevada() + cantLlevada <= getCapacidad()){
            cantLlevada = cantLlevada + producto.getCantLlevada();
        }
        else {
            throw new CantidadExcedidaExcepcion("");
        }

        return cantLlevada;
    }

    public StringBuilder mostrarBebidas(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Bebida bebida : bebidas){
            stringBuilder.append(bebida.mostrar());
        }

        return stringBuilder;
    }

    public StringBuilder mostrarComidas(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Comida comida : comidas){
            stringBuilder.append(comida.mostrar());
        }

        return stringBuilder;
    }

    public StringBuilder mostrarTecnologias(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Tecnologia tecnologia : tecnologias){
            stringBuilder.append(tecnologia.mostrar());
        }

        return stringBuilder;
    }

}
