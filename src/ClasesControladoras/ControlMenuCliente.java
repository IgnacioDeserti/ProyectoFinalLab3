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
      System.out.println("Bienvenido " + cliente.getNombreYapellido());
      System.out.println("Usted se encuentra en nuestro Carrefour digital.\n");
         do {
            System.out.println("""
                    Ingrese 1 para ver los productos disponibles
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
                  llenoCarrito();
                  guardoNuevosStockArchi();
                  break;
               }

               case 3: {

                  break;
               }
               default: {
                  System.out.println("Ingreso una opcion incorrecta, vuelva a seleccionar un numero correcto");
               }
            }
         }while (opc!=0);
   }

   public int verProductos() throws ArchivoIncorrectoExcepcion{
      System.out.println("""
                            \n\n
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
      try {
         int op = verProductos();
         System.out.println(cliente.mostrarDeposito(op));
         System.out.println("Ingrese el id del producto que quiera agregar al carrito");
         int id = teclado.nextInt();
         producto = cliente.seleccionoProducto(id, cliente.elegirDeposito(op));
         System.out.println("Cuantas unidades desea llevar?");
         int cant = teclado.nextInt();
         verificoStock(producto, cant);
         producto.setCantLlevada(cant);

      } catch (ArchivoIncorrectoExcepcion e) {
         System.out.println(e.getMessage());
         elijoProducto();
      } catch (IdIncorrectoExcepcion e) {
         System.out.println(e.getMessage());
         elijoProducto();
      } catch (CantidadInvalidaExcepcion e) {
         System.out.println(e.getMessage());
         elijoProducto();
      }

      return producto;
   }

   public void llenoCarrito(){
      int cantLlevada = 0;
      char control = 's';
      do {
         try {
            Producto producto = elijoProducto();
            cantLlevada = verificoCantidadLlevada(producto, cantLlevada);
            cliente.buscarEnElChanguito(producto);
            cliente.agregarAlChanguito(producto);
         } catch (CantidadExcedidaExcepcion e) {
            System.out.println(e.getMessage());
            llenoCarrito();
         } catch (ProductoExistenteExcepcion e) {
            System.out.println(e.getMessage());
            llenoCarrito();
         }
         System.out.println("Desea agregar otro producto?");
         control = teclado.next().charAt(0);
      }while (control != 'n');
   }

   public void verificoStock(Producto producto, int cantidad) throws CantidadInvalidaExcepcion {
      if (cantidad > producto.getStock()){
         throw new CantidadInvalidaExcepcion("");
      }
   }

   public int verificoCantidadLlevada(Producto producto, int cantLlevada) throws CantidadExcedidaExcepcion {
      if (producto.getCantLlevada() + cantLlevada < cliente.getCapacidad()){
         cantLlevada = cantLlevada + producto.getCantLlevada();
      }
      else {
         throw new CantidadExcedidaExcepcion("");
      }

      return cantLlevada;
   }

   public float precioTotal(){
      float total = 0;
      ArrayList<Producto> changuito = cliente.getChanguito();
      for (Producto producto: changuito) {
         total = total + producto.getPrecio();
      }

      return total;
   }

   public ArrayList<Producto> ajustoStock(){
      for (int i = 0; i < cliente.getChanguito().size(); i++) {
         cliente.getChanguito().get(i).setStock(cliente.getChanguito().get(i).getStock() - cliente.getChanguito().get(i).getCantLlevada());
         cliente.getChanguito().get(i).setCantLlevada(0);
      }

      return cliente.getChanguito();
   }

   public void guardoNuevosStockArchi(){
      Deposito deposito = new Deposito();
      ColeccionFactura coleccionFactura = new ColeccionFactura();

      coleccionFactura.agregar(new Factura(cliente.getChanguito(), cliente, precioTotal()));
      coleccionFactura.cargarArchivo("factura.json");
      cliente.setChanguito(ajustoStock());

      for (Producto producto: cliente.getChanguito()) {
         if (producto instanceof Comida){
            modificoArchi("comida.bin", producto);
         }
         else if (producto instanceof Bebida){
            modificoArchi("bebida.bin", producto);
         }
         else{
            modificoArchi("tecnologia.bin", producto);
         }
      }

   }

   public void modificoArchi(String nombreArchivo, Producto producto){
      Deposito deposito = new Deposito();
      deposito.setProductoHashSet(deposito.leerArchivo(nombreArchivo));
      deposito.eliminar(producto.getId());
      deposito.agregar(producto);
      deposito.cargarArchivo(nombreArchivo);
   }

}
