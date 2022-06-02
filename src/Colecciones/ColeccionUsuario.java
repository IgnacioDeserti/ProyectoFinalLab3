package Colecciones;

import Persona.app.Usuario;
import Producto.app.Producto;

import java.io.*;
import java.util.HashSet;
import java.util.Map;

public class ColeccionUsuario implements I_Coleccion<Usuario> {

    HashSet<Usuario> usuariosHashSet;

    public ColeccionUsuario() {
        this.usuariosHashSet  = new HashSet<>();
    }

    public void cargarArchivo() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuarios.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Usuario usuario : usuariosHashSet) {
                objectOutputStream.writeObject(usuario);
            }

            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                usuariosHashSet.add((Usuario) objectInputStream.readObject());
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
        Usuario aux = buscar(persona.getDni());
        if (aux == null) {
            usuariosHashSet.add(persona);
            rta = true;
        }
        return rta;
    }

    @Override
    public boolean eliminar(int dni) {
        boolean rta = false;
        Usuario aux = buscar(dni);
        if (aux != null) {
            usuariosHashSet.remove(aux);
            rta = true;
        }

        return rta;
    }

    @Override
    public Usuario buscar(int dni) {
        Usuario encontrada = null;
        for (Usuario p : usuariosHashSet) {
            if (p.getDni() == dni) {
                encontrada = p;
            }
        }
        return encontrada;
    }

    @Override
    public String mostrar() {
        return usuariosHashSet.toString();
    }

    @Override
    public int contar() {
        return usuariosHashSet.size();
    }

    @Override
    public String toString() {
        return "" + usuariosHashSet;
    }
}
