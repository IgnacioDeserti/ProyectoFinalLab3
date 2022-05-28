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

    @Override
    public String toString() {
        return "\n\nUsuario:" +
                "\nNombre y Apellido: " + nombreYapellido+
                "\nDNI: " + dni;
    }
}
