package Colecciones;

import Usuario.app.Usuario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ColeccionUsuario implements I_Coleccion<Usuario> {

    HashMap<Integer, Usuario> usuariosHashMap;

    public ColeccionUsuario() {
        this.usuariosHashMap  = new HashMap<>();
    }

    @Override
    public void cargarArchivo(String nombreArchivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuarios.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Usuario usuario = null;
            Integer i = 0;
            for (Map.Entry<Integer, Usuario> entry : usuariosHashMap.entrySet()){
                objectOutputStream.writeObject(entry.getValue());
            }

            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Integer, Usuario> leerArchivo(String nombreArchivo) {
        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                Usuario usuario = (Usuario) objectInputStream.readObject();
                usuariosHashMap.put(usuario.getDni(), usuario);
            }
        }catch (EOFException e) {
            System.out.println("");

        } catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return usuariosHashMap;
    }

    @Override

    public boolean agregar(Usuario persona) {
        boolean rta = false;
        Usuario aux = buscar(persona.getDni());
        if (aux == null) {
            persona.setIdUsuario(contar());
            usuariosHashMap.put(persona.getDni(), persona);
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
    public Usuario buscar(int dni) {
        Usuario encontrada = null;
        if (usuariosHashMap.containsKey(dni)){
            encontrada = usuariosHashMap.get(dni);
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

    //SETTERS--------------------------------------------------------

    public void setUsuariosHashMap(HashMap<Integer, Usuario> usuariosHashMap) {
        this.usuariosHashMap = usuariosHashMap;
    }
}
