package InterfacesGraficas.app;

import Colecciones.ColeccionUsuario;
import Usuario.app.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class PaginaLogin extends JFrame implements ActionListener{
    private JLabel label1, label2, label3, label5; //Etiquetas
    private JButton cerrar, aceptar, volver;
    private JTextField dni;
    private JPasswordField password;
    private JCheckBox mostrarContraseña;
    public static Usuario usuario;

    public PaginaLogin() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        setTitle("Login");
        getContentPane().setBackground(new Color(248, 248, 248, 255));
        ImageIcon imageIcon1 = new ImageIcon("src\\images\\CdeCarrefour.png");
        setIconImage(imageIcon1.getImage());

        ImageIcon imageIcon = new ImageIcon("src\\images\\ImagenDeFondo.png");
        label5 = new JLabel(imageIcon);
        label5.setBounds(0,10,590,145);
        add(label5);

        label1 = new JLabel("Bienvenido, haga su login");
        label1.setBounds(20,115,300,100);
        add(label1);

        label2 = new JLabel("Ingrese su dni");
        label2.setBounds(100,140,300,100);
        add(label2);

        label3 = new JLabel("Ingrese su contraseña");
        label3.setBounds(100,190,300,100);
        add(label3);

        dni = new JTextField();
        dni.setBounds(100, 210, 150, 20);
        add(dni);

        password = new JPasswordField();
        password.setBounds(100, 260, 150, 20);
        add(password);

        mostrarContraseña = new JCheckBox("Mostrar Contraseña");
        mostrarContraseña.setBounds(170, 285, 150, 30);
        add(mostrarContraseña);
        mostrarContraseña.addActionListener(this);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(50, 300, 100, 30);
        add(aceptar);
        aceptar.addActionListener(this);

        cerrar = new JButton("Cerrar");
        cerrar.setBounds(450, 500, 100, 30);
        add(cerrar);
        cerrar.addActionListener(this); //se le va a agregar un evento, esperando un click

        volver = new JButton("Volver");
        volver.setBounds(50, 500, 100, 30);
        add(volver);
        volver.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrar) {
            System.exit(0);
        }
        if (e.getSource() == volver) {
            PantallaInicio pantallaInicio = new PantallaInicio();
            pantallaInicio.setBounds(0, 0, 400, 400);
            pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
            pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
            pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.
            this.setVisible(false);
        }
        if (e.getSource() == aceptar) {
            Usuario usuario = new Usuario();
            String docu = dni.getText();
            int valor = validaInt(dni.getText());

            if (docu.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar algun valor en el campo dni");
            } else if (valor <= 0 && valor > 99999999) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un dni valido en este campo");
            } else {
                usuario.setDni(valor);
            }
            usuario.setPassword(String.valueOf(password.getPassword()));
            if (Objects.equals(usuario.getPassword(), "")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar algun valor en el campo Contraseña");
            }
            ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
            coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
            Usuario aux = null;
            aux = coleccionUsuario.buscar(usuario.getDni());
            if (aux == null && !Objects.equals(usuario.getPassword(), "")) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado, sera enviado al apartado de registro");
                PaginaRegistro paginaRegistro = new PaginaRegistro();
                paginaRegistro.setBounds(0, 0, 600, 600);
                paginaRegistro.setVisible(true);
                paginaRegistro.setLocationRelativeTo(null);
                paginaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaRegistro.setResizable(false);
                this.setVisible(false);
            } else if (aux.getDni() == 1 && Objects.equals(aux.getPassword(), "SoyDiosnel10")) {
                JOptionPane.showMessageDialog(null, "Usted a ingresado como administrador");
                PaginaAdmin paginaAdmin = new PaginaAdmin();
                paginaAdmin.setBounds(0, 0, 600, 600);
                paginaAdmin.setVisible(true);
                paginaAdmin.setLocationRelativeTo(null);
                paginaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaAdmin.setResizable(false);
                this.setVisible(false);
            }
            if(aux != null && docu.equals("") && usuario.getDni() <= 0 && usuario.getDni() > 99999999 && Objects.equals(usuario.getPassword(), "")){
                JOptionPane.showMessageDialog(null, "Usted se a logueado correctamente");
            }
        }
            if (mostrarContraseña.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }

        public int validaInt(String number){
            int result = 0; //Valor default.
            try{
                if(number != null){
                    result = Integer.parseInt(number);
                }
            }catch(NumberFormatException nfe){
                //*No es numerico!
            }
            return result;
        }

}
