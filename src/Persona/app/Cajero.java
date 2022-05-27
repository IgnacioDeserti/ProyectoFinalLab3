package Persona.app;

public class Cajero extends Empleado implements I_MetodosPersona{

    public Cajero(String nombreYapellido, int dni, String departamento) {
        super(nombreYapellido, dni, departamento);
    }


    @Override
    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return null;
    }
}
