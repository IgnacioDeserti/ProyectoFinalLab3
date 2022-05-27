package Persona.app;

public class Empleado extends Usuario {
    private String departamento;


    public Empleado(String nombreYapellido, int dni, String departamento) {
        super(nombreYapellido, dni);
        this.departamento = departamento;

    }

}
