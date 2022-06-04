package Persona.app;

import java.io.Serializable;

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

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public int getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
