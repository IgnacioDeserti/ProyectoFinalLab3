package Excepciones;

public class UsuarioExistente extends Exception{

    public UsuarioExistente(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
