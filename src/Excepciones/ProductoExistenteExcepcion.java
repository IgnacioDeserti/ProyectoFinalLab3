package Excepciones;

public class ProductoExistenteExcepcion extends Exception{

    public ProductoExistenteExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Este producto ya existe, ingrese uno nuevo ";
    }


}
