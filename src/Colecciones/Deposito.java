package Colecciones;

import Producto.app.Producto;

import java.io.*;
import java.util.HashSet;

public class Deposito implements I_Coleccion<Producto>, Serializable {

   HashSet<Producto> productoHashSet;

    public Deposito() {
        this.productoHashSet = new HashSet<>();
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Producto producto: productoHashSet) {
                objectOutputStream.writeObject((Producto) producto);
            }

            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashSet<Producto> leerArchivo(String nombreArchivo) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                Producto producto = (Producto) objectInputStream.readObject();
                productoHashSet.add(producto);
            }
        }catch (EOFException e) {
            System.out.println("");

        } catch(IOException | ClassNotFoundException e)
        {
            e.getMessage();
        }

        return productoHashSet;
    }

    @Override
    public int contar() {
        return productoHashSet.size();
    }

    @Override
    public boolean eliminar(int id) {
        boolean rta = false;
        Producto aux = buscar(id);
        if (aux != null) {
            productoHashSet.remove(aux);
            rta = true;
        }

        return rta;
    }

    @Override
    public Producto buscar(int aux) {
        Producto encontrada = null;
        for (Producto producto: productoHashSet) {
            if (producto.getId() == (int) aux){
                encontrada = producto;
            }
        }
        return encontrada;
    }

    public StringBuilder mostrar() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Producto producto : productoHashSet){
            stringBuilder.append(producto.mostrar());
        }

        return stringBuilder;
    }

    @Override
    public boolean agregar(Producto producto) {
        boolean rta = false;
        producto.setId(contar());
        Producto aux = buscar((producto.getId()));
        if (aux == null) {
            productoHashSet.add(producto);
            rta = true;
        }
        return rta;
    }

    public boolean agregarModificado(Producto producto){
        boolean rta = false;
        Producto aux = buscar((producto.getId()));
        if (aux == null) {
            productoHashSet.add(producto);
            rta = true;
        }
        return rta;
    }

    public String toString() {
        return "" + productoHashSet;
    }

    public void modificoArchi(String nombreArchivo, Producto producto){
        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchivo));
        deposito.eliminar(producto.getId());
        deposito.agregarModificado(producto);
        deposito.cargarArchivo(nombreArchivo);
    }

    //SETTERS--------------------------------------------------------
    public void setProductoHashSet(HashSet<Producto> productoHashSet) {
        this.productoHashSet = productoHashSet;
    }

    //GETTERS--------------------------------------------------------

    public HashSet<Producto> getProductoHashMap() {
        return productoHashSet;
    }
}
