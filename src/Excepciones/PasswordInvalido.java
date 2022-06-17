package Excepciones;

public class PasswordInvalido extends Exception{

    public PasswordInvalido(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
