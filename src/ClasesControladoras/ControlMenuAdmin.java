package ClasesControladoras;

import Colecciones.ColeccionFactura;
import Colecciones.ColeccionUsuario;
import Colecciones.Deposito;
import Excepciones.*;
import Factura.Factura;
import Usuario.app.Admin;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;

import javax.swing.*;
import java.io.Serializable;
import java.util.Scanner;

public class ControlMenuAdmin implements Serializable {

    private Admin admin;
    static Scanner teclado;

    public ControlMenuAdmin(Admin admin) {
        this.admin = admin;
    }

    public void menuGralAdmin() {

        teclado = new Scanner(System.in);
        System.out.println("Bienvenido, " + admin.getNombreYapellido() + ", que le trae por aca?");
        int opcion = 0;

        do {
            System.out.println("""
                \nIngrese
                1 para ver el deposito general
                2 para agregar un producto
                3 para modificar un producto
                4 para eliminar un producto
                5 para ver los usuarios existentes
                6 para ver las facturas existentes
                7 para ver facturas por usuario
                8 para cambiar la password
                9 para cambiar el codigo secreto
                0 para salir del programa\n\n""");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {
                    funcionVerDeposito();
                }
                case 2 -> {
                    funcionAgregarProducto();
                }
                case 3 -> {
                    modificoYGuardoProducto();
                }
                case 4 -> {
                    eliminoProducto();
                }
                case 5 -> {
                    System.out.println(admin.verUsuarios());
                }
                case 6 -> {
                    muestroFacturas();
                }
                case 7 -> {
                    System.out.println(muestroFacturasPorUsuario());
                }
                case 8 -> {
                    teclado.nextLine();
                    cambioPasswordAdmin();
                }
                case 9 -> {
                    cambioCodigoSecreto();
                }
                case 0 -> {
                    System.out.println("Hasta luego, capitan!!!");
                }
            }
        }while (opcion != 0);

    }

    public int seleccionoArchi() throws ArchivoIncorrectoExcepcion{
        System.out.println("""
                            \n\n
                            Ingrese
                            1 para elegir el deposito de comida
                            2 para elegir el deposito de bebida
                            3 para elegir el deposito de tecnologia""");
        teclado.nextLine();
        int op = teclado.nextInt();

        if (op > 3 || op < 0){
            throw new ArchivoIncorrectoExcepcion("");
        }

        return op;
    }

    public void funcionVerDeposito() {
        int op = 0;
        try {
            op = seleccionoArchi();
            System.out.println(admin.mostrarDeposito(op));
        } catch (ArchivoIncorrectoExcepcion e) {
            System.out.println(e.getMessage());
            funcionVerDeposito();
        }
    }

    public Producto creoProducto(int op) throws ArchivoIncorrectoExcepcion{
        Producto producto = null;
        switch(op) {
            case 1: {
                producto = creoComida();
            } break;
            case 2: {
                producto = creoBebida();
                break;
            }
            case 3: {
                producto = creoTecnologia();
                break;
            }
            default: {
                throw new ArchivoIncorrectoExcepcion("");
            }
        }

        return producto;
    }

    public Comida creoComida(){
        System.out.println("Ingrese el nombre del producto");
        teclado.nextLine();
        String nombreProducto = teclado.nextLine();
        System.out.println("Ingrese el precio del producto");
        float precioProducto = teclado.nextFloat();
        while (precioProducto < 1){
            System.out.println("Precio invalido, ingrese otro");
            precioProducto = teclado.nextFloat();
        }
        System.out.println("Ingrese el stock del producto");
        int stock = teclado.nextInt();
        while (stock < 0){
            System.out.println("Stock invalido, ingrese otro");
            stock = teclado.nextInt();
        }
        System.out.println("Ingrese el tipo de producto (1 frio | 2 seco)");
        int tipoProducto = teclado.nextInt();
        while (tipoProducto != 1 && tipoProducto != 2){
            System.out.println("Tipo de producto invalido, ingrese otro");
            tipoProducto = teclado.nextInt();
        }
        System.out.println("Ingrese los gramos del producto");
        float gramos = teclado.nextFloat();
        while (gramos < 1){
            System.out.println("Gramos invalidos, ingrese otro valor");
            gramos = teclado.nextFloat();
        }

        Comida comida = new Comida(nombreProducto, precioProducto, tipoProducto, stock, gramos);

        return comida;
    }

    public Bebida creoBebida(){
        System.out.println("Ingrese el nombre del producto");
        teclado.nextLine();
        String nombreProducto = teclado.nextLine();
        System.out.println("Ingrese el precio del producto");
        float precioProducto = teclado.nextFloat();
        while (precioProducto < 1){
            System.out.println("Precio invalido, ingrese otro");
            precioProducto = teclado.nextFloat();
        }
        System.out.println("Ingrese el stock del producto");
        int stock = teclado.nextInt();
        while (stock < 0){
            System.out.println("Stock invalido, ingrese otro");
            stock = teclado.nextInt();
        }
        System.out.println("Ingrese los ml del producto");
        int ml = teclado.nextInt();
        while (ml < 1){
            System.out.println("Ml invalidos, ingrese otro");
            ml = teclado.nextInt();
        }

        Bebida bebida = new Bebida(nombreProducto, precioProducto, stock, ml);

        return bebida;
    }

    public Tecnologia creoTecnologia(){
        System.out.println("Ingrese el nombre del producto");
        teclado.nextLine();
        String nombreProducto = teclado.nextLine();
        System.out.println("Ingrese el precio del producto");
        float precioProducto = teclado.nextFloat();
        while (precioProducto < 1){
            System.out.println("Precio invalido, ingrese otro");
            precioProducto = teclado.nextFloat();
        }
        System.out.println("Ingrese el stock del producto");
        int stock = teclado.nextInt();
        while (stock < 0){
            System.out.println("Stock invalido, ingrese otro");
            stock = teclado.nextInt();
        }
        System.out.println("Si el producto es electrico ingrese si, en caso contrario ingrese no");
        teclado.nextLine();
        String aux = teclado.nextLine();
        boolean isElectrico = aux.equals("si");

        Tecnologia tecnologia = new Tecnologia(nombreProducto, precioProducto, stock, isElectrico);

        System.out.println(tecnologia.mostrar());

        return tecnologia;
    }

    public void funcionAgregarProducto(){
        try {
            int op = seleccionoArchi();
            Producto producto = creoProducto(op);
            boolean aux = admin.agregarProducto(op, producto);
            if (aux) {
                System.out.println("Genial! Los cambios se veran modificados al acceder al deposito de nuevo");
            }
        } catch (ArchivoIncorrectoExcepcion e) {
            System.out.println(e.getMessage());
            funcionAgregarProducto();
        } catch (ProductoExistenteExcepcion e) {
            System.out.println(e.getMessage());
            funcionAgregarProducto();
        }
    }

    public Comida modificoAtributoComida(Comida comida){
        System.out.println("""
                       Ingrese
                       1 para modificar el nombre
                       2 para modificar el precio
                       3 para modificar el stock
                       4 para modificar el tipo de producto (1 frio | 2 seco)
                       5 para modificar los gramos
                        """);
        int op = teclado.nextInt();
        switch(op)
            {
                case 1: {
                    System.out.println("Ingrese el nombre del producto");
                    teclado.nextLine();
                    String nombreProducto = teclado.nextLine();
                    comida.setNombreProduto(nombreProducto);
                } break;
                case 2: {
                    System.out.println("Ingrese el precio del producto");
                    float precioProducto = teclado.nextFloat();
                    while (precioProducto < 1){
                        System.out.println("Precio invalido, por favor ingrese otro");
                        precioProducto = teclado.nextFloat();
                    }
                    comida.setPrecio(precioProducto);
                    break;
                }
                case 3: {
                    System.out.println("Ingrese el stock del producto");
                    int stock = teclado.nextInt();
                    while (stock < 0){
                        System.out.println("Stock invalido, ingrese otro");
                        stock = teclado.nextInt();
                    }
                    comida.setStock(stock);
                    if (comida.getStock() > 0){
                        comida.setDisponible(true);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Ingrese el tipo de producto (1 frio | 2 seco)");
                    int tipoProducto = teclado.nextInt();
                    while (tipoProducto != 1 && tipoProducto != 2){
                        System.out.println("Tipo de producto invalido, ingrese uno nuevo");
                        tipoProducto = teclado.nextInt();
                    }
                    comida.setTipoProducto(tipoProducto);
                    break;
                }
                case 5: {
                    System.out.println("Ingrese los gramos del producto");
                    float gramos = teclado.nextFloat();
                    while (gramos < 1){
                        System.out.println("Gramos invalidos, ingrese otro valor");
                        gramos = teclado.nextFloat();
                    }
                    comida.setGramos(gramos);
                    break;
                }
                default: {
                    System.out.println("Ingrese una opcion valida");
                    modificoAtributoComida(comida);
                }

            };

        return comida;
    }

    public Bebida modificoAtributoBebida(Bebida bebida) {
        System.out.println("""
                Ingrese
                1 para modificar el nombre
                2 para modificar el precio
                3 para modificar el stock
                4 para modificar los ml
                 """);
        int op = teclado.nextInt();
        switch (op) {
                case 1: {
                    System.out.println("Ingrese el nombre del producto");
                    teclado.nextLine();
                    String nombreProducto = teclado.nextLine();
                 bebida.setNombreProduto(nombreProducto);
                }
                break;
                case 2: {
                    System.out.println("Ingrese el precio del producto");
                    float precioProducto = teclado.nextFloat();
                    while (precioProducto < 1){
                        System.out.println("Precio invalido, ingrese otro");
                        precioProducto = teclado.nextFloat();
                    }
                    bebida.setPrecio(precioProducto);
                    break;
                }
                case 3: {
                    System.out.println("Ingrese el stock del producto");
                    int stock = teclado.nextInt();
                    while (stock < 0){
                        System.out.println("Stock invalido, ingrese otro");
                        stock = teclado.nextInt();
                    }
                    bebida.setStock(stock);
                    if (bebida.getStock() > 0){
                        bebida.setDisponible(true);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Ingrese los ml del prooducto");
                    int ml = teclado.nextInt();
                    while (ml < 1){
                        System.out.println("Ml invalidos, ingrese otro");
                        ml = teclado.nextInt();
                    }
                    bebida.setMl(ml);
                    break;
                }
            default: {
                System.out.println("Ingrese una opcion valida");
                modificoAtributoBebida(bebida);
            }
        }
            return bebida;
    }

    public Tecnologia modificoAtributoTecnologia(Tecnologia tecnologia) {
        System.out.println("""
                Ingrese
                1 para modificar el nombre
                2 para modificar el precio
                3 para modificar el stock
                4 para modificar si es electrico
                 """);
        int op = teclado.nextInt();
        switch (op) {
            case 1: {
                System.out.println("Ingrese el nombre del producto");
                teclado.nextLine();
                String nombreProducto = teclado.nextLine();
                tecnologia.setNombreProduto(nombreProducto);
            }
            break;
            case 2: {
                System.out.println("Ingrese el precio del producto");
                float precioProducto = teclado.nextFloat();
                while (precioProducto < 1){
                    System.out.println("Precio invalido, ingrese otro");
                    precioProducto = teclado.nextFloat();
                }
                tecnologia.setPrecio(precioProducto);
                break;
            }
            case 3: {
                System.out.println("Ingrese el stock del producto");
                int stock = teclado.nextInt();
                while (stock < 0){
                    System.out.println("Stock invalido, ingrese otro");
                    stock = teclado.nextInt();
                }
                tecnologia.setStock(stock);
                if (tecnologia.getStock() > 0){
                    tecnologia.setDisponible(true);
                }
                break;
            }
            case 4: {
                System.out.println("Se cambiara automaticamente de si a no, o viceversa");
                if (tecnologia.isElectrico()) {
                    tecnologia.setElectrico(false);
                } else {
                    tecnologia.setElectrico(true);
                }
                break;
            }
            default: {
                System.out.println("Ingrese una opcion valida");
                modificoAtributoTecnologia(tecnologia);
            }
        }

            return tecnologia;
    }

    public Producto modificoProducto(Producto producto){

        if (producto instanceof Comida){
            producto = modificoAtributoComida((Comida) producto);
        }
        else if (producto instanceof Bebida){
            producto = modificoAtributoBebida((Bebida) producto);
        }
        else if (producto instanceof Tecnologia){
            producto = modificoAtributoTecnologia((Tecnologia) producto);
        }

        return producto;
    }

    public void modificoYGuardoProducto(){
        int op = 0;
        int id = 0;
        Deposito deposito = new Deposito();
        try {
            op = seleccionoArchi();
            String nombreArchi = admin.elegirDeposito(op);
            System.out.println(admin.mostrarDeposito(op));
            System.out.println("\nIngrese el id del producto que quiere modificar");
            id = teclado.nextInt();
            Producto producto = admin.seleccionoProducto(id, admin.elegirDeposito(op));
            System.out.println(producto.mostrar() + "\n");
            deposito.eliminoParaReemplazar(id, nombreArchi);
            producto = modificoProducto(producto);
            deposito.modificoArchi(admin.elegirDeposito(op), producto);
            System.out.println("Producto modificado! Se veran los cambios al acceder al deposito de nuevo");
        } catch (ArchivoIncorrectoExcepcion e) {
            System.out.println(e.getMessage());
            modificoYGuardoProducto();
        } catch (IdIncorrectoExcepcion e) {
            System.out.println(e.getMessage());
            modificoYGuardoProducto();
        }

    }

    public void eliminoProducto(){
        int op = 0;
        try {
            op = seleccionoArchi();
            System.out.println(admin.mostrarDeposito(op));
            System.out.println("\nIngrese el id del producto que quiere eliminar");
            int id = teclado.nextInt();
            boolean rta = admin.eliminarProducto(admin.elegirDeposito(op), id);
            if (rta){
                System.out.println("Producto eliminado! Se veran los cambios al acceder al deposito de nuevo");
            }
        } catch (ArchivoIncorrectoExcepcion e) {
            System.out.println(e.getMessage());
            eliminoProducto();
        } catch (EliminarExcepcion e) {
            System.out.println(e.getMessage());
            eliminoProducto();
        }
    }

    public void muestroFacturas(){
        ColeccionFactura coleccionFactura = new ColeccionFactura();
        coleccionFactura.setFacturas(coleccionFactura.leerArchivo("factura.json"));
        System.out.println(coleccionFactura.mostrar());
    }

    public StringBuilder muestroFacturasPorUsuario(){
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(admin.verUsuarios());
        ColeccionFactura coleccionFactura = new ColeccionFactura();
        coleccionFactura.setFacturas(coleccionFactura.leerArchivo("factura.json"));
        System.out.println("Ingrese el dni del usuario el cual quiere ver una factura");
        int dni = teclado.nextInt();
        for (Factura factura : coleccionFactura.getFacturas()){
            if (factura.getComprador().getDni() == dni){
                stringBuilder.append(factura.mostrar());
            }
        }
        if (stringBuilder.isEmpty()){
            System.out.println("El usuario no existe o no ha realizado compras");
        }

        return stringBuilder;
    }

    public void cambioPasswordAdmin(){
        try {
            System.out.println("Ingrese nueva password");
            String password = teclado.nextLine();
            password = admin.cambioPassword(password);
            ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
            coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
            coleccionUsuario.getUsuariosHashMap().get(admin.getDni()).setPassword(password);
            coleccionUsuario.cargarArchivo("usuarios.bin");
            System.out.println("Password cambiada con exito!!");
        } catch (PasswordInvalidoException e) {
            System.out.println(e.getMessage());
            cambioPasswordAdmin();
        }
    }

    public void cambioCodigoSecreto(){
        System.out.println("Ingrese nuevo codigo secreto");
        int codigo = teclado.nextInt();
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
        admin.setCodigoSecreto(codigo);
        coleccionUsuario.getUsuariosHashMap().replace(admin.getDni(), admin);
        coleccionUsuario.cargarArchivo("usuarios.bin");
    }
}
