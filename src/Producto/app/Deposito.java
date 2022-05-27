package Producto.app;

import java.util.HashMap;

public class Deposito<T> {

    HashMap<Integer, T> hashMap;

    public Deposito() {
        this.hashMap = new HashMap<Integer, T>();
    }

    public void agregarProducto(){
        //agrega al hashmap y al archi
    }
    public void eliminarProducto(){
        //elimina del hashmap y del archi
    }

    public void ajustarStock(){
        //fore en el arraylist del carito ajustando el stock
        //stock = stock - cantLlevada;
        //cantLlevada = 0;
        //fseek(segun get.id)
        //fwrite(nueva info)
    }
}
