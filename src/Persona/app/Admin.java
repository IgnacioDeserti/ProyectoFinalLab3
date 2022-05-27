package Persona.app;

public class Admin extends Empleado implements I_MetodosPersona{

    public Admin(String nombreYapellido, int dni, String departamento, String password) {
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
