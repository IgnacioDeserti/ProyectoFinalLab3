package Persona.app;

import javax.swing.*;

public class Admin extends Empleado implements I_MetodosPersona{
    private String password;

    public Admin(String nombreYapellido, int dni, String departamento, String password) {
        super(nombreYapellido, dni, departamento);
        this.password = password;
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
