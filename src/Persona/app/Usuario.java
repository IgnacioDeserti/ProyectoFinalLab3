package Persona.app;

public abstract class Usuario {
    private String nombreYapellido;
    private int dni;
    private String password;


    public Usuario(String nombreYapellido, int dni, String password) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.password = password;
    }

}
