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

import javax.swing.*;
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
               case 0:{
                  System.out.println("Hasta la proxima");
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
         //JOptionPane.showMessageDialog(null,e.getMessage());
         System.out.println(e.getMessage());
         llenoCarrito();
      } catch (IdIncorrectoExcepcion e) {
         //JOptionPane.showMessageDialog(null,e.getMessage());
         System.out.println(e.getMessage());
         llenoCarrito();
      } catch (CantidadInvalidaExcepcion e) {
         //JOptionPane.showMessageDialog(null,e.getMessage());
         System.out.println(e.getMessage());
         llenoCarrito();
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
            cliente.agregarAlCarro(producto);
         } catch (CantidadExcedidaExcepcion e) {
            //JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println(e.getMessage());
            llenoCarrito();
         } catch (ProductoExistenteExcepcion e) {
            //JOptionPane.showMessageDialog(null,e.getMessage());
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

   public ArrayList<Bebida> ajustoStockBebida(){
      for (int i = 0; i < cliente.getBebidas().size(); i++) {
         cliente.getBebidas().get(i).setStock(cliente.getBebidas().get(i).getStock() - cliente.getBebidas().get(i).getCantLlevada());
         cliente.getBebidas().get(i).setCantLlevada(0);
      }
      return cliente.getBebidas();
   }

   public ArrayList<Comida> ajustoStockComida(){
      for (int i = 0; i < cliente.getComidas().size(); i++) {
         cliente.getComidas().get(i).setStock(cliente.getComidas().get(i).getStock() - cliente.getComidas().get(i).getCantLlevada());
         cliente.getComidas().get(i).setCantLlevada(0);
      }
      return cliente.getComidas();
   }

   public ArrayList<Tecnologia> ajustoStockTecnologia(){
      for (int i = 0; i < cliente.getTecnologias().size(); i++) {
         cliente.getTecnologias().get(i).setStock(cliente.getTecnologias().get(i).getStock() - cliente.getTecnologias().get(i).getCantLlevada());
         cliente.getTecnologias().get(i).setCantLlevada(0);
      }
      return cliente.getTecnologias();
   }

   public void guardoNuevosStockArchi(){
      Deposito deposito = new Deposito();
      ColeccionFactura coleccionFactura = new ColeccionFactura();
      Factura factura = new Factura(cliente, precioTotal());
      System.out.println("Usted compro: \n" + factura.toString());
      //coleccionFactura.agregar(factura);
      //coleccionFactura.cargarArchivo("factura.json");
      cliente.setBebidas(ajustoStockBebida());
      cliente.setComidas(ajustoStockComida());
      cliente.setTecnologias(ajustoStockTecnologia());

      for (Bebida bebida : cliente.getBebidas()){
         deposito.modificoArchi("bebida.bin", bebida);
      }

      for (Comida comida : cliente.getComidas()){
         deposito.modificoArchi("comida.bin", comida);
      }

      for (Tecnologia tecnologia : cliente.getTecnologias()){
         deposito.modificoArchi("tecnologia.bin", tecnologia);
      }

   }

}
