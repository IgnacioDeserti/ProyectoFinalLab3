package Excepciones;

public class UsuarioIncorrecto extends Exception{

    private int cantidadDeIntentos;

    public UsuarioIncorrecto(String message, int cantidadDeIntentos) {
        super(message);
        this.cantidadDeIntentos = cantidadDeIntentos;
    }

    public int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Usuario y/o password incorrecta";
    }


}
