package Excepciones;

public class UsuarioIncorrecto extends Exception{

    private int cantidadDeIntentos;

    public UsuarioIncorrecto(String message) {
        super(message);
    }

    public int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Usuario y/o password incorrecta" +
                "Cantidad de intentos: " + cantidadDeIntentos++;
    }


}
