package com.app;

import Persona.app.Cliente;
import Persona.app.Usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Cliente("Ignacio Tosini", 44460448, "zurdosiete"));

        String contenido = "";
        int aux;

        try(FileWriter fileWriter = new FileWriter("miArchi.txt")) {
            fileWriter.write(listaUsuarios.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


        try(FileReader fileReader = new FileReader("miArchi.txt")) {

            aux = fileReader.read();
            while(aux != -1){
                contenido = contenido + (char)aux;
                try {
                    aux = fileReader.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CONTENIDO: " + contenido);


        teclado.close();
    }



}
