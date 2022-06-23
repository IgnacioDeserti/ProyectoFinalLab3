package ClasesControladoras;

import Colecciones.ColeccionFactura;
import Colecciones.Deposito;
import Excepciones.*;
import Factura.Factura;
import Producto.app.Bebida;
import Producto.app.Comida;
import Producto.app.Tecnologia;
import Usuario.app.Cliente;
import Producto.app.Producto;

import java.util.ArrayList;
import java.util.Scanner;


public class ControlMenuCliente {

   static Scanner teclado;
   private Cliente cliente;

   public ControlMenuCliente(Cliente cliente){
      this.cliente= cliente;
   }

   public void menuCliente (){
      teclado = new Scanner(System.in);
      int opc = 0;
      System.out.println("\nBienvenido " + cliente.getNombreYapellido());
      System.out.println("Usted se encuentra en nuestro Carrefour digital.\n");
         do {
            System.out.println("""
                    \nIngrese 1 para ver los productos disponibles
                    Ingrese 2 para realizar una compra
                    Ingrese 3 para ver sus anteriores compras, si es que tiene
                    Ingrese 0 para salir del menu""");
            opc = teclado.nextInt();

            switch (opc) {
               case 1: {
                  funcionVerProductos();
                  break;
               }

               case 2:{
                  llenoCarrito(0);
                  creoFactura();
                  modificoStock();
                  break;
               }

               case 3: {
                  mostrarFacturas();
                  break;
               }
               case 0:{
                  System.out.println("Hasta la proxima!!!");
               }

            }
         }while (opc!=0);

   }

   public int verProductos() throws ArchivoIncorrectoExcepcion{
      System.out.println("""
                            \n
                            Ingrese
                            1 para elegir el deposito de comida
                            2 para elegir el deposito de bebida
                            3 para elegir el deposito de tecnologia""");

      int op = teclado.nextInt();
      if (op > 3 || op < 0){
         throw new ArchivoIncorrectoExcepcion("");
      }

      return op;
   }

   public void funcionVerProductos() {
      int op = 0;
      try {
         op = verProductos();
         System.out.println(cliente.mostrarDeposito(op));
      } catch (ArchivoIncorrectoExcepcion e) {
         System.out.println(e.getMessage());
         funcionVerProductos();
      }
   }

   public Producto elijoProducto(){
      Producto producto = null;
      Deposito deposito = new Deposito();
      try {
         int op = verProductos();
         System.out.println(cliente.mostrarDeposito(op));
         System.out.println("Ingrese el id del producto que quiera agregar al carrito");
         int id = teclado.nextInt();
         producto = cliente.seleccionoProducto(id, cliente.elegirDeposito(op));
         System.out.println("Cuantas unidades desea llevar?");
         int cant = teclado.nextInt();
         producto = deposito.verificoStock(producto, cant);

      } catch (ArchivoIncorrectoExcepcion e) {
         System.out.println(e.getMessage());
         producto = elijoProducto();
      } catch (IdIncorrectoExcepcion e) {
         System.out.println(e.getMessage());
         producto = elijoProducto();
      } catch (CantidadInvalidaExcepcion e) {
         System.out.println(e.getMessage());
         producto = elijoProducto();
      }

      return producto;
   }

   public void llenoCarrito(int cantLlevada){
      char control = 's';
      while (control != 'n'){
         try {
            Producto producto = elijoProducto();
            System.out.println(producto.mostrar());
            cantLlevada = cliente.verificoCantidadLlevada(producto, cantLlevada);
            cliente.buscarEnElChanguito(producto);
            cliente.agregarAlCarro(producto);
            System.out.println("Producto agregado!");
            System.out.println("Desea agregar otro producto?");
         } catch (CantidadExcedidaExcepcion e) {
            System.out.println(e.getMessage());
            llenoCarrito(cantLlevada);
         } catch (ProductoExistenteExcepcion e) {
            System.out.println(e.getMessage());
            llenoCarrito(cantLlevada);
         }
         control = teclado.next().charAt(0);
      }
   }

   public float precioTotal(){
      float total1 = 0;
      float total2 = 0;
      float total3 = 0;
      for (Bebida bebida : cliente.getBebidas()) {
         total1 = total1 + bebida.getPrecio();
      }
      for (Comida comida : cliente.getComidas()){
         total2 = total2 + comida.getPrecio();
      }
      for (Tecnologia tecnologia : cliente.getTecnologias()){
         total3 = total3 + tecnologia.getPrecio();
      }

      return total1 + total2 + total3;
   }

   public void creoFactura(){
      ColeccionFactura coleccionFactura = new ColeccionFactura();
      Factura factura = new Factura(cliente, precioTotal());
      coleccionFactura.setFacturas(coleccionFactura.leerArchivo("factura.json"));
      coleccionFactura.agregar(factura);
      coleccionFactura.cargarArchivo("factura.json");
   }

   public void modificoStock(){
      Deposito deposito = new Deposito();
      deposito.guardoNuevosStockArchi(cliente);
   }

   public StringBuilder facturasCliente(){
      StringBuilder stringBuilder = new StringBuilder();
      ColeccionFactura coleccionFactura = new ColeccionFactura();
      coleccionFactura.setFacturas(coleccionFactura.leerArchivo("factura.json"));
      for (Factura factura : coleccionFactura.getFacturas()){
         if (factura.getComprador().getDni() == cliente.getDni()){
            stringBuilder.append(coleccionFactura.mostrar());
         }
      }

      return stringBuilder;
   }

   public void mostrarFacturas(){
      StringBuilder stringBuilder = facturasCliente();
      if (stringBuilder.isEmpty()){
         System.out.println("Usted no ha hecho compras");
      }
      else {
         System.out.println(stringBuilder.toString());
      }
   }

}
