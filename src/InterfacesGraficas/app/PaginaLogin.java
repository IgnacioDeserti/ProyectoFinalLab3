package InterfacesGraficas.app;

import Persona.app.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaginaLogin extends JFrame implements ActionListener{
    private JLabel label1, label2, label3, label5; //Etiquetas
    private JButton cerrar, aceptar, volver;
    private JTextField nya, dni;
    public static Usuario usuario;

    public PaginaLogin() {
        setLayout(null);

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

        nya = new JTextField();
        nya.setBounds(100, 210, 150, 20);
        add(nya);

        dni = new JTextField();
        dni.setBounds(100, 260, 150, 20);
        add(dni);

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
            pantallaInicio.setBounds(0,0,400,400);
            pantallaInicio.setVisible(true); //Si queres que se vea true, si no false.
            pantallaInicio.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
            pantallaInicio.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.
            this.setVisible(false);
        }
    }
}
