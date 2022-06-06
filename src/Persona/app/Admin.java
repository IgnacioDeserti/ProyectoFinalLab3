package Persona.app;

import Colecciones.Deposito;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;

import java.io.*;
import java.util.HashMap;

public class Admin extends Usuario implements I_MetodosPersona, Serializable {

    private int codigoSecreto;

    public Admin(String nombreYapellido, int dni, String password, int codigoSecreto) {
        super(nombreYapellido, dni, password);
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

    public Comida modificoComida(Comida comida, Object object, int opcion) {

        try{
            switch(opcion)
            {
                case 1-> {
                     comida.setPrecio((Float) object);
                }
                case 2-> {
                    comida.setStock((Integer) object);
                }
                case 3-> {
                    comida.setNombreProduto((String) object);
                }
                case 4-> {
                    comida.setGramos((Float) object);
                }
                case 5-> {
                    comida.setTipoProducto((Integer) object);
                }
                default -> {
                    throw new Exception();
                }
            }

        }catch (Exception e){
            e.getMessage();
        }

        return comida;
    }

    public Bebida modificoBebida(Bebida bebida, Object object, int opcion){

        try{
            switch(opcion)
            {
                case 1-> {
                    bebida.setPrecio((Float) object);
                }
                case 2-> {
                    bebida.setStock((Integer) object);
                }
                case 3-> {
                    bebida.setNombreProduto((String) object);
                }
                case 4-> {
                    bebida.setMl((Integer) object);
                }
            }

        }catch (Exception e){
            e.getMessage();
        }

        return bebida;
    }

    public Tecnologia modificoTecnologia(Tecnologia tecnologia, Object object, int opcion){

        try{
            switch(opcion)
            {
                case 1-> {
                    tecnologia.setPrecio((Float) object);
                }
                case 2-> {
                    tecnologia.setStock((Integer) object);
                }
                case 3-> {
                    tecnologia.setNombreProduto((String) object);
                }
                case 4-> {
                    tecnologia.setElectrico((Boolean) object);
                }
            }

        }catch (Exception e){
            e.getMessage();
        }

        return tecnologia;
    }

    public void guardarArchiModificado(String nombreArchi, Producto producto){
        Deposito deposito = new Deposito();
        deposito.setProductoHashMap(deposito.leerArchivo(nombreArchi));
        HashMap<Integer, Producto> aux = deposito.getProductoHashMap();
        aux.put(producto.getId(), producto);
        deposito.setProductoHashMap(aux);
        deposito.cargarArchivo(nombreArchi);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Numero incorrecto ";
    }

    public void menuModificacion(int op, Object object, int opcion){
       String nombreArchi = elegirArchi(op);
       Deposito deposito = new Deposito();
       deposito.setProductoHashMap(deposito.leerArchivo(nombreArchi));
        System.out.println(deposito.mostrar());
        Producto producto = seleccionoProducto(0, nombreArchi);


        if (producto instanceof Comida){
            producto = modificoComida((Comida) producto, object, 3);
        }
        else if(producto instanceof Bebida){
            System.out.println("holaaaa");
            producto = modificoBebida((Bebida) producto, object, 3);
        }
        else{
            producto = modificoTecnologia((Tecnologia) producto, object, 3);
        }

        guardarArchiModificado(nombreArchi, producto);
    }
}
