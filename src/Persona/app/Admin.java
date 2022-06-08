package Persona.app;

import Colecciones.Deposito;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

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

    public void leerArchivoAux(String nombreArchi){
        Deposito deposito = new Deposito();
        deposito.leerArchivo(nombreArchi);
    }

    public Producto seleccionoProducto(int id, String nombreArchivo){

        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchivo));

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

    public boolean eliminoParaReemplazar(int id, String nombreArchi){
        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        Producto producto = deposito.buscar(id);
        if (producto != null){
            deposito.eliminar(producto.getId());
            deposito.cargarArchivo(nombreArchi);
            return true;
        }

        return false;
    }

    public void guardarArchiModificado(String nombreArchi, Producto producto){
        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        deposito.agregar(producto);
        deposito.cargarArchivo(nombreArchi);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Numero incorrecto ";
    }

    public void menuModificacion(int op, Object object, int opcion){
       String nombreArchi = elegirArchi(op);
       Deposito deposito = new Deposito();
       deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        System.out.println(deposito.mostrar());
        Producto producto = seleccionoProducto(0, nombreArchi);


        if (producto instanceof Comida){
            producto = modificoComida((Comida) producto, object, opcion);
        }
        else if(producto instanceof Bebida){
            producto = modificoBebida((Bebida) producto, object, opcion);
        }
        else{
            producto = modificoTecnologia((Tecnologia) producto, object, opcion);
        }

        guardarArchiModificado(nombreArchi, producto);
    }

    public void agregarProducto(String nombreArchi, Producto producto){
        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        producto.setId(deposito.contar());
        deposito.agregar(producto);
        deposito.cargarArchivo(nombreArchi);
    }

    public void menuAgregar(int op, Producto producto){
        String nombreArchi = elegirArchi(op);
        agregarProducto(nombreArchi, producto);
    }

    public boolean eliminarProducto(String nombreArchi, int id){
        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        boolean rta = deposito.eliminar(id);
        deposito.cargarArchivo(nombreArchi);
        return rta;
    }
}
