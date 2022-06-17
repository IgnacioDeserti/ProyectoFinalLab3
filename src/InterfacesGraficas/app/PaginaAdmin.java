package InterfacesGraficas.app;

import Usuario.app.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaAdmin extends JFrame implements ActionListener {
    private JButton cerrar, volver, verProductos, agregar, eliminar, verUsuarios;

    public PaginaAdmin()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        setTitle("Administrador");
        getContentPane().setBackground(new Color(248, 248, 248, 255));

        verProductos = new JButton("Ver Productos");
        verProductos.setBounds(100, 40, 140, 50);
        add(verProductos);
        verProductos.addActionListener(this); //se le va a agregar un evento, esperando un click

        agregar = new JButton("Agregar Producto");
        agregar.setBounds(350, 40, 140, 50);
        add(agregar);
        agregar.addActionListener(this); //se le va a agregar un evento, esperando un click

        eliminar = new JButton("Eliminar Producto");
        eliminar.setBounds(100, 200, 140, 50);
        add(eliminar);
        eliminar.addActionListener(this); //se le va a agregar un evento, esperando un click

        verUsuarios = new JButton("Ver usuarios");
        verUsuarios.setBounds(350, 200, 140, 50);
        add(verUsuarios);
        verUsuarios.addActionListener(this); //se le va a agregar un evento, esperando un click

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
            PaginaLogin paginaLogin = new PaginaLogin();
            paginaLogin.setBounds(0,0,600,600);
            paginaLogin.setVisible(true);
            paginaLogin.setLocationRelativeTo(null);
            paginaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paginaLogin.setResizable(false);
            this.setVisible(false);
        }

        if (e.getSource() == verUsuarios){
            PaginaMostrarUsuario paginaMostrarUsuario = new PaginaMostrarUsuario();
            paginaMostrarUsuario.setBounds(0,0,600,600);
            paginaMostrarUsuario.setVisible(true);
            paginaMostrarUsuario.setLocationRelativeTo(null);
            paginaMostrarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paginaMostrarUsuario.setResizable(false);
            this.setVisible(false);
        }

    }
}
