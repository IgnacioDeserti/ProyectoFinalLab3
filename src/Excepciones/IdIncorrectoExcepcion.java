package Excepciones;

import java.lang.reflect.Executable;

public class IdIncorrectoExcepcion extends Exception {

    public IdIncorrectoExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "No hay producto con este ID";
    }
}


