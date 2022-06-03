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

    public int getDni() {
        return dni;
    }
}
