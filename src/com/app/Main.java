package com.app;

import Colecciones.Deposito;
import Colecciones.ColeccionUsuario;
import Persona.app.Admin;
import Persona.app.Cliente;
import Persona.app.Usuario;

import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        Deposito deposito = new Deposito();
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


        coleccionUsuario.leerArchivo();
        System.out.println(coleccionUsuario.toString());
        //System.out.println("\nHay " + coleccionUsuario.contar() + " usuarios");

        deposito.leerArchivo();
        System.out.println(deposito.toString());




        teclado.close();
    }



}
