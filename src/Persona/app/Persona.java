package Persona.app;

public abstract class Persona {
    private String nombreYapellido;
    private int dni;

    public Persona(String nombreYapellido, int dni) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
    }
}
