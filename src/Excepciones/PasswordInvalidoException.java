package Excepciones;

public class PasswordInvalidoException extends Exception{

    public PasswordInvalidoException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
