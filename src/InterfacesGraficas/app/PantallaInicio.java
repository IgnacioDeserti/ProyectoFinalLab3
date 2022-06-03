package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaInicio extends JFrame implements ActionListener {
    private JLabel label1, label2, label3; //Etiquetas
    private JButton button, button2, button3;


    public PantallaInicio() {
        setLayout(null);
        label1 = new JLabel("Buenas, esta es la pantalla de Inicio");
        label1.setBounds(20,5,300,100);
        add(label1);

        label2 = new JLabel("Eliga una opcion");
        label2.setBounds(100,50,300,100);
        add(label2);

        label3 = new JLabel("");
        label3.setBounds(100,70,300,100);
        add(label3);

        button = new JButton("Cerrar");
        button.setBounds(250, 250, 100, 30);
        add(button);
        button.addActionListener(this); //se le va a agregar un evento, esperando un click

        button2 = new JButton("Registrarse");
        button2.setBounds(50, 150, 120, 30);
        add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Login");
        button3.setBounds(200, 150, 100, 30);
        add(button3);
        button3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Aca se crea el evento (donde se almacena)
        if (e.getSource() == button)
        {
            System.exit(0);
        } else if (e.getSource() == button2)
        {
            label3.setText("Usted fue enviado al apartado de registro");
        } else if (e.getSource() == button3)
        {
            label3.setText("Usted se esta logueando");
        }
    }
}
