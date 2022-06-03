package com.app;

import Colecciones.Deposito;
import Colecciones.ColeccionUsuario;
import InterfacesGraficas.app.PaginaComida;
import InterfacesGraficas.app.PaginaGeneral;
import InterfacesGraficas.app.PaginaRegistro;
import InterfacesGraficas.app.PantallaInicio;
import Persona.app.Admin;
import Persona.app.Cliente;
import Persona.app.Empleado;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Producto;
import Producto.app.Tecnologia;

import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        Deposito deposito = new Deposito();
        PantallaInicio pantallaInicio = new PantallaInicio();
        PaginaRegistro paginaRegistro = new PaginaRegistro();
        PaginaComida paginaComida = new PaginaComida();
        PaginaGeneral paginaGeneral = new PaginaGeneral();

        /*pantallaInicio.setBounds(0,0,400,400);
        pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
        pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
        pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.*/

        /*paginaRegistro.setBounds(0,0,600,600);
        paginaRegistro.setVisible(true);
        paginaRegistro.setLocationRelativeTo(null);
        paginaRegistro.setResizable(false);*/

        /*paginaComida.setBounds(0,0,600,600);
        paginaComida.setVisible(true);
        paginaComida.setLocationRelativeTo(null);
        paginaComida.setResizable(false);*/

        /*paginaGeneral.setBounds(0,0,600,600);
        paginaGeneral.setVisible(true);
        paginaGeneral.setLocationRelativeTo(null);*/

        /*
        coleccionUsuario.agregar(new Cliente("Ignacio Deserti", 44667880, "Papasito123"));
        coleccionUsuario.agregar(new Cliente("Ignacio Tosini", 44460448, "zurdosiete"));
        coleccionUsuario.agregar(new Admin("Lionel Messi", 1, "Jefe", "SoyDiosnel10", 10));
        coleccionUsuario.agregar(new Empleado("Gabriel Chaldu", 27850418, "madafaker", "Porofesor"));
        coleccionUsuario.cargarArchivo();


        deposito.agregar(new Comida("Fideos", 14.99f, 2, 0,5, 12));
        deposito.agregar(new Comida("Hamburguesa", 15.99f, 1, 0,6, 12));
        deposito.agregar(new Tecnologia("Televisor", 299.99f, 0, 2, true));
        deposito.agregar(new Bebida("Coca cola", 10.99f,  0,3, 150));
        deposito.cargarArchivo();
         */

        /*coleccionUsuario.leerArchivo("a");
        System.out.println(coleccionUsuario.mostrar());
        //System.out.println("\nHay " + coleccionUsuario.contar() + " usuarios");

        deposito.leerArchivo("a");
        System.out.println(deposito.mostrar());

         */


        Admin admin = new Admin("Lionel Messi", 1, "Jefe", "SoyDiosnel10", 10);

        String nombreArchi = admin.elegirArchi(2);

        Producto producto = admin.seleccionoProducto(2, nombreArchi);

        System.out.println(producto.toString());

        producto = admin.modificoProducto(producto, "Tele");

        System.out.println(producto.toString());



        teclado.close();
    }
}
