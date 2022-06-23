package com.app;

import ClasesControladoras.ControlMenuAdmin;
import ClasesControladoras.ControlMenuCliente;
import ClasesControladoras.InicioSesion;
import Colecciones.ColeccionFactura;
import Colecciones.Deposito;
import Colecciones.ColeccionUsuario;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Tecnologia;
import Usuario.app.Admin;
import Usuario.app.Cliente;

import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public static void main(String[] args){
        teclado = new Scanner(System.in);

        /*ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        Deposito deposito = new Deposito();
        PantallaInicio pantallaInicio = new PantallaInicio();
        PaginaDeCompra paginaDeCompra = new PaginaDeCompra();
         */


        /*pantallaInicio.setBounds(0,0,400,400);
        pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
        pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
        pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.*/

        /*paginaDeCompra.setBounds(0,0,600,600);
        paginaDeCompra.setVisible(true); //Si queres que se vea true, si no false.
        paginaDeCompra.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
        paginaDeCompra.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.

         */

        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.menuInicioSesion();

        //ControlMenuAdmin controlMenuAdmin = new ControlMenuAdmin(new Admin("Lionel Messi", 1, "SoyDiosnel10",10));
        //controlMenuAdmin.menuGralAdmin();


        //ControlMenuCliente menuCliente = new ControlMenuCliente(new Cliente("Ignacio Deserti", 44667880, "123"));
        //menuCliente.menuCliente();

        /*ColeccionFactura coleccionFactura = new ColeccionFactura();
        coleccionFactura.setFacturas(coleccionFactura.leerArchivo("factura.json"));
        System.out.println(coleccionFactura.mostrar());
         */






        Deposito deposito1 = new Deposito();
        /*deposito1.agregar(new Comida("Hamburguesas Tapy", 49.99f, 1, 20, 300));
        deposito1.agregar(new Comida("Fideos Marisol", 19.99f, 2, 20, 100));
        deposito1.agregar(new Comida("Nuggets Granja de la luna", 14.99f, 1, 20, 150));
        deposito1.agregar(new Comida("Salchichas LeBron James VIP", 6.66f, 1, 20, 200));

         */
        /*deposito1.agregar(new Bebida("Moca Cola D&J", 49.99f, 20, 150));
        deposito1.agregar(new Bebida("Guepardex", 19.99f, 20, 150));
        deposito1.agregar(new Bebida("Cerveza Martin Palermo", 29.99f, 20, 150));
        deposito1.agregar(new Bebida("Voskita Esmirlo", 99.99f, 20, 200));

         */
        /*deposito1.agregar(new Tecnologia("Televisor ELE SHI", 49.99f, 5, true));
        deposito1.agregar(new Tecnologia("Heladera Patricio", 399.99f, 5, true));
        deposito1.agregar(new Tecnologia("Orange iCellphone 19 ULTRA OMEGA", 2999.99f, 5, false));
        deposito1.agregar(new Tecnologia("Televisor NOSY", 99.99f, 5, true));

         */
        //System.out.println(deposito1.mostrar());
        //deposito1.cargarArchivo("bebida.bin");




        ColeccionUsuario coleccionUsuario1 = new ColeccionUsuario();
        //coleccionUsuario1.setUsuariosHashMap(coleccionUsuario1.leerArchivo("usuarios.bin"));
        //System.out.println(coleccionUsuario1.mostrar());

        /*coleccionUsuario1.agregar(new Admin("Lionel Messi", 1, "SoyDiosnel10", 1));
        coleccionUsuario1.agregar(new Cliente("Ignacio Deserti", 44667880, "Daleboka123"));
        coleccionUsuario1.agregar(new Cliente("Ignacio Tosini", 44456789, "Zurdosie7e"));
        System.out.println(coleccionUsuario1.mostrar());
        coleccionUsuario1.cargarArchivo("usuarios.bin");
         */

        //coleccionUsuario1.setUsuariosHashMap(coleccionUsuario1.leerArchivo("usuarios.bin"));
        //System.out.println(coleccionUsuario1.mostrar());



        teclado.close();
    }
}
