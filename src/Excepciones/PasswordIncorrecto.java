package Excepciones;

public class PasswordIncorrecto extends Exception{

    private int cantIntentos;

    public PasswordIncorrecto(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Error, password incorrecta, intente de nuevo" +
                "Cantidad de intentos: " + cantIntentos++;
    }
}


