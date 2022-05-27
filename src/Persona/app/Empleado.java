package Persona.app;

public class Empleado extends Usuario {
    private String departamento;


    public Empleado(String nombreYapellido, int dni, String password, String departamento) {
        super(nombreYapellido, dni, password);
        this.departamento = departamento;
    }
}
