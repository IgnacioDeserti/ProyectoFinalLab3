package InterfacesGraficas.app;

import Usuario.app.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaMostrarUsuario extends JFrame implements ActionListener {
    private JScrollPane panel;
    private JTextArea listaUsuarios;
    private JButton cerrar, volver;
    Admin admin = new Admin();

    public PaginaMostrarUsuario(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        setTitle("Usuarios");
        getContentPane().setBackground(new Color(248, 248, 248, 255));

        listaUsuarios = new JTextArea();
        System.out.println(admin.verUsuarios());
        String listaUsuario = "";
        listaUsuario += admin.verUsuarios();
        listaUsuarios.append(listaUsuario);

        panel = new JScrollPane(listaUsuarios);
        panel.setBounds(15,0,550,500);
        add(panel);

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
            PaginaAdmin paginaAdmin = new PaginaAdmin();
            paginaAdmin.setBounds(0,0,600,600);
            paginaAdmin.setVisible(true);
            paginaAdmin.setLocationRelativeTo(null);
            paginaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paginaAdmin.setResizable(false);
            this.setVisible(false);
        }
    }
}
