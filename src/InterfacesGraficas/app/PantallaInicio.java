package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaInicio extends JFrame implements ActionListener {
    private JLabel label1, label2, label3; //Etiquetas
    private JButton cerrar, registro, login;

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

        registro = new JButton("Registrarse");
        registro.setBounds(50, 150, 120, 30);
        add(registro);
        registro.addActionListener(this);

        login = new JButton("Login");
        login.setBounds(200, 150, 100, 30);
        add(login);
        login.addActionListener(this);

        cerrar = new JButton("Cerrar");
        cerrar.setBounds(250, 250, 100, 30);
        add(cerrar);
        cerrar.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Aca se crea el evento (donde se almacena)
        if (e.getSource() == cerrar)
        {
            System.exit(0);
        }
        if (e.getSource() == registro)
        {
            JOptionPane.showMessageDialog(null, "Usted va a ser enviado al apartado de registro");

            PaginaRegistro paginaRegistro = new PaginaRegistro();
            paginaRegistro.setBounds(0,0,600,600);
            paginaRegistro.setVisible(true);
            paginaRegistro.setLocationRelativeTo(null);
            paginaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paginaRegistro.setResizable(false);
            this.setVisible(false);
        } else if (e.getSource() == login)
        {
            JOptionPane.showMessageDialog(null, "Usted va a ser enviado al apartado de Login");
            PaginaLogin paginaLogin = new PaginaLogin();
            paginaLogin.setBounds(0,0,600,600);
            paginaLogin.setVisible(true);
            paginaLogin.setLocationRelativeTo(null);
            paginaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paginaLogin.setResizable(false);
            this.setVisible(false);
        }
    }
}
