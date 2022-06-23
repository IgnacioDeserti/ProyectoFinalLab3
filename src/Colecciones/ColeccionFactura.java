package Colecciones;

import Factura.Factura;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Tecnologia;
import Usuario.app.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

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
    public StringBuilder mostrar() {
        StringBuilder stringBuilder =  new StringBuilder();
        for (Factura factura : facturas){
            stringBuilder.append(factura.mostrar());
        }

        return stringBuilder;
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {
        try {
            JSONArray facturaJson = new JSONArray();

            Iterator<Factura> iterator = facturas.iterator();
            Factura factura;

            while (iterator.hasNext()){
                factura = iterator.next();
                JSONObject clienteJson = new JSONObject();
                JSONArray bebidasJson = new JSONArray();
                JSONArray comidasJson = new JSONArray();
                JSONArray tecnologiasJson = new JSONArray();
                ArrayList<Bebida> bebidas = factura.getComprador().getBebidas();
                ArrayList<Comida> comidas = factura.getComprador().getComidas();
                ArrayList<Tecnologia> tecnologias = factura.getComprador().getTecnologias();

                clienteJson.put("nombreYapellido", factura.getComprador().getNombreYapellido());
                clienteJson.put("dni", factura.getComprador().getDni());
                clienteJson.put("password", factura.getComprador().getPassword());
                clienteJson.put("idUsuario", factura.getComprador().getIdUsuario());;

                for (Bebida bebida : bebidas) {
                    JSONObject object = new JSONObject();
                    object.put("nombreProducto", bebida.getNombreProduto());
                    object.put("id", bebida.getId());
                    object.put("precio", bebida.getPrecio());
                    object.put("stock", bebida.getStock());
                    object.put("cantLlevada", bebida.getCantLlevada());
                    object.put("isDisponible", bebida.getDisponible());
                    object.put("ml", bebida.getMl());
                    bebidasJson.put(object);
                }
                clienteJson.put("bebidas", bebidasJson);

                for (Comida comida : comidas) {
                    JSONObject object = new JSONObject();
                    object.put("nombreProducto", comida.getNombreProduto());
                    object.put("id", comida.getId());
                    object.put("precio", comida.getPrecio());
                    object.put("stock", comida.getStock());
                    object.put("cantLlevada", comida.getCantLlevada());
                    object.put("isDisponible", comida.getDisponible());
                    object.put("gramos", comida.getGramos());
                    object.put("tipoProducto", comida.getTipoProducto());
                    comidasJson.put(object);
                }
                clienteJson.put("comidas", comidasJson);

                for (Tecnologia tecnologia : tecnologias) {
                    JSONObject object = new JSONObject();
                    object.put("nombreProducto", tecnologia.getNombreProduto());
                    object.put("id", tecnologia.getId());
                    object.put("precio", tecnologia.getPrecio());
                    object.put("stock", tecnologia.getStock());
                    object.put("cantLlevada", tecnologia.getCantLlevada());
                    object.put("isDisponible", tecnologia.getDisponible());
                    object.put("isElectrico", tecnologia.isElectrico());
                    tecnologiasJson.put(object);
                }
                clienteJson.put("tecnologias", tecnologiasJson);

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("comprador", clienteJson);
                jsonObject.put("total", factura.getTotal());

                facturaJson.put(jsonObject);

                JsonUtiles.grabar(facturaJson);
            }
        }catch (JSONException e){

        }

    }

    @Override
    public ArrayList<Factura> leerArchivo(String nombreArchivo) {
        String contenido = JsonUtiles.leer("factura.json");
        try {
            JSONArray array = new JSONArray(contenido);
            for (int i = 0; i < array.length(); i++) {
                Cliente cliente = new Cliente();
                JSONObject object = array.getJSONObject(i);
                JSONObject persona = object.getJSONObject("comprador");
                JSONArray tecnologiasJSON = persona.getJSONArray("tecnologias");
                JSONArray comidasJSON = persona.getJSONArray("comidas");
                JSONArray bebidasJSON = persona.getJSONArray("bebidas");
                ArrayList<Bebida> bebidas = new ArrayList<>();
                ArrayList<Comida> comidas = new ArrayList<>();
                ArrayList<Tecnologia> tecnologias = new ArrayList<>();
                cliente.setNombreYapellido(persona.getString("nombreYapellido"));
                cliente.setDni(persona.getInt("dni"));
                cliente.setIdUsuario(persona.getInt("idUsuario"));
                cliente.setPassword(persona.getString("password"));
                for (int k = 0; k < bebidasJSON.length(); k++) {
                    JSONObject producto = bebidasJSON.getJSONObject(k);
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
                    comida.setTipoProducto(producto.getInt("tipoProducto"));
                    comidas.add(comida);
                }
                cliente.setComidas(comidas);

                for (int t = 0; t < tecnologiasJSON.length(); t++) {
                    JSONObject producto = tecnologiasJSON.getJSONObject(t);
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
                double total = object.getDouble("total");
                Factura factura = new Factura();
                factura.setComprador(cliente);
                factura.setTotal((float) total);
                facturas.add(factura);
            }
        }
        catch (JSONException e) {
            e.getMessage();
        }

        return facturas;
    }

    @Override
    public boolean agregar(Factura aux) {
        if (aux != null){
            facturas.add(aux);
            return true;
        }
        return false;
    }

    //SETTERS---------------------------------------------------

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    //GETTERS--------------------------------------------------


    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public String toString() {
        return "ColeccionFactura{" +
                "facturas=" + facturas +
                '}';
    }
}
