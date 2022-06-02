package Persona.app;

import java.io.Serializable;

public class Empleado extends Usuario implements I_MetodosPersona, Serializable {
    private String departamento;


    public Empleado(String nombreYapellido, int dni, String password, String departamento) {
        super(nombreYapellido, dni, password);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nDepartamento: " + departamento;
    }

    @Override
    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return toString();
    }
}
