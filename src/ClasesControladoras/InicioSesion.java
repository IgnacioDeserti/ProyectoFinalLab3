package ClasesControladoras;

import Colecciones.ColeccionUsuario;
import Excepciones.PasswordIncorrecto;
import Excepciones.PasswordInvalido;
import Excepciones.UsuarioExistente;
import Excepciones.UsuarioIncorrecto;
import Usuario.app.Admin;
import Usuario.app.Cliente;
import Usuario.app.Usuario;

import java.util.Scanner;


public class InicioSesion {

    static Scanner teclado;

    public void menuInicioSesion(){
        int opcion;
            System.out.println("Bienvenido a carrefour!!" +
                    "Ingrese 1 para registrarse" +
                    "Ingrese 2 para iniciar sesion" +
                    "Ingrese 0 para cerrar el programa");
            opcion = teclado.nextInt();

            do {
                switch(opcion)
                {
                    case 1 -> {
                        Usuario usuario = registro();
                        ejecutoMenuAdecuado(usuario);
                    }

                    case 2 -> {
                        Usuario usuario = login();
                        ejecutoMenuAdecuado(usuario);
                    }


                }
            }while (opcion != 0);
    }

    public int verificoDniLogin() throws UsuarioIncorrecto {
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
        System.out.println("Ingrese su dni");
        int dni = teclado.nextInt();
        if (coleccionUsuario.buscar(dni) == null){
            throw new UsuarioIncorrecto("No hay un usuario registrado con ese dni");
        }

        return dni;
    }

    public Usuario verificoPasswordLogin(int dni) throws PasswordIncorrecto {
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
        Usuario usuario = coleccionUsuario.buscar(dni);
        System.out.println("Ingrese password");
        String password = teclado.nextLine();
        if (usuario.getPassword() != password) {
            throw new PasswordIncorrecto("Password incorrecto");
        }
        else {
            System.out.println("Credenciales correctas" +
                    "Iniciando sesion...");
            try {
                wait(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        return usuario;
    }

    public Usuario login(){
        int dni = 0;
        Usuario usuario = null;
        try {
            dni = verificoDniLogin();
            usuario = verificoPasswordLogin(dni);
        } catch (UsuarioIncorrecto e) {
            System.out.println(e.getMessage());
            login();
        } catch (PasswordIncorrecto e) {
            System.out.println(e.getMessage());
            login();
        }

        return usuario;
    }

    public void ejecutoMenuAdecuado(Usuario usuario){
        if (usuario instanceof Admin){
            ControlMenuAdmin controlMenuAdmin = new ControlMenuAdmin((Admin) usuario);
            controlMenuAdmin.menuGralAdmin();
        }else {
            ControlMenuCliente controlMenuCliente = new ControlMenuCliente((Cliente) usuario);
            controlMenuCliente.menuCliente();
        }
    }

    public int verificoDniRegistro() throws UsuarioExistente {
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
        System.out.println("Ingrese su dni");
        int dni = teclado.nextInt();
        if (coleccionUsuario.buscar(dni) != null){
            throw new UsuarioExistente("Ya existe un usuario con ese dni");
        }

        return dni;
    }

    public void verificoPasswordRegistro(String password) throws PasswordInvalido {
        if (password.length() < 8){
            throw new PasswordInvalido("Password invalida, ingrese otra");
        }
    }

    public Cliente registro(){
        Cliente cliente = new Cliente();
        ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
        coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
        try {
            System.out.println("Ingrese su dni");
            int dni = verificoDniRegistro();
            System.out.println("Ingrese password");
            String password = teclado.nextLine();
            verificoPasswordRegistro(password);
            System.out.println("Ingrese su nombre y apellido");
            String nya = teclado.nextLine();
            cliente.setDni(dni);
            cliente.setPassword(password);
            cliente.setNombreYapellido(nya);
            coleccionUsuario.agregar(cliente);
        } catch (UsuarioExistente e) {
            System.out.println(e.getMessage());
            registro();
        } catch (PasswordInvalido e) {
            System.out.println(e.getMessage());
            registro();
        }

        return cliente;
    }

}
