package Excepciones;

public class PasswordIncorrectoException extends Exception{

    public PasswordIncorrectoException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}


