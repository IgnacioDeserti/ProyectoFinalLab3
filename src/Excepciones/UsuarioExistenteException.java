package Excepciones;

public class UsuarioExistenteException extends Exception{

    public UsuarioExistenteException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
