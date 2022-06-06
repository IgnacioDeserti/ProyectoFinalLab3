package Persona.app;

import java.io.*;

public abstract class Usuario extends Exception implements Serializable {
    private String nombreYapellido;
    private int dni;
    private String password;


    public Usuario(String nombreYapellido, int dni, String password) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.password = password;
    }

    public String toString() {
        return "\n\nNombre y Apellido: " + this.nombreYapellido + "\nDNI: " + this.dni;
    }

    public int getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(int dni, String password) {
        if (dni == getDni() && password == getPassword()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = nombreYapellido != null ? nombreYapellido.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Usuario login(int dni, String password){
        int flag = 0;
        Usuario usuario = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (flag == 0 && (usuario = (Usuario) objectInputStream.readObject()) != null) {
                if (usuario.equals(dni, password)){
                    flag = 1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return usuario;
    }


}
