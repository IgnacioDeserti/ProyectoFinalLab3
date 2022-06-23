package Excepciones;

public class DniInvalidoExcepcion extends Exception{

    public DniInvalidoExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
