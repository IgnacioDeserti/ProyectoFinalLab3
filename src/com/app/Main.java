package com.app;

import Colecciones.ListaPersona;
import Muebles.app.Gondola;
import Persona.app.Cliente;
import Persona.app.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        System.out.println("A ver si se cambio");


        ArrayList<Cliente> listaPersonas = new ArrayList<Cliente>();

        listaPersonas.add(new Cliente("Hola", 123));



        teclado.close();
    }



}
