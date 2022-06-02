package Persona.app;

import java.io.Serializable;

public class Admin extends Empleado implements I_MetodosPersona, Serializable {

    private int codigoSecreto;

    public Admin(String nombreYapellido, int dni, String password, String departamento, int codigoSecreto) {
        super(nombreYapellido, dni, password, departamento);
        this.codigoSecreto = codigoSecreto;
    }

    @Override
    public boolean registro(Usuario usuario) {
        return false;
    }

    @Override
    public String listar() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nCodigo Secreto: " + codigoSecreto;
    }
}
