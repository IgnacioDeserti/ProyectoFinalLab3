package Excepciones;

public class PasswordIncorrecto extends Exception{

    private int cantidadDeIntentos;

    public PasswordIncorrecto(String message, int cantidadDeIntentos) {
        super(message);
        this.cantidadDeIntentos = cantidadDeIntentos;
    }

    //GETTERS-------------------------------------------------


    public int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Error, password incorrecta, intente de nuevo" +
                "Cantidad de intentos" + getCantidadDeIntentos() + " de 3";
    }
}
