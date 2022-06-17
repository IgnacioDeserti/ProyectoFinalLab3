package Colecciones;

import Factura.Factura;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;
import Usuario.app.Cliente;

import javax.swing.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import JSON.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ColeccionFactura implements I_Coleccion<Factura>, Serializable {

    private ArrayList<Factura> facturas;

    public ColeccionFactura() {
        facturas = new ArrayList<>();
    }

    @Override
    public int contar() {
        return facturas.size();
    }

    @Override
    public boolean eliminar(int dni){
        boolean bool = false;
        for (Factura factura : facturas) {
            if (factura.getComprador().getDni() == dni ){
                facturas.remove(factura);
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public Factura buscar(int dni) {
        for (Factura factura : facturas) {
            if (factura.getComprador().getDni() == dni ){
                return factura;
            }
        }
        return null;
    }

    @Override
    public String mostrar() {
        return facturas.toString();
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {
        try {
            JSONArray jsonArray = new JSONArray(facturas.toString());
            JsonUtiles.grabar(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Factura> leerArchivo(String nombreArchivo) {
        String contenido = JsonUtiles.leer("facturas.json");
        try {
            JSONArray array = new JSONArray(contenido);
            for (int i = 0; i < array.length(); i++) {
                Cliente cliente = new Cliente();
                JSONObject object = array.getJSONObject(i);
                JSONArray bebidasJSON = object.getJSONArray("bebidas");
                JSONArray comidasJSON = object.getJSONArray("comidas");
                JSONArray tecnologiasJSON = object.getJSONArray("tecnologias");
                ArrayList<Bebida> bebidas = new ArrayList<>();
                ArrayList<Comida> comidas = new ArrayList<>();
                ArrayList<Tecnologia> tecnologias = new ArrayList<>();

                cliente.setNombreYapellido(object.getString("nombreYapellido"));
                cliente.setDni(object.getInt("dni"));
                cliente.setIdUsuario(object.getInt("idUsuario"));
                cliente.setPassword(object.getString("password"));
                cliente.setContador(object.getInt("contador"));
                cliente.setCapacidad(object.getInt("capacidad"));
                for (int j = 0; j < bebidasJSON.length(); j++) {
                    JSONObject producto = bebidasJSON.getJSONObject(j);
                    Bebida bebida = new Bebida();
                    bebida.setNombreProduto(producto.getString("nombreProducto"));
                    bebida.setId(producto.getInt("id"));
                    bebida.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                    bebida.setStock(producto.getInt("stock"));
                    bebida.setCantLlevada(producto.getInt("cantLlevada"));
                    bebida.setDisponible(producto.getBoolean("isDisponible"));
                    bebida.setMl(producto.getInt("ml"));
                    bebidas.add(bebida);
                }
                cliente.setBebidas(bebidas);

                for (int l = 0; l < comidasJSON.length(); l++) {
                    JSONObject producto = comidasJSON.getJSONObject(l);
                    Comida comida = new Comida();
                    comida.setNombreProduto(producto.getString("nombreProducto"));
                    comida.setId(producto.getInt("id"));
                    comida.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                    comida.setStock(producto.getInt("stock"));
                    comida.setCantLlevada(producto.getInt("cantLlevada"));
                    comida.setDisponible(producto.getBoolean("isDisponible"));
                    comida.setGramos(BigDecimal.valueOf(producto.getDouble("gramos")).floatValue());
                    comida.setTipoProducto(producto.getInt("tipoProductos"));
                    comidas.add(comida);
                }
                cliente.setComidas(comidas);

                for (int k = 0; k < tecnologiasJSON.length(); k++) {
                    JSONObject producto = tecnologiasJSON.getJSONObject(k);
                    Tecnologia tecnologia = new Tecnologia();
                    tecnologia.setNombreProduto(producto.getString("nombreProducto"));
                    tecnologia.setId(producto.getInt("id"));
                    tecnologia.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                    tecnologia.setStock(producto.getInt("stock"));
                    tecnologia.setCantLlevada(producto.getInt("cantLlevada"));
                    tecnologia.setDisponible(producto.getBoolean("isDisponible"));
                    tecnologia.setElectrico(producto.getBoolean("isElectrico"));
                    tecnologias.add(tecnologia);
                }
                cliente.setTecnologias(tecnologias);
                float total = object.getInt("total");
                Factura factura = new Factura();
                factura.setComprador(cliente);
                factura.setTotal(total);
                facturas.add(factura);
            }
        } catch (JSONException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return facturas;
    }

    @Override
    public boolean agregar(Factura aux) {
        Factura factura = buscar(aux.getComprador().getDni());
        if (factura == null){
            facturas.add(aux);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + facturas;
    }


}
