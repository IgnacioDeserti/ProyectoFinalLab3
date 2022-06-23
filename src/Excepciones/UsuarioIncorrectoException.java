package Excepciones;

public class UsuarioIncorrectoException extends Exception{

    private int cantidadDeIntentos;

    public UsuarioIncorrectoException(String message) {
        super(message);
    }

    public int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


}
