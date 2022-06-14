package Excepciones;

public class CantidadExcedidaExcepcion extends Exception{

    public CantidadExcedidaExcepcion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Has excedido la capacidad del changuito, por favor reselecione su producto con una cantidad valida";
    }


}
