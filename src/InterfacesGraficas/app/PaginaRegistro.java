package InterfacesGraficas.app;

import Colecciones.ColeccionUsuario;
import Usuario.app.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class PaginaRegistro extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5; //Etiquetas
    private JButton cerrar, aceptar, volver;
    private JTextField nya, dni;
    private JPasswordField password;
    private JCheckBox mostrarContraseña;

    public PaginaRegistro() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        setTitle("Registro");
        getContentPane().setBackground(new Color(248, 248, 248, 255));
        ImageIcon imageIcon1 = new ImageIcon("src\\images\\CdeCarrefour.png");
        setIconImage(imageIcon1.getImage());

        ImageIcon imageIcon = new ImageIcon("src\\images\\ImagenDeFondo.png");
        label5 = new JLabel(imageIcon);
        label5.setBounds(0,10,590,145);
        add(label5);

        label1 = new JLabel("Bienvenido, registrese");
        label1.setBounds(20,115,300,100);
        add(label1);

        label2 = new JLabel("Ingrese su nombre y apellido");
        label2.setBounds(100,140,300,100);
        add(label2);

        label3 = new JLabel("Ingrese su dni");
        label3.setBounds(100,190,300,100);
        add(label3);

        label4 = new JLabel("Ingrese su contraseña");
        label4.setBounds(100,250,300,100);
        add(label4);

        nya = new JTextField();
        nya.setBounds(100, 210, 150, 20);
        add(nya);

        dni = new JTextField();
        dni.setBounds(100, 260, 150, 20);
        add(dni);

        password = new JPasswordField();
        password.setBounds(100, 310, 150, 20);
        add(password);

        mostrarContraseña = new JCheckBox("Mostrar Contraseña");
        mostrarContraseña.setBounds(160, 340, 150, 30);
        add(mostrarContraseña);
        mostrarContraseña.addActionListener(this);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(50, 350, 100, 30);
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
            pantallaInicio.setBounds(0,0,400,400);
            pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
            pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
            pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.
            pantallaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
        }
        if (e.getSource() == aceptar)
        {
            Usuario usuario = new Cliente();
            usuario.setNombreYapellido(nya.getText().trim());
            String docu = dni.getText();
            if (Objects.equals(usuario.getNombreYapellido(), ""))
            {
                JOptionPane.showMessageDialog(null, "Debe ingresar algun valor en el campo nombre y apellido");
            }else {
                if (docu.equals("")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar algun valor en el campo dni");
                }else {
                    int valor = validaInt(dni.getText());
                    usuario.setDni(valor);
                    usuario.setPassword(String.valueOf(password.getPassword()));
                }
                if (usuario.getDni() <= 0 && usuario.getDni() > 99999999) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un dni valido en este campo");
                } else if (Objects.equals(usuario.getPassword(), ""))
                {
                    JOptionPane.showMessageDialog(null, "Debe ingresar algun valor en el campo Contraseña");
                }
            }
            ColeccionUsuario coleccionUsuario = new ColeccionUsuario();
            coleccionUsuario.setUsuariosHashMap(coleccionUsuario.leerArchivo("usuarios.bin"));
            Usuario aux = null;
            aux = coleccionUsuario.buscar(usuario.getDni());
            if(aux == null){
                JOptionPane.showMessageDialog(null, "Usted a sido registrado correctamente");
                coleccionUsuario.agregar(usuario);
                coleccionUsuario.cargarArchivo("usuarios.bin");
            }else if (Objects.equals(usuario.getNombreYapellido(), "") && docu.equals("") && usuario.getDni() <= 0 && usuario.getDni() > 99999999 && Objects.equals(usuario.getPassword(), "")){
                JOptionPane.showMessageDialog(null, "Usuario ya creado, sera enviado al apartado login");
                PaginaLogin paginaLogin = new PaginaLogin();
                paginaLogin.setBounds(0,0,600,600);
                paginaLogin.setVisible(true);
                paginaLogin.setLocationRelativeTo(null);
                paginaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaLogin.setResizable(false);
                this.setVisible(false);
            }
        }
        if (mostrarContraseña.isSelected()){
            password.setEchoChar((char) 0);
        }else {
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
