package Excepciones;

public class PasswordIncorrecto extends Exception{


    public PasswordIncorrecto(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Error, password incorrecta, intente de nuevo";
    }
}


