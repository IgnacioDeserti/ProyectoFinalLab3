package Excepciones;

public class CantidadInvalidaExcepcion extends Exception{

    public CantidadInvalidaExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "No hay suficiente stock, ingrese una cantidad valida";
    }
}


