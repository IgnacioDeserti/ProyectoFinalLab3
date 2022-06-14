package Excepciones;

public class EliminarProductoExcepcion extends Exception{

    public EliminarProductoExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
