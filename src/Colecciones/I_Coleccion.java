package Colecciones;

public interface I_Coleccion<T>{

    int contar();
    boolean eliminar(int aux);
    boolean agregar(T aux);
    T buscar(int aux);
    String mostrar();
    void cargarArchivo(String nombreArchivo);
    Object leerArchivo(String nombreArchivo);

}
