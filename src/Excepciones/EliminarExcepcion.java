package Excepciones;

public class EliminarExcepcion extends Exception{

    public EliminarExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}


