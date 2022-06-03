package Persona.app;

import Producto.app.Producto;

import java.io.*;
import java.util.ArrayList;

public class Cliente extends Usuario implements I_MetodosPersona, Serializable {

    private int idCliente;
    private ArrayList<Producto> changuito;
    private static int capacidad = 50;

    public Cliente(String nombreYapellido, int dni, String password) {
        super(nombreYapellido, dni, password);
        this.idCliente = idCliente + 1;
        this.changuito = new ArrayList<>();
    }


    @Override
    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nId Cliente: " + idCliente;
    }

    public Cliente registro(int dni, String password){
        Usuario usuario = null;
        int flag = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (flag == 0) {
               usuario = (Usuario) objectInputStream.readObject();
               if (usuario.equals(dni, password)){
                   flag = 1;
               }
            }
        }catch (EOFException e) {
            System.out.println("");

        } catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public



}
