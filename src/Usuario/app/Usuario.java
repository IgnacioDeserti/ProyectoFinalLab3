package Usuario.app;

import Colecciones.Deposito;
import Excepciones.ArchivoIncorrectoExcepcion;
import Excepciones.IdIncorrectoExcepcion;
import Producto.app.Producto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombreYapellido;
    private int dni;
    private String password;
    private int idUsuario;
    private static int contador;


    public Usuario(String nombreYapellido, int dni, String password) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.password = password;
        this.idUsuario = contador;
        contador++;
    }

    public Usuario() {
    }

    public String mostrar() {
        return "DNI Usuario:" + dni +  " \nNombre y Apellido: " + nombreYapellido + "\nId usuario: " + idUsuario + "\n";
    }

    //GETTERS---------------------------------------------------------------
    public int getDni() {
        return dni;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public String getPassword() {
        return password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreYapellido='" + nombreYapellido + '\'' +
                ", dni=" + dni +
                ", password='" + password + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }

    //SETTERS---------------------------------------------------------------

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setContador(int contador) {
        Usuario.contador = contador;
    }

    @Override
    public int hashCode() {
        int result = nombreYapellido != null ? nombreYapellido.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String elegirDeposito(int op){
        String nombreArchi = null;
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

    public StringBuilder mostrarDeposito(int op)  {
        Deposito deposito = new Deposito();
        String nombreArchi = elegirDeposito(op);
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchi));

        return deposito.mostrar();
    }

    public Producto seleccionoProducto(int id, String nombreArchivo) throws IdIncorrectoExcepcion {

        Deposito deposito = new Deposito();
        deposito.setProductoHashSet(deposito.leerArchivo(nombreArchivo));
        Producto aux = deposito.buscar(id);

        if (aux ==  null){
            throw new IdIncorrectoExcepcion("");
        }

        return aux;
    }

}
