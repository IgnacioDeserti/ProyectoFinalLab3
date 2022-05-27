package Persona.app;

public abstract class Usuario {
    private String nombreYapellido;
    private int dni;

    public Usuario(String nombreYapellido, int dni) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
    }


}
