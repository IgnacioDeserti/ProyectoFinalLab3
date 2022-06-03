package InterfacesGraficas.app;

import Persona.app.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaginaRegistro extends JFrame implements ActionListener {
    //private ArrayList<JLabel> listaUsuarios = new ArrayList<>();
    private JLabel label1, label2, label3, label4; //Etiquetas
    private JButton button, button1, button2, button3, button4;
    private JTextField textField1, textField2, textField3;

    public PaginaRegistro() {
        setLayout(null);
        label1 = new JLabel("Esta es la pantalla de registro de usuario");
        label1.setBounds(20,0,300,100);
        add(label1);

        label2 = new JLabel("Ingrese su nombre y apellido");
        label2.setBounds(100,40,300,100);
        add(label2);

        label3 = new JLabel("Ingrese su dni");
        label3.setBounds(100,90,300,100);
        add(label3);

        label4 = new JLabel("Ingrese su contraseña");
        label4.setBounds(100,140,300,100);
        add(label4);

        textField1 = new JTextField();
        textField1.setBounds(100, 110, 150, 20);
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(100, 160, 150, 20);
        add(textField2);

        textField3 = new JTextField();
        textField3.setBounds(100, 210, 150, 20);
        add(textField3);

        button2 = new JButton("Aceptar");
        button2.setBounds(50, 250, 100, 30);
        add(button2);
        button2.addActionListener(this);

        button = new JButton("Cerrar");
        button.setBounds(450, 500, 100, 30);
        add(button);
        button.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.exit(0);
        } else if (e.getSource() == button2)
        {
            /*Usuario listaUsuarios = new Usuario;
            listaUsuarios = Usuario.(textField1.getText());*/

        }
    }
}
