package Persona.app;

import javax.swing.*;

public class Admin extends Empleado implements I_MetodosPersona{

    public Admin(String nombreYapellido, int dni, String departamento, String password) {
        super(nombreYapellido, dni, departamento);
    }


    @Override
    public boolean registro(Persona persona) {
        return false;
    }

    @Override
    public String listar() {
        return null;
    }
}
