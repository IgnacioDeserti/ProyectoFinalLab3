package Excepciones;

public class ArchivoIncorrectoExcepcion extends Exception{

    public ArchivoIncorrectoExcepcion(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage() + "\nDeposito inexistente, ingrese uno valido";
    }
}
