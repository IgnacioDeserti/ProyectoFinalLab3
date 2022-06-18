package Usuario.app;

import Colecciones.ColeccionUsuario;
import Colecciones.Deposito;
import Excepciones.EliminarExcepcion;
import Excepciones.ProductoExistenteExcepcion;
import Producto.app.Producto;

import java.io.*;

public class Admin extends Usuario implements Serializable{

    private int codigoSecreto;

    public Admin(String nombreYapellido, int dni, String password, int codigoSecreto) {
        super(nombreYapellido, dni, password);
        this.codigoSecreto = codigoSecreto;
    }

    public Admin() {

    }

    public boolean registro(Usuario usuario) {
        return false;
    }

    public String listar() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString()+
                "Codigo Secreto: " + codigoSecreto +"\n\n";
    }


    public boolean agregarProducto(int op, Producto producto) throws ProductoExistenteExcepcion {
        Deposito deposito = new Deposito();
        String nombreArchi = elegirDeposito(op);
        boolean aux = false;

        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        producto.setId(deposito.contar());
        aux = deposito.agregar(producto);
        if (aux == false){
            throw new ProductoExistenteExcepcion("");
        }
        deposito.cargarArchivo(nombreArchi);


        return aux;
    }

    public boolean eliminarProducto(String nombreArchi, int id) throws EliminarExcepcion {
        Deposito deposito = new Deposito();
        boolean rta = false;

        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));
        rta = deposito.eliminar(id);
        deposito.cargarArchivo(nombreArchi);

        if (rta == false){
            throw new EliminarExcepcion("Error al eliminar");
        }


        return rta;
    }

    public StringBuilder verUsuarios(){
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();

        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));

        return coleccionUsuario.mostrar();
    }
}
