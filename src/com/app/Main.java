package com.app;

import ClasesControladoras.ControlMenuAdmin;
import ClasesControladoras.ControlMenuCliente;
import ClasesControladoras.InicioSesion;
import Colecciones.Deposito;
import Colecciones.ColeccionUsuario;
import InterfacesGraficas.app.PaginaComida;
import InterfacesGraficas.app.PaginaGeneral;
import InterfacesGraficas.app.PantallaInicio;
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

        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        Deposito deposito = new Deposito();
        PantallaInicio pantallaInicio = new PantallaInicio();


        /*pantallaInicio.setBounds(0,0,400,400);
        pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
        pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
        pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.*/

        //InicioSesion inicioSesion = new InicioSesion();
        //inicioSesion.menuInicio();

        //ControlMenuAdmin controlMenuAdmin = new ControlMenuAdmin(new Admin("Lionel Messi", 1, "SoyDiosnel10",10));
        //controlMenuAdmin.menuGralAdmin();


        ControlMenuCliente menuCliente = new ControlMenuCliente(new Cliente("Mateo Braganza", 43741503, "123"));
        menuCliente.menuCliente();

        /*Deposito deposito1 = new Deposito();
        deposito1.agregar(new Comida("Hamburguesas Paty", 49.99f, 1, 20, 300));
        //deposito1.agregar(new Bebida("Coca Cola", 49.99f, 20, 150));
        //deposito1.agregar(new Tecnologia("Televisor LG", 49.99f, 5, true));
        System.out.println(deposito1.mostrar());
        deposito1.cargarArchivo("comida.bin");
         */




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
