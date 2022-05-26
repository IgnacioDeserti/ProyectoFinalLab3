package Persona.app;

public class Empleado extends Persona{
    private String departamento;


    public Empleado(String nombreYapellido, int dni, String departamento) {
        super(nombreYapellido, dni);
        this.departamento = departamento;

    }
}
