package Producto.app;

import java.io.Serializable;

public class Tecnologia extends Producto implements Serializable {
    private boolean isElectrico; //Si es a corriente o bateria


    public Tecnologia(String nombreProduto, float precio, int stock, boolean isElectrico) {
        super(nombreProduto, precio, stock);
        this.isElectrico = isElectrico;
    }

    public Tecnologia(){

    }

    @Override
    public String toString() {
        return super.toString() +
                "Tecnologia{" +
                "isElectrico=" + isElectrico +
                '}';
    }

    @Override
    public String mostrar() {
        return super.mostrar()+
                "\nIs Electrico: " + isElectrico;
    }

    //SETTERS------------------------------------------------------------

    public void setElectrico(boolean electrico) {
        isElectrico = electrico;
    }

    //GETTERS------------------------------------------------------------


    public boolean isElectrico() {
        return isElectrico;
    }
}
