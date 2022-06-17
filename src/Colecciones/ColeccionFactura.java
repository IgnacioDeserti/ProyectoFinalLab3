package Colecciones;

import Factura.Factura;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Tecnologia;
import Usuario.app.Cliente;

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
    public StringBuilder mostrar() {
        StringBuilder stringBuilder =  new StringBuilder();
        for (Factura factura : facturas){
            stringBuilder.append(factura.mostrar());
        }

        return stringBuilder;
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {
        JSONArray jsonArray = new JSONArray();
        System.out.println(facturas.toString());
        jsonArray.put(facturas);
        System.out.println(jsonArray.toString());
        JsonUtiles.grabar(jsonArray);
    }

    @Override
    public ArrayList<Factura> leerArchivo(String nombreArchivo) {
        String contenido = JsonUtiles.leer("factura.json");
        try {
            JSONArray array = new JSONArray(contenido);

            for (int i = 0; i < array.length(); i++) {
                Cliente cliente = new Cliente();
                JSONArray jsonArray = array.getJSONArray(i);
                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject object = jsonArray.getJSONObject(i);
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
                        //bebida.setNombreProduto(producto.getString("nombreProducto"));
                        bebida.setId(producto.getInt("id"));
                        bebida.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                        bebida.setStock(producto.getInt("stock"));
                        bebida.setCantLlevada(producto.getInt("cantLlevada"));
                        bebida.setMl(producto.getInt("ml"));
                        bebidas.add(bebida);
                    }
                    cliente.setBebidas(bebidas);

                    for (int l = 0; l < comidasJSON.length(); l++) {
                        JSONObject producto = comidasJSON.getJSONObject(l);
                        Comida comida = new Comida();
                        //comida.setNombreProduto(producto.getString("nombreProducto"));
                        comida.setId(producto.getInt("id"));
                        comida.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                        comida.setStock(producto.getInt("stock"));
                        comida.setCantLlevada(producto.getInt("cantLlevada"));
                        //comida.setGramos(BigDecimal.valueOf(producto.getDouble("gramos")).floatValue());
                        comidas.add(comida);
                    }
                    cliente.setComidas(comidas);

                    for (int t = 0; t < tecnologiasJSON.length(); t++) {
                        JSONObject producto = tecnologiasJSON.getJSONObject(t);
                        Tecnologia tecnologia = new Tecnologia();
                        //tecnologia.setNombreProduto(producto.getString("nombreProducto"));
                        tecnologia.setId(producto.getInt("id"));
                        tecnologia.setPrecio(BigDecimal.valueOf(producto.getDouble("precio")).floatValue());
                        tecnologia.setStock(producto.getInt("stock"));
                        tecnologia.setCantLlevada(producto.getInt("cantLlevada"));
                        tecnologia.setElectrico(producto.getBoolean("electrico"));
                        tecnologias.add(tecnologia);
                    }
                    cliente.setTecnologias(tecnologias);
                    float total = object.getInt("total");
                    Factura factura = new Factura();
                    factura.setComprador(cliente);
                    factura.setTotal(total);
                    facturas.add(factura);
                }
            }
        } catch (JSONException e) {
            e.getMessage();
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
