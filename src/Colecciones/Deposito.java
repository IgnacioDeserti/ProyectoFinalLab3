package Colecciones;

import Producto.app.Producto;

import java.io.*;
import java.util.HashMap;

public class Deposito implements I_Coleccion<Producto>, Serializable {

    HashMap<Integer, Producto> productoHashMap;

    public Deposito() {
        this.productoHashMap = new HashMap<Integer, Producto>();
    }


    public void cargarArchivo() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("productos.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(int i = 0; i <= productoHashMap.size(); i++){
                objectOutputStream.writeObject((Producto) productoHashMap.get(i));
            }

            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Producto> leerArchivo(String nombreArchi) {
        try {
            int i = 0;
            FileInputStream fileInputStream = new FileInputStream("productos.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                Producto producto = (Producto) objectInputStream.readObject();
                productoHashMap.put(i , producto);
                i++;
            }
        }catch (EOFException e) {
            System.out.println("");

        } catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return productoHashMap;
    }

    public void setProductoHashMap(HashMap<Integer, Producto> productoHashMap) {
        this.productoHashMap = productoHashMap;
    }

    @Override
    public int contar() {
        return productoHashMap.size();
    }

    @Override
    public boolean eliminar(int id) {
        boolean rta = false;
        Producto aux = buscar(id);
        if (aux != null) {
            productoHashMap.remove(id);
            rta = true;
        }
        return rta;
    }

    @Override
    public Producto buscar(int aux) {
        Producto encontrada = null;
        if (productoHashMap.containsKey(aux)) {
            encontrada = productoHashMap.get(aux);
        }
        return encontrada;
    }

    @Override
    public String mostrar() {
        return productoHashMap.toString();
    }

    @Override
    public boolean agregar(Producto producto) {
        boolean rta = false;
        Producto aux = (Producto) buscar((producto.getId()));
        if (aux == null) {
            productoHashMap.put(producto.getId(), producto);
            rta = true;
        }

        return rta;
    }

    public String toString() {
        return "" + productoHashMap;
    }

}
