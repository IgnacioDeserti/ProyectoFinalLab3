package Colecciones;

import Persona.app.Usuario;

import java.io.*;
import java.util.HashMap;

public class ColeccionUsuario implements I_Coleccion<Usuario> {

    HashMap<Integer, Usuario> usuariosHashMap;

    public ColeccionUsuario() {
        this.usuariosHashMap  = new HashMap<>();
    }

    public void cargarArchivo() {
        int i = 0;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuarios.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            while (i < usuariosHashMap.size()){
                objectOutputStream.writeObject(usuariosHashMap.get(i));
                i++;
            }

            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        int i = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                Usuario usuario = (Usuario) objectInputStream.readObject();
                usuariosHashMap.put(i, usuario);
                i++;
            }
        }catch (EOFException e) {
            System.out.println("");

        } catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override

    public boolean agregar(Usuario persona) {
        boolean rta = false;
        int i = contar();
        Usuario aux = buscar(persona.getDni());
        if (aux == null) {
            usuariosHashMap.put(i, persona);
            rta = true;
        }
        return rta;
    }

    @Override
    public boolean eliminar(int id) {
        boolean rta = false;
        Usuario aux = buscar(id);
        if (aux != null) {
            usuariosHashMap.remove(id);
            rta = true;
        }

        return rta;
    }

    @Override
    public Usuario buscar(int id) {
        Usuario encontrada = null;
        if (usuariosHashMap.containsKey(id)){
            encontrada = usuariosHashMap.get(id);
        }
        return encontrada;
    }

    @Override
    public String mostrar() {
        return usuariosHashMap.toString();
    }

    @Override
    public int contar() {
        return usuariosHashMap.size();
    }

    @Override
    public String toString() {
        return "" + usuariosHashMap;
    }
}
