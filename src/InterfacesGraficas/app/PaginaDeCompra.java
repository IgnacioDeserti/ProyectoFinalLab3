package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class PaginaDeCompra extends JFrame implements ActionListener{
    private JLabel label5, derechos;
    private JButton cerrar, aceptar, volver, seccionComida, seccionBebidas, seccionTecnologia;

    public PaginaDeCompra(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        setTitle("Apartado de compras");
        getContentPane().setBackground(new Color(248, 248, 248, 255));
        ImageIcon imageIcon = new ImageIcon("src\\images\\ImagenDeFondo.png");
        label5 = new JLabel(imageIcon);
        label5.setBounds(0,10,590,145);
        add(label5);

        derechos = new JLabel("Copyright 2021 ©Carrefour. Todos los derechos reservados.");
        derechos.setBounds(155, 500, 300, 30);
        derechos.setFont(new Font("SUB SCRIPT", 1, 10));
        add(derechos);

        seccionComida = new JButton("Seccion Comida");
        seccionComida.setBounds(20, 250, 145, 40);
        add(seccionComida);
        seccionComida.addActionListener(this); //se le va a agregar un evento, esperando un click

        seccionBebidas = new JButton("Seccion Bebidas");
        seccionBebidas.setBounds(220, 250, 140, 40);
        add(seccionBebidas);
        seccionBebidas.addActionListener(this); //se le va a agregar un evento, esperando un click

        seccionTecnologia = new JButton("Seccion Tecnologia");
        seccionTecnologia.setBounds(420, 250, 150, 40);
        add(seccionTecnologia);
        seccionTecnologia.addActionListener(this); //se le va a agregar un evento, esperando un click

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
        if (e.getSource() == seccionComida){
            PaginaComida paginaComida = new PaginaComida();
            paginaComida.setBounds(0, 0, 600, 600);
            paginaComida.setVisible(true); //Si queres que se vea true, si no false.
            paginaComida.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
            paginaComida.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.
            this.setVisible(false);

        }

    }
}
