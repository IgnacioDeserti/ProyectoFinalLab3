package Excepciones;

public class CodigoInvalidoException extends Exception{

    public CodigoInvalidoException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
