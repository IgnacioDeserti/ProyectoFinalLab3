package Excepciones;

public class ArchivoIncorrectoExcepcion extends Exception{

    private static final long serialVersionUID = 700L;

    public ArchivoIncorrectoExcepcion(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage() + "\nDeposito inexistente, ingrese uno valido";
    }
}
